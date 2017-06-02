package com.iss.service.impl;

import gov.ccm.netbar.interfaceImp.deployInfo.NetbarDeployInfo;
import gov.ccm.netbar.interfaceImp.placeInfo.RelationshipNetbar;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.constants.SystemConstants;
import com.iss.dao.INetBar2Dao;
import com.iss.dao.INetBar2JPADao;
import com.iss.dao.INetBarDeployDao;
import com.iss.dao.INetBarDeployJPADao;
import com.iss.entity.NetBar2Entity;
import com.iss.entity.NetBarDeployEntity;
import com.iss.service.INetBarDeployService;
import com.iss.service.INetBarListService;
import com.iss.util.CommonUtil;
import com.iss.util.DateUtil;
import com.iss.util.PropertiesUtil;
import com.iss.util.WebServiceUtil;
import com.iss.vo.InterfaceConfig;
import com.iss.vo.NetBarPrintVo;

@Service
public class INetBarDeployServiceImpl implements INetBarDeployService {
	private Logger log=LoggerFactory.getLogger(INetBarDeployServiceImpl.class);
	@Autowired
	private INetBarDeployDao iNetBarDeployDao;
	@Autowired
	private INetBarDeployJPADao iNetBarDeployJPADao;
	@Autowired
	private INetBar2JPADao iNetBarJPADao;
	@Autowired
	private INetBar2Dao iNetBarDao;
	@Autowired
	private INetBarListService iNetBarListService;

	@Override
	public List<NetBarDeployEntity> queryDeploysByBarId(String barId,String isDeploy) {
		// TODO Auto-generated method stub
		if(CommonUtil.isEmpty(barId))return null;
		return this.iNetBarDeployJPADao.getDeploysByBarId(barId,isDeploy);
	}
	
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public String printNetBar(String barId) throws Exception {
		// TODO Auto-generated method stub
		try {
			if(CommonUtil.isEmpty(barId)){
				throw new Exception("上传网吧ID为空");
			}
			NetBar2Entity bar=this.iNetBarJPADao.findOne(barId);
			if(bar==null){
				throw new Exception("网吧ID["+barId+"]不存在");
			}
			bar.setIsdeployed(1);//已确认
			
			NetBarDeployEntity dinfo=new NetBarDeployEntity();
			NetBarPrintVo vo=iNetBarListService.queryNetbarPrintInfo(barId);
			dinfo.setNetbarCode(bar.getId());
			dinfo.setIs_deploy("1");//未确认
			dinfo.setDetectNum(String.valueOf(vo.getOnLineCount()+vo.getOffLineCount()));
			dinfo.setInstallNum(dinfo.getDetectNum());
			dinfo.setOnlineNum(String.valueOf(vo.getOnLineCount()));
			dinfo.setReportTime(vo.getUploadTime());
			this.iNetBarDeployDao.saveAndFlush(dinfo);
			
			this.iNetBarDao.saveAndFlush(bar);
			
			
			/*List<RelationshipNetbar> list=new ArrayList<RelationshipNetbar>();
			RelationshipNetbar b=new RelationshipNetbar();
			b.setNetbar_code(bar.getId());
			b.setMain_id(bar.getMain_id());
			b.setNetbar_name(bar.getNetbar_name());
			b.setDistrict_code(bar.getDistrict_code());
			b.setReg_address_detail(bar.getReg_address_detail());
			b.setLegalname(bar.getLegal_name());
			list.add(b);
			String uploadcurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_BARINFO_UPLOAD_URL);
			config.setUrl(uploadcurl);
			config.setMethod(SystemConstants.NETBAR_WEBSERVICE_BARINFO_UPLOAD_METHED);
			String resp=WebServiceUtil.netbarInfoUpload(loginKey,config, list);
			if(SystemConstants.WS_INTERFACE_RESPONSE_SUCC.equals(resp)){
				NetBarPrintVo vo=iNetBarListService.queryNetbarPrintInfo(barId);
				List<NetbarDeployInfo> dinfolist=new ArrayList<NetbarDeployInfo>();
				NetbarDeployInfo dinfo=new NetbarDeployInfo();
				dinfo.setNetbarCode(bar.getId());
				dinfo.setIs_deploy("0");
				dinfo.setDetectNum(String.valueOf(vo.getOnLineCount()+vo.getOffLineCount()));
				dinfo.setInstallNum(dinfo.getDetectNum());
				dinfo.setOnlineNum(String.valueOf(vo.getOnLineCount()));
				dinfo.setReportTime(vo.getUploadTime());
				dinfolist.add(dinfo);
				uploadcurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_BAR_DEPLOYINFO_UPLOAD_URL);
				config.setUrl(uploadcurl);
				config.setMethod(SystemConstants.NETBAR_WEBSERVICE_BAR_DEPLOYINFO_UPLOAD_METHED);
				resp=WebServiceUtil.netbarInfoDeploy(loginKey,config, dinfolist);
				if(SystemConstants.WS_INTERFACE_RESPONSE_SUCC.equals(resp)){
					this.iNetBarDao.saveAndFlush(bar);
					
					return resp;
				}else
					throw new Exception("上报网吧实施信息失败");
			}else{
				throw new Exception("上报网吧信息失败");
			}*/
			
			return null;
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			throw e;
		}
	
	}


	@Override
	public String uploadNetBarDeployInfos() throws Exception {
		// TODO Auto-generated method stub
		List<NetBarDeployEntity> deploylist= this.iNetBarDeployJPADao.getUnDeployInfos();
		if(CommonUtil.isEmpty(deploylist)){
			throw new Exception("无网吧实施信息需要上传");
		}
		
		String loginurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGIN_URL);
		String username=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGINNAME);
		String password=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_PASSWORD);
		InterfaceConfig config=new InterfaceConfig();
		config.setUrl(loginurl);
		config.setMethod(SystemConstants.NETBAR_WEBSERVICE_LOGIN_METHOD);
		config.setUsername(username);
		config.setPassword(password);
		String loginKey=WebServiceUtil.netBarSyncLogin(config);
		
		List<NetbarDeployInfo> dinfolist=new ArrayList<NetbarDeployInfo>();
		for(NetBarDeployEntity dep:deploylist){
			NetbarDeployInfo dinfo=new NetbarDeployInfo();
			dinfo.setNetbarCode(dep.getNetbarCode());
			dinfo.setIs_deploy("0");
			dinfo.setDetectNum(dep.getDetectNum());
			dinfo.setInstallNum(dep.getDetectNum());
			dinfo.setOnlineNum(dep.getOnlineNum());
			dinfo.setReportTime(dep.getReportTime());
			dinfolist.add(dinfo);
			dep.setIs_deploy("0");
			dep.setDeployTime(DateUtil.getDataString(DateUtil.datetimeFormat));
		}
		
		String uploadcurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_BAR_DEPLOYINFO_UPLOAD_URL);
		config.setUrl(uploadcurl);
		config.setMethod(SystemConstants.NETBAR_WEBSERVICE_BAR_DEPLOYINFO_UPLOAD_METHED);
		String resp=WebServiceUtil.netbarInfoDeploy(loginKey,config, dinfolist);
		if(SystemConstants.WS_INTERFACE_RESPONSE_SUCC.equals(resp)){
			for(NetBarDeployEntity dep:deploylist){
				this.iNetBarDeployDao.saveAndFlush(dep);
			}
//			this.iNetBarDao.saveAndFlush(bar);
			return resp;
		}else
			throw new Exception("上报网吧实施信息失败");
		
	}
	
	

}
