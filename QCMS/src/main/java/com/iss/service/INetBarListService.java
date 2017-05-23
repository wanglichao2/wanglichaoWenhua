package com.iss.service;

import java.util.List;

import com.iss.entity.AreasBarEntity;
import com.iss.entity.ProvinceCityBarEntity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.entity.UserEntity;
import com.iss.vo.DataParam;

public interface INetBarListService {

	List<ProvinceCityBarEntity> loadProvinceCityBar(UserEntity user);
	
	List<ProvinceCityBarEntity> loadProvinceCityBar(UserEntity user, DataParam param);
	
	List<AreasBarEntity> loadAreasBar(DataParam param);
	
	List<StatAreaEntity> getStatAreas(String area_code,String parentId);
	
	List<StatNetBarEntity> getStatNetBars(String area_code);
}
