package com.iss.service.impl;

import gov.ccm.netbar.interfaceImp.deployInfo.NetbarDeployInfo;
import gov.ccm.netbar.interfaceImp.placeInfo.RelationshipNetbar;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iss.constants.SystemConstants;
import com.iss.constants.TableConstants;
import com.iss.dao.ICommonDao;
import com.iss.dao.INetBar2Dao;
import com.iss.dao.INetBar2JPADao;
import com.iss.entity.NetBar2Entity;
import com.iss.query.NetBarQuery;
import com.iss.service.INetBar2Service;
import com.iss.service.INetBarListService;
import com.iss.util.CommonUtil;
import com.iss.util.DateUtil;
import com.iss.util.FileUtil;
import com.iss.util.NumberUtil;
import com.iss.util.PropertiesUtil;
import com.iss.util.StringUtil;
import com.iss.util.WebServiceUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;
import com.iss.vo.InterfaceConfig;
import com.iss.vo.NetBarBean;
import com.iss.vo.NetBarPrintVo;
import com.iss.vo.param.DeployInfo;

@Service
public class NetBar2ServiceImpl implements INetBar2Service {
	private Logger log=LoggerFactory.getLogger(NetBar2ServiceImpl.class);
	@Autowired
	private INetBar2Dao iNetBarDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private INetBar2JPADao iNetBarJPADao;
	@Autowired
	private INetBarListService iNetBarListService;
	
	@Override
	public List<NetBar2Entity> load(){
		DataParam param = new DataParam();
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		return iNetBarJPADao.query(param).getData();
//		return this.iNetBarDao.findAll();
	}
	
	@Override
	public List<NetBar2Entity> loadAsync() {
		// TODO Auto-generated method stub
		
		
		return null;
	}




	@Override
	public DataTables<NetBar2Entity> load(DataParam param){
		return iNetBarJPADao.query(param);
	}
	
	@Override
	public List<NetBar2Entity> queryByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		return this.iNetBarJPADao.findByCityCode(cityCode);
	}

	@Override
	public List<NetBar2Entity> queryByDistrictCode(String districtCode) {
		// TODO Auto-generated method stub
		return this.iNetBarJPADao.findByDistrictCode(districtCode);
	}

	@Override
	public boolean existBusinessRegNo(String business_reg_no){
		int count = iNetBarJPADao.existBusinessRegNo(business_reg_no);
		if(count > 0){
			return true;
		}
		return false;
	}
	
	@Override
	@Transactional
	public NetBar2Entity save(NetBar2Entity entity){
		if(StringUtil.isEmpty(entity.getId())){
			String addressCode = entity.getDistrict_code()+"9";
//			String maxId = iNetBarJPADao.queryMaxId(addressCode);
			String maxId=iNetBarJPADao.queryMaxIdById(addressCode);
			String id = addressCode + "001";
			if(CommonUtil.isNotEmpty(maxId)){
				id = String.valueOf(Long.parseLong(maxId) + 1);
			}
			entity.setId(id);
			return iNetBarDao.saveAndFlush(entity);
		}else{
			NetBar2Entity netbar = iNetBarJPADao.findOne(entity.getId());
			/*entity.setApproval_num(netbar.getApproval_num());
			entity.setNetbar_state(netbar.getNetbar_state());
			entity.setDistrict_code(netbar.getDistrict_code());*/
			
			/*entity.setAddress_name(netbar.getAddress_name());
			entity.setCity_code(netbar.getCity_code());
			entity.setArea_code(netbar.getArea_code());
			entity.setServer_version(netbar.getServer_version());
			entity.setClient_version(netbar.getClient_version());*/
			
			netbar.setContact_name(entity.getContact_name());
			netbar.setContact_tel(entity.getContact_tel());
			netbar.setComputer_num(entity.getComputer_num());
			return iNetBarDao.saveAndFlush(netbar);
		}
		
	}
	
	
	
	@Override
	public NetBar2Entity insert(NetBar2Entity ent) {
		// TODO Auto-generated method stub
		String curtime=DateUtil.getDate(DateUtil.datetimeformat_str);
		if(ent.getIsdeleted()==null)ent.setIsdeleted(0);
		if(ent.getIsdeployed()==null)ent.setIsdeployed(0);
		if(StringUtil.isEmpty(ent.getCreate_time()))ent.setCreate_time(curtime);
		if(StringUtil.isEmpty(ent.getSync_time()))ent.setSync_time(curtime);
		
		return this.iNetBarDao.saveAndFlush(ent);
	}

	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue) {
		return iCommonDao.updateField(id, field, fieldValue, TableConstants.NETBAR2_TABLE);
	}
	
	@Override
	@Transactional
	public boolean delBatch(Long[] ids) {
		return iCommonDao.delBatch(TableConstants.NETBAR2_TABLE, ids);
	}
	
	@Override
	@Transactional
	public void delAll() {
//		this.iNetBarDao.deleteAll();
		
		 iCommonDao.delTableData(TableConstants.NETBAR2_TABLE);
	}  
	
	@Override
	@Transactional
	public List<NetBar2Entity> save(List<NetBar2Entity> list){
		return iNetBarDao.save(list);
	}
	

	@Override
	public String queryMaxUpdateTime() {
		// TODO Auto-generated method stub
		return this.iNetBarJPADao.queryMaxUpdateTime();
	}

	@Override
	public String syncNetBarData(String code)throws Exception {
		// TODO Auto-generated method stub
		Gson gson=new Gson();
		String loginurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGIN_URL);
		String username=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGINNAME);
		String password=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_PASSWORD);
		InterfaceConfig config=new InterfaceConfig();
		config.setUrl(loginurl);
		config.setMethod(SystemConstants.NETBAR_WEBSERVICE_LOGIN_METHOD);
		config.setUsername(username);
		config.setPassword(password);
//		String loginKey=WebServiceUtil.netBarSyncLoginAxis2(config);
		String loginKey=WebServiceUtil.netBarSyncLogin(config);
		String syncurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_SYNC_DOWNLOAD_URL);
		config.setUrl(syncurl);
		config.setMethod(SystemConstants.NETBAR_WEBSERVICE_SYNC_DOWNLOAD_METHOD);
		String endtime="20160101000000";
		if(!"all".equals(code)){
			endtime=this.queryMaxUpdateTime();
		}
		if(StringUtil.isEmpty(endtime))
			endtime="20160101000000";
		//调用接口
		List<NetBarBean> list= WebServiceUtil.netBarSyncData(config,loginKey,endtime);
		if(list==null || list.size()==0){
			log.info("netbar data from webservice is null....");
		}else{
			log.info("netbar data from webservice size is "+list.size());
//			List<NetBar2Entity> nblist =this.changeBean2EntityList(list);
			NetBarBean[] t=gson.fromJson(gson.toJson(list), NetBarBean[].class);
			list=new ArrayList<NetBarBean>(Arrays.asList(t));
			List<NetBar2Entity> nblist =this.changeBean2EntityList(list);
			log.info("netbar data from change size is "+nblist.size());
			this.saveSync(nblist);
		}
		
//		this.save(list);
		
		return null;
	}
	
	private void saveSync(List<NetBar2Entity> nblist){
		if(nblist==null || nblist.isEmpty())return ;
		String filename=FileUtil.NETBAR_DATA_LOG_HEAD+DateUtil.getDate(DateUtil.datetimeformat_str_cn)+".log";
		String errorLog=FileUtil.NETBAR_DATA_LOG_HEAD+"错误信息"+DateUtil.getDate(DateUtil.datetimeformat_str_cn)+".log";
		String fileurl=PropertiesUtil.getLogUrl()+"log"+File.separator;
		Gson gson=new Gson();
		int total=this.iNetBarJPADao.countNetBar(new NetBarQuery());
		if(total==0){
			for(NetBar2Entity e:nblist){
				try {
					this.initId(e);
					this.insert(e);
				} catch (Exception e2) {
					// TODO: handle exception
					log.error("",e2);
					FileUtil.writeContent(fileurl,filename, gson.toJson(e));
				}
			}
		}else{
			for(NetBar2Entity e:nblist){
				try {
					NetBar2Entity dbe=this.iNetBarJPADao.findByMainId(e.getMain_id());
					if(dbe==null){
						this.initId(e);
						this.insert(e);
					}else{
						setDbData(e,dbe);
						this.save(dbe);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					log.error("",e2);
					FileUtil.writeContent(fileurl,filename, gson.toJson(e));
					FileUtil.writeContent(fileurl,errorLog, e2.getMessage());
				}
			}
		}
		
	}
	
	private void setDbData(NetBar2Entity e,NetBar2Entity dbe){
		dbe.setNetbar_name(e.getNetbar_name());
		dbe.setNetbar_state(e.getNetbar_state());
		dbe.setReg_address(e.getReg_address());
		dbe.setReg_address_detail(e.getReg_address_detail());
		dbe.setReg_fund(e.getReg_fund());
		dbe.setUpdate_time(e.getUpdate_time());
		dbe.setLegal_name(e.getLegal_name());
		dbe.setApproval_date(e.getApproval_date());
		dbe.setApproval_dept(e.getApproval_dept());
		dbe.setApproval_num(e.getApproval_num());
		dbe.setBusi_area(e.getBusi_area());
		dbe.setComputer_num(e.getComputer_num());
		dbe.setDistrict_code(e.getDistrict_code());
		dbe.setEconomic_type(e.getEconomic_type());
		dbe.setIp(e.getIp());
		dbe.setIsdeleted(e.getIsdeleted());
//		dbe.setClient_version(e.getClient_version());
//		dbe.setServer_version(e.getServer_version());
	}
	
	private void initId(NetBar2Entity e){
		String districtcode=e.getDistrict_code();
		String approvalnum=e.getApproval_num();
		String id=null;
		if(districtcode.substring(0, 4).equals(approvalnum.substring(0, 4))){
			id=districtcode+approvalnum.substring(approvalnum.length()-4);
			NetBar2Entity dbe= this.iNetBarJPADao.findOne(id);
			if(dbe!=null){
				id=getIdFromDb(districtcode);
			}
		}else{
			id=getIdFromDb(districtcode);
		}
		e.setId(id);
	}
	
	private String getIdFromDb(String districtcode){
		String id=null;
		String head=districtcode+"9";
		String maxId=this.iNetBarJPADao.queryMaxIdById(head);
		if(maxId==null || "".equals(maxId)){
			id=head+"001";
		}else{
			id=String.valueOf(Long.parseLong(maxId)+1);
		}
		return id;
	}
	
	private List<NetBar2Entity> changeBean2EntityList(List<NetBarBean> list){
		Collections.sort(list);
		List<NetBar2Entity> nblist=new ArrayList<NetBar2Entity>();
		Iterator<NetBarBean> it=list.iterator();
		while(it.hasNext()){
			NetBarBean b=it.next();
			NetBar2Entity e=new NetBar2Entity();
			this.copyBean2Entity(b, e);
			nblist.add(e);
			it.remove();
		}
		return nblist;
	}
	
	private void copyBean2Entity(NetBarBean b,NetBar2Entity e){
		e.setMain_id(b.getMainId());
		e.setNetbar_name(b.getNetbarName());
		e.setNetbar_state(b.getNetbarState());
		e.setReg_address(b.getRegAddress());
		e.setReg_address_detail(b.getRegAddressDetail());
		e.setReg_fund(b.getRegFund());
		e.setUpdate_time(b.getUpdateTime());
		e.setLegal_name(b.getLegalname());
		e.setApproval_date(b.getApprovalDate());
		e.setApproval_dept(b.getApprovalDept());
		e.setApproval_num(b.getApprovalNum());
		e.setBusi_area(b.getBusiArea());
		double num=NumberUtil.toDouble(StringUtil.isEmpty(b.getComputerNum(), "0"));
		e.setComputer_num((int)num);
		e.setDistrict_code(b.getDistrictCode());
		e.setEconomic_type(b.getEconomicType());
		e.setIp(b.getIp());
		e.setIsdeleted(NumberUtil.toInteger(b.getIsdeleted()));
		e.setCity_code(StringUtil.isEmpty(e.getDistrict_code())?"":e.getDistrict_code().substring(0,4)+"00");
		int head=Integer.valueOf(e.getDistrict_code().substring(0,4));
		if(head>=4189){
			e.setCity_code("418000");
		}
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
			bar.setIsdeployed(1);
			String loginurl=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGIN_URL);
			String username=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_LOGINNAME);
			String password=PropertiesUtil.getPropery(SystemConstants.NETBAR_WEBSERVICE_PASSWORD);
			InterfaceConfig config=new InterfaceConfig();
			config.setUrl(loginurl);
			config.setMethod(SystemConstants.NETBAR_WEBSERVICE_LOGIN_METHOD);
			config.setUsername(username);
			config.setPassword(password);
			String loginKey=WebServiceUtil.netBarSyncLogin(config);
			
			
			List<RelationshipNetbar> list=new ArrayList<RelationshipNetbar>();
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
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			throw e;
		}
	
	}

	
	
}