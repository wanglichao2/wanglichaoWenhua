package com.wenhua.svr.domain.base;

import com.wenhua.svr.base.domain.AbstractEntity;
import java.util.Date;

public class BaseNetBar extends AbstractEntity<String, BaseNetBar> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String netBarName;

    private String businessRegNo;

    private String cityCode;

    private String areaCode;

    private String serverVersion;

    private String clientVersion;

    private String addressName;

    private String contactName;

    private String contactTel;

    private Integer clientTotal;

    private String outsideNetwork;

    private String insideNetwork;

    private String serverMac;

    private String creator;

    private Date createTime;

    private Integer status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNetBarName() {
        return netBarName;
    }

    public void setNetBarName(String netBarName) {
        this.netBarName = netBarName;
    }

    public String getBusinessRegNo() {
        return businessRegNo;
    }

    public void setBusinessRegNo(String businessRegNo) {
        this.businessRegNo = businessRegNo;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getServerVersion() {
        return serverVersion;
    }

    public void setServerVersion(String serverVersion) {
        this.serverVersion = serverVersion;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public Integer getClientTotal() {
        return clientTotal;
    }

    public void setClientTotal(Integer clientTotal) {
        this.clientTotal = clientTotal;
    }

    public String getOutsideNetwork() {
        return outsideNetwork;
    }

    public void setOutsideNetwork(String outsideNetwork) {
        this.outsideNetwork = outsideNetwork;
    }

    public String getInsideNetwork() {
        return insideNetwork;
    }

    public void setInsideNetwork(String insideNetwork) {
        this.insideNetwork = insideNetwork;
    }

    public String getServerMac() {
        return serverMac;
    }

    public void setServerMac(String serverMac) {
        this.serverMac = serverMac;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}