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
		<link rel="stylesheet" href="${basePath}/css/bootstrap.min.css">
		<link rel="stylesheet" href="${basePath}/css/font-awesome.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
		<style type="text/css">
			body {
			    height: auto;
			    background: url("${basePath}/img/info.jpg") no-repeat center fixed;
			    -webkit-background-size: cover;
			    -moz-background-size: cover;
			    -o-background-size: cover;
			    background-size: cover;
			}
			.dashboard-header{
				background-color: transparent;
			}
		</style>
	</head>

	<body class="gray-bg">
    <div class="row white-bg dashboard-header">
        <div class="col-sm-12 text-center">
        	<br /><br /><br />
            <h2>我们正在努力建设中...</h2>
            <h1>敬请期待！</h1>
        </div>
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${basePath}/js/layer/layer.min.js"></script>
    <script src="${basePath}/js/content.min.js"></script>
</body>
</html>
