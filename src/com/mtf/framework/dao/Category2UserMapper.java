package com.mtf.framework.dao;

import com.mtf.framework.model.Category2User;


public interface Category2UserMapper {

	int insert(Category2User record);
	
	int deleteById(String id);
	
	int deleteByCategoryId(int categoryId);
}