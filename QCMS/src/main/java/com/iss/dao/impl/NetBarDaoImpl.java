package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.iss.dao.INetBarJPADao;
import com.iss.entity.NetBarEntity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.util.DateUtil;
import com.iss.util.NumberUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

@Repository
public class NetBarDaoImpl extends BaseJPADaoImpl<Object, Long> implements INetBarJPADao{
	
	@Override
	public DataTables<NetBarEntity> query(DataParam param) {
		int total=0;
		List<NetBarEntity> data = new ArrayList<NetBarEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,net_bar_name,business_reg_no,city_code,area_code,server_version,client_version,address_name,contact_name,contact_tel,client_total,outside_network,inside_network,server_mac,creator,create_time ")
		.append("FROM t_net_bar WHERE status=1 ");
		StringBuffer where = new StringBuffer();
		Map<String, String> search = param.getSearch();
		if(search!=null){//搜索条件
			String value = search.get("value");
			if(StringUtils.isNotBlank(value)){
				where.append("AND CONCAT_WS(id,net_bar_name,business_reg_no,city_code,area_code,server_version,client_version,address_name,contact_name,contact_tel,client_total,outside_network,inside_network,server_mac) like :param");
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
			if(index < 2)
				sql.append("create_time desc");
			else
				sql.append(index+1).append(" "+order.get("dir"));
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
				NetBarEntity entity = new NetBarEntity();
				entity.setId(Objects.toString(obj[0], ""));
				entity.setNet_bar_name(Objects.toString(obj[1], ""));
				entity.setBusiness_reg_no(Objects.toString(obj[2], ""));
				entity.setCity_code(Objects.toString(obj[3], ""));
				entity.setArea_code(Objects.toString(obj[4], ""));
				entity.setServer_version(Objects.toString(obj[5], ""));
				entity.setClient_version(Objects.toString(obj[6], ""));
				entity.setAddress_name(Objects.toString(obj[7], ""));
				entity.setContact_name(Objects.toString(obj[8], ""));
				entity.setContact_tel(Objects.toString(obj[9], ""));
				entity.setClient_total(NumberUtil.toInteger(obj[10]));
				entity.setOutside_network(Objects.toString(obj[11], ""));
				entity.setInside_network(Objects.toString(obj[12], ""));
				entity.setServer_mac(Objects.toString(obj[13], ""));
				entity.setCreator(NumberUtil.toLong(obj[14]));
				entity.setCreate_time(DateUtil.toTimestamp(obj[15]));
				data.add(entity);
			}
		}
		return new DataTables<NetBarEntity>(param.getDraw(), total, total, data);
	}
	
	@Override
	public NetBarEntity findOne(String id){
		List<NetBarEntity> data = new ArrayList<NetBarEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,net_bar_name,business_reg_no,city_code,area_code,server_version,client_version,address_name,contact_name,contact_tel,client_total,outside_network,inside_network,server_mac,creator,create_time ")
		.append("FROM t_net_bar WHERE id= :id ");
		parameters.put("id", id);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				NetBarEntity entity = new NetBarEntity();
				entity.setId(Objects.toString(obj[0], ""));
				entity.setNet_bar_name(Objects.toString(obj[1], ""));
				entity.setBusiness_reg_no(Objects.toString(obj[2], ""));
				entity.setCity_code(Objects.toString(obj[3], ""));
				entity.setArea_code(Objects.toString(obj[4], ""));
				entity.setServer_version(Objects.toString(obj[5], ""));
				entity.setClient_version(Objects.toString(obj[6], ""));
				entity.setAddress_name(Objects.toString(obj[7], ""));
				entity.setContact_name(Objects.toString(obj[8], ""));
				entity.setContact_tel(Objects.toString(obj[9], ""));
				entity.setClient_total(NumberUtil.toInteger(obj[10]));
				entity.setOutside_network(Objects.toString(obj[11], ""));
				entity.setInside_network(Objects.toString(obj[12], ""));
				entity.setServer_mac(Objects.toString(obj[13], ""));
				entity.setCreator(NumberUtil.toLong(obj[14]));
				entity.setCreate_time(DateUtil.toTimestamp(obj[15]));
				data.add(entity);
			}
		}
		if(data == null || data.size() <= 0){
			return null;
		}
		return data.get(0);
	}
	
	@Override
	public int existBusinessRegNo(String business_reg_no){
		String sql = "select count(*) FROM t_net_bar WHERE business_reg_no="+business_reg_no;
		return findNativeCount(sql);
	}

	@Override
	public String queryMaxId(String areasid) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id from t_net_bar ");
		sql.append("where area_code = :search ");
		sql.append("order by id desc");
		parameters.put("search", areasid);
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		if(list == null || list.size() <= 0){
			return null;
		}
		return Objects.toString(list.get(0), "");
	}

	@Override
	public List<StatAreaEntity> getStatAreas(String area_code, String rankno) {
		List<StatAreaEntity> data = new ArrayList<StatAreaEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select stat_date,online,offline,login from t_stat_area ");
		sql.append("where area_code= :area_code and rankno= :rankno ");
		sql.append("order by stat_date desc limit 7");
		parameters.put("area_code", area_code);
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
		sql.append("SELECT stat_date, sum(`online`) as `online`, sum(offline) as offline, sum(valid) as valid FROM t_stat_net_bar ");
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