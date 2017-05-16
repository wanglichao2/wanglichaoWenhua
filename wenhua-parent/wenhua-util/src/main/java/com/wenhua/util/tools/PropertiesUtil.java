package com.wenhua.util.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Properties;

public class PropertiesUtil implements Serializable {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final long serialVersionUID = 1L;

	private static PropertiesUtil instance = null;
	private Properties props = null;
	private static String classPath = "config.properties";

	/**
	 * 获取PropertiesUtil实例
	 * 
	 * @return
	 */
	public static PropertiesUtil getInstance() {
		if (instance == null)
			instance = new PropertiesUtil();
		return instance;
	}

	private PropertiesUtil() {
		refresh();
	}

	/*
	 * 装载properties文件
	 */
	private void refresh() {
		try {
			props = new Properties(); 
			props.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(classPath));
		} catch (Exception e) {
			logger.error("refresh properties 文件失败!", e.getMessage());
		}
	}

	/**
	 * 跟据properties文件中的key值获取相对应的val值
	 * 
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return props.getProperty(key);
	}

    public String getString(String key, String defaultValue) {
        if (!props.containsKey(key)) {
            return defaultValue;
        }
        String stringValue = props.getProperty(key);
        if (stringValue == null || (stringValue = stringValue.trim()).length() == 0) {
            return defaultValue;
        }
        return stringValue;
    }

    public BigDecimal getBigDecimal(String key, BigDecimal defaultVal) {
        String stringValue = getString(key, null);
        return stringValue == null ? defaultVal : new BigDecimal(stringValue);
    }

    public Integer getInt(String key, Integer defaultVal) {
        String stringValue = getString(key, null);
        return stringValue == null ? defaultVal : Integer.valueOf(stringValue);
    }

    public Long getLong(String key, Long defaultVal) {
        String stringValue = getString(key, null);
        return stringValue == null ? defaultVal : Long.valueOf(stringValue);
    }
}