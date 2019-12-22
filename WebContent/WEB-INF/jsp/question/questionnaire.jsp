<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML >
<HEAD>
<META content="IE=11.0000" http-equiv="X-UA-Compatible">

<META http-equiv="expires" content="0">
<META http-equiv="Pragma" content="no-cache">
<META http-equiv="Content-Type" content="text/html; charset=utf-8">
<!-- 
		<link rel="canonical" href="http://www.51diaocha.com/w/1066681.htm"/>
		 -->
<TITLE>调查问卷</TITLE>
  <jsp:include page="../inc.jsp"></jsp:include>

<LINK href="${pageContext.request.contextPath}/quesCss/yulan.css" rel="stylesheet" type="text/css">
<LINK href="${pageContext.request.contextPath}/quesCss/style.css" rel="stylesheet" type="text/css">

<script type="text/javascript" charset="utf-8">
    $(function() {	
    $('#result_div').hide();
	$('#userForm').form({
		url : '${pageContext.request.contextPath}/office/userQuset/doEdit.do',
		success : function(result) {
		$.messager.progress('close');
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$('#result_div').show();
					$('#question_div').hide();
				
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
</HEAD>




<BODY class="yl_body yl_customStyle">

	<STYLE type="text/css">
.yl_questions .yl_question .yl_header {
	width: 100%;
}
</STYLE>


	<DIV class="main" id="questionaryAnswerDiv"
		style="margin-top: 15px; margin-bottom: 20px;">
		<DIV class="yl_nav"></DIV>
		<DIV class="yl_main">
			<DIV class="topic" align="center">
				<H2>${questionnaire.title }</H2>
				<!--  标题-->
			</DIV>
			<DIV class="notice">${questionnaire.title }</DIV>
			<FORM id="userForm" method="post">
			<input type="hidden" name="quesId" value="${questionnaire.id}"/>
			<!-- 遍历问题 -->
			
				<DIV class="yl_questions" id="questionsDiv">
				<div class="endnotice" id="result_div">
					<H2 class="topic">您的答卷已提交</H2><br/>
					<label class="topic">如果想返回主页面请点击这里<a href="${pageContext.request.contextPath}/" class="topicA">主页面</a></label>
				</div>
				<div id="question_div">
						<c:if test="${ questionList != null}">
								<c:forEach items="${ questionList}" var="question"
									varStatus="status">
									<div id="singleChoice${status.index }" class="GHRJ_questionnaire_Lest GHRJ_rightBG span-20 last Lightress GHRJ_marginTop1 pageHead">
										
										<table border="0" id="questionTable_${status.index }">
										<input type="hidden" name="userQuestionList[${status.index}].questionId" value="${question.id}"/>
											<input id="quest${status.index}" type="hidden"
												value="chk${status.index }_">
												<tr>
													<td><DIV class="yl_sort">${question.number}.</DIV></td>
													<td align="left" colspan="2"><strong><SPAN style="font-size: 90%;" >${question.content}</SPAN></strong></td>
												</tr> <c:forEach items="${question.listSelecter}" var="selecter"
													varStatus="sc">
													<tr id="chk${status.index }_${sc.index}">
														<td><input name="userQuestionList[${status.index}].userSelecter.selecterId" type="radio" value="${selecter.id}"/></td>
														<td><label style="font-size: 85%">${selecter.charNum}.${selecter.content}</label></td>
													</tr>
												</c:forEach>
											
												<br/>
												<br/>
											
										</table>
									<c:if test="${question.remark == 'y'}">
										<strong>备注：</strong>
										<br />
										<textarea cols="120" rows="2" name="userQuestionList[${status.index}].remark"></textarea>
									</c:if>
								</div>
								</c:forEach>
							</c:if>
							<c:if test="${questionnaire.editState != 'p' }">
								<div align="center">
											<input type="button" value="提交(submit)"
											onclick="javascript:$('#userForm').submit();" />
									</div>
							</c:if>
							</div>
								</DIV>
								</FORM>
								
								</DIV>
								</DIV>
												
										

</BODY>
</HTML>
