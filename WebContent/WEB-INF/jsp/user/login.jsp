<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null) {
		for(int i = 0; i < cookies.length; i++){
			Cookie cookie = cookies[i];
			if ("userInfo89554128".equals(cookie.getName())){
				String value = cookie.getValue();
				String name = value.split("-")[0];
				String password = value.split("-")[1];
				if(name != null && password != null){
					request.setAttribute("uid", name);
					request.setAttribute("pwd", password);
				}
			}
		}
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>用户登录</title>
<jsp:include page="../inc.jsp"></jsp:include>
<%-- <link href="${pageContext.request.contextPath}/csslib/login/login.css" rel="stylesheet" type="text/css" /> --%>
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/csslib/login/reset.css" />
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/csslib/login/login.css" />
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/csslib/login/blue.css" />
		
		<!-- comment extra.css for css validation -->
	<script type="text/javascript">
		$(function(){
			var myw = screen.availWidth;   
		    var myh = screen.availHeight;  
		    window.moveTo(0, 0);           
		    window.resizeTo(myw, myh);
			
		    //$("#btn1").attr("href","");
		    //$("#btn1").attr("href","#");
		    
			$("#uid").select();
			
			if (screen.width <= 1024 || screen.height <= 768) {
				$.cookie('screenSize', 'small', {
					expires : 31
				});
			} else {
				$.cookie('screenSize', 'large', {
					expires : 31
				});
			}
			
			// 回车提交
			 /* document.onkeydown = function(e){ 
			    var ev = document.all ? window.event : e;
			    if (ev.keyCode==13) {
			    	 if(){
			    		
			    	}else{
			    		
			    	} 
			    	formSubmit();
			    	//$('.panel window messager-window').close();
			    	//href_disabled();
			    	console.info($('.panel window messager-window'));
			    }
			}  */
			// 如果默认加载页不为空,那么自动登入
			var defaultPageCode = $("#defaultPageCode").val()
			if(null != defaultPageCode && defaultPageCode.length > 0){
				formSubmit();
			}
		});

		function href_disabled(){
			 $("#btn1").attr("href","");
		}
		
		function formSubmit(){
			var loginname = $("#uid").val() ;
			var password = $("#pwd").val() ;
			var defaultPageCode = $("#defaultPageCode").val() ;
			var cookieRemember = $("#cookieRemember").attr('checked');
			var questId = $("#questId").val() ;
			if (undefined == cookieRemember){
				cookieRemember = "unchecked";
			}
			if(loginname.length <1 || password.length <1){
				$("#errorInfo").html("登录名和登录密码不允许为空！");
				$("#errorInfoMain").show();
				return ;
			}
			
			$.post(
				"${pageContext.request.contextPath}/user/doLogin.do",
				{status:"0", uid:loginname, pwd:password, cookieRemember:cookieRemember, statusRegist : "o",
					defaultPageCode: defaultPageCode},
				function(result){
					try {
						var r = $.parseJSON(result);
						if (r.success) {
						var info = r.obj;
							/* //status=2 为新入职员工，需要跳转到答题页面
							if(info.status == '2'){
							window.location = '${pageContext.request.contextPath}/office/userQuset/toEdit.do';
							}else { */
							if (questId == null || questId == undefined || questId == "" || questId.length == 0){
								window.location = '${pageContext.request.contextPath}/';
							}else{
							// 链接带参数为跳转问卷页面
								var quest = questId;
								window.location = '${pageContext.request.contextPath}/office/userQuset/toEdit.do?field1='+quest;
							}
							//}
							
						} else {
							$("#errorInfo").html(r.msg);
							$("#errorInfoMain").show();
							
						}
					} catch (e) {
						$("#errorInfo").html(result);
						$("#errorInfoMain").show();
					}
				}
			)
		}
		
		function formRegister(){
			// window.location = '${pageContext.request.contextPath}/ReportServer?reportlet=addRegistration.cpt&op=write';
			window.location = '${pageContext.request.contextPath}/maintenance/user/toAddUser.do?stateInit';
		}

		function reset_form() {
			$('#div_user').form('clear');
		}
	</script>
</head>
<%-- <body >

    <div id="login" style="height: 200%">
	
	     <div id="top">
		      <div id="top_left"><img src="${pageContext.request.contextPath}/images/login/login_03.gif" /></div>
			  <div id="top_center"></div>
		 </div>
		 
		 <div id="center">
		      <div id="center_left"></div>
			  <div id="center_middle">
			       <div id="user">用 户
			         <input name="uid"  type="text" value="emp-sz" onkeypress="if(event.keyCode==13){$('#pwd').select();}" />
			       </div>
				   <div id="password">密   码
				     <input type="password" name="pwd"  value="123456" />
				   </div>
				   <div id="btn"><a id="btn1" href="javascript:formSubmit()" >登录</a><a href="javascript:reset_form()">清空</a></div>
			  
			  </div>
			  <div id="center_right"></div>		 
		 </div>
		 <div id="down">
		      <div id="down_left">
			      <div id="inf">
                       <span class="inf_text">版本信息</span>
					   <span class="copyright">系统 2013 v1.0</span>
			      </div>
			  </div>
			  <div id="down_center"></div>		 
		 </div>

	</div>
</body> --%>
	<body>
		
		<div class="boxLogin clearfix">
			 <!-- Tooltip styles  --> 
			<div id="errorInfoMain" class="toolTip tpRed clearfix" style="display: none;">
				<p id="errorInfo"></p>
				<a class="close" title="Close"></a>
			</div>
			
			<form action="main.html" method="post">
			<input id="questId" type="hidden" value="${questId}" />
			<div id="div_user" class="fields">
				<p class="sep error">
					<label class="small" for="user01">User name</label>
					<input  value="${defaultPageCode}" id="defaultPageCode" name="defaultPageCode" type="hidden" />
					<input value="${uid}" id="uid" name="uid"  type="text" class="sText" onkeypress="if(event.keyCode==13){$('#pwd').select();}" />
				</p>
				
				<p class="sep error">
					<label class="small" for="pass01">Password</label>
					 <input value="${pwd}" id="pwd" type="password" name="pwd" class="sText" onkeypress="if(event.keyCode==13){formSubmit();}"/>
				</p>
					
				<p class="rem">
					<input class="sCheck" type="checkbox" name="cookieRemember"  id="cookieRemember"/>
					<label for="check08">Remember me</label> 
				</p>
				
				<div class="action">
					<input id="btn1" onclick="formSubmit()" type="button" class="butDef" value="Login" />
					<input onclick="reset_form()" type="button" class="butDef" value="clean" />
					<input id="btn2" onclick="formRegister()" type="button" class="butDef" value="Register" />
				</div>
			</div>
			</form>
		</div>
		
	</body>
</html>
