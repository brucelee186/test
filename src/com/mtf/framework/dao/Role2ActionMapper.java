package com.mtf.framework.dao;

import java.util.HashMap;

import com.mtf.framework.model.Role2Action;

public interface Role2ActionMapper {

	int deleteById(String id);

	int insert(Role2Action record);

	Role2Action selectById(String id);

	int updateById(Role2Action record);

	int countByActionIdAndRoleIds(HashMap<String, Object> param);

	int deleteByActionId(String actionId);

	void deleteByRoleId(String roleId);
}