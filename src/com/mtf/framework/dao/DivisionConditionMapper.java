package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.impl.DivisionImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 部门表
 * 作者:    Auto
 * 日期:    2016/3/28
 **********************************************
 */
public interface DivisionConditionMapper extends CommonMapper {
	int deleteById(String id);

	int insert(Division record);

	Division selectById(String id);

	int updateById(Division record);

	List<Division> selectByUserId(String userId);

	List<Division> selectBySearch(HashMap<String, Object> param);

	List<DivisionImpl> selectByTag(@Param("tag") String tag);
	
	List<DivisionImpl> selectByTagOnly(@Param("tag") String tag);
	
	List<DivisionImpl> selectDivisionTree(DivisionImpl division);

	int countByName(String name);

	List<Division> selectAll();
	
	List<Division> selectForDivisionGroup(Division division);
	
	List<Division> select(Division division);
	
	List<Division> selectAllGroup();
	
	List<Division> selectByCategoryId(@Param("record")Division record, @Param("categoryId") Integer categoryId);
	
	List<Division> selectGroupByCategoryId(@Param("record")Division record, @Param("categoryId") Integer categoryId);
	
	int countGroupByCategoryId(@Param("categoryId")Integer categoryId);
	
	List<Division> selectAllGroupForCategory(@Param("record")Division record);
}