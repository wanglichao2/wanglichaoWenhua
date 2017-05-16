package com.wenhua.svr.exception;

import com.wenhua.base.exception.BaseException;

public class AuthSignNotValidException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthSignNotValidException() {
		super();
	}

	public AuthSignNotValidException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthSignNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthSignNotValidException(String message) {
		super(message);
	}

	public AuthSignNotValidException(Throwable cause) {
		super(cause);
	}
}
