package com.iss.dao;

import java.util.List;

import com.iss.entity.AreasEntity;

public interface IAreasCodeJPADao {
	
	/**
	 * 根据城市代码查询下级区县
	 * @param areasid
	 * @return
	 */
	List<AreasEntity> findByAreasId(String areasid, String rankno);
	
	List<AreasEntity> findAll();
}
