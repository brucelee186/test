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

/**
 * 通用消息bean
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class Message implements java.io.Serializable {

	private static final long	serialVersionUID	= 1L;

	private int					code				= 0;
	private String				key					= null;
	private String				msg					= null;
	private Object				obj					= null;

	public Message() {}
	
	public Message(String msg) {
		this(0, null, msg, null);
	}
	
	public Message(int code, String msg) {
		this(code, null, msg, null);
	}
	
	public Message(String key, String msg) {
		this(0, key, msg, null);
	}
	
	public Message(int code, String key, String msg) {
		this(code, key, msg, null);
	}
	
	public Message(int code, String key, String msg, Object obj) {
		this.code = code;
		this.key = key;
		this.msg = msg;
		this.obj = obj;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
}
