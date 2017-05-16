package com.wenhua.svr.domain;

/**
 * 网吧配置信息
 * @author zhuzhaohua
 *
 */
public class BarConfig {

	/** 上传频率 单位 秒 */
	private int freqInstantPcInfo;

	public int getFreqInstantPcInfo() {
		return freqInstantPcInfo;
	}

	/**
	 * 设置网吧上传频率 单位 秒
	 * @param freqInstantPcInfo
	 */
	public void setFreqInstantPcInfo(int freqInstantPcInfo) {
		this.freqInstantPcInfo = freqInstantPcInfo;
	}
	
}
