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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import com.mtf.framework.util.ConfigUtil;

/**
 * 自定义Date类型属性编辑器
 *
 * @author Wade.Zhu
 * @version 1.0	2013-04-25	Wade.Zhu		created.
 * @version 1.1	2013-06-24	Wade.Zhu		default format = UtilConfig.getDateTimeFormatString()
 * @version <ver>
 */
public class DateEditor extends PropertyEditorSupport {

	private Logger	logger	= Logger.getLogger(DateEditor.class);

	private String	dateFormat;
	private String	dateTimeFormat;
	private boolean	allowNull;

	public DateEditor(String dateFormat, String dateTimeFormat, boolean allowNull) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;
		this.allowNull = allowNull;
	}
	public DateEditor(boolean allowNull) {
		this.dateFormat = ConfigUtil.getDateFormatString();
		this.dateTimeFormat = ConfigUtil.getDateTimeFormatString();
		this.allowNull = allowNull;
	}
	public DateEditor(String dateFormat, String dateTimeFormat) {
		this.dateFormat = dateFormat;
		this.dateTimeFormat = dateTimeFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}
	
	public void setAllowNull(boolean allowNull) {
		this.allowNull = allowNull;
	}

	@Override
	public String getAsText() {
		Date date = (Date) getValue();
		String text = new SimpleDateFormat(this.dateTimeFormat).format(date);
		return text;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Date date = new SimpleDateFormat(text.contains(" ") ? this.dateTimeFormat : this.dateFormat).parse(text);
			setValue(date);
		} catch (ParseException e) {
			logger.debug(String.format("Failed to parse String '%s' to Date", text));
			if (this.allowNull) {
				setValue(null);
			} else {
				throw new IllegalArgumentException(text);
			}
		}
	}

}
