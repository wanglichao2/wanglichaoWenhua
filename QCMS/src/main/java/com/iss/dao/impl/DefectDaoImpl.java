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

import com.iss.dao.IDefectJPADao;
import com.iss.entity.DefectEntity;
import com.iss.util.DateUtil;
import com.iss.util.NumberUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理持久化数据实现
 */
@Repository
public class DefectDaoImpl extends BaseJPADaoImpl<Object, Long> implements IDefectJPADao{
	@Override
	public DataTables<DefectEntity> query(DataParam param) {
		int total=0;
		List<DefectEntity> data = new ArrayList<DefectEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT id, zs, zt, bt, csjd, fxr, fxrq, fpg, gjxfsj, gbrq, gbybb, jhgbbb, jhxfrq, jcybb, jcyfb, ")
		.append("jcyzq, kcx, ms, mbfb, mbzq, qxhjjly, qxid, qxlb, qxzt, sjxfsj, xm, xgrq, yzd, yxj, sjzt, ylid ")
		.append("FROM t_qc_defect WHERE status=1 ");
		StringBuffer where = new StringBuffer();
		Map<String, String> search = param.getSearch();
		if(search!=null){//搜索条件
			String value = search.get("value");
			if(StringUtils.isNotBlank(value)){
				where.append("AND(CONCAT_WS(zs, zt, bt, csjd, fxr, fxrq, fpg, gjxfsj, gbrq, gbybb, jhgbbb, jhxfrq, jcybb, jcyfb,")
				.append("jcyzq, kcx, ms, mbfb, mbzq, qxhjjly, qxid, qxlb, qxzt, sjxfsj, xm, xgrq, yzd, yxj, sjzt) like :search)");
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
				DefectEntity entity = new DefectEntity();
				//entity.setRowId(NumberUtil.toLong(obj[0]));
				entity.setId(NumberUtil.toLong(obj[0]));
				entity.setZs(Objects.toString(obj[1], ""));
				entity.setZt(Objects.toString(obj[2], ""));
				entity.setBt(Objects.toString(obj[3], ""));
				entity.setCsjd(Objects.toString(obj[4], ""));
				entity.setFxr(Objects.toString(obj[5], ""));
				entity.setFxrq(DateUtil.toTimestamp(obj[6]));
				entity.setFpg(Objects.toString(obj[7], ""));
				entity.setGjxfsj(DateUtil.toTimestamp(obj[8]));
				entity.setGbrq(DateUtil.toTimestamp(obj[9]));
				entity.setGbybb(Objects.toString(obj[10], ""));
				entity.setJhgbbb(Objects.toString(obj[11], ""));
				entity.setJhxfrq(DateUtil.toTimestamp(obj[12]));
				entity.setJcybb(Objects.toString(obj[13], ""));
				entity.setJcyfb(Objects.toString(obj[14], ""));
				entity.setJcyzq(Objects.toString(obj[15], ""));
				entity.setKcx(Objects.toString(obj[16], ""));
				entity.setMs(Objects.toString(obj[17], ""));
				entity.setMbfb(Objects.toString(obj[18], ""));
				entity.setMbzq(Objects.toString(obj[19], ""));
				entity.setQxhjjly(Objects.toString(obj[20], ""));
				entity.setQxid(Objects.toString(obj[21], ""));
				entity.setQxlb(Objects.toString(obj[22], ""));
				entity.setQxzt(Objects.toString(obj[23], ""));
				entity.setSjxfsj(DateUtil.toTimestamp(obj[24]));
				entity.setXm(Objects.toString(obj[25], ""));
				entity.setXgrq(DateUtil.toTimestamp(obj[26]));
				entity.setYzd(Objects.toString(obj[27], ""));
				entity.setYxj(Objects.toString(obj[28], ""));
				entity.setSjzt(Objects.toString(obj[29], ""));
				entity.setYlid(Objects.toString(obj[30], ""));
				data.add(entity);
			}
		}
		return new DataTables<DefectEntity>(param.getDraw(), total, total, data);
	}
}
