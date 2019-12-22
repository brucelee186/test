<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
// 1 request
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// 2 response
String encoding = response.getCharacterEncoding();
// 3 session
String sessionId = session.getId();
// 4 application
application.setAttribute("test", "OK");
String applicationAttribute = (String)application.getAttribute("test");
// 5 out
out.print("test");
// 6 page
Object obj = this;
// 7 config
String servletName = config.getServletName();
// 8 exception
Throwable exception1 = new Throwable();
// 9 pageContext
pageContext.setAttribute("1","text");
pageContext.setAttribute("page","pageText");
pageContext.setAttribute("request", "requestTest");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jsp九大内置对象.jsp' starting page</title>
  </head>
  request.getContextPath() = <%=path%>
  <br>
  request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/" = <%=basePath %>
  <br>
  response.getCharacterEncoding() = <%=encoding %>
  <br>
  session.getId() = <%=sessionId %>
  <br>
  response.getCharacterEncoding() = <%=encoding %>
  <br>
   (String)application.getAttribute("test") = <%=encoding %>
  <br>
  out.print("test") = <% out.print("test"); %>
  <br>
  obj = <%=obj.toString() %>
  <br>
  config.getServletName() = <%=servletName %>
  <br>
  exception1 = <%=exception1 %>
  <br>
  pageContext.getAttribute("request") =
  <br>
  <body>
  </body>
</html>
