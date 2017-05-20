//package com.iss.dao;
//
//import java.util.List;
//
//import com.iss.entity.NetBarEntity;
//import com.iss.entity.StatAreaEntity;
//import com.iss.entity.StatNetBarEntity;
//import com.iss.vo.DataParam;
//import com.iss.vo.DataTables;
//
//public interface INetBarJPADao {
//
//	/**
//	 * 查询缺陷Datatables表格数据
//	 * @param param
//	 * @return
//	 */
//	DataTables<NetBarEntity> query(DataParam param);
//	
//	NetBarEntity findOne(String id);
//	
//	int existBusinessRegNo(String business_reg_no);
//	
//	String queryMaxId(String areasid);
//	
//	List<StatAreaEntity> getStatAreas(String area_code, String rankno);
//	
//	List<StatNetBarEntity> getStatNetBars(String area_code);
//}
