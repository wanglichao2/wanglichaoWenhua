package com.iss.vo;

public class NetBarPrintVo {
	
	private String barId;
	private String barName;
	private String approvalNum;
	private String regAddress;
	private Long zdzs=0l;
	private Long onLineCount=0l;
	private Long offLineCount=0l;
	private Long installNum=0l;
	private Long unInstallNum=0l;
	private String onLineRate="0";
	private String installRate="0";
	private String uploadTime;
	private String uploadDate;
	
	
	public String getBarId() {
		return barId;
	}
	public void setBarId(String barId) {
		this.barId = barId;
	}
	public String getBarName() {
		return barName;
	}
	public void setBarName(String barName) {
		this.barName = barName;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	public Long getZdzs() {
		return zdzs;
	}
	public void setZdzs(Long zdzs) {
		this.zdzs = zdzs;
	}
	public Long getOnLineCount() {
		return onLineCount;
	}
	public void setOnLineCount(Long onLineCount) {
		this.onLineCount = onLineCount;
	}
	public Long getOffLineCount() {
		return offLineCount;
	}
	public void setOffLineCount(Long offLineCount) {
		this.offLineCount = offLineCount;
	}
	public Long getInstallNum() {
		return installNum;
	}
	public void setInstallNum(Long installNum) {
		this.installNum = installNum;
	}
	public Long getUnInstallNum() {
		return unInstallNum;
	}
	public void setUnInstallNum(Long unInstallNum) {
		this.unInstallNum = unInstallNum;
	}
	public String getOnLineRate() {
		return onLineRate;
	}
	public void setOnLineRate(String onLineRate) {
		this.onLineRate = onLineRate;
	}
	public String getInstallRate() {
		return installRate;
	}
	public void setInstallRate(String installRate) {
		this.installRate = installRate;
	}
	public String getUploadTime() {
		return uploadTime;
	}
	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}
	public String getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	

}
