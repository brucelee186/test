<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Mail Log</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
$(function() {
	$('#dtg_mail').datagrid({
		url : '${pageContext.request.contextPath}/admin/mail/doSearch.do',
		fit : true,
		border : false,
		pagination : true,
		//idField : 'id',
		sortName : 'createDateTime',
		sortOrder : 'desc',
		pageSize : 50,
		pageList : [ 10, 20, 50, 100, 200 ],
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		nowrap : true,
		autoRowHeight : false,
		rownumbers : true,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		} ] ],
		columns : [ [ {
			title : 'Type',
			field : 'type',
			width : 125,
			align : 'center',
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 1) return 'Purchase';
				if (value == 2) return 'Reimbursement';
				if (value == 3) return 'ReimbursementReport';
			}
		}, {
			title : '',
			field : 'priority',
			align : 'center',
			width : 26,
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 1) {
					return '<a href="javascript:void(0);" class="mtficon ext-icon-mail_high" title="High"></a>';
				} else if (value == 5){
					return '<a href="javascript:void(0);" class="mtficon ext-icon-mail_low" title="Low"></a>';
				}
			}
		}, {
			title : '',
			field : 'extFile',
			align : 'center',
			width : 26,
			formatter : function(value, row, index) {
				if (row.extFile) {
					return '<a href="javascript:void(0);" class="mtficon ext-icon-attach" title="Attach"></a>';
				}
			}
		}, {
			title : 'TO',
			field : 'tos',
			width : 150,
			formatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...');
				} else {
					return '';
				}
			},
			tipFormatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...').replace(/;/gi, '<br />');
				}
			}
		}, {
			title : 'CC',
			field : 'ccs',
			width : 150,
			sortable : true,
			formatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...');
				} else {
					return '';
				}
			},
			tipFormatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...').replace(/;/gi, '<br />');
				}
			}
		}, {
			title : 'BCC',
			field : 'bccs',
			width : 150,
			hidden : true,
			hiddable : true,
			sortable : false,
			formatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...');
				} else {
					return '';
				}
			},
			tipFormatter : function(value, row, index) {
				if (value) {
					return value.replace(/manchutimesfashion.com/gi, '...').replace(/;/gi, '<br />');
				}
			}
		}, {
			title : 'Subject',
			field : 'subject',
			width : 270,
			sortable : false
		}, {
			title : 'Retry',
			field : 'retry',
			width : 50,
			align : 'right',
			sortable : true
		}, {
			title : 'Status',
			field : 'status',
			align : 'center',
			width : 50,
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 0){
					return '<a href="javascript:void(0);" class="mtficon ext-icon-email" title="Waitting"></a>';
				} else if (value == 1) {
					return '<a href="javascript:void(0);" class="mtficon ext-icon-email_go" title="Sent"></a>';
				} else if (value == 2) {
					return '<a href="javascript:void(0);" class="mtficon ext-icon-email_error" title="Failed"></a>';
				}
			},
			styler : function(value, row, index) {
				if (value == 1) {
					return {'class' : 'mtfgoodbg'};
				} else if (value == 2) {
					return {'class' : 'mtfbadbg'};
				}
			}
		}, {
			title : 'Msg',
			field : 'msg',
			width : 250
		}, {
			title : 'Created',
			field : 'createDateTime',
			width : 150,
			sortable : true
		}, {
			title : 'Updated',
			field : 'updateDateTime',
			width : 150,
			sortable : true
		} ] ],
		onDblClickRow : function(index, row) {
			showMail(row);
		},
		toolbar : [{
			iconCls : 'ext-icon-email_open',
			text : '<s:message code="View" />',
			handler : function() {
				var row = $('#dtg_mail').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				showMail(row);
			}
		}, '-', {
			iconCls : 'ext-icon-email_go',
			text : 'Send',
			handler : function() {
				var row = $('#dtg_mail').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				
				$.messager.confirm('<s:message code="common.confirm" />', '确认发送?', function(r) {
					if (r) {
						$.messager.progress();// show progress dialog
						$.post('${pageContext.request.contextPath}/admin/mail/doSend.do', { 'id' : row.id }, function(result) {
							$.messager.progress('close');// hide progress dialog
							try {
								var j = result;
								if (j.success) {
									$.messager.alert('<s:message code="common.tip" />', 'OK', 'info', function(rr) {
										$('#dtg_mail').datagrid('reload');
									});
									
								} else {
									var msg = j.msg;
									if (!msg && j.obj) {
										msg = formatErrorMessage(j.obj);
									}
									$.messager.alert('<s:message code="common.error" />', msg, 'error', function(rr) {
										$('#dtg_mail').datagrid('reload');
									});
								}
							} catch (e) {
								$.messager.alert('<s:message code="common.error" />', result, 'error');
							}
						}, 'json');
					}
				});
			}
		}],
		onLoadSuccess : function(data) {
			//$(this).datagrid('clearSelections');
			$(this).datagrid('tooltip', ['tos', 'ccs', 'bccs', 'subject', 'msg']);
		}
	});

	$('#frm_search :text').keydown(function(e) {
		handleEnterKey(e, submitSearchForm);
	});
});

function submitSearchForm() {
	var $dtgMail = $('#dtg_mail');
	var opt = $dtgMail.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/admin/mail/doSearch.do';
	}
	$dtgMail.datagrid('load', serializeObject($('#frm_search')));
}
function resetSearchForm() {
	$('#frm_search').form('reset');
}

function showMail(row) {
	if (row.tos) {
		$('#tr_to').show();
		$('#td_to').html(row.tos.replace(/manchutimesfashion.com/gi, '...'));
	} else {
		$('#tr_to').hide();
		$('#td_to').html('&nbsp;');
	}
	if (row.ccs) {
		$('#tr_cc').show();
		$('#td_cc').html(row.ccs.replace(/manchutimesfashion.com/gi, '...'));
	} else {
		$('#tr_cc').hide();
		$('#td_cc').html('&nbsp;');
	}
	if (row.bccs) {
		$('#tr_bcc').show();
		$('#td_bcc').html(row.bccs.replace(/manchutimesfashion.com/gi, '...'));
	} else {
		$('#tr_bcc').hide();
		$('#td_bcc').html('&nbsp;');
	}
	$('#td_subject').html(row.subject);
	if (row.extFile) {
		$('#tr_ext').show();
		var html = '';
		for (var i = 0 ; i < row.extFileArr.length; i ++) {
			var f = row.extFileArr[i];
			var lastI = f.lastIndexOf('\\');
			if (lastI == -1) lastI = f.lastIndexOf('/');
			var n = f.substring(lastI + 1, f.length);
			var e = f.substring(f.lastIndexOf('.') + 1, f.length);
			html += '<a href="javascript:void(0);" class="mtficon ext-icon-file_' + e + '"></a><span style="color:blue;cursor:pointer" onclick="javascript:downloadFile(\'' + row.id + '\', ' + i + ');">' + n + '</span>&nbsp;&nbsp;';
		}
		$('#td_ext').html(html);
	} else {
		$('#tr_ext').hide();
		$('#td_ext').html('&nbsp;');
	}
	
	$('#div_content').html('Loading...');
	$('#dlg_mail').dialog('setTitle', row.subject).dialog('open').dialog('center');
	getMail(row.id);
}

function getMail(id) {
	$.messager.progress();// show progress dialog
	$.post('${pageContext.request.contextPath}/admin/mail/doGet.do', { 'id' : id }, function(result) {
		$.messager.progress('close');// hide progress dialog
		try {
			var r = result;
			if (r.success) {
				$('#div_content').html(r.obj.content);
			} else {
				$.messager.alert('<s:message code="common.error" />', 'Get mail failed!', 'error');
			}
		} catch (e) {
			$.messager.alert('<s:message code="common.error" />', result, 'error');
		}
	}, 'json');
}

function downloadFile(id, i) {
	var rows = $('#dtg_mail').datagrid('getRows');
	for (var j = 0; j < rows.length; j ++) {
		if (rows[j].id == id) {
			$('#hid_filename').val(rows[j].extFileArr[i]);
			$('#frm_download').submit();
			break;
		}
	}
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.search" />',border:true" style="height: 60px;overflow: hidden;" align="center">
		<form id="frm_search">
			<table class="mtftable">
				<tr>
					<th>Type</th>
					<td>:</td>
					<td><select name="type" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',editable:false">
							<option value=""></option>
							<option value="1">Purchase</option>
							<option value="2">Reimbursement</option>
							<option value="3">ReimbursementReport</option>
					<th>Status</th>
					<td>:</td>
					<td><select name="status" class="easyui-combobox" style="width:100px" data-options="panelHeight:'auto',editable:false">
							<option value=""></option>
							<option value="0">Waiting</option>
							<option value="1">Sent</option>
							<option value="2">Failed</option></select></td>
					<td>
						<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchForm();"><s:message code="common.search" /></a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:resetSearchForm();"><s:message code="common.reset" /></a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div data-options="region:'center',border:false,title:'Mail Log'">
		<table id="dtg_mail"></table>
	</div>
	<div id="dlg_mail" class="easyui-dialog" style="width:800px;height:600px;" data-options="resizable:true,modal:true,closed: true,iconCls:'ext-icon-email_open'">
		<table class="mtftable">
			<tr id="tr_to">
				<th>TO</th>
				<td>:</td>
				<td id="td_to"></td>
			</tr>
			<tr id="tr_cc">
				<th>CC</th>
				<td>:</td>
				<td id="td_cc"></td>
			</tr>
			<tr id="tr_bcc">
				<th>BCC</th>
				<td>:</td>
				<td id="td_bcc"></td>
			</tr>
			<tr>
				<th>Subject</th>
				<td>:</td>
				<td id="td_subject"></td>
			</tr>
			<tr id="tr_ext">
				<th>File</th>
				<td>:</td>
				<td id="td_ext"></td>
			</tr>
		</table>
		<hr/>
		<div id="div_content"></div>
	</div>
	
	<div style="display: none;">
		<form id="frm_download" action="${pageContext.request.contextPath}/admin/mail/toDownload.do" target="_blank" method="post">
			<input type="hidden" id="hid_filename" name="filename" />
		</form>
	</div>
</html>