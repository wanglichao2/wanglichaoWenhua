package com.wenhua.svr.exception;

import com.wenhua.base.exception.BaseException;

public class FileNotExistException extends BaseException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileNotExistException() {
		super();
	}

	public FileNotExistException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileNotExistException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileNotExistException(String message) {
		super(message);
	}

	public FileNotExistException(Throwable cause) {
		super(cause);
	}
}
