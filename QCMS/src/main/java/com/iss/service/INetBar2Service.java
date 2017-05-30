package com.iss.service;

import java.util.List;

import com.iss.entity.NetBar2Entity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;
import com.iss.vo.NetBarPrintVo;

public interface INetBar2Service {
	
	/**
	 * 加载全部数据
	 * @return
	 */
	List<NetBar2Entity> load();
	List<NetBar2Entity> loadAsync();
	
	/**
	 * 加载分页数据
	 * @param param Datatables搜索、分页参数 
	 * @return
	 */
	DataTables<NetBar2Entity> load(DataParam param);
	List<NetBar2Entity> queryByCityCode(String cityCode);
	List<NetBar2Entity> queryByDistrictCode(String districtCode);
	
	/**
	 * 校验工商登记号是否存在
	 * @param business_reg_no
	 * @return
	 */
	boolean existBusinessRegNo(String business_reg_no);
	
	String syncNetBarData(String code)throws Exception;
	String printNetBar(String barId)throws Exception;
	/**
	 * 保存数据
	 * @param entity
	 * @return
	 */
	NetBar2Entity save(NetBar2Entity entity);
	
	NetBar2Entity insert(NetBar2Entity ent);
	
	/**
	 * 编辑数据
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue);
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	boolean delBatch(Long[] ids);
	
	/**
	 * 批量导入数据
	 * @param list
	 * @return
	 */
	List<NetBar2Entity> save(List<NetBar2Entity> list);
	
	String queryMaxUpdateTime();
	
}
