package com.iss.service;

import java.util.List;

import com.iss.entity.NetBarDeployEntity;

public interface INetBarDeployService {
	
	List<NetBarDeployEntity> queryDeploysByBarId(String barId,String isDeploy);
	String printNetBar(String barId)throws Exception;
	String uploadNetBarDeployInfos()throws Exception;
}
