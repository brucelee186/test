package com.mtf.framework.service.impl.common;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.BaseMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.service.common.CommonService;
import com.mtf.framework.util.CommonUtil;

@Service("commonService")
public class CommonServiceImpl implements CommonService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private BaseMapper baseMapper;
	
	public BaseMapper getBaseMapper() {
		return baseMapper;
	}

	public void setBaseMapper(BaseMapper baseMapper) {
		this.baseMapper = baseMapper;
	}

	/**
	 * 以JDBC的方式插入对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	@Override
	public Object insertByQuery(Object object) throws PmException {
		Class<?> clazz = object.getClass();
		Class<?> superClass = clazz.getSuperclass();
		try {
			Field fieldSql = superClass.getDeclaredField("sql");
			fieldSql.setAccessible(true);
			String sql = (String) fieldSql.get(object);
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 以JDBC的方式删除对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	@Override
	public Object deleteByQuery(Object object) throws PmException {
		Class<?> clazz = object.getClass();
		Class<?> superClass = clazz.getSuperclass();
		try {
			Field fieldSql = superClass.getDeclaredField("sql");
			fieldSql.setAccessible(true);
			String sql = (String) fieldSql.get(object);
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 以JDBC的方式更新对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	@Override
	public Object updateByQuery(Object object) throws PmException {
		Class<?> clazz = object.getClass();
		Class<?> superClass = clazz.getSuperclass();
		try {
			Field fieldSql = superClass.getDeclaredField("sql");
			fieldSql.setAccessible(true);
			String sql = (String) fieldSql.get(object);
			jdbcTemplate.execute(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	/**
	 * 以JDBC的方式查询对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	@Override
	public Object selectByQuery(Object object) throws PmException {
		try {
			Class<?> clazz = object.getClass();
			Class<?> superClazz = clazz.getSuperclass();
			Field fieldSql = superClazz.getDeclaredField("sql");
			fieldSql.setAccessible(true);
			String sql = (String) fieldSql.get(object);
			object = jdbcTemplate.query(sql, ParameterizedBeanPropertyRowMapper.newInstance(object.getClass()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * 以JDBC的方式查询单个对象
	 * @param object
	 * @return
	 * @throws PmException
	 */
	@Override
	public Object getByQuery(Object object) throws PmException {
		try {
			Class<?> clazz = object.getClass();
			Class<?> superClazz = clazz.getSuperclass();
			Field fieldSql = superClazz.getDeclaredField("sql");
			fieldSql.setAccessible(true);
			String sql = (String) fieldSql.get(object);
			List<?> listObject = jdbcTemplate.query(sql + " LIMIT 1", ParameterizedBeanPropertyRowMapper.newInstance(object.getClass()));
			if (listObject.size() >= 0) {
				object = listObject.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}
	
	/**
	 * 以JDBC的方式查询JSON对象
	 * @param sql
	 * @return
	 * @throws PmException
	 */
	@Override
	public JSONArray select(String sql) throws PmException {
		JSONArray jsonArray = new JSONArray();
		List<?> list = jdbcTemplate.queryForList(sql);
		if (list.size() >= 1) {
			jsonArray = JSONArray.fromObject(list);
		}
		return jsonArray;
	}

	/**
	 * 以JDBC的方式查询JSON单个对象
	 * @param sql
	 * @return
	 * @throws PmException
	 */
	@Override
	public JSONObject get(String sql) throws PmException {
		JSONObject jsonObject = new JSONObject();
		sql = sql + " LIMIT 1";
		List<?> list = jdbcTemplate.queryForList(sql.toString());
		if (list.size() == 1) {
			JSONArray jsonArray = JSONArray.fromObject(list);
			jsonObject = (JSONObject) jsonArray.get(0);
		}
		return jsonObject;
	}
	/**	
	 * 取得会话基础类
	 * @return
	 */
	public SessionInfo getSessionInfo() {
		SessionInfo sessionInfo = CommonUtil.getSessionInfo();
		return sessionInfo;
	}
	
	/**
	 * 取得用户编号
	 * @return
	 */
	public String getUserId() {
		String userId = this.getSessionInfo().getUserId();
		return userId;
	}
	
	public String getUserName() {
		String userName = this.getSessionInfo().getDisplayName();
		return userName;
	}
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public String getCardNo() {
		User user = this.getSessionInfo().getUser();
		return user.getCardNo();
	}
	
	public String getDivisionId() {
		String divisionId = this.getSessionInfo().getDivisionId();
		return divisionId;
	}
	
	public String getDivisionName() {
		String divisionName = this.getSessionInfo().getDivisionName();
		return divisionName;
	}
	
	public String getIp() {
		String ip = this.getSessionInfo().getIp();
		return ip;
	}

	public String getLastMonth() {
		return this.getSessionInfo().getLastMonth();
	}
	
	/**
	 * 取得本月
	 * @return
	 */
	public String getCurrentMonth() {
		return this.getSessionInfo().getNowMonth();
	}
	
	/**
	 * 取得用户等级
	 * @return
	 */
	public Integer getUserLevel() {
		return this.getSessionInfo().getUserLever();
	}
	
	/**
	 * 取得用户电子邮箱
	 * @return
	 */
	public String getEmail() {
		return this.getSessionInfo().getEmail();
	}
	
}
