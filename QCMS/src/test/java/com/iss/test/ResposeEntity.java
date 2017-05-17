package com.iss.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class ResposeEntity {
	private String vendorIds;// 供应商ID
	private String result;
	private String error_code;// 供应商记录数

	public String getVendorIds() {
		return vendorIds;
	}

	public void setVendorIds(String vendorIds) {
		this.vendorIds = vendorIds;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public static void main(String[] args){
		List<ResposeEntity> respose = new ArrayList<ResposeEntity>();
		ResposeEntity resposeEntity = new ResposeEntity();
		resposeEntity.setVendorIds("1000");
		resposeEntity.setResult("sussecs");
		resposeEntity.setError_code("");
		respose.add(resposeEntity);
		ResposeEntity resposeEntity1 = new ResposeEntity();
		resposeEntity1.setVendorIds("1000");
		resposeEntity1.setResult("fail");
		resposeEntity1.setError_code("01(待约定)");
		respose.add(resposeEntity1);
		
		String json = JSON.toJSONString(respose);
		System.out.println(json);
	}
}
