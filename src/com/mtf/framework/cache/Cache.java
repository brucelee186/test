package com.mtf.framework.cache;

public class Cache {

	private String	key;		// 缓存ID
	private Object	value;		// 缓存数据
	private long	timeOut;	// 更新时间

	public Cache() {
		super();
	}

	public Cache(String key, Object value, long timeOut) {
		this.key = key;
		this.value = value;
		this.timeOut = timeOut;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}

	public void setTimeOutAfter(long after) {
		this.timeOut = System.currentTimeMillis() + timeOut;
	}

}