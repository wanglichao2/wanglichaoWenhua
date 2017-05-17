/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-15
 * @version: 1.0
 */
package com.iss.exception;

/**
 * 自定义异常类
 */
public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
