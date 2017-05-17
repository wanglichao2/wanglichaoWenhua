package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.iss.dao.IAreasCodeJPADao;
import com.iss.entity.AreasEntity;

@Repository
public class AreasCodeJPADaoImpl extends BaseJPADaoImpl<Object, Long>  implements IAreasCodeJPADao {

	@Override
	public List<AreasEntity> findByAreasId(String areasid, String rankno) {
		List<AreasEntity> data = new ArrayList<AreasEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select areasid, areasname from t_areas_code where rankno=").append(rankno);
		if(rankno.equals("3")){
			sql.append(" and areasid like :search");
			areasid = areasid.substring(0,4);
			parameters.put("search", ("%"+areasid+"%"));
		}
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				AreasEntity entity = new AreasEntity();
				entity.setAreasid(Objects.toString(obj[0], ""));
				entity.setAreasname(Objects.toString(obj[1], ""));
				data.add(entity);
			}
		}
		return data;
	}
	
	@Override
	public List<AreasEntity> findAll(){
		List<AreasEntity> data = new ArrayList<AreasEntity>();
		StringBuffer sql = new StringBuffer();
		sql.append("select areasid, areasname from t_areas_code where rankno=");
		return data;
	}
}