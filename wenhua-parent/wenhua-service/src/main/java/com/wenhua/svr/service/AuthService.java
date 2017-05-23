package com.wenhua.svr.service;

import java.util.Date;
import java.util.List;

import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.FileInfo;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.PcInfo;
import com.wenhua.svr.domain.ServerInfo;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;

/**
 * 统一接口
 * @author zhuzhaohua
 *
 */
public interface AuthService {

	/**
	 * 检查客服端认证请求是否通过
	 * @param barAuthInfo
	 * @throws AuthBarNotExistException
	 * @throws AuthSignNotValidException
	 * @throws AuthBarNotValidException 
	 */
	public NetBar isAuth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException, AuthBarNotValidException;
	
	/**
	 * 根据网吧ID查询网吧
	 * @param barId
	 * @return
	 */
	public NetBar getNetBar(String barId);
	
	/**
	 * 获取网吧配置信息
	 * @param barId
	 * @return
	 * @throws AuthBarNotExistException
	 */
	public BarConfig getBarConfig(String barId) throws AuthBarNotExistException;
	
	/**
	 * 上报网吧服务器信息
	 * @param serverInfo
	 * @throws AuthBarNotExistException
	 */
	public void setServerInfo(ServerInfo serverInfo) throws AuthBarNotExistException;
	
	/**
	 * 更新网吧PC信息
	 * @param barId
	 * @param barPcInfoList
	 */
	public void updatePcInfoList(String barId, List<PcInfo> pcInfoList);
	
	/**
	 * 获取文件信息列表
	 * @param barId
	 * @param version
	 * @return
	 */
	public List<BarFileInfo> getBarFileInfoList(String barId);
	
	/**
	 * 
	 * @param barId
	 * @param version
	 * @return
	 */
	public List<BarFileBar> getBarFileBarList(String barId);
	
	/**
	 * 根据文件ID获取文件字节数组
	 * @param fileId
	 * @return
	 * @throws FileNotExistException 
	 * @throws SystemException 
	 */
	public FileInfo getFileById(int fileId) throws FileNotExistException, SystemException;
	
//	/**
//	 * 更新网吧软件版本信息
//	 * @param barId
//	 * @param serverVersion
//	 * @param clientVersion
//	 * @throws AuthBarNotExistException 
//	 */
//	public void updateVersion(String barId, String serverVersion, String clientVersion) throws AuthBarNotExistException;
	
	/**
	 * 查询所有地区代码
	 * @return
	 */
	public List<AreasCode> selectAllAreasCode();
	
	/**
	 * 查询指定 区 代码 区域中的网吧总数
	 * @param areaCode
	 * @return
	 */
	public int countNetBarByAreaCode(String areaCode);
	
	/**
	 * 查询指定 区 代码 区域中的网吧PC机总数
	 * @param areaCode
	 * @return
	 */
	public int countNetBarPcByAreaCode(String areaCode);
	
	/**
	 * 查询省内所有网吧PC数量
	 * @return
	 */
	public int countNetBarPcInProvince();
	
	/**
	 * 查询指定 市 代码 区域中的网吧总数
	 * @param areaCode
	 * @return
	 */
	public int countNetBarByCityCode(String cityCode);
	
	/**
	 * 查询指定 市 代码 区域中的网吧PC机总数
	 * @param areaCode
	 * @return
	 */
	public int countNetBarPcByCityCode(String cityCode);
	
	/**
	 * 查询所有省内网吧数量
	 * @return
	 */
	public int countNetBarInProvince();
	
	/**
	 * 查询指定时间 区域 的区域统计数据
	 * @param areaCode 区域代码  区 + 市
	 * @param statDate
	 * @return
	 */
	public StatArea getStatAreaById(String areaCode, Date statDate);
	
	/**
	 * 保存一条区域统计数据
	 * @param statArea
	 */
	public void saveStatArea(StatArea statArea);
	
	/**
	 * 更新一条区域统计数据
	 * @param statArea
	 */
	public void updateStatArea(StatArea statArea);
	
	/**
	 * 获取所有网吧信息
	 * @return
	 */
	public List<NetBar> getAllBar();
	
	/**
	 * 根据ID查询指定网吧统计记录
	 * @param barId
	 * @param statDate
	 * @return
	 */
	public StatNetBar getStatNetBarById(String barId, Date statDate);
	
	/**
	 * 保存网吧统计记录
	 * @param statNetBar
	 */
	public void saveStatNetBar(StatNetBar statNetBar);
	
	/**
	 * 更新网吧统计记录
	 * @param statNetBar
	 */
	public void updateStatNetBar(StatNetBar statNetBar);
	
	public List<String> getCityCodesByUserId(Long userId);
	public List<String> getDistrictCodeByUserId(Long userId,String cityCode);
	
}
