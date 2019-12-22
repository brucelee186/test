package com.mtf.framework.util;


import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;


public class PoiRepeater implements Comparable<PoiRepeater>{
		private int startRowIndex;
		private int endRowIndex;
		private String className;
		private List<PoiRepeaterItem> items;
		
		private PoiRepeater(){}
		public PoiRepeater(Cell cell, String className){
			startRowIndex = cell.getRowIndex();
			endRowIndex = startRowIndex;
			this.className = className;
			
			items = new ArrayList<>();
		}
		public int getStartRowIndex() {
			return startRowIndex;
		}
		public int getEndRowIndex() {
			return endRowIndex;
		}
		public int getRows(){
			return endRowIndex - startRowIndex + 1;
		}
		public String getClassName() {
			return className;
		}
		public List<PoiRepeaterItem> getItems() {
			return items;
		}
		
		public void AddItem(Cell cell, String propertyName){
			int rowIndex = cell.getRowIndex();
			if(rowIndex > endRowIndex){
				endRowIndex = rowIndex;
			}
			
			PoiRepeaterItem item = new PoiRepeaterItem(cell.getRowIndex() - startRowIndex, cell.getColumnIndex(), propertyName);
			items.add(item);
		}

		@Override
		public int compareTo(PoiRepeater obj) {
			if(obj.getStartRowIndex() > this.startRowIndex){
				return -1;
			}else if(obj.getStartRowIndex() < this.startRowIndex){
				return 1;
			}
			
			return 0;
		}
	}
	
	class PoiRepeaterItem{
		private int rowNum;
		private int columnNum;
		private String propertyName;
		
		private PoiRepeaterItem(){}
		public PoiRepeaterItem(int rowNum, int columnNum, String propertyName){
			this.rowNum = rowNum;
			this.columnNum = columnNum;
			this.propertyName = propertyName;
		}
		
		public int getRowNum() {
			return rowNum;
		}
		
		public int getColumnNum() {
			return columnNum;
		}
		
		public String getPropertyName() {
			return propertyName;
		}
	}
