package com.iss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.iss.dao.INetBarJPADao;
import com.iss.entity.AreasBarEntity;
import com.iss.entity.ProvinceCityBarEntity;
import com.iss.entity.StatAreaEntity;
import com.iss.entity.StatNetBarEntity;
import com.iss.service.INetBarListService;
import com.iss.util.HttpClientUtil;
import com.iss.util.PropertiesUtil;
import com.iss.util.StringUtil;
import com.iss.vo.DataParam;

@Service
public class NetBarListServiceImpl implements INetBarListService {

	@Autowired
	private INetBarJPADao iNetBarJPADao;
	
	@Override
	public List<ProvinceCityBarEntity> loadProvinceCityBar() {
		List<ProvinceCityBarEntity> data = new ArrayList<ProvinceCityBarEntity>();
		String result = HttpClientUtil.netBarListHttpPost(PropertiesUtil.getPropery("provinceUrl"));
		//json结果转换为List集合
		try {
			if(StringUtil.isNotEmpty(result)){
				data = JSON.parseArray(result,ProvinceCityBarEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<ProvinceCityBarEntity> loadProvinceCityBar(DataParam param) {
		String url = PropertiesUtil.getPropery("cityUrl");
		String value = param.getSearch().get("value");
		if(StringUtil.isEmpty(value) || value.equals("410000")){
			url = PropertiesUtil.getPropery("provinceUrl");
		}else{
			url = url + value;
		}
		List<ProvinceCityBarEntity> data = new ArrayList<ProvinceCityBarEntity>();
		String result = HttpClientUtil.netBarListHttpPost(url);
		//json结果转换为List集合
		try {
			if(StringUtil.isNotEmpty(result)){
				data = JSON.parseArray(result,ProvinceCityBarEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<AreasBarEntity> loadAreasBar(DataParam param) {
		List<AreasBarEntity> data = new ArrayList<AreasBarEntity>();
		String value = param.getSearch().get("value");
		String result = HttpClientUtil.netBarListHttpPost(PropertiesUtil.getPropery("areaUrl")+value);
		//json结果转换为List集合
		try {
			if(StringUtil.isNotEmpty(result)){
				data = JSON.parseArray(result,AreasBarEntity.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	@Override
	public List<StatAreaEntity> getStatAreas(String area_code,String parentId){
		String rankno = "";
		if(StringUtil.isEmpty(parentId)){
			rankno = "1";
			area_code = "410000";
		}else if(parentId.equals("0")){
			rankno = "1";
		}else if(parentId.equals("410000")){
			rankno = "2";
		}else{
			rankno = "3";
		}
		return iNetBarJPADao.getStatAreas(area_code, rankno);
	}

	@Override
	public List<StatNetBarEntity> getStatNetBars(String area_code){
		return iNetBarJPADao.getStatNetBars(area_code);
	}
}