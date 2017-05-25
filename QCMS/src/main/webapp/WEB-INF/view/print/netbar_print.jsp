<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%> 

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
		<link rel="stylesheet" href="${basePath}/css/dataTables/dataTables.bootstrap.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/dataTables/fixedColumns.bootstrap.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-editable/bootstrap-editable.css"/>
		<link rel="stylesheet" href="${basePath}/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-dialog/bootstrap-dialog.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/select2/select2.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/select2/select2-bootstrap.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/uniform/uniform.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/webuploader/webuploader.css" />
		<link rel="stylesheet" href="${basePath}/css/blueimp/css/blueimp-gallery.min.css" />
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
		<style type="text/css">.modal-lg .modal-body{padding: 0 !important;min-height:400px;}.lightBoxGallery img {margin:5px;width:160px;}
		.tabs-container .tab-pane .panel-body{border:none;}</style>
	</head>
	<style type="text/css"> 
			.showgz{font-weight:bold;
					width:160px;height: 159px;
					background:url(${basePath}/img/2017052418362911.jpg) no-repeat ;
					-webkit-background-size:cover;
					-moz-background-size:cover;
					-o-background-size:cover;
					background-size:cover;}
			/* form{background:rgba(255,255,255,.2);border:1px solid rgba(255,255,255,.3);-moz-box-shadow:0 3px 0 rgba(12,12,12,.03);-webkit-box-shadow:0 3px 0 rgba(12,12,12,.03);box-shadow:0 3px 0 rgba(12,12,12,.03);-moz-border-radius:3px;-webkit-border-radius:3px;border-radius:3px;padding:30px}
			.uname{background:#fff url(${basePath}/img/user.png) no-repeat 95% center;}
			.pword{background:#fff url(${basePath}/img/locked.png) no-repeat 95% center;}
			.logo-name{font-size:100px !important;} */
		</style>
<body>
	<table align="center" style="width:90%;">
		<tr>
			<td colspan="2" align="center"><h1>哨矮兵经营管理技术监管措施确认单</h1></td>
		</tr>
		<tr>
			<td colspan="2" style="height: 20px;"></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经河南睿网公司客服远程查看确认，
			<!-- </td><td style="width:60%;border-bottom: 1px solid;"> -->
			<a style="text-decoration: underline;">${netbar.barName}</a>
			（注册号：<a style="text-decoration: underline;">${netbar.approvalNum}</a>）
			</td>
		</tr>
		<tr>
			<td colspan="2">已经安装文化技术监管措施（矮哨兵文化监管平台），服务器正常在线，客户端安装率为：<a style="text-decoration: underline;">${netbar.installRate}%</a>已达到合格合格标准</td>
		</tr>
		<tr>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border="1">
					<thead>
					<tr align="center">
						<td>地区名称</td>
						<td>网吧名称</td>
						<td style="width:80px;">终端总数(个)</td>
						<td style="width:70px;">在线(个)</td>
						<td style="width:80px;">不在线(个)</td>
						<td style="width:80px;">已安装终端(个)</td>
						<td style="width:80px;">未安装终端(个)</td>
						<td style="width:80px;">在线率</td>
						<td style="width:80px;">安装率</td>
						<td style="width:120px;">数据上报时间</td>
					</tr>
					</thead>
					<tbody>
					<tr align="center">
						<td>${netbar.regAddress}</td>
						<td align="center">${netbar.barName}(${netbar.approvalNum})</td>
						<td>${netbar.zdzs}</td>
						<td>${netbar.onLineCount}</td>
						<td>${netbar.offLineCount}</td>
						<td>${netbar.installNum}</td>
						<td>${netbar.unInstallNum}</td>
						<td>${netbar.onLineRate}%</td>
						<td>${netbar.installRate}%</td>
						<td>${netbar.uploadTime}</td>
					</tr>
					</tbody>
				</table>
			</td>
		</tr>
		<tr>
			<td  colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right" >
				<div style="position:relative">
				   <img alt="" src="${basePath}/img/2017052418362911.jpg">
				   <span style="position:absolute; right:0; top:45%;font-weight:bold;">
				   		特此证明
				   		<br>
				   		<br>
				   		河南睿网信息技术有限公司<br><br>
				   		${netbar.uploadDate}
				   </span>
				</div>
			</td>
		</tr>
	</table>
	<%-- <table class="showgz"  background="${basePath}/img/2017052418362911.jpg" >
					<tr>
						<td align="right">特此证明 </td>
					</tr>
					<tr>
						<td align="right">河南睿网信息技术有限公司</td>
					</tr>
					<tr>
						<td align="right">${netbar.uploadDate}</td>
					</tr>
				</table> --%>
	
	<table align="center">
		<tr>
			<td><input type="button" id="printbtn" name="printbtn" value="打印" onclick="printDeploy()"></td>
		</tr>
	</table>
	
</body>
<script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
<script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
<script src="${basePath}/js/json3.min.js"></script>
<script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
<script type="text/javascript">
	function printDeploy(){
		console.log(111);
		$.ajax({
          	url:'${basePath}/netbar2/deploy/print', 
              data:'barId=${netbar.barId}' ,
              success:function(data){
            	  console.log(data);
            	  if(data.flag){
            		  window.print() ;
		           	}else{
		           		BootstrapDialog.alert({type:'type-default', message:'打印失败：'+data.msg,title:"错误信息"});
		           	}
              },
              error:function(){
                  BootstrapDialog.alert("没有找到对应的数据～");
              }
          });
		
	}
</script>
</html>