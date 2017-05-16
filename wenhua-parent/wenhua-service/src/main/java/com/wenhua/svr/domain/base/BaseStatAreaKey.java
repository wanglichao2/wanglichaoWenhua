package com.wenhua.svr.domain.base;

import java.util.Date;

public class BaseStatAreaKey {
    private String areaCode;

    private Date statDate;
    
    public static BaseStatAreaKey newOne(String areaCode, Date statDate) {
    	BaseStatAreaKey key = new BaseStatAreaKey();
    	key.setAreaCode(areaCode);
    	key.setStatDate(statDate);
    	return key;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getStatDate() {
        return statDate;
    }

    public void setStatDate(Date statDate) {
        this.statDate = statDate;
    }
}