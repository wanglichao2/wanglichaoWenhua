package com.wenhua.server.bean;

import java.util.Date;

public class ApiResult<T> {

	// 编码：0成功；其他为错误编码
	private Integer errorCode;
	// 返回的消息：可以是成功的消息，也可以是失败的消息，成功也可以不指定
	private String message;
	// 返回的业务数据
	private T data;
	// 交易时间
	private Date time;

	/**
	 * 默认构造方法：无返回数据
	 */
	public ApiResult() {
		this.errorCode = 0;
		this.time = new Date();
	}

	/**
	 * 默认的成功返回构造方法
	 * 
	 * @param data
	 */
	public ApiResult(T data) {
		this.errorCode = 0;
		this.data = data;
		this.time = new Date();
	}

	/**
	 * 有错误信息时的构造方法
	 * 
	 * @param code
	 * @param message
	 * @param data
	 */
	public ApiResult(int code, String message, T data) {
		this.errorCode = code;
		this.message = message;
		this.data = data;
		this.time = new Date();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int code) {
		this.errorCode = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("{\"errorCode\":");
		sb.append(this.getErrorCode());
		sb.append(",");
		sb.append("\"message\":\"");
		sb.append(this.getMessage());
		sb.append("\",");
		sb.append("\"data\":\"");
		sb.append(this.getData());
		sb.append("\"");
		sb.append("}");
		return sb.toString();
	}

}
