
function getCustomerPid(customerId) {
	if(customerId){
		return [];
	}
	
	var customerPid = '';
	for (var i = 0; i < jsonArrayCustomer.length; i ++) {
		var id = jsonArrayCustomer[i].id;
		var pid = jsonArrayCustomer[i].pid;
		if (customerId == id) {
			customerPid = pid;
		}
	}
	return customerPid;
}

function getCustomerName(customerId) {
	if(customerId == null || customerId == ''){
		return '';
	}
	
	var customerName = '';
	for (var i = 0; i < jsonArrayCustomer.length; i ++) {
		var id = jsonArrayCustomer[i].id;
		var name = jsonArrayCustomer[i].name;
		if (customerId == id) {
			customerName = name;
			return name;
		}
	}
	return customerName;
}


function itemAdd(goods){
	//加载窗口
	constructWindow(goods,'商品添加',800,320);
	//显示弹出窗口工具栏
	domShow('goods');
}

