package com.wenhua.util;

public class BarIdUtils {

	/**
	 * 从网吧注册号中获取区代码
	 * @param barId
	 * @return
	 */
	public static String getAreaCode(String barId) {
		if(!isValid(barId)) return null;
		return barId.substring(0, 6);
	}
	
	/**
	 * 从网吧注册号获取市代码
	 * @param barId
	 * @return
	 */
	public static String getCityCode(String barId) {
		if(!isValid(barId)) return null;
		return barId.substring(0, 4) + "00";
	}
	
	/**
	 * 从网吧注册号获取省代码
	 * @param barId
	 * @return
	 */
	public static String getProvinceCode(String barId) {
		if(!isValid(barId)) return null;
		return barId.substring(0, 2) + "0000";
	}
	
	/**
	 * 检验网吧注册号是否合法
	 * @param barId
	 * @return
	 */
	public static boolean isValid(String barId) {
		
		if(null == barId || 10 != barId.length()) return false;
		
		return true;
	}
}
