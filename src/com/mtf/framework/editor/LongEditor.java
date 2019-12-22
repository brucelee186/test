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
package com.mtf.framework.editor;

import java.beans.PropertyEditorSupport;

import org.apache.log4j.Logger;

/**
 * 自定义Long类型属性编辑器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-11-27	Wade.Zhu		created.
 * @version <ver>
 */
public class LongEditor extends PropertyEditorSupport {

	private Logger	logger	= Logger.getLogger(LongEditor.class);

	private boolean	allowNull;

	public LongEditor(boolean allowNull) {
		this.allowNull = allowNull;
	}

	@Override
	public String getAsText() {
		Long i = (Long) getValue();
		if (i == null) {
			return null;
		}
		return i.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Long i = Long.parseLong(text);
			setValue(i);
		} catch (NumberFormatException e) {
			logger.debug(String.format("Failed to parse String '%s' to Long", text));
			if (this.allowNull) {
				setValue(null);
			} else {
				throw new IllegalArgumentException(text);
			}
		}
	}

}
