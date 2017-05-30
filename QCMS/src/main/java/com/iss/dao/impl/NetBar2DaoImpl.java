package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.iss.constants.DeployEnum;
import com.iss.constants.TableConstants;
import com.iss.dao.INetBar2JPADao;
import com.iss.entity.NetBar2Entity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.query.NetBarQuery;
import com.iss.util.DateUtil;
import com.iss.util.NumberUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

@Repository
public class NetBar2DaoImpl extends BaseJPADaoImpl<Object, Long> implements INetBar2JPADao{
	

	private String getQueryColumns(){
		String columnsStr=" id,main_id,netbar_name,netbar_state,district_code,reg_address,reg_address_detail,reg_fund,economic_type,"
				+"approval_num,approval_dept,approval_date,legal_name,busi_area,computer_num,ip,isdeleted,update_time,"
				+ "contact_name,contact_tel,"
				+"city_code,isdeployed,create_time,sync_time ,client_version ,server_version ";
		return columnsStr;
	}
	
	@Override
	public DataTables<NetBar2Entity> query(DataParam param) {
		int total=0;
		List<NetBar2Entity> data = new ArrayList<NetBar2Entity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
//		sql.append("select id,net_bar_name,business_reg_no,city_code,area_code,server_version,client_version,address_name,contact_name,contact_tel,client_total,outside_network,inside_network,server_mac,creator,create_time ")
//		.append("FROM t_net_bar WHERE status=1 ");
		sql.append("select "+getQueryColumns());
		sql.append(" from "+TableConstants.NETBAR2_TABLE);
		sql.append(" where isdeleted=0");
		
		StringBuffer where = new StringBuffer();
		Map<String, String> search = param.getSearch();
		if(search!=null){//搜索条件
			String value = search.get("value");
			if(StringUtils.isNotBlank(value)){
				where.append(" AND CONCAT_WS(id,netbar_name,approval_num,city_code,district_code,legal_name,contact_name,contact_tel) like :param");
				parameters.put("param", ("%"+value+"%"));
			}
		}
		sql.append(where);
		//记录总数
		total = findNativeCount(sql.toString(), parameters);//先统计总数，不需要orderby和limit
		sql.append(" ORDER BY ");
		if(param.getOrder()==null){
			sql.append("create_time desc");
		}else{
			Map<String, String> order = param.getOrder().get(0);
			int index = Integer.valueOf(order.get("column"));
			/*if(index < 2)
				sql.append("create_time desc");
			else
				sql.append(index+1).append(" "+order.get("dir"));*/
			String orderStr=this.getOrder(index);
			sql.append(orderStr).append(" "+order.get("dir"));
			
		}
		if(param.getLength()!=-1){//排除全部
			sql.append(" LIMIT :start, :length");
			parameters.put("start", param.getStart());
			parameters.put("length", param.getLength());
		}//row_number序号列
		//sql.insert(0, "SELECT @row_number\\:=CONVERT(@row_number +1, SIGNED) AS num, tb.* FROM(");
		//sql.append(") AS tb, (SELECT @row_number\\:=:start) AS t");//添加伪列必须带别名
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBar2Entity entity = this.obj2Entity(obj);
				data.add(entity);
			}
		}
		return new DataTables<NetBar2Entity>(param.getDraw(), total, total, data);
	}
	
	private String getOrder(Integer index){
		String order="create_time";
		switch (index) {
		case 0:
			order= "id";
			break;
		case 1:
			order= "id";
			break;
		case 2:
			order= "netbar_name";
			break;
		case 3:
			order= "approval_num";
			break;
		case 4:
			order= "CONVERT(reg_fund,SIGNED)";
			break;
		case 5:
			order= "CONVERT(busi_area,SIGNED) ";
			break;
		case 6:
			order= "contact_name";
			break;
		case 7:
			order= "contact_tel";
			break;
		case 8:
			order= "computer_num";
			break;
		case 9:
			order= "legal_name";
			break;
		case 10:
			order= "ip";
			break;
		case 11:
			order= "reg_address";
			break;
		case 12:
			order= "reg_address_detail";
			break;
		default:
			break;
		}
		return order;
	}
	
	private NetBar2Entity obj2Entity(Object[] obj){
		if(obj==null || obj.length==0)return null;
//		Object[] obj = (Object[]) object;
		NetBar2Entity entity = new NetBar2Entity();
		int col=0;
		entity.setId(Objects.toString(obj[col++], ""));
		entity.setMain_id(Objects.toString(obj[col++], ""));
		entity.setNetbar_name(Objects.toString(obj[col++], ""));
		entity.setNetbar_state(Objects.toString(obj[col++], ""));
		entity.setDistrict_code(Objects.toString(obj[col++], ""));
		entity.setReg_address(Objects.toString(obj[col++], ""));
		entity.setReg_address_detail(Objects.toString(obj[col++], ""));
		entity.setReg_fund(Objects.toString(obj[col++], ""));
		entity.setEconomic_type(Objects.toString(obj[col++], ""));
		entity.setApproval_num(Objects.toString(obj[col++], ""));
		entity.setApproval_dept(Objects.toString(obj[col++], ""));
		entity.setApproval_date(Objects.toString(obj[col++], ""));
		entity.setLegal_name(Objects.toString(obj[col++], ""));
		entity.setBusi_area(Objects.toString(obj[col++], ""));
		entity.setComputer_num(NumberUtil.toInteger(obj[col++]));
		entity.setIp(Objects.toString(obj[col++], ""));
		entity.setIsdeleted(NumberUtil.toInteger(obj[col++]));
		entity.setUpdate_time(Objects.toString(obj[col++], ""));
		entity.setContact_name(Objects.toString(obj[col++], ""));
		entity.setContact_tel(Objects.toString(obj[col++], ""));
		entity.setCity_code(Objects.toString(obj[col++], ""));
		entity.setIsdeployed(NumberUtil.toInteger(obj[col++]));
		entity.setCreate_time(Objects.toString(obj[col++], ""));
		entity.setSync_time(Objects.toString(obj[col++], ""));
		entity.setClient_version(Objects.toString(obj[col++], ""));
		entity.setServer_version(Objects.toString(obj[col++], ""));
		
		
		return entity;
	}
	
	@Override
	public NetBar2Entity findOne(String id){
		List<NetBar2Entity> data = new ArrayList<NetBar2Entity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR2_TABLE+" WHERE id= :id ");
		parameters.put("id", id);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBar2Entity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data.get(0);
	}
	
	@Override
	public NetBar2Entity findByMainId(String mainId) {
		// TODO Auto-generated method stub
		List<NetBar2Entity> data = new ArrayList<NetBar2Entity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR2_TABLE+" WHERE main_id= :id ");
		parameters.put("id", mainId);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBar2Entity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data.get(0);
	}
	
	

	@Override
	public List<NetBar2Entity> findByCityCode(String cityCode) {
		// TODO Auto-generated method stub
		List<NetBar2Entity> data = new ArrayList<NetBar2Entity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR2_TABLE+" WHERE city_code= :cityCode ");
		parameters.put("cityCode", cityCode);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBar2Entity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data;
	}

	@Override
	public List<NetBar2Entity> findByDistrictCode(String districtCode) {
		// TODO Auto-generated method stub
		List<NetBar2Entity> data = new ArrayList<NetBar2Entity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select "+getQueryColumns())
		.append(" FROM "+TableConstants.NETBAR2_TABLE+" WHERE district_code= :districtCode ");
		parameters.put("districtCode", districtCode);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBar2Entity entity=this.obj2Entity(obj);
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data;
	}

	@Override
	public int existBusinessRegNo(String business_reg_no){
		String sql = "select count(*) FROM "+TableConstants.NETBAR2_TABLE+" WHERE approval_num="+business_reg_no;
		return findNativeCount(sql);
	}
	

	@Override
	public int countNetBar(NetBarQuery query) {
		// TODO Auto-generated method stub
		String sql = "select count(*) FROM "+TableConstants.NETBAR2_TABLE;
		return findNativeCount(sql);
	}

	@Override
	public String queryMaxId(String district_code) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id from "+TableConstants.NETBAR2_TABLE);
		sql.append(" where district_code = :search ");
		sql.append("order by id desc");
		parameters.put("search", district_code);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		if(list == null || list.size() <= 0){
			return null;
		}
		return Objects.toString(list.get(0), "");
	}
	
	

	@Override
	public String queryMaxIdById(String idhead) {
		// TODO Auto-generated method stub
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select max(id) from "+TableConstants.NETBAR2_TABLE);
		sql.append(" where id like :search ");
//		sql.append("order by id desc");
		parameters.put("search", idhead+"%");
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		if(list == null || list.size() <= 0){
			return null;
		}
		return Objects.toString(list.get(0), "");
	}
	
	

	@Override
	public String queryMaxUpdateTime() {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer();
		sql.append("select max(update_time) from "+TableConstants.NETBAR2_TABLE);
		List<Object> list = findNativeQuery(sql.toString());
		if(list == null || list.size() <= 0){
			return null;
		}
		return Objects.toString(list.get(0), "");
	}

	@Override
	public List<StatAreaEntity> getStatAreas(String district_code, String rankno) {
		List<StatAreaEntity> data = new ArrayList<StatAreaEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select stat_date,online,offline,login from t_stat_area ");
		sql.append("where area_code= :area_code and rankno= :rankno ");
		sql.append("order by stat_date desc limit 7");
		parameters.put("area_code", district_code);
		parameters.put("rankno", rankno);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				StatAreaEntity entity = new StatAreaEntity();
				entity.setStat_date(DateUtil.toDate(obj[0]));
				entity.setOnline(NumberUtil.toLong(obj[1]));
				entity.setOffline(NumberUtil.toLong(obj[2]));
				entity.setLogin(NumberUtil.toLong(obj[3]));
				data.add(entity);
			}
		}
		return data;
	}

	@Override
	public List<StatNetBarEntity> getStatNetBars(String area_code) {
		List<StatNetBarEntity> data = new ArrayList<StatNetBarEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT stat_date, sum(`online`) as `online`, sum(offline) as offline, sum(valid) as valid FROM  "+TableConstants.STAT_NET_BAR);
		sql.append("WHERE area_code= :area_code ");
		sql.append("GROUP BY stat_date LIMIT 7");
		parameters.put("area_code", area_code);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				StatNetBarEntity entity = new StatNetBarEntity();
				entity.setStat_date(DateUtil.toDate(obj[0]));
				entity.setOnline(NumberUtil.toLong(obj[1]));
				entity.setOffline(NumberUtil.toLong(obj[2]));
				entity.setValid(NumberUtil.toLong(obj[3]));
				data.add(entity);
			}
		}
		return data;
	}
}