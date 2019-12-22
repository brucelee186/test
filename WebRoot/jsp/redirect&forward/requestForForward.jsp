<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
request.getRequestDispatcher("redirectOrForward.jsp").forward(request, response);
%>


<%out.println("requestForForward.jsp<br/>");
String str=request.getParameter("redirectOrForward");
out.println(str+"<br/>");
String str1=request.getParameter("formPara");
out.println(str1+"<br/>");
%>