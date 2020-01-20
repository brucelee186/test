<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
response.sendRedirect(basePath + "jsp/redirect&forward/redirectOrForward.jsp");
%>
<%out.println("requestForRedirect.jsp<br/>");
String str=request.getParameter("redirectOrForward");
out.println(str+"<br/>");
String str1=request.getParameter("formPara");
out.println(str1+"<br/>");
%>