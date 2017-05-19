package com.iss.dao;

import java.util.List;

import com.iss.entity.NetBar2Entity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.query.NetBarQuery;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

public interface INetBar2JPADao {

	/**
	 * 查询缺陷Datatables表格数据
	 * @param param
	 * @return
	 */
	DataTables<NetBar2Entity> query(DataParam param);
	int countNetBar(NetBarQuery query);
	
	NetBar2Entity findOne(String id);
	NetBar2Entity findByMainId(String mainId);
	
	int existBusinessRegNo(String business_reg_no);
	
	String queryMaxId(String district_code);
	String queryMaxIdById(String id);
	
	String queryMaxUpdateTime();
	
	List<StatAreaEntity> getStatAreas(String area_code, String rankno);
	
	List<StatNetBarEntity> getStatNetBars(String area_code);
}
