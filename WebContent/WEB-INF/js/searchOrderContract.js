$(function() {
});

var $span = $('.fr-checkbox-checkon');  //定义选中的复选框 
alert($span)
var darray = []; 
var $tds = $("td").has($span);   //定义选中复选框的单元格 
alert($tds)
for (var i = 0, len = $tds.length; i < len; i ++) {    //遍历选中的单元格
     var id = $($tds[i]).attr("id");   
     
     //给选中的单元格加上id的属性
     if (id) {
      darray.push(id);     //将选中的id放入到数组中
     }
}
contentPane.deleteReportRC(null,darray); //第二个参数为批量删除的选中行
contentPane.writeReport(); ; 