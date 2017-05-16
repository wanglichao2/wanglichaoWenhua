package com.wenhua.svr.exception;

import com.wenhua.base.exception.BaseException;

public class AuthBarNotExistException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthBarNotExistException() {
		super();
	}

	public AuthBarNotExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthBarNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthBarNotExistException(String message) {
		super(message);
	}

	public AuthBarNotExistException(Throwable cause) {
		super(cause);
	}
}
