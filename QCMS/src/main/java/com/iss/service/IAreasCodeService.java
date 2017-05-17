package com.iss.service;

import java.util.List;

import com.iss.entity.AreasEntity;

public interface IAreasCodeService {

	String getTreeAreas();

	List<AreasEntity> getTwolevelAreas(String areasid);

	List<AreasEntity> getThreelevelAreas(String areasid);
}
