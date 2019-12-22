<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>创建问卷</title>
<jsp:include page="../inc.jsp"></jsp:include>


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
$(function() {	
	$('#mainForm').form({
		url : '${pageContext.request.contextPath}/office/quest/doEdit.do',
		success : function(result) {
		$.messager.progress('close');
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					var url = "${pageContext.request.contextPath}/office/quest/toSearch.do";
					window.location.href = url;
				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});
});	



</script>
</head>

<body>
	<div class="container">
		<!-- 导入页面头文件 -->

		<div class="GHRJ_TopTitle">
			<div class=" GHRJ_main">
				<div class="span-16 last GHRJ_inline">
					<h1 class="GHRJ_marginTop3">
						&nbsp;<a id="header_survey_title"
							class="color_black"><c:if test="${questionnaire.editState == 'i'}">新建问卷</c:if><c:if test="${questionnaire.editState == 'u'}">编辑问卷</c:if></a>
					</h1>
				</div>
			</div>

			<div class=" GHRJ_main" id="leftMenuHead">
				<div id="tableLink" class="span-11 GHRJ_Tab1 last">
					<a id="basicInformationPageLink" class="basicInformationPage pitch"
						href="javascript:" onclick="showBasic()">基本信息</a> <a id="addQuestionPageLink"
						class="addQuestionPage" href="javascript:" onclick="hideBasic()">添加问题</a> 
				</div>
			</div>
		</div>
		<form id="mainForm" class="clear" method="post">
		<input type="hidden" name="editState" value="${questionnaire.editState }"/>
		<input type="hidden" name="id" value="${questionnaire.id}"/>
			<!--主体内容-开始-->
			<div class="GHRJ_main GHRJ_bx23">

				<div id="basicInformation">
					<div class="GHRJ_bx3 equal span-11 last" id="left">
						<div class="GHRJ_questionnaire_form" id="basicInfoDiv">
							<div class="GHRJ_leftBG GHRJ_margin">
								<div class="GHRJ_position valideInputDiv">
								<p>
									<select name="type">
										<option value="e" <c:if test="${questionnaire.type == 'e'}">selected="selected"</c:if>>其他问卷</option>
										<option value="d" <c:if test="${questionnaire.type == 'd'}">selected="selected"</c:if>>默认问卷</option>
									</select>
									</p>
									<p>
										<label> 问卷名称： </label> <br /> <input name="title"
											type="text" class="GHRJ_input_1" value="${questionnaire.title }"/><br/>
											<input type="text" class="GHRJ_input_1" />
									</p>
									<p class="bottom">
										<label> 问卷说明： </label> <br />
										<textarea name="description" cols="" rows=""
											class="GHRJ_input_1">${questionnaire.description}</textarea>
										<br />
										<textarea  cols="" rows=""
											class="GHRJ_input_1"></textarea>
									</p>
								
									
								</div>
							</div>
						</div>
					</div>
				</div>
				<div id="addQuestion" class="hide">


					<!--左边内容-开始-->
					<div class="GHRJ_bx3 equal span-11" id="left">
						<div id="placeholder">&nbsp;</div>
						<div id="questionTypeListDiv"
							class="span-11 last GHRJ_questionnaire_form"
							style="position:absolute;">
							<div id="sysquestiontypediv">
								<div id="commonQuestionsListDiv"
									class="span-11 last GHRJ_marginBottom hide">
									<div class="span-11 last">
										<div class="GHRJ_listBG"></div>
										<div class="GHRJ_listBG_2 last sortDiv">
											<div class="span-10 right noSort">
												<a id="cancelCommonQuestionsListLink" href="#"
													class="GHRJ_arrows_3 right"></a>
											</div>
										</div>
									</div>
								</div>
								<div id="sysquestiontypediv"
									class="span-11 last GHRJ_paddingLeft1 GHRJ_paddingBottom1 sortDiv">

									<div id="dq-999" class="GHRJ_leftBG_1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_18"></label>分页</a>


									</div>

									<div id="dq17" class="GHRJ_leftBG_2 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_17"></label>信息栏</a>


									</div>

									<div id="dq1" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="javascript:addQuestion()"><label class="ghrj_icon16_16"></label>列表单选</a>


									</div>

									<div id="dq2" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_8"></label>投票单选</a>


									</div>

									<div id="dq3" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_4"></label>打分单选</a>


									</div>


									<div id="dq4" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_6"></label>测试单选</a>


									</div>


									<div id="dq5" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_14"></label>列表多选</a>


									</div>



									<div id="dq6" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_7"></label>投票多选</a>


									</div>



									<div id="dq18" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_3"></label>打分多选</a>


									</div>

									<div id="dq8" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_1"></label>测试多选</a>


									</div>

									<div id="dq7" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_8"></label>排序题</a>


									</div>

									<div id="dq9" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_5"></label>打分/评级</a>


									</div>


									<div id="dq10" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_11"></label>个人信息</a>


									</div>

									<div id="dq11" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_13"></label>单行文本</a>


									</div>

									<div id="dq12" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_12"></label>多行文本</a>


									</div>


									<div id="dq13" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_10"></label>矩阵单选</a>


									</div>

									<div id="dq14" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_19"></label>矩阵多选</a>


									</div>

									<div id="dq15" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_9"></label>矩阵下拉</a>


									</div>

									<div id="dq16" class="GHRJ_leftBG1 questionTypeDiv">

										<a href="#"><label class="ghrj_icon16_2"></label>图片上传</a>


									</div>




								</div>


							</div>
						</div>
					</div>
					<!--左边内容-结束-->
				</div>
				<div id="editQuestion" class="hide">


					<div class="GHRJ_bx3 equal span-11" id="left"
						style="position: relative;">
						<div class="span-11 last GHRJ_questionnaire_form" id="editTable"
							style="position: absolute; top : 0px;"></div>
					</div>
				</div>

				<div id="contentDiv">



					<!--右边内容-开始-->

					<input type="hidden" name="surveyDbTime" value="1393925511975" />
					<input type="hidden" name="surveySettingDbTime"
						value="1393925511975" />
					<div class="equal width640" id="right">

						<p class="GHRJ_postiton GHRJ_marginTop1">
						 <label class="prepend-1"><a target="_blank"
								href="${pageContext.request.contextPath}/office/quest/preview.do?editState=p&Id=${questionnaire.id}">预览</a>
							</label>
						</p>

						<div class="span-3 right"></div>

						<div
							class="GHRJ_questionnaire_Lest span-20 last Lightress GHRJ_marginTop1">
							<p class="span-20"></p>
						</div>

						<div id="questionListDivId">
							<!--静态问题页  -->

							<!--编辑时遍历  -->
							<c:if test="${ questionList != null}">
								<c:forEach items="${ questionList}" var="question"
									varStatus="status">
									<div id="singleChoice${status.index}"
										class="GHRJ_questionnaire_Lest GHRJ_rightBG span-20 last Lightress GHRJ_marginTop1 pageHead">

										<table border="0" id="questionTable_${status.index }">
											<input id="quest${status.index}" type="hidden"
												value="chk${status.index }_">
												<tr>
												<td colspan="2"></td>
													<td align="right"><a href="javascript:void(0);" onclick="javascript:delDiv(${status.index})">删除</a></td>
												</tr>
												<tr>
													<td><label id="ql${status.index }">
															${question.number}</label></td>
													<td align="left" colspan="2"><textarea
															name="listQuestion[${status.index}].content" cols="88"
															rows="2">${question.content}</textarea></td>
												</tr> <c:forEach items="${question.listSelecter}" var="selecter"
													varStatus="sc">
													<tr id="chk${status.index }_${sc.index}">
														<td><input id="scsh${status.index  }_${sc.index}"
															name="listQuestion[${status.index }].listSelecter[${sc.index}].answer"
															type="hidden" class="scsh${status.index }"
															value="${selecter.answer}" /> <input
															name="listQuestion[${status.index }].radioValue"
															type="radio"
															onclick="radioValue(${status.index },${sc.index});"
															<c:if test="${selecter.answer == 'y'}">checked="checked"</c:if> /></td>
														<td><input type="text" class="GHRJ_input_3"
															name="listQuestion[${status.index }].listSelecter[${sc.index}].content"
															value="${selecter.content}" /></td>
														<td><input type="button" value="删除"
															onclick="delRow(${status.index },${sc.index})" /></td>
													</tr>
												</c:forEach>
										</table>
										<div>
											<table>
												<tr>
													<td width="90%"><input
														id="addSelecter${status.index}" type="button"
														value="添加选项" onclick="addSelecter(${status.index })">
													</td>
													<td>备注:</td>
													<td><input type="checkbox" name="listQuestion[${status.index }].remark" value="y" <c:if test="${question.remark == 'y'}">checked="checked"</c:if>></td>
												</tr>
											</table>
										</div>
									</div>
								</c:forEach>
							</c:if>



						</div>

						<div class="height100 span-20"></div>
					</div>



				</div>

				<div style='float:right;width: 660px; margin:0 auto'>
					<div id="footbutton" class="GHRJ_following">
						<li class="right"><span class="GHRJ_marginTop3 right"> <a id="saveLink"
								class="GHRJ_Btn2" href="javascript:void(0);" onclick="javascript:$('#mainForm').submit();">保&nbsp;&nbsp;存</a> <a
								id="addQuestionBottomLink" href="javascript:addQuestion()"
								class="GHRJ_Btn2 GHRJ_marginLeft7">添加问题</a> 
						</span></li>
					</div>
				</div>
			</div>
			<!--主体内容-结束-->
		</form>
	</div>






<script type="text/javascript" src="${pageContext.request.contextPath}/js/question/question.js"></script>

<!--单独添加选项  -->
	<div id="divRadio" style="display: none;">
		<td><input id="scshXXX_AAA" name="listQuestion[XXX].listSelecter[AAA].answer" type="hidden" class="scshXXX"/><input name="listQuestion[XXX].radioValue" type="radio" onclick="radioValue(XXX,AAA);"/></td>
	</div>
	<div id="divText" style="display: none;">
		<td><input type="text" class="GHRJ_input_1" name="listQuestion[XXX].listSelecter[AAA].content" style="width: 400"/></td>
	</div>
	<div id="divDel" style="display: none;">
		<input type="button" value="删除" onclick="delRow(XXX,AAA)"/>
	</div>

	
	<!--静态共同问题页  -->
	<div id="singleChoice" style="display: none;">
	<div id="singleChoiceXXX"
		class="GHRJ_questionnaire_Lest GHRJ_rightBG span-20 last Lightress GHRJ_marginTop1 pageHead" >

		<table border="0" id="questionTable_XXX">
			<input id="questXXX" type="hidden" value="chkXXX_">
				<tr>
					<td colspan="2"></td>
					<td align="right"><a href="javascript:void(0);" onclick="javascript:delDiv(XXX)">删除</a></td>
				</tr>
				<tr>
					<td><label id="qlXXX">XXX.</label></td>
					<td align="left" colspan="2"><textarea name="listQuestion[XXX].content" cols="88" rows="2"></textarea></td>
				</tr>
				<tr id="chkXXX_1">
					<td><input id="scshXXX_1" name="listQuestion[XXX].listSelecter[0].answer" type="hidden" class="scshXXX"/><input name="listQuestion[XXX].radioValue" type="radio" onclick="radioValue(XXX,1);"/></td>
					<td><input type="text" class="GHRJ_input_3" name="listQuestion[XXX].listSelecter[0].content"/></td>
					<td><input type="button" value="删除" onclick="delRow(XXX,1)" /></td>
				</tr>
				<tr id="chkXXX_2">
					<td><input id="scshXXX_2" name="listQuestion[XXX].listSelecter[1].answer" type="hidden" class="scshXXX"/><input name="listQuestion[XXX].radioValue" type="radio" onclick="radioValue(XXX,2);"/></td>
					<td><input type="text" class="GHRJ_input_3" name="listQuestion[XXX].listSelecter[1].content" /></td>
					<td><input type="button" value="删除" onclick="delRow(XXX,2)" /></td>
				</tr>
				<tr id="chkXXX_3">
					<td><input id="scshXXX_3" name="listQuestion[XXX].listSelecter[2].answer" type="hidden" class="scshXXX"/><input name="listQuestion[XXX].radioValue" type="radio" onclick="radioValue(XXX,3);"/></td>
					<td><input type="text" class="GHRJ_input_3" name="listQuestion[XXX].listSelecter[2].content"/></td>
					<td><input type="button" value="删除" onclick="delRow(XXX,3)" /></td>
				</tr>
				<tr id="chkXXX_4">
					<td><input id="scshXXX_4" name="listQuestion[XXX].listSelecter[3].answer" type="hidden" class="scshXXX"/><input name="listQuestion[XXX].radioValue" type="radio" onclick="radioValue(XXX,4);"/></td>
					<td><input type="text" class="GHRJ_input_3" name="listQuestion[XXX].listSelecter[3].content"/></td>
					<td><input type="button" value="删除" onclick="delRow(XXX,4)" /></td>
				</tr>
		</table>
		<div>
				<table>
					<tr>
						<td width="90%"><input id="addSelecterXXX"
							type="button" value="添加选项"
							onclick="addSelecter(XXX)"></td>
						<td>备注:</td>
						<td><input type="checkbox"
							name="listQuestion[XXX].remark" value="y"></td>
					</tr>
				</table>
			</div>
	</div>
	</div>
	
</body>
</html>
