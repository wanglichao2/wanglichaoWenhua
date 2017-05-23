package com.wenhua.svr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.wenhua.svr.component.StatBarInstancerCacher;
import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.FileBarDao;
import com.wenhua.svr.dao.FileInfoDao;
import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.dao.PcInfoDao;
import com.wenhua.svr.dao.ServerInfoDao;
import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.dao.UserAreaDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.FileBar;
import com.wenhua.svr.domain.FileInfo;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.PcInfo;
import com.wenhua.svr.domain.ServerInfo;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.domain.base.BaseStatAreaKey;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.BarIdUtils;

public class AuthServiceImpl implements AuthService {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
	private NetBarDao netBarDao;
	
	private ServerInfoDao serverInfoDao;
	
	private PcInfoDao pcInfoDao;
	
	private FileBarDao fileBarDao;
	
	private FileInfoDao fileInfoDao;
	
	private AreasCodeDao areasCodeDao;
	
	private StatAreaDao statAreaDao;
	
	private StatNetBarDao statNetBarDao;
	private UserAreaDao userAreaDao;
	
	private String key = "hn123wh";
	/** 客户机上报信息频率 */
	private int freqInstantPcInfo = 60;

	@Override
	public NetBar isAuth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException, AuthBarNotValidException {
		if(null == barAuthInfo) throw new AuthBarNotExistException();

		if(!barAuthInfo.isValid(key)) {
			throw new AuthSignNotValidException();
		}
		
		NetBar netBar = netBarDao.selectByPrimaryKey(String.valueOf(barAuthInfo.getBarId()));
		if(null == netBar) {
			throw new AuthBarNotExistException();
		}
		if(!netBar.isValid()) {
			throw new AuthBarNotValidException();
		}
		return netBar;
	}

	@Override
	public BarConfig getBarConfig(String barId) throws AuthBarNotExistException {
		
		BarConfig config = new BarConfig();
		config.setFreqInstantPcInfo(this.getFreqInstantPcInfo());
		return config;
	}

	@Override
	public void setServerInfo(ServerInfo serverInfo) throws AuthBarNotExistException {
		if(null == serverInfo || null == serverInfo.getId()) return;
		
		NetBar bar = netBarDao.selectByPrimaryKey(serverInfo.getBarId());
		if(null == bar) {
			throw new AuthBarNotExistException();
		}

		ServerInfo target = serverInfoDao.selectByPrimaryKey(serverInfo.getId());
		if(null == target) {
			serverInfoDao.insert(serverInfo);
		} else {
			serverInfoDao.updateByPrimaryKey(serverInfo);
		}
		
		bar.setServerVersion(serverInfo.getWenhuaVer());
//		bar.setServerMac(serverInfo.getId());
		netBarDao.updateByPrimaryKey(bar);
		// 更新缓存网吧服务器相关信息
		StatBarInstancerCacher.addOrUpdate(bar);
	}

	@Override
	public void updatePcInfoList(String barId, List<PcInfo> pcInfoList) {
		if(null == pcInfoList || 0 == pcInfoList.size()) return;
		
		String clientVersion = null;
		for(PcInfo pi : pcInfoList) {
			PcInfo target = pcInfoDao.selectByPrimaryKey(pi.getId());
			if(null == target) {
				pcInfoDao.insert(pi);
			} else {
				pcInfoDao.updateByPrimaryKey(pi);
			}
			
			if(null == clientVersion) {
				clientVersion = pi.getWenhuaVer();
			}
		}
		
		NetBar netBar = netBarDao.selectByPrimaryKey(barId);
		if(null != netBar) {
			netBar.setClientVersion(clientVersion);
			netBarDao.updateByPrimaryKey(netBar);
			StatBarInstancerCacher.addOrUpdate(netBar);
		}
		
	}

	@Override
	public List<BarFileInfo> getBarFileInfoList(String barId) {
		
		List<FileInfo> files = fileInfoDao.selectBaseAll();
		if(null == files || 0 == files.size()) return Lists.newArrayList();
		
		List<BarFileInfo> list = Lists.newArrayList();
		
		for(FileInfo file : files) {
			BarFileInfo bfb1 = new BarFileInfo();
			Integer action = 0;
			try {
				action = Integer.parseInt(file.getAction());
			} catch (NumberFormatException e) {
				action = -1;
			}
			bfb1.setAction(action);
			
			bfb1.setApplyAllBar(file.isApplyAll());
			
			bfb1.setFileName(file.getFilename());
			int flag = 0;
			try {
				flag = Integer.parseInt(file.getFlag());
			} catch (NumberFormatException e) {
				flag = -1;
			}
			bfb1.setFlag(flag);
			int fileId = 0;
			try {
				fileId = Integer.parseInt(String.valueOf(file.getId()));
			} catch (NumberFormatException e) {
				fileId = -1;
			}
			bfb1.setId(fileId);
			bfb1.setMd5(file.getMd5());
			int type = 0;
			try {
				type = Integer.parseInt(file.getType());
			} catch (NumberFormatException e) {
				type = -1;
			}
			bfb1.setType(type);
			bfb1.setVersion(file.getVersion());
			
			list.add(bfb1);
		}
		return list;
	}

	@Override
	public List<BarFileBar> getBarFileBarList(String barId) {
		
		List<FileBar> fileBars = fileBarDao.selectAll();
		
		if(null == fileBars || 0 == fileBars.size()) return Lists.newArrayList();
		
		Map<Integer, BarFileBar> map = new HashMap<Integer, BarFileBar>();
		
		for(FileBar fileBar : fileBars) {
			BarFileBar bfb = map.get(Integer.parseInt(String.valueOf(fileBar.getFileid())));
			
			if(null == bfb) {
				bfb = new BarFileBar();
				bfb.setFileId(Integer.parseInt(String.valueOf(fileBar.getFileid())));
				List<String> barIds = Lists.newArrayList();
				barIds.add(fileBar.getBarid());
				bfb.setBarIdList(barIds);
				
				map.put(Integer.parseInt(String.valueOf(fileBar.getFileid())), bfb);
				
			} else {
				
				bfb.getBarIdList().add(fileBar.getBarid());
				
			}
			
		}
		
		List<BarFileBar> list = Lists.newArrayList();
		for(BarFileBar b : map.values()) {
			list.add(b);
		}
		
		return list;
	}

	@Override
	public FileInfo getFileById(int fileId) throws FileNotExistException, SystemException {
		
		FileInfo fileInfo = this.fileInfoDao.selectByPrimaryKey((long)fileId);
		
		if(null == fileInfo) {
			throw new FileNotExistException();
		}
		
		return fileInfo;
	}

	public NetBarDao getNetBarDao() {
		return netBarDao;
	}

	public void setNetBarDao(NetBarDao netBarDao) {
		this.netBarDao = netBarDao;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ServerInfoDao getServerInfoDao() {
		return serverInfoDao;
	}

	public void setServerInfoDao(ServerInfoDao serverInfoDao) {
		this.serverInfoDao = serverInfoDao;
	}

	public PcInfoDao getPcInfoDao() {
		return pcInfoDao;
	}

	public void setPcInfoDao(PcInfoDao pcInfoDao) {
		this.pcInfoDao = pcInfoDao;
	}

	public int getFreqInstantPcInfo() {
		return freqInstantPcInfo;
	}

	public void setFreqInstantPcInfo(int freqInstantPcInfo) {
		this.freqInstantPcInfo = freqInstantPcInfo;
	}

//	@Override
//	public void updateVersion(String barId, String serverVersion, String clientVersion) throws AuthBarNotExistException {
//		NetBar bar = netBarDao.selectByPrimaryKey(barId);
//		if(null == bar) {
//			throw new AuthBarNotExistException();
//		}
//		
//		bar.setClientVersion(clientVersion);
//		bar.setServerVersion(serverVersion);
//		
//		netBarDao.updateByPrimaryKey(bar);
//	}

	public FileBarDao getFileBarDao() {
		return fileBarDao;
	}

	public void setFileBarDao(FileBarDao fileBarDao) {
		this.fileBarDao = fileBarDao;
	}

	public FileInfoDao getFileInfoDao() {
		return fileInfoDao;
	}

	public void setFileInfoDao(FileInfoDao fileInfoDao) {
		this.fileInfoDao = fileInfoDao;
	}

	@Override
	public List<AreasCode> selectAllAreasCode() {
		return this.areasCodeDao.selectAll();
	}

	@Override
	public int countNetBarByAreaCode(String areaCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		return this.netBarDao.countAreaBar(params);
	}

	@Override
	public int countNetBarPcByAreaCode(String areaCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		return this.netBarDao.countAreaPc(params);
	}

	@Override
	public int countNetBarByCityCode(String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", cityCode);
		return this.netBarDao.countCityBar(params);
	}

	@Override
	public int countNetBarPcByCityCode(String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", cityCode);
		return this.netBarDao.countCityPc(params);
	}

	@Override
	public StatArea getStatAreaById(String areaCode, Date statDate) {
		return this.statAreaDao.selectByPrimaryKey(BaseStatAreaKey.newOne(areaCode, statDate));
	}

	@Override
	public void saveStatArea(StatArea statArea) {
		this.statAreaDao.insert(statArea);
	}

	@Override
	public void updateStatArea(StatArea statArea) {
		this.statAreaDao.updateByPrimaryKey(statArea);
	}

	@Override
	public List<NetBar> getAllBar() {
		return this.netBarDao.selectAll();
	}

	@Override
	public StatNetBar getStatNetBarById(String barId, Date statDate) {
		return this.statNetBarDao.selectByPrimaryKey(BaseStatNetBarKey.newOne(barId, statDate));
	}

	@Override
	public void saveStatNetBar(StatNetBar statNetBar) {
		this.statNetBarDao.insert(statNetBar);
	}

	@Override
	public void updateStatNetBar(StatNetBar statNetBar) {
		this.statNetBarDao.updateByPrimaryKey(statNetBar);
	}

	public AreasCodeDao getAreasCodeDao() {
		return areasCodeDao;
	}

	public void setAreasCodeDao(AreasCodeDao areasCodeDao) {
		this.areasCodeDao = areasCodeDao;
	}

	public StatAreaDao getStatAreaDao() {
		return statAreaDao;
	}

	public void setStatAreaDao(StatAreaDao statAreaDao) {
		this.statAreaDao = statAreaDao;
	}

	public StatNetBarDao getStatNetBarDao() {
		return statNetBarDao;
	}

	public void setStatNetBarDao(StatNetBarDao statNetBarDao) {
		this.statNetBarDao = statNetBarDao;
	}
	public UserAreaDao getUserAreaDao() {
		return userAreaDao;
	}

	public void setUserAreaDao(UserAreaDao userAreaDao) {
		this.userAreaDao = userAreaDao;
	}

	@Override
	public int countNetBarPcInProvince() {
		return this.netBarDao.countProvincePc();
	}

	@Override
	public int countNetBarInProvince() {
		return this.netBarDao.countProvinceBar();
	}

	@Override
	public NetBar getNetBar(String barId) {
		
		if(!BarIdUtils.isValid(barId)) {
			return null;
		}
		
		return netBarDao.selectByPrimaryKey(barId);
	}

	@Override
	public List<String> getCityCodesByUserId(Long userId) {
		// TODO Auto-generated method stub
		return this.userAreaDao.getCityCodesByUserId(userId);
	}

	@Override
	public List<String> getDistrictCodeByUserId(Long userId,String cityCode) {
		// TODO Auto-generated method stub
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("userId", userId);
		queryMap.put("cityCode", cityCode);
		return this.userAreaDao.getDistrictCodesByUserId(queryMap);
	}

	
}
