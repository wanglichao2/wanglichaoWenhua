package com.iss.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_netbar_deploy")
public class NetBarDeployEntity extends IdEntity {
	
	private String netbarCode;
	private String detectNum;
	private String installNum;
	private String is_deploy;
	private String onlineNum;
	private String reportTime;
	private String deployTime;
	private Integer status;
	
	public String getNetbarCode() {
		return netbarCode;
	}
	public void setNetbarCode(String netbarCode) {
		this.netbarCode = netbarCode;
	}
	public String getDetectNum() {
		return detectNum;
	}
	public void setDetectNum(String detectNum) {
		this.detectNum = detectNum;
	}
	public String getInstallNum() {
		return installNum;
	}
	public void setInstallNum(String installNum) {
		this.installNum = installNum;
	}
	public String getIs_deploy() {
		return is_deploy;
	}
	public void setIs_deploy(String is_deploy) {
		this.is_deploy = is_deploy;
	}
	public String getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(String onlineNum) {
		this.onlineNum = onlineNum;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	
	public String getDeployTime() {
		return deployTime;
	}
	public void setDeployTime(String deployTime) {
		this.deployTime = deployTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	

}
