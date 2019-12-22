package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.RoleImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 部门表
 * 作者:    Auto
 * 日期:    2016/5/5
 **********************************************
 */
public interface RoleConditionMapper extends CommonMapper {
	int deleteById(String id);

	int insert(RoleImpl record);

	RoleImpl selectById(String id);

	int updateById(RoleImpl record);

	List<RoleImpl> selectByUserId(String userId);

	List<RoleImpl> selectAll(HashMap<String, Object> param);

	int countByName(String name);

	RoleImpl selectByIdWithActions(String id);
}