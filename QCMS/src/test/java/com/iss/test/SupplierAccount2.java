package com.iss.test;

import java.util.Date;

public class SupplierAccount2 {
	private Long id;//供应商账号主键ID
	private Long vendorId;//EBS供应商主键ID(必填)
	private String isDefault;//是否默认账号
	
	private String bankCode;//收款开户银行编号(必填)
	private String bankName;//收款开户银行名称(必填)
	
	private String accountNumber;//收款账号(必填)
	private String accountName;//收款账户名称(必填)
	
	private String currencyCode;//币种代码(必填)
	private String currencyName;//币种名称(必填)
	
	private Long bankBranchId;//开户支行ID
	private String bankBranchName;//开户支行名称(必填)
	private String bankNo;//支行行号(必填)
	private String bankAddress;//支行地址
	
	private String swiftCode;//银行国际代码
	
	private String agentAccountNumber;//收款银行之代理行账号
	private String agentBank;//收款银行之代理行名称
	private String agentBankAddress;//收款银行之代理行地址
	
	private Long countryCode;//国家code(必填)
	private String supplierCountry;//供应商国家
	
	private Long districtId;//地区id(必填)
	private String supplierArea;//供应商地区
	
	private Long cityId;//城市id(必填)
	private String supplierCity;//供应商城市
	
	private String validity;//有效状态(必填)
	
	private Date beginDate;//账户使用有效期起
	private Date endDate;//账户使用有效期讫
	
	private Long createdBy;// 创建者(必填)
	private Date createdTime;// 创建时间(EBS创建供应商的时间)
	private Long lastModifiedBy;// 创建者(必填)
	private Date lastModifiedTime;// 创建时间(EBS修改供应商的时间)
	private Date syncTime;// 最初同步时间（仅在资金系统使用）

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(Long countryCode) {
		this.countryCode = countryCode;
	}

	public Long getBankBranchId() {
		return bankBranchId;
	}

	public void setBankBranchId(Long bankBranchId) {
		this.bankBranchId = bankBranchId;
	}

	public String getBankBranchName() {
		return bankBranchName;
	}

	public void setBankBranchName(String bankBranchName) {
		this.bankBranchName = bankBranchName;
	}

	public String getBankNo() {
		return bankNo;
	}

	public void setBankNo(String bankNo) {
		this.bankNo = bankNo;
	}

	public String getBankAddress() {
		return bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getAgentAccountNumber() {
		return agentAccountNumber;
	}

	public void setAgentAccountNumber(String agentAccountNumber) {
		this.agentAccountNumber = agentAccountNumber;
	}

	public String getAgentBank() {
		return agentBank;
	}

	public void setAgentBank(String agentBank) {
		this.agentBank = agentBank;
	}

	public String getAgentBankAddress() {
		return agentBankAddress;
	}

	public void setAgentBankAddress(String agentBankAddress) {
		this.agentBankAddress = agentBankAddress;
	}

	public String getSupplierCountry() {
		return supplierCountry;
	}

	public void setSupplierCountry(String supplierCountry) {
		this.supplierCountry = supplierCountry;
	}

	public String getSupplierArea() {
		return supplierArea;
	}

	public void setSupplierArea(String supplierArea) {
		this.supplierArea = supplierArea;
	}

	public String getSupplierCity() {
		return supplierCity;
	}

	public void setSupplierCity(String supplierCity) {
		this.supplierCity = supplierCity;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

}
