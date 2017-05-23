package com.iss.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class CommonUtil {
	

	
	/**
	 * 判断空值
	 * 
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		if (null == obj) {
			return true;
		}
		if (obj instanceof String) {
			String s = (String) obj;
			return s.trim().length() == 0 || "null".equals(s) || "NULL".equals(s) || "undefined".equals(s);
		}
		if (obj.getClass().isArray()) {
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof Collection) {
			@SuppressWarnings("rawtypes")
			Collection c = (Collection) obj;
			return c.isEmpty();
		}
		if (obj instanceof Map) {
			@SuppressWarnings("rawtypes")
			Map m = (Map) obj;
			return m.isEmpty();
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
}
