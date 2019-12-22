package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.common.Page;

public interface RbsCategoryMapper {
	int deleteById(Integer id);

	int insert(RbsCategory record);

	RbsCategory selectById(Integer id);

	int updateById(RbsCategory record);

	int count(RbsCategory record);
	
	int countByName(String name);

	List<RbsCategory> select(@Param("record") RbsCategory record, @Param("page") Page page);
	
	List<RbsCategory> selectForLv1(@Param("record") RbsCategory record);
}