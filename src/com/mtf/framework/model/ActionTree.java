package com.mtf.framework.model;

public class ActionTree {

	private String	id;

	private String	name;

	private String	pid;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		if (id == null || id.trim().length() == 0) {
			this.id = null;
		} else {
			this.id = id.trim();
		}
	}

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

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		if (pid == null || pid.trim().length() == 0) {
			this.pid = null;
		} else {
			this.pid = pid.trim();
		}
	}
}