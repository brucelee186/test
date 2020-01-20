<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>普通权限</title>
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
		}
		// 根据状态选择子菜单
		$('input[parent3=' + codeFather + ']').attr('checked', statusFather);
	
	}
	
	// 三级菜单选择
	function checkAll3(codeGrandpa, codeFather, codeGrandson) {
		// 取得当前菜单状态
		var statusGrandson = $('#chk3_' + codeGrandson).attr('checked');
		if (statusGrandson == undefined) {
			statusGrandson = false;
		}
		// 根据状态选择父菜单
		if (statusGrandson) {
			$('#chk1_' + codeGrandpa).attr('checked', statusGrandson);
		}
		if (statusGrandson) {
			$('#chk2_' + codeFather).attr('checked', statusGrandson);
		}
		// 根据状态选择子菜单
		$('#chk3_' + codeGrandson).attr('checked', statusGrandson);
	
	}

</script>
</head>
<body id="GHRJ_bodyBg1">
		<form id="form" method="post">
			<input type="hidden" name="roleId" value="${rolePermission.roleId }">
			<input id="typeSys" type="hidden" name="typeSys" value="${rolePermission.typeSys}">
			<input id="type" type="hidden" name="type" value="${rolePermission.type}">
			<input id="typeId" type="hidden" name="typeId" value="${rolePermission.typeId}">
			<div class="container_1 width620">
				<h6 class="GHRJ_listBG1 GHRJ_padding2 width600">
					角色权限(${rolePermission.roleName })
				</h6>
			<p id="errorMsg" class="width300 error"></p>
				<div class="GHRJ_margin5 width620 left">
				<table class="GHRJ_permission_parent_table">
					<tbody>
						<c:if test="${ permission != null}">
							<c:forEach items="${ permission.listPermission}" var="permissionLeve1" varStatus="status">
								<c:if test="${permissionLeve1.name != null}">
								<tr class="tr">
									<td><table class="child_table">
											<tbody>
												<tr class="col_header">
													<td colspan="2"><input type="checkbox"
														style="border: 0px; background: none;"
														name="mapRolePermission1[${permissionLeve1.code}].code1" <c:if test="${permissionLeve1.tagPermission == 'y'}">checked="checked"</c:if> id="chk1_${permissionLeve1.code}" value="${permissionLeve1.code}"
														onclick="checkAll1(${permissionLeve1.code})">
														<span class="zogo-form-checkbox"></span>${permissionLeve1.name}
													</td>
												</tr>
												<c:forEach items="${permissionLeve1.listPermissionLevel2}" var="permissionLeve2">
													<tr class="tr">
														<td class="row_header" valign="top"><input type="checkbox"
															style="border: 0px; background: none;"
															name="mapRolePermission2[${permissionLeve2.code}].code2" id="chk2_${permissionLeve2.code}" <c:if test="${permissionLeve2.tagPermission == 'y'}">checked="checked"</c:if> value="${permissionLeve2.code}"
															parent2="${permissionLeve1.code}" onclick="checkAll2(${permissionLeve1.code}, ${permissionLeve2.code})"><span
															class="zogo-form-checkbox"></span>${permissionLeve2.name}
														</td>
														<td>
														<c:forEach items="${permissionLeve2.listPermissionLevel3}" var="permissionLeve3">
															<c:if test="${permissionLeve3.code != null}">
																<li><input type="checkbox"
																		name="mapRolePermission3[${permissionLeve3.code}].code3" id="chk3_${permissionLeve3.code}" <c:if test="${permissionLeve3.tagPermission == 'y'}">checked="checked"</c:if> value="${permissionLeve3.code}"
																		parent2="${permissionLeve1.code}" parent3="${permissionLeve2.code}"
																		onclick="checkAll3(${permissionLeve1.code}, ${permissionLeve2.code}, ${permissionLeve3.code})">${permissionLeve3.name}
																		</input>
																</li>
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