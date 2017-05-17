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

/** 
 * 缺陷管理实体
 */
@Entity
@Table(name="t_qc_defect")
public class DefectEntity extends IdEntity implements Serializable, IExcelModel{
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	@Excel(name="注释", orderNum="29")
	private String zs;//注释
	@Excel(name="主题", orderNum="2")
	private String zt;//主题
	@Excel(name="标题", orderNum="3")
	private String bt;//标题
	@Excel(name="测试阶段", orderNum="4")
	private String csjd;//测试阶段
	@Excel(name="发现人", orderNum="5")
	private String fxr;//发现人
	@Excel(name="发现日期", orderNum="6", exportFormat="yyyy/MM/dd")
	private Timestamp fxrq;//发现日期
	@Excel(name="分配给", orderNum="7")
	private String fpg;//分配给
	@Excel(name="估计修复时间", orderNum="8", exportFormat="yyyy/MM/dd HH:mm")
	private Timestamp gjxfsj;//估计修复时间
	@Excel(name="关闭日期", orderNum="9", exportFormat="yyyy/MM/dd HH:mm")
	private Timestamp gbrq;//关闭日期
	@Excel(name="关闭于版本", orderNum="10")
	private String gbybb;//关闭于版本
	@Excel(name="计划关闭版本", orderNum="11")
	private String jhgbbb;//计划关闭版本
	@Excel(name="计划修复日期", orderNum="12", exportFormat="yyyy/MM/dd HH:mm")
	private Timestamp jhxfrq;//计划修复日期
	@Excel(name="检测于版本", orderNum="13")
	private String jcybb;//检测于版本
	@Excel(name="检测于发布", orderNum="14")
	private String jcyfb;//检测于发布
	@Excel(name="检测于周期", orderNum="15")
	private String jcyzq;//检测于周期
	@Excel(name="可重现", orderNum="16")
	private String kcx;//可重现
	@Excel(name="描述", orderNum="17")
	private String ms;//描述
	@Excel(name="目标发布", orderNum="18")
	private String mbfb;//目标发布
	@Excel(name="目标周期", orderNum="19")
	private String mbzq;//目标周期
	@Excel(name="取消或拒绝理由", orderNum="20")
	private String qxhjjly;//取消或拒绝理由
	@Excel(name="缺陷ID", orderNum="21")
	private String qxid;//缺陷ID
	@Excel(name="缺陷类别", orderNum="22")
	private String qxlb;//缺陷类别
	@Excel(name="缺陷状态", orderNum="23")
	private String qxzt;//缺陷状态
	@Excel(name="实际修复时间", orderNum="24", exportFormat="yyyy/MM/dd HH:mm")
	private Timestamp sjxfsj;//实际修复时间
	@Excel(name="项目", orderNum="25")
	private String xm;//项目
	@Excel(name="修改日期", orderNum="26", exportFormat="yyyy/MM/dd HH:mm")
	private Timestamp xgrq;//修改日期
	@Excel(name="严重度", orderNum="27")
	private String yzd;//严重度
	@Excel(name="优先级", orderNum="28")
	private String yxj;//优先级
	@Excel(name="状态", orderNum="30")
	private String sjzt;//数据状态
	private String ylid;//关联用例ID
	private Boolean status=true;//是否显示 true：是；false：否
	private Timestamp createTime;//创建时间
	private Long rowId;//序号
	private String errorMsg;//错误消息
	
	public String getZs() {
		return zs;
	}
	public void setZs(String zs) {
		this.zs = zs;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getBt() {
		return bt;
	}
	public void setBt(String bt) {
		this.bt = bt;
	}
	public String getCsjd() {
		return csjd;
	}
	public void setCsjd(String csjd) {
		this.csjd = csjd;
	}
	public String getFxr() {
		return fxr;
	}
	public void setFxr(String fxr) {
		this.fxr = fxr;
	}
	public Timestamp getFxrq() {
		return fxrq;
	}
	public void setFxrq(Timestamp fxrq) {
		this.fxrq = fxrq;
	}
	public String getFpg() {
		return fpg;
	}
	public void setFpg(String fpg) {
		this.fpg = fpg;
	}
	public Timestamp getGjxfsj() {
		return gjxfsj;
	}
	public void setGjxfsj(Timestamp gjxfsj) {
		this.gjxfsj = gjxfsj;
	}
	public Timestamp getGbrq() {
		return gbrq;
	}
	public void setGbrq(Timestamp gbrq) {
		this.gbrq = gbrq;
	}
	public String getGbybb() {
		return gbybb;
	}
	public void setGbybb(String gbybb) {
		this.gbybb = gbybb;
	}
	public String getJhgbbb() {
		return jhgbbb;
	}
	public void setJhgbbb(String jhgbbb) {
		this.jhgbbb = jhgbbb;
	}
	public Timestamp getJhxfrq() {
		return jhxfrq;
	}
	public void setJhxfrq(Timestamp jhxfrq) {
		this.jhxfrq = jhxfrq;
	}
	public String getJcybb() {
		return jcybb;
	}
	public void setJcybb(String jcybb) {
		this.jcybb = jcybb;
	}
	public String getJcyfb() {
		return jcyfb;
	}
	public void setJcyfb(String jcyfb) {
		this.jcyfb = jcyfb;
	}
	public String getJcyzq() {
		return jcyzq;
	}
	public void setJcyzq(String jcyzq) {
		this.jcyzq = jcyzq;
	}
	public String getKcx() {
		return kcx;
	}
	public void setKcx(String kcx) {
		this.kcx = kcx;
	}
	public String getMs() {
		return ms;
	}
	public void setMs(String ms) {
		this.ms = ms;
	}
	public String getMbfb() {
		return mbfb;
	}
	public void setMbfb(String mbfb) {
		this.mbfb = mbfb;
	}
	public String getMbzq() {
		return mbzq;
	}
	public void setMbzq(String mbzq) {
		this.mbzq = mbzq;
	}
	public String getQxhjjly() {
		return qxhjjly;
	}
	public void setQxhjjly(String qxhjjly) {
		this.qxhjjly = qxhjjly;
	}
	public String getQxid() {
		return qxid;
	}
	public void setQxid(String qxid) {
		this.qxid = qxid;
	}
	public String getQxlb() {
		return qxlb;
	}
	public void setQxlb(String qxlb) {
		this.qxlb = qxlb;
	}
	public String getQxzt() {
		return qxzt;
	}
	public void setQxzt(String qxzt) {
		this.qxzt = qxzt;
	}
	public Timestamp getSjxfsj() {
		return sjxfsj;
	}
	public void setSjxfsj(Timestamp sjxfsj) {
		this.sjxfsj = sjxfsj;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public Timestamp getXgrq() {
		return xgrq;
	}
	public void setXgrq(Timestamp xgrq) {
		this.xgrq = xgrq;
	}
	public String getYzd() {
		return yzd;
	}
	public void setYzd(String yzd) {
		this.yzd = yzd;
	}
	public String getYxj() {
		return yxj;
	}
	public void setYxj(String yxj) {
		this.yxj = yxj;
	}
	public String getSjzt() {
		return sjzt;
	}
	public void setSjzt(String sjzt) {
		this.sjzt = sjzt;
	}
	public String getYlid() {
		return ylid;
	}
	public void setYlid(String ylid) {
		this.ylid = ylid;
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
