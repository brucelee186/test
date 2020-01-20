<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<script type="text/javascript" src="index.js"></script>
      <SCRIPT LANGUAGE="JavaScript">
            function submit1(url)
            {
                document.form1.action=url;
                document.form1.submit();
            }     
        </SCRIPT>
    <base href="<%=basePath%>">
  </head>
  
  <body>
<a href="<%=basePath%>/ReportServer?reportlet=homeTemperature.cpt" >温度走势</a>
<br>
   <form action="LoginServlet" method="get">
   	get提交<br>
	   用户名：<input type="text" name="username" /><br>
	   密码：<input type="text" name="password" />
	   <br><input type="submit" value="登陆" />
   </form>  
   <form action="LoginServlet" method="post">
   post提交<br>
	   用户名：<input type="text" name="username" /><br>
	   密码：<input type="text" name="password" />
	   <br><input type="submit" value="登陆" />
   </form> 
   
<form name="form1" method="POST" action="">
         <INPUT type="hidden" name="formPara" value="formPara">
    </form>
<br/>
<!-- forward跳转到页面转发后,本身页面地址不会发生改变,并可form转参 -->
<a href="#" onClick="submit1('<%=basePath%>jsp/redirect&forward/requestForForward.jsp?redirectOrForward=requestForForward')">转发:requestForForward.jsp</a>
<br/>
<!-- forward跳转到页面转发后,转发的页面地址发生改变,并不可转参 -->
<a href="#" onClick="submit1('<%=basePath%>jsp/redirect&forward/requestForRedirect.jsp?redirectOrForward=requestForRedirect')">重定向:requestForRedirect.jsp</a>
<br/>
<a href="<%=basePath%>jsp/jspInnerObject/testJspInnerObject.jsp" >jsp九大内置对象.jsp</a>
<br>
<br>
	struts1
	<form name="loginForm" onsubmit="" action="testStruts1.do?selectMethod=testStruts1" method="post">
		name<input type="text" name="name"  /><br>
		password<input name="password" type="password"/><br>
		<input type="submit" value="login"/>
	</form>
	<br>
	struts2
	<form action="testStruts2Action.action">
		用户名：<input name="name"><br>
		 密 码：<input type="password" name="password"><br>
      <input type="submit" value="提 交">
      <input type="reset"  value="取 消">	
	</form>
	<br>
	ssh
	<form action="person.action">
		用户名：<input ><br>
		 密 码：<input type="password" ><br>
      <input type="submit" value="提 交">
      <input type="reset"  value="取 消">	
	</form>
  </body>
  <a href="<%=basePath%>jsp/include/main.jsp" >动太引入jsp页</a>
  <a href="<%=basePath%>jsp/errorPage/testErrorPage.jsp" >jspErrorPage</a>
  <br>
  diyStruts1 v1
  <form action="servlet/AddUserServlet" method="post">  
    姓名：<input type="text" name="userName" /><br/>  
    <input type="submit" value="submit"/> 
 </form>
  <br>
  diyStruts1 v2
  <form action="servlet/AddUserServlet.do" method="post">  
    姓名：<input type="text" name="userName" /><br/>  
    <input type="submit" value="submit"/>   
</form>
</html>
