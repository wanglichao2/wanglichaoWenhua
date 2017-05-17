package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Repository;

import com.iss.dao.IFileBarJPADao;
import com.iss.entity.FileBarEntity;
import com.iss.util.NumberUtil;

@Repository
public class FileBarDaoImpl extends BaseJPADaoImpl<Object, Long> implements IFileBarJPADao{
	@Override
	public List<FileBarEntity> query(Long fileId){
		List<FileBarEntity> data = new ArrayList<FileBarEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,fileId,barId from t_file_bar where fileId= :fileId");
		parameters.put("fileId", fileId);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				FileBarEntity entity = new FileBarEntity();
				entity.setId(NumberUtil.toLong(obj[0]));
				entity.setFileId(NumberUtil.toLong(obj[1]));
				entity.setBarid(Objects.toString(obj[2], ""));
				data.add(entity);
			}
		}
		return data;
	}
	
	@Override
	public boolean delByFileId(Long fileId){
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sql = "delete from t_file_bar where fileId= :fileId";
		parameters.put("fileId", fileId);
		return executeNative(sql, parameters);
	}
}