package com.iss.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iss.constants.TableConstants;
import com.iss.dao.ICommonDao;
import com.iss.dao.INetBar2Dao;
import com.iss.dao.INetBar2JPADao;
import com.iss.entity.NetBar2Entity;
import com.iss.query.NetBarQuery;
import com.iss.service.INetBar2Service;
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

@Service
public class NetBar2ServiceImpl implements INetBar2Service {
	private Logger log=LoggerFactory.getLogger(NetBar2ServiceImpl.class);
	@Autowired
	private INetBar2Dao iNetBarDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private INetBar2JPADao iNetBarJPADao;
	
	@Override
	public List<NetBar2Entity> load(){
		DataParam param = new DataParam();
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		return iNetBarJPADao.query(param).getData();
	}
	
	@Override
	public DataTables<NetBar2Entity> load(DataParam param){
		return iNetBarJPADao.query(param);
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
			String addressCode = entity.getDistrict_code();
			String maxId = iNetBarJPADao.queryMaxId(addressCode);
			String id = addressCode + "0001";
			if(maxId != null){
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
//		if(ent.getIsdeployed()==null)ent.setIsdeployed(0);
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
		String loginurl=PropertiesUtil.getPropery("barSyncLoginUrl");
		String username=PropertiesUtil.getPropery("barSyncLoginName");
		String password=PropertiesUtil.getPropery("barSyncLoginPwd");
		InterfaceConfig config=new InterfaceConfig();
		config.setUrl(loginurl);
		config.setMethod("login");
		config.setUsername(username);
		config.setPassword(password);
//		String loginKey=WebServiceUtil.netBarSyncLoginAxis2(config);
		String loginKey=WebServiceUtil.netBarSyncLogin(config);
		String syncurl=PropertiesUtil.getPropery("barSyncDownLoadUrl");
		config.setUrl(syncurl);
		config.setMethod("downloadNetbarInfo");
		String endtime=this.queryMaxUpdateTime();
		if(StringUtil.isEmpty(endtime))
			endtime="20160101000000";
//			DateUtil.getDate(DateUtil.datetimeformat_str);
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
		
	}
}