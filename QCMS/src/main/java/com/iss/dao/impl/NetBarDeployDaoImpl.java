package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.iss.constants.TableConstants;
import com.iss.dao.INetBarDeployJPADao;
import com.iss.entity.NetBarDeployEntity;
import com.iss.util.CommonUtil;
import com.iss.util.NumberUtil;

@Repository
public class NetBarDeployDaoImpl extends BaseJPADaoImpl<Object, Long> implements
		INetBarDeployJPADao {
	
	private String getQueryColumns(){
		String columnsStr="  d.id,d.netbarCode,d.detectNum,d.installNum,d.is_deploy,d.onlineNum,d.reportTime ";
		return columnsStr;
	}

	@Override
	public List<NetBarDeployEntity> getDeploysByBarId(String barId,String isDeploy) {
		// TODO Auto-generated method stub
		List<NetBarDeployEntity> data = new ArrayList<NetBarDeployEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR_DEPLOY_TABLE+" d WHERE d.netbarCode= :netbarCode ");
		parameters.put("netbarCode", barId);
		if(CommonUtil.isNotEmpty(isDeploy)){
			sql.append(" and d.isDeploy= :isDeploy");
			parameters.put("isDeploy", isDeploy);
		}
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBarDeployEntity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data;
	}
	
	
	
	
	@Override
	public List<NetBarDeployEntity> getUnDeployInfos() {
		// TODO Auto-generated method stub
		List<NetBarDeployEntity> data = new ArrayList<NetBarDeployEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR_DEPLOY_TABLE+" d WHERE d.isDeploy= :isDeploy ");
		parameters.put("isDeploy", "1");
		
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBarDeployEntity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data;
	}

	private NetBarDeployEntity obj2Entity(Object[] obj){
		if(obj==null || obj.length==0)return null;
		NetBarDeployEntity entity = new NetBarDeployEntity();
		int col=0;
		entity.setId(NumberUtil.toLong(obj[col++]));
		entity.setNetbarCode(Objects.toString(obj[col++], ""));
		entity.setDetectNum(Objects.toString(obj[col++], ""));
		entity.setInstallNum(Objects.toString(obj[col++], ""));
		entity.setIs_deploy(Objects.toString(obj[col++], ""));
		entity.setOnlineNum(Objects.toString(obj[col++], ""));
		entity.setReportTime(Objects.toString(obj[col++], ""));
		
		return entity;
	}

}
