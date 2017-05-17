<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title><s:message code="sys.title" /></title>
		<meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="renderer" content="webkit">
		<c:set var="basePath" value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${basePath}/css/font-awesome.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
	</head>

	<body class="gray-bg">
	    <div class="middle-box text-center animated fadeInDown">
	        <h1>ERROR</h1>
	        <h3 class="font-bold">程序出错了！</h3>
	        <div class="error-desc">请联系我们的管理员吧...
	            <br/>您可以返回主页看看
	            <br/><a href="${basePath}/work/home" class="btn btn-white m-t">主页</a>
	        </div>
	        <div style="display: none;">
	        	<% Exception e = (Exception)request.getAttribute("ex"); %>
				<H3>错误异常: <%= e.getClass().getSimpleName()%></H3>
				<hr />
				<P>错误描述：</P>
				<%= e.getMessage()%>
				<P>错误信息：</P>
				<% e.printStackTrace(new java.io.PrintWriter(out)); %>
	        </div>
	    </div>
	    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
	    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
	</body>
</html>