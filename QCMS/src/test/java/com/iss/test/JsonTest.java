package com.iss.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

public class JsonTest {
	
	public static void main(String[] args){
		Supplier supplier = new Supplier();
		supplier.setVendorId("1000");
		supplier.setSupplierName("天津滨海国际机场");
		supplier.setSupplierCode("0302015109000019188");
		supplier.setSupplierDeptId(20002L);
		supplier.setStatus("Y");
		supplier.setCreatedBy(8001L);
		supplier.setCreatedTime(new Date());
		supplier.setLastModifiedBy(8001L);
		supplier.setLastModifiedTime(new Date());
		
		List<SupplierAccount> supplierAccounts = new ArrayList<SupplierAccount>();
		SupplierAccount supplierAccount = new SupplierAccount();
		supplierAccount.setId(1L);
		supplierAccount.setVendorId("1");
		supplierAccount.setIsDefault("N");
		supplierAccount.setAccountName("天津滨海国际机场");
		supplierAccount.setAccountNumber("0302015109000019188");
		supplierAccount.setCurrencyCode("RMB");
		supplierAccount.setBankCode("ICBC");
		supplierAccount.setDistrictId(100003L);
		supplierAccount.setCityId(10000002L);
		supplierAccount.setValidity("Y");
		supplierAccount.setBankBranchId(433994L);
		supplierAccount.setBankBranchName("中国工商银行天津市滨海国际机场支行");
		supplierAccount.setBankNo("102110001028");
		supplierAccount.setSwiftCode("ICBKCNBJAHI");
		supplierAccount.setBeginDate(new Date());
		supplierAccount.setEndDate(new Date());
		supplierAccount.setCreatedBy(8001L);
		supplierAccount.setCreatedTime(new Date());
		supplierAccount.setLastModifiedBy(8001L);
		supplierAccount.setLastModifiedTime(new Date());
		supplierAccounts.add(supplierAccount);
		
		supplier.setSupplierAccounts(supplierAccounts);
		
		Supplier supplier1 = new Supplier();
		supplier1.setVendorId("1000");
		supplier1.setSupplierName("天津滨海国际机场");
		supplier1.setSupplierCode("0302015109000019188");
		supplier1.setSupplierDeptId(20002L);
		supplier1.setStatus("Y");
		supplier1.setCreatedBy(8001L);
		supplier1.setCreatedTime(new Date());
		supplier1.setLastModifiedBy(8001L);
		supplier1.setLastModifiedTime(new Date());
		
		List<SupplierAccount> supplierAccounts1 = new ArrayList<SupplierAccount>();
		SupplierAccount supplierAccount1 = new SupplierAccount();
		supplierAccount1.setId(1L);
		supplierAccount1.setVendorId("1");
		supplierAccount1.setIsDefault("N");
		supplierAccount1.setAccountName("天津滨海国际机场");
		supplierAccount1.setAccountNumber("0302015109000019188");
		supplierAccount1.setCurrencyCode("RMB");
		supplierAccount1.setBankCode("ICBC");
		supplierAccount1.setDistrictId(100003L);
		supplierAccount1.setCityId(10000002L);
		supplierAccount1.setValidity("Y");
		supplierAccount1.setBankBranchId(433994L);
		supplierAccount1.setBankBranchName("中国工商银行天津市滨海国际机场支行");
		supplierAccount1.setBankNo("102110001028");
		supplierAccount1.setSwiftCode("ICBKCNBJAHI");
		supplierAccount1.setBeginDate(new Date());
		supplierAccount1.setEndDate(new Date());
		supplierAccount1.setCreatedBy(8001L);
		supplierAccount1.setCreatedTime(new Date());
		supplierAccount1.setLastModifiedBy(8001L);
		supplierAccount1.setLastModifiedTime(new Date());
		supplierAccounts1.add(supplierAccount1);
		
		supplier1.setSupplierAccounts(supplierAccounts1);
		
		List<Supplier> suppliers = new ArrayList<Supplier>();
		suppliers.add(supplier);
		//suppliers.add(supplier1);
		
		RequestEntity request = new RequestEntity();
		request.setSuppliers(suppliers);
		request.setCount(suppliers.size());
		
		String json = JSON.toJSONString(request);
		System.out.println(json);
	}
}
