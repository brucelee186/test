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

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

/**
 * 分页表单基类
 * 
 * @author Wade.Zhu
 * @version 1.0 2013-4-25 Wade.Zhu created.
 * @version <ver>
 */
public class Page implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private int					page;
	private int					rows;
	private String				sort;
	private String				order;
	private String				orderBy;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		String temp = sort == null ? null : sort.trim();
		if (temp == null) {
			this.sort = null;
		} else {
			this.sort = temp;
		}
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		String temp = order == null ? null : order.trim();
		if (temp == null) {
			this.order = null;
		} else {
			this.order = temp;
		}
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public void generateOrderBy(HashMap<String, String> map) {
		this.orderBy = null;
		if (StringUtils.isBlank(this.sort)) {
			// do nothing
		} else {
			StringBuilder sb = new StringBuilder();
			String[] sorts = this.sort.split(",");
			String[] orders = this.order.split(",");

			for (int i = 0; i < sorts.length; i++) {
				String col = map.get(sorts[i]);
				if (col == null) {
					continue;
				}
				sb.append(col);

				if (i < orders.length) {
					if ("desc".equalsIgnoreCase(orders[i])) {
						sb.append(" DESC, ");
					} else {
						sb.append(" ASC, ");
					}
				} else {
					sb.append(" ASC, ");
				}
			}
			if (sb.length() > 0) {
				this.orderBy = sb.substring(0, sb.length() - 2);
			}

		}
	}

	public int getStartIndex() {
		int startIndex = (this.page - 1) * this.rows;
		if (startIndex < 0) startIndex = 0;
		return startIndex;
	}
}
