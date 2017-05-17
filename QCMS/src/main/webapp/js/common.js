$(function(){
	BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DEFAULT] = '提示信息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_INFO] = '提示信息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_PRIMARY] = '提示信息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_SUCCESS] = '提示信息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_WARNING] = '警告信息';
    BootstrapDialog.DEFAULT_TEXTS[BootstrapDialog.TYPE_DANGER] = '错误信息';
	BootstrapDialog.DEFAULT_TEXTS['OK'] = '确定';
    BootstrapDialog.DEFAULT_TEXTS['CANCEL'] = '取消';
    BootstrapDialog.configDefaultOptions({
    	type: BootstrapDialog.TYPE_DEFAULT,
        size: BootstrapDialog.SIZE_SMALL,
        closable: true
    });
});
$.com = {
	ajax:function(param){
		/**
		 * 执行异步 HTTP (Ajax) 请求,初始化参数默认值
		 * 请求方式, 调用地址, 参数对象, 返回后执行的方法, 错误处理方法, 服务器返回的数据类型, 超时时间,是否异步
		 */
		var opt = {type:'post', url:null, data:null, cache:false, dataType:'json', async:true,  
				beforeSend:null, success:null, error:null, timeout:30000};
		$.extend(opt, param);
		$.ajax({
			type: opt.type,
			url: opt.url,
			data: opt.data,
			cache: opt.cache,
			dataType: opt.dataType,
			async: opt.async,
			beforeSend: opt.beforeSend,
			success: opt.success,
			error: function(errors){
				if(opt.error){
					opt.error(errors);
				}else{
					BootstrapDialog.alert({type:'type-danger', message:'服务器异常，请稍候重试！'});
					console.log(errors.responseText);
				}
			},
			timeout: opt.time
		});
	}
};
//复选框
var initCheckbox = function(){
    $('.table th input.checkable').change(function(){//全选
    	//var tableId = $(this).parents('table').attr("id");
		//var rows = $('#'+tableId).dataTable().fnGetNodes();
		var rows = dbTable.rows('tr:not(tr.newRow)').nodes();//oTable.fnGetNodes();
		var $rows = $('input[type="checkbox"].checkable', rows);
		$rows.prop('checked', this.checked);
		$.uniform.update($rows);
    });
    $('.table>tbody').on('change', 'input[type="checkbox"].checkable', function(){
    	$(this).prop('checked', this.checked);
    	var tableId = $(this).parents('table').attr("id");
		var rows = dbTable.rows('tr:not(tr.newRow)').nodes();//oTable.fnGetNodes();
        var rLen = rows.length,
        	rcLen = $('input[type="checkbox"].checkable:checked', rows).length,
        	th_checkbox = $('#'+tableId+' th input.checkable'),
        	frozen_checkbox = $('div.dataTables_scrollHeadInner th input.checkable');//固定表头虚拟checkbox
        var bool = rLen==rcLen && rcLen!=0;
        	th_checkbox.prop('checked', bool);
        	frozen_checkbox.prop('checked', bool);
        	if(bool){
        		th_checkbox.parent('span').addClass("checked");
        		frozen_checkbox.parent('span').addClass("checked");
        	}else{
        		th_checkbox.parent('span').removeClass("checked");
        		frozen_checkbox.parent('span').removeClass("checked");
        	}
    });
}
//对Date的扩展，将 Date 转化为指定格式的String 
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
Date.prototype.Format = function(fmt){
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds()
	//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "")
				.substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k])
					: (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt; 
}
//格式化日期
var formatDate = function(date, format){
	if($.trim(date) != ''){
		format = $.trim(format)=='' ? 'yyyy/MM/dd hh:mm' : format;
		var dateObj = new Date(date);
		return dateObj.Format(format);
	}
	return date;
}
var parseJSON = function(json){
	if($.trim(json)!=''){
		return JSON.parse(json);
	}
	return null;
}
//过滤数据列表数据
var filterSource = function(json, filed, filter){
	if($.trim(json)!=''){
		var jsonArray = JSON.parse(json);
		var dataSource = new Array();
		$(jsonArray).each(function(i, obj){
			if($.inArray(obj[filed], filter)==-1){
				dataSource.push(obj);
			}
		});
		return dataSource;
	}
	return null;
}
//处理sysParam系统参数字符串{1=菜单, 2=选项卡, 3=按钮}
var toJsonArray = function(param){
	var jsonArray = new Array();
	var str = param.substring(1, param.length-1)//去掉{}字符
	var paramSet = str.split(',');
	$(paramSet).each(function(i, obj){
		var sp = obj.split('=');
		jsonArray.push({value:$.trim(sp[0]), text:$.trim(sp[1])});
	});
	return jsonArray;
}
//jsonArray转Map
var sysToMap = function(jsonArray){
	var paramSet = new Array();
	$(jsonArray).each(function(i, param){
		paramSet[param.value]=param.text;
	});
	return paramSet;
}