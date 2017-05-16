package com.wenhua.svr.exception;

import com.wenhua.base.exception.BaseException;

public class AccountNameExistException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNameExistException() {
		super();
	}

	public AccountNameExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AccountNameExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountNameExistException(String message) {
		super(message);
	}

	public AccountNameExistException(Throwable cause) {
		super(cause);
	}
}
