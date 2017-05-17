package com.iss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.handler.inter.IExcelModel;

@Entity
@Table(name = "t_file_info")
public class FileInfoEntity extends IdEntity implements Serializable, IExcelModel {
	/**
	 * @Fields serialVersionUID : long
	 */
	private static final long serialVersionUID = 1L;

	private Long rowId;// 序号
	private String errorMsg;// 错误消息
	private String filename;// 文件名称
	private String version;// 版本号
	private String md5;//文件md5值
	private char flag;// 文件所在模块（1-服务端，2-客户端）
	private char type;// 文件类型（0-忽略，1-dll，2-exe）
	private char action;// 启用方式（0-忽略，1-加载dll，2-运行exe）
	private char isApply;// 是否应用到所有网吧0-是，1-否
	private Integer status;//状态(1:有效；0:无效)
	private byte[] data;// 文件二进制数组
	private Long creator;// 创建人
	private Date createTime;// 创建时间
	private Long lastModifier;// 最后修改人
	private Date lastModifyTime;// 最后修改时间
	
	private String netbarIds;//接收页面选择的网吧ID
	private String netbarNames;//返回至页面

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}

	public char getFlag() {
		return flag;
	}

	public void setFlag(char flag) {
		this.flag = flag;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	public char getAction() {
		return action;
	}

	public void setAction(char action) {
		this.action = action;
	}

	@Column(name = "is_apply")
	public char getIsApply() {
		return isApply;
	}

	public void setIsApply(char isApply) {
		this.isApply = isApply;
	}

	@Lob   
    //@Basic(fetch=FetchType.LAZY)   
    @Column(name="data", columnDefinition="LONGBLOB", nullable=true)  
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Long getCreator() {
		return creator;
	}

	public void setCreator(Long creator) {
		this.creator = creator;
	}

	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "last_modifier")
	public Long getLastModifier() {
		return lastModifier;
	}

	public void setLastModifier(Long lastModifier) {
		this.lastModifier = lastModifier;
	}

	@Column(name = "last_modify_time")
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Transient
	public String getNetbarIds() {
		return netbarIds;
	}

	public void setNetbarIds(String netbarIds) {
		this.netbarIds = netbarIds;
	}

	@Transient
	public String getNetbarNames() {
		return netbarNames;
	}

	public void setNetbarNames(String netbarNames) {
		this.netbarNames = netbarNames;
	}

}
