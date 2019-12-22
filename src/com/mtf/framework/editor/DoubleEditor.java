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
 * 自定义Double类型属性编辑器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class DoubleEditor extends PropertyEditorSupport {

	private Logger	logger	= Logger.getLogger(DoubleEditor.class);

	private boolean	allowNull;

	public DoubleEditor(boolean allowNull) {
		this.allowNull = allowNull;
	}

	@Override
	public String getAsText() {
		Double d = (Double) getValue();
		if (d == null) {
			return null;
		}
		return d.toString();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Double d = Double.parseDouble(text);
			setValue(d);
		}
		catch (NumberFormatException e) {
			logger.warn(String.format("Failed to parse String '%s' to Double", text));
			if (this.allowNull) {
				setValue(null);
			} else {
				throw new IllegalArgumentException(text);
			}
		}
	}

}
