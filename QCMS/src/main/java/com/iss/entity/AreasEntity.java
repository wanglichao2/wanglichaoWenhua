package com.iss.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="t_areas_code")
public class AreasEntity {

	private String areasid;
	
	private String areasname;
	
	private char rankno;
	
	private String parentId;

	@Id
	@Column(name="areasid", nullable=false)
	public String getAreasid() {
		return areasid;
	}

	public void setAreasid(String areasid) {
		this.areasid = areasid;
	}

	public String getAreasname() {
		return areasname;
	}

	public void setAreasname(String areasname) {
		this.areasname = areasname;
	}

	public char getRankno() {
		return rankno;
	}

	public void setRankno(char rankno) {
		this.rankno = rankno;
	}

	@Transient
	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
