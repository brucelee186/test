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
 * 自定义String类型属性编辑器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class StringEditor extends PropertyEditorSupport {

	private Logger	logger	= Logger.getLogger(StringEditor.class);

	private boolean	allowNull;

	public StringEditor(boolean allowNull) {
		this.allowNull = allowNull;
	}

	@Override
	public String getAsText() {
		return (String) getValue();
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(allowNull){
			String temp = text == null ? null : text.trim();
			if (temp == null || temp.length() == 0) {
				setValue(null);
			} else {
				setValue(temp);
			}
		}else{
			setValue(text);
		}
	}
}
