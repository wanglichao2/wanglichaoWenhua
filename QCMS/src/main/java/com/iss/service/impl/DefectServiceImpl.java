/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.ICommonDao;
import com.iss.dao.IDefectDao;
import com.iss.dao.IDefectJPADao;
import com.iss.entity.DefectEntity;
import com.iss.service.IDefectService;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理服务层
 */
@Service
public class DefectServiceImpl implements IDefectService{
	@Autowired
	private IDefectDao iDefectDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private IDefectJPADao iDefectJPADao;
	
	@Override
	public List<DefectEntity> load(){
		DataParam param = new DataParam();
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		return iDefectJPADao.query(param).getData();
	}
	
	@Override
	public DataTables<DefectEntity> load(DataParam param){
		return iDefectJPADao.query(param);
	}
	
	@Override
	@Transactional
	public DefectEntity save(DefectEntity entity){
		return iDefectDao.saveAndFlush(entity);
	}
	
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue, String suffix) {
		return iCommonDao.updateField(id, field, fieldValue, "t_qc_"+suffix);
	}
	
	@Override
	@Transactional
	public boolean delBatch(Long[] ids) {
		return iCommonDao.delBatch("t_qc_defect", ids);
	}
	
	@Override
	@Transactional
	public List<DefectEntity> save(List<DefectEntity> list){
		return iDefectDao.save(list);
	}
}
