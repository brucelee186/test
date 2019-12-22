<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jslib/jquery-1.7.js?v=20140516" charset="utf-8"></script>

<script type="text/javascript">
function test() {
    $.ajax({  
        url:'json2.action',  
        type:'POST',  
        dataType:'json',  
        success:function (data) {  
            $('#font_temperature').text(data.temperature);
            $('#font_humidity').text(data.humidity);
            $('#font_date').text('(' + data.dateStr　+ ')');
        }  
    });  
} 

setInterval("test()","1000");
</script>
<html>
<script type="text/javascript">

	var url = webPath+ "admin/department!pagination.htm?department.parent_code="+ departId;
    	$.ajax({
    		async:false,
    		url:url,
    		success:function(data){
    			$("#div").html(data);
    			regFromEvent();
    			GHRJ_closeBg();
    			//设置选中父节点
    			setSelectNode(departId);
    		}
    	});
</script>
  <head>
    <title>欢迎</title>
  </head>
  <body>
    <!-- <font color="blue" size="10">当前温湿度</font> -->
    <font color="blue" size="10">Temperature and Humidity</font>
    <font color="blue" size="10" id="font_date"></font>
    <table>
    	<tr>
    		<td>
    			<!-- <font color="" size="10">温度:</font> -->
    			<font color="" size="10">Temperature:</font>
    		</td>
    		<td>
	    		<font color="red" size="10" id="font_temperature"></font><br>
    		</td>
    	</tr>
    	<tr>
    		<td>
	    		<!-- <font color="" size="10">湿度:</font> -->
	    		<font color="" size="10">Humidity:</font>
    		</td>
    		<td>
	    		<font color="green" size="10" id="font_humidity"></font><br>
    		</td>
    	</tr>
    	<!-- <tr>
    		<td><input id="msg" type="button" onclick="test()" /></td>
    	</tr> -->
    </table>
    
	
  </body>
</html>