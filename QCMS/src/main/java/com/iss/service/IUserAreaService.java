package com.iss.service;

import java.util.List;

import com.iss.entity.UserAreaEntity;

public interface IUserAreaService {
	
	 List<UserAreaEntity> queryUserAreas();
	
	 String[] queryUserAreaIds(Long userId);
	 
	 String[] queryUserAreaCodes(Long[]userIds);
	 
	 String saveUserAreaIds(String[]areaCodes,Long[]userIds)throws Exception;
	 

}
