/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.model.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 用于支持easyui的DataGrid
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version 1.1	2014-4-23	Bill.Qi		created.
 * @version <ver>
 */
public class DataGrid<T> implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private int					total				= 0;
	private List<T>				rows				= new ArrayList<T>();
	private List<Map<String,String>>				footer				= new ArrayList<Map<String,String>>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	
	public List<Map<String, String>> getFooter() {
		return footer;
	}

	
	public void setFooter(List<Map<String, String>> footer) {
		this.footer = footer;
	}

	
}
