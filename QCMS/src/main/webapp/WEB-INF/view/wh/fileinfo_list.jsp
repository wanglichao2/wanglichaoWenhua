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
		<link rel="stylesheet" href="${basePath}/css/ztree/ztree.css"/>
		<style type="text/css">.modal-lg .modal-body{padding: 0 !important;min-height:400px;}.lightBoxGallery img {margin:5px;width:160px;}
		.tabs-container .tab-pane .panel-body{border:none;}</style>
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
                <div class="ibox-title">
                       	<a href="${basePath}/fileinfo/list" class="btn btn-white btn-margin-right"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                       	<shiro:hasPermission name="fileinfo:add">
                        	<a id="addRow" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-plus"></i>&nbsp;添加</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="fileinfo:del">
                        	<a id="delAll" href="javascript:void(0);" class="btn btn-white btn-margin-right" style="display: none;"><i class="fa fa-remove"></i>&nbsp;批量删除</a>
                        </shiro:hasPermission>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped table-bordered table-hover " id="editable">
                            <thead>
                                <tr>
                                	<th>操作</th>
                                	<th>文件名称</th>
									<th>版本号</th>
									<th>文件md5值</th>
									<th>文件所在模块</th>
									<th>文件类型</th>
									<th>启用方式</th>
                                	<th>是否应用到所有网吧</th>
                                </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="${basePath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${basePath}/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="${basePath}/js/dataTables/jquery.dataTables.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.bootstrap.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.fixedColumns.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.table.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.extends.js"></script>
    <script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
    <script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
    <script src="${basePath}/js/handlebars.js"></script>
    <script src="${basePath}/js/validate/jquery.validate.min.js"></script>
    <script src="${basePath}/js/validate/messages_zh.min.js"></script>
    <script src="${basePath}/js/webuploader/webuploader.min.js"></script>
    <script src="${basePath}/js/ztree/jquery.ztree.min.js"></script>
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <!--定义HTML模板-->
	<script id="tpl" type="text/x-handlebars-template">
		<div class="tabs-container">
             <ul class="nav nav-tabs">
                 <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">详细信息</a></li>
             </ul>
             <div class="tab-content">
				<div id="tab-1" class="tab-pane active">
                     <div class="panel-body">
						<form class="form-horizontal" id="dataForm" action="${basePath}/fileinfo/importDataNew" method="post" enctype="multipart/form-data"> 
                        	<input type="hidden" id="id" name="id" value="{{this.id}}">
		    				<div class="row m-b">
			    	    		<div class="col-sm-2 text-nowrap l-h"><span class="red">*</span>文件名称：</div>
					    		<div class="col-sm-5">
									<input type="file" id="file" name="file" />
									<input type="text" id="filename" name="filename" value="{{this.filename}}" class="form-control">
								</div>	
							</div>
							<div class="row m-b">
								<div class="col-sm-2 text-nowrap l-h"><span class="red">*</span>文件版本号：</div>
					    		<div class="col-sm-5"><input type="text" id="version" name="version" value="{{this.version}}" class="form-control" required></div>	
							</div>
			            	<div class="row m-b">
			            		<div class="col-sm-2 text-nowrap l-h"><span class="red">*</span>文件所在模块：</div>
					    		<div class="col-sm-2">
									<select id="flag" name="flag" style="width:200px;">
										<option selected="true" value="1">服务端</option>
										<option value="2">客户端</option>
									</select>
								</div>
							</div>
			            	<div class="row m-b">
								<div class="col-sm-2 text-nowrap l-h"><span class="red">*</span>文件类型：</div>
					    		<div class="col-sm-5">
									<select id="type" name="type" style="width:200px;">
										<option selected="true" value="0">忽略</option>
										<option value="1">dll</option>
										<option value="2">exe</option>
									</select>
								</div>
			           	 	</div>
							<div class="row m-b">
			            		<div class="col-sm-2 text-nowrap l-h"><span class="red">*</span>启用方式：</div>
					    		<div class="col-sm-5">
									<select id="action" name="action" style="width:200px;">
										<option selected="true" value="0">忽略</option>
										<option value="1">加载dll</option>
										<option value="2">运行exe</option>
									</select>
								</div>
			            	</div>
			            	<div class="row m-b">
			            		<div class="col-sm-2 text-nowrap"><span class="red">*</span>是否应用到所有网吧：</div>
					    		<div class="col-sm-5">
									<input type="radio" id="isApply1" name="isApply" value="1" checked="checked" /> 是
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" id="isApply0" name="isApply" value="0" /> 否
								</div>
							</div>
							<div class="row m-b">
								<div id="netbarList" class="panel panel-default" style="display: none;">
    								<div class="panel-heading">
        								<h3 class="panel-title">
            								请选择网吧：
        								</h3>
    								</div>
    								<div class="panel-body">
										<input id="zNodes" type="hidden" value='${areasTree}'>
										<div class="col-sm-3">
                    						<ul id="nodeTree" class="ztree" style="padding-left: 20%;"></ul>
                    					</div>
                    					<div class="col-sm-9">
											<div id="netbarDiv">
												<input type="hidden" id="netbarIds" name="netbarIds" value="{{this.netbarIds}}">
												<c:forEach var="_netbar" items="${netbarList}">
        											<input type="checkbox" name="netbarId" value="${_netbar.id}"/>${_netbar.net_bar_name}&nbsp;&nbsp;
			                					</c:forEach>
			                				</div>
                    					</div>
    								</div>
								</div>
							</div>
						</form>
                 	</div>
                 </div>
             </div>
        </div>
	</script>
    <script>
    	$(function(){
    		initDtSearch();//表格搜索框回车查询
	        var columns = [{data:'id'},{data:'filename'},{data:'version'},{data:'md5'},
	        			   {data:'flag'},{data:'type'},{data:'action'},{data:'isApply'}];
	        var columnDefs = new Array();
    		var isVisible = $('#addRow').length>0 || $('#delAll').length>0;//权限按钮
    		columnDefs.push({targets:0, className:'text-center', orderable:false, render:optRenderAuth, visible:isVisible});//操作列
    		columnDefs.push({targets:4, render:function(data, type, row, meta){
    			if(data == "1") data = "服务端";
    			else data = "客户端";
    			return data;
    		}});
    		columnDefs.push({targets:5, render:function(data, type, row, meta){
    			if(data == "1") data = "dll";
    			else if(data == "2") data = "exe";
    			else data = "忽略";
    			return data;
    		}});
    		columnDefs.push({targets:6, render:function(data, type, row, meta){
				if(data == "1") data = "加载dll";
    			else if(data == "2") data = "运行exe";
    			else data = "忽略";
    			return data;
    		}});
    		columnDefs.push({targets:7, render:function(data, type, row, meta){
    			if(data == "1"){
    				data = "是";
    			}else{
    				data = '否';
    			}
    			return data;
    		}});
    		//表格初始化
			oTable = $('#editable').dataTable({//dom:dtDom
				scrollY: $('body').height()-260,
				scrollX: true, 
				fixedColumns: {leftColumns: 3},
				columns: columns,
	            columnDefs: columnDefs,
	            autoWidth: false,
				order:[[3, 'desc']],
				processing: true, 
				serverSide: true,
			    ajax: {url:'${basePath}/fileinfo/load', type:'POST'}, 
			    searchDelay: 300, 
			    deferRender: true//当处理大数据时，延迟渲染数据，有效提高Datatables处理能力
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			dbTable = oTable.api();//$('#editable').DataTable();//返回datatable的API实例,
		    dbTable.on('error.dt', function(e, settings, techNote, message){//出现异常时调用
		        console.log('An error has been reported by DataTables:', message);
		    });
	        //预编译模板
	        var template = Handlebars.compile($('#tpl').html());
	        var dataDialog = function(){
	        	var $this = $(this);
	        	var title = '添加文件', dataJson = {};
	        	if($this.is('i.fa-edit')){
	        		title = '编辑文件信息';
					var tr = $this.parents('tr');
					dataJson = dbTable.row(tr).data();
	        	}
	        	var $div = $(template(dataJson));
	        	BootstrapDialog.show({type:'type-default', size:'size-wide', message:$div, title:title, closable:true,
		       		 buttons: [{
		                 icon:'fa fa-save', label:'确定',
		               	 action: function(){
		               		var netbarIds = "";
		               		$("input[name='netbarId']:checked").each(function(){
		               			netbarIds = netbarIds + "," + this.value;
	                        });
		               		$('#netbarIds').val(netbarIds);
		               		
		               		$('#dataForm').submit();
		             	 }
		             }, {
		            	 icon:'fa fa-close', label: '取消',
		                 action: function(dialog){
		                	 dialog.close();
		                 }
	             	}],
            		onshown: function(dialog){
            			$("#file").on("change",function(){
                            var filename = $(this).val().split(".");
                            var i = filename.length;
                			if(filename[i-1] == "dll"){
            	    			$("#type").val("1");
            	    		}else if(filename[i-1] == "exe"){
            	    			$("#type").val("2");
            	    		}else{
            	    			$("#type").val("0");
            	    		}
                		});
                		
            			$("#filename").hide(); 
            			//编辑时页面信息特殊处理
            			if($this.is('i.fa-edit')){
            				//编辑时上传文件控件隐藏，显示文件名称文本框，且禁用
	                        $("#file").hide();
	                        $("#filename").show();
	                        $("#filename").attr("disabled", "disabled");
	                        //编辑时重置form表单提交地址
	                        $("#dataForm").attr("action", "${basePath}/fileinfo/edit");
	            			//显示是否应用到所有网吧单选按钮值
	        	        	var isApply = dataJson.isApply;
	                        $(":radio[name='isApply'][value='" + isApply + "']").prop("checked", "checked");
	                        if(isApply == 0){//如果等于0，显示网吧选择框
                   				$("#netbarList").show();
                   			}
	                        $("#flag").val(dataJson.flag);//显示文件所在模块下拉框值
	                        $("#type").val(dataJson.type);//显示文件类型下拉框值
	                        $("#action").val(dataJson.action);//显示启用方式下拉框值
	                        //显示文件关联的网吧
							var netbarIds = dataJson.netbarIds;
	                        if(netbarIds != null && netbarIds != ""){
	                        	$.each(netbarIds.split(","), function(name, value) {
	                        		//根据Value值设置checkbox为选中值
			                        $("input:checkbox[value='"+value+"']").attr('checked','true');
                               	});
	                        }
            			}
            			//地区导航树加载及事件
            			var onClick = function(event, treeId, treeNode, clickFlag) {
            				$.ajax({
            					type: 'POST', 
            					data:{"search":{"value":treeNode.id}},
            					url:'${basePath}/fileinfo/loadNetBar',//目标地址
            					success:function(data){
            						$('#netbarDiv').empty();   //清空resText里面的所有内容
                                    var html = ''; 
                                    $.each(data.data, function(name, value) {
                                    	html += '<input type="checkbox" name="netbarIds" value="'+value.id+'"/>'+value.net_bar_name+'&nbsp;&nbsp;';
                                   	});
                                    $('#netbarDiv').html(html);
            					}
            				});
                		}
                		var setting = {
               				view:{selectedMulti: false},
               				data:{simpleData:{enable:true, idKey:'id', pidKey:'pId', rootPId:0}},
               				callback: {onClick: onClick}
               			};
                		var treeObj = $.fn.zTree.init($('#nodeTree'), setting, parseJSON($('#zNodes').val()));
                		$('#zNodes').remove();
                		
                	    $(':radio').click(function(){
                   			var val = $(this).val();
                   			if(val == 0){
                   				$("#netbarList").show();
                   			}else{
                   				$("#netbarList").hide();
                   			}
    					});
               		}
	        	});
	        }
    	  	//添加新行
	        $('#addRow').click(dataDialog);
	        $('#editable tbody').on('click', 'i.fa-edit', dataDialog);
	        $('#editable tbody').on('click', 'i.fa-remove:not("i.i-remove")', function(){//删除
	    		var $this = $(this);
	    		var tr = $this.parents('tr');
				dataJson = dbTable.row(tr).data();
	    		BootstrapDialog.confirm({type:'type-default', message:'确认是否删除?', callback:function(result){
	                if(result) {
	                	var pk = tr.find('a[data-type]:first').attr('data-pk');
	                	$.com.ajax({
	    			       	url: '${basePath}/fileinfo/del',
	    		           	data:{pk:dataJson.id, name:'status', value:'0'},
	    			       	success: function(data){
	    			           	if(data.flag){
	    			           		dbTable.row(tr).remove().draw(false);
	    			           		BootstrapDialog.alert('删除成功！');
	    			           	}else{
	    			           		BootstrapDialog.alert({type:'type-danger', message:'删除失败，请刷新重试！'});
	    			           	}
	    		       		},
	    		       		error:function(){
                                BootstrapDialog.alert("删除失败，请刷新重试！");
                            }
	    				});
	                }
	            }});
	    	});
	        $('.spiner-example').hide();//移除遮罩层
		});
	</script>
</body>
</html>
