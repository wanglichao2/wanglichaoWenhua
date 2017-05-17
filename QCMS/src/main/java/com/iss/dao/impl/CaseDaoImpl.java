/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.iss.dao.ICaseJPADao;
import com.iss.entity.CaseEntity;
import com.iss.util.DateUtil;
import com.iss.util.NumberUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 用例管理持久化数据实现
 */
@Repository
public class CaseDaoImpl extends BaseJPADaoImpl<Object, Long> implements ICaseJPADao{
	@Override
	public DataTables<CaseEntity> query(DataParam param) {
		int total=0;
		List<CaseEntity> data = new ArrayList<CaseEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id, ggzt, zs, cjrq, ylms, sjz, gjkfsj, zxzt, xgsj, lj, sjzt, zt, mb, csid, csmc,  ")
		.append("lx, csms, cssj, csylbh, csylzt, gzms, qztj, sjdglxt, syzt, sszxt, xylx, ylfyzt, ylxz, yxj ")
		.append("FROM t_qc_case WHERE status=1 ");
		StringBuffer where = new StringBuffer();
		Map<String, String> search = param.getSearch();
		if(search!=null){//搜索条件
			String value = search.get("value");
			if(StringUtils.isNotBlank(value)){
				where.append("AND(CONCAT_WS(id, ggzt, zs, cjrq, ylms, sjz, gjkfsj, zxzt, xgsj, lj, sjzt, zt, mb, csid, csmc,")
				.append("lx, csms, cssj, csylbh, csylzt, gzms, qztj, sjdglxt, syzt, sszxt, xylx, ylfyzt, ylxz, yxj) like :search)");
				parameters.put("search", ("%"+value+"%"));
			}
		}
		sql.append(where);
		//记录总数
		total = findNativeCount(sql.toString(), parameters);//先统计总数，不需要orderby和limit
		sql.append("ORDER BY ");
		if(param.getOrder()==null){
			sql.append("createTime desc, id");
		}else{
			Map<String, String> order = param.getOrder().get(0);
			int index = Integer.valueOf(order.get("column"));
			if(index < 2)
				sql.append("createTime desc, id");
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
				CaseEntity entity = new CaseEntity();
				//entity.setRowId(NumberUtil.toLong(obj[0]));
				entity.setId(NumberUtil.toLong(obj[0]));
				entity.setGgzt(Objects.toString(obj[1], ""));
				entity.setZs(Objects.toString(obj[2], ""));
				entity.setCjrq(DateUtil.toTimestamp(obj[3]));
				entity.setYlms(Objects.toString(obj[4], ""));
				entity.setSjz(Objects.toString(obj[5], ""));
				entity.setGjkfsj(DateUtil.toTimestamp(obj[6]));
				entity.setZxzt(Objects.toString(obj[7], ""));
				entity.setXgsj(DateUtil.toTimestamp(obj[8]));
				entity.setLj(Objects.toString(obj[9], ""));
				entity.setSjzt(Objects.toString(obj[10], ""));
				entity.setZt(Objects.toString(obj[11], ""));
				entity.setMb(Objects.toString(obj[12], ""));
				entity.setCsid(Objects.toString(obj[13], ""));
				entity.setCsmc(Objects.toString(obj[14], ""));
				entity.setLx(Objects.toString(obj[15], ""));
				entity.setCsms(Objects.toString(obj[16], ""));
				entity.setCssj(Objects.toString(obj[17], ""));
				entity.setCsylbh(Objects.toString(obj[18], ""));
				entity.setCsylzt(Objects.toString(obj[19], ""));
				entity.setGzms(Objects.toString(obj[20], ""));
				entity.setQztj(Objects.toString(obj[21], ""));
				entity.setSjdglxt(Objects.toString(obj[22], ""));
				entity.setSyzt(Objects.toString(obj[23], ""));
				entity.setSszxt(Objects.toString(obj[24], ""));
				entity.setXylx(Objects.toString(obj[25], ""));
				entity.setYlfyzt(Objects.toString(obj[26], ""));
				entity.setYlxz(Objects.toString(obj[27], ""));
				entity.setYxj(Objects.toString(obj[28], ""));
				data.add(entity);
			}
		}
		return new DataTables<CaseEntity>(param.getDraw(), total, total, data);
	}
}
