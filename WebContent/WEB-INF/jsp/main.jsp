<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page import="com.mtf.framework.util.CommonUtil"%>
<jsp:useBean id="comUtil" class="com.mtf.framework.util.CommonUtil" scope="page" />
<!DOCTYPE HTML>
<html>
<head>
<title>HOME</title>
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
	<div data-options="region:'west',split:true,title:'HOME'" style="width: 200px; overflow: hidden;">
		<div id="div_accordion" class="easyui-accordion" data-options="fit:true,border:false">
		<%-- <c:if test="${sessionInfo.userLever == '0' || sessionInfo.userLever == '1' || sessionInfo.userLever == '2' || sessionInfo.userLever == '3' || sessionInfo.userLever == '4' || sessionInfo.userLever == '5' || sessionInfo.userLever == '6' || sessionInfo.userLever == '7'}"> --%>
			<c:if test="${comUtil.checkCode('1200000')}">
					<div id="title1200000" title="家居管理">
						<ul id="menu1200000"></ul>
						<script type="text/javascript" charset="utf-8">
						$(function() {
							$('#menu1200000').tree({
								data : [
											// 主菜单 申请
												{
													text : '硬件',
													iconCls : 'ext-icon-attach',
													children : [
														// 子菜单 申请
															{
																
																id: 1201000,
																text : '电表',
																iconCls : 'ext-icon-basket',
																attributes : {
																	url : '${pageContext.request.contextPath}/maintenance/electricityMeter/toSearch.do'
																}
															},
													]
												},
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
					<div title="系统管理" id="title1100000">
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
