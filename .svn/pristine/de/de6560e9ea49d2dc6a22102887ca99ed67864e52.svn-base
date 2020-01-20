var errorTitle = 'Error';
var networkError = 'Network error.';
var notMatch = 'Field value do not match.';
var intRange_invalid = 'Numeric characters only.';
var intRange_min = 'Min value is {0}.';
var intRange_max = 'Max value is {1}.';
var intRange_minmax = 'Please enter a value between {0} and {1}.';
var dateRange_min = 'Min date is {0}.';
var dateRange_max = 'Max date is {0}.';
var dateRange_minmax = 'Please choose a date between {0} and {1}.';

/**
 * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
 * 
 * @requires jQuery 1.8-,EasyUI
 * 
 */
$.fn.panel.defaults.onBeforeDestroy = function() {
	var frame = $('iframe', this);
	try {
		if (frame.length > 0) {
			for(var i = 0; i < frame.length; i++) {
				frame[i].contentWindow.document.write('');
				frame[i].contentWindow.close();
			}
			frame.remove();
			if ($.browser.msie) {
				CollectGarbage();
			}
		}
	} catch (e) {
	}
};

/**
 * 使panel和datagrid在加载时提示
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.fn.panel.defaults.loadingMessage = 'Loading...';
$.fn.datagrid.defaults.loadMsg = 'Loading...';
$.fn.treegrid.defaults.loadMsg = 'Loading...';

/**
 * 
 * @requires jQuery
 * 
 * 通用Ajax错误提示
 * 
 */
function handleAjaxError(XMLHttpRequest, textStatus, errorThrown) {
	$.messager.progress('close');//因此可能出现的loading框
	//var args = Array.prototype.slice.call(arguments); 
	var status = XMLHttpRequest.status;
	var response = XMLHttpRequest.responseText;
	if (response == undefined || response == '') {
		if (status == 200) {
			response = textStatus;
		} else {
			response = networkError;
		}
	}
	// no session
	if (response.indexOf('flag_exception_nosession', 0) > 0) {
		if (top.document.getElementById('dlg_login')) {
			top.goLogin();
		} else {
			top.location.reload();
		}
	//} else if (response.indexOf('flag_vegaexception', 0) > 0) {
	//	
	//} else if (response.indexOf('flag_sysexception', 0) > 0) {
	//	
	} else {
		$.messager.alert(errorTitle, response, 'error');
	}
}
$.fn.datagrid.defaults.onLoadError = handleAjaxError;
$.fn.treegrid.defaults.onLoadError = handleAjaxError;
$.fn.tree.defaults.onLoadError = handleAjaxError;
$.fn.combogrid.defaults.onLoadError = handleAjaxError;
$.fn.combobox.defaults.onLoadError = handleAjaxError;
$.fn.form.defaults.onLoadError = handleAjaxError;


/**
 * 
 * 显示用户信息
 * 
 * @requires jQuery,EasyUI
 * @param id 用户id
 * @param host 主机地址（可选项，不传入则从cookie取）
 * @param lng 语言（可选项，不传入则从cookie取，可选范围zh,en）
 */
function showUserInfo(id, host, lng) {
	if (id == undefined || id == '') {
		return;
	}
	if (host == undefined) {
		host = $.cookie('host');
	}
	if (lng == undefined) {
		lng = $.cookie('userLocale');
	}
	if (host == null || host == '/') host = '';
	if (lng == null) lng = 'en';
	
	$.messager.progress();// show progress dialog
	$.post(host + '/common/user/doGet.do', { 'id' : id }, function(result) {
		$.messager.progress('close');// hide progress dialog
		try {
			var j = result;
			if (j.id) {
				var msg = '<table class="mtftable">';
				msg += '<tr><th style="width:100px;">' + (lng == 'zh' ? '用户' : 'User') + '</th><td>:</td><td style="width:300px;">' + j.displayName + '</td></tr>';
				msg += '<tr><th>' + (lng == 'zh' ? '中文名' : 'CN Name') + '</th><td>:</td><td>' + j.chineseName + '</td></tr>';
				msg += '<tr><th>' + (lng == 'zh' ? '性别' : 'Gender') + '</th><td>:</td><td>' + (j.gender == 1 ? (lng == 'zh' ? '男' : 'Male') : (j.gender == 2 ? (lng == 'zh' ? '女' : 'Female') : '')) + '</td></tr>';
				msg += '<tr><th>' + (lng == 'zh' ? '邮箱' : 'Email') + '</th><td>:</td><td><a href="mailto:' + j.email + '">' + j.email + '</a></td></tr>';
				msg += '<tr><th>' + (lng == 'zh' ? '内线' : 'Line') + '</th><td>:</td><td>' + j.line + '</td></tr>';
				msg += '<tr><th>' + (lng == 'zh' ? '短号' : 'VNet') + '</th><td>:</td><td>' + j.vnet + '</td></tr>';
				msg += '</table>';
				$.messager.alert((lng == 'zh' ? '用户信息' : 'User Info'), msg);
			} else {
				$.messager.alert((lng == 'zh' ? '错误' : 'Error'), (lng == 'zh' ? '获取用户信息失败！' : 'Failed to fetch user info!'), 'error');
			}
		} catch (e) {
			$.messager.alert((lng == 'zh' ? '错误' : 'Error'), result, 'error');
		}
	}, 'json');
}

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 为datagrid、treegrid增加表头菜单，用于显示或隐藏列，注意：冻结列不在此菜单中
 */
function createGridHeaderContextMenu(e, field) {
	e.preventDefault();
	var grid = $(this);/* grid本身 */
	var headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
	if (!headerContextMenu) {
		var tmenu = $('<div></div>').appendTo('body');
		var fields = grid.datagrid('getColumnFields');
		for (var i = 0; i < fields.length; i++) {
			var fildOption = grid.datagrid('getColumnOption', fields[i]);
			if (fildOption.hiddable) {
				if (!fildOption.hidden) {
					$('<div iconCls="tree-checkbox1" field="' + fields[i] + '" hideOnClick="false"></div>').html(fildOption.title).appendTo(tmenu);
				} else {
					$('<div iconCls="tree-checkbox0" field="' + fields[i] + '" hideOnClick="false"></div>').html(fildOption.title).appendTo(tmenu);
				}
			}
		}
		headerContextMenu = this.headerContextMenu = tmenu.menu({
			onClick : function(item) {
				var field = $(item.target).attr('field');
				if (item.iconCls == 'tree-checkbox1') {
					grid.datagrid('hideColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'tree-checkbox0'
					});
				} else {
					grid.datagrid('showColumn', field);
					$(this).menu('setIcon', {
						target : item.target,
						iconCls : 'tree-checkbox1'
					});
				}
			}
		});
	}
	headerContextMenu.menu('show', {
		left : e.pageX,
		top : e.pageY
	});
};
$.fn.datagrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;
$.fn.treegrid.defaults.onHeaderContextMenu = createGridHeaderContextMenu;

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展Datagrid，添加单元格Tooltip功能和设置列标题功能
 * tootip默认显示datagrid单元格的内容，如果需要特别指定提示内容及格式，可以通过tipFormatter : function(value, row, index)格式化
 * eg: "James<tip title="Wade"></tip>" 将提示Wade而不是James
 * 
 * eg:$("#dt").datagrid('tooltip',['description', 'comment']);
 * eg:$("#dt").datagrid('tooltip',[['description', 'comment', 'name', 'location'],['b','t','l','r']]);
 * eg:$("#dt").datagrid('setColumnTitle',{field:'product',text:'newTitle'});
 */
$.extend($.fn.datagrid.methods, {
	tooltip : function (jq, fields) {
		return jq.each(function (index,jq) {
			var panel = $(this).datagrid('getPanel');
			if (fields && typeof fields == 'object' && fields.sort) {
				var dirs = undefined;
				if (fields.length == 2 && fields[0].sort) {
					dirs = fields[1];
					fields = fields[0];
				}
				$.each(fields, function (index, field) {
					var rows = $(jq).datagrid('getRows');
					var cells = $('.datagrid-body td[field=' + field + '] .datagrid-cell', panel);
					var columnOption = $(jq).datagrid('getColumnOption', field);
					
					for(var i=0; i<cells.length; i++){
						var content ;
						if(columnOption.tipFormatter){
							content = columnOption.tipFormatter(rows[i][field], rows[i], i);
						}else if(columnOption.formatter){
							content = columnOption.formatter(rows[i][field], rows[i], i);
						}else{
							content = htmlEncode(rows[i][field]);
						}
						
						cells[i].tipContent = content ? content.replace(/\n/ig,'<br />') : '';
						cells[i].tipDir = 'b';
						
						if (dirs && typeof dirs == 'object' && dirs.sort && dirs.length >= index) {
							cells[i].tipDir = dirs[index];
						}
					}
					if (cells.length > 0) {
						bindEvent(cells);
					}
				});
			} else {
				bindEvent($(".datagrid-body .datagrid-cell", panel));
			}
		});

		function bindEvent(jqs) {
			jqs.mouseover(function() {
				var content = this.tipContent;
				var dir = this.tipDir;
				if (dir == 'l') dir = 'left';
				else if (dir == 't') dir = 'top';
				else if (dir == 'r') dir = 'right';
				else dir = 'bottom';
				if (content != '') {
					$(this).tooltip({
						content : content,
						trackMouse : true,
						position : dir,
						onShow : function () {
							var css = {color:'#000',borderColor:'#CC9933',backgroundColor:'#FFFFCC',textAlign:'left'};
							if (content.indexOf('<br') > 50 || (content.indexOf('<br') == -1 && content.length > 50)) {
								css.width='500';
							}
							$(this).tooltip('tip').css(css);
						},
						onHide : function () {
							$(this).tooltip('destroy');
						}
					}).tooltip('show');
				};
			});
		}
	},
	setColumnTitle: function(jq, option){
		if(option.field){
			return jq.each(function(){
				var $panel = $(this).datagrid('getPanel');
				var $field = $('td[field='+option.field+']',$panel);
				if($field.length){
					var $span = $('span', $field).eq(0);
					$span.html(option.text);
				}
			});
		}
		return jq;
	}  
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展validatebox，添加验证两次功能
 */
$.extend($.fn.validatebox.defaults.rules, {
	equals : {
		validator : function(value, param) {
			return value == $(param[0]).val();
		},
		message : notMatch
	},
	intRange : {
		validator : function(value, param) {
			//先验证是否为整数
			var regExp = new RegExp(/^-?\d+$/);
			if(!regExp.test(value)){
				$.fn.validatebox.defaults.rules.intRange.message = "Numeric characters only";
				return false;
			}
			
			var isValueCorrect = true;	//判断指定值是否在某一范围内
			if(param != null){
				switch(param.length){
					case 1:		//intValid[9] 表示最小值为9
						isValueCorrect = (value >= param[0]);
						$.fn.validatebox.defaults.rules.intRange.message = intRange_min;//"Min value is {0}";
						break;
						
					case 2:		
						if(typeof(param[0]) == "undefined"){	//intValid[,9] 表示最大值为9
							isValueCorrect = (value <= param[1]);
							$.fn.validatebox.defaults.rules.intRange.message = intRange_max;//"Max value is {1}";
						}
						else if(typeof(param[1]) == "undefined"){	//intValid[9,] 表示最小值为9
							isValueCorrect = (value >= param[0]);
							$.fn.validatebox.defaults.rules.intRange.message = intRange_min;//"Min value is {0}";
						}
						else{		//intValid[0,9] 表示取值范围为0-9
							isValueCorrect =((value >= param[0]) && (value <= param[1]));
							$.fn.validatebox.defaults.rules.intRange.message = intRange_minmax;//"Range is [{0} - {1}]";
						}
						break;
					default:
						isValueCorrect = true;
				}
			}
			return isValueCorrect;
		},
		message : ''
	},
	// 移动手机号码验证
	phone : {// value值为文本框中的值
		validator : function(value) {
			var reg = /^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{4,7}(-\d{1,8})?$/;
			return reg.test(value);
		},
		message : '请输入正确的电话格式如:1381234****,0411-1234****!'
	},
	// 验证内部电话
	phoneInterior : {// value值为文本框中的值
		validator : function(value) {
			var reg = /^1\d{10}$|^(0\d{2,3}-?|\(0\d{2,3}\))?[1-9]\d{1,7}(-\d{1,8})?$/;
			return reg.test(value);
		},
		message : '请输入正确的电话格式如:1206, 0411-1234****!'
	}
	/*
	 * , intDigit : { validator : function(value, param) { if(
	 * (/^[+]?\d*$/.test(value))&&(value.length == param[0])){ return true;
	 * }else{ return false; } }, message : '请输入 {0} 位数字' }
	 */
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展validatebox
 */
$.extend($.fn.validatebox.defaults.rules, {
	//输入n位整数
	intDigit : {
		validator : function(value, param) {
			if( (/^[+]?\d*$/.test(value))&&(value.length == param[0])){
				return true;
			}else{
				return false;
			}
		},
		message : '请输入 {0} 位数字'
	}
});

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展datebox，添加最大最小日期限制
 */
$.extend($.fn.datebox.defaults.rules, {
	min : {
		validator : function(value, param) {
			var d1 = $.fn.datebox.defaults.parser(param[0]);
			var d2 = $.fn.datebox.defaults.parser(value);
			var isOk = d2 <= d1;
			if (!isOk) {
				$.fn.datebox.defaults.rules.min.message = dateRange_min;
			}
			return isOk;
		},
		message : ''
	},
	max : {
		validator : function(value, param) {
			var d1 = $.fn.datebox.defaults.parser(param[0]);
			var d2 = $.fn.datebox.defaults.parser(value);
			var isOk = d2 >= d1;
			if (!isOk) {
				$.fn.datebox.defaults.rules.max.message = dateRange_max;
			}
			return isOk;
		},
		message : ''
	}
})
/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展validatebox，支持清除和恢复验证
 */
$.extend($.fn.validatebox.methods, {
	removeValidate: function(jq, newposition) {
		return jq.each(function() {
			$(this).removeClass("validatebox-text validatebox-invalid").unbind('focus.validatebox').unbind('blur.validatebox');
		});
	},
	reduceValidate: function(jq, newposition) {
		return jq.each(function() {
			var opt = $(this).data().validatebox.options;
			$(this).addClass("validatebox-text").validatebox(opt);
		});  
	}	
}); 

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展combobox，添加selectIndex方法.
 */
$.extend($.fn.combobox.methods, {
	selectIndex:function(jq, index){
		var items = jq.combobox('getData');
		var valueField = jq.combobox('options').valueField;
		if(items.length == 0 || items.length <= index){
			return;
		}
		
		var selectValue = items[index][valueField];
		jq.combobox('select', selectValue);
	}
	
});

$.extend($.fn.combobox.defaults, {
	autoShowPanel: false
});
/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展tree，使其支持平滑数据格式
 */
$.fn.tree.defaults.loadFilter = function(data, parent) {
	var opt = $(this).data().tree.options;
	var idField, textField, parentField;
	if (opt.parentField) {
		idField = opt.idField || 'id';
		textField = opt.textField || 'text';
		parentField = opt.parentField || 'pid';
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idField]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['id'] = data[i][idField];
				data[i]['text'] = data[i][textField];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展treegrid，使其支持平滑数据格式
 */
$.fn.treegrid.defaults.loadFilter = function(data, parentId) {
	var opt = $(this).data().treegrid.options;
	var idField, textField, parentField;
	if (opt.parentField) {
		idField = opt.idField || 'id';
		textField = opt.textField || 'text';
		parentField = opt.parentField || 'pid';
		var i, l, treeData = [], tmpMap = [];
		for (i = 0, l = data.length; i < l; i++) {
			tmpMap[data[i][idField]] = data[i];
		}
		for (i = 0, l = data.length; i < l; i++) {
			if (tmpMap[data[i][parentField]] && data[i][idField] != data[i][parentField]) {
				if (!tmpMap[data[i][parentField]]['children'])
					tmpMap[data[i][parentField]]['children'] = [];
				data[i]['text'] = data[i][textField];
				tmpMap[data[i][parentField]]['children'].push(data[i]);
			} else {
				data[i]['text'] = data[i][textField];
				treeData.push(data[i]);
			}
		}
		return treeData;
	}
	return data;
};

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 扩展combotree，使其支持平滑数据格式
 */
$.fn.combotree.defaults.loadFilter = $.fn.tree.defaults.loadFilter;

/***
 * 
 * 
 */
function handleEnterKey(e, fun) {
	if (e.keyCode == 13) {
		e.target.blur();
		setTimeout(fun, 100);
		e.target.focus();
	}
}

/**
 * 
 * @requires jQuery,EasyUI
 * 
 * 防止panel/window/dialog组件超出浏览器边界
 * @param left
 * @param top
 */
function easyuiPanelOnMove(left, top) {
	var l = left;
	var t = top;
	if (l < 1) {
		l = 1;
	}
	if (t < 1) {
		t = 1;
	}
	var width = parseInt($(this).parent().css('width')) + 14;
	var height = parseInt($(this).parent().css('height')) + 14;
	var right = l + width;
	var buttom = t + height;
	var browserWidth = $(window).width();
	var browserHeight = $(window).height();
	if (right > browserWidth) {
		l = browserWidth - width;
		if (l < 1) {
			l = 1;
		}
	}
	if (buttom > browserHeight) {
		t = browserHeight - height;
		if (t < 1) {
			t = 1;
		}
	}
	$(this).parent().css({/* 修正面板位置 */
		left : l,
		top : t
	});
};
$.fn.dialog.defaults.onMove = easyuiPanelOnMove;
$.fn.window.defaults.onMove = easyuiPanelOnMove;
$.fn.panel.defaults.onMove = easyuiPanelOnMove;

/**
 * 
 * @requires jQuery
 * 
 * 将form表单元素的值序列化成对象
 * 
 * @returns object
 */
function serializeObject(form) {
	var o = {};
	$.each(form.serializeArray(), function(index) {
		if (o[this['name']]) {
			o[this['name']] = o[this['name']] + "," + this['value'];
		} else {
			o[this['name']] = this['value'];
		}
	});
	return o;
};

/**
 * 
 * 增加formatString功能
 * 
 * 使用方法：formatString('字符串{0}字符串{1}字符串','第一个变量','第二个变量');
 * 
 * @returns 格式化后的字符串
 */
function formatString(str) {
	for ( var i = 0; i < arguments.length - 1; i++) {
		str = str.replace("{" + i + "}", arguments[i + 1]);
	}
	return str;
};

function formatErrorMessage(errList) {
	var str = 'Operation failed!<br /><br />';
	if (!errList) { return str; }
	str += 'The following error occurred:<br />';
	str += '<ul>';
	for (var i = 0; i < errList.length; i ++) {
		str += '<li>' + errList[i].msg + '</li>';
	}
	str += '</ul>';
	return str;
}

/**
 * 
 * 接收一个以逗号分割的字符串，返回List，list里每一项都是一个字符串
 * 
 * @returns list
 */
function stringToList(value) {
	if (value != undefined && value != '') {
		var values = [];
		var t = value.split(',');
		for ( var i = 0; i < t.length; i++) {
			values.push('' + t[i]);/* 避免将ID当成数字 */
		}
		return values;
	} else {
		return [];
	}
};

function formValidate(filter, opt) {
	if (opt) {
		$(filter).form('enableValidation');
		$(filter).form('validate');
	} else {
		$(filter).form('disableValidation');
	}
}

/**
 * 
 * @requires jQuery
 * 
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
	timeout : 180000,
	type : 'POST',
	error : handleAjaxError
});

/**
 * &,",>,< html encode
 * @param str
 * @returns
 */
function htmlEncode(str){
	if(!str && typeof(str)!="string"){
		return str;
	}
	
	return str.replace(/&/g,"&amp;").replace(/"/g,"&quot;").replace(/>/g,"&gt;").replace(/</g,"&lt;");
}

/**
 * 将日期字符串转为Date对象
 * @param str 日期字符串（yyyy-MM-dd或MM/dd/yyyy）
 * @param nullable 允许返回空
 * @returns {Date}
 */
function parseDate(str, nullable){
	if(!str) {
		if (nullable) {
			return;
		} else {
			return new Date();
		}
	}
	
	var ymd = str.split("-");
	if(ymd.length == 3){
		return new Date(Date.parse(ymd[1]+"/"+ymd[2]+"/"+ymd[0]));
	}else{
		return new Date(Date.parse(str));
	}
}

/**
 * 格式化日期对象为字符串
 * @param date		需要格式化的日期对象
 * @param format	输出格式，默认yyyy-MM-dd
 * @returns String
 */
function formatDate(date, format) {
	if (!date) {
		return '';
	}
	
	if(format == undefined){
		format = 'yyyy-MM-dd';
	}

	var o = { 
		"M+" : date.getMonth()+1, //month 
		"d+" : date.getDate(), //day 
		"h+" : date.getHours(), //hour 
		"m+" : date.getMinutes(), //minute 
		"s+" : date.getSeconds(), //second 
		"q+" : Math.floor((date.getMonth()+3)/3), //quarter 
		"S" : date.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
			format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
	}
	
	return format; 
}

/**
 * @requires EasyUI
 * 
 * 设置datebox默认显示格式yyyy-MM-dd
 */
$.fn.datebox.defaults.formatter = formatDate;

/**
 * @requeires EasyUI
 * 
 * 设置datebox默认日期转换方式
 */
$.fn.datebox.defaults.parser = parseDate;

/**
 * @requires EasyUI
 * 
 * 设置combobox默认筛选规则
 */
$.fn.combobox.defaults.filter = function(q, row) {
	if (q == undefined || q == '') {
		return true;
	}
	var opts = $(this).combobox('options');
	return row[opts.textField].toLowerCase().indexOf(q.toLowerCase()) >= 0;
}

function hideLoading(){
	$("#div_loading").hide('fast');
}

/**  
* numberFormat  
*  
* @param int or float number  		要格式化的数值
* @param int          decimals		小数保留位数，四舍五入
* @param object       defaultValue	不是有效数值时的默认值,默认为""
* @param string       thousandsSep  千位分隔符,默认为","
* @param string       decPoint  	小数点，默认为"."
* @return string  
*/  
function numberFormat(number, decimals, defaultValue, thousandsSep, decPoint) {
	if(isNaN(parseFloat(number))){
		if(defaultValue == undefined ){
			return '';
		}else{
			return defaultValue;
		}
	}
	
	var n = !isFinite(+number) ? 0 : +number, 
		prec = !isFinite(+decimals) ? 0 : Math.abs(decimals), 
		sep = (typeof thousandsSep === 'undefined') ? ',' : thousandsSep, 
		dec = (typeof decPoint === 'undefined') ? '.' : decPoint, 
		s = '', 
		toFixedFix = function(n, prec) {
			var k = Math.pow(10, prec);
			return '' + Math.round(n * k) / k;
		};
	// Fix for IE parseFloat(0.55).toFixed(0) = 0;   
	s = (prec ? toFixedFix(n, prec) : '' + Math.round(n)).split('.');
	if (s[0].length > 3) {
		s[0] = s[0].replace(/\B(?=(?:\d{3})+(?!\d))/g, sep);
	}
	if ((s[1] || '').length < prec) {
		s[1] = s[1] || '';
		s[1] += new Array(prec - s[1].length + 1).join('0');
	}
	return s.join(dec);
}

function buildTabOpt(title, content, id, iconCls, closable) {
	var opt = {};
	opt['title'] = title;
	opt['content'] = content;
	if (id && id.indexOf('tag:') != -1) {
		opt['id'] = id;
	}
	if (iconCls) {
		opt['iconCls'] = iconCls;
	}
	if (closable) {
		opt['closable'] = closable;
	}
	return opt;
}

/**
 * 生成Iframe Tab html
 * @param url	Iframe.src
 * @param id	Iframe.id
 * @param callbackName	回调函数名
 * @returns {String}
 */
function buildIframe(url, id, callbackName) {
	if(id == undefined || id == ''){
		id = (new Date()).getTime();
	}
	var html = '<iframe ';
	if(id){
		html += 'id="' + id + '" ';
	}
	
	if(callbackName != undefined && callbackName != ''){
		var child;
		var callback = {method : callbackName} ;
		var callbackWindow = window;
		
		while(true){
			if(callbackWindow.frameElement == undefined){
				break;
			}
			
			if(callbackWindow.frameElement.id != undefined){
				if(callback.id == undefined){
					callback.id = callbackWindow.frameElement.id; 
				}else{
					callback = {id:callbackWindow.frameElement.id, child:$.extend( true, {},callback)};
				}
				
				callbackWindow = callbackWindow.parent;
			}else{
				callback = undefined;
				break;
			}
		}
		
		if(callback != undefined){
			html += 'callback="' + JSON.stringify(callback).replace(/"/g, '&quot;') + '" ';
		}
	}
	
	html += 'src="' + url + '" frameborder="0" style="border: 0; width: 100%; height: 100%; display: block"></iframe> ';

	return html;
}

/**
 * Iframe tab 执行回调函数
 * @param params	回调函数参数
 */
function iframeTabCallBack(params) {
	var callbackStr = $(window.frameElement).attr('callback');
	if(callbackStr == undefined){
		return;
	}
	
	var callback = JSON.parse(callbackStr);
	
	var callbackWindow = top;
	var callbackMethod = null;
	
	while(true){
		if(callback == undefined){
			break;
		}
		if(callbackWindow == undefined){
			return;
		}
		
		if(callback.method != undefined){
			callbackMethod = callback.method;
		}
		
		if(callback.id == undefined){
			break;
		}
		
		var ifrs = callbackWindow.$('iframe[id="' + callback.id + '"]');
		if(ifrs.length == 0 || ifrs[0].contentWindow == undefined){
			return;
		}
		
		callbackWindow = ifrs[0].contentWindow;
		callback = callback.child;
	}
	
	if(callbackWindow && callbackMethod){
		var method = callbackMethod + '()';
		if(params){
			method = callbackMethod + '(' + JSON.stringify(params) + ')';
		}
		callbackWindow.eval(method);
	}
}


function validateUUID(uuid) {
	var reg = /^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$/gi;
	return reg.test(uuid);
}

/**
 * 扩展DataGrid编辑器，编辑时，显示保存和取消图标
 * 用法：
 *  {
 *		title : '',
 *		field : 'edit',
 *		width : '50',
 *		align : 'center',
 *		formatter : function(value, row, index){
 *			return '<center><div style="width:24px;height:24px;cursor:pointer;" class="icon-edit" onclick="javascript:$(\'#dtg_xxx\').edatagrid(\'editRow\',' + index + ');"></div></center>';
 *		},
 *		editor:{type:'editbutton',options:{gridName:'dtg_xxx'}}
 *	}
 */
$.extend($.fn.datagrid.defaults.editors, {
	editbutton : {
		init : function(container, options) {
			var input = $(
					'<div style="width:24px;height:24px;cursor:pointer;float:left" class="icon-save" onclick="javascript:$(\'#'
							+ options.gridName
							+ '\').edatagrid(\'saveRow\');"></div><div style="width:24px;height:24px;cursor:pointer;float:left" class="icon-cancel" onclick="javascript:$(\'#'
							+ options.gridName
							+ '\').edatagrid(\'cancelRow\');"></div>')
					.appendTo(container);
			return input;
		},
		destroy : function(target) {
			$(target).remove();
		},
		getValue : function(target) {
		},
		setValue : function(target, value) {
		},
		resize : function(target, width) {
		}
	}
});

/**
 * 扩展Textbox编辑器，输入时即设置值（EasyUI默认为失去焦点时才设置值）
 */
/*$.extend($.fn.textbox.defaults.inputEvents, {
	keyup: function(e){
		var t = $(e.data.target);
		t.textbox('setValue', t.textbox('getText'));
	}
});*/

$.extend($.fn.numberbox.defaults.rules, {
    digitalCompare: {
        validator: function(value, param){
        	var x = value.split(','); 
        	num = Number(x.join(""));
        	return (param[0] <= num) && (param[1] >= num);
        },
        message: '请输入{0}-{1}之间数字.' 
    }
});

/**
 * DataGrid编辑器快捷键：
 *   回车：移动到下一个Editor,如果是最后一个Editor,编辑下一行
 *   上下箭头：编辑上一行和下一行
 *   Ctrl+s:保存当前编辑行
 *   Esc：取消当前编辑行
 * @param index
 * @param dtg
 */
function edatagridShortcutKey(index, dtg){
	var editors = dtg.datagrid('getEditors', index);
	var rows = dtg.datagrid('getRows');
	$(editors).each(function(i, editor){
		var target = getTarget(i);
		setFocus(target, i);
		
		$(target).keydown(function(event){
			if(!event.shiftKey){
				switch(event.keyCode){
					case 9: //Tab
						if((this.editorIndex + 1) == editors.length){
							$(this).trigger('blur');
							editNextRow(0);
							return false
						}
						break;
					case 13: //Enter
						if((this.editorIndex + 1) < editors.length){
							var nextTarget = getTarget(this.editorIndex + 1);
							$(nextTarget).focus();
							if(nextTarget[0].select == undefined){
								$(this).trigger('blur');
								editNextRow(0);
							}else{
								nextTarget[0].select();
							}
						}else{
							$(this).trigger('blur');
							editNextRow(0);
						}
						break;
					case 27: //Esc
						dtg.edatagrid('cancelRow');
						break;
					case 38: //Up
						if(this.isCombobox && this.isShow()){
							
						}else{
							$(this).trigger('blur');
							editPreRow(this.editorIndex);
						}
						break;
					case 40: //Down
						if(!this.isCombobox){
							$(this).trigger('blur');
							editNextRow(this.editorIndex);
						}else if(this.isShow() == false){
							$(this.arrow).click();
						}
						break;
				
				}
			}
			if(event.ctrlKey){
				switch(event.keyCode){
					case 83:
						dtg.edatagrid('saveRow');
						return false;
						break;
				}
			}
		});
		
		function getTarget(i){
			var editor = editors[i];
			var target;
			if(editor.type == 'numberbox' || editor.type == 'textbox'){
				//target = $(editor.target[0].nextSibling.children[0]);
				target = $($(editor.target[0]).next()).find('input.textbox-text')
			}else if(editor.type.substr(0,5)=='combo' || editor.type == 'datebox' || editor.type == 'datetimebox'){
				target = $($(editor.target[0]).next()).find('input.textbox-text');
				target[0].arrow = $($(editor.target[0]).next()).find('a.combo-arrow');
				target[0].panel = $($(editor.target[0]).combobox('panel')).parent();
				target[0].isCombobox = true;
				target[0].isShow = function(){
					if(this.panel.css('display') == 'none'){
						return false;
					}else{
						return true;
					}
				}
			}else{
				target = editor.target;
			}
			target[0].editorIndex = i;
			
			return target;
		}
		
		function editNextRow(focusIndex){
			dtg.edatagrid('saveRow');
			var nextIndex = index + 1;
			if(nextIndex < rows.length){
				window.focusIndex = focusIndex;
				dtg.edatagrid('editRow', nextIndex);
			}
		}
		function editPreRow(focusIndex){
			dtg.edatagrid('saveRow');
			var nextIndex = index - 1;
			if(nextIndex >= 0){
				window.focusIndex = focusIndex;
				dtg.edatagrid('editRow', nextIndex);
			}
			
		}
		function setFocus(target, index){
			if($.isNumeric(window.focusIndex)){
				if(window.focusIndex == index){
					$(target).focus();
					setTimeout(function(){target[0].select();},50);
				}
			}else{
				if(index == 0){
					$(target).focus();
					setTimeout(function(){target[0].select();},50);
				}
			}
		}
	 });
}

//数值加法运算，解决javascript浮点数计算不准确  
function floatAdd(arg1,arg2){  
	var r1,r2,m;  
	try{r1=arg1.toString().split('.')[1].length}catch(e){r1=0}  
	try{r2=arg2.toString().split('.')[1].length}catch(e){r2=0}  
	m=Math.pow(10,Math.max(r1,r2));  
	return (arg1*m+arg2*m)/m;  
}

//IE6,7下JSON对象不存在解决方法
function toJSONString(object) {
	var type = typeof object;
	if ('object' == type) {
		if (Array == object.constructor)
			type = 'array';
		else if (RegExp == object.constructor)
			type = 'regexp';
		else
			type = 'object';
	}
	switch (type) {
	case 'undefined':
	case 'unknown':
		return;
		break;
	case 'function':
	case 'boolean':
	case 'regexp':
		return object.toString();
		break;
	case 'number':
		return isFinite(object) ? object.toString() : 'null';
		break;
	case 'string':
		return '"'
				+ object.replace(/(\\|\")/g, "\\$1").replace(
						/\n|\r|\t/g,
						function() {
							var a = arguments[0];
							return (a == '\n') ? '\\n' : (a == '\r') ? '\\r'
									: (a == '\t') ? '\\t' : ""
						}) + '"';
		break;
	case 'object':
		if (object === null)
			return 'null';
		var results = [];
		for ( var property in object) {
			var value = toJSONString(object[property]);
			if (value !== undefined)
				results.push(toJSONString(property) + ':' + value);
		}
		return '{' + results.join(',') + '}';
		break;
	case 'array':
		var results = [];
		for ( var i = 0; i < object.length; i++) {
			var value = toJSONString(object[i]);
			if (value !== undefined)
				results.push(value);
		}
		return '[' + results.join(',') + ']';
		break;
	}
}
window.JSON = window.JSON == undefined?{stringify:function(json){return toJSONString(json);}}:window.JSON;
