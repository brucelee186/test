<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!-- easyui样式 -->
<link id="easyuiTheme" rel="stylesheet"
	href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css?v=20140516"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/themes/icon.css"
	type="text/css"></link>

<!-- 服务器路径 -->
<script type="text/javascript" charset="utf-8">
	var contextPath = '${pageContext.request.contextPath}';
</script>

<!-- jquery脚本 -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-1.8.0.min.js?v=20140516" charset="utf-8"></script> --%>

<!-- easyui脚本 -->
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/jquery.min.js?v=20151104" charset="utf-8"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/jquery.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/jquery.easyui.min.js?v=20150429"
	charset="utf-8"></script>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/jquery.easyui.patch.js?v=20140909" charset="utf-8"></script> --%>


<c:if
	test="${cookie.userLocale.value == 'zh' or cookie.userLocale.value == 'zh_CN'}">
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js?v=20140516"
		charset="utf-8"></script>
</c:if>


<!-- cookie插件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/jquery.cookie.js?v=20140516"
	charset="utf-8"></script>


<!-- print插件 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/jquery.jqprint-0.3.js?v=20140516"
	charset="utf-8"></script>


<!-- 自己定义的样式和JS扩展 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/csslib/mtf-css.css?v=20140515"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/csslib/mtf-icons.css?v=20140516"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/csslib/mtf-exticons.css?v=20150113"
	type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/jslib/commonUtil.js?v=20150723"
	charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-util.js?v=20150210" charset="utf-8"></script>

<!-- easyui textarea bug fix when IE -->
<style type="text/css">
/* .textbox .textbox-text { */
/*   white-space: normal; */
/* } */
</style>
<!-- 国际化 -->
<c:if
	test="${cookie.userLocale.value == 'zh' or cookie.userLocale.value == 'zh_CN'}">
	<script type="text/javascript">
		$.fn.panel.defaults.loadingMessage = '加载中...';
		$.fn.datagrid.defaults.loadMsg = '加载中...';
		$.fn.treegrid.defaults.loadMsg = '加载中...';
		errorTitle = '错误';
		networkError = '网络错误';
		notMatch = '输入值不一致';
		intRange_invalid = '必须为数字';
		intRange_min = '最小值为 {0}';
		intRange_max = '最大值为 {1}';
		intRange_minmax = '输入值必须介于{0}和{1}之间';
		dateRange_min = '最小日期为 {0}';
		dateRange_max = '最大日期为 {0}';
		dateRange_minmax = '日期必须介于 {0}和{1}之间';
	</script>
</c:if>
<jsp:useBean id="comUtil" class="com.mtf.framework.util.CommonUtil"
	scope="application" />
