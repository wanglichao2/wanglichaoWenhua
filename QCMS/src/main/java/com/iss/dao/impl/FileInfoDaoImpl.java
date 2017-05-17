package com.iss.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.iss.dao.IFileInfoJPADao;
import com.iss.entity.FileInfoEntity;
import com.iss.util.DateUtil;
import com.iss.util.NumberUtil;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

@Repository
public class FileInfoDaoImpl extends BaseJPADaoImpl<Object, Long> implements IFileInfoJPADao{
	@Override
	public DataTables<FileInfoEntity> query(DataParam param) {
		int total=0;
		List<FileInfoEntity> data = new ArrayList<FileInfoEntity>();
		Map<String, Object> parameters = new HashMap<String, Object>();
		StringBuffer sql = new StringBuffer();
		sql.append("select id,filename,version,md5,flag,type,action,is_apply,creator,create_time,last_modifier,last_modify_time ")
		.append("from t_file_info WHERE status= "+param.getSearch().get("status"));
		StringBuffer where = new StringBuffer();
		Map<String, String> search = param.getSearch();
		if(search!=null){//搜索条件
			String value = search.get("value");
			if(StringUtils.isNotBlank(value)){
				where.append(" AND CONCAT_WS(filename,version,md5,flag,type,action,is_apply,creator,create_time) like :param");
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
		List<Object> list = findNativeQuery(sql.toString(), parameters);
		for (Object object : list) {
			if(object instanceof Object[]){
				Object[] obj = (Object[]) object;
				FileInfoEntity entity = new FileInfoEntity();
				entity.setId(NumberUtil.toLong(obj[0]));
				entity.setFilename(Objects.toString(obj[1], ""));
				entity.setVersion(Objects.toString(obj[2], ""));
				entity.setMd5(Objects.toString(obj[3], ""));
				entity.setFlag(Objects.toString(obj[4], "").charAt(0));
				entity.setType(Objects.toString(obj[5], "").charAt(0));
				entity.setAction(Objects.toString(obj[6], "").charAt(0));
				entity.setIsApply(Objects.toString(obj[7], "").charAt(0));
				entity.setCreator(NumberUtil.toLong(obj[8]));
				entity.setCreateTime(DateUtil.toDate(obj[9]));
				entity.setLastModifier(NumberUtil.toLong(obj[10]));
				entity.setLastModifyTime(DateUtil.toDate(obj[11]));
				if(entity.getIsApply() == '0'){
					String sqlStr = "select n.id,n.net_bar_name from t_net_bar n left JOIN t_file_bar b on b.barid = n.id where b.fileId="+entity.getId();
					List<Object> netbarList = findNativeQuery(sqlStr);
					StringBuffer netbarIds = new StringBuffer();
					StringBuffer netbarNames = new StringBuffer();
					for (Object o : netbarList) {
						if(o instanceof Object[]){
							Object[] netbar = (Object[]) o;
							netbarIds.append(NumberUtil.toLong(netbar[0])).append(",");
							netbarNames.append(Objects.toString(netbar[1], "")).append(",");;
						}
					}
					entity.setNetbarIds(netbarIds.toString());
					entity.setNetbarNames(netbarNames.toString());
				}
				
				data.add(entity);
			}
		}
		return new DataTables<FileInfoEntity>(param.getDraw(), total, total, data);
	}
	
	@Override
	public FileInfoEntity update(FileInfoEntity entity){
		return null;
	}
}