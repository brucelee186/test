<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %> 
<html>
<head>
<title></title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
 $(function(){
	 if ('e10adc3949ba59abbe56e057f20f883e' == '${sessionInfo.pass}') {
		 $('#pass').show();
	 } else {
		 $('#pass').hide();
	 }
	$("#contractType a").each(function(){
		$(this).click(function(){
			$(this).hide();
			var url=$(this).attr("name");
			var title=$(this).attr("title");
			var id=$(this).attr("id");
			//addTab();
			top.layout_center_addTab({
				id:id,
				title : title,
				url :url,
				closable : true,
				iconCls : 'icon-search',
				content : '<iframe src='+ url +' frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>'
			});
			//trigger tree
			//top.layout_center_dashboardExpendTree(title);
		});
	}); 
	
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var currntTime = year + "-" + month+"-" + day+" " + hour + ":" + minute + ":" + second;
	$('#currntTime').text("<s:message code="officeTree.dashboard.curTime" />：" + currntTime);
});

setInterval(function(){
	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth() + 1;
	var day = date.getDate();
	var hour = date.getHours();
	var minute = date.getMinutes();
	var second = date.getSeconds();
	var currntTime = year + "-" + month+"-" + day+" " + hour + ":" + minute + ":" + second;
	$('#currntTime').text("<s:message code="officeTree.dashboard.curTime" />：" + currntTime);
}, 1000);

function editPass(){
	window.location.href = "${pageContext.request.contextPath}/maintenance/user/toEdit.do?id=${sessionInfo.userId}";
}
</script>
</head>
<body>
<TABLE cellSpacing=0 cellPadding=0 width="100%" align=center border=0>
  <TR height=28>
    <TD><s:message code="officeTree.dashboard.curLocation" />: </TD></TR>
  <TR>
    <TD bgColor=#b1ceef height=1></TD></TR>
  <TR height=20>
    <TD></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="90%" align=center border=0>
  <TR height=100>
    <TD align=middle width=100><IMG height=100 src="${pageContext.request.contextPath}/images/admin_p.gif" 
      width=90></TD>
    <TD width=60>&nbsp;</TD>
    <TD>
      <TABLE height=100 cellSpacing=0 cellPadding=0 width="100%" border=0>
        <TR>
          <TD id="currntTime"></TD>
        </TR>
        <TR>
          <TD style="FONT-WEIGHT: bold; FONT-SIZE: 16px">${sessionInfo.displayName}</TD></TR>
        <TR>
          <TD>你好 尹先生!</TD>
            <TR>
          <TD style="COLOR: #880000" ><s:message code="officeTree.dashboard.tip" /><a href="${pageContext.request.contextPath}/upload/attachment/ChromeStandaloneSetup.exe"><s:message code="officeTree.main.download" /></a> </TD></TR> </TABLE></TD></TR>
  <TR>
    <TD colSpan=3 height=10></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=0 width="95%" align=center border=0>
  <TR height=20>
    <TD></TD></TR>
  <TR height=22>
    <TD style="PADDING-LEFT: 20px; FONT-WEIGHT: bold; COLOR: #ffffff" 
    align=middle ><s:message code="officeTree.dashboard.RelatedInfo" /></TD></TR>
  <TR bgColor=#ecf4fc height=12>
    <TD></TD></TR>
  <TR height=20>
    <TD></TD></TR></TABLE>
<TABLE cellSpacing=0 cellPadding=2 width="95%" align=center border=0 id="contractType">
	<TR>
	  <TD align=right width=110><s:message code="officeTree.dashboard.login" />：</TD>
	  <TD style="COLOR: #880000">${sessionInfo.loginName}</TD></TR>
	<TR>
	  <TD align=right><s:message code="officeTree.dashboard.realName" />：</TD>
	  <TD style="COLOR: #880000">${sessionInfo.displayName}</TD></TR>
	<TR>
		<TD align=right><s:message code="officeTree.dashboard.regTime" />： </TD>
		<TD style="COLOR: #880000">${sessionInfo.datetime}</TD>
	</TR>
	
	<TR><TD align=right>当前任务：</TD><TD style="COLOR: #880000">
	<c:if test="${comUtil.checkCode('1701001')}">
		
	</c:if>
	</TD></TR>
</TABLE>
	<div id="pass" align="centent">
		<table >
		<tr>
			<td width="60" height="60"></td>
			<td style="COLOR: #880000"><s:message code="officeTree.dashboard.firstLogin" /></td>
			<td><input type="button" onclick="editPass()" value="<s:message code='officeTree.dashboard.modifyPwd' />" /></td>
		</tr>
		</table>
	</div>
</body>
</html>
