$.extend($.fn.combobox.methods, {
    selectedIndex: function (jq, index) {
        if (!index)
            index = 0;
        var data = $(jq).combobox('options').data;
        var vf = $(jq).combobox('options').valueField;
        $(jq).combobox('setValue', eval('data[index].' + vf));
    }
});

// 多浏览器可以，js新规时间
function NewDate(str, hour, minute, second) {
    str = str.split('-'); 
    var date = new Date(); 
    date.setUTCFullYear(str[0], str[1] - 1, str[2]);
    //hours[, minutes[, seconds[, milliseconds ]]] 
    date.setUTCHours(hour, minute, second, 0); 
    return date; 
}

// 刷新对应标题的tab页
function refreshTab(tab) {
	if (tab != undefined) {
		var href = tab.panel('options').href;
		if (href) {/*说明tab是以href方式引入的目标页面*/
			var index = t.tabs('getTabIndex', tab);
			t.tabs('getTab', index).panel('refresh');
		} else {/*说明tab是以content方式引入的目标页面*/
			var panel = tab.panel('panel');
			var frame = panel.find('iframe');
			try {
				if (frame.length > 0) {
					for ( var i = 0; i < frame.length; i++) {
						frame[i].contentWindow.document.write('');
						frame[i].contentWindow.close();
						frame[i].src = frame[i].src;
					}
					if ($.browser.msie) {
						CollectGarbage();
					}
				}
			} catch (e) {
			}
		}
	}
}

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

/**
 * 把搜索条件表单格式化为查询参数数组
 * @param form
 */
function serializeObject(form) {
	serializeArray = form.serializeArray();
	var paramArray = {};
	$.each(serializeArray, function(index, element) {
		if (paramArray[this['name']]) {
			paramArray[this['name']] = paramArray[this['name']] + ',' + this['value'];
		} else {
			paramArray[element.name] =element.value;
		}
	});
	return paramArray;
}

// 重写任意匹配模糊查询下拉框
(function() {
	$.fn.combotree.defaults.editable = true;
	$.extend($.fn.combotree.defaults.keyHandler, {
		up : function() {
			console.log('up');
		},
		down : function() {
			console.log('down');
		},
		enter : function() {
			console.log('enter');
		},
		query : function(q) {
			var t = $(this).combotree('tree');
			var nodes = t.tree('getChildren');
			for ( var i = 0; i < nodes.length; i++) {
				var node = nodes[i];
				if (node.text.indexOf(q) >= 0) {
					$(node.target).show();
				} else {
					$(node.target).hide();
				}
			}
			var opts = $(this).combotree('options');
			if (!opts.hasSetEvents) {
				opts.hasSetEvents = true;
				var onShowPanel = opts.onShowPanel;
				opts.onShowPanel = function() {
					var nodes = t.tree('getChildren');
					for ( var i = 0; i < nodes.length; i++) {
						$(nodes[i].target).show();
					}
					onShowPanel.call(this);
				};
				$(this).combo('options').onShowPanel = opts.onShowPanel;
			}
		}
	});
})(jQuery);


//格式化日期格式
function dateFormat(date) {
	date = new Date(date);
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}

// 共有json下拉框格式化
function formatterJsonDropList(value, rowData, rowIndex, jsonArray,typeId,typeName) {
	if (value == 0) {
		return;
	}
	for ( var i = 0; i < jsonArray.length; i++) {
		if (eval('jsonArray[i].' + typeId) == value) {
			return eval('jsonArray[i].' + typeName);
		}
	}
}

// 构建弹出窗口
function constructWindow(domId,tit,wdt,hgt){
    $('#'+domId).window({
		title: tit,
		width: wdt,
		resizable:false,
		modal: true,
		draggable:true,
		collapsible:false,
		shadow: true,
		closed: false,
		maximizable:false,
		minimizable:false,
		height:hgt
		
	});
}


function domShow(domId){
    $('#'+domId).show();
}



function ajax(url,data,closeWindow){
	var result="";
	$.ajax({
		async:false,
		type: "POST",
		url: url,
	    data: data,
		success: function(data){
			if(closeWindow!=""){
				$('#'+closeWindow+'').window('close');
			}
			if(data!=""){
				result=data;
			}
		}
	});
	return result;
}