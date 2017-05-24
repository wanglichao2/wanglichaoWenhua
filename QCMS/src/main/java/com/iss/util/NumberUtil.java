package com.iss.util;

import java.math.BigDecimal;
import java.util.Objects;


/**
 * 数字类型转换处理类
 */
public class NumberUtil {
	/**
	 * Integer 类型转换
	 * @return
	 */
	public static Integer toInteger(Object obj) {
		if(obj == null) return null;
		return Integer.valueOf(Objects.toString(obj));
	}
	/**
	 * Long 类型转换
	 * @return
	 */
	public static Long toLong(Object obj) {
		if(obj == null) return null;
		return Long.valueOf(Objects.toString(obj));
	}
	/**
	 * Float 类型转换
	 * @return
	 */
	public static Float toFloat(Object obj) {
		if(obj == null) return null;
		return Float.valueOf(Objects.toString(obj));
	}
	/**
	 * Double 类型转换
	 * @return
	 */
	public static Double toDouble(Object obj) {
		if(obj == null) return null;
		return Double.valueOf(Objects.toString(obj));
	}
	/**
	 * BigDecimal 类型转换
	 * @return
	 */
	public static BigDecimal toDecimal(Object obj) {
		if(obj == null) return null;
		return new BigDecimal(Objects.toString(obj));
	}
	
	public static String parseDoubleToString(Double l, Integer scale) {
		if (l == null)
			return "";
		StringBuffer format = new StringBuffer("#0");
		if (scale != null && scale > 0) {
			format.append(".");
			for (int i = 0; i < scale; i++)
				format.append("0");
		}
		java.text.DecimalFormat df = new java.text.DecimalFormat(format.toString());
		return df.format(l);
	}
}
