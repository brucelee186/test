package com.mtf.framework.service.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.SessionInfo;

public interface CommonService {
	
	/**
	 * 以JDBC的方式插入对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	Object insertByQuery(Object object) throws PmException;
	
	/**
	 * 以JDBC的方式删除对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	Object deleteByQuery(Object object) throws PmException;
	
	/**
	 * 以JDBC的方式更新对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	Object updateByQuery(Object object) throws PmException;
	
	/**
	 * 以JDBC的方式查询对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	Object selectByQuery(Object object) throws PmException;
	
	/**
	 * 以JDBC的方式查询单个对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	Object getByQuery(Object object) throws PmException;
	
	/**
	 * 以JDBC的方式查询JSON对象
	 * @param sql
	 * @return
	 * @throws PmException
	 */
	JSONArray select(String sql) throws PmException;
	
	
	/**
	 * 以JDBC的方式查询JSON单个对象
	 * @param sql
	 * @return
	 * @throws PmException
	 */
	JSONObject get(String sql) throws PmException;
	
	/**	
	 * 取得会话基础类
	 * @return
	 */
	public SessionInfo getSessionInfo();
	
	/**
	 * 取得用户编号
	 * @return
	 */
	public String getUserId();
	
	public String getUserName();
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public String getCardNo();
	
	public String getDivisionId();
	
	public String getDivisionName();
	
	public String getIp();
	public String getLastMonth();
	
	/**
	 * 取得本月
	 * @return
	 */
	public String getCurrentMonth();
	
	/**
	 * 取得用户等级
	 * @return
	 */
	public Integer getUserLevel();
}
