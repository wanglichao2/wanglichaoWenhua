package com.wenhua.util.tools;

import com.google.common.base.Strings;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 根据日期字符串串获取日期对象 默认格式yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static Date getDate(String date) {
		return getDate(date, null);
	}
	
	/**
	 * 根据日期字符串与日期格式字符串获取日期对象
	 * @param date    日期字符串
	 * @param format  日期格式字符串
	 * @return
	 */
	public static Date getDate(String date, String format) {
        if (Strings.isNullOrEmpty(date)) return null;
        if (Strings.isNullOrEmpty(format)) {
            format = DATE_TIME_FORMAT;
        }
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date target = null;
		try {
			target = sdf.parse(date);
		} catch (ParseException e) {

		}
		return target;
	}
	
	/**
	 * 将时间格式化为默认格式 yyyy-MM-dd HH:mm:ss
	 * @param date
	 * @return
	 */
	public static String getString(Date date) {
		return getString(date, null);
	}
	
	/**
	 * 将时间格式化为制定格式
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getString(Date date, String format) {
		if(null == date) return null;
		if(null == format) format = DATE_TIME_FORMAT;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 计算end - begin 的时间差
	 * @param begin
	 * @param end
	 * @return
	 */
	public static long getTimeInterval(Date end, Date begin) {
		if(null == begin || null == end) return 0;
		return end.getTime() - begin.getTime();
	}
	
	/**
	 * 计算end - begin 的天数差
	 * @param end
	 * @param begin
	 * @return
	 */
	public static long getDayInterval(Date end, Date begin) {
		
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
			begin=sdf.parse(sdf.format(begin));  
			end=sdf.parse(sdf.format(end));  
			Calendar cal = Calendar.getInstance();    
			cal.setTime(begin);    
			long time1 = cal.getTimeInMillis();                 
			cal.setTime(end);    
			long time2 = cal.getTimeInMillis();         
			long between_days=(time2-time1)/(1000*3600*24);  
			    
      return Integer.parseInt(String.valueOf(between_days));
		} catch (NumberFormatException e) {
			return 0;
		} catch (ParseException e) {
			return 0;
		}       
	}
	
	/**
	 * 生日日期获取年龄
	 * @param birthday
	 * @return
	 */
	public static int getAge(Date birthday) {
		if(null == birthday) return 0;
		
		Calendar now = Calendar.getInstance();
		Calendar bir = Calendar.getInstance();
		bir.setTimeInMillis(birthday.getTime());
		
		return now.get(Calendar.YEAR) - bir.get(Calendar.YEAR);
	}
	
	/**
	 * 获取中国（东8区）今天的日期 例如: 2017-04-01
	 * @return
	 */
	public static Date getChinaDay() {
		return getChinaDay(0);
	}
	
	/**
	 * 获取中国（东8区）与当天相差 diff 天的日期 例如: 2017-04-01
	 * @param diff 与今天相差的天数
	 * @return
	 */
	public static Date getChinaDay(int diff) {
		long now = System.currentTimeMillis();
		long day = 24 * 60 * 60 * 1000;
		long today = now - (now % day) - (8 * 60 * 60 *1000 ) + (diff * (24 * 60 * 60 * 1000));
		return new Date(today);
	}
	
	private DateUtils() {}
}