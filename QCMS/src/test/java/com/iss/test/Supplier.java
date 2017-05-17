package com.iss.test;

import java.util.Date;
import java.util.List;

public class Supplier {
	private String vendorId;// EBS供应商主键ID(必填)
	private String supplierName;// 供应商名称(必填)
	private String supplierCode;// 供应商编号(必填)
	private Long supplierDeptId;// 供应商所在部门ID(必填)
	private String status;// 状态（Y：有效，N：无效）(必填)
	private Long createdBy;// 创建者(必填)
	private Date createdTime;// 创建时间(EBS创建供应商的时间)(必填)
	private Long lastModifiedBy;// 最后修改人
	private Date lastModifiedTime;// 最后修改时间(EBS修改供应商的时间)
	private Date syncTime;// 最初同步时间（仅在资金系统使用）
	private List<SupplierAccount> supplierAccounts;//供应商的账户信息

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public Long getSupplierDeptId() {
		return supplierDeptId;
	}

	public void setSupplierDeptId(Long supplierDeptId) {
		this.supplierDeptId = supplierDeptId;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Long getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Long lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	public Date getSyncTime() {
		return syncTime;
	}

	public void setSyncTime(Date syncTime) {
		this.syncTime = syncTime;
	}

	public List<SupplierAccount> getSupplierAccounts() {
		return supplierAccounts;
	}

	public void setSupplierAccounts(List<SupplierAccount> supplierAccounts) {
		this.supplierAccounts = supplierAccounts;
	}

}
