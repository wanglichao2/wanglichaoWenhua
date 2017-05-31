package com.wenhua.util;

import com.wenhua.util.constants.SystemConstant;

public class BarIdUtils {

	/**
	 * 从网吧注册号中获取区代码
	 * @param barId
	 * @return
	 */
	public static String getAreaCode(String barId) {
		if(!isValid(barId)) return null;
		//4199190125
		String areaCode=barId.substring(0, 6);
		String headStr=areaCode.substring(0, 4);
		if(Long.valueOf(headStr)>SystemConstant.District_Head)
		return headStr+"00";
		else return areaCode;
	}
	
	/**
	 * 从网吧注册号获取市代码
	 * @param barId
	 * @return
	 */
	public static String getCityCode(String barId) {
		if(!isValid(barId)) return null;
		String headStr=barId.substring(0, 4);
		if(Long.valueOf(headStr)>SystemConstant.District_Head)
		return SystemConstant.District_Center;
		else
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
