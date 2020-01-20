//添加问题

var rowCount = 4;
function addQuestion(){
	var trId = $("#questionListDivId").find("label").last().attr("id");
	var labId = $('#'+trId).html();
	if (undefined == labId){
		var addNumber = new Number(1);
	}else {
		var addNumber = new Number(labId);
		addNumber++;
	}
	var questHtm = $('#singleChoice').html();
	questHtm = questHtm.replace(/XXX/g,addNumber);
	$('#questionListDivId').append(questHtm);
}


//添加选项
	function addSelecter(count){
	rowCount++;
 	var temp = $('#quest'+count).val();
	var chr = $('#divRadio').html();
	var cht = $('#divText').html();
	var chdel = $('#divDel').html();
	//var chdel = '<input type="button" value="删除" onclick="delRow('+count+','+rowCount+')"/>';
 	var chrhtm = '<tr id="'+temp+rowCount+'"><td>'+chr+'</td><td>'+cht+'</td><td>'+chdel+'</td></tr>';
 	chrhtm = chrhtm.replace(/XXX/g, count);
 	chrhtm = chrhtm.replace(/AAA/g, rowCount);
	var trId = $("#questionTable_"+count).find("tr").last().attr("id");
	if(trId == undefined){
		$("#questionTable_"+count).append(chrhtm);	
	}
	$("#"+trId).after(chrhtm); 
	}
	
// 删除选项
	function delRow(count,rowIndex){
	var temp = $('#quest'+count).val();
	var delRowId = temp+rowIndex;
	$("#"+delRowId).remove();  
	}  
	
// 显示基本页面div
	function showBasic(){
		$('#basicInformation').show();
		$('#addQuestion').hide();
		$('#basicInformationPageLink').attr('class','basicInformationPage pitch');
		$('#addQuestionPageLink').attr('class','addQuestionPage');
	}

	// 隐藏基本页面div
	function hideBasic(){
		$('#basicInformation').hide();
		$('#addQuestion').show();
		$('#basicInformationPageLink').attr('class','addQuestionPage');
		$('#addQuestionPageLink').attr('class','basicInformationPage pitch');
	}

	//将选择的默认答案赋值到隐藏控件中
	function radioValue(index,row){
		//根据class来清空
		$('.scsh'+index).val("");
		$('#scsh'+index+'_'+row).val("y");
		
	}
	
	// 删除问题div
	function delDiv(count){
	$("#singleChoice"+count).remove();  
	} 
