package com.mtf.framework.dao;

import java.util.HashMap;

import com.mtf.framework.model.UserProfile;

public interface UserProfileMapper {

	int deleteById(String id);

	int insert(UserProfile record);

	UserProfile selectById(String id);

	int updateById(UserProfile record);

	UserProfile selectByUserId(String userId);

	int countByEmail(String email);

	int countByEmailAndNotId(HashMap<String, Object> param);
}