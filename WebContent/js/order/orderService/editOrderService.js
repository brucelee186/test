// 模块(订车 o:order, 派车 a:allocation)
var tagModule = $('#tagModule').val();
// 出行类别变更
function changeTypeExpense(typeExpense) {
	// 固定金额
	if ('jflb1' == typeExpense) {
		$('div.datagrid-toolbar').eq(2).hide();
		// 显示始发地,目的地
		$('.type_jflb1').show();
		$('#idOrderServicePath').combobox({required : true})
	}
	// 公里数
	if ('jflb2' == typeExpense) {
		$('div.datagrid-toolbar').eq(2).show();
		// 隐藏始发地,目的地
		$('.type_jflb1').hide();
		//$('#idOrderServicePath').combobox('hide');
		// 去掉验证
		$('#idOrderServicePath').combobox({required : false})
	}
}

// 变更路线
function changeOrderServicePath(rec) {
	var timeTrip = $('#timeTrip').datetimebox('getValue');
	if (null == timeTrip || '' == timeTrip) {
		$.messager.alert(common_dialog_error, '请填写出行时间!', 'error');
		$('#idOrderServicePath').combobox('setValue', '');
		return;
	}
	var origin = rec.origin;
	var destination = rec.destination;
	var mileage = rec.mileage;
	$('#origin').textbox('setValue', origin);
	$('#destination').textbox('setValue', destination);
	var timeTrip = $('#timeTrip').datetimebox('getValue');
	$('#datagridDetailEdit').datagrid('loadData', { total: 0, rows: [] })
	$('#datagridDetailEdit').datagrid('insertRow',{
		index: 0,	
		row: { 
			id : '',
			location : origin,
			timeDepart : timeTrip,
			mileageDeparture : mileage,
		}
		});
	var data = $('#datagridDetailEdit').datagrid('getRows');
	var jsonListString = JSON.stringify(data);
	$('#jsonListString').val(jsonListString);
}

// 变更时间
function changeTimeTrip(time) {
	//$('#idOrderServicePath').select();
	//alert($('#datagridDetailEdit').datagrid('getRows')[0][columns[0][2].timeDepart])
	//$('#datagridDetailEdit').datagrid.('getRows')[0][columns[0][2].timeDepart].val(time);
	
}

function submitSearchForm() {
	var searchDateStart = $('#searchDateStart').datebox('getValue');
	var searchDateEnd = $('#searchDateEnd').datebox('getValue');
	if (searchDateStart != null && searchDateEnd != null) {
		var calDateStart = new Date(searchDateStart);
		var calDateEnd = new Date(searchDateEnd);
		if (calDateEnd < calDateStart) {
			$.messager.alert(common_dialog_tip, '开始时间不能大于结束时间!', 'warning');
			return;
		}
	}
	var opt = $('#datagrid').datagrid('options');
	opt.url = contextPath + '/order/orderService/doSearch.do';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#formSearch')));
}

//订车状态(d:draft 草稿,s:提交,a:分配)
function submitFormMain(typeSubmit) {
	alert(1111);
	$('#statusOrder').val(typeSubmit);
	$('#form').submit();
}