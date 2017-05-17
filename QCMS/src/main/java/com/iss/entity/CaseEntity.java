/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.handler.inter.IExcelModel;
import org.springframework.format.annotation.DateTimeFormat;

/** 
 * 缺陷管理实体
 */
@Entity
@Table(name="t_qc_case")
public class CaseEntity extends IdEntity implements Serializable, IExcelModel{
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name="更改状态", orderNum="1")
	private String ggzt;//更改状态
	@Excel(name="注释", orderNum="29")
	private String zs;//注释
	@Excel(name="创建日期", orderNum="3", exportFormat="yyyy/MM/dd")
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Timestamp cjrq;//创建日期
	@Excel(name="用例描述", orderNum="4")
	private String ylms;//用例描述
	@Excel(name="设计者", orderNum="5")
	private String sjz;//设计者
	@Excel(name="估计开发时间", orderNum="6", exportFormat="yyyy/MM/dd HH:mm")
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
	private Timestamp gjkfsj;//估计开发时间
	@Excel(name="执行状态", orderNum="7")
	private String zxzt;//执行状态
	@Excel(name="修改时间", orderNum="8", exportFormat="yyyy/MM/dd HH:mm")
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm")
	private Timestamp xgsj;//修改时间
	@Excel(name="路径", orderNum="9")
	private String lj;//路径
	@Excel(name="状态", orderNum="10")
	private String sjzt;//数据状态
	@Excel(name="主题", orderNum="11")
	private String zt;//主题
	@Excel(name="模板", orderNum="12")
	private String mb;//模板
	@Excel(name="测试ID", orderNum="13")
	private String csid;//测试ID
	@Excel(name="用例名称", orderNum="14")
	private String csmc;//用例名称
	@Excel(name="类型", orderNum="15")
	private String lx;//类型
	@Excel(name="测试模式", orderNum="16")
	private String csms;//测试模式
	@Excel(name="测试数据", orderNum="17")
	private String cssj;//测试数据
	@Excel(name="测试用例编号", orderNum="18")
	private String csylbh;//测试用例编号
	@Excel(name="测试用例状态", orderNum="19")
	private String csylzt;//测试用例状态
	@Excel(name="工作模式", orderNum="20")
	private String gzms;//工作模式
	@Excel(name="前置条件", orderNum="21")
	private String qztj;//前置条件
	@Excel(name="涉及的关联系统", orderNum="22")
	private String sjdglxt;//涉及的关联系统
	@Excel(name="审阅状态", orderNum="23")
	private String syzt;//审阅状态
	@Excel(name="所属子系统", orderNum="24")
	private String sszxt;//所属子系统
	@Excel(name="协议类型", orderNum="25")
	private String xylx;//协议类型
	@Excel(name="用例复用状态", orderNum="26")
	private String ylfyzt;//用例复用状态
	@Excel(name="用例性质", orderNum="27")
	private String ylxz;//用例性质
	@Excel(name="优先级", orderNum="28")
	private String yxj;//优先级
	private Boolean status=true;//是否显示 true：是；false：否
	private Timestamp createTime;//创建时间
	private Long rowId;//序号
	private String errorMsg;//错误消息
	
	public String getGgzt() {
		return ggzt;
	}
	public void setGgzt(String ggzt) {
		this.ggzt = ggzt;
	}
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public Timestamp getCjrq() {
		return cjrq;
	}
	public void setCjrq(Timestamp cjrq) {
		this.cjrq = cjrq;
	}
	public String getYlms() {
		return ylms;
	}
	public void setYlms(String ylms) {
		this.ylms = ylms;
	}
	public String getSjz() {
		return sjz;
	}
	public void setSjz(String sjz) {
		this.sjz = sjz;
	}
	public Timestamp getGjkfsj() {
		return gjkfsj;
	}
	public void setGjkfsj(Timestamp gjkfsj) {
		this.gjkfsj = gjkfsj;
	}
	public String getZxzt() {
		return zxzt;
	}
	public void setZxzt(String zxzt) {
		this.zxzt = zxzt;
	}
	public Timestamp getXgsj() {
		return xgsj;
	}
	public void setXgsj(Timestamp xgsj) {
		this.xgsj = xgsj;
	}
	public String getLj() {
		return lj;
	}
	public void setLj(String lj) {
		this.lj = lj;
	}
	public String getSjzt() {
		return sjzt;
	}
	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getMb() {
		return mb;
	}
	public void setMb(String mb) {
		this.mb = mb;
	}
	public String getCsid() {
		return csid;
	}
	public void setCsid(String csid) {
		this.csid = csid;
	}
	public String getCsmc() {
		return csmc;
	}
	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}
	public String getLx() {
		return lx;
	}
	public void setLx(String lx) {
		this.lx = lx;
	}
	public String getCsms() {
		return csms;
	}
	public void setCsms(String csms) {
		this.csms = csms;
	}
	public String getCssj() {
		return cssj;
	}
	public void setCssj(String cssj) {
		this.cssj = cssj;
	}
	public String getCsylbh() {
		return csylbh;
	}
	public void setCsylbh(String csylbh) {
		this.csylbh = csylbh;
	}
	public String getCsylzt() {
		return csylzt;
	}
	public void setCsylzt(String csylzt) {
		this.csylzt = csylzt;
	}
	public String getGzms() {
		return gzms;
	}
	public void setGzms(String gzms) {
		this.gzms = gzms;
	}
	public String getQztj() {
		return qztj;
	}
	public void setQztj(String qztj) {
		this.qztj = qztj;
	}
	public String getSjdglxt() {
		return sjdglxt;
	}
	public void setSjdglxt(String sjdglxt) {
		this.sjdglxt = sjdglxt;
	}
	public String getSyzt() {
		return syzt;
	}
	public void setSyzt(String syzt) {
		this.syzt = syzt;
	}
	public String getSszxt() {
		return sszxt;
	}
	public void setSszxt(String sszxt) {
		this.sszxt = sszxt;
	}
	public String getXylx() {
		return xylx;
	}
	public void setXylx(String xylx) {
		this.xylx = xylx;
	}
	public String getYlfyzt() {
		return ylfyzt;
	}
	public void setYlfyzt(String ylfyzt) {
		this.ylfyzt = ylfyzt;
	}
	public String getYlxz() {
		return ylxz;
	}
	public void setYlxz(String ylxz) {
		this.ylxz = ylxz;
	}
	public String getYxj() {
		return yxj;
	}
	public void setYxj(String yxj) {
		this.yxj = yxj;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
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
