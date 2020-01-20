<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page import="com.mtf.framework.util.CommonUtil"%>
<jsp:useBean id="comUtil" class="com.mtf.framework.util.CommonUtil" scope="page" />
<!DOCTYPE HTML>
<html>
<head>
<title>办公用品管理平台</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<script type="text/javascript">
	<c:if test="${sessionInfo == null}" >
		top.location = '${pageContext.request.contextPath}/';
	</c:if>
</script>
<jsp:include page="inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		if (screen.width < 1024 || screen.height < 768) {
			$.messager.alert('<s:message code="common.dialog.warn" />', 'For better experience, Screen resolution should larger than 1024x768!', 'warning');
		}
	});
</script>
<script type="text/javascript" charset="utf-8">
	function layout_center_refreshTab(title) {
		var t = $('#layout_center_tabs');
		var tab;
		if (title != undefined && title != '') {
			tab = t.tabs('getTab', title);
		} else {
			tab = t.tabs('getSelected');
		}
		if (tab != undefined) {
			var href = tab.panel('options').href;
			if (href) {/*说明tab是以href方式引入的目标页面*/
				var index = t.tabs('getTabIndex', tab);
				t.tabs('getTab', index).panel('refresh');
			} else {/*说明tab是以content方式引入的目标页面*/
				var panel = tab.panel('panel');
				var frame = panel.find('iframe');
				try {
					if (frame.length > 0) {
						for ( var i = 0; i < frame.length; i++) {
							frame[i].contentWindow.document.write('');
							frame[i].contentWindow.close();
							frame[i].src = frame[i].src;
						}
						if ($.browser.msie) {
							CollectGarbage();
						}
					}
				} catch (e) {
				}
			}
		}
	}
	
	function layout_center_addTab(opts) {
		var t = $('#layout_center_tabs');
		
		if (t.tabs("tabs").length > 10) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '打开太多卡片了', 'info');
			return;
		}
		var id = opts.id;
		if(id != null){
			var idTemp = id.toString().substr(0,2)
			var idPar = idTemp + '00000';
			var idMenu = 'menu' + idPar;
			
		}
		if (t.tabs('exists', opts.title)) {
			//t.tabs('select', opts.title);
			//新的打开方式（满足书节点打开）
			//var Allurl=undefined;
			var tab = t.tabs("getTab", opts.title);
			
			var node;
			/* if(opts.id > 900){
				node = $('#menu1100000').tree('find',opts.id);
			}else if(200 < opts.id && opts.id < 400){
				node = $('#menu_contract_management1').tree('find',opts.id);
			}
			
			else if(500 < opts.id && opts.id < 600){
				node = $('#menu1600000').tree('find',opts.id);
			}
			else if(100 < opts.id && opts.id < 200){
				node = $('#menu1200000').tree('find',opts.id);
			}
			else if(400 < opts.id ){
				//node = $('#menu1500000').tree('find',opts.id);
			} */
			//Allurl="${pageContext.request.contextPath}" + node.attributes.url;
			t.tabs('select', opts.title); 
			//refreshTab(tab, Allurl);
		} else {
			t.tabs('add', opts);
		}
	}
	
function refreshTab(obj,url){
var refresh_tab = obj;
if (refresh_tab && refresh_tab.find('iframe').length > 0){
		var _refresh_ifram = refresh_tab.find('iframe')[0];
		_refresh_ifram.contentWindow.location.href = url;
	} 
}

	
	function layout_center_closeTab(title) {
		var t = $('#layout_center_tabs');
		var tab;
		if (title != undefined && title != '') {
			tab = t.tabs('getTab', title);
		} else {
			tab = t.tabs('getSelected');
		}
		if (tab != undefined && tab.panel('options').closable) {
			t.tabs('close', tab.panel('options').title);
		}
	}
	
 	

	$(function() {
		
		$.post('${pageContext.request.contextPath}/information/doGetInfo.do',null,function(r){
			var j = $.parseJSON(r);
			if (j.success) {
				var total = j.obj.total ;
				for(var i=0;i<total ;i++){
					
					if(0 == i){
						$("#font_scroll"+i).html(j.obj.rows[i].remarks);
						$("#font_scroll_link"+i).html(j.obj.rows[i].linkRemarks);
						$("#ascroll_0").attr("href","/office"+j.obj.rows[i].url);
					}else{
					 	$("#font_space"+(i-1)).after("<img alt='' src='${pageContext.request.contextPath}/images/icons/tip.png'><font id='font_scroll" + i + "'></font>");
						$("#font_scroll"+i).after("<a id='ascroll_" + i + "' href='#'><font id='font_scroll_link" + i + "'></font></a><font id='font_space" + i + "' style='margin-left: 400px'></font>");
						
						$("#font_scroll"+i).html(j.obj.rows[i].remarks);
						$("#font_scroll_link"+i).html(j.obj.rows[i].linkRemarks); 
						$("#ascroll_"+i).attr("href","/office"+j.obj.rows[i].url);
					}
				} 
			}
		});
		
		$('#layout_center_tabs_contentmenu').menu({
			onClick : function(item) {
				var t = $('#layout_center_tabs');
				var curTabTitle = $(this).data('tabTitle');
				var type = $(item.target).attr('type');
				if (type === 'refresh') {
					layout_center_refreshTab(curTabTitle);
					return;
				}

				if (type === 'close') {
					var tab = t.tabs('getTab', curTabTitle);
					if (tab.panel('options').closable) {
						t.tabs('close', curTabTitle);
					}
					return;
				}

				var allTabs = t.tabs('tabs');
				var closeTabsTitle = [];

				$.each(allTabs, function() {
					var opt = $(this).panel('options');
					if (opt.closable && opt.title != curTabTitle && type === 'closeOther') {
						closeTabsTitle.push(opt.title);
					} else if (opt.closable && type === 'closeAll') {
						closeTabsTitle.push(opt.title);
					}
				});

				for ( var i = 0; i < closeTabsTitle.length; i++) {
					t.tabs('close', closeTabsTitle[i]);
				}
			}
		});

		$('#layout_center_tabs').tabs({
			fit : true,
			border : false,
			onContextMenu : function(e, title) {
				e.preventDefault();
				$('#layout_center_tabs_contentmenu').menu('show', {
					left : e.pageX,
					top : e.pageY
				}).data('tabTitle', title);
			},
			tools : '#layout_center_toolbar'
		});
		
	/* 	$('#layout_center_tabs').tabs({
			onSelect:function(title){
				//alert(title+' is selected');
				//var node = undefined;
				var id = undefined;
				switch(title){
					case "<s:message code="officeTree.tree.maintenance"/>":  id=111; break;
					case "<s:message code="common.titleOfficeApply"/>":  id=112; break;
					case "<s:message code="officeTree.tree.officeSuppliesApply"/>" :  id=113; break;
					case "<s:message code="officeTree.tree.costCheck"/>":  id=122; break;
					case "<s:message code="officeTree.tree.costToCheckDeps"/>":  id=123; break;
					case "<s:message code="officeTree.tree.costToCheckEmp"/>":  id=124; break;
					case "<s:message code="officeTree.tree.itemAmount"/>":  id=125; break;
					case "<s:message code="p_main.tree.maintenance.user.add"/>":  id=901; break; 
					case "<s:message code="p_main.tree.maintenance.user.search"/>" :  id=902; break; 
					case "<s:message code="p_main.tree.maintenance.division.add"/>":  id=903; break; 
					case "<s:message code="p_main.tree.maintenance.division.search"/>" :  id=904; break; 
					case "<s:message code="p_main.tree.admin.role.add"/>":  id=905; break; 
					case "<s:message code="p_main.tree.admin.role.search"/>" :  id=906; break;
					case "<s:message code="p_main.tree.admin.action.add"/>":  id=907; break; 
					case "<s:message code="p_main.tree.admin.action.search"/>" :  id=908; break; 
					case "<s:message code="p_main.tree.admin.resource.add"/>":  id=909; break; 
					case "<s:message code="p_main.tree.admin.resource.search"/>" :  id=910; break;
					case "<s:message code="p_main.tree.admin.sysMagTip"/>" :  id=911; break;
					case "<s:message code="officeTree.tree.registerRecord"/>" :  id=114; break;
					case "<s:message code="officeTree.tree.checkPersonalInfo"/>":  id=115; break;
					case "问卷管理" :  id=201; break;
					case "费用报销审批" :  id=116; break;
					case "我的申请" :  id=410; break;
					case "我的采购" :  id=470; break;
					case "我的报销" :  id=420; break;
					case "财务审核" :  id=430; break;
					case "待审批LV2" :  id=441; break;
					case "待审批LV1" :  id=442; break;
					case "历史审批" :  id=443; break;
					case "待估价" :  id=451; break;
					case "待采购" :  id=452; break;
					case "历史采购" :  id=453; break;
					case "采购查看" :  id=444; break;
					case " 我关注的采购" :  id=454; break;
					case "采购统计" :  id=461; break;
					case "报销统计" :  id=462; break;
					case "打卡补签" :  id=501; break;
					case "考勤审批" :  id=502; break;
					case "考勤统计" :  id=503; break;
					case "考勤时段" :  id=504; break;
					case "考勤规则" :  id=505; break;
					case "节日管理" :  id=506; break;
					case "请假管理" :  id=507; break;
					case "请假申请" :  id=508; break;
					case "加班申请" :  id=509; break;
					case "加班审批" :  id=510; break;
					case "加班审批" :  id=511; break;
					case "考勤配置" :  id=512; break;
					case "订车申请" :  id=1801001; break;
					case "订车审批" :  id=1804001; break;
					case "报销管理" :  id=1808100; break;
					case "一级审批" :  id=1808200; break;
					case "二级审批" :  id=1808300; break;
					case "三级审批" :  id=1808400; break;
			}
				if(id!=null){
					layout_center_ExpendTreeByTabs(id);
				}
			}
		}); */
		
		
	});
	function layout_center_ExpendTreeByTabs(id){
		var node;
		if(id >= 1800000 && id < 1900000 ){
			node = $('#menu1800000').tree('find',id);
			$('#menu1800000').tree('expandTo',node.target).tree('select', node.target);
		}
		if(id > 900 && id < 1000){
			node = $('#menu1100000').tree('find',id);
			$('#menu1100000').tree('expandTo',node.target).tree('select', node.target);
		}
		else if(200 < id && id < 400){
			node = $('#menu_contract_management1').tree('find',id);
			$('#menu_contract_management1').tree('expandTo',node.target).tree('select', node.target);
		} 
		
		else if(500 < id && id < 600){
			node = $('#menu1600000').tree('find',id);
			$('#menu1600000').tree('expandTo',node.target).tree('select', node.target);
		} 
		
		else if(100 < id && id < 200){
			node = $('#menu1200000').tree('find',id);
			$('#menu1200000').tree('expandTo',node.target).tree('select', node.target);
		} else if(400 < id ){
			//node = $('#menu1500000').tree('find',id);
			//$('#menu1500000').tree('expandTo',node.target).tree('select', node.target);
		} 
	}
	
	function downHelp(){
		var url = '${pageContext.request.contextPath}/upload/upload/attachment/ChromeStandaloneSetup.exe';
		window.location.href = url;
	}
</script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		layout_center_addTab({
			title : '<s:message code="p_main.center.title"/>',
			closable : false,
			iconCls : 'icon-home',
			content : '<iframe src="${pageContext.request.contextPath}/user/toDashboard.do" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>'
		});
	});
	/* setTimeout(function(){
		layout_center_addTab({
			id:node.id,
			title : node.text,
			closable : true,
			iconCls : node.iconCls,
			content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
		}); */
		/*	$(function() {
 		$("#title1200000").hide();
		$("#title1200000").prev().removeClass("accordion-header-selected");
		$("#title1800000").prev().addClass("accordion-header-selected");
		$("#title1800000").show(); */
		//$("#title1200000").prev().attr('class');
		//var parent = $("#title1800000").parent();
		//alert(parent.first().html())
		//$("#title1800000").parent().first().click();
		//var div = $("#div_accordion").find("div").first;
		//alert(div)
		/*  layout_center_addTab({
			id: '1808400',
			title : '三级审批',
			closable : true,
			iconCls : 'ext-icon-tick',
			content : '<iframe src="${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808400" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>'
		}); 
	

}, 1000);*/
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north'" style="height: 50px; overflow: hidden; background-repeat: no-repeat;">
		<div style="position: absolute; right: 5px; top: 5px;">
			<s:message code="p_main.welcome" arguments="${sessionInfo.displayName}" />
		</div>
		<div id="layout_north_marquee" style="position: absolute; right: 200px; bottom: 0px; left: 120px;">
		
			<marquee behavior="scroll" direction="left" scrollamount="2"  scrolldelay="10" width="1700" height="35" onMouseOut="this.start()" onMouseOver="this.stop()" ><p id="p_notification">
			<img alt="" src="${pageContext.request.contextPath}/images/icons/tip.png"><font id="font_scroll0"></font><a id="ascroll_0" href="" ><font id="font_scroll_link0" ></font></a>
			<font id="font_space0" style='margin-left: 400px'></font>
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
<%-- <c:if test="${ sessionInfo.pass != 'e10adc3949ba59abbe56e057f20f883e' }"> --%>
	<div data-options="region:'west',split:true,title:'<s:message code="common.titleMenu"/>'" style="width: 200px; overflow: hidden;">
		<div id="div_accordion" class="easyui-accordion" data-options="fit:true,border:false">
		<%-- <c:if test="${sessionInfo.userLever == '0' || sessionInfo.userLever == '1' || sessionInfo.userLever == '2' || sessionInfo.userLever == '3' || sessionInfo.userLever == '4' || sessionInfo.userLever == '5' || sessionInfo.userLever == '6' || sessionInfo.userLever == '7'}"> --%>
			<c:if test="${comUtil.checkCode('1200000')}">
					<div id="title1200000" title="<s:message code="common.titleOfficeManage"/>">
						<ul id="menu1200000"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu1200000').tree({
								data : [
											// 主菜单 办公用品申请
											<c:if test="${comUtil.containCode('1201000,1202000,1203000')}">
												{
													text : '<s:message code="common.titleOfficeApply"/>',
													iconCls : 'ext-icon-attach',
													children : [
														// 子菜单 办公用品申请
														<c:if test="${comUtil.checkCode('1201000')}">
															{
																
																id: 1201000,
																text : '<s:message code="common.titleOfficeApply"/>',
																iconCls : 'ext-icon-basket',
																attributes : {
																	url : '${pageContext.request.contextPath}/office/office/toOfficeAdd.do'
																}
															},
														</c:if>
														// 子菜单 办公用品审批
														// 如果是业务部或事件部经理的话可见
														<c:if test="${comUtil.checkCode('1202000')}">
															{
																id: 1202000,
																text : '<s:message code="officeTree.tree.officeSuppliesApply"/>',
																iconCls : 'ext-icon-tick',
																attributes : {
																	url : '${pageContext.request.contextPath}/office/office/toSearch.do'
																}
															},
														</c:if>
														// 部门可见
														/* {
															id: 112,
															text : '<s:message code="common.titleOfficeApply"/>',
															attributes : {
																url : '${pageContext.request.contextPath}/office/office/toOfficeAdd.do'
															}
														},
														{
															id: '113',
															text : '<s:message code="officeTree.tree.officeSuppliesApply"/>',
															iconCls : 'icon-search',
															attributes : {
																url : '${pageContext.request.contextPath}/office/office/toSearch.do'
															}
														}, */
														// 子菜单 邮件提醒
														<c:if test="${comUtil.checkCode('1203000')}">
															{
																id: 1203000,
																text : '<s:message code="officeTree.tree.emailAlert"/>',
																iconCls : 'ext-icon-email',
																attributes : {
																	url : '${pageContext.request.contextPath}/office/email/toEdit.do'
																}
															},
														</c:if>
													]
												},
											</c:if>
											// 主菜单 办公用品维护
											<c:if test="${comUtil.containCode('1204000')}">
												{
													text : '<s:message code="officeTree.tree.maintenance"/>',
													iconCls : 'ext-icon-pencil',
													children : [
														// 子菜单 办公用品维护
														<c:if test="${comUtil.checkCode('1204000')}">
															{
																id: 1204000,
																text : '<s:message code="officeTree.tree.maintenance"/>',
																iconCls : 'ext-icon-basket_add',
																attributes : {
																	url : '${pageContext.request.contextPath}/office/itemrule/toSearch.do'
																}
															},
														</c:if>
													]
												},
											</c:if>
											// 主菜单 办公用品费用
											<c:if test="${comUtil.containCode('1205000,1206000,1207000,1208000')}">
												{
													text : '<s:message code="officeTree.tree.costCheck"/>',
													iconCls : 'ext-icon-search',
													children : [
														// 子菜单 办公用品费用查看
														<c:if test="${comUtil.checkCode('1205000')}">
															{
																id: 1205000,
																text : '<s:message code="officeTree.tree.costCheck"/>',
																iconCls : 'ext-icon-zoom',
																attributes : {
																	url : '${pageContext.request.contextPath}/report/toSearch.do'
																}
															},
														</c:if>
														// 子菜单 部门办公用品费用查看
														<c:if test="${comUtil.checkCode('1206000')}">
															{
																id: 1206000,
																text : '<s:message code="officeTree.tree.costToCheckDeps"/>',
																iconCls : 'ext-icon-zoom',
																attributes : {
																	url : '${pageContext.request.contextPath}/report/toSearchDep.do'
																}
															},
														</c:if>
														// 子菜单 员工办公用品费用查看
														<c:if test="${comUtil.checkCode('1207000')}">
															{
																id: 1207000,
																text : '<s:message code="officeTree.tree.costToCheckEmp"/>',
																iconCls : 'ext-icon-zoom',
																attributes : {
																	url : '${pageContext.request.contextPath}/report/toSearchEmp.do'
																}
															},
														</c:if>
													]
												},
											</c:if>
											// 主菜单 员工入职等级表
											/* <c:if test="${comUtil.checkCode('1103000')}">
												{
													text : '<s:message code="officeTree.tree.registerRecord"/>',
													children : [{
														id: 114,
														text : '<s:message code="officeTree.tree.registerRecord"/>',
														attributes : {
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=editRegistration.cpt&op=write&loginName=${sessionInfo.loginName}&modifyUser=${sessionInfo.loginName}'
														}
													}]
												},
											</c:if> */
											// 主菜单 费用报销审批
											<c:if test="${comUtil.containCode('1208000')}">
												{
													text : '<s:message code="费用报销审批"/>',
													iconCls : 'ext-icon-shading',
													children : [
														<c:if test="${comUtil.checkCode('1208000')}">
															{
																id: 1208000,
																text : '费用报销审批',
																iconCls : 'ext-icon-tick',
																attributes : {
																	url : '${pageContext.request.contextPath}/payment/paymentVoucher/toAdd.do'
																	//url : '/ReportServer?reportlet=paymentVoucher.cpt&op=write&userId=${sessionInfo.userId}&divisionId=${sessionInfo.divisionId}'
																}
															},
														</c:if>
													]
												},
											</c:if>
										],
								lines : true,
								onClick : function(node) {
									var url;
									if (node.attributes != undefined && node.attributes.url != undefined) {
										url = node.attributes.url;
									} else {
										return;
									}
									layout_center_addTab({
										id:node.id,
										title : node.text,
										closable : true,
										iconCls : node.iconCls,
										content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
									});
								}
							});
						});
						</script>
					</div>
				</c:if>
				<c:if test="${comUtil.checkCode('1600000')}">
					<div id="title1600000" title="考勤管理">
						<ul id="menu1600000"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu1600000').tree({
								data : 
									[
										<c:if test="${comUtil.containCode('1601000,1602000,1603000,1604000,1612000,1613000')}">
										{
											id: 501,
											text : '考勤管理',
											iconCls : 'ext-icon-clock',
										children : [
										      
										<c:if test="${comUtil.checkCode('1601000')}">
											{
												id: 1601000,
												text : '打卡补签',
												iconCls : 'ext-icon-tag_green',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do?tagSearch=re'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1619000')}">
											{
												id: 1619000,
												text : '考勤调整',
												iconCls : 'ext-icon-tag_blue_edit',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do?tagPageCode=1619000'
												}
											},
										</c:if>
										// 部门经理专用
										/* <c:if test="${comUtil.checkCode('1602000')}">
											{
												id: 1602000,
												text : '考勤查看',
												iconCls : 'ext-icon-tag_orange',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do?tagSearch=ap1'
												}
											},
										</c:if> */
										<c:if test="${comUtil.checkCode('1602000')}">
											{
												id: 1602000,
												text : '考勤审批',
												iconCls : 'ext-icon-tick',
												attributes : {
													/* url : '/attendance/attenRecord/toSearch.do?tag=ap1&typeRecord=a&serverIp=${sessionInfo.serverIp}' */
													url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchApprove.do?typeData=a&tagPage=a'
												}
											},
										</c:if>
										// 人事管理专用
										/* <c:if test="${comUtil.checkCode('')}">
											{
												id: 16,
												text : '考勤审批',
												iconCls : 'ext-icon-tag_orange',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do?tagSearch=ap2'
												}
											},
										</c:if> */
										<c:if test="${comUtil.checkCode('1612000')}">
										{
											id: 1612000,
											text : '考勤统计',
											iconCls : 'ext-icon-chart_bar',
											attributes : {
												//url : '/ReportServer?reportlet=showAttendanceAll.cpt&op=write&serverIp=${sessionInfo.serverIp}&applyMonth=${sessionInfo.lastMonth}'
												url : '${pageContext.request.contextPath}/attendance/attenRecord/toSearch.do?tag=ap2&typeRecord=a'
											}
										},
										</c:if>
										<c:if test="${comUtil.checkCode('1613000')}">
											{
												id: 1613000,
												text : '考勤时段',
												iconCls : 'ext-icon-clock_link',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attenDay/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1604000')}">
											{
												id: 1604000,
												text : '考勤规则',
												iconCls : 'ext-icon-style_edit',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attenRule/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1603000')}">
											{
												id: 1603000,
												text : '节日管理',
												iconCls : 'ext-icon-map_edit',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attenFestival/toSearch.do?tag=m'
												}
											},
										</c:if>
										]
										},
										</c:if>
										<c:if test="${comUtil.containCode('1607000,1614000,1608000,1606000,1605000')}">
											{
												id: 507,
												text : '请假管理',
												iconCls : 'ext-icon-group_go',
											children : [
												/* <c:if test="${comUtil.checkCode('1605000')}">
													{
														id: 507,
														text : '请假管理',
														iconCls : 'ext-icon-tag_red',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearch.do'
														}
													},
												</c:if> */
												<c:if test="${comUtil.checkCode('1607000')}">
													{
														id: 1607000,
														text : '请假申请',
														iconCls : 'ext-icon-tag_pink',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearch.do?typeData=v&tagPage=i&tagPageCode=1607000'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('1614000')}">
													{
														id: 1614000,
														text : '考勤类型',
														iconCls : 'ext-icon-pictures',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacate/toSearch.do'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('1608000')}">
													{
														id: 1608000,
														text : '假期维护',
														iconCls : 'ext-icon-paintcan',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateRule/toSearch.do'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('1606000')}">
													{
														id: 1606000,
														text : '请假审批',
														iconCls : 'ext-icon-tick',
														attributes : {
															//url : '/ReportServer?reportlet=showAttendanceAll.cpt&op=write&serverIp=${sessionInfo.serverIp}&applyMonth=${sessionInfo.lastMonth}'
															//url : '/attendance/attenRecord/toSearch.do?tag=ap1&typeRecord=v&serverIp=${sessionInfo.serverIp}'
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchApprove.do?typeData=v&tagPage=a&tagPageCode=1606000'
														}
													},
												</c:if>
											]
											},
										</c:if>
										<c:if test="${comUtil.containCode('16200000')}">
											{
												id: 16200000,
												text : '加班管理',
												iconCls : 'ext-icon-group_go',
											children : [
												<c:if test="${comUtil.checkCode('16200100')}">
													{
														id: 16200100,
														text : '部门加班申请',
														iconCls : 'ext-icon-plugin',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchOvertime.do?typeData=v&tagPage=i&tagPageCode=16200100'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('16200200')}">
													{
														id: 16200200,
														text : '个人加班申请',
														iconCls : 'ext-icon-user',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchOvertime.do?typeData=v&tagPage=i&tagPageCode=16200200'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('16200300')}">
													{
														id: 16200300,
														text : '加班审批',
														iconCls : 'ext-icon-tick',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchApprove.do?typeData=v&tagPage=a&tagPageCode=16200300'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('16200300')}">
													{
														id: 16200400,
														text : '加班修正',
														iconCls : 'ext-icon-pencil',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearchOvertime.do?typeData=v&tagPage=i&tagPageCode=16200400'
														}
													},
												</c:if>
												<c:if test="${comUtil.checkCode('16200300')}">
													{
														id: 16200500,
														text : '加班统计',
														iconCls : 'ext-icon-chart_curve',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenRecord/toSearch.do?tag=ap2&typeRecord=a&tagPageCode=16200500'
														}
													},
												</c:if>
											]
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1612000')}">
											{
												id: 1612000,
												text : '考勤报表',
												iconCls : 'ext-icon-group_go',
												children : [
												/* <c:if test="${comUtil.checkCode('1605000')}">
													{
														id: 507,
														text : '请假管理',
														iconCls : 'ext-icon-tag_red',
														attributes : {
															url : '${pageContext.request.contextPath}/attendance/attenVacateManage/toSearch.do'
														}
													},
												</c:if> */
												<c:if test="${comUtil.checkCode('1612000')}">
													{
														id: 1616000,
														text : '部门加班汇总表',
														iconCls : 'ext-icon-tag_pink',
														attributes : {
															//url : '/ReportServer?reportlet=showWorkExtraAll.cpt&__bypagesize__=true'
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=showWorkExtraAll2.cpt&__bypagesize__=true&serverIp=${pageContext.request.contextPath}'
														}
													},
													{
														id: 1617000,
														text : '全员考勤汇总表',
														iconCls : 'ext-icon-tag_pink',
														attributes : {
															//url : '/ReportServer?reportlet=showWorkExtraAll.cpt&__bypagesize__=true'
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAllYear.cpt&__bypagesize__=true&serverIp=${pageContext.request.contextPath}'
														}
													},
													{
														id: 1618000,
														text : '全员加班明细表',
														iconCls : 'ext-icon-tag_pink',
														attributes : {
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=showAttenUserByDate.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
														}
													},
												</c:if>
											]
											},
										</c:if>
							
										/* <c:if test="${comUtil.checkCode('1608000')}">
											{
												id: 510,
												text : '加班申请',
												iconCls : 'ext-icon-tag_blue',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do'
												}
											},
								
											</c:if>
										<c:if test="${comUtil.checkCode('')}">
											{
												id: 511,
												text : '加班审批',
												iconCls : 'ext-icon-tag_red',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do'
												}
											},
										</c:if> */
										/* <c:if test="${comUtil.checkCode('1611000')}">
											{
												id: 512,
												text : '考勤配置',
												iconCls : 'ext-icon-tag_red',
												attributes : {
													url : '${pageContext.request.contextPath}/attendance/attendance/toSearch.do'
												}
											},
										</c:if> */
									],
								lines : true,
								onClick : function(node) {
									var url;
									if (node.attributes != undefined && node.attributes.url != undefined) {
										url = node.attributes.url;
									} else {
										return;
									}
									layout_center_addTab({
										id:node.id,
										title : node.text,
										closable : true,
										iconCls : node.iconCls,
										content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
									});
								}
							});
						});
						</script>
					</div>
				</c:if>	
				<c:if test="${comUtil.checkCode('1800000')}">
					<div id="title1800000" title="申请管理">
					<ul id="menu1800000"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu1800000').tree({
								data : 
									[
										<c:if test="${comUtil.containCode('1801000,1802000,1803000,1804000')}">
											{
												id: 1801000,
												text : '订车管理',
												iconCls : 'ext-icon-car',
												children : [
													<c:if test="${comUtil.checkCode('1801000')}">
														{   
															id: 1801001,
															text : '订车申请',
															iconCls : 'ext-icon-car_add',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderService/toSearch.do?tagModule=o'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1804000')}">
														{   
															id: 1804001,
															text : '订车审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderService/toSearch.do?tagModule=ap'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1802000')}">
														{   
															id: 1802001,
															text : '路线维护',
															iconCls : 'ext-icon-patten',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderServicePath/toSearch.do'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1803000')}">
														{   
															id: 1803001,
															text : '派车管理',
															iconCls : 'ext-icon-car_add',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderService/toSearch.do?tagModule=a'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1805000')}">
														{   
															id: 1805001,
															text : '订车报销',
															iconCls : 'ext-icon-money_yen',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderServiceRecord/toSearch.do?tagPageCode=1805000'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1806100, 1806200')}">
											{
												id: 1801000,
												text : '订车报表',
												iconCls : 'ext-icon-chart_line',
												children : [
													<c:if test="${comUtil.checkCode('1806100')}">
														{   
															id: 1806100,
															text : '车费统计',
															iconCls : 'ext-icon-chart_curve_go',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceTotal.cpt&__bypagesize__=true'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1806200')}">
														{   
															id: 1806200,
															text : '出车明细',
															iconCls : 'ext-icon-chart_curve_link',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetail.cpt&__bypagesize__=true'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1807100,')}">
											{
												id: 1807000,
												text : '申请维护',
												iconCls : 'ext-icon-wrench',
												children : [
													<c:if test="${comUtil.checkCode('1807100')}">
														{   
															id: 1807100,
															text : '科目维护',
															iconCls : 'ext-icon-pictures',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategory/toSearch.do'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1807200')}">
														{   
															id: 1807200,
															text : '科目规则',
															iconCls : 'ext-icon-plugin',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryRule/toSearch.do'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1808100,1808200,1808300,1808400')}">
											{
												text : '报销管理',
												iconCls : 'ext-icon-money_dollar',
												children : [
													<c:if test="${comUtil.checkCode('1808100')}">
														{   
															id: 1808100,
															text : '报销管理',
															iconCls : 'ext-icon-money',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=m&typeData=r&tagPageCode=1808100'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808200')}">
														{   
															id: 1808200,
															text : '一级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808200'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808300')}">
														{   
															id: 1808300,
															text : '二级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808300'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808400')}">
														{   
															id: 1808400,
															text : '三级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808400'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808600')}">
														{   
															id: 1808600,
															text : '财务审核',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808600'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1809500')}">
														{   
															id: 1809500,
															text : '报销修正',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1809500'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808700')}">
														{   
															id: 1808700,
															text : '报销签字',
															iconCls : 'ext-icon-ticks',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderServiceRecord/toSearch.do?tagPageCode=1808700'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808900')}">
														{   
															id: 1808900,
															text : '报销统计总计',
															iconCls : 'ext-icon-chart_curve',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAllTotal.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1808800')}">
														{   
															id: 1808800,
															text : '报销统计明细',
															iconCls : 'ext-icon-chart_curve',
															attributes : {
																//url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAll2.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
																//url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAll2.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAllDetail.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1809100,1809200,1809300,1809400')}">
											{
												text : '申请管理',
												iconCls : 'ext-icon-money_dollar',
												children : [
													<c:if test="${comUtil.checkCode('1809100')}">
														{   
															id: 1808100,
															text : '申请管理',
															iconCls : 'ext-icon-money',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=m&typeData=a'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1809200')}">
														{   
															id: 1808200,
															text : '一级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=a'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1809300')}">
														{   
															id: 1808300,
															text : '二级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=a'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1809400')}">
														{   
															id: 1808300,
															text : '三级审批',
															iconCls : 'ext-icon-tick',
															attributes : {
																url : '${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=a'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1813100')}">
											{
												text : '汇率管理',
												iconCls : 'ext-icon-money_yen',
												children : [
													<c:if test="${comUtil.checkCode('1813100')}">
														{   
															id: 1813100,
															text : '汇率管理',
															iconCls : 'ext-icon-money_dollar',
															attributes : {
																url : '${pageContext.request.contextPath}/maintenance/currency/toSearch.do'
															}
														}
													</c:if>
														   ]
											},
										</c:if>
										<c:if test="${comUtil.containCode('1811001,1811002,1811003,1811004')}">
											{
												text : '申请报表',
												iconCls : 'ext-icon-chart_bar',
												children : [
													<c:if test="${comUtil.checkCode('1811005')}">
														{   
															id: 1811005,
															text : '实时报销流水',
															iconCls : 'ext-icon-chart_bar_error',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAllCurrent.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1811001')}">
														{   
															id: 1811001,
															text : '审批报销流水',
															iconCls : 'ext-icon-chart_bar_error',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryAll.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1811002')}">
														{   
															id: 1811002,
															text : '部门报销统计表',
															iconCls : 'ext-icon-chart_bar_add',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryDep.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1811003')}">
														{   
															id: 1811003,
															text : '人员报销统计表',
															iconCls : 'ext-icon-chart_bar_edit',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryUser.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1811004')}">
														{   
															id: 1811004,
															text : '科目报销统计表',
															iconCls : 'ext-icon-chart_bar_link',
															attributes : {
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategory.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1811006')}">
														{   
															id: 1811004,
															text : '报销科目',
															iconCls : 'ext-icon-chart_bar_link',
															attributes : {
															url : '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryList.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
												   ]
											},
										</c:if>
									],
								lines : true,
								onClick : function(node) {
									var url;
									if (node.attributes != undefined && node.attributes.url != undefined) {
										url =  node.attributes.url;
									} else {
										return;
									}
									layout_center_addTab({
										id:node.id,
										title : node.text,
										closable : true,
										iconCls : node.iconCls,
										content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
									});
								},
							});
						});
						</script>
					</div>
				</c:if>	
				<%--  <c:if test="${sessionInfo.userLever == '9' || sessionInfo.userLever == '6'}">	 --%>
				<c:if test="${comUtil.checkCode('1300000')}">
					<div id="title1600000" title="问卷管理与维护">
						<ul id="menu_contract_management1"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu_contract_management1').tree({
								data : 
									[
										// 主菜单 问卷管理
										<c:if test="${comUtil.checkCode('1301000')}">
											{
												id: 1301000,
												text : '问卷管理',
												iconCls : 'icon-vcard',
												attributes : {
													url : '${pageContext.request.contextPath}/office/quest/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1302000')}">
											{   
											  //员工入职等级表
												id: 1302000,
												text : '<s:message code="officeTree.tree.registerRecord"/>',
												attributes : {
													url : '${pageContext.request.contextPath}/ReportServer?reportlet=editRegistration.cpt&op=write&loginName=${sessionInfo.loginName}&modifyUser=${sessionInfo.loginName}'
												}
												}
										</c:if>
									],
								lines : true,
								onClick : function(node) {
									var url;
									if (node.attributes != undefined && node.attributes.url != undefined) {
										url = node.attributes.url;
									} else {
										return;
									}
									layout_center_addTab({
										id:node.id,
										title : node.text,
										closable : true,
										iconCls : node.iconCls,
										content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
									});
								}
							});
						});
						</script>
					</div>
				</c:if>
				
				<c:if test="${comUtil.checkCode('1500000')}">
					<div id="title1500000" title="申请和报销管理">
						<ul id="menu1500000"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu1500000').tree({
								data : 
									[
										// 主菜单 问卷管理
										<c:if test="${comUtil.checkCode('1501000')}">
											{
												id: 1501000,
												text : '我的申请',
												iconCls : 'ext-icon-cart',
												attributes : {
													url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toMyPurchase.do?statusGroup=1'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1513000')}">
										{
											id: 1513000,
											text : '我的采购',
											iconCls : 'ext-icon-money_yen',
											attributes : {
												url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toMyQuote.jsp.do?statusGroup=8'
											}
										},
										</c:if>
										<c:if test="${comUtil.checkCode('1502000')}">
											{
												id: 1502000,
												text : '我的报销',
												iconCls : 'ext-icon-money',
												attributes : {
													url : '${pageContext.request.contextPath}/office/reimbursement/reimbursement/toMyReimbursement.do?statusGroup=1'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1503000')}">
											{   
												id: 1503000,
												text : '财务审核',
												iconCls : 'ext-icon-shield',
												attributes : {
													url : '${pageContext.request.contextPath}/office/reimbursement/reimbursement/toFinancialAudit.do?statusGroup=2'
												}
											},
										</c:if>
										<c:if test="${comUtil.containCode('1504000,1505000,1506000')}">
											{   
											  //员工入职等级表
												id: 440,
												text : '审批管理',
												children : [
													<c:if test="${comUtil.checkCode('1505000')}">
														{
															id: '1505000',
															text : '申请审批',
															iconCls : 'ext-icon-paste_plain',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toApproveLv1.do?statusGroup=2'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1504000')}">
														{
															id: 1504000,
															text : '采购审批',
															iconCls : 'ext-icon-paste_plain',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toApproveLv2.do?statusGroup=3'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1514000')}">
														{
															id: 1514000,
															text : '采购查看',
															iconCls : 'ext-icon-eye',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toCheck.do?statusGroup=9'
															}
														},
													</c:if>
													
													<c:if test="${comUtil.checkCode('1506000')}">
														{
															id: '1506000',
															text : '历史审批',
															iconCls : 'icon-search',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toHistoryApprove.do?statusGroup=4'
															}
														},
													</c:if>
												]
											},
											</c:if>
											<c:if test="${comUtil.containCode('1507000,1508000,1509000,1510000')}">
											{   
												id: 450,
												text : '采购管理',
												children : [
													<c:if test="${comUtil.checkCode('1507000')}">
													{
														id: 1507000,
														text : '待估价',
														iconCls : 'ext-icon-calculator',
														attributes : {
															url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toEvaluate.do?statusGroup=5'
														}
													},
													</c:if>
													<c:if test="${comUtil.checkCode('1508000')}">
														{
															id: 1508000,
															text : '待采购',
															iconCls : 'ext-icon-cart',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toPurchase.do?statusGroup=6'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1509000')}">
														{
															id: 1509000,
															text : '历史采购',
															iconCls : 'icon-search',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toHistoryPurchase.do?statusGroup=7'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1510000')}">
													{
														id: 1510000,
														text : '我关注的采购',
														iconCls : 'ext-icon-heart',
														attributes : {
															url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toMyWatch.do'
														}
													}
													</c:if>
												]
											},
											</c:if>
											<c:if test="${comUtil.containCode('1511000,1512000')}">
											{   
												id: 460,
												text : '统计报表',
												children : [
													<c:if test="${comUtil.checkCode('1511000')}">
														{
															id: 1511000,
															text : '采购统计',
															iconCls : 'ext-icon-table',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/purchase/toPurchaseReport.do'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('1512000')}">
														{
															id: 1512000,
															text : '报销统计',
															iconCls : 'ext-icon-chart_curve',
															attributes : {
																url : '${pageContext.request.contextPath}/office/reimbursement/reimbursement/toReimbursementReport.do'
															}
														}
													</c:if>
												]
											}
											</c:if>
									],
								lines : true,
								onClick : function(node) {
									var url;
									if (node.attributes != undefined && node.attributes.url != undefined) {
										url = node.attributes.url;
									} else {
										return;
									}
									layout_center_addTab({
										id:node.id,
										title : node.text,
										closable : true,
										iconCls : node.iconCls,
										content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
									});
								}
							});
						});
						</script>
					</div>
				</c:if>
				
				<%-- </c:if> --%>
				<%-- <c:if test="${ sessionInfo.userLever == '9' || sessionInfo.userLever == '6' || sessionInfo.userLever == '7'}"> --%>
				 <c:if test="${comUtil.checkCode('1100000')}">
					<div title="人力资源管理及维护" id="title1100000">
						<ul id="menu1100000"></ul>
						<script type="text/javascript" charset="utf-8">
							$(function() {
								$('#menu1100000').tree({
									data: [
										// 员工管理
										<c:if test="${comUtil.checkCode('1101000')}">
											/* {
												text : '<s:message code="p_main.tree.maintenance.user"/>',
												iconCls : 'icon-user',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/user/toSearch.do'
												}
											}, */
											{
												id: 1101000,
												text : '<s:message code="p_main.tree.maintenance.user"/>',
												iconCls : 'ext-icon-user',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/userDetail/toSearch.do'
												}
											}, 
											{
												id : 1108000,
												text : '用户信息',
												iconCls : 'ext-icon-group_link',
												attributes : {
													url : '${pageContext.request.contextPath}/ReportServer?reportlet=showUserList.cpt&__bypagesize__=true&__cutpage__=v&status=04'
												}
											},  
											<c:if test="${comUtil.checkCode('1110000')}">
											{
												id : 1110000,
												text : '用户历史',
												iconCls : 'ext-icon-group_link',
												attributes : {
													url : '${pageContext.request.contextPath}/ReportServer?reportlet=showUserList.cpt&__bypagesize__=true&__cutpage__=v'
												}
											},  
											</c:if>
										</c:if>
										<c:if test="${comUtil.checkCode('1102000')}">
											{
												id: 1102000,
												text : '<s:message code="p_main.tree.maintenance.division"/>',
												iconCls : 'ext-icon-group',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/division/toSearch.do?tag=d'
												}
											},
											{
												id: 1109000,
												text : '客户管理',
												iconCls : 'ext-icon-group',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/division/toSearch.do?tag=c'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1103000')}">
											{
												id: 1103000,
												text : '<s:message code="p_main.tree.maintenance.role"/>',
												iconCls : 'ext-icon-ruby',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/role/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1104000')}">
											{
												id: 1104000,
												text : '权限管理',
												iconCls : 'ext-icon-link',
												attributes : {
													url : '${pageContext.request.contextPath}/maintenance/permission/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1105000')}">
											{
												id: 1105000,
												text : '<s:message code="p_main.tree.admin.action"/>',
												iconCls : 'ext-icon-lightning',
												attributes : {
													url : '${pageContext.request.contextPath}/admin/action/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1106000')}">
											{
												id: 1106000,
												text : '<s:message code="p_main.tree.admin.resource"/>',
												iconCls : 'ext-icon-link',
												attributes : {
													url : '${pageContext.request.contextPath}/admin/resource/toSearch.do'
												}
											},
										</c:if>
										<c:if test="${comUtil.checkCode('1107000')}">
											{
												id: 1107000,
												text : '提示信息',
												iconCls : 'ext-icon-exclamation',
												attributes : {
													url : '${pageContext.request.contextPath}/information/toSearch.do'
												}
												
											},
										</c:if>
											{
												id: 1111000,
												text : '信息管理',
												iconCls : 'ext-icon-file_txt',
												attributes : {
														url : '${pageContext.request.contextPath}/maintenance/userInfo/toSearch.do'
														}
													
											},
											{
												id: 1112000,
												text : '邮件管理',
												iconCls : 'ext-icon-email',
												attributes : {
														url : '${pageContext.request.contextPath}/admin/mail/toSearch.do'
														}
													
											},
											{
												id: 1113000,
												text : '类别管理',
												iconCls : 'ext-icon-bricks',
												attributes : {
														url : '${pageContext.request.contextPath}/maintenance/rbsCategory/toSearch.do'
														}
													
											},
											{
												id: 1114000,
												text : '组管理',
												iconCls : 'ext-icon-bricks',
												attributes : {
														url : '${pageContext.request.contextPath}/maintenance/user2division/toSearchGroups.do'
														}
											},
											{
												id: 1115000,
												text : '货币管理',
												iconCls : 'ext-icon-money_yen',
												attributes : {
														url : '${pageContext.request.contextPath}/maintenance/currency/toSearch.do'
														}
											},
										<c:if test="${comUtil.checkCode('11010000')}">
											{   
												id: 11010000,
												text : '人员报表',
												iconCls : 'ext-icon-chart_bar',
												children : [
													<c:if test="${comUtil.checkCode('11010100')}">
														{
															id: 11010100,
															text : '人员入职表',
															iconCls : 'ext-icon-chart_bar_add',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=EmployEntryAndExit.cpt&__bypagesize__=true&tag=e&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('11010200')}">
														{
															id: 11010200,
															text : '人员离职表',
															iconCls : 'ext-icon-chart_bar_add',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=EmployEntryAndExit.cpt&__bypagesize__=true&tag=d&serverIp=${pageContext.request.contextPath}'
															}
														},
													</c:if>
													<c:if test="${comUtil.checkCode('11010300')}">
														{
															id: 11010300,
															text : '人员保险公积金表',
															iconCls : 'ext-icon-chart_bar_edit',
															attributes : {
																url : '${pageContext.request.contextPath}/ReportServer?reportlet=EmployWelfare.cpt&__bypagesize__=true&serverIp=${pageContext.request.contextPath}'
															}
														}
													</c:if>
												]
											},
											</c:if>											
	
									],
									lines : true,
									onClick : function(node) {
										var url;
										if (node.attributes != undefined && node.attributes.url != undefined) {
											url = node.attributes.url;
										} else {
											return;
										}
										layout_center_addTab({
											id:node.id,
											title : node.text,
											closable : true,
											iconCls : node.iconCls,
											content : '<iframe src="' + url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
										});
									},
									onLoadSuccess:function(node, data){
										var defaultPageCode = '${sessionInfo.defaultPageCode}';
										// 加载菜单										
										if(defaultPageCode != null && defaultPageCode.length > 0){
											var idTemp = defaultPageCode.toString().substr(0,2)
											var idParent = idTemp + '00000';
											var nodeDef = $('#menu' + idParent).tree('find', defaultPageCode);
											$('#menu' + idParent).tree('select', nodeDef.target);
											 layout_center_addTab({
													id : nodeDef.id,
													title : nodeDef.text,
													closable : true,
													iconCls : nodeDef.iconCls,
													//content : '<iframe src="${pageContext.request.contextPath}/order/orderCategoryService/toSearch.do?tagPage=a&typeData=r&tagPageCode=1808400" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>'
													content : '<iframe src="' + nodeDef.attributes.url + '" frameborder="0" style="border:0;width:100%;height:99%;"></iframe>'
											});
											$('#title' +  idParent).prev().children().click();
										} 
									}
								});
							});
						</script>
					</div>
				</c:if>
				<%-- </c:if> --%>
		</div>
	</div>
<%-- </c:if> --%>
	<div data-options="region:'center'" style="overflow: hidden;">
<!-- 	<input id="hid_remarks" type="text" />
	<input id="hid_remarks_link" type="text" /> -->
		<div id="layout_center_tabs" style="overflow: hidden;"></div>
		<div id="layout_center_toolbar">
			<table cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<!-- <td><a class="easyui-linkbutton" plain="true" iconCls="icon-bug-error" onclick="alert('Report a Bug!')"></a></td>-->
						<!-- <td><a class="easyui-linkbutton" plain="true" iconCls="icon-help" onclick="downHelp()"></a></td> -->
						<td><a class="easyui-linkbutton" plain="true" iconCls="icon-reload" onclick="layout_center_refreshTab()"></a></td>
						<td><a class="easyui-linkbutton" plain="true" iconCls="icon-cancel" onclick="layout_center_closeTab()"></a></td>
					</tr>
				</tbody>
			</table>
		</div>
		<div id="layout_center_tabs_contentmenu" style="width: 100px; display: none;">
			<div type="refresh"><s:message code="p_main.tab.contentmenu.refresh" /></div>
			<div class="menu-sep"></div>
			<div type="close"><s:message code="p_main.tab.contentmenu.close" /></div>
			<div type="closeOther"><s:message code="p_main.tab.contentmenu.closeother" /></div>
			<div type="closeAll"><s:message code="p_main.tab.contentmenu.closeall" /></div>
		</div>
	</div>
	<div data-options="region:'south'" style="height: 27px; overflow: hidden;">
		<div class="panel-header panel-header-noborder" style="text-align: center;">
			Copyright &copy;
		</div>
	</div>
</body>
</html>
