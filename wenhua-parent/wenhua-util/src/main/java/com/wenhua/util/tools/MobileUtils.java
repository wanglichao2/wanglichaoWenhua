package com.wenhua.util.tools;

/**
 * 手机号码工具类
 * @author zhuzhaohua
 *
 */
public class MobileUtils {

	private static final String cm = "^((13[4-9])|(147)|(15[0-2,7-9])|(18[2-3,7-8]))\\d{8}$";
	private static final String cu = "^((13[0-2])|(145)|(15[5-6])|(186))\\d{8}$";
	private static final String ct = "^((133)|(153)|(18[0,9]))\\d{8}$";
	
	private static final String mobile = "^1[3|4|5|7|8][0-9]\\d{8}$";
	
	/**
	 * 检查号码所属运营商
	 * @param phoneNumber
	 * @return
	 */
	public static Provider matchesPhoneNumber(String phoneNumber) {

		Provider flag = null;
		if (phoneNumber.matches(cm)) {
			flag = Provider.CMCC;
		} else if (phoneNumber.matches(cu)) {
			flag = Provider.CUCC;
		} else if (phoneNumber.matches(ct)) {
			flag = Provider.CTCC;
		} else {
			flag = Provider.UNKOWN;
		}
		return flag;
	}
	
	/**
	 * 检查是否是正确的国内手机号
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isMobile(String mobileNumber) {
		if(mobileNumber.matches(mobile)) {
			return true;
		}
		return false;
	}

}
