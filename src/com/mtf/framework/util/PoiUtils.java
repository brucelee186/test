package com.mtf.framework.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class PoiUtils {

	public static void fillTemplate(Sheet sheet, Map<String, Object> data) {
		Map<String, PoiRepeater> repeaterMap = new HashMap<>();
		Stack<PoiRepeater> repeaters = new Stack<>();
		
		//遍历所有row
		for (Iterator<Row> rowIterator = sheet.rowIterator(); rowIterator.hasNext();) {
			Row row = (Row) rowIterator.next();
			
			//遍历Row的所有Cell
			for (Iterator<Cell> cellIterator = row.cellIterator(); cellIterator.hasNext();) {
				Cell cell = (Cell) cellIterator.next();
				String cellValue = cell.toString();
				
				//判断Cell值是不是${}变量
				if (cellValue.indexOf("${") >= 0) {
					boolean isReplace = false;
					
					//遍历Map，找到${}变量对应的值，设置到Cell
					for (Iterator<Entry<String, Object>> dataIterator = data.entrySet().iterator(); dataIterator.hasNext();) {
						Entry<String, Object> entry = dataIterator.next();
						String variable = "${" + entry.getKey() + "}";
						
						if(cellValue.equals(variable)){
							setCellValue(cell, entry.getValue());
							break;
						}else if(cellValue.indexOf(variable) >= 0){
							cellValue = cellValue.replace(variable, entry.getValue()==null?"":entry.getValue().toString());
							isReplace = true;
						}
					}
					
					if(isReplace){
						setCellValue(cell, cellValue);
					}
				} else if (cellValue.startsWith("#{") && cellValue.endsWith("}")) {
					String[] strs = cellValue.substring(2, cellValue.length() - 1).split("\\.");
					if (strs == null || strs.length != 2) {
						continue;
					}

					PoiRepeater repeater = repeaterMap.get(strs[0]);
					if (repeater == null) {
						repeater = new PoiRepeater(cell, strs[0]);
						repeaterMap.put(strs[0], repeater);
						repeaters.push(repeater);
					}

					repeater.AddItem(cell, strs[1]);
				}
			}

		}

		//自下至上，填充数据
		while (!repeaters.empty()) {
			PoiRepeater repeater = repeaters.pop();
			
			//获取数据列表
			Object obj = data.get(repeater.getClassName());
			if(obj instanceof List == false){
				continue;
			}
			
			//遍历列表数据
			List list = (List)obj;
			for (int i = 0; i < list.size(); i++) {
				obj = list.get(i);
				if(obj instanceof Map == false){
					break;
				}
				Map entity = (Map)obj;
				
				//插入Row
				if(i > 0){
					for (int j = 0; j < repeater.getRows(); j++) {
						Row templateRow = sheet.getRow(repeater.getStartRowIndex() + j);
						
						int rowIndex = repeater.getStartRowIndex() + i* repeater.getRows() + j;
						int lastRowNum = sheet.getLastRowNum();
						
						if(rowIndex <= lastRowNum) {
							sheet.shiftRows(rowIndex, lastRowNum, 1, true, false);
						}
						Row newRow = sheet.createRow(rowIndex);
						newRow.setHeight(templateRow.getHeight());
						
						//copy style
						int cellcount = 0;
						for (Iterator<Cell> cellIterator = templateRow.cellIterator(); cellIterator.hasNext();) {
							Cell cellTemplate = (Cell) cellIterator.next();
							Cell cell = newRow.createCell(cellcount);
							cell.setCellStyle(cellTemplate.getCellStyle());
							cellcount++;
						}
					}
				}
				
				//填充数据
				List<PoiRepeaterItem> items =repeater.getItems();
				for (PoiRepeaterItem poiRepeaterItem : items) {
					Row row = sheet.getRow((repeater.getStartRowIndex() + poiRepeaterItem.getRowNum()) + i * repeater.getRows());
					Cell cell = row.getCell(poiRepeaterItem.getColumnNum());
					setCellValue(cell, entity.get(poiRepeaterItem.getPropertyName()));
				}
			}
		}
	}
	
	public static void setCellValue(Cell cell, Object value){
		if(value == null){
			cell.setCellValue("");
			return;
		}

		if(value instanceof Date){
			cell.setCellValue((Date)value);
		}else if(value instanceof Integer){
			cell.setCellValue((Integer)value);
		}else if(value instanceof Long){
			cell.setCellValue((Long)value);
		}else if(value instanceof Double){
			cell.setCellValue((Double)value);
		}else if(value instanceof Boolean){
			cell.setCellValue((Boolean)value);
		}else if(value instanceof Calendar){
			cell.setCellValue((Calendar)value);
		}else{
			cell.setCellValue(value.toString());
		}
	}
}
