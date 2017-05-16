package com.wenhua.util.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
	private static PropertiesUtil properties = PropertiesUtil.getInstance();

	public static String getNow() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date date = new Date();
		return sdf.format(date);
	}

	public static String getAllNow() {
		return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
	}

	public static String getFormatDate(String dateTime) {
		if (dateTime == null || "".equals(dateTime))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(sdf.parse(dateTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date getFormateDate(String dateTime) {
		if (dateTime == null || dateTime.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			return sdf.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getAllFormateDate(String dateTime){
		if (dateTime == null || dateTime.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		try {
			return sdf.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getFromateStr(String dateTime) {
		if (dateTime == null || dateTime.equals("")) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.format(sdf1.parse(dateTime));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getFormateDateToString(Date date) {
		if (date == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	public static boolean isPassTime(Date lastDate) {
		long time = new Date().getTime() - lastDate.getTime();
		Long passTime = properties.getLong("captcha.period", 2L);
		if (time < passTime * 1000 * 60) {
			return true;
		} else {
			return false;
		}
	}

	public static Long passTime(Date lastDate) {
		long time = new Date().getTime() - lastDate.getTime();
		return time;
	}
}
