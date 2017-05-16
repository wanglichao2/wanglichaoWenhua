package com.wenhua.util.tools;

public class CheckCodeUtil {
	public static Integer getCheckCode() {
		Integer code = (int) (Math.random() * 9000 + 1000);
		return code;
	}
}
