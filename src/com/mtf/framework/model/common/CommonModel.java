package com.mtf.framework.model.common;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;


public class CommonModel extends PageForm {
	private static final long serialVersionUID = 5540399961952105715L;

	// 审批状态(ap1:一级,ap2:二级,ap3:三级)
	private String approveStatus;
	// 编辑状态(增:i,删:d,改:u,查:s,提交:su(submit), 审批:a,驳回 ：r ,预览：p
	private String editState;
	// 原始修改时间(防并发)
	private Long original;
	// 备用字段1
	private String field1;
	// 备用字段2
	private String field2;
	
	// 备用字段3
	private int field3;
	// 备用列表1
	private List<?>	listBack1;
	
	private Map<String, String> mapStr;
	// 查询语句
	private String sql;
	// 用户编号
	private String userId;
	// 类对象
	private Object object;
	// 页面路径
	private String viewPath;
	// IP
	private String serverIp;
	// String类型编号
	private String idString;
	// 开始查询时间
	private String searchDateStart;
	// 结束查询时间
	private String searchDateEnd;
	// 更新条件标记
	private String tagUpdate;
	// 查询条件标记
	private String tagMapper;
	
	// 页面编码
	private String tagPageCode;
	
	
	public String getTagMapper() {
		return tagMapper;
	}
	public void setTagMapper(String tagMapper) {
		this.tagMapper = tagMapper;
	}
	public String getTagPageCode() {
		return tagPageCode;
	}
	public void setTagPageCode(String tagPageCode) {
		this.tagPageCode = tagPageCode;
	}
	public String getTagUpdate() {
		return tagUpdate;
	}
	public void setTagUpdate(String tagUpdate) {
		this.tagUpdate = tagUpdate;
	}
	public Json getJson() {
		return json;
	}
	public void setJson(Json json) {
		this.json = json;
	}

	// 前台 json数组字符串(JSON.stringify)
	private String jsonListString;
	
	// 单独更新判断条件 
	private String judgeUpdate;
	
	// 共同json对象
	private Json json;
	
	public String getJudgeUpdate() {
		return judgeUpdate;
	}
	public void setJudgeUpdate(String judgeUpdate) {
		this.judgeUpdate = judgeUpdate;
	}
	public String getApproveStatus() {
		return approveStatus;
	}
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus;
	}
	public String getJsonListString() {
		return jsonListString;
	}
	public void setJsonListString(String jsonListString) {
		this.jsonListString = jsonListString;
	}
	public String getSearchDateStart() {
		return searchDateStart;
	}
	public void setSearchDateStart(String searchDateStart) {
		this.searchDateStart = searchDateStart;
	}
	public String getSearchDateEnd() {
		return searchDateEnd;
	}
	public void setSearchDateEnd(String searchDateEnd) {
		this.searchDateEnd = searchDateEnd;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getServerIp() {
		return serverIp;
	}
	public void setServerIp(String serverIp) {
		this.serverIp = serverIp;
	}
	public String getViewPath() {
		return viewPath;
	}
	public void setViewPath(String viewPath) {
		this.viewPath = viewPath;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEditState() {
		return editState;
	}
	public void setEditState(String editState) {
		this.editState = editState;
	}
	public Long getOriginal() {
		return original;
	}
	public void setOriginal(Long original) {
		this.original = original;
	}
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
	public List<?> getListBack1() {
		return listBack1;
	}
	public void setListBack1(List<?> listBack1) {
		this.listBack1 = listBack1;
	}
	public String getSql() {
		return sql;
	}
	public void setSql(String sql) {
		this.sql = sql;
	}
	
	public Map<String, String> getMapStr() {
		return mapStr;
	}
	
	public void setMapStr(Map<String, String> mapStr) {
		this.mapStr = mapStr;
	}
	
	public int getField3() {
		return field3;
	}
	
	public void setField3(int field3) {
		this.field3 = field3;
	}
	
	

}
