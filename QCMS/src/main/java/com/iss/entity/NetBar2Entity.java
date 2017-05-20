/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.handler.inter.IExcelModel;

import com.iss.constants.TableConstants;

/**
 * 网吧实体
 */
@Entity
@Table(name=TableConstants.NETBAR2_TABLE)
public class NetBar2Entity implements Serializable, IExcelModel {
	/**
	 * @Fields serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	private Long rowId;// 序号
	private String errorMsg;// 错误消息
	
	private String id;// 网吧ID
	private String main_id;
	private String netbar_name;// 网吧名称
	private String netbar_state;//
	private String district_code;// 区划编码
	private String reg_address; //区划地址
	private String reg_address_detail;// 详细地址
	private String reg_fund;//注册资本
	private String economic_type;//经济类型
	private String approval_num;//许可证号
	private String approval_dept;//批准机关名称
	private String approval_date;//批准日期
	private String legal_name;//法人姓名
	private String busi_area;//经营面积
	private Integer computer_num;//核定终端台数
	private String ip;//IP地址
	private Integer isdeleted;//是否删除
	private String update_time;//网吧信息在部中心的更新时间
	private Integer isdeployed;//是否已施工完成
	private String contact_name;//联系人姓名
	private String contact_tel;// 联系人电话
	private String city_code;// 市代码
	private String create_time;
	private String sync_time;
	

	@Transient
	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	@Override
	@Transient
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_tel() {
		return contact_tel;
	}

	public void setContact_tel(String contact_tel) {
		this.contact_tel = contact_tel;
	}
	
	public String getMain_id() {
		return main_id;
	}

	public void setMain_id(String main_id) {
		this.main_id = main_id;
	}

	public String getNetbar_name() {
		return netbar_name;
	}

	public void setNetbar_name(String netbar_name) {
		this.netbar_name = netbar_name;
	}

	public String getNetbar_state() {
		return netbar_state;
	}

	public void setNetbar_state(String netbar_state) {
		this.netbar_state = netbar_state;
	}

	public String getDistrict_code() {
		return district_code;
	}

	public void setDistrict_code(String district_code) {
		this.district_code = district_code;
	}

	public String getReg_address() {
		return reg_address;
	}

	public void setReg_address(String reg_address) {
		this.reg_address = reg_address;
	}

	public String getReg_address_detail() {
		return reg_address_detail;
	}

	public void setReg_address_detail(String reg_address_detail) {
		this.reg_address_detail = reg_address_detail;
	}

	public String getReg_fund() {
		return reg_fund;
	}

	public void setReg_fund(String reg_fund) {
		this.reg_fund = reg_fund;
	}

	public String getEconomic_type() {
		return economic_type;
	}

	public void setEconomic_type(String economic_type) {
		this.economic_type = economic_type;
	}

	public String getApproval_num() {
		return approval_num;
	}

	public void setApproval_num(String approval_num) {
		this.approval_num = approval_num;
	}

	public String getApproval_dept() {
		return approval_dept;
	}

	public void setApproval_dept(String approval_dept) {
		this.approval_dept = approval_dept;
	}

	public String getApproval_date() {
		return approval_date;
	}

	public void setApproval_date(String approval_date) {
		this.approval_date = approval_date;
	}

	public String getLegal_name() {
		return legal_name;
	}

	public void setLegal_name(String legal_name) {
		this.legal_name = legal_name;
	}

	public String getBusi_area() {
		return busi_area;
	}

	public void setBusi_area(String busi_area) {
		this.busi_area = busi_area;
	}

	public Integer getComputer_num() {
		return computer_num;
	}

	public void setComputer_num(Integer computer_num) {
		this.computer_num = computer_num;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(Integer isdeleted) {
		this.isdeleted = isdeleted;
	}

	public String getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}

	public Integer getIsdeployed() {
		return isdeployed;
	}

	public void setIsdeployed(Integer isdeployed) {
		this.isdeployed = isdeployed;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getSync_time() {
		return sync_time;
	}

	public void setSync_time(String sync_time) {
		this.sync_time = sync_time;
	}

	@Id
	@Column(name="id", nullable=false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
