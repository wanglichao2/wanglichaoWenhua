package com.iss.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.handler.inter.IExcelModel;

@Entity
@Table(name = "t_file_bar")
public class FileBarEntity extends IdEntity implements Serializable, IExcelModel {
	/**
	 * @Fields serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	private Long rowId;// 序号
	private String errorMsg;// 错误消息
	private Long fileId;//文件ID
	private String barid;//网吧ID

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	public String getBarid() {
		return barid;
	}

	public void setBarid(String barid) {
		this.barid = barid;
	}

	@Transient
	public Long getRowId() {
		return rowId;
	}

	public void setRowId(Long rowId) {
		this.rowId = rowId;
	}

	@Override
	@Transient
	public String getErrorMsg() {
		return errorMsg;
	}

	@Override
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
