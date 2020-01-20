

var comboStatus = [ {
	"value" : "a",
	"text" : "启用"
}, {
	"value" : "f",
	"text" : "禁用"
} ];
	
function formatterCombo(value, rowData, rowIndex) {
	if (value == 0) {
		return;
	}
	for ( var i = 0; i < comboStatus.length; i++) {
		if (comboStatus[i].value == value) {
			return comboStatus[i].text;
		}
	}
}	
$(function(){
	$('#initAddSuppliers').window('close');
	$('#initSearchSuppliers').window('close');
	//加载下拉框
    $.ajax({
		url :"",
		cache :true,
		async: false,
		success : function(data) {
		    var m;
		    var p = '';
		    temp_positionId =p;
			$.each(p,function(index, c){
			   m +="<option value='"+c.levelId+"'>"+c.levelName+"</option>";
			});
			$('#levelId_s').append(m);
			$('#levelId').append(m);
		}
	});
    
  //加载区域下拉框
    $.ajax({
		url :"",
		cache :true,
		async: false,
		success : function(data) {
		    var m;
		    var p = '';
		    temp_departmentId =p;
			$.each(p,function(index, c){
			   m +="<option value='"+c.districtId+"'>"+c.districtName+"</option>";
			});
			$('#districtId_s').append(m);
			$('#districtId').append(m);
		}
	});
    
	//打开添加供应商对话框
	$("#addSuppliers").click(function(){
		$('#initAddSuppliers').css("display","block");
		$('#initAddSuppliers').window('open');
	});
	//打开查询供应商对话框
	$("#searchSuppliers").click(function(){
		$('#initSearchSuppliers').css("display","block");
		//编号
        var suppliersId = $("#suppliersId_s").val();
        //名称
        var suppliersName=$("#suppliersName_s").val();
        //状态
        var status = "1";
        //助记码
		var mnemonic = $("#mnemonic_s").val();
		//区域
		var districtId = $("#districtId_s").val();
		//等级
		var levelId = $("#levelId_s").val();
		var parmarter = 'suppliersId='+suppliersId+'&suppliersName='+suppliersName+'&mnemonic='+mnemonic+'&districtId='+districtId+'&levelId='+levelId+'&status='+status;
		initSuppliers(parmarter);
		$('#initSearchSuppliers').window('open');
	});	
});


function insertSuppliers(){
	if($('#suppliersDialogForm').form('validate')== false)return ;
	var userName = $("#dia_userName").textbox('getValue');
    var bankName = $("#dia_bankName").textbox('getValue');
	var bankCard = $("#dia_bankCode").numberbox('getValue');
	var mobileNo = $("#dia_mobileNo").textbox('getValue');
	var email = $("#dia_email").textbox('getValue');
	var status = $("#dia_statusUser").combobox('getValue');
	$.post(contextPath + '/maintenance/sysTemp/doEdit.do?editState=i&type=ocsrp', {
		text1 :userName,
		text2 :bankName,
		text3 :bankCard,
		text4 :mobileNo,
		text5 :email,
		text6 :status,
	}, function(res) {
		var j = $.parseJSON(res); 
//		$('#txt_payeeName').combobox({
//			url : contextPath + '/common/droplist/doListUserBank.do',
//			valueField : 'userId',
//			textField : 'uniqueName',
//			editable : true,
//			multiple : false, 
//		});
		
		//var payeeId = rowData.text7;
	   // var txt_payeeName = userName;
		var payeeId = j.obj.id;
	    //给页面赋值，根据需要增加赋值(*修改的地方)
	    $("#bankName").val(bankName);
	    $("#bankCard").val(bankCard);
	    $("#payeeId").val(payeeId);
	    $("#payeeName").val(userName);
	    $("#txt_payeeName").combobox('setValue', 'o');
	    $("#txt_payeeName").combobox('setText',userName);
	    $("#payeeType").val('o');
		$('#initAddSuppliers').window('close');
		/*$.messager.show( {
			title :'操作日志',
			msg :data,
			timeout :3000,
			showType :'fade'
		});*/
	});
	suppliersResize();

}

//*************************************************************
//* mothed :initSuppliers                                         
//* discrib:供应商DataGrid初始化                                
//* Param  :str(自定义参数)                                             
//* author :liyang                                         
//* date   :2011-05-30                                        
//*************************************************************
function initSuppliers(str){
	var editRow = undefined; 
	var datagrid = $('#suppliers').datagrid({
			nowrap: true,
			striped: true,
			collapsible:true,
			loadMsg:'正在加载...请稍等!',
			sortOrder: 'desc',
			remoteSort: false,
			height:280,
			pageNumber:1,
			singleSelect: true, 
			idField:'id',
			url: contextPath + '/maintenance/sysTemp/doSearch.do?type=ocsrp',
			title: '',
			columns:[[
				{
					field:'text1',
					title:'收款人',
					width:150,
					sortable:true,
					editor : {
						type : 'validatebox',
						options : {
							required : true,
							validType : 'length[1,30]',
						}
					}
				},
				{
					field:'text2',
					title:'开户行',
					width:60,
					sortable:true,
					editor : {
						type : 'validatebox',
						options : {
							required : true,
							validType : 'length[1,30]',
						}
					}
				},
				{
					field:'text3',
					title:'银行帐号',
					width:180, 
					align : 'right', 
					sortable:true,
					editor : {
						type : 'validatebox',
						options : {
							required : true,
							validType : 'length[1,25]',
						}
					}
				},
				{
					field:'text4',
					title:'手机',
					width:80, 
					align : 'right', 
					sortable:true,
					editor : {
						type : 'validatebox',
						options : {
							validType : 'length[1,15]',
						}
					}
				},
				{
					field:'text5',
					title:'邮箱',
					width:100,
					sortable:true,
					editor : {
						type : 'validatebox',
						options : {
							validType : 'length[1,30]',
						}
					}
				},
				{
					title : 'Status',
					field : 'text6',
					align : 'center',
					formatter : function(value, row, index) {
						if (value == 'a'){
							return '启动';
						} else {
							return '禁用';
						}
					},
					styler: function(value, row, index){
						if (value == 'a'){
							return 'background-color:#C6EFCE;color:#006100;';
						} else {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
					},
					editor : {
						type : 'combobox',
						options : {
							data : comboStatus,
							valueField : "value",
							textField : "text",
							required : true,
							editable : false,
						}
					}
				},

			]],
			toolbar : [
						{
							text : '添加',
							iconCls : 'icon-add',
							handler : function() {//添加列表的操作按钮添加，修改，删除等
								//添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
								if (editRow != undefined) {
									datagrid.datagrid("endEdit",
											editRow);
								}
								//添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
								if (editRow == undefined) {
									datagrid.datagrid("insertRow",
											{
												index : 0, // index start with 0
												row : {

												}
											});
									//将新插入的那一行开户编辑状态
									datagrid.datagrid("beginEdit",
											0);
									//给当前编辑的行赋值
									editRow = 0;
								}

							}
						},
						'-',
						{
							text : '修改',
							iconCls : 'icon-edit',
							handler : function() {
								//修改时要获取选择到的行
								var rows = $('#suppliers').datagrid("getSelections");
								//如果只选择了一行则可以进行修改，否则不操作
								if (rows.length == 1) {
									//修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
									if (editRow != undefined) {
										datagrid.datagrid(
												"endEdit", editRow);
									}
									//当无编辑行时
									if (editRow == undefined) {
										//获取到当前选择行的下标
										var index = datagrid
												.datagrid(
														"getRowIndex",
														rows[0]);
										//开启编辑
										datagrid.datagrid(
												"beginEdit", index);
										//把当前开启编辑的行赋值给全局变量editRow
										editRow = index;
										//当开启了当前选择行的编辑状态之后，
										//应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
										datagrid
												.datagrid("unselectAll");
									}
								}
							}
						},
						'-',
						{
							text : '保存',
							iconCls : 'icon-save',
							handler : function() {
								//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
								datagrid.datagrid("endEdit",
										editRow);
							}
						}, '-', {
							text : '取消编辑',
							iconCls : 'icon-redo',
							handler : function() {
								//取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
								editRow = undefined;
								datagrid.datagrid("rejectChanges");
								datagrid.datagrid("unselectAll");
							}
						}, '-' ],
						onAfterEdit : function(rowIndex, rowData, changes) {
							var changes = datagrid.datagrid("getChanges")
							//endEdit该方法触发此事件
							console.info(rowData);
							//editRow = undefined;
							//提交后台处理
							$.post(contextPath + '/maintenance/sysTemp/doEdit.do?editState=i&type=ocsrp',
								{
									id : rowData.id,
									text1 : rowData.text1,
									text2 : rowData.text2,
									text3 : rowData.text3,
									text4 : rowData.text4,
									text5 : rowData.text5,
									text6 : rowData.text6,
									text7 : rowData.text7,
								},
								function(result) {
									$('#datagrid').datagrid( 'reload');
									editRow = undefined;
									$.messager
											.show({
												title : '提示',
												msg : '修改成功',
												timeout : 2000,
												showType : 'slide'
											});
									
									
								});
						},
						onLoadError : function (data) {
							editRow = undefined;
						},
						onLoadSuccess : function (data){
						},
						onSelect : function(rowIndex, rowData) {
						},
			pagination:true,
			rownumbers:true,
			onDblClickRow: function(rowIndex,rowData){
				var payeeId = rowData.id;
			    var txt_payeeName =rowData.text1;
			    var userName = rowData.text1;
			    var bankName = rowData.text2;
			    var bankCard = rowData.text3;
			    //给页面赋值，根据需要增加赋值(*修改的地方)
			    $("#txt_payeeName").combobox('setValue',payeeId);
			    $("#txt_payeeName").combobox('setText',txt_payeeName);
			    $("#payeeType").val('o');
			    $("#bankName").val(bankName);
			    $("#bankCard").val(bankCard);
			    $("#payeeId").val(payeeId);
			    $("#payeeName").val(userName);
			    
			    $('#initSearchSuppliers').window('close');
			}
		});
		//$('#suppliers').datagrid("reload");
}

//*************************************************************
//* mothed :searchSuppliersByCond                                         
//* discrib:根据条件查询供应商                                       
//* Param  :none                                              
//* author :liyang                                         
//* date   :2011-05-30                                        
//*************************************************************
function searchSuppliersByCond(){
	//编号
    var suppliersId = $("#suppliersId_s").val();
    //名称
    var suppliersName=$("#suppliersName_s").val();
    //状态
    var status = "1";
    //助记码
	var mnemonic = $("#mnemonic_s").val();
	//区域
	var districtId = $("#districtId_s").val();
	//等级
	var levelId = $("#levelId_s").val();
	var parmarter = 'suppliersId='+suppliersId+'&suppliersName='+suppliersName+'&mnemonic='+mnemonic+'&districtId='+districtId+'&levelId='+levelId+'&status='+status;
	initSuppliers(parmarter);
	
	
	$('#suppliersId_s').val('');
	$('#suppliersName_s').val('');
    $('#mnemonic_s').val('');
	$('#districtId_s').val('');
    $('#levelId_s').val('');
	
}

//*************************************************************
//* mothed :resize                                         
//* discrib:重置供应商                                
//* Param  :none                                              
//* author :liyang                                         
//* date   :2011-05-30                                        
//*************************************************************
function suppliersResize(){
	$("#userName").textbox("setValue", "");
	$("#bankName").textbox("setValue", "");
	$("#bankCode").numberbox("setValue", "");
	$("#mobileNo").textbox("setValue", "");
	$("#email").textbox("setValue", "");
	$("#statusUser").combobox("setValue", "a");
   
}