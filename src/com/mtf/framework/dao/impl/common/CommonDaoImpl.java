package com.mtf.framework.dao.impl.common;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.BaseMapper;
import com.mtf.framework.dao.common.CommonDao;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.CommonModel;
import com.mtf.framework.model.common.DataGrid;

@Service("CommonDaoImpl")
public class CommonDaoImpl implements CommonDao {
	
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

	@Override
	public Object handleByQuery(CommonModel commonModel) {
		return null;
	}

	@Override
	public Object insert(CommonModel commonModel) throws PmException {
		return null;
	}

	@Override
	public DataGrid<Object> select(CommonModel commonModel) throws PmException {
		return null;
	}

	@Override
	public Object get(CommonModel commonModel) throws PmException {
		return null;
	}

	@Override
	public int update(CommonModel commonModel) throws PmException {
		return 0;
	}

	@Override
	public int delete(CommonModel commonModel) throws PmException {
		return 0;
	}

	@Override
	public Object handleByQuery(String sql) throws PmException {
		return null;
	}

	@Override
	public Object insert(String sql) throws PmException {
		return null;
	}

	@Override
	public JSONArray select(String sql) throws PmException {
		JSONArray jsonArray = new JSONArray();
		List<?> list = jdbcTemplate.queryForList(sql);
		if (list.size() >= 1) {
			jsonArray = JSONArray.fromObject(list);
		}
		return jsonArray;
	}

	@Override
	public JSONObject get(String sql) throws PmException {
		JSONObject jsonObject = new JSONObject();
		sql = sql + " limit 1";
		List<?> list = jdbcTemplate.queryForList(sql.toString());
		if (list.size() == 1) {
			JSONArray jsonArray = JSONArray.fromObject(list);
			jsonObject = (JSONObject) jsonArray.get(0);
		}
		return jsonObject;
	}

	@Override
	public int update(String sql) throws PmException {
		return 0;
	}

	@Override
	public int delete(String sql) throws PmException {
		return 0;
	}

}
