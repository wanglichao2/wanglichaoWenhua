package com.iss.vo;

public class NetBarBean implements Comparable<NetBarBean>{
	
	private String approvalDate ;
    private String approvalDept ;
    private String approvalNum ;
    private String busiArea ;
    private String computerNum ;
    private String districtCode ;
    private String economicType ;
    private String ip ;
    private String isdeleted ;
    private String legalname ;
    
    private String mainId ;
    private String netbarName ;
    private String netbarState ;
    private String regAddress ;
    private String regAddressDetail ;
    private String regFund ;
    private String updateTime ;
    
    
	public String getApprovalDate() {
		return approvalDate;
	}
	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
	public String getApprovalDept() {
		return approvalDept;
	}
	public void setApprovalDept(String approvalDept) {
		this.approvalDept = approvalDept;
	}
	public String getApprovalNum() {
		return approvalNum;
	}
	public void setApprovalNum(String approvalNum) {
		this.approvalNum = approvalNum;
	}
	public String getBusiArea() {
		return busiArea;
	}
	public void setBusiArea(String busiArea) {
		this.busiArea = busiArea;
	}
	public String getComputerNum() {
		return computerNum;
	}
	public void setComputerNum(String computerNum) {
		this.computerNum = computerNum;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public String getEconomicType() {
		return economicType;
	}
	public void setEconomicType(String economicType) {
		this.economicType = economicType;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(String isdeleted) {
		this.isdeleted = isdeleted;
	}
	public String getLegalname() {
		return legalname;
	}
	public void setLegalname(String legalname) {
		this.legalname = legalname;
	}
	public String getMainId() {
		return mainId;
	}
	public void setMainId(String mainId) {
		this.mainId = mainId;
	}
	public String getNetbarName() {
		return netbarName;
	}
	public void setNetbarName(String netbarName) {
		this.netbarName = netbarName;
	}
	public String getNetbarState() {
		return netbarState;
	}
	public void setNetbarState(String netbarState) {
		this.netbarState = netbarState;
	}
	public String getRegAddress() {
		return regAddress;
	}
	public void setRegAddress(String regAddress) {
		this.regAddress = regAddress;
	}
	public String getRegAddressDetail() {
		return regAddressDetail;
	}
	public void setRegAddressDetail(String regAddressDetail) {
		this.regAddressDetail = regAddressDetail;
	}
	public String getRegFund() {
		return regFund;
	}
	public void setRegFund(String regFund) {
		this.regFund = regFund;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public int compareTo(NetBarBean o) {
		// TODO Auto-generated method stub
		if(o.getDistrictCode()==null || "".equals(o.getDistrictCode()))return 0;
		int bcode=Integer.parseInt(this.districtCode);
		int ocode=Integer.parseInt(o.getDistrictCode());
		if(bcode>ocode)return 1;
		else if(bcode<ocode)return -1;
		else return 0;
	}
    
    

}
