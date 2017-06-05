var oTable=null, dbTable=null, optTag=null, newRows=null;//全局变量对象
var addopt='<i class="fa fa-save fa-cursor i-margin-r"></i><i class="fa fa-remove fa-cursor i-remove"></i>',
	editopt='<i class="fa fa-edit fa-cursor i-margin-r"></i><i class="fa fa-remove fa-cursor"></i>',
	delopt='<i class="fa fa-remove fa-cursor"></i>',modifyopt='<i class="fa fa-edit fa-cursor"></i>';
var dtDom = "<'row'<'col-sm-1'B><'col-sm-5'l><'col-sm-6'f>><'row'<'col-sm-12'tr>><'row'<'col-sm-5'i><'col-sm-7'p>>";
var whether = [{value:0, text:'否'},{value:1, text:'是'}], state = [{value:1, text:'启用'},{value:0, text:'禁用'}];
$.extend($.fn.editable.defaults, {
	//mode : 'inline',
	//showbuttons : false,
	emptytext : '输入',
	placement : 'bottom'
});
//checkbox
var cbRender = function(data, type, row, meta){
	return $.trim(data)==''?'':('<input type="checkbox" class="checkable" value="'+ data +'" />');
}
//操作列
var optRender = function(data, type, row, meta){
	var opt = editopt;
	var pk = $(dbTable.cell(meta.row, 4).node()).children('a').attr('data-pk');
	if($.trim(pk)==''){
		$(dbTable.row(meta.row).node()).addClass('newRow');
		opt = addopt;
	}
	return opt;
}
//操作列
var optRenderAuth = function(data, type, row, meta){
	var opt = null;
	if($('#addRow').length>0 && $('#delAll').length>0){
		opt = editopt;
	}else if($('#addRow').length>0){
		opt = modifyopt;
	}else if($('#delAll').length>0){
		opt = delopt;
	}
	if($('#addRow').length>0){//添加权限
		var pk = $(dbTable.cell(meta.row, 4).node()).children('a').attr('data-pk');
		if($.trim(pk)==''){
			$(dbTable.row(meta.row).node()).addClass('newRow');
			opt = addopt;
		}
	}
	return opt;
}
var optShown = function(){//设置input number小数点
	$(this).parent('td').find('input[type="number"]').attr('step', '0.01');
}
//dataSrc表格数据渲染数据加工的方法 
var drawData = function(result){
	var json = result.data;
	var _length = newRows==null?0:newRows.length;
	if(_length>0){
		newRows.reverse();//反转结果集（先进后出）
		$.each(newRows, function(i, row){
			json.unshift(row);//先添加已存在的新行
		});
	}
	if(optTag=='add'){
		json.unshift(['']);
		_length++;
	}
	result.recordsTotal+=_length;
	result.recordsFiltered+=_length;
   return json;   
}
//添加，删除时获取新添加的行
var loadNewRows = function(){
	var rows = dbTable.rows('tr.newRow');
	var trSet = $(rows.nodes());
	newRows = new Array();//rows.data();//获取空值的数组
	$.each(trSet, function(i){
		var cols = new Array();
		$('td', $(this)).each(function(j){
			var a_node = $(this).children('a.editable');
			if(a_node.length==1){//将新增未保存的数据赋值到数组中，添加时用
				var a_val = a_node.editable('getValue', true);
				if($.trim(a_val)!=''){
					if(typeof(a_val)=="object"){//转换日期格式
						a_val = formatDate(a_val);
					}
					cols[a_node.attr('id')] = a_val;
					//newRows[i][j]=a_val;
				}
			}
		});
		newRows.push(cols);
	});
	if(optTag=='add'){
		$('div.ibox-content div.DTFC_LeftWrapper').addClass('visible-hide');
		$('#frozenBtn>span').html('未');//添加时取消冻结功能
	}
}
//自动生成序号列
var createIndex = function(col){
	dbTable.on('order.dt search.dt', function () {
		dbTable.column(col?col:0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
            cell.innerHTML = i+1;
        });
    }).draw(false);
}
//自动扩展列宽度
var adjustColumn = function(){
	setTimeout(function() {
		dbTable.columns.adjust();//重新计算列宽
    	//oTable.fnAdjustColumnSizing(false);
    }, 200);
}
//添加行之后初始化事件
var afterAddRow = function(tr){
	//自动显示下一列编辑框
	tr.find('a[data-type]').on('save', function(){
	    var $this = $(this);
	    setTimeout(function() {
	    	dbTable.columns.adjust();//重新计算列宽
	        $this.closest('td').next().find('a').editable('show');
	    }, 200);
	});
	//删除添加的行
	tr.find('i.fa-remove').on('click', function(){
		var tr=$(this).parents('tr');
		var pk = tr.find('a[data-type]:first').attr('data-pk');
		if(pk){
			console.log("+++++++++++++++++"+pk);
			editableDelRow(pk,tr);
		}else{
			console.log("no pkid===");
			oTable.fnDeleteRow(tr);
		}
		
//		oTable.fnDeleteRow($(this).parents('tr'));
	});
}
//公共删除和编辑状态切换事件
var initEvent= function(url){
	$('#editable tbody').on('click', 'i.fa-edit', function(){//编辑
		$(this).parents('tr').find('a.editable').editable('toggleDisabled');
	}).on('click', 'i.fa-remove:not("i.i-remove")', function(){//删除
		var $this = $(this);
		var tr = $this.parents('tr');
		BootstrapDialog.confirm({type:'type-default', message:'确认是否删除?', callback:function(result){
            if(result) {
            	var pk = tr.find('a[data-type]:first').attr('data-pk');
            	$.com.ajax({
			       	url: url,
		           	data:{pk:pk, name:'status', value:'0'},
			       	success: function(data){
			           	if(data.flag){
			           		optTag='del';
			           		loadNewRows();//保留新添加的行
			           		dbTable.row(tr).remove().draw(false);
			           	}else{
			           		BootstrapDialog.alert({type:'type-danger', message:'删除失败，请刷新重试！'});
			           	}               
		       		}
				});
            }
        }});
	});
	//冻结功能开关
    $('#frozenBtn').on('click', function(){
    	var leftWrapper = $('div.ibox-content div.DTFC_LeftWrapper');
    	leftWrapper.toggleClass('visible-hide');
    	$(this).children('span').html(leftWrapper.hasClass('visible-hide')?'未':'已');
    });
}
//扩展DT的搜索文本框回车查询默认配置
var initDtSearch = function(){
	console.log("initDtSearch");
	$.extend($.fn.dataTable.defaults, {
	    //DT初始化完毕回调函数
	    initComplete: function(settings) {
	        var _$this = this;
	        var searchHTML='<div class="dataTables_filter"><label>查找:<input type="search" class="form-control input-sm" aria-controls="editable" placeholder="按回车搜索内容"></label></div>';
	        //快捷操作的HTML DOM
	        $(_$this.selector + '_wrapper .dataTables_filter').html(searchHTML);
	        //重写搜索事件
	        $(_$this.selector + '_wrapper .dataTables_filter input').bind('keyup',
	        function(e) {
	            if (e.keyCode == 13 || (e.keyCode == 8 && (this.value.length == 0))) {
	            	console.log("search");
	            	if($('#defineKey'))
	            		searchByKey(this.value);
	                _$this.api().search(this.value).draw();
	            }
	        });
	    }
	});
}
//批量删除
var delBatch = function(url){
	$('#delAll').click(function(){
    	var rows = oTable.fnGetNodes();
		var ckboxs = $('input[type="checkbox"]:checked', rows);
		if(ckboxs.length==0){
			BootstrapDialog.alert({type:'type-default', message:'请选择删除的数据！'});
			return;
		}
		BootstrapDialog.confirm({type:'type-default', message:'确认是否批量删除？', callback:function(result){
            if(result){
	        	var dataSet = new Array();
	    		$.each(ckboxs, function(){
	    			dataSet.push($(this).val());
	    		});
	    		$.com.ajax({
			       	url: url, data:{ids:dataSet},
			       	success: function(data){
			           	if(data.flag){
			           		if($.trim(dbTable.ajax.url())!=''){
			           			dbTable.ajax.reload(null, false);
			           		}else{
			           			var trs = $('input[type="checkbox"]:checked', rows).parents('tr');
			           			dbTable.rows(trs).remove().draw(false);
			           		}
			           		BootstrapDialog.alert({type:'type-default', message:'操作成功！'});
			           	}else{
			           		BootstrapDialog.alert({type:'type-danger', message:'操作失败，请刷新重试！'});
			           	}               
		       		}
				});
            }
    	}});
    });
}