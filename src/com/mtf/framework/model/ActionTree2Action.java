package com.mtf.framework.model;

public class ActionTree2Action {

	private String	id;

	private String	treeId;

	private String	actionId;

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

	public String getTreeId() {
		return treeId;
	}

	public void setTreeId(String treeId) {
		if (treeId == null || treeId.trim().length() == 0) {
			this.treeId = null;
		} else {
			this.treeId = treeId.trim();
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
}