var mtfDetailGridGenerator = {
	generate : function(datagrid, groupRow, groupIndex) {
		var datagridId = datagrid.id;
		detailGrid = $(datagrid).datagrid('options').detailGrid;
		
		var divCss = '';
		if(detailGrid.width){
			divCss = 'width:' + detailGrid.width + 'px;';
		} else {
			divCss += 'width: 100%;';
		}
		if(detailGrid.borderCss){
			divCss += detailGrid.borderCss;
		}
		
		var html = '<div class="panel-body" style="overflow:auto;' + divCss + '">'; 
		html += '<table style="width:100%;" groupIndex="' + groupIndex + '" class="datagrid-body mtfdetailgrid" border="0" cellspacing="0" cellpadding="0">';
		
		//生成列头
		html += '<tr class="datagrid-header datagrid-header-row" style="border-color:gray; border">';
		for(var columnIndex=0; columnIndex < detailGrid.columns.length; columnIndex++) {
			html += this.genHeaderCell(detailGrid.columns[columnIndex], datagridId, groupIndex);
		}
		html += '</tr>';
		
		//取detail数据列表
		var detailRows = groupRow[detailGrid.dataField];
		//生成数据行
		if(detailRows != null && detailRows.length > 0) {
			for(var detailIndex=0; detailIndex < detailRows.length; detailIndex++) {
				var detailRow = detailRows[detailIndex];
				var style = '';
				if(detailGrid.rowStyler instanceof Function){
					style = detailGrid.rowStyler(detailIndex, detailRow);
					if(!style){
						style = '';
					}
				}
				html += '<tr class="datagrid-row" style="' + style +'" detailIndex="' + detailIndex + '" >';
				for(var columnIndex=0; columnIndex < detailGrid.columns.length; columnIndex++) {
					html += this.genCell(detailGrid.columns[columnIndex], datagridId, groupRow, groupIndex, detailRow, detailIndex);
				}
				html += '</tr>';
			}
		}
		
		html += '</table>';
		html += '</div>'
		return html;
	},
	genHeaderCell : function(option, datagridId, groupIndex){
		var cell = '<td class="datagrid-cell" style="';
		cell += this.genThCss(option);
		cell += '">';
		
		cell += '<span style="';
		cell += this.genSpanCss(option);
		cell += '">';
		
		if(option.checkbox) {
			if(!option.singleSelect){
				cell += '<input class="mtfdetailgrid-header-checkbox" type="checkbox" groupIndex="' + groupIndex + '" onclick="mtfDetailGridGenerator.headerCheckboxClick(this,\'' + datagridId + '\', ' + option.exclusive + ')"></input>'
			}
		} else if(option.title != undefined && option.title != null) {
			cell += option.title;
		}
		
		cell += '</span></td>';
		
		return cell;
	},
	genCell : function(option, datagridId, groupRow, groupIndex, detailRow, detailIndex){
		var cellValue = detailRow[option.field];
		var formatCellValue = cellValue;
		if(option.checkbox) {
			formatCellValue = '<input class="mtfdetailgrid-checkbox" type="checkbox" value="' + detailRow[option.field] + '" detailIndex="' + detailIndex + '" groupIndex="' + groupIndex + '" onclick="mtfDetailGridGenerator.checkboxClick(this,\'' + datagridId + '\', ' + option.exclusive + ', ' + option.singleSelect + ')"></input>'
		} else if (option.formatter instanceof Function) {
			formatCellValue = option.formatter(cellValue, detailRow, detailIndex, groupRow, groupIndex);
		} 
		
		if(formatCellValue == null || formatCellValue == undefined) {
			formatCellValue = '';
		}
		
		var cell = '<td class="datagrid-cell" style="';
		cell += this.genTdCss(option, cellValue, detailRow, detailIndex, groupRow, groupIndex);
		cell += '">';
		
		cell += '<span style="';
		cell += this.genSpanCss(option);
		cell += '" ';
		if(option.tooltip){
			cell += 'title="' + htmlEncode(formatCellValue) + '"';
		}
		cell += '>';
		
		cell += formatCellValue;
		cell += '</span></td>';
		
		return cell;
	},
	genThCss : function(option) {
		//生成css
		var css = '';
		if(option.width != undefined) {
			css += 'width:' + option.width + 'px;';
		}
		if(option.align != undefined) {
			css += 'text-align:' + option.align + ';';
		}
		
		return css;
	},
	genTdCss : function(option, cellValue, detailRow, detailIndex, groupRow, groupIndex) {
		//生成css
		var css = '';
		if(option.width != undefined) {
			css += 'width:' + option.width + 'px;';
		}
		if(option.align != undefined) {
			css += 'text-align:' + option.align + ';';
		}
		
		if(option.styler instanceof Function) {
			css += option.styler(cellValue, detailRow, detailIndex, groupRow, groupIndex);
		}
		
		return css;
	},
	genSpanCss :function(option){
		var css = '';
		if(option.width != undefined) {
			css += 'width:' + (option.width - 6) + 'px;';
		}
		if(option.align != undefined) {
			css += 'text-align:' + option.align + ';';
		}
		
		css += 'margin:0 3px 0 3px; display:block;'
		return css;
	},
	headerCheckboxClick : function (el, datagridId, exclusive) {
		var groupIndex = $(el).attr('groupIndex');
		var value = $(el).prop('checked');
		
		$($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex="' + groupIndex + '"] .mtfdetailgrid-checkbox').prop('checked', value);
		
		if(exclusive) {
			$($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex!="' + groupIndex + '"] .mtfdetailgrid-checkbox').prop('checked', false);
			$($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex!="' + groupIndex + '"] .mtfdetailgrid-header-checkbox').prop('checked', false);
		}
	},
	checkboxClick : function(el, datagridId, exclusive, singleSelect) {
		if(singleSelect) {
			var checked = $(el).prop('checked');
			if(checked){
				var all = $($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid .mtfdetailgrid-checkbox');
				$(all).prop('checked', false);
				$(el).prop('checked', true);
			}
			
			return;
		}
		
		var groupIndex = $(el).attr('groupIndex');
		var headerCheckbox = $($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex="' + groupIndex + '"] .mtfdetailgrid-header-checkbox');
		var cellCheckBoxes = $($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex="' + groupIndex + '"] .mtfdetailgrid-checkbox');
		
		var allChecked = true;
		for(var i = 0; i < cellCheckBoxes.length; i++) {
			if($(cellCheckBoxes[i]).prop('checked') == false) {
				allChecked = false;
				break;
			}
		}
		
		$(headerCheckbox).prop('checked', allChecked);
		
		if(exclusive) {
			$($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex!="' + groupIndex + '"] .mtfdetailgrid-checkbox').prop('checked', false);
			$($('#' + datagridId)[0].parentElement).find('.mtfdetailgrid[groupIndex!="' + groupIndex + '"] .mtfdetailgrid-header-checkbox').prop('checked', false);
		}
	}
}
$.extend($.fn.datagrid.methods, {
	getDetailChecked:function(sender,params){
		var groupRows = sender.datagrid('getRows');
		var detailDataField = sender.datagrid('options').detailGrid.dataField;
		
		var values = [];
		var ceckboxes = $(sender[0].parentElement).find('.mtfdetailgrid-checkbox:checked');
		for(var i = 0; i < ceckboxes.length; i++) {
			var groupIndex = $(ceckboxes[i]).attr('groupIndex');
			var detailIndex = $(ceckboxes[i]).attr('detailIndex');
			var detailRow = groupRows[groupIndex][detailDataField][detailIndex];
			values.push(detailRow);
		}
		
		return values;
	},
	getDetailCheckedValues:function(sender,params){
		var ceckboxes = $(sender[0].parentElement).find('.mtfdetailgrid-checkbox:checked');
		var values = [];
		for(var i = 0; i < ceckboxes.length; i++) {
			values.push($(ceckboxes[i]).val());
		}
		
		return values;
	},
	getDetailRow:function(sender,params){
		var groupIndex = params.groupIndex;
		var detailIndex = params.detailIndex;
		
		var groupRows = sender.datagrid('getRows');
		var detailDataField = sender.datagrid('options').detailGrid.dataField;
		
		var detailRow = groupRows[groupIndex][detailDataField][detailIndex];
		
		return detailRow;
	}
});
