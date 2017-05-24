package com.iss.vo.param;

public class DeployInfo {

	private String netbarCode;
	private String is_deploy; //是否实施--0：实施 1：未实施
	private String detectNum;//检测数--已安装终端
	private String installNum;//安装数--已安装终端
	private String onlineNum;//在线数--在线终端数
	private String reportTime;//上报日期--年月日
	
	
	public String getNetbarCode() {
		return netbarCode;
	}
	public void setNetbarCode(String netbarCode) {
		this.netbarCode = netbarCode;
	}
	public String getIs_deploy() {
		return is_deploy;
	}
	public void setIs_deploy(String is_deploy) {
		this.is_deploy = is_deploy;
	}
	public String getDetectNum() {
		return detectNum;
	}
	public void setDetectNum(String detectNum) {
		this.detectNum = detectNum;
	}
	public String getInstallNum() {
		return installNum;
	}
	public void setInstallNum(String installNum) {
		this.installNum = installNum;
	}
	public String getOnlineNum() {
		return onlineNum;
	}
	public void setOnlineNum(String onlineNum) {
		this.onlineNum = onlineNum;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	
	
}
