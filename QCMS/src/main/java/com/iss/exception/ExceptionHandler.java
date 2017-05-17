package com.iss.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * spring mvc异常捕获类
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {

	private Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
	
	/**
	 * 异常拦截方法
	 * 
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex 异常
	 * @return
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, java.lang.Object,
	 *      java.lang.Exception)
	 */
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		logger.error(ex.getMessage());
		ModelAndView model = new ModelAndView("/error/error");  
		model.addObject("ex", ex);
		ex.printStackTrace();
		return model;
	}
}
