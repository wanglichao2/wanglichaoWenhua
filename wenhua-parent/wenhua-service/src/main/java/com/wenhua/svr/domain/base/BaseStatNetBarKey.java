package com.wenhua.svr.domain.base;

import java.util.Date;

public class BaseStatNetBarKey {
	private String barId;

	private Date statDate;

	public static BaseStatNetBarKey newOne(String barId, Date statDate) {
		BaseStatNetBarKey key = new BaseStatNetBarKey();
		key.setBarId(barId);
		key.setStatDate(statDate);
		return key;
	}

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public Date getStatDate() {
		return statDate;
	}

	public void setStatDate(Date statDate) {
		this.statDate = statDate;
	}
}