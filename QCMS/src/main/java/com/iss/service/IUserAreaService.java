package com.iss.service;

import java.util.List;

import com.iss.entity.UserAreaEntity;

public interface IUserAreaService {
	
	 List<UserAreaEntity> queryUserAreas();
	
	 String[] queryUserAreaIds(Integer userId);
	 
	 

}
