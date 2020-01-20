<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<div data-options="region:'north'" style="height: 50px; overflow: hidden; background-repeat: no-repeat;">
	<div style="position: absolute; right: 5px; top: 5px;">
		<s:message code="p_main.welcome" arguments="${sessionInfo.displayName}" />
	</div>
	<div id="layout_north_marquee" style="position: absolute; right: 200px; bottom: 0px; left: 120px;">
	
		<marquee behavior="scroll" direction="left" scrollamount="2"  scrolldelay="10" width=1700 height=35   onMouseOut="this.start()" onMouseOver="this.stop()" ><p id="p_notification">
		<img alt="" src="${pageContext.request.contextPath}/images/icons/tip.png"><font id="font_scroll0"></font><a id="ascroll_0" href="" ><font id="font_scroll_link0"></font></a>
		<font id="font_space0">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
		</p></marquee> 
		
	</div>
	<div style="position: absolute; right: 0px; bottom: 0px; ">
		<a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_zxMenu',iconCls:'icon-vcard-edit'"><s:message code="p_main.menu.setting"/></a>
	</div>
	<div id="layout_north_zxMenu" style="width: 100px; display: none;">

		<div onclick="userInfoFun();" data-options="iconCls:'icon-vcard-edit'"><s:message code="common.editInfo"/></div>

		<div class="menu-sep"></div>
		<div onclick="logoutFun();" data-options="iconCls:'icon-door-out'"><s:message code="p_main.menu.logout"/></div>
	</div>
	<script type="text/javascript" charset="utf-8">
		function logoutFun() {
			$.getJSON('${pageContext.request.contextPath}/user/doLogout.do?rnd=' + (new Date().getTime()), function(result) {
				location.reload();
			});
		}
		function userInfoFun() {
			layout_center_addTab({
				title : '<s:message code="p_main.menu.profile"/>',
				closable : true,
				iconCls : 'icon-vcard-edit',
				 content : '<iframe src="${pageContext.request.contextPath}/maintenance/user/toEdit.do?id=${sessionInfo.userId}" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
				/* href : '${pageContext.request.contextPath}/user/toMyProfile.do' */
			});
		}
	</script>
</div>
