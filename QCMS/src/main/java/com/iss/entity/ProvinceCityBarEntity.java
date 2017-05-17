/**
 * 
 */
package com.iss.entity;

import java.io.Serializable;

import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.handler.inter.IExcelModel;

/**
 * @author gxie
 *
 */
public class ProvinceCityBarEntity implements Serializable, IExcelModel{
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	private Long rowId;//序号
	private String errorMsg;//错误消息
	
	private String areaCode;
	@Excel(name = "行政区名称", orderNum = "1")
	private String areaName;
	@Excel(name = "在线网吧数", orderNum = "2")
	private Long online;
	@Excel(name = "离线网吧数", orderNum = "3")
	private Long offline;
	@Excel(name = "机器总数", orderNum = "4")
	private Long pcTotal;
	@Excel(name = "用户总数", orderNum = "5")
	private Long login;

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public Long getOffline() {
		return offline;
	}

	public void setOffline(Long offline) {
		this.offline = offline;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	public Long getPcTotal() {
		return pcTotal;
	}

	public void setPcTotal(Long pcTotal) {
		this.pcTotal = pcTotal;
	}

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
}
