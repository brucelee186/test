/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Role;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.impl.RoleImpl;

/**
 * 角色相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface IRoleService {

	/**
	 * 查询所有角色信息
	 * 
	 * @param uid 操作用户
	 * @param form
	 * @param system
	 * @return 角色列表，或null
	 * @throws PmException
	 */
	List<RoleImpl> listAll(String uid, PageForm form, Integer system, String type) throws PmException;
	
	/**
	 * 查询所有状态可用的角色信息
	 * <p>查询条件:status=0</p>
	 * 
	 * @param uid 操作用户
	 * @param form
	 * @param system
	 * @return 角色列表，或null
	 * @throws PmException
	 */
	List<RoleImpl> listAllAvailable(String uid, PageForm form, Integer system) throws PmException;
	
	/**
	 * 添加新角色
	 * 
	 * @param uid 操作用户
	 * @param role
	 * @return 角色id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter role is NULL.<br>
	 * Parameter role.id is NULL or Empty.<br>
	 * Parameter role.name is NULL or Empty.<br>
	 * Parameter role.level not in [1-9].<br>
	 * Parameter role.userId is NULL or Empty.<br>
	 * Parameter role.status less than 0.
	 * </td></tr>
	 * <tr><td>行为名称已存在</td><td>2</td><td>Role name already exists.</td><tr>
	 * </table>
	 * <br>
	 */
	RoleImpl add(String uid, RoleImpl role) throws PmException;

	/**
	 * 查询指定角色
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 角色信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	RoleImpl get(String uid, String id) throws PmException;

	/**
	 * 查询指定角色，并包含行为列表
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 角色信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	RoleImpl getWithActions(String uid, String id) throws PmException;

	/**
	 * 编辑角色
	 * 
	 * @param uid 操作用户
	 * @param role
	 * @return 角色信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter role is NULL.<br>
	 * Parameter role.id is NULL or Empty.<br>
	 * Parameter role.name is NULL or Empty.<br>
	 * Parameter role.level not in [1-9].<br>
	 * Parameter role.userId is NULL or Empty.<br>
	 * Parameter role.status less than 0.
	 * </td></tr>
	 * <tr><td>角色不存在</td><td>2</td><td>Role not found.</td></tr>
	 * <tr><td>角色名称已存在</td><td>3</td><td>Role name already exists.</td></tr>
	 * </table>
	 */
	RoleImpl edit(String uid, RoleImpl role) throws PmException;

	/**
	 * 删除指定角色
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * <tr><td>角色不存在</td><td>1</td><td>Role not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 编辑角色行为
	 * 
	 * @param uid 操作用户
	 * @param roleId
	 * @param actionIds
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter roleId is NULL or Empty.</td></tr>
	 * <tr><td>角色不存在</td><td>2</td><td>Role not found.</td></tr>
	 * <tr><td>行为不存在</td><td>3</td><td>Action not found.</td></tr>
	 * </table>
	 */
	void editActions(String uid, String roleId, String[] actionIds) throws PmException;
}
