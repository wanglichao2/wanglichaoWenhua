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
		<script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.editable.js"></script>
		<link rel="stylesheet" href="${basePath}/css/datetimepicker/bootstrap-datetimepicker.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/bootstrap-dialog/bootstrap-dialog.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/select2/select2.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/uniform/uniform.css"/>
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/webuploader/webuploader.css" />
		<link rel="stylesheet" href="${basePath}/css/style.min.css"/>
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
                       	<a href="${basePath}/case/list" class="btn btn-white btn-margin-right"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                       	<a id="frozenBtn" href="javascript:;" class="btn btn-white btn-margin-right"><i class="fa fa-table"></i>&nbsp;<span>已</span>冻结</a>
                       	<shiro:hasPermission name="case:add">
                        	<a id="addRow" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-plus"></i>&nbsp;添加</a>
	                   		<a id="picker" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-upload"></i>&nbsp;导入Excel</a>
                        </shiro:hasPermission>
                        <shiro:hasPermission name="case:del">
                        	<a id="delAll" href="javascript:void(0);" class="btn btn-white btn-margin-right"><i class="fa fa-remove"></i>&nbsp;批量删除</a>
                        </shiro:hasPermission>
                   		<a href="${basePath}/case/export" class="btn btn-white"><i class="fa fa-download"></i>&nbsp;导出Excel</a>
                    </div>
                    <div class="ibox-content">
                        <table class="table table-striped table-bordered table-hover " id="editable">
                            <thead>
                                <tr>
                                	<th><input type="checkbox" class="checkable"/></th>
									<th>操作</th>
									<th>用例描述</th>
									<th>更改状态</th>
									<th>创建日期</th>
                                	<th>设计者</th>
									<th>估计开发时间</th>
									<th>执行状态</th>
									<th>修改时间</th>
									<th>路径</th>
									<th>数据状态</th>
                                	<th>主题</th>
									<th>模板</th>
									<th>测试ID</th>
									<th>用例名称</th>
									<th>类型</th>
									<th>测试模式</th>
                                	<th>测试数据</th>
									<th>测试用例编号</th>
									<th>测试用例状态</th>
									<th>工作模式</th>
									<th>前置条件</th>
									<th>涉及的关联系统</th>
                                	<th>审阅状态</th>
									<th>所属子系统</th>
									<th>协议类型</th>
									<th>用例复用状态</th>
									<th>用例性质</th>
									<th>优先级</th>
									<th>注释</th>
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
    <script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
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
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <!--定义HTML模板-->
	<script id="tpl" type="text/x-handlebars-template">
		<form class="form-horizontal" id="dataForm">
		<input type="hidden" id="id" name="id" value="{{this.id}}">
		<div class="row m-b">
    		<div class="col-sm-1 text-nowrap l-h">用例ID：</div>
			<div class="col-sm-3"><input type="text" id="csid" name="csid" value="{{this.csid}}" class="form-control"></div>
    		<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;用例描述：</div>
			<div class="col-sm-7"><input type="text" id="ylms" name="ylms" class="form-control" value="{{this.ylms}}" required></div>
		</div>
		<div class="row m-b">	
        	<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;主题：</div>
			<div class="col-sm-3"><input type="text" id="zt" name="zt" value="{{this.zt}}" class="form-control" required></div>
        	<div class="col-sm-1 text-nowrap l-h">更改状态：</div>
			<div class="col-sm-3"><input type="text" id="ggzt" name="ggzt" value="{{this.ggzt}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">创建日期：</div>
			<div class="col-sm-3">
				<div id="d_cjrq" class="input-append date" style="display: inline-table;">
					<input type="text" id="cjrq" name="cjrq" value="{{this.cjrq}}" class="form-control" readonly>
					<span class="add-on input-group-btn">
						<button class="btn default" type="button" style="padding: 9px 12px;">
							<i class="fa fa-calendar"></i></button>
					</span>
				</div>						
			</div>
        </div>
        <div class="row m-b">	
        	<div class="col-sm-1 text-nowrap l-h"><span class="red">*</span>&nbsp;设计者：</div>
			<div class="col-sm-3"><input type="text" id="sjz" name="sjz" value="{{this.sjz}}" class="form-control" required></div>
        	<div class="col-sm-1 text-nowrap">估计开发<br/>时间：</div>
			<div class="col-sm-3">
				<div id="d_gjkfsj" class="input-append date" style="display: inline-table;">
					<input type="text" id="gjkfsj" name="gjkfsj" value="{{this.gjkfsj}}" class="form-control" readonly>
					<span class="add-on input-group-btn">
						<button class="btn default" type="button" style="padding: 9px 12px;">
							<i class="fa fa-calendar"></i></button>
					</span>
				</div>						
			</div>
        	<div class="col-sm-1 text-nowrap l-h">执行状态：</div>
			<div class="col-sm-3"><input type="text" id="zxzt" name="zxzt" value="{{this.zxzt}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap l-h">修改时间：</div>
			<div class="col-sm-3">
				<div id="d_xgsj" class="input-append date" style="display: inline-table;">
					<input type="text" id="xgsj" name="xgsj" value="{{this.xgsj}}" class="form-control" readonly>
					<span class="add-on input-group-btn">
						<button class="btn default" type="button" style="padding: 9px 12px;">
							<i class="fa fa-calendar"></i></button>
					</span>
				</div>						
			</div>
        	<div class="col-sm-1 text-nowrap l-h">路径：</div>
			<div class="col-sm-3"><input type="text" id="lj" name="lj" value="{{this.lj}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">数据状态：</div>
			<div class="col-sm-3"><input type="text" id="sjzt" name="sjzt" value="{{this.sjzt}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap l-h">模板：</div>
			<div class="col-sm-3"><input type="text" id="mb" name="mb" value="{{this.mb}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">用例名称：</div>
			<div class="col-sm-3"><input type="text" id="csmc" name="csmc" value="{{this.csmc}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">类型：</div>
			<div class="col-sm-3"><input type="text" id="lx" name="lx" value="{{this.lx}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap l-h">测试模式：</div>
			<div class="col-sm-3"><input type="text" id="csms" name="csms" value="{{this.csms}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">测试数据：</div>
			<div class="col-sm-3"><input type="text" id="cssj" name="cssj" value="{{this.cssj}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap">测试用例<br/>编号：</div>
			<div class="col-sm-3"><input type="text" id="csylbh" name="csylbh" value="{{this.csylbh}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap">测试用例<br/>状态：</div>
			<div class="col-sm-3"><input type="text" id="csylzt" name="csylzt" value="{{this.csylzt}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">工作模式：</div>
			<div class="col-sm-3"><input type="text" id="gzms" name="gzms" value="{{this.gzms}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">前置条件：</div>
			<div class="col-sm-3"><input type="text" id="qztj" name="qztj" value="{{this.qztj}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap">涉及的<br/>关联系统：</div>
			<div class="col-sm-3"><input type="text" id="sjdglxt" name="sjdglxt" value="{{this.sjdglxt}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">审阅状态：</div>
			<div class="col-sm-3"><input type="text" id="syzt" name="syzt" value="{{this.syzt}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap">所属子<br/>系统：</div>
			<div class="col-sm-3"><input type="text" id="sszxt" name="sszxt" value="{{this.sszxt}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap l-h">协议类型：</div>
			<div class="col-sm-3"><input type="text" id="xylx" name="xylx" value="{{this.xylx}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap">用例复用<br/>状态：</div>
			<div class="col-sm-3"><input type="text" id="ylfyzt" name="ylfyzt" value="{{this.ylfyzt}}" class="form-control"></div>
        	<div class="col-sm-1 text-nowrap l-h">用例性质：</div>
			<div class="col-sm-3"><input type="text" id="ylxz" name="ylxz" value="{{this.ylxz}}" class="form-control"></div>
        </div>
        <div class="row m-b">		
        	<div class="col-sm-1 text-nowrap">优先级：</div>
			<div class="col-sm-3"><input type="text" id="yxj" name="yxj" value="{{this.yxj}}" class="form-control"></div>
        </div>
		<div class="row m-b">		
        	<div class="col-sm-2 text-nowrap">注释：</div>
			<div class="col-sm-10"><textarea id="zs" name="zs" class="form-control">{{this.zs}}</textarea></div>
        </div>
		</form>
	</script>
    <script>
    	$(function(){
    		var editUrl = '${basePath}/case/edit';
    		initDtSearch();//表格搜索框回车查询
	        var columns = [{data:'id'},{data:'id'},{data:'ylms'},{data:'ggzt'},{data:'cjrq'},{data:'sjz'},{data:'gjkfsj'},{data:'zxzt'},
	                       {data:'xgsj'},{data:'lj'},{data:'sjzt'},{data:'zt'},{data:'mb'},{data:'csid'},{data:'csmc'},{data:'lx'},
	                       {data:'csms'},{data:'cssj'},{data:'csylbh'},{data:'csylzt'},{data:'gzms'},{data:'qztj'},{data:'sjdglxt'},
	                       {data:'syzt'},{data:'sszxt'},{data:'xylx'},{data:'ylfyzt'},{data:'ylxz'},{data:'yxj'},{data:'zs'}];
	        var columnDefs = new Array();
    		columnDefs.push({targets:0, className:'text-center', orderable:false, render:cbRender});//第一列不参与排序
    		var isVisible = $('#addRow').length>0 || $('#delAll').length>0;//权限按钮
    		columnDefs.push({targets:1, className:'text-center', orderable:false, render:optRenderAuth, visible:isVisible});//操作列
    		columnDefs.push({targets:4, render:function(data, type, row, meta){return formatDate(data, 'yyyy/MM/dd');}});
    		columnDefs.push({targets:6, render:function(data, type, row, meta){return formatDate(data);}});
    		columnDefs.push({targets:8, render:function(data, type, row, meta){return formatDate(data);}});
			//表格初始化
			oTable = $('#editable').dataTable({//dom:dtDom
				scrollY: $('body').height()-260,
				scrollX: true, fixedColumns:{leftColumns: 3},
				columns:columns,
	            columnDefs:columnDefs,autoWidth:false,
				order:[[4, 'desc']],
				processing: true, serverSide: true,//pipeline pages 管道式分页加载数据，减少ajax请求
			    //ajax: $.fn.dataTable.pipeline({url:'${basePath}/case/load', type:'POST', dataSrc:drawData, pages:5}),
			    ajax: {url:'${basePath}/case/load', type:'POST'},//dataSrc表格数据渲染数据加工的方法
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
	        	var title = '添加用例', dataJson = {};
	        	if($this.is('i.fa-edit')){
	        		title = '编辑用例';
					var tr = $this.parents('tr');
					dataJson = dbTable.row(tr).data();
					dataJson.cjrq = formatDate(dataJson.cjrq, 'yyyy/MM/dd');
					dataJson.gjkfsj = formatDate(dataJson.gjkfsj);
					dataJson.xgsj = formatDate(dataJson.xgsj);
	        	}
	        	BootstrapDialog.show({type:'type-default', size:'size-wide', message:$(template(dataJson)), title:title, closable:true,
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
            			$('#dataForm').validate({
            				submitHandler: function(form){//提交事件      
            					$.com.ajax({
            				       	url:'${basePath}/case/add', 
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
	             		$('#d_cjrq').datetimepicker({
	            			format:'yyyy/mm/dd',
	            			minView:3,
	            			language:'zh-CN',
	            			pickerPosition:'bottom-left'
	            		});
	             		$('#d_gjkfsj, #d_xgsj').datetimepicker({
	            			format:'yyyy/mm/dd hh:ii',
	            			minView:0,
	            			language:'zh-CN',
	            			pickerPosition:'bottom-left'
	            		});
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
    	        server: '${basePath}/case/importData',// 文件接收服务端。
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
	    	    		window.location.href='${basePath}/case/list';//刷新页面
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
    	    delBatch('${basePath}/case/delBatch');//批量删除
	        initEvent(editUrl);
	        $('.spiner-example').hide();//移除遮罩层
		});
	</script>
</body>
</html>
