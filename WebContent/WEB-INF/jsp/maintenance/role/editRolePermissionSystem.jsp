<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统权限</title>
<jsp:include page="../../inc.jsp"></jsp:include>



<%-- <base href="${pageContext.request.contextPath}/surveybee/" /> --%>
<!-- 样式 -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/screen.css"
	media="screen, projection">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/print.css"
	media="print">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/ie.css"
	media="screen, projection">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/common.css" />
<!-- 赋一个全局web路径 -->
<%-- <script type="text/javascript">
	var webPath = '${pageContext.request.contextPath}/surveybee/';
</script> --%>
<!-- Framework CSS -->
<!--[if IE]><link rel="stylesheet" href="${pageContext.request.contextPath}/surveybee/css/ie.css" type="text/css" media="screen, projection"><![endif]-->
<!-- Framework CSS -->
<!-- Import fancy-type plugin for the sample page. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/screen.css"
	type="text/css" media="screen, projection" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/quesCss/print.css"
	type="text/css" media="print" />
	
<script type="text/javascript" charset="utf-8">
	$(function(){
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/rolePermission/doEdit.do?editState=u',
			success : function(result) {
				$.messager.progress('close');	// hide progress bar while submit successfully
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							top.layout_center_closeTab();
						});
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		
	});

	function submitForm() {
		$('#form').submit();
	}
	
	// 一级菜单选择
	function checkAll1(codeGrandpa) {
		// 取得当前菜单状态
		var statusGrandpa = $('#chk1_' + codeGrandpa).attr('checked');
		if (statusGrandpa == undefined) {
			statusGrandpa = false;
		}
		$('input[parent2=' + codeGrandpa + ']').attr('checked', statusGrandpa);
	}
	
	// 二级菜单选择
	function checkAll2(codeGrandpa, codeFather) {
		// 取得当前菜单状态
		var statusFather = $('#chk2_' + codeFather).attr('checked');
		if (statusFather == undefined) {
			statusFather = false;
		}
		// 根据状态选择父菜单
		if (statusFather) {
			$('#chk1_' + codeGrandpa).attr('checked', statusFather);
			$('#chk1_parent_' + codeGrandpa).attr('checked', statusFather);
		}
		// 根据状态选择子菜单
		$('input[parent3=' + codeFather + ']').attr('checked', statusFather);
	
	}
	
	// 三级菜单选择
	function checkAll3(codeGrandpa, codeFather, codeGrandson) {
		// 取得当前菜单状态
		var statusGrandson = $('#chk3_' + codeFather + "_" + codeGrandson).attr('checked');
		if (statusGrandson == undefined) {
			statusGrandson = false;
		}
		// 根据状态选择父菜单
		if (statusGrandson) {
			$('#chk1_' + codeGrandpa).attr('checked', statusGrandson);
			$('#chk1_parent_' + codeGrandpa).attr('checked', statusGrandson);
		}
		if (statusGrandson) {
			$('#chk2_' + codeFather).attr('checked', statusGrandson);
			$('#chk2_parent_' + codeFather).attr('checked', statusGrandson);
		}
		// 根据状态选择子菜单
		$('#chk3_' + codeGrandson).attr('checked', statusGrandson);
		$('#chk3_parent_' + codeGrandson).attr('checked', statusGrandson);
	
	}


/* var listApprover = '${jsonApprover}';
var jsonApprover = jQuery.parseJSON(listApprover)[0];
function formatterListApprover(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonApprover, 'id', 'displayName');
}

function formatterDate(value, rowData, rowIndex, jsonArray,typeId,typeName) {
if (value == 0) {
	return;
}
for ( var i = 0; i < jsonArray.length; i++) {
	if (eval('jsonArray[i].' + typeId) == value) {
		return eval('jsonArray[i].' + typeName);
	}
}
}
 */
</script>
</head>
<body id="GHRJ_bodyBg1">
		<form id="form" method="post">
			<input type="hidden" name="roleId" value="${rolePermission.roleId }">
			<input id="typeSys" type="hidden" name="typeSys" value="${rolePermission.typeSys}">
			<input id="type" type="hidden" name="type" value="${rolePermission.type}">
			<input id="typeId" type="hidden" name="typeId" value="${rolePermission.typeId}">
			<div class="container_1 ">
				<h6 class="GHRJ_listBG1 GHRJ_padding2 ">
					角色权限(${rolePermission.roleName })
				</h6>
			<p id="errorMsg" class="width300 error"></p>
				<div class="GHRJ_margin5 width1500 left">
				<table class="GHRJ_permission_parent_table">
					<tbody>
						<c:if test="${ permission != null}">
							<c:forEach items="${ permission.listPermission}" var="permissionLeve1" varStatus="status">
								<c:if test="${permissionLeve1.name != null}">
								<tr class="tr">
									<td><table class="child_table">
											<tbody>
												<tr class="col_header">
													<td colspan="2">
														<input type="checkbox" style="border: 0px; background: none;"
															id="chk1_${permissionLeve1.code}" 
															name="mapRolePermission1[${permissionLeve1.parentCode}_${permissionLeve1.code}].code1" 
															value="${permissionLeve1.parentCode}_${permissionLeve1.code}"
															<c:if test="${permissionLeve1.tagPermission == 'y'}">checked="checked"</c:if> 
															onclick="checkAll1(${permissionLeve1.code})">
																<span class="zogo-form-checkbox">${permissionLeve1.name}</span>
														</input>
														<input style="display: none;"
															type="checkbox"
															id="chk1_parent_${permissionLeve1.code}" 
															name="mapRolePermission1[${permissionLeve1.code}].parentCode" 
															<c:if test="${permissionLeve1.tagPermission == 'y'}">checked="checked"</c:if> value="${permissionLeve1.parentCode}"
															parent2="${permissionLeve1.code}" >
														</input>
													</td>
												</tr>
												<c:forEach items="${permissionLeve1.listPermissionLevel2}" var="permissionLeve2">
													<tr class="tr" style="width: 1800px;">
														<td class="row_header" valign="top">
														<input type="checkbox" style="border: 0px; background: none;"
															id="chk2_${permissionLeve2.code}" 
															name="mapRolePermission2[${permissionLeve2.parentCode}_${permissionLeve2.code}].code2" 
															value="${permissionLeve2.parentCode}_${permissionLeve2.code}"
															<c:if test="${permissionLeve2.tagPermission == 'y'}">checked="checked"</c:if> 
															parent2="${permissionLeve1.code}" 
															onclick="checkAll2(${permissionLeve1.code}, ${permissionLeve2.code})">
																<span class="zogo-form-checkbox">${permissionLeve2.name}</span>
														</input>
														<input style="display: none;"
															type="checkbox"
															id="chk2_parent_${permissionLeve2.code}" 
															name="mapRolePermission1[${permissionLeve2.code}].parentCode" 
															value="${permissionLeve2.parentCode}"
															<c:if test="${permissionLeve2.tagPermission == 'y'}">checked="checked"</c:if> 
															parent2="${permissionLeve1.code}"
															parent3="${permissionLeve2.code}"
															onclick="checkAll2(${permissionLeve1.code}, ${permissionLeve2.code})">
														</input>
														</td>
														<td style="width: 500px;">
														<c:forEach items="${permissionLeve2.listPermissionLevel3}" var="permissionLeve3">
															<c:if test="${permissionLeve3.code != null}">
															<!-- 在此修改宽度 -->
															<label style="width: 1400px;">
																<label style="width: 500px;">
																<input type="checkbox"
																	id="chk3_${permissionLeve2.code}_${permissionLeve3.code}" 
																	name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].code3" 
																	value="${permissionLeve3.parentCode}_${permissionLeve3.code}"
																	<c:if test="${permissionLeve3.tagPermission == 'y'}">checked="checked"</c:if> 
																	parent2="${permissionLeve1.code}" 
																	parent3="${permissionLeve2.code}"
																	onclick="checkAll3(${permissionLeve1.code}, ${permissionLeve2.code}, ${permissionLeve3.code})">
																</input>
																${permissionLeve3.name}
																</label>
																<c:if test="${rolePermission.type != 's'}">
																<label style="width: 100px;">
																	<input type="checkbox" 
																		parent2="${permissionLeve1.code}" 
																		parent3="${permissionLeve2.code}"
																		name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].haveExtends" 
																		<c:if test="${permissionLeve3.haveExtends == 'n'}">checked="checked"</c:if> 
																		>
																	</input>
																	非继承
																</label>
																</c:if>
																<c:if test="${rolePermission.type == 'u' && permissionLeve3.parentCode == '2002000'}">
																<label style="width: 120px;font-size: small;">
																		&nbsp;&nbsp;限定金额:
																	</label>
																		<label style="width: 120px;font-size: small;">
																		<select class="easyui-combobox" style="width: 120px;" value="${permissionLeve3.approver1AmonutLower}"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver1AmonutLower">
																			 <%-- <c:if test="${permissionLeve3.approver1LimitRuleId == null}">
																				<c:forEach items="${listOrderCategoryRule}" var="orderCategoryRule">
																					<option value="${orderCategoryRule.id}" >${orderCategoryRule.name}</option>
																				</c:forEach>
																			</c:if>
																			<c:if test="${permissionLeve3.approver1LimitRuleId != null}">
																				<c:forEach items="${listOrderCategoryRule}" var="orderCategoryRule">
																					<option value="${orderCategoryRule.id}"<c:if test="${permissionLeve3.approver1LimitRuleId == orderCategoryRule.id}">selected="selected"</c:if> >${orderCategoryRule.name}</option>
																				</c:forEach>
																			</c:if> --%>
																			<c:forEach items="${listApproveAmount}" var="approveAmount">
																				<option value="${approveAmount.codeDetail}"<c:if test="${approveAmount.codeDetail == permissionLeve3.approver1AmonutLower}">selected="selected"</c:if> >${approveAmount.name}</option>
																			</c:forEach>
																		</select>
																	</label>
																</c:if>
																<c:if test="${rolePermission.type == 'u'}">
																	<label style="width: 100px;font-size: small;">
																		<%-- <input type="text"
																			value="√"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].code3" 
																			>
																		</input> --%>
																		&nbsp;&nbsp;
																			<c:if test="${permissionLeve3.fromSuper == 'y'}">部门: 是</c:if>
																			<c:if test="${permissionLeve3.fromSuper != 'y'}">部门: 否</c:if>
																	</label>
																</c:if> 
																<c:if test="${rolePermission.type == 'd' || rolePermission.type == 'u' || rolePermission.type == 's'}">
																	<label style="width: 100px;font-size: small;">
																		<%-- <input type="text"
																			value="√"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].code3" 
																			>
																		</input> --%>
																		
																			<c:if test="${permissionLeve3.fromGrand == 'y' || rolePermission.type == 's'}">系统: 是</c:if>
																			<c:if test="${permissionLeve3.fromGrand != 'y' && rolePermission.type != 's'}">系统: 否</c:if>
																	</label>
																</c:if> 
																<c:if test="${rolePermission.type == 'd'|| rolePermission.type == 's'}">
																<c:if test="${permissionLeve3.parentCode == '2002000'}">
																	<label style="width: 65px;font-size: small;">
																		审批类型:
																	</label>
																		<label style="width: 70px;font-size: small;">
																		<select class="easyui-combobox" style="width: 70px;" value="${permissionLeve3.approveType}"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approveType">
																				<c:forEach items="${listApproveType}" var="approveType">
																					<option value="${approveType.codeDetail}"<c:if test="${permissionLeve3.approveType == approveType.codeDetail}">selected="selected"</c:if> >${approveType.name}</option>
																				</c:forEach>
																		</select>
																	</label>
																	<label style="width: 80px;font-size: small;">
																		&nbsp;&nbsp;一级审批人:
																	</label>
																		<label style="width: 70px;font-size: small;">
																		<%-- <select name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver1" class="easyui-combobox" style="width:70px;" data-options="required: false, value:'${permissionLeve3.approver1}', valueField:'id', textField:'displayName', panelHeight:'200', editable:true, "></select> --%>
																		<select class="easyui-combobox" style="width: 70px;" value="${permissionLeve3.approver1}"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver1">
																			 <c:if test="${permissionLeve3.approver1 == null}">
																				<c:forEach items="${listApprover1}" var="approver">
																					<option value="${approver.id}" >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																			<c:if test="${permissionLeve3.approver1 != null}">
																				<c:forEach items="${listApprover1}" var="approver">
																					<option value="${approver.id}"<c:if test="${permissionLeve3.approver1 == approver.id}">selected="selected"</c:if> >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																		</select>
																	</label>
																	<label style="width: 80px;font-size: small;">
																		&nbsp;&nbsp;二级审批人:
																	</label>
																		<label style="width: 70px;font-size: small;">
																		<%-- <select name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver2" class="easyui-combobox" style="width:70px;" data-options="required: false, value:'${permissionLeve3.approver2}', valueField:'id', textField:'displayName', panelHeight:'200', editable:true, "></select> --%>
																		<select class="easyui-combobox" style="width: 70px;" value="${permissionLeve3.approver2}"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver2">
																			 <c:if test="${permissionLeve3.approver2 == null}">
																				<c:forEach items="${listApprover2}" var="approver">
																					<option value="${approver.id}" >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																			<c:if test="${permissionLeve3.approver2 != null}">
																				<c:forEach items="${listApprover2}" var="approver">
																					<option value="${approver.id}"<c:if test="${permissionLeve3.approver2 == approver.id}">selected="selected"</c:if> >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																		</select>
																	</label>
																<label style="width: 80px;font-size: small;">
																		&nbsp;&nbsp;三级审批人:
																	</label>
																		<label style="width: 70px;font-size: small;">
																		<select class="easyui-combobox" style="width: 70px;" value="${permissionLeve3.approver3}"
																			name="mapRolePermission3[${permissionLeve3.parentCode}_${permissionLeve3.code}].approver3">
																			 <c:if test="${permissionLeve3.approver3 == null}">
																				<c:forEach items="${listApprover3}" var="approver">
																					<option value="${approver.id}" >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																			<c:if test="${permissionLeve3.approver3 != null}">
																				<c:forEach items="${listApprover3}" var="approver">
																					<option value="${approver.id}"<c:if test="${permissionLeve3.approver3 == approver.id}">selected="selected"</c:if> >${approver.displayName}</option>
																				</c:forEach>
																			</c:if>
																		</select>
																	</label>
																	</c:if> 
																</c:if> 
																</label>
															</c:if>
														</c:forEach>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table></td>
								</tr>
								</c:if>
							</c:forEach>
						</c:if>
					</tbody>			
				</table>
			</div>
			</div>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm();"><s:message code="common.button.save" /></a>
			</div>
		</form>
	
</body>
</html>