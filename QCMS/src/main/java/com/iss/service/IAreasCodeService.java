package com.iss.service;

import java.util.List;

import com.iss.entity.AreasEntity;
import com.iss.vo.DataParam;

public interface IAreasCodeService {

	String getTreeAreas(DataParam param);

	List<AreasEntity> getTwolevelAreas(String areasid);

	List<AreasEntity> getThreelevelAreas(String areasid);
	
	String getUserAreasTree(Long userId);
}
