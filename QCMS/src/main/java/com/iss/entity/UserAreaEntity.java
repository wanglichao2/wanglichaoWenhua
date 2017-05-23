package com.iss.entity;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="t_user_area")
public class UserAreaEntity extends IdEntity {

	private Long userId;
	private String areaCode;
	private String districtCode;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	 
	
	
	

}
