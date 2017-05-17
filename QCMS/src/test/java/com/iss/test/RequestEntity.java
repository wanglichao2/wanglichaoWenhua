package com.iss.test;

import java.util.List;

public class RequestEntity {
	private List<Supplier> suppliers;// 供应商对象
	private Integer count;// 供应商记录数

	
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
