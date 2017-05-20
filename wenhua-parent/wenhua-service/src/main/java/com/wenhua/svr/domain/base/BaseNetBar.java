package com.wenhua.svr.domain.base;

import com.wenhua.svr.base.domain.AbstractEntity;

public class BaseNetBar extends AbstractEntity<String, BaseNetBar> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String mainId;

    private String netbarName;

    private String netbarState;

    private String districtCode;

    private String regAddress;

    private String regAddressDetail;

    private String regFund;

    private String economicType;

    private String approvalNum;

    private String approvalDept;

    private String approvalDate;

    private String legalName;

    private String busiArea;

    private Integer computerNum;

    private String ip;

    private Integer isdeleted;

    private String updateTime;

    private String contactName;

    private String contactTel;

    private String cityCode;

    private Integer isdeployed;

    private String createTime;

    private String syncTime;
    
    private String clientVersion;
    private String serverVersion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId == null ? null : mainId.trim();
    }

    public String getNetbarName() {
        return netbarName;
    }

    public void setNetbarName(String netbarName) {
        this.netbarName = netbarName == null ? null : netbarName.trim();
    }

    public String getNetbarState() {
        return netbarState;
    }

    public void setNetbarState(String netbarState) {
        this.netbarState = netbarState == null ? null : netbarState.trim();
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode == null ? null : districtCode.trim();
    }

    public String getRegAddress() {
        return regAddress;
    }

    public void setRegAddress(String regAddress) {
        this.regAddress = regAddress == null ? null : regAddress.trim();
    }

    public String getRegAddressDetail() {
        return regAddressDetail;
    }

    public void setRegAddressDetail(String regAddressDetail) {
        this.regAddressDetail = regAddressDetail == null ? null : regAddressDetail.trim();
    }

    public String getRegFund() {
        return regFund;
    }

    public void setRegFund(String regFund) {
        this.regFund = regFund == null ? null : regFund.trim();
    }

    public String getEconomicType() {
        return economicType;
    }

    public void setEconomicType(String economicType) {
        this.economicType = economicType == null ? null : economicType.trim();
    }

    public String getApprovalNum() {
        return approvalNum;
    }

    public void setApprovalNum(String approvalNum) {
        this.approvalNum = approvalNum == null ? null : approvalNum.trim();
    }

    public String getApprovalDept() {
        return approvalDept;
    }

    public void setApprovalDept(String approvalDept) {
        this.approvalDept = approvalDept == null ? null : approvalDept.trim();
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate == null ? null : approvalDate.trim();
    }

    public String getLegalName() {
        return legalName;
    }

    public void setLegalName(String legalName) {
        this.legalName = legalName == null ? null : legalName.trim();
    }

    public String getBusiArea() {
        return busiArea;
    }

    public void setBusiArea(String busiArea) {
        this.busiArea = busiArea == null ? null : busiArea.trim();
    }

    public Integer getComputerNum() {
        return computerNum;
    }

    public void setComputerNum(Integer computerNum) {
        this.computerNum = computerNum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Integer getIsdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(Integer isdeleted) {
        this.isdeleted = isdeleted;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel == null ? null : contactTel.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public Integer getIsdeployed() {
        return isdeployed;
    }

    public void setIsdeployed(Integer isdeployed) {
        this.isdeployed = isdeployed;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime == null ? null : syncTime.trim();
    }

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}
    
}