package com.wenhua.svr.exception;

public class AuthBarNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AuthBarNotValidException() {
		super();
	}

	public AuthBarNotValidException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public AuthBarNotValidException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthBarNotValidException(String message) {
		super(message);
	}

	public AuthBarNotValidException(Throwable cause) {
		super(cause);
	}
}
