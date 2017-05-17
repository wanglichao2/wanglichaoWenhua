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
		<link rel="stylesheet" href="${basePath}/css/animate.min.css"/>
		<link rel="stylesheet" href="${basePath}/css/ztree/ztree.css"/>
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
                       	<a href="${basePath}/netbarList/list" class="btn btn-white btn-margin-right"><i class="fa fa-refresh"></i>&nbsp;刷新</a>
                       	<a id="export" href="javascript:void(0);" class="btn btn-white"><i class="fa fa-download"></i>&nbsp;导出Excel</a>
                       	<input id="zNodes" type="hidden" value='${areasTree}'>
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
		                                    <th>市</th>
											<th>在线网吧数</th>
											<th>离线网吧数</th>
											<th>机器总数</th>
											<th>当前用户总数</th>
		                                </tr>
		                            </thead>
		                            <tbody>
		                            	<c:forEach var="stat" items="${statList}">
		                            		<tr>
												<td>${stat.areaName}</td>
												<td>${stat.online}</td>
												<td>${stat.offline}</td>
												<td>${stat.pcTotal}</td>
												<td>${stat.login}</td>
											</tr>
		                            	</c:forEach>
		                            </tbody>
		                            <tfoot>
			                            <tr>
			                            	<th>河南省  总计</th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
										<tr>
		                                    <th colspan="10" style="text-align:right;">
		                                    	<span id="showChart">历史曲线图</span>
		                                    </th>
		                                </tr>
	                                </tfoot>
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
    <script src="${basePath}/js/bootstrap-editable/bootstrap-editable.min.js"></script>
    <script src="${basePath}/js/dataTables/dataTables.editable.js"></script>
    <script src="${basePath}/js/bootstrap-dialog/bootstrap-dialog.min.js"></script>
    <script src="${basePath}/js/handlebars.js"></script>
    <script src="${basePath}/js/Chart/Chart.js"></script>
	<script src="${basePath}/js/Chart/Chart.min.js"></script>
    <script src="${basePath}/js/ztree/jquery.ztree.min.js"></script>
    <script src="${basePath}/js/content.min.js?v=1.0.0"></script>
    <script src="${basePath}/js/common.js" charset="utf-8"></script>
    <script id="tpl" type="text/x-handlebars-template">
    	<div id="chartDiv" class="tabs-container">
			<div id="chart_line_legend"></div>
    		<canvas id="myChart" width="800" height="300"></canvas>
    	</div>
    </script>
    <script>
    	$(document).ready(function(){
    		var id = "";
    		var parentId = "";
    		var areaName = "";
    		var onClick = function(event, treeId, treeNode, clickFlag) {
				var url = '${basePath}/netbarList/loadProvinceCityBar';
				id = treeNode.id;
				parentId = treeNode.pId;
				areaName = treeNode.name;
				var columns = [{data:'areaName'},{data:'online'},{data:'offline'},{data:'pcTotal'},{data:'login'}];
				//再次查询时先删除editable，如果少了以下语句每次只能查询一次，第二次点击查询就不执行。
				var table = $('#editable').dataTable();
				if(table){
					table.fnDestroy();
				}
    			//获取dataTable的第一行所有单元格
    			var cells = table[0].rows[0].cells;
				if(treeNode.pId == 0){
    				//修改表头
    				cells[0].textContent = '市';
    				cells[1].textContent = '在线网吧数';
	        		cells[2].textContent = '离线网吧数';
	        		cells[3].textContent = '机器总数';
	        		cells[4].textContent = '当前用户总数';
	        	}else if(treeNode.pId == 410000){
	        		//修改表头
	        		cells[0].textContent = '县';
	        		cells[1].textContent = '在线网吧数';
	        		cells[2].textContent = '离线网吧数';
	        		cells[3].textContent = '机器总数';
	        		cells[4].textContent = '当前用户总数';
	        	}else{
	        		//修改表头
	        		cells[0].textContent = '网吧列表';
	        		cells[1].textContent = '在线终端数';
	        		cells[2].textContent = '离线终端数';
	        		cells[3].textContent = '有效终端数';
	        		cells[4].textContent = '服务端版本';
	        		
	        		//更换URL，并传递节点ID参数
	        		url = '${basePath}/netbarList/loadAreasBar';
	        		columns = [{data:'barName'},{data:'online'},{data:'offline'},{data:'valid'},{data:'serverVersion'}];
	        	}
        		
        		//省级表格初始化
        		$('#editable').dataTable({
        			columns: columns,
        			columnDefs:[{
        				targets:0, 
        				orderable:false
        			}],
    				order: [[0, 'asc']],//定义列表的初始排序设定
    				paging:false,
    				processing: true, //控制是否在数据加载时出现”Processing”的提示
    				serverSide: true,//pipeline pages 管道式分页加载数据，减少ajax请求
    				/* ajax: $.fn.dataTable.pipeline({
    					url:url,
    					type:'POST', 
    					data: {"search":{"value":id}},
    					dataSrc:drawData
    				}), */
   				 	ajax: {
    			    	url: url, 
    			    	data: {"search":{"value":id}},
    			    	type: 'POST', 
    			    	dataSrc: function(result){
    			    		var online = 0,offline = 0,pcTotal = 0, login = 0;
    			    		$.each(result.data,function(index,value){
    			    			online = online + parseInt(value.online);
    			    			offline = offline + parseInt(value.offline);
    			    			if(parentId == 410000 || parentId == 0){
    			    				pcTotal = pcTotal + parseInt(value.pcTotal);
    			    			}else{
    			    				pcTotal = pcTotal + parseInt(value.valid);
    			    			}
    			    			login = login + parseInt(value.login);
    			    		});
    			    		var tfoot = $('#editable').find('tfoot');
    			    		tfoot[0].rows[0].cells[0].textContent = areaName+" 总计";
    			    		tfoot[0].rows[0].cells[1].textContent = online;
    			    		tfoot[0].rows[0].cells[2].textContent = offline;
    			    		tfoot[0].rows[0].cells[3].textContent = pcTotal;
    			    		if(parentId == 410000 || parentId == 0){
    			    			tfoot[0].rows[0].cells[4].textContent = login;
    			    		}else{
    			    			tfoot[0].rows[0].cells[4].textContent = "";
    			    		}
    			    		return drawData(result);
   			    		}
   			    	},//dataSrc表格数据渲染数据加工的方法
    			    searchDelay: 300,
    			    deferRender: true,//当处理大数据时，延迟渲染数据，有效提高Datatables处理能力
    	           	drawCallback: function(settings){//Datatables每次重绘后执行
    	           		var tr = $('tbody tr.newRow');//初始化新增行的编辑插件
    	           		afterAddRow(tr);
    	           		optTag = null;//重置操作标识
    			     }
        		});//返回JQuery对象，api()方法添加到jQuery对象,访问API. 
    		}
    		var setting = {
   				view:{selectedMulti: false},
   				data:{simpleData:{enable:true, idKey:'id', pidKey:'pId', rootPId:0}},
   				callback: {onClick: onClick}
   			};
    		
    		var treeObj = $.fn.zTree.init($('#nodeTree'), setting, parseJSON($('#zNodes').val()));
    		$('#zNodes').remove();

    		//initDtSearch();//表格搜索框回车查询
    		//表格初始化
			oTable = $('#editable').dataTable({
				order:[[0, 'asc']],//scrollX:true,
				columnDefs:[{targets:0, orderable:false}],
				paging:false
			});//返回JQuery对象，api()方法添加到jQuery对象,访问API.
			dbTable = oTable.api();//返回datatable的API实例,
			total();
			
			$('#export').click(function(){
				window.location.href="${basePath}/netbarList/export?id="+id+"&parentId="+parentId+"&areaName="+areaName;
			});
			
			//预编译模板
	        var template = Handlebars.compile($('#tpl').html());
			$('#showChart').click(function(){
	        	var $this = $(this);
	        	var title = '曲线图';
	        	var $div = $(template());
	        	$.ajax({
	        		type: 'POST', 
	        		data:{"id":id,"parentId":parentId},
                	url:'${basePath}/netbarList/getChart', 
                    success:function(data){
                    	var obj = data.obj;
                    	var data = {
          					labels : obj.x,//X轴（日期）
          					datasets : [
          						{
          							label: obj.name[0],
          							fillColor: "rgba(0,0,0,0)",//"rgba(220,220,220,0.2)",// 填充颜色
          				            strokeColor: "rgba(30,144,255,1)",// 线的颜色
          				            pointColor: "rgba(30,144,255,1)",// 点的填充颜色
          				            pointStrokeColor: "#fff",// 点的边线颜色
          							data : obj.y1, //Y轴（数量）
          							spanGaps: false,
          						},{
          							label: obj.name[1],
          							fillColor: "rgba(0,0,0,0)",//"rgba(230,230,250,0.2)",
  				            		strokeColor: "rgba(255,255,0,1)",
  				            		pointColor: "rgba(255,255,0,1)",
  				            		pointStrokeColor: "#fff",
          							data : obj.y2, //Y轴（数量）
          							spanGaps: false,
          						},{
          							label: obj.name[2],
          							fillColor: "rgba(0,0,0,0)",//"rgba(151,187,205,0.2)",
          				            strokeColor: "rgba(255,165,0,1)",
          				            pointColor: "rgba(255,165,0,1)",
          				            pointStrokeColor: "#fff",
          							data : obj.y3, //Y轴（数量）
          							spanGaps: false,
          						}
          					]
          				};
		        		BootstrapDialog.show({type:'type-default', size:'size-wide', message:$div, title:title, closable:true,
			           		onshown: function(dialog){
			           			$("#chartDiv").show();
			           			
			           			var options = {
		           			        scaleShowLabels : true, // 是否显示y轴的标签
		           			        scaleFontFamily : "'Arial'", // 标签的字体
		           			        scaleFontSize : 12,// 标签字体的大小
		           			        scaleFontStyle : "normal",// 标签字体的样式
		           			        scaleFontColor : "#666",// 标签字体的颜色
		           			        animation : true,// 是否有动画效果
		           			        animationSteps : 60,// 动画的步数
		           			        animationEasing : "easeOutQuart",// 动画的效果
		           			        onAnimationComplete : null// 动画完成后调用
		           			    };
			           			
		          				var ctx = document.getElementById("myChart").getContext("2d");
		          				var chartLine = new Chart(ctx).Line(data, options);
		          				
		          				//构建图例名
		          				var html = '<ul style= "width:800px;height:60px;list-style:none;margin-left:50px">';
		          				$.each(chartLine.datasets,function(index,value){
		          					html = html + '<li style="float:left;display:inline;margin-left:30px;line-height:30px;width:100px;border:1px solid rgba(0,0,0,0);background-color:'
		          					+value.strokeColor+'">&nbsp;&nbsp;&nbsp;&nbsp;'+value.label+'<br/></li>';
		          				});
		          				html = html + '</ul>';
		          				document.getElementById('chart_line_legend').innerHTML = html;
			              	}
			 	        });
                    },
                    error:function(){
                        BootstrapDialog.alert("没有找到对应的数据～");
                    }
	        	});
			});
			function total(){
				var i=0;
	    		var zxwb = 0,lxwb = 0,jqzs = 0, yhzs = 0;
	    		$('#editable tbody tr').each(function() { 
	    			if(i != 0){
	    				var c1 = parseInt($(this).children().eq(1).html());
	    				if(!isNaN(c1)){
	    					zxwb = zxwb + c1;
	    				}
	    				var c2 = parseInt($(this).children().eq(2).html());
	    				if(!isNaN(c2)){
	    					lxwb = lxwb + c2;
	    				}
	    				var c3 = parseInt($(this).children().eq(3).html());
	    				if(!isNaN(c3)){
	    					jqzs = jqzs + c3;
	    				}
	    				var c4 = parseInt($(this).children().eq(4).html());
	    				if(!isNaN(c4)){
	    					yhzs = yhzs + c4;
	    				}
	    			}
	    			i++;
	    		});
	    		var tfoot = $('#editable').find('tfoot');
	    		tfoot[0].rows[0].cells[1].textContent = zxwb;
	    		tfoot[0].rows[0].cells[2].textContent = lxwb;
	    		tfoot[0].rows[0].cells[3].textContent = jqzs;
	    		tfoot[0].rows[0].cells[4].textContent = yhzs;
			}
	        $('.spiner-example').remove();//移除遮罩层
    	});
	</script>
</body>
</html>
