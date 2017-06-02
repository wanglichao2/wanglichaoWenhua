package com.iss.dao;

import java.util.List;

import com.iss.entity.NetBarDeployEntity;

public interface INetBarDeployJPADao {
	
	List<NetBarDeployEntity> getDeploysByBarId(String barId,String isDeploy);
	
	List<NetBarDeployEntity> getUnDeployInfos();
	
	

}
