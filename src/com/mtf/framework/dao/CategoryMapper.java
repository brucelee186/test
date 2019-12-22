package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.Category;
import com.mtf.framework.model.common.Page;

public interface CategoryMapper {
	int deleteById(Integer id);

	int insert(Category record);

	Category selectById(Integer id);

	int updateById(Category record);

	int count(Category record);

	List<Category> select(@Param("record") Category record, @Param("page") Page page);
}