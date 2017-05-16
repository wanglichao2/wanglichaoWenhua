package com.wenhua.svr.domain.base;

import com.wenhua.svr.base.domain.AbstractEntity;
import java.util.Date;

/**
 * 账户信息
 * @author zhuzhaohua
 *
 */
public class BaseAccount extends AbstractEntity<Long, BaseAccount> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String accountName;

    private String pwd;

    private String lastLoginIp;

    private Date lastLoginTime;

    private Boolean isDeleted;

    private Date createdTime;

    private Date lastModifiedTime;
    
    public Long getId() {
    	return super.getId();
    }
    
    public void setId(Long id) {
    	super.setId(id);
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }
}