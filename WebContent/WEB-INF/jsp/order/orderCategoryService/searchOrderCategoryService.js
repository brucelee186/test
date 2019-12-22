
//部门格式化信息
var jsonArrayDivision = jQuery.parseJSON(listArrayDivision)[0];
function formatterDropListDivision(value, rowData, rowIndex) {
 return formatterJsonDropList(value, rowData, rowIndex, jsonArrayDivision, 'id', 'name');
}



function getCategoryLevel1(pid) {
	if(pid === ''){
		return [];
	}
	
	var level = [];
	level.push({id:'', text:'- -'});
	for (var i = 0; i < categoryLevel1.length; i ++) {
		level.push({'id':categoryLevel1[i].id, 'text':categoryLevel1[i].name});
	}
	return level;
}

function getCategoryLevel2(pid) {
	var level = [];
	level.push({id:'', text:'- -'});
	for (var i = 0; i < categoryLevel2.length; i ++) {
		if (categoryLevel2[i].pid == pid) {
			level.push({'id':categoryLevel2[i].id, 'text':categoryLevel2[i].name});
		}
	}
	return level;
}

function getItemDiv() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_itemDiv.length; i ++) {
		level.push({'id':p_itemDiv[i].id, 'text':p_itemDiv[i].name});
	}
	return level;
}

	$(function() {
		var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.edatagrid(
						{
							url : contextPath + '/order/orderCategoryService/doSearch.do', //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 15, //页大小
							pageList : [ 15, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowap : true, //列内容多时自动折至第二行
							border : false,
							idField : 'id', //主键
							singleSelect : true,
							rownumbers : false,
							sortName : 'id',
							sortOrder : 'desc',
						/*	frozenColumns : [ [ {
								title : 'ID',
								field : 'id',
								width : 0,
								hidden : true
							} ] ],*/
							columns : [ [
								{
									title : 'No.',
									field : 'id',
									sortable : true,
									width : 40,
									hidden : false
								} ,
								{
									title : '申请人',
									field : 'applicantName',
									sortable : true,
									width : 75
								},
								{
									title : '收款人',
									field : 'payeeName',
									sortable : true,
									width : 75
								},
								{
									title : '申请部门',
									field : 'applicantDivisionName',
									sortable : true,
									width : 150
								},{
									title : '申请日期',
									field : 'applicantDate',
									sortable : true,
									align : 'center',
									width : 110,
									formatter : function(val){
										if(null != val && '' != val){
											return dateFormat(val);
										}
									}
								},{
									title : '总金额',
									field : 'totalAmount',
									sortable : true,
									align : 'right',
									width : 100,
									editor : {
										type : 'numberbox',
										options : {
											precision : '2',
											min : 0,
											required : true,
										}
									}
								},{
									title : '币种',
									field : 'currencyId',
									align : 'center',
									width : 70,
									formatter : function(value, row, index) {
										if(value == 1){
											return 'RMB';
										}else if(value == 2){
											return 'USD';
										}else if(value == 3){
											return 'HKD';
										}else{
											return '';
										}
									}
								},{
									title : '汇率',
									field : 'exchangeRate',
									sortable : true,
									align : 'right',
									width : 100,
									hiddable : true,
									hidden : true,
									formatter : function(value, row, index) {
										if(value) {
											return numberFormat(value, 4);
										}
									}
								},{
									title : '换算总金额',
									field : 'totalAmountRmb',
									sortable : true,
									align : 'right',
									width : 100,
									hiddable : true,
									hidden : true,
									editor : {
										type : 'numberbox',
										options : {
											precision : '2',
											min : 0,
											required : true,
										}
									}
								},{
									title : '实际总金额',
									field : 'actualTotalAmount',
									sortable : true,
									align : 'right',
									width : 100,
									hiddable : true,
									hidden : true,
									editor : {
										type : 'numberbox',
										options : {
											precision : '2',
											min : 0,
											required : true,
										}
									}
								},{
									title : '状态',
									field : 'status',
									sortable : true,
									align : 'center',
									width : 60,
									formatter : function(value, row, index) {
										if(value == 'd'){
											return '草稿';
										}else if(value == 's'){
											return '已提交';
										}else if(value == 2){
											return '已审核通过';
										}else if(value == 3){
											return '审核未通过';
										}else if(value == 9){
											return '取消';
										}else{
											return '无';
										}
									},
									styler : function(value, row, index) {
										if (value == 'd' ){
											return 'background-color:#FFEB9C;color:#9C6500;';
										}else if (value == 2){
											return 'background-color:#C6EFCE; color:#006100';
										} else if (value == 3 || value == 9) {
											return 'background-color:#FFC7CE; color:#9C0006';
										}
									}
								},{
									title : '创建时间',
									field : 'createDatetime',
									width : 150,
									sortable : true,
									hiddable : true,
									hidden : true
								},
								{
									title : '创建人',
									field : 'createUserName',
									width : 150,
									sortable : true,
									hiddable : true,
									hidden : true
								},{
									title : '更新时间',
									field : 'updateDatetime',
									width : 150,
									sortable : true,
									hiddable : true,
									hidden : true
								},{
									title : '更新人',
									field : 'updateUserName',
									width : 150,
									sortable : true,
									hiddable : true,
									hidden : true
								}
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
								{
									iconCls : 'icon-add',
									text : '添加报销',
									handler : function() {
										$('#dlg_categoryService').dialog('setTitle', '添加报销').dialog('open').dialog('center');	
										$('#edatagridDetail').edatagrid('cancelRow');
										$('#edatagridDetail').datagrid('loadData',[]);
										
										$('#frm_categoryService').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=i');
									/* 	$('#frm_categoryService').form('load', {
											vehiclePlateNo : checkedRows[0].vehiclePlateNo,
											driverId : checkedRows[0].driverId,
											type : checkedRows[0].type,
											deptRequester : checkedRows[0].deptRequester,
											timeTrip : checkedRows[0].timeTrip,
											typeExpense : checkedRows[0].typeExpense,
											idOrderServicePath : checkedRows[0].idOrderServicePath,
											expenseActual : checkedRows[0].expenseActual,
											customer : checkedRows[0].customer,
											passenger : checkedRows[0].passenger,
											origin : checkedRows[0].origin,
											destination : checkedRows[0].destination,
										}); */
									}
								}, 
								'-',
								{
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										var checkedRows = $('#datagrid').datagrid('getSelections');
										if(checkedRows[0] == undefined){
											return;
										}
										if(checkedRows[0].status == 's'){
											$.messager.alert(common_dialog_tip, '【草稿】状态可以编辑，【已审核通过】可以重新编辑！', 'warning');
											return;
										}
										
										$('#frm_categoryService').form('clear');
										$('#dlg_categoryService').dialog('setTitle', '编辑报销').dialog('open').dialog('center');	
										$('#edatagridDetail').edatagrid('cancelRow');
										$('#edatagridDetail').datagrid('loadData',[]);
										$.post(contextPath + '/order/orderCategoryService/doSearchJson.do', { 'id' : checkedRows[0].id }, function(result) {
											$.messager.progress('close');// hide progress dialog
											try {
												var r = result;
												if (r.success) {
													 $('#frm_categoryService').form('load', {
														'id' : r.obj.id,
														'applicantDivisionId' : r.obj.applicantDivisionId,
														'currencyId' : r.obj.currencyId,
														'payeeName' : r.obj.payeeName,
														'applicantDate' : r.obj.applicantDate,
														'totalAmount' : r.obj.totalAmount,
														'exchangeRate' : r.obj.exchangeRate,
														'totalAmountRmb' : r.obj.totalAmountRmb,
														'actualTotalAmount' : r.obj.actualTotalAmount
													});
													$('#edatagridDetail').datagrid('loadData', r.obj.listOrderCategoryServiceDetail);
												} else {
													$.messager.alert(common_error, '报销相关信息查找失败！', 'error');
												}
											} catch (e) {
												$.messager.alert(common_error, result, 'error');
											}
										}, 'json');
										
										$('#frm_categoryService').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=u');
										//编辑状态1：添加，2：编辑
										//$('#hid_editStatus').val(2);
										
										
										//隐藏输入框边框
										$('#nbx_totalAmount').next().css('border', '0px');
										$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
									}
								},
								'-',
									{
										text : '删除',
										iconCls : 'icon-remove',
										handler : function() {
											//删除时先获取选择行
											var rows = datagrid
													.datagrid("getSelections");
											//选择要删除的行
											if (rows.length == 1) {
												$.messager
														.confirm(
																"提示",
																"你确定要删除吗?",
																function(r) {
																	if (r) {
																		$.post(contextPath + '/order/orderServiceDetail/doEdit.do?editState=d',
																				{
																					idString : rows[0].id
																				},
																				function(result) {
																					$('#datagrid').datagrid( 'reload');
																					$.messager.show({
																						title : common_dialog_tip,
																						msg : '删除成功',
																						timeout : 2000,
																						showType : 'slide'
																					});
																				});
																	}
																});
											} else {
												$.messager.alert("提示",
														"请选择要删除的行", "error");
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
									view: detailview,
									detailFormatter: function(rowIndex, rowData){
										var html = mtfDetailGridGenerator.generate(this, rowData, rowIndex);
										return html;
									},
									detailGrid : {
										sortName : 'index',
										sortOrder : 'desc',
										dataField : 'listOrderCategoryServiceDetail',
										columns : [{
											title : '主类别',
											field : 'nameCategoryLevel1',
											align : 'left',
											width : 148
										},{
							 				title : '次类别',
											field : 'nameCategoryLevel2',
											align : 'left',
											width : 116
										},{
											title : '费用部门',
											field : 'divisionName',
											align : 'left',
											width : 110
										},{
											title : '客户',
											field : 'customerName',
											align : 'left',
											width : 110
										},{
											title : '金额',
											field : 'amount',
											align : 'right',
											width : 110,
											editor : {
												type : 'numberbox',
												options : {
													precision : '2',
													min : 0,
													required : true,
												}
											}
										},{
											title : '描述',
											field : 'description',
											align : 'left',
											tooltip : true,
											width : 205
										}]
									},
								onAfterEdit : function(rowIndex, rowData, changes) {
								var changes = datagrid.datagrid("getChanges")
								//alert(changes)
								//return;
								//endEdit该方法触发此事件
								console.info(rowData);
								//alert(rowData.name)
								//editRow = undefined;
								//提交后台处理
								$.post(contextPath + '/order/ordercategoryService/doEdit.do?editState=u',
									{
										idString : rowData.id,
										name : rowData.name,
										origin : rowData.origin,
										destination : rowData.destination,
										mileage : rowData.mileage,
										expense : rowData.expense,
										remark : rowData.remark,
										tag : rowData.tag,
									},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : common_dialog_tip,
													msg : '修改成功',
													timeout : 2000,
													showType : 'slide'
												});
									});
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							onDblClickRow : function(rowIndex, rowData) {
								//alert('double')
								//双击开启编辑行
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
							}
						});

		
		
		
	
	
	
		$('#edatagridDetail').edatagrid({
			fit : true,
			weight :800,
			height : 360, 
			border : false,
			idField : 'id',
			nowrap : true,
			rownumbers : true,
			autoRowHeight : false,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				hidden : true
			} ] ],
			columns : [ [ 
			{
				title : '主类别',
				field : 'idCategoryLeve1',
				width : 180,
				formatter : function(value, row, index) {
					return row.nameCategoryLevel1;
				},
				editor : 
					{ type : 'combobox',  
						options : {valueField : 'id', textField : 'text', panelHeight:'auto',panelMaxHeight:'200', editable:false,
						data : getCategoryLevel1(0), 
						onSelect:function(rec){
							var row = $('#edatagridDetail').datagrid('getSelected');
							var rowIndex = $('#edatagridDetail').datagrid('getRowIndex',row);
							var target = $('#edatagridDetail').datagrid('getEditor', {'index':rowIndex,'field':'idCategoryLeve2'}).target;
							target.combobox('clear');
							target.combobox('loadData', getCategoryLevel2(rec.id));
						}
						}
					}
			} ,
			{
				title : '次类别',
				field : 'idCategoryLeve2',
				width : 180,
				formatter : function(value, row, index) {
					return row.nameCategoryLevel1;
				},
				editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', panelHeight:'auto', panelMaxHeight:'200',editable:false}  }
			} ,{
				title : '描述',
				field : 'remark',
				width : 300,
				editor : { type : 'textbox',options : {validType:'length[0,100]'}}
			} ,{
				title : '金额',
				field : 'amount',
				align : 'right',
				width : 90,
				editor : 
					{
						type : 'numberbox',  
						options : {
						precision : '2',
						min : 0,
						required : true,
						onChange:function(rec){
							var allRows = $('#edatagridDetail').edatagrid('getRows');
							var totalAmount = 0.0;
							for(var i = 0; i < allRows.length; i++ ){
								totalAmount += allRows[i].amount*1.0;
								//console.info(allRows[i].amount);
							}
							//console.info(totalAmount*1.00);
							$('#totalAmount').numberbox('setValue',totalAmount*1.00);
						}
					},
				}
			} ,
			{
				title : '费用部门',
				field : 'divisionId',
				width : 100,
				formatter : formatterDropListDivision,
				align : 'left',
				editor : {
					type : 'combobox',
					options : {
						data : jsonArrayDivision,
						valueField : 'id',
						textField : 'name',
						required : true,
						editable : false,
				 }
				}
			},{
				title : '客户',
				field : 'customerId',
				width : 100,
				formatter : function(value, row, index) {
					return row.customerName;
				}, 
				//editor : { type : 'combobox', options : {valueField : 'id', textField:'text', data: p_customerList, panelHeight:'auto', editable:false}  }
				editor : { type : 'combobox', options : {url : contextPath + '/maintenance/customer/doListTetrad.do?type=0&aps=1',
				valueField : 'first',textField : 'third', panelHeight:'auto',panelMaxHeight:'200', editable:false}  }
			} ] ],
			onBeforeSave : function(index) {
				var rows = $(this).datagrid('getRows');
				
				var category1Editor = $(this).datagrid('getEditor', {index : index, field : 'idCategoryLeve1'});
				var idCategoryLeve1 = $(category1Editor.target[0]).combobox('getValue');			
				var nameCategoryLevel1 = $(category1Editor.target[0]).combobox('getText');			
				rows[index].idCategoryLeve1 = idCategoryLeve1;
				rows[index].nameCategoryLevel1 = nameCategoryLevel1;
				
				var category2Editor = $(this).datagrid('getEditor', {index : index, field : 'idCategoryLeve2'});
				var idCategoryLeve2 = $(category2Editor.target[0]).combobox('getValue');			
				var nameCategoryLevel2 = $(category2Editor.target[0]).combobox('getText');			
				rows[index].idCategoryLeve2 = idCategoryLeve2;
				rows[index].nameCategoryLevel2 = nameCategoryLevel2;
				
				var divisionEditor = $(this).datagrid('getEditor', {index : index, field : 'divisionId'});
				var divisionName = $(divisionEditor.target[0]).combobox('getText');			
				rows[index].divisionName = divisionName;
				
				var customerEditor = $(this).datagrid('getEditor', {index : index, field : 'customerId'});
				var customerName = $(customerEditor.target[0]).combobox('getText');			
				rows[index].customerName = customerName;
			},
			onSelect : function(index, row) {
				//编辑后取消提交需要
				$('#edatagridDetail').edatagrid('editRow', index);
				var idCategoryLeve2Target = $('#edatagridDetail').datagrid('getEditor', {'index':index,'field':'idCategoryLeve2'}).target;
				//target.combobox('clear');
				if(row.idCategoryLeve1 != null && row.idCategoryLeve1 != ''){
					idCategoryLeve2Target.combobox('loadData', getCategoryLevel1(row.idCategoryLeve1)).combobox('setValue', row.idCategoryLeve2);
				}
				
			},
			toolbar : [  
			    {
				iconCls : 'icon-add',
				text : common_button_add,
				handler : function() {
					$('#edatagridDetail').edatagrid('saveRow');
					var rows = $('#edatagridDetail').datagrid('getRows');
					var lastRowIndex = rows.length;
					if(lastRowIndex > 5){
						$.messager.alert(common_dialog_tip, '最多添加6项报销记录！', 'warning'); 
						return;
					}
				 	$('#edatagridDetail').datagrid('appendRow',{});
					$('#edatagridDetail').edatagrid('editRow', lastRowIndex);	
					$('#edatagridDetail').edatagrid('selectRow', lastRowIndex);	
				}
			}, 
			'-',  {
				iconCls : 'icon-edit',
				text : common_button_edit,
				handler : function() {
					var selectedRow = $('#edatagridDetail').edatagrid('getSelected');
					if(!selectedRow){
						return;
					}
					var selectedIndex = $('#edatagridDetail').edatagrid('getRowIndex', selectedRow);
					$('#edatagridDetail').edatagrid('editRow', selectedIndex);
					$('#edatagridDetail').edatagrid('selectRow', selectedIndex);
				}
			}, 
			'-',  {
				iconCls : 'icon-remove',
				text : common_button_remove,
				handler : function() {
					var rows = $('#edatagridDetail').edatagrid('getRows');
					 if(rows.length < 2){
						return;
					} 
					
					var selectedRow = $('#edatagridDetail').edatagrid('getSelected');
					if(!selectedRow){
						return;
					}
					
					var selectedIndex = $('#edatagridDetail').edatagrid('getRowIndex', selectedRow);
					$('#edatagridDetail').edatagrid('deleteRow', selectedIndex);
					
					//var rows = $('#edatagridDetail').datagrid('getRows');
					if(rows.length == 0){
						return;
					}
					if(selectedIndex < rows.length){
						$('#edatagridDetail').edatagrid('editRow', selectedIndex);
						$('#edatagridDetail').edatagrid('selectRow', selectedIndex);
					}else{
						$('#edatagridDetail').edatagrid('editRow', rows.length - 1);
						$('#edatagridDetail').edatagrid('selectRow', rows.length - 1);
					}
					
					//删除时重新计算总金额
					var allRows = $('#edatagridDetail').edatagrid('getRows');
					var totalAmount = 0.0;
					for(var i = 0; i < allRows.length; i++ ){
						totalAmount += allRows[i].amount*1.0;
						//console.info(allRows[i].amount);
					}
					//console.info(totalAmount*1.00);
					$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
				}
			}, 
			'-',  
			]
		});
		
		$('#frm_categoryService').form({
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
					$('#edatagridDetail').edatagrid('saveRow');
					var data = $('#edatagridDetail').datagrid('getRows');
					var jsonListString = JSON.stringify(data);
					$('#jsonListString').val(jsonListString);
				} else {
					$.messager.progress('close');	// hide progress bar while the form is invalid
					$.messager.alert(common_dialog_tip, '请完整填写！', 'warning'); 
				}
				return isValid;	// return false will stop the form submission
			},
			success : function(result) {
				$.messager.progress('close');
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$('#dlg_categoryService').dialog('close');
						$('#datagrid').datagrid('reload', serializeObject($('#formSearch')));
						$.messager.show({
							title : common_dialog_error,
							msg : '操作成功',
							timeout : 2000,
							showType : 'slide'
						});
						$('#datagrid').datagrid("clearSelections");
					} else {
						$.messager.alert(common_dialog_error, r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert(common_dialog_error, result, 'error');
				}
			}
		});
	});

function submitForm(status){
	$('#status').val(status);
	$('#frm_categoryService').submit();
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
	opt.url = contextPath + '/order/orderCategoryService/doSearch.do';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#formSearch')));
}

