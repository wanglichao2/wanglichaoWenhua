<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
		<link rel="stylesheet" href="${basePath}/css/dataTables/dataTables.bootstrap.css"/>
		<link rel="stylesheet" href="${basePath}/css/dataTables/fixedColumns.bootstrap.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-editable/bootstrap-editable.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-dialog/bootstrap-dialog.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/uniform/uniform.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/ztree/ztree.css"/>
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
		<style type="text/css">
			a[id=name].editable-disabled{
				color: #0088cc !important;
			}
			a[id=name].editable-disabled:hover{
				cursor: pointer !important;
			}
		</style>
	</head>

	<body class="gray-bg">
	<div class="spiner-example">
       <div class="sk-spinner sk-spinner-three-bounce">
            <div class="sk-bounce1"></div>
            <div class="sk-bounce2"></div>
            <div class="sk-bounce3"></div>
        </div>
    </div>
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                    	<a href="${basePath}/user/list" class="btn btn-white btn-margin-right"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                        <a id="frozenBtn" href="javascript:;" class="btn btn-white btn-margin-right"><i class="fa fa-table"></i>&nbsp;<span>已</span>冻结</a>
                    	<shiro:hasPermission name="user:add">
	                        <a id="addRow" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-plus"></i>&nbsp;添加</a>
	                        <a id="userbtn" href="javascript:;" class="btn btn-white btn-margin-right"><i class="fa fa-user"></i>&nbsp;用户关联部门</a>
	                        <a id="userAreaCfg" href="javascript:;" class="btn btn-white btn-margin-right"><i class="fa fa-user"></i>&nbsp;用户区域设置</a>
                    	</shiro:hasPermission>
                    	<input id="zNodes" type="hidden" value='${groupTree}'>
                    	<c:set var="groupMap" value='${groupData[2]}'/>
                    </div>
                    <div class="ibox-content">
                    	<div class="row">
                    		<div class="col-sm-3">
                    			<ul id="nodeTree" class="ztree" style="padding-left: 20%;"></ul>
                    		</div>
                    		<div class="col-sm-9">
		                        <table class="table table-striped table-bordered table-hover " id="editable">
		                            <thead>
		                                <tr>
		                                	<th><input type="checkbox" class="checkable"/></th>
		                                    <th>编号</th>
											<th>用户名称</th>
											<th>登录账号</th>
											<th>访问密码</th>
											<th>职位</th>
											<th>手机号码</th>
											<th>邮箱地址</th>
											<th>微信OpenId</th>
											<th>主要职责</th>
											<th>管理员</th>
											<th>用户状态</th>
											<th>操作</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                            	<c:forEach var="user" items="${userSet}">
		                            		<tr>
		                            			<td><input type="checkbox" class="checkable" value="${user.id}" />
		                            			<span class="display-none" groupId="${user.groupId}">${groupMap[user.groupId]}</span></td>
												<td>${user.id}</td>
												<td><a href="#" id="name" data-type="text" data-pk="${user.id}" title="点击查看所属部门">${user.name}</a></td>
												<td><a href="#" id="login" data-type="text" data-pk="${user.id}">${user.login}</a></td>
												<td><a href="#" id="password" data-type="text" data-pk="${user.id}"></a></td>
												<td><a href="#" id="job" data-type="text" data-pk="${user.id}">${user.job}</a></td>
												<td><a href="#" id="phone" data-type="text" data-pk="${user.id}">${user.phone}</a></td>
												<td><a href="#" id="email" data-type="text" data-pk="${user.id}">${user.email}</a></td>
												<td><a href="#" id="openId" data-type="text" data-pk="${user.id}">${user.openId}</a></td>
												<td><a href="#" id="duty" data-type="text" data-pk="${user.id}">${user.duty}</a></td>
												<td><a href="#" id="isAdmin" data-type="select" data-pk="${user.id}">${user.isAdmin?'是':'否'}</a></td>
												<td><a href="#" id="status" data-type="select" data-pk="${user.id}">${user.status?'启用':'禁用'}</a></td>
												<td class="text-center"><i class="fa fa-edit fa-cursor"></i></td>
											</tr>
		                            	</c:forEach>
		                            </tbody>
		                        </table>
		                  	</div>
		            	</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${basePath}/js/dataTables/jquery.dataTables.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.bootstrap.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.extends.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.fixedColumns.min.js"></script>
    <script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.editable.js"></script>
    <script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
    <script src="${basePath}/js/handlebars.js"></script>
    <script src="${basePath}/js/uniform/jquery.uniform.js"></script>
    <script src="${basePath}/js/ztree/jquery.ztree.min.js"></script>
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <!--定义HTML模板-->
	<script id="tpl" type="text/x-handlebars-template">
		<a href="#" id="{{this.id}}" data-type="{{this.type}}"></a>
	</script>
	<!--定义HTML模板-->
	<script id="tpl_area" type="text/x-handlebars-template">
		<div class="tabs-container">
             <ul class="nav nav-tabs">
                 <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">区域信息</a></li>
             </ul>
             <div class="tab-content">
                 <div id="tab-1" class="tab-pane active">
                     <div class="panel-body">
						<div class="col-sm-3">
                    			<ul id="areaNodeTree" class="ztree" style="padding-left: 20%;"></ul>
                    		</div>
                     </div>
                 </div>
             </div>
        </div>
	</script>
    <script>
    	$(document).ready(function(){
    		var url = '${basePath}/user/edit';
    		var onClick = function(event, treeId, treeNode, clickFlag) {
    			var text = treeNode.id==0?'':treeNode.name;
    			dbTable.columns(0).search(text).draw();//正则表达式搜索
    		}
    		var setting={
   				view:{selectedMulti: false}, check:{enable: true, chkStyle:'radio'},
   				data:{simpleData:{enable:true, idKey:'id', pidKey:'pId', rootPId:0}},
   				callback: {onClick: onClick}
   			};
    		var setting_area={
        			check: {enable: true},
       				data:{simpleData:{enable:true, idKey:'id', pidKey:'pId', rootPId:0}}
       		};
    		var treeObj = $.fn.zTree.init($('#nodeTree'), setting, parseJSON($('#zNodes').val()));
    		$('#zNodes').remove();
    		$('input[type="checkbox"].checkable').uniform();
    		initCheckbox();
    		var checkVal = function(objNode){
    			objNode.find('a[id="name"]').editable('option', 'validate', function(v) {
            		if(!$.trim(v)) return '用户名称不能为空！';
            	});
    			objNode.find('a[id="login"]').editable('option', 'validate', function(v) {
            		if(!$.trim(v)) return '登录账号不能为空！';
            	});
    			objNode.find('a[id="password"]').editable('option', 'validate', function(v) {
            		if(!$.trim(v)) return '访问密码不能为空！';
            	});
    			objNode.find('a[id="email"]').editable('option', 'validate', function(v) {
            	    if($.trim(v) && !email_regex.test(v)) return '请输入正确的邮箱地址！';
            	});
    		}
    		//编辑插件初始化
    		$('a[data-type="text"]').editable({disabled:true, url:url}).on('save', adjustColumn);
        	$('a[id="isAdmin"]').editable({disabled:true, source:whether, url:url});
        	$('a[id="status"]').editable({disabled:true, source:state, url:url});
        	checkVal($('#editable tbody'));
			//表格初始化
			oTable = $('#editable').dataTable({
				columnDefs:[{targets:0, orderable:false},{targets:11, orderable:false}],
				order:[[1,'asc']],/* scrollX:true,  */
				fixedColumns:{leftColumns: 3}
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			dbTable = oTable.api();//$('#editable').DataTable();//返回datatable的API实例,
	        //预编译模板
	        var template = Handlebars.compile($('#tpl').html());
	        //添加新行
	        $('#addRow').click(function(){
	        	var name = template({id:'name', type:'text'});
	        	var login = template({id:'login', type:'text'});
	        	var password = template({id:'password', type:'text'});
	        	var job = template({id:'job', type:'text'});
	        	var phone = template({id:'phone', type:'text'});
	        	var email = template({id:'email', type:'text'});
	        	var openId = template({id:'openId', type:'text'});
	        	var duty = template({id:'duty', type:'text'});
	        	var isAdmin = template({id:'isAdmin', type:'select'});
	        	var status = template({id:'status', type:'select'});
	        	var operate = '<td class="text-center"><i class="fa fa-save fa-cursor"></i>&nbsp;&nbsp;&nbsp;<i class="fa fa-remove fa-cursor"></i></td>';
	        	var nRow = oTable.fnAddData(['', '', name, login, password, job, phone, email, openId, duty, isAdmin, status, operate]);
	        	var tr = $(oTable.fnGetNodes(nRow));
	        	tr.find('a[data-type="text"]').editable();
	        	tr.find('a[id="isAdmin"]').editable({value:0, source: whether});
	        	tr.find('a[id="status"]').editable({value:1, source: state});
	        	checkVal(tr);//验证数据
				afterAddRow(tr);
				$('div.ibox-content div.DTFC_LeftWrapper').addClass('visible-hide');
				$('#frozenBtn>span').html('未');//添加时取消冻结功能
	        });//保存
	        $('#editable tbody').on('click', 'i.fa-save', function(){
				var $this = $(this);
				var tr = $this.parents('tr');
				var element = tr.find('a[data-type]');
				var obj = element.editable('getValue');
				if($.trim(obj.name)==''){
					BootstrapDialog.alert({type:'type-default', message:'用户名称不能为空！'});
					return;
				}
				if($.trim(obj.login)==''){
					BootstrapDialog.alert({type:'type-default', message:'登录账号不能为空！'});
					return;
				}
				if($.trim(obj.password)==''){
					BootstrapDialog.alert({type:'type-default', message:'访问密码不能为空！'});
					return;
				}
				var data = JSON.parse(JSON.stringify(obj));
				$.com.ajax({
			       	url: '${basePath}/user/add', 
		           	data:data,
			       	success: function(data) {
			           	if(data.flag) {
			           		element.removeClass('editable-unsaved');
			           		element.editable('destroy');//销毁重新初始化
			           		var id = data.obj.id;
			           		element.attr('data-pk', id);
			           		tr.find('a[data-type="text"]').editable({
			           			pk:id, disabled:true, url:url
			    			}).on('save', adjustColumn);
				        	tr.find('a[id="isAdmin"]').editable({pk:id, disabled:true, source:whether, url:url});
				        	tr.find('a[id="status"]').editable({pk:id, disabled:true, source:state, url:url});
				        	checkVal(tr);//验证数据
			               	$this.removeClass('fa-save').addClass('fa-edit');
			               	tr.find('i.fa-remove').remove();
			               	element.off('save');//解绑自动显示下一列编辑框事件
			               	dbTable.columns.adjust();//重新计算列宽
			           	}else{
			           		BootstrapDialog.alert({type:'type-danger', message:'保存失败，请刷新重试！'});
			           	}               
		       		}
				});
			}).on('click', 'i.fa-edit', function(){//编辑
				$(this).parents('tr').find('a[data-type]').editable('toggleDisabled');
			});
	        
	      //预编译模板-区域
	        var template_area = Handlebars.compile($('#tpl_area').html());
	        var areaTreeObj=null;
	        var dataDialog = function(){
	        	var $this = $(this);
	        	var rows = oTable.fnGetNodes();
	        	var userSet = new Array()
	    		var userIds = $('input[type="checkbox"]:checked', rows);
	    		$.each(userIds, function(){
	    			userSet.push($(this).val());
	    		});
	    		console.log(userSet);
	    		if(userIds.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择用户！'});
	    			return;
	    		}
	        	var title = '所属区域配置', dataJson = {};
	        	var $div = $(template_area(dataJson));
	        	BootstrapDialog.show({type:'type-default', size:'size-wide', message:$div, title:title, closable:true,
		       		 buttons: [{
		                 icon:'fa fa-save', label:'确定',
		               	 action: function(){
		               		var nodes = areaTreeObj.getCheckedNodes();
		    	        	if(nodes.length==0){
		    	    			BootstrapDialog.alert({type:'type-default', message:'请从层级树中选择节点！'});
		    	    			return;
		    	    		}
		    	    		BootstrapDialog.confirm({type:'type-default', message:'确认操作用户的所属区域？', callback:function(result){
		    	                if(result){
		    	    	        	var nodeSet = new Array();
		    	    	    		$.each(nodes, function(i, node){
		    	    	    			nodeSet.push(node.id);
		    	    	    		});
		    	    	    		console.log("user====>"+userSet);
		    	    	    		console.log("areaCode===>"+nodeSet);
		    	    	    		$.com.ajax({
		    	    			       	url: '${basePath}/user/save/userAreas', 
		    	    		           	data:{areaCodes: nodeSet, userIds:userSet},
		    	    			       	success: function(data){
		    	    			           	if(data.flag){
		    	    			           		BootstrapDialog.alert({type:'type-default', message:'操作成功！'});
		    	    			           	}else{
		    	    			           		BootstrapDialog.alert({type:'type-danger', message:'操作失败:'+data.msg});
		    	    			           	}               
		    	    		       		}
		    	    				}); 
		    	                }
		    	    		}});
		             	 }
		             }, {
		            	 icon:'fa fa-close', label: '取消',
		                 action: function(dialog){
		                	 dialog.close();
		                 }
	             	}],
            		onshown: function(dialog){
            			$.ajax({
	                        	url:'${basePath}/netbarList/loadAreaTree', 
	                            data:{"search":{"value":"41"}},
	                            success:function(data){
	                            	areaTreeObj = $.fn.zTree.init($('#areaNodeTree'), setting_area, data);
	                            	userAreaLoad(userSet);
	                            },
	                            error:function(){
	                                BootstrapDialog.alert("没有找到对应的数据～");
	                            }
	                        });
            		}
	        	});
	        }
	      	//添加新行
	        $('#userAreaCfg').click(dataDialog);
	        
	      	var userAreaLoad=function(userId){
	      		$.ajax({
                	url:'${basePath}/user/loadUserAreas', 
                    data:{userId:userId},
                    success:function(nodes){
                    	console.log(nodes);
                    	areaTreeObj.checkAllNodes(false);//取消所有勾选节点
			    		if(nodes.length==0){
			       			BootstrapDialog.alert({type:'type-default', message:'此员工未配置任何区域！'});
			       			return;
			       		}
			    		//将 zTree 使用的标准 JSON 嵌套格式的数据转换为简单 Array 格式
			    		var allNodes = areaTreeObj.transformToArray(areaTreeObj.getNodes());
			    		$(allNodes).each(function(i, node){
			    			/* console.log("==>"+node.id+"--"+node); */
			    			if($.inArray(node.id+"", nodes)!=-1){
			    				/* console.log(node.id+"  in nodes"); */
			    				areaTreeObj.checkNode(node, true, false);
			    			}else{
			    				console.log(node.id +" not in nodes ");
			    			}
			    		});
                    },
                    error:function(){
                        BootstrapDialog.alert("没有找到对应的数据～");
                    }
                });
	      	};
	        
	        $('#userbtn').click(function(){//用户关联部门
	        	var rows = oTable.fnGetNodes();
	    		var users = $('input[type="checkbox"]:checked', rows);
	    		if(users.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中勾选关联的用户！'});
	    			return;
	    		}
	    		var groups = treeObj.getCheckedNodes();
	    		if(groups.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请部门树中勾选关联的部门！'});
	    			return;
	    		}
	    		var msg = '确认操作用户关联部门？';
	    		BootstrapDialog.confirm({type:'type-default', message:msg, callback:function(result){
	                if(result){
	    	        	var userSet = new Array();
	    	    		$.each(users, function(){
	    	    			userSet.push($(this).val());
	    	    		});
	    	    		$.com.ajax({
	    			       	url: '${basePath}/group/relation', 
	    		           	data:{users:userSet, groupId:groups[0].id},
	    			       	success: function(data){
	    			           	if(data.flag){
	    			           		BootstrapDialog.alert({type:'type-default', message:'操作成功！'});
	    			           	}else{
	    			           		BootstrapDialog.alert({type:'type-danger', message:'操作失败，请刷新重试！'});
	    			           	}               
	    		       		}
	    				});
	                }
	        	}});
	        });//查询用户关联的部门
	        $('#editable tbody').on('click', 'a[id="name"]', function(){
	        	var $this = $(this);
	        	if($this.hasClass('editable-disabled')){
	        		var tr = $this.parents('tr');
	        		var groupId = $('span.display-none', tr).attr('groupId');
	        		var nodes = treeObj.getCheckedNodes(true);
	        		if(nodes.length>0){//取消所有勾选节点
		        		treeObj.checkNode(nodes[0], false, false);
	        		}
	        		if($.trim(groupId)==''){
		       			BootstrapDialog.alert({type:'type-default', message:'此用户未关联部门！'});
		       			return;
	        		}
		    		//将 zTree 使用的标准 JSON 嵌套格式的数据转换为简单 Array 格式
		    		var allNodes = treeObj.transformToArray(treeObj.getNodes());
		    		$(allNodes).each(function(i, node){
		    			if(groupId == node.id){
		    				treeObj.checkNode(node, true, false);
		    			}
		    		});
	        	}
			});
	        //冻结功能开关
	        $('#frozenBtn').on('click', function(){
	        	var leftWrapper = $('div.ibox-content div.DTFC_LeftWrapper');
	        	leftWrapper.toggleClass('visible-hide');
	        	$(this).children('span').html(leftWrapper.hasClass('visible-hide')?'未':'已');
	        });
	        $('.spiner-example').remove();//移除遮罩层
		});
	</script>
</body>
</html>
