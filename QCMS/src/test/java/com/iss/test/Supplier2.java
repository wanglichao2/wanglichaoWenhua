package com.iss.test;

import java.util.Date;
import java.util.List;

public class Supplier2 {
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
	
	private String isDefault;// 是否默认账号
	private String accountName;// 账户名(必填)
	private String accountNumber;// 账号(必填)
	private String currencyCode;// 币种代码(必填)
	private String bankCode;// 开户银行代码(必填)
	private Long countryCode;// 国家code(必填)
	private Long districtId;// 地区id(必填)
	private Long cityId;// 城市id(必填)
	private String validity;// 有效状态(必填)
	private Long bankBranchId;// 开户支行ID
	private String bankBranchName;// 开户支行名称(必填)
	private String bankNo;// 支行行号(必填)
	private String swiftCode;// 银行国际代码(国际汇款使用)
	private Date beginDate;// 账户使用有效期起
	private Date endDate;// 账户使用有效期讫

}
