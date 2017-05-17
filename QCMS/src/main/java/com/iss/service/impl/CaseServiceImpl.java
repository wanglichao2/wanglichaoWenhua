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
import com.iss.dao.ICaseDao;
import com.iss.dao.ICaseJPADao;
import com.iss.entity.CaseEntity;
import com.iss.service.ICaseService;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 用例管理服务层
 */
@Service
public class CaseServiceImpl implements ICaseService{
	@Autowired
	private ICaseDao iCaseDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private ICaseJPADao iCaseJPADao;
	
	@Override
	public List<CaseEntity> load(){
		DataParam param = new DataParam();
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		return iCaseJPADao.query(param).getData();
	}
	
	@Override
	public DataTables<CaseEntity> load(DataParam param){
		return iCaseJPADao.query(param);
	}
	
	@Override
	public List<CaseEntity> query(){
		return iCaseDao.findByStatusTrueOrderByCjrqDesc();
	}
	
	@Override
	@Transactional
	public CaseEntity save(CaseEntity entity){
		return iCaseDao.saveAndFlush(entity);
	}
	
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue, String suffix) {
		return iCommonDao.updateField(id, field, fieldValue, "t_qc_"+suffix);
	}
	
	@Override
	@Transactional
	public boolean delBatch(Long[] ids) {
		return iCommonDao.delBatch("t_qc_case", ids);
	}
	
	@Override
	@Transactional
	public List<CaseEntity> save(List<CaseEntity> list){
		return iCaseDao.save(list);
	}
}
