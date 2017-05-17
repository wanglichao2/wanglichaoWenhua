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
                       	<a href="${basePath}/defect/list" class="btn btn-white btn-margin-right"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                       	<a id="frozenBtn" href="javascript:;" class="btn btn-white btn-margin-right"><i class="fa fa-table"></i>&nbsp;<span>已</span>冻结</a>
                       	<shiro:hasPermission name="defect:add">
                        	<a id="addRow" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-plus"></i>&nbsp;添加</a>
	                   		<a id="picker" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-upload"></i>&nbsp;导入Excel</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="defect:del">
                        	<a id="delAll" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-remove"></i>&nbsp;批量删除</a>
                        </shiro:hasPermission>
                   		<a href="${basePath}/defect/export" class="btn btn-white"><i class="fa fa-download"></i>&nbsp;导出Excel</a>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped table-bordered table-hover " id="editable">
                            <thead>
                                <tr>
                                	<th><input type="checkbox" class="checkable"/></th>
                                	<th>操作</th>
									<th>标题</th>
									<th>主题</th>
									<th>测试阶段</th>
									<th>发现人</th>
									<th>发现日期</th>
                                	<th>分配给</th>
									<th>估计修复时间</th>
									<th>关闭日期</th>
									<th>关闭于版本</th>
									<th>计划关闭版本</th>
									<th>计划修复日期</th>
                                	<th>检测于版本</th>
									<th>检测于发布</th>
									<th>检测于周期</th>
									<th>可重现</th>
									<th>描述</th>
									<th>目标发布</th>
                                	<th>目标周期</th>
									<th>取消或拒绝理由</th>
									<th>缺陷ID</th>
									<th>缺陷类别</th>
									<th>缺陷状态</th>
									<th>实际修复时间</th>
                                	<th>项目</th>
									<th>修改日期</th>
									<th>严重度</th>
									<th>优先级</th>
									<th>注释</th>
									<th>状态</th>
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
    <script src="${basePath}/js/json3.min.js"></script>
    <script src="${basePath}/js/dataTables/jquery.dataTables.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.bootstrap.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.extends.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.fixedColumns.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.table.js"></script>
    <script src="${basePath}/js/datetimepicker/bootstrap-datetimepicker.min.js"></script>
    <script src="${basePath}/js/datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
    <script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
    <script src="${basePath}/js/select2/select2.full.min.js"></script>
    <script src="${basePath}/js/select2/zh-CN.js"></script>
    <script src="${basePath}/js/validate/jquery.validate.min.js"></script>
    <script src="${basePath}/js/validate/messages_zh.min.js"></script>
    <script src="${basePath}/js/handlebars.js"></script>
    <script src="${basePath}/js/uniform/jquery.uniform.js"></script>
    <script src="${basePath}/js/webuploader/webuploader.min.js"></script>
    <script src="${basePath}/js/blueimp/jquery.blueimp-gallery.min.js"></script>
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <!--定义HTML模板-->
	<script id="tpl" type="text/x-handlebars-template">
		<div class="tabs-container">
             <ul class="nav nav-tabs">
                 <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true">详细信息</a></li>
				{{#if this.id}}
                 <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">上传图片</a></li>
				{{/if}}
             </ul>
             <div class="tab-content">
                 <div id="tab-1" class="tab-pane active">
                     <div class="panel-body">
						<form class="form-horizontal" id="dataForm">
                        <input type="hidden" id="id" name="id" value="{{this.id}}">
		    			<div class="row m-b">
			    	    	<div class="col-sm-1 text-nowrap l-h">缺陷ID：</div>
					    	<div class="col-sm-3"><input type="text" id="qxid" name="qxid" value="{{this.qxid}}" class="form-control"></div>
			    	    	<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;标题：</div>
					    	<div class="col-sm-7"><input type="text" id="bt" name="bt" class="form-control" value="{{this.bt}}" required></div>
					    </div>
					    <div class="row m-b">	
			            	<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;主题：</div>
					    	<div class="col-sm-3"><input type="text" id="zt" name="zt" value="{{this.zt}}" class="form-control" required></div>
			            	<div class="col-sm-1 text-nowrap l-h">测试阶段：</div>
					    	<div class="col-sm-3"><input type="text" id="csjd" name="csjd" value="{{this.csjd}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;发现人：</div>
					    	<div class="col-sm-3"><input type="text" id="fxr" name="fxr" value="{{this.fxr}}" class="form-control" required></div>
			            </div>
			            <div class="row m-b">	
			            	<div class="col-sm-1 text-nowrap l-h">发现日期：</div>
					    	<div class="col-sm-3">
					    		<div id="d_fxrq" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="fxrq" name="fxrq" value="{{this.fxrq}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            	<div class="col-sm-1 text-nowrap l-h">分配给：</div>
					    	<div class="col-sm-3"><input type="text" id="fpg" name="fpg" value="{{this.fpg}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap">估计修复<br/>时间：</div>
					    	<div class="col-sm-3">
					    		<div id="d_gjxfsj" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="gjxfsj" name="gjxfsj" value="{{this.gjxfsj}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap l-h">关闭日期：</div>
					    	<div class="col-sm-3">
					    		<div id="d_gbrq" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="gbrq" name="gbrq" value="{{this.gbrq}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            	<div class="col-sm-1 text-nowrap">关闭于<br/>版本：</div>
					    	<div class="col-sm-3"><input type="text" id="gbybb" name="gbybb" value="{{this.gbybb}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap">计划关闭<br/>版本：</div>
					    	<div class="col-sm-3"><input type="text" id="jhgbbb" name="jhgbbb" value="{{this.jhgbbb}}" class="form-control"></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap">计划修复<br/>日期：</div>
					    	<div class="col-sm-3">
					    		<div id="d_jhxfrq" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="jhxfrq" name="jhxfrq" value="{{this.jhxfrq}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            	<div class="col-sm-1 text-nowrap">检测于<br/>版本：</div>
					    	<div class="col-sm-3"><input type="text" id="jcybb" name="jcybb" value="{{this.jcybb}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap">检测于<br/>发布：</div>
					    	<div class="col-sm-3"><input type="text" id="jcyfb" name="jcyfb" value="{{this.jcyfb}}" class="form-control"></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap">检测于<br/>周期：</div>
					    	<div class="col-sm-3"><input type="text" id="jcyzq" name="jcyzq" value="{{this.jcyzq}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">可重现：</div>
					    	<div class="col-sm-3"><input type="text" id="kcx" name="kcx" value="{{this.kcx}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">目标发布：</div>
					    	<div class="col-sm-3"><input type="text" id="mbfb" name="mbfb" value="{{this.mbfb}}" class="form-control"></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap l-h">目标周期：</div>
					    	<div class="col-sm-3"><input type="text" id="mbzq" name="mbzq" value="{{this.mbzq}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">缺陷类别：</div>
					    	<div class="col-sm-3"><input type="text" id="qxlb" name="qxlb" value="{{this.qxlb}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">缺陷状态：</div>
					    	<div class="col-sm-3"><select type="text" id="qxzt" name="qxzt" class="form-control">
					    		<c:forEach var="SP" items="${sysParam.SP002}">
			                      	<option value="${SP.value}">${SP.value}</option>          		
			                	</c:forEach>
					    	</select></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap">实际修复<br/>时间：</div>
					    	<div class="col-sm-3">
					    		<div id="d_sjxfsj" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="sjxfsj" name="sjxfsj" value="{{this.sjxfsj}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            	<div class="col-sm-1 text-nowrap l-h">项目：</div>
					    	<div class="col-sm-3"><input type="text" id="xm" name="xm" value="{{this.xm}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">修改日期：</div>
					    	<div class="col-sm-3">
					    		<div id="d_xgrq" class="input-append date" style="display: inline-table;">
					    			<input type="text" id="xgrq" name="xgrq" value="{{this.xgrq}}" class="form-control" readonly>
					    			<span class="add-on input-group-btn">
					    				<button class="btn default" type="button" style="padding: 9px 12px;">
					    					<i class="fa fa-calendar"></i></button>
					    			</span>
					    		</div>						
					    	</div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-1 text-nowrap l-h">严重度：</div>
					    	<div class="col-sm-3"><input type="text" id="yzd" name="yzd" value="{{this.yzd}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">优先级：</div>
					    	<div class="col-sm-3"><input type="text" id="yxj" name="yxj" value="{{this.yxj}}" class="form-control"></div>
			            	<div class="col-sm-1 text-nowrap l-h">状态：</div>
					    	<div class="col-sm-3"><input type="text" id="sjzt" name="sjzt" value="{{this.sjzt}}" class="form-control"></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-2 text-nowrap">描述：</div>
					    	<div class="col-sm-10"><textarea id="ms" name="ms" class="form-control">{{this.ms}}</textarea></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-2 text-nowrap">取消或拒绝理由：</div>
					    	<div class="col-sm-10"><textarea id="qxhjjly" name="qxhjjly" class="form-control">{{this.qxhjjly}}</textarea></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-2 text-nowrap">注释：</div>
					    	<div class="col-sm-10"><textarea id="zs" name="zs" class="form-control">{{this.zs}}</textarea></div>
			            </div>
			            <div class="row m-b">		
			            	<div class="col-sm-2 text-nowrap">关联用例：</div>
					    	<div class="col-sm-10"><select id="ylid" name="ylid" class="form-control" multiple>
					    		<c:forEach var="_case" items="${caseSet}">
			                      	<option value="${_case.id}">${_case.ylms}</option>          		
			                	</c:forEach>
					    	</select></div>
			            </div>
						</form>
                     </div>
                 </div>
				 {{#if this.id}}
                 <div id="tab-2" class="tab-pane">
                     <div class="panel-body">
						 <div class="row">
							<div class="col-sm-12">
								<a id="imgPicker" href="javascript:void(0);" class="btn btn-white"><i class="fa fa-upload"></i>&nbsp;选择图片</a></div>
						 </div>
                         <div class="lightBoxGallery">
                            <div id="blueimp-gallery" class="blueimp-gallery">
                                <div class="slides"></div>
                                <h3 class="title"></h3>
                                <a class="prev"><</a>
                                <a class="next">></a>
                                <a class="close">×</a>
                                <a class="play-pause"></a>
                                <ol class="indicator"></ol>
                            </div>
                        </div>
                     </div>
                 </div>
				{{/if}}
             </div>
        </div>
	</script>
    <script>
    	$(function(){
    		var editUrl = '${basePath}/defect/edit';
    		initDtSearch();//表格搜索框回车查询
	        var columns = [{data:'id'},{data:'ylid'},{data:'bt'},{data:'zt'},{data:'csjd'},{data:'fxr'},{data:'fxrq'},{data:'fpg'},
	                       {data:'gjxfsj'},{data:'gbrq'},{data:'gbybb'},{data:'jhgbbb'},{data:'jhxfrq'},{data:'jcybb'},
	                       {data:'jcyfb'},{data:'jcyzq'},{data:'kcx'},{data:'ms'},{data:'mbfb'},{data:'mbzq'},{data:'qxhjjly'},
	                       {data:'qxid'},{data:'qxlb'},{data:'qxzt'},{data:'sjxfsj'},{data:'xm'},{data:'xgrq'},{data:'yzd'},
	                       {data:'yxj'},{data:'zs'},{data:'sjzt'}];
	        var columnDefs = new Array();
    		columnDefs.push({targets:0, className:'text-center', orderable:false, render:cbRender});//第一列不参与排序
    		var isVisible = $('#addRow').length>0 || $('#delAll').length>0;//权限按钮
    		columnDefs.push({targets:1, className:'text-center', orderable:false, render:optRenderAuth, visible:isVisible});//操作列
    		columnDefs.push({targets:6, render:function(data, type, row, meta){return formatDate(data, 'yyyy/MM/dd');}});
    		columnDefs.push({targets:8, render:function(data, type, row, meta){return formatDate(data);}});
    		columnDefs.push({targets:9, render:function(data, type, row, meta){return formatDate(data);}});
    		columnDefs.push({targets:12, render:function(data, type, row, meta){return formatDate(data);}});
    		columnDefs.push({targets:24, render:function(data, type, row, meta){return formatDate(data);}});
    		columnDefs.push({targets:26, render:function(data, type, row, meta){return formatDate(data);}});
			//表格初始化
			oTable = $('#editable').dataTable({//dom:dtDom
				scrollY: $('body').height()-260,
				scrollX: true, fixedColumns:{leftColumns: 3},
				columns:columns,
	            columnDefs:columnDefs,autoWidth:false,
				order:[[6, 'desc']],
				processing: true, serverSide: true,//pipeline pages 管道式分页加载数据，减少ajax请求
			    //ajax: $.fn.dataTable.pipeline({url:'${basePath}/defect/load', type:'POST', dataSrc:drawData, pages:5}),
			    ajax: {url:'${basePath}/defect/load', type:'POST'}, 
			    searchDelay: 300, deferRender: true,//当处理大数据时，延迟渲染数据，有效提高Datatables处理能力
	           	//initComplete: function(settings, json){},//初始化结束后的回调函数
			    drawCallback: function(settings){//Datatables每次重绘后执行
			    	$('input[type="checkbox"].checkable').uniform();
	    			initCheckbox();
	    			$('.table th input.checkable').prop('checked', false).parent('span').removeClass('checked');
			    }
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			dbTable = oTable.api();//$('#editable').DataTable();//返回datatable的API实例,
			//dbTable.on('xhr.dt', function(e, settings, json, xhr){});//ajax事件-当datatable发送ajax请求完成时
		    dbTable.on('error.dt', function(e, settings, techNote, message){//出现异常时调用
		        console.log('An error has been reported by DataTables:', message);
		    });
	        //预编译模板
	        var template = Handlebars.compile($('#tpl').html());
	        var dataDialog = function(){
	        	var $this = $(this);
	        	var title = '添加缺陷', dataJson = {};
	        	if($this.is('i.fa-edit')){
	        		title = '编辑缺陷';
					var tr = $this.parents('tr');
					dataJson = dbTable.row(tr).data();
					dataJson.fxrq = formatDate(dataJson.fxrq, 'yyyy/MM/dd');
					dataJson.gjxfsj = formatDate(dataJson.gjxfsj);
					dataJson.gbrq = formatDate(dataJson.gbrq);
					dataJson.jhxfrq = formatDate(dataJson.jhxfrq);
					dataJson.sjxfsj = formatDate(dataJson.sjxfsj);
					dataJson.xgrq = formatDate(dataJson.xgrq);
	        	}
	        	var $div = $(template(dataJson));
	        	BootstrapDialog.show({type:'type-default', size:'size-wide', message:$div, title:title, closable:true,
		       		 buttons: [{
		                 icon:'fa fa-save', label:'确定',
		               	 action: function(){
		               		$('#dataForm').submit();
		             	 }
		             }, {
		            	 icon:'fa fa-close', label: '取消',
		                 action: function(dialog){
		                	 dialog.close();
		                 }
	             	}],
            		onshown: function(dialog){
            			$('#qxzt', $div).val(dataJson.qxzt);
            			$('#dataForm', $div).validate({
            				submitHandler: function(form){//提交事件      
            					$.com.ajax({
            				       	url:'${basePath}/defect/add', 
            				       	data:$(form).serialize(),
            				       	success: function(data){
            				       		if(data.flag){
            				       			dialog.close();
            				       			dbTable.ajax.reload(null, false);
            				       		}else{
            				           		BootstrapDialog.alert({type:'type-danger', message:'保存失败，请刷新重试！'});
            				           	} 
            			       		}
            					});  
            			   	}  
            			});
                 		$('#d_fxrq', $div).datetimepicker({
                			format:'yyyy/mm/dd',
                			minView:3,
                			language:'zh-CN',
                			pickerPosition:'bottom-left'
                		});
                 		$('#d_gjxfsj, #d_gbrq, #d_jhxfrq, #d_sjxfsj, #d_xgrq', $div).datetimepicker({
                			format:'yyyy/mm/dd hh:ii',
                			minView:0,
                			language:'zh-CN',
                			pickerPosition:'bottom-left'
                		});
                 		$('#ylid', $div).val(dataJson.ylid.split(',')).select2({language:'zh-CN',theme:'bootstrap',placeholder:'请选择关联的用例'});
                	    if($this.is('i.fa-edit')){//编辑时用
	                 		//图片上传初始化
	                	    var imgUploader = null,
	                	    innerImg = function(objSet){
	                	    	var h = '';
					       		$(objSet).each(function(i, val){
					       			var imgSrc = '${basePath}/upload/photos/'+dataJson.id+'/'+val;
					       			h += '<a href="'+imgSrc+'" title="'+val+'" data-gallery=""><img src="'+imgSrc+'"></a>';
					       		});
					       		$('.lightBoxGallery a[data-gallery]').remove();
					       		$('.lightBoxGallery').prepend(h);
	                 		}
	                	    $.com.ajax({
	    				       	url:'${basePath}/defect/readImg/'+dataJson.id, 
	    				       	success: function(data){
	    				       		innerImg(data.obj);
	    			       		}
	    					});
	                	    $('a[data-toggle="tab"]').on('show.bs.tab', function (e) {
	                	    	if($(e.target).attr('href')=='#tab-2' && imgUploader==null){ // 激活的标签页
		                	    	 imgUploader = WebUploader.create({
		                     	        auto: true,//选完文件后，是否自动上传。
		                     	        swf: '${basePath}/js/webuploader/Uploader.swf',//swf文件路径
		                     	        server: '${basePath}/defect/uploadImg',// 文件接收服务端。
		                     	        pick:{id: '#imgPicker', multiple:false},//multiple是否多选文件
		                     	        accept: {
		                     	        	title: '选择图片',
		                     	            extensions: 'jpg,jpeg,png',
		                     	            mimeTypes: 'image/jpg,image/jpeg,image/png'
		                     	        }
		                     	    }).on('uploadBeforeSend', function(obj, data) {
		        			            data.id=dataJson.id;//传入id
		        			        }).on('uploadSuccess', function(file, response){
		        			        	innerImg(response.obj);
		        		    	    }).on('uploadComplete', function(file){
		                     	    	imgUploader.reset();
	                	    	    });
	                	    	}
	               	    	});
                	    }
               		}
	        	});
	        };
    	  	//添加新行
	        $('#addRow').click(dataDialog);
	        $('#editable tbody').on('click', 'i.fa-edit', dataDialog);
	      	//初始化Web Uploader
    	    var uploader = WebUploader.create({
    	        auto: true,//选完文件后，是否自动上传。
    	        swf: '${basePath}/js/webuploader/Uploader.swf',//swf文件路径
    	        server: '${basePath}/defect/importData',// 文件接收服务端。
    	        pick:{id:'#picker', multiple:false},//multiple是否多选文件
    	        accept: {
    	            title: '选择Excel',//mimeTypes只允许选择excel文件。
    	            mimeTypes:'application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
    	        }
    	    });
    	 	//文件上传过程中创建进度条实时显示。
    	    uploader.on('uploadProgress', function(file, percentage){
    	    	$('.spiner-example').show();
    	    });
    	    //文件上传成功，给item添加成功class, 用样式标记上传成功。
    	    uploader.on('uploadSuccess', function(file, response){
    	    	var msg = response.msg;
    	    	if(response.flag){
	    	    	BootstrapDialog.alert({type:'type-default', message:'数据导入成功！', callback:function(){
	    	    		window.location.href='${basePath}/defect/list';//刷新页面
	        	    }});
    	    	}else{
    	    		BootstrapDialog.alert({type:'type-danger', message:msg, size:BootstrapDialog.SIZE_NORMAL});
    	    	}
    	    });
    	    //文件上传失败，显示上传出错。
    	    uploader.on('uploadError', function(file){
    	    	BootstrapDialog.alert({type:'type-danger', message:'文件上传失败，请刷新重试！'});
    	    });
    	    //完成上传完了，成功或者失败，先清除文件队列。
    	    uploader.on('uploadComplete', function(file){
    	    	$('.spiner-example').hide();
    	    	uploader.reset();
    	    });
    	    delBatch('${basePath}/defect/delBatch');//批量删除
	        initEvent(editUrl);
	        $('.spiner-example').hide();//移除遮罩层
		});
	</script>
</body>
</html>
