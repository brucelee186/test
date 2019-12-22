package com.mtf.framework.model;

public class Action2Resource {

	private String	id;

	private String	actionId;

	private String	resourceId;

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

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		if (actionId == null || actionId.trim().length() == 0) {
			this.actionId = null;
		} else {
			this.actionId = actionId.trim();
		}
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		if (resourceId == null || resourceId.trim().length() == 0) {
			this.resourceId = null;
		} else {
			this.resourceId = resourceId.trim();
		}
	}
}