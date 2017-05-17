<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
	</head>

	<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                    <li class="nav-header" style="padding: 0;">
                        <div class="dropdown profile-element text-center">
                        	<%-- <span><img alt="image" style="width: 180px;" src="${basePath}/img/logo.png" /></span> --%>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                               <span class="clear" style="padding-bottom: 5px;">
	                               <span class="block m-t-xs" style="font-size:medium;"><strong>${sessionUserName}</strong></span>
	                               <span class="text-muted text-xs block">
	                               		<%-- <shiro:hasRole name="admin">管理员</shiro:hasRole> --%>
	                               		${groupData[2][sessionUser.groupId]}<%--&nbsp;&nbsp;
	                               		<c:forEach var="role" items="${sessionUser.roles}" varStatus="vs">
	                               			<c:choose>
	                               				<c:when test="${vs.first}">${role.name}</c:when>
	                               				<c:otherwise>、${role.name}</c:otherwise>
	                               			</c:choose>
	                               		</c:forEach> --%>
	                               </span>
                               </span>
                            </a>
                        </div>
                        <div class="logo-element"><i class="fa fa-arrow-right"></i></div>
                    </li>
                    <c:forEach var="node" items="${userNodeSet}">
                    	<c:set var="childNode" value="${node.childNode}" />
                    	<li>
	                    	<c:choose>
	                    		<c:when test="${not empty childNode}">
	                    			<a href="#">
			                            <i class="fa fa-${node.icon}"></i>
			                            <span class="nav-label">${node.name}</span>
			                            <span class="fa arrow"></span>
			                        </a>
			                        <ul class="nav nav-second-level">
			                        	<c:forEach var="child" items="${childNode}">
				                            <li><a class="J_menuItem" href="${basePath}${child.url}">${child.name}</a></li>
			                        	</c:forEach>
			                        </ul>
	                    		</c:when>
	                    		<c:otherwise>
			                        <a class="J_menuItem" href="${basePath}${node.url}"><i class="fa fa-${node.icon}"></i><span class="nav-label">${node.name}</span></a>
	                    		</c:otherwise>
	                    	</c:choose>
                    	</li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                    </div>
                   	  <ul class="nav navbar-top-links navbar-right">
                    	 <%-- <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            	<c:set var="noticeSize" value="${fn:length(noticeSet)}" />
                                <i class="fa fa-bell"></i> 
                                <c:if test="${noticeSize gt 0}">
	                                <span class="label label-primary">${noticeSize}</span>
                                </c:if>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                            	<c:forEach var="notice" items="${noticeSet}" end="3" varStatus="vs">
                            		<li ${vs.first?'class="m-t-xs"':''}>
	                                    <div class="dropdown-messages-box">
	                                        <div class="media-body">
                                           		<strong class="text-info">#${sysParam.SP006[notice.classify]}#</strong>
                                           		<span>${notice.name}</span><br>
	                                            <span class="pull-right text-muted small"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;<span class="date-moment" title="${notice.releaseDate}"></span></span>
	                                        </div>
	                                    </div>
	                                </li>
	                                <li class="divider"></li>
                            	</c:forEach>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="${basePath}/notice/noticeList">
                                            <i class="fa fa-bell"></i><strong> 所有公告</strong>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            	<c:set var="warningSize" value="${fn:length(warningSet)}" />
                                <i class="fa fa-warning"></i> 
                                <c:if test="${warningSize gt 0}">
	                                <span class="label label-warning">${warningSize}</span>
                                </c:if>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                            	<c:forEach var="warning" items="${warningSet}" end="3" varStatus="vs">
	                                <li ${vs.first?'class="m-t-xs"':''}>
	                          			<div class="dropdown-messages-box">
	                                       	<div class="media-body">
                                         		<i class="fa fa-warning"></i><span> ${warning.name}</span><br>
	                                           	<span class="pull-right text-muted small"><i class="fa fa-clock-o"></i>&nbsp;&nbsp;<span class="date-moment" title="${warning.releaseDate}"></span></span>
	                                       	</div>
	                                   	</div>
	                                </li>
	                                <li class="divider"></li>
                                </c:forEach>
                                <li>
                                    <div class="text-center link-block">
                                        <a class="J_menuItem" href="${basePath}/notice/warningList">
                                            <i class="fa fa-warning"></i><strong> 所有预警 </strong>
                                        </a>
                                    </div>
                                </li>
                            </ul>
                        </li> --%>
                        <li class="dropdown hidden-xs">
                            <a class="right-sidebar-toggle" aria-expanded="false">
                                <i class="fa fa-tasks"></i> 主题
                            </a>
                        </li>
                    </ul>
                </nav>
            </div>
            <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="${basePath}/work/home">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>
                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="${basePath}/login/logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i>退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="${basePath}/work/home" frameborder="0" data-id="${basePath}/work/home" seamless></iframe>
            </div>
            <!-- <div class="footer">
                <div class="pull-right">&copy;&nbsp;2017 &nbsp;版权所有&nbsp;&nbsp;</div>
            </div> -->
        </div>
        <!--右侧部分结束-->
        <!--右侧边栏开始-->
        <div id="right-sidebar">
            <div class="sidebar-container">
                <ul class="nav nav-tabs navs-3">
                    <li class="active">
                        <a data-toggle="tab" href="#tab-1">
                            <i class="fa fa-gear"></i> 主题
                        </a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div id="tab-1" class="tab-pane active">
                        <div class="sidebar-title">
                            <h3> <i class="fa fa-comments-o"></i> 主题设置</h3>
                            <small><i class="fa fa-tim"></i> 你可以从这里选择和预览主题的布局和样式，这些设置会被保存在本地，下次打开的时候会直接应用这些设置。</small>
                        </div>
                        <div class="skin-setttings">
                            <div class="title">主题设置</div>
                            <div class="setings-item">
                                <span>收起左侧菜单</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="collapsemenu" class="onoffswitch-checkbox" id="collapsemenu">
                                        <label class="onoffswitch-label" for="collapsemenu">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item">
                                <span>固定顶部</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="fixednavbar" class="onoffswitch-checkbox" id="fixednavbar">
                                        <label class="onoffswitch-label" for="fixednavbar">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="setings-item"><span>固定宽度</span>
                                <div class="switch">
                                    <div class="onoffswitch">
                                        <input type="checkbox" name="boxedlayout" class="onoffswitch-checkbox" id="boxedlayout">
                                        <label class="onoffswitch-label" for="boxedlayout">
                                            <span class="onoffswitch-inner"></span>
                                            <span class="onoffswitch-switch"></span>
                                        </label>
                                    </div>
                                </div>
                            </div>
                            <div class="title">皮肤选择</div>
                            <div class="setings-item default-skin nb">
                                <span class="skin-name">
                         			<a href="#" class="s-skin-0">默认皮肤</a>
                    			</span>
                            </div>
                            <div class="setings-item blue-skin nb">
                                <span class="skin-name">
			                        <a href="#" class="s-skin-1">蓝色主题</a>
			                    </span>
                            </div>
                            <div class="setings-item yellow-skin nb">
                                <span class="skin-name">
									<a href="#" class="s-skin-3">黄色/紫色主题</a>
                    			</span>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <!--右侧边栏结束-->
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${basePath}/js/metisMenu/jquery.metisMenu.js"></script>
    <script src="${basePath}/js/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="${basePath}/js/layer/layer.min.js"></script>
    <script src="${basePath}/js/moment/moment.min.js"></script>
    <script src="${basePath}/js/moment/zh-cn.js"></script>
    <script src="${basePath}/js/hplus.min.js?v=4.1.0"></script>
    <script src="${basePath}/js/contabs.min.js"></script>
    <script src="${basePath}/js/pace/pace.min.js"></script>
</body>
</html>
