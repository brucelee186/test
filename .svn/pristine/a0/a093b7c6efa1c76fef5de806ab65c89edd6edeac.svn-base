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
package com.mtf.framework.model.page;

import com.mtf.framework.model.common.PageForm;

/**
 * 资源搜索FormBean
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class ResourceSearchForm extends PageForm implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private String				name;
	private String				uri;
	private Integer				level;
	private Integer				access;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name == null || name.trim().length() == 0) {
			this.name = null;
		} else {
			this.name = name.trim();
		}
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		if (uri == null || uri.trim().length() == 0) {
			this.uri = null;
		} else {
			this.uri = uri.trim();
		}
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}
}
