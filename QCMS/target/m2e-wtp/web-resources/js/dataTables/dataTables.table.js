var oTable=null, dbTable=null, optTag=null, newRows=null;//全局变量对象
var editopt='<i class="fa fa-edit fa-cursor i-margin-r"></i><i class="fa fa-remove fa-cursor"></i>',
	delopt='<i class="fa fa-remove fa-cursor"></i>',modifyopt='<i class="fa fa-edit fa-cursor"></i>';
var dtDom = "<'row'<'col-sm-1'B><'col-sm-5'l><'col-sm-6'f>><'row'<'col-sm-12'tr>><'row'<'col-sm-5'i><'col-sm-7'p>>";
//checkbox
var cbRender = function(data, type, row, meta){
	return $.trim(data)==''?'':('<input type="checkbox" class="checkable" value="'+ data +'" />');
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
	return opt;
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
//公共删除和编辑状态切换事件
var initEvent= function(url){
	$('#editable tbody').on('click', 'i.fa-remove:not("i.i-remove")', function(){//删除
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