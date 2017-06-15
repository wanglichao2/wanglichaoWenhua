<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
		<link rel="stylesheet" href="${basePath}/css/dataTables/dataTables.bootstrap.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-editable/bootstrap-editable.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-dialog/bootstrap-dialog.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/select2/select2.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/uniform/uniform.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/ztree/ztree.css"/>
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
		<style type="text/css">
			a[id=name].editable-disabled,.a-link{
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
                       	<a href="${basePath}/role/list" class="btn btn-white"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                       	<input id="zNodes" type="hidden" value='${nodeSet}'>
                       	<input type="hidden" id="groupSource" value='${groupData[0]}'/>
                       	<c:set var="groupMap" value='${groupData[2]}'/>
                    </div>
                    <div class="ibox-content">
                    	<div class="row">
                    		<div class="col-sm-3">
                    			<ul id="nodeTree" class="ztree" style="padding-left: 20%;"></ul>
                    		</div>
                    		<div class="col-sm-9">
                    			<a id="addRow" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-plus"></i>&nbsp;添加角色</a>
                    			<a id="authbtn" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-tree"></i>&nbsp;角色赋权</a>
                    			<!-- <a id="revokebtn" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-recycle"></i>&nbsp;权限回收</a> -->
		                        <table class="table table-striped table-bordered table-hover " id="editable">
		                            <thead>
		                                <tr>
		                                	<th><input type="checkbox" class="checkable"/></th>
		                                    <th>角色编号</th>
											<!-- <th>所属部门</th> -->
											<th>角色名称</th>
											<th>角色标识符</th>
											<th>角色描述</th>
											<th>角色状态</th>
											<th>操作</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                            	<c:forEach var="role" items="${roleSet}">
		                            		<tr>
		                            			<td><input type="checkbox" class="checkable" value="${role.id}" /></td>
												<td>${role.id}</td>
												<%-- <td><a href="#" id="groupId" data-type="select2" data-pk="${role.id}">${groupMap[role.groupId]}</a></td> --%>
												<td><a href="#" id="name" data-type="text" data-pk="${role.id}" title="点击查看关联节点">${role.name}</a></td>
												<td><a href="#" id="role" data-type="text" data-pk="${role.id}">${role.role}</a></td>
												<td><a href="#" id="description" data-type="text" data-pk="${role.id}">${role.description}</a></td>
												<td><a href="#" id="status" data-type="select" data-pk="${role.id}">${role.status?'启用':'禁用'}</a></td>
												<td><i class="fa fa-edit fa-cursor"></i>
												&nbsp;&nbsp;&nbsp;<i class="fa fa-remove fa-cursor"></i>
												</td>
											</tr>
		                            	</c:forEach>
		                            </tbody>
		                        </table>
	                    		<div>
	                    			<a id="userbtn" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-user"></i>&nbsp;用户赋权</a>
	                    			<!-- <a id="recoverybtn" href="javascript:void(0);" class="btn btn-white"><i class="fa fa-remove"></i>&nbsp;权限回收</a> -->
	                    			<table class="table table-striped table-bordered table-hover " id="userTable">
			                            <thead>
			                                <tr>
			                                	<th><input type="checkbox" class="checkable1"/></th>
			                                    <th>用户编号</th>
												<th>用户名称</th>
												<th>登录账号</th>
												<th>所属部门</th>
			                                </tr>
			                            </thead>
			                            <tbody>
			                            	<c:forEach var="user" items="${userSet}">
			                            		<tr>
			                            			<td class="text-center"><input type="checkbox" class="checkable1" value="${user.id}" /></td>
													<td>${user.id}</td>
													<td><a href="#" id="name" class="a-link" title="点击查看关联角色">${user.name}</a></td>
													<td>${user.login}</td>
													<td>${groupMap[user.groupId]}</td>
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
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${basePath}/js/json3.min.js"></script>
    <script src="${basePath}/js/dataTables/jquery.dataTables.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.bootstrap.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.extends.js"></script>
    <script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.editable.js"></script>
    <script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
    <script src="${basePath}/js/select2/select2.full.min.js"></script>
    <script src="${basePath}/js/select2/zh-CN.js"></script>
    <script src="${basePath}/js/handlebars.js"></script>
    <script src="${basePath}/js/uniform/jquery.uniform.js"></script>
    <script src="${basePath}/js/ztree/jquery.ztree.min.js"></script>
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <!--定义HTML模板-->
	<script id="tpl" type="text/x-handlebars-template">
		<a href="#" id="{{this.id}}" data-type="{{this.type}}"></a>
	</script>
    <script>
    	$(document).ready(function(){
    		var url = '${basePath}/role/edit';
    		var groupSource = parseJSON($('#groupSource').val());	$('#groupSource').remove();
    		var setting={
    			check: {enable: true},
   				data:{simpleData:{enable:true, idKey:'id', pidKey:'pId', rootPId:0}}
   			};
    		var treeObj = $.fn.zTree.init($('#nodeTree'), setting, parseJSON($('#zNodes').val()));
    		$('#zNodes').remove();
    		var checkVal = function(objNode){//检查空值
    			objNode.find('a[id="name"]').editable('option', 'validate', function(v) {
            		if(!$.trim(v)) return '角色名称不能为空！';
            	});
    		}
    		$('input[type="checkbox"].checkable').uniform();
    		initCheckbox();
    		//编辑插件初始化
    		$('a[data-type="text"]').editable({disabled:true, url:url});
        	$('a[id="status"]').editable({disabled:true, source:state, url:url});
        	/* $('a[id="groupId"]').editable({
				disabled:true, url:url, emptytext:'选择', source:groupSource,
				select2:{placeholder:'选择所属部门',allowClear:true,language:'zh-CN'}
			}); */
        	checkVal($('#editable tbody'));
			//表格初始化
			oTable = $('#editable').dataTable({
				columnDefs:[{targets:0, orderable:false},{targets:6, orderable:false},
				            {targets:1,visible:true}], order:[[1, 'asc']]
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			dbTable = oTable.api();//返回datatable的API实例,
	        //预编译模板
	        var template = Handlebars.compile($('#tpl').html());
	        //添加新行
	        $('#addRow').click(function(){
	        	/* var groupId = template({id:'groupId', type:'select2'}); */
	        	var name = template({id:'name', type:'text'});
	        	var role = template({id:'role', type:'text'});
	        	var description = template({id:'description', type:'text'});
	        	var status = template({id:'status', type:'select'});
	        	var operate = '<td class="text-center"><i class="fa fa-save fa-cursor"></i>&nbsp;&nbsp;&nbsp;<i class="fa fa-remove fa-cursor"></i></td>';
	        	var nRow = oTable.fnAddData(['', '', /* groupId, */ name, role, description, status, operate]);
	        	var tr = $(oTable.fnGetNodes(nRow));
	        	tr.find('a[data-type="text"]').editable();
	        	tr.find('a[id="status"]').editable({value:0, source: state});
	        	/* $('a[id="groupId"]', tr).editable({
    				emptytext:'选择', source:groupSource,
    				select2:{placeholder:'选择所属部门',allowClear:true,language:'zh-CN'}
    			}); */
	        	checkVal(tr);//验证数据
				afterAddRow(tr);
	        });//保存
	        $('#editable tbody').on('click', 'i.fa-save', function(){
				var $this = $(this);
				var tr = $this.parents('tr');
				var element = tr.find('a[data-type]');
				var obj = element.editable('getValue');
				if($.trim(obj.name)==''){
					BootstrapDialog.alert({type:'type-default', message:'角色名称不能为空！'});
					return;
				}
				var data = JSON.parse(JSON.stringify(obj));
				$.com.ajax({
			       	url: '${basePath}/role/add', 
		           	data:data,
			       	success: function(data) {
			           	if(data.flag) {
			           		element.removeClass('editable-unsaved');
			           		element.editable('destroy');//销毁重新初始化
			           		var id = data.obj.id;
			           		var first = tr.find('td:first').html('<input type="checkbox" class="checkable" value="'+ id +'" />');
			           		tr.find('input[type="checkbox"].checkable').uniform();
			           		first.next().html(id);
			           		element.attr('data-pk', id);
			           		tr.find('a[data-type="text"]').editable({
			           			pk:id, disabled:true, url:url
			    			});
				        	tr.find('a[id="status"]').editable({pk:id, disabled:true, source:state, url:url});
				        	/* $('a[id="groupId"]', tr).editable({
			    				pk:id, disabled:true, url:url, emptytext:'选择', source:groupSource,
			    				select2:{placeholder:'选择所属部门',allowClear:true,language:'zh-CN'}
			    			}); */
				        	checkVal(tr);//验证数据
			               	$this.removeClass('fa-save').addClass('fa-edit');
			               	/* tr.find('i.fa-remove').remove(); */
			               	element.off('save');//解绑自动显示下一列编辑框事件
			               	dbTable.columns.adjust();//重新计算列宽
			           	}else{
			           		BootstrapDialog.alert({type:'type-danger', message:'保存失败，请刷新重试！'});
			           	}               
		       		}
				});
			}).on('click', 'i.fa-edit', function(){//编辑
				$(this).parents('tr').find('a[data-type]').editable('toggleDisabled');
			}).on('click', 'i.fa-remove:not("i.i-remove")', function(){
				var $this = $(this);
				var tr = $this.parents('tr');
				var pk = tr.find('a[data-type]:first').attr('data-pk');
				editableDelRow(pk,tr);
			}).on('click', 'a[id="name"]', function(){//查询节点
				var $this = $(this);
				if($this.hasClass('editable-disabled')){
					var tr = $this.parents('tr');
					var roleId = tr.find('input[type="checkbox"].checkable').val();
					$.com.ajax({
				       	url: '${basePath}/role/relationNode', 
			           	data:{roleId: roleId},
				       	success: function(nodes){
				       		treeObj.checkAllNodes(false);//取消所有勾选节点
				    		if(nodes.length==0){
				       			BootstrapDialog.alert({type:'type-default', message:'此角色未关联任何节点！'});
				       			return;
				       		}
				    		//将 zTree 使用的标准 JSON 嵌套格式的数据转换为简单 Array 格式
				    		var allNodes = treeObj.transformToArray(treeObj.getNodes());
				    		$(allNodes).each(function(i, node){
				    			if($.inArray(node.id, nodes)!=-1){
				    				treeObj.checkNode(node, true, false);
				    			}
				    		});
			       		}
					});
				}
			});
	        var editableDelRow=function(pk,tr){//删除
				BootstrapDialog.confirm({type:'type-default', message:'确认是否删除?', callback:function(result){
		            if(result) {
		            	$.com.ajax({
					       	url: '${basePath}/role/del', 
				           	data:{pk:pk},
					       	success: function(data){
					           	if(data.flag){
					           		BootstrapDialog.alert({type:'type-default', message:'删除成功！'});
					           		dbTable.row(tr).remove().draw(false);
					           	}else{
					           		BootstrapDialog.alert({type:'type-danger', message:'删除失败，请刷新重试！'});
					           	}               
				       		}
						});
		            }
		        }});
			};
	        $('#authbtn').click(function(){//节点权限
	        	var rows = oTable.fnGetNodes();
	    		var roles = $('input[type="checkbox"]:checked', rows);
	    		if(roles.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择角色！'});
	    			return;
	    		}
	    		//var treeObj = $.fn.zTree.getZTreeObj("nodeTree");
	        	var nodes = treeObj.getCheckedNodes();
	        	if(nodes.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从层级树中选择节点！'});
	    			return;
	    		}
	    		BootstrapDialog.confirm({type:'type-default', message:'确认操作角色节点权限？', callback:function(result){
	                if(result){
	    	        	var nodeSet = new Array(), roleSet = new Array();
	    	    		$.each(nodes, function(i, node){
	    	    			nodeSet.push(node.id);
	    	    		});
	    	    		$.each(roles, function(){
	    	    			roleSet.push($(this).val());
	    	    		});
	    	    		$.com.ajax({
	    			       	url: '${basePath}/role/authority', 
	    		           	data:{nodes: nodeSet, roles:roleSet},
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
	        });
	        $('#revokebtn').click(function(){//回收节点权限
	        	var rows = oTable.fnGetNodes();
	    		var roles = $('input[type="checkbox"]:checked', rows);
	    		if(roles.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择角色！'});
	    			return;
	    		}
	        	var nodes = treeObj.getCheckedNodes();
	        	var msg = nodes.length==0?'未选择任何节点，确认收回所有角色节点权限？':'确认收回角色节点权限？';
	    		BootstrapDialog.confirm({type:'type-default', message:msg, callback:function(result){
	                if(result){
	    	        	var nodeSet = new Array(), roleSet = new Array();
	    	    		$.each(nodes, function(i, node){
	    	    			nodeSet.push(node.id);
	    	    		});
	    	    		if(nodeSet.length==0){nodeSet.push(-1);}//未选中任何节点时用
	    	    		$.each(roles, function(){
	    	    			roleSet.push($(this).val());
	    	    		});
	    	    		$.com.ajax({
	    			       	url: '${basePath}/role/revoke', 
	    		           	data:{nodes: nodeSet, roles:roleSet},
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
	        });//用户表格
	        $('input[type="checkbox"].checkable1').uniform();
	        var userTable = $('#userTable').dataTable({
				columnDefs:[{targets:0, orderable:false}],
				order:[[1, 'asc']]
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			var apiTable = userTable.api();//返回datatable的API实例,
	        $('#userTable th input.checkable1').change(function(){//全选
	    		var rows = apiTable.rows('tr:not(tr.newRow)').nodes();//oTable.fnGetNodes();
	    		var $rows = $('input[type="checkbox"].checkable1', rows);
	    		$rows.prop('checked', this.checked);
	    		$.uniform.update($rows);
	        });
	        $('#userTable>tbody').on('change', 'input[type="checkbox"].checkable1', function(){
	        	$(this).prop('checked', this.checked);
	    		var rows = apiTable.rows('tr:not(tr.newRow)').nodes();//oTable.fnGetNodes();
	            var rLen = rows.length,
	            	rcLen = $('input[type="checkbox"].checkable1:checked', rows).length,
	            	th_checkbox = $('#userTable th input.checkable1');
	            var bool = rLen==rcLen && rcLen!=0;
	            	th_checkbox.prop('checked', bool);
	            	if(bool){
	            		th_checkbox.parent('span').addClass("checked");
	            	}else{
	            		th_checkbox.parent('span').removeClass("checked");
	            	}
	        });
	        $('#userbtn').click(function(){//角色赋权
	        	var rows = userTable.fnGetNodes();
	    		var users = $('input[type="checkbox"]:checked', rows);
	    		if(users.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择用户！'});
	    			return;
	    		}
	    		rows = oTable.fnGetNodes();
	    		var roles = $('input[type="checkbox"]:checked', rows);
	    		if(roles.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择角色！'});
	    			return;
	    		}
	    		BootstrapDialog.confirm({type:'type-default', message:'确认操作用户角色赋权？', callback:function(result){
	                if(result){
	    	        	var roleSet = new Array(), userSet = new Array();
	    	    		$.each(roles, function(){
	    	    			roleSet.push($(this).val());
	    	    		});
	    	    		$.each(users, function(){
	    	    			userSet.push($(this).val());
	    	    		});
	    	    		$.com.ajax({
	    			       	url: '${basePath}/role/relation', 
	    		           	data:{roles:roleSet, users:userSet},
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
	        });
	        $('#recoverybtn').click(function(){//收回角色权限
	        	var rows = userTable.fnGetNodes();
	    		var users = $('input[type="checkbox"]:checked', rows);
	    		if(users.length==0){
	    			BootstrapDialog.alert({type:'type-default', message:'请从列表中选择用户！'});
	    			return;
	    		}
	    		rows = oTable.fnGetNodes();
	    		var roles = $('input[type="checkbox"]:checked', rows);
	    		var msg = roles.length==0?'未选择任何角色，确认收回用户所有角色？':'确认操作用户角色权限？'
	    		BootstrapDialog.confirm({type:'type-default', message:msg, callback:function(result){
	                if(result){
	    	        	var roleSet = new Array(), userSet = new Array();
	    	    		$.each(roles, function(){
	    	    			roleSet.push($(this).val());
	    	    		});
	    	    		if(roleSet.length==0){roleSet.push(-1);}//未选中任何节点时用
	    	    		$.each(users, function(){
	    	    			userSet.push($(this).val());
	    	    		});
	    	    		$.com.ajax({
	    			       	url: '${basePath}/role/recovery', 
	    		           	data:{roles:roleSet, users:userSet},
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
	        });
	        $('#userTable tbody').on('click', 'a[id="name"]', function(){
				var $this = $(this);
				var tr = $this.parents('tr');
				var userId = tr.find('input[type="checkbox"].checkable1').val();
				var text = $('td:last', tr).text();
				/* dbTable.columns(2).search(text).draw(); *///过滤角色表
				$.com.ajax({
			       	url: '${basePath}/role/relationRole', 
		           	data:{userId: userId},
			       	success: function(roles){
			       		var rows = dbTable.rows('tr').nodes();
			    		var $rows = $('input[type="checkbox"].checkable', rows);
			    		$rows.prop('checked', false);
			    		$.uniform.update($rows);
			    		if(roles.length==0){
			       			BootstrapDialog.alert({type:'type-default', message:'此用户未关联任何角色！'});
			       			return;
			       		}
			    		$($rows).each(function(){
			    			var $this = $(this);
			    			if($.inArray(parseInt($this.val()), roles)!=-1){
			    				$this.prop('checked', true);
					    		$.uniform.update($this);
			    			}
			    		});
		       		}
				});
			});
	        $('.spiner-example').remove();//移除遮罩层
		});
	</script>
</body>
</html>
