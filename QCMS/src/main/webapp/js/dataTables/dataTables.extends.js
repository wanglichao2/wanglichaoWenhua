/*! DataTables Bootstrap 3 integration
 * ©2011-2015 SpryMedia Ltd - datatables.net/license
 */

/**
 * DataTables integration for Bootstrap 3. This requires Bootstrap 3 and
 * DataTables 1.10 or newer.
 */
(function( factory ){
	if ( typeof define === 'function' && define.amd ) {
		// AMD
		define( ['jquery', 'datatables.net'], function ( $ ) {
			return factory( $, window, document );
		} );
	}
	else if ( typeof exports === 'object' ) {
		// CommonJS
		module.exports = function (root, $) {
			if ( ! root ) {
				root = window;
			}

			if ( ! $ || ! $.fn.dataTable ) {
				// Require DataTables, which attaches to jQuery, including
				// jQuery if needed and have a $ property so we can access the
				// jQuery object that is used
				$ = require('datatables.net')(root, $).$;
			}

			return factory( $, root, root.document );
		};
	}
	else {
		// Browser
		factory( jQuery, window, document );
	}
}(function( $, window, document, undefined ) {
'use strict';
var DataTable = $.fn.dataTable;

$.extend(DataTable.defaults, {
	/*dom:"<'row'<'col-sm-1'B><'col-sm-5'l><'col-sm-6'f>>" +
		"<'row'<'col-sm-12'tr>><'row'<'col-sm-5'i><'col-sm-7'p>>",*/
	lengthMenu:[[10, 40, 80, 120, 160, 200, '-1'], [10, 40, 80, 120, 160, 200, '全部']],
	"oLanguage": {
		"sProcessing": "加载数据中，请稍候...",
		"sLengthMenu": "每页 _MENU_ 条记录",
		"sZeroRecords": "没有找到符合条件的记录",
		"sInfo": "显示 _START_ 到 _END_ ，共 _TOTAL_ 条数据",
		"sInfoEmpty": "显示 0 到 0 ，共 0 条数据",
		"sInfoFiltered": "(从 _MAX_ 条中筛选)",
		"sInfoPostFix": "",
		"sSearch": "查找:",
		"sUrl": "",
		"sEmptyTable": "没有数据！",
		"sLoadingRecords": "加载数据中...",
		"sDecimal": "",
		"sThousands": ",",
		"oPaginate" : {
			"sFirst": "首页",
			"sPrevious": "上页",
			"sNext": "下页",
			"sLast": "末页"
		},
		"oAria": {
			"sSortAscending": "：按升序排序此列",
			"sSortDescending": "：按降序排序此列"
		}
	}
});

/*
 * TableTools Bootstrap compatibility
 * Required TableTools 2.1+
 */
if ($.fn.DataTable.TableTools) {
    // Set the classes that TableTools uses to something suitable for Bootstrap
    $.extend(true, $.fn.DataTable.TableTools.classes, {
        "container": "DTTT btn-group",
        "buttons": {
            "normal": "btn btn-default",
            "disabled": "disabled"
        },
        "collection": {
            "container": "DTTT_dropdown dropdown-menu",
            "buttons": {
                "normal": "",
                "disabled": "disabled"
            }
        },
        "print": {
            "info": "DTTT_print_info modal"
        },
        "select": {
            "row": "active"
        }
    });

    // Have the collection use a bootstrap compatible dropdown
    $.extend(true, $.fn.DataTable.TableTools.DEFAULTS.oTags, {
        "collection": {
            "container": "ul",
            "button": "li",
            "liner": "a"
        }
    });
}
//
//Pipelining function for DataTables. To be used to the `ajax` option of DataTables
//
DataTable.pipeline = function(opts){
	 // Configuration options
	 var conf = $.extend( {
	     pages: 5,     // number of pages to cache
	     url: '',      // script url
	     data: null,   // function or object with parameters to send to the server
	                   // matching how `ajax.data` works in DataTables
	     method: 'GET' // Ajax HTTP method
	 }, opts );
	
	 // Private variables for storing the cache
	 var cacheLower = -1;
	 var cacheUpper = null;
	 var cacheLastRequest = null;
	 var cacheLastJson = null;
	
	 return function ( request, drawCallback, settings ) {
	     var ajax          = false;
	     var requestStart  = request.start;
	     var drawStart     = request.start;
	     var requestLength = request.length;
	     var requestEnd    = requestStart + requestLength;
	      
	     if ( settings.clearCache ) {
	         // API requested that the cache be cleared
	         ajax = true;
	         settings.clearCache = false;
	     }
	     else if ( cacheLower < 0 || requestStart < cacheLower || requestEnd > cacheUpper ) {
	         // outside cached data - need to make a request
	         ajax = true;
	     }
	     else if ( JSON.stringify( request.order )   !== JSON.stringify( cacheLastRequest.order ) ||
	               JSON.stringify( request.columns ) !== JSON.stringify( cacheLastRequest.columns ) ||
	               JSON.stringify( request.search )  !== JSON.stringify( cacheLastRequest.search )
	     ) {
	         // properties changed (ordering, columns, searching)
	         ajax = true;
	     }
	      
	     // Store the request for checking next time around
	     cacheLastRequest = $.extend( true, {}, request );
	
	     if ( ajax ) {
	         // Need data from the server
	         if ( requestStart < cacheLower ) {
	             requestStart = requestStart - (requestLength*(conf.pages-1));
	
	             if ( requestStart < 0 ) {
	                 requestStart = 0;
	             }
	         }
	          
	         cacheLower = requestStart;
	         cacheUpper = requestStart + (requestLength * conf.pages);
	
	         request.start = requestStart;
	         request.length = requestLength*conf.pages;
	
	         // Provide the same `data` options as DataTables.
	         if ( $.isFunction ( conf.data ) ) {
	             // As a function it is executed with the data object as an arg
	             // for manipulation. If an object is returned, it is used as the
	             // data object to submit
	             var d = conf.data( request );
	             if ( d ) {
	                 $.extend( request, d );
	             }
	         }
	         else if ( $.isPlainObject( conf.data ) ) {
	             // As an object, the data given extends the default
	             $.extend( request, conf.data );
	         }
	
	         settings.jqXHR = $.ajax( {
	             "type":     conf.method,
	             "url":      conf.url,
	             "data":     request,
	             "dataType": "json",
	             "cache":    false,
	             "success":  function ( json ) {
	                 cacheLastJson = $.extend(true, {}, json);
	
	                 if ( cacheLower != drawStart ) {
	                     json.data.splice( 0, drawStart-cacheLower );
	                 }
	                 if ( requestLength >= -1 ) {
	                     json.data.splice( requestLength, json.data.length );
	                 }
	                  
	                 drawCallback( json );
	             }
	         } );
	     }
	     else {
	         var json = $.extend( true, {}, cacheLastJson );
	         json.draw = request.draw; // Update the echo for each response
	         json.data.splice( 0, requestStart-cacheLower );
	         json.data.splice( requestLength, json.data.length );
	
	         drawCallback(json);
	     }
	 }
};
//Register an API method that will empty the pipelined data, forcing an Ajax
//fetch on the next draw (i.e. `table.clearPipeline().draw()`)
DataTable.Api.register('clearPipeline()', function(){
	return this.iterator('table', function(settings){
		settings.clearCache = true;
 	});
});
return DataTable;
}));