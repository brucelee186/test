
	// 参数(主编号, datagridId, 是否显示按钮)
	function loadDetailGrid(idMain, datagrid,statusButton) {
		var datagridDetail; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagridDetail = $('#' + datagrid)
				.datagrid(
						{
							url :  contextPath +　'/order/orderServiceDetail/doSearch.do?idOrderService=' + idMain, //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 10, //页大小
							pageList : [ 10, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowap : true, //列内容多时自动折至第二行
							border : false,
							idField : 'id', //主键
							singleSelect : true,
							sortName : 'id',
							sortOrder : 'asc',
							rownumbers : false,
							columns : [ [//显示的列
							{
								title : 'ID',
								field : 'id',
								width : 0,
								sortable : false,
								checkbox : true,
							//hidden : true
							}, 
							{
								field : 'idOrderService',
								width : 0,
								sortable : false,
								hidden : true
							}, 
							{
								title : '出行地点 Location',
								field : 'location',
								width : 400,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : true,
										validType : 'length[1,30]',
									}
								}
							}, 
							{
								title : '出发时间 Depart Time',
								field : 'timeDepart',
								width : 200,
								align : 'center',
								sortable : true,
								editor : {
									type : 'datetimebox',
									options : {
										required : true,
										editable : false,
										showSeconds : false,
									}
								},
							},
							{
								title : '出发里程 Mileage of Departure',
								field : 'mileageDeparture',
								width : 200,
								align : 'right',
								sortable : true,
								editor : {
									type : 'numberbox',
									options : {
										precision : '2',
										min : 0.25,
										max : 50000,
										required : true,
									}
								}
							},
							] ],
							//查询参数
							queryParams : {
								action : 'query'
							}, 
							toolbar : [
									{
										text : '添加',
										iconCls : 'icon-add',
										handler : function() {
											$('#editStateDetail').val('i');
											// 验证主表
											/*var isValid = $('#form').form('validate');
											if (false == isValid) {
												$.messager.alert('提示','添加路线前,请补充完整用车信息!','error');
												return;
											}*/
											//添加列表的操作按钮添加，修改，删除等
											//添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
											if (editRow != undefined) {
												datagridDetail.datagrid("endEdit",
														editRow);
											}
											//添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
											if (editRow == undefined) {
												datagridDetail.datagrid("insertRow",
														{
															index : 0, // index start with 0
															row : {

															}
														});
												//将新插入的那一行开户编辑状态
												datagridDetail.datagrid("beginEdit",
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
											var rows = datagridDetail
													.datagrid("getSelections");
											//如果只选择了一行则可以进行修改，否则不操作
											if (rows.length == 1) {
												$('#editStateDetail').val('u');
												//修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
												if (editRow != undefined) {
													datagridDetail.datagrid(
															"endEdit", editRow);
												}
												//当无编辑行时
												if (editRow == undefined) {
													//获取到当前选择行的下标
													var index = datagridDetail
															.datagrid(
																	"getRowIndex",
																	rows[0]);
													//开启编辑
													datagridDetail.datagrid(
															"beginEdit", index);
													//把当前开启编辑的行赋值给全局变量editRow
													editRow = index;
													//当开启了当前选择行的编辑状态之后，
													//应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
													datagridDetail
															.datagrid("unselectAll");
												}
											}
										}
									},
									'-',
									{
										text : '删除',
										iconCls : 'icon-remove',
										handler : function() {
											//删除时先获取选择行
											var rows = datagridDetail
													.datagrid("getSelections");
											//选择要删除的行
											if (rows.length == 1) {
												$.messager
														.confirm(
																"提示",
																"你确定要删除吗?",
																function(r) {
																	if (r) {
																		var checkedRows = $('#datagrid').datagrid('getChecked');
																		var idOrderService = checkedRows[0].id;
																		$.post( contextPath + '/order/orderServiceDetail/doEdit.do',
																				{
																					editState : 'd',
																					id : rows[0].id,
																					idOrderService : idOrderService,
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
																	$('#datagridDetail').datagrid("clearSelections");
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
											datagridDetail.datagrid("endEdit",
													editRow);
										}
									}, '-', {
										text : '取消编辑',
										iconCls : 'icon-redo',
										handler : function() {
											//取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
											editRow = undefined;
											datagridDetail.datagrid("rejectChanges");
											datagridDetail.datagrid("unselectAll");
										}
									}, '-' ],
							onAfterEdit : function(rowIndex, rowData, changes) {
								var changes = datagridDetail.datagrid("getChanges")
								//alert(changes)
								//return;
								//endEdit该方法触发此事件
								console.info(rowData);
								//alert(rowData.name)
								//editRow = undefined;
								//提交后台处理
								var checkedRows = $('#datagrid').datagrid('getChecked');
								var idOrderService = checkedRows[0].id;
								var dayStart = rowData.dayStart;
								var dayEnd = rowData.dayEnd;
								/* if (dayEnd != '' && dayEnd != null && dayStart != null && (dayEnd <= dayStart)) {
									$.messager.alert(common_dialog_tip, '结束日期不能小于或等于开始日期!', 'warning');
									editRow = undefined;
									return;
								} */
								var editStateDetail = $('#editStateDetail').val();
								$.post(　contextPath　+ '/order/orderServiceDetail/doEdit.do',
									{
										id : rowData.id,
										location : rowData.location,
										timeDepart : rowData.timeDepart + ':00',
										mileageDeparture : rowData.mileageDeparture,
										idOrderService : idOrderService,
										editState : editStateDetail,
										/*vehiclePlateNo : $('#vehiclePlateNo').textbox('getValue'),
										driverId : $('#driverId').textbox('getValue'),
										deptRequester : $('#deptRequester').textbox('getValue'),
										timeTrip : $('#vehiclePlateNo').textbox('getValue'),
										typeExpense : $('#typeExpense').textbox('getValue'),
										idOrderServicePath : $('#idOrderServicePath').textbox('getValue'),
										passenger : $('#passenger').textbox('getValue'),
										expenseActual : $('#expenseActual').textbox('getValue'),*/
									},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										$('#datagridDetail').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : common_dialog_tip,
													msg : '操作成功',
													timeout : 2000,
													showType : 'slide'
												});
										$('#datagridDetail').datagrid("clearSelections");
									});
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							onDblClickRow : function(rowIndex, rowData) {
								//alert('double')
								//双击开启编辑行
								$('#editStateDetail').val('u');
								var tagModule = $('#tagModule').val();
								if ('o' != tagModule) {
									if (editRow != undefined) {
										datagridDetail.datagrid("endEdit", editRow);
									}
									if (editRow == undefined) {
										datagridDetail.datagrid("beginEdit", rowIndex);
										editRow = rowIndex;
									}
								}
							}
						});
	}

