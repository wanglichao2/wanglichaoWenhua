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
			body{height:auto;background:url(${basePath}/img/login-background.jpg) no-repeat center fixed;-webkit-background-size:cover;-moz-background-size:cover;-o-background-size:cover;background-size:cover;}
			form{background:rgba(255,255,255,.2);border:1px solid rgba(255,255,255,.3);-moz-box-shadow:0 3px 0 rgba(12,12,12,.03);-webkit-box-shadow:0 3px 0 rgba(12,12,12,.03);box-shadow:0 3px 0 rgba(12,12,12,.03);-moz-border-radius:3px;-webkit-border-radius:3px;border-radius:3px;padding:30px}
			.uname{background:#fff url(${basePath}/img/user.png) no-repeat 95% center;}
			.pword{background:#fff url(${basePath}/img/locked.png) no-repeat 95% center;}
			.logo-name{font-size:100px !important;}
		</style>
	</head>

	<body class="gray-bg">
    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
			<div>
				<h1 class="logo-name"><img alt="" src="" style="width: 100%;"></h1>
			</div>
            <form class="m-t" role="form">
				<h3><s:message code="sys.title" /></h3>
                <div class="form-group">
                    <input id="username" type="text" class="form-control uname" placeholder="请输入登录帐号" required="required">
                </div>
                <div class="form-group">
                    <input id="password" type="password" class="form-control pword" placeholder="请输入访问密码" required="required">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b">登 录</button>
                <p class="text-muted text-right"> <a id="clearbtn" href="#"><small>清空输入信息</small></a></p>
            </form>
        </div>
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script>
	    $(function(){
	    	var prompt = function($this, info, placement){
		    	$this.popover({
		    		html:true, placement:placement, trigger:'focus',
		    		content:'<div style="color:#a94442;">'+info+'</div>'
		    	}).popover('show');
	    	}
	    	$('button.btn').click(function(){
	    		var $this = $(this);
	    		var account = $('#username');
				if($.trim(account.val())==''){
					account.val('');
					prompt(account, '登录账号不能为空！', 'left');
					return;
				}
				var password = $('#password');
				if($.trim(password.val())==''){
					password.val('');
					prompt(password, '访问密码不能为空！', 'left');
					return;
				}
				$.ajax({
				  	type: 'post',
				  	url: '${basePath}/login/check',
				  	data: {username: account.val(), password:password.val()},
				 	dataType: 'json',
				  	success: function(data){
				  		if($.trim(data.msg)==''){
				  			window.location.href='${basePath}/work/frame';
				  		}else{
				  			prompt($this, data.msg, 'bottom');
				  		}
				  	},
				  	error: function(xhr, type){
				  		prompt($this, '服务器异常，请稍候重试！', 'bottom');
				  	}
				});
	    	});
	    	$(document).keydown(function(e){ 
	    	    var ev = document.all ? window.event : e;
	    	    if(ev.keyCode==13) {
	    	    	$('button.btn').click();
	    	    }
	    	});
	    	$('#clearbtn').click(function(){
				$('form')[0].reset();	    		
	    	});
	    });
    </script>
</body>
</html>
