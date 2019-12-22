//权限类型列表
var p_accesslist = {
		// Style
		'A0101':'BOM',// view/edit basic/colorway/fabric/trim/size
		'A0102':'TDOF',// request/view
		'A0103':'Sample',// request/view
		'A0104':'Costing',// new/edit/submit
		'A0105':'Order',// new/edit
		'A0106':'Finalize',// view/edit
		'A0107':'Purchase',// view
		'A0108':'Security',
		// TDOF
		'A0201':'TDOF',//
		// Sample
		'A0301':'Sample',
		// Costing
		'A0401':'Costing',
		// Order
		'A0501':'Order'
};
//通知类型列表
var p_notificationlist = {
		// Style
		'N0101':'Style Active',
		// TDOF
		'N0201':'TDOF Request',
		'N0202':'TDOF Response',
		// Sample
		'N0303':'SID Create',
		// Costing
		'N0401':'Costing Request Approval',
		'N0402':'Costing Approve Response',
		// Order
		'N0501':'Order Active',
		'N0502':'Order Request Approval'
};

var p_cutMethod = {'1':'Two Way Random Cut', '2':'Cut in Gross Grain', '3':'One Way Cut', '4':'One Way Per Garment', '5':'Bias Cut', '0':'Other'};

/**
* 根据上面定义的全局对象，生成Combo数据
*
* @param object			obj  		上面定义的全局对象
* @param int			addEmpty	添加空行
* @param Regex			keyFilter	过滤key
* @param Regex			textFilter  过滤text
* @return Array  
*/  
function getComboData(obj, addEmpty, keyFilter, textFilter){
	var data = [];
	if(addEmpty){
		data.push({'id':'', 'text':''});
	}
	for(key in obj){
		if(keyFilter && typeof(keyFilter.test) == 'function'){
			if(!keyFilter.test(key)){
				continue;
			}
		}
		if(textFilter && typeof(textFilter.test) == 'function'){
			if(!textFilter.test(obj[key])){
				continue;
			}
		}
		
		data.push({'id':key, 'text':obj[key]});
	}
	
	return data;
}