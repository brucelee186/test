package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.Permission;
import com.mtf.framework.model.impl.PermissionImpl;

public interface PermissionConditionMapper extends CommonMapper{
	/**
	 * 搜索所有权限并生成权限树型结构
	 * @param permission
	 * @return
	 */
	List<PermissionImpl> searchPermissionList(Permission permission);
	
	List<PermissionImpl> searchUserDivisionByPermission(Permission permission);
	
	PermissionImpl getAmountByUserId(@Param("userId") String userId, @Param("categoryId") String categoryId, @Param("pid") String pid, @Param("codes") String[] codes);
	
	double getMinAmountByAmount(@Param("amount") double amount, @Param("categoryId") String categoryId, @Param("pid") String pid, @Param("codes") String[] codes);
	
	int countMinAmountByAmount(@Param("amount") double amount, @Param("categoryId") String categoryId, @Param("pid") String pid, @Param("codes") String[] codes);
	
	double getAmountByCode(@Param("code") String code);
	
	String getValueByCode(@Param("code") String code);
	
	// 根据用户编号和权限ID,判断此权限是否存在
	PermissionImpl getPermissionByUserId(PermissionImpl permission);
	
	// 根据主权限与Value1判断用户是否有些权限
	PermissionImpl getPermissionByUserIdValue1(PermissionImpl permission);
}
