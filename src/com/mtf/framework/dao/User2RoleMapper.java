package com.mtf.framework.dao;

import com.mtf.framework.model.User2Role;

public interface User2RoleMapper {

	int deleteById(String id);

	int insert(User2Role record);

	User2Role selectById(String id);
	
	User2Role selectMainRole(String userId);

	int updateById(User2Role record);

	void deleteByUserId(String userId);

	void deleteByRoleId(String roleId);
}