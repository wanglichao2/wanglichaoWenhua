package com.wenhua.svr.domain;

import java.io.UnsupportedEncodingException;

import com.wenhua.util.tools.Md5Util;

/**
 * 网吧认证信息
 * 
 * @author zhuzhaohua
 *
 */
public class BarAuthInfo {

	private String barId;
	private String when;
	private String sign;
	
	/**
	 * 检查sign与网吧信息是否合法
	 * @param key
	 * @return
	 */
	public boolean isValid(String key) {
		
		if(null == getSign() || 0 == getSign().length()) {
			return false;
		}
		String targetMD5 = getMD5(barId, when, key);
		
		if(!getSign().equals(targetMD5)) {
			return false;
		}
		return true;
	}

	public static String getMD5(String barId, String when, String key) {
		String targetMD5 = Md5Util.getMD5HexString(getByteArray(barId, when, key));
		return targetMD5.toUpperCase();
	}
	
	/**
	 * 计算签名信息
	 * @param barId
	 * @param when
	 * @param key
	 * @return
	 */
	public static byte[] getByteArray(String barId, String when, String key) {
		
		if(null == barId || null == when || null == key) {
			return null;
		}
		
		String target = barId + when + key;
		
		try {
			return target.getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public BarAuthInfo(String barId, String when, String sign) {
		super();
		this.barId = barId;
		this.when = when;
		this.sign = sign;
	}

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
