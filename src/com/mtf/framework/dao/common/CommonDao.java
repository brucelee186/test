package com.mtf.framework.dao.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.model.common.DataGrid;

public interface CommonDao {
	
	Object handleByQuery(CommonModel commonModel) throws PmException;
	
	Object insert(CommonModel commonModel) throws PmException;
	
	DataGrid<Object> select(CommonModel commonModel) throws PmException;
	
	Object get(CommonModel commonModel) throws PmException;
	
	int update(CommonModel commonModel) throws PmException;
	
	int delete(CommonModel commonModel) throws PmException;
	
	Object handleByQuery(String sql) throws PmException;
	
	Object insert(String sql) throws PmException;
	
	JSONArray select(String sql) throws PmException;
	
	JSONObject get(String sql) throws PmException;
	
	int update(String sql) throws PmException;
	
	int delete(String sql) throws PmException;
}
