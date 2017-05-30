package com.iss.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iss.entity.NetBar2Entity;
import com.iss.service.INetBar2Service;
import com.iss.thread.AbstractThread;
import com.iss.util.CommonUtil;

public class NetBarQueryThread extends AbstractThread {
	private Logger log=LoggerFactory.getLogger(NetBarQueryThread.class);
	
	private INetBar2Service iNetBar2Service;
	private List<NetBar2Entity> list;
	private String cityCode;
	
	public NetBarQueryThread(INetBar2Service iNetBar2Service,List<NetBar2Entity> list,String cityCode){
		this.iNetBar2Service=iNetBar2Service;
		this.list=list;
		this.cityCode=cityCode;
	}
	
	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		try {
			List<NetBar2Entity> result=this.iNetBar2Service.queryByCityCode(cityCode);
			if(CommonUtil.isNotEmpty(result))
				list.addAll(result);
			
		} catch (Exception e) {
			// TODO: handle exception
			log.error("");
		}
	}

}
