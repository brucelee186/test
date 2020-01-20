/*
\ * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
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

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.page.UserSearchForm;

/**
 * 用户相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface UserService {

	/**
	 * 登录
	 * <p>根据登录名和密码查询用户信息，如果成功，则返回一个{@link com.mtf.framework.model.common.SessionInfo}对象</p>
	 * 
	 * @param user 登录信息
	 * @return 用户信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>
	 * Parameter user is NULL<br>
	 * Parameter user.loginname is NULL or Empty.<br>
	 * Parameter user.password is NULL or Empty.</td></tr>
	 * <tr><td>用户名密码错误</td><td>2</td><td>Loginname or password is wrong.</td></tr>
	 * <tr><td>账号不可用</td><td>3</td><td>Account is disabled.</td></tr>
	 * <tr><td>账号不完整</td><td>4</td><td>Account is invalid.</td></tr>
	 * </table>
	 */
	SessionInfo getAsLogin(UserImpl user) throws PmException;
	
	/**
	 * 添加新用户
	 * <p>添加新用户，如果成功，则返回用户id</p>
	 * 
	 * @param uid 操作用户
	 * @param user
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter user is NULL.<br>
	 * Parameter user.loginname is NULL or Empty.<br>
	 * Parameter user.password is NULL or Empty.<br>
	 * Parameter user.userId is NULL or Empty.<br>
	 * Parameter user.status less than 0.<br>
	 * Parameter user.userProfile is NULL.<br>
	 * Parameter user.userProfile.fullname is NULL or Empty.
	 * </td></tr>
	 * <tr><td>登录名称已存在</td><td>2</td><td>UserImpl loginname already exists.</td></tr>
	 * <tr><td>邮箱地址已存在</td><td>3</td><td>Userprofile email already exists.</td></tr>
	 * </tbody>
	 * </table>
	 */
	UserImpl add(String uid,  UserImpl user) throws PmException;
	
	/**
	 * 编辑用户基本资料
	 * 
	 * @param uid 操作用户
	 * @param user
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter user is NULL.<br>
	 * Parameter user.id is NULL or Empty.<br>
	 * Parameter user.loginname is NULL or Empty.<br>
	 * Parameter user.userId is NULL or Empty.<br>
	 * Parameter user.status less than 0.<br>
	 * Parameter user.userProfile is NULL.<br>
	 * Parameter user.userProfile.fullname is NULL or Empty.
	 * </td></tr>
	 * <tr><td>用户不存在</td><td>2</td><td>UserImpl not found.</td></tr>
	 * <tr><td>用户名已存在</td><td>3</td><td>UserImpl loginname already exists.</td></tr>
	 * <tr><td>用户资料不存在</td><td>4</td><td>Userprofile not found.</td></tr>
	 * <tr><td>邮箱地址已存在</td><td>5</td><td>Userprofile email already exists.</td></tr>
	 * </table>
	 */
	UserImpl edit(String uid, UserImpl user) throws PmException;
	
	/**
	 * 编辑用户密码
	 * 
	 * <p>
	 * 如果oldPassword为空，则不验证当前密码，直接修改<br>
	 * 如果oldPassword不为空，则验证当前密码正确才修改
	 * </p>
	 * 
	 * @param uid 操作用户
	 * @param oldPassword 当前密码
	 * @param user
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter user is NULL.<br>
	 * Parameter user.id is NULL or Empty.<br>
	 * Parameter user.password is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>用户名或密码错误</td><td>2</td><td>UserImpl not found or Password incorrect</td></tr>
	 * <tr><td>密码不正确</td><td>3</td><td>Password incorrect.</td></tr>
	 * </table>
	 */
	UserImpl editPassword(String uid, String oldPassword, UserImpl user) throws PmException;
	
	/**
	 * 搜索用户列表
	 * 
	 * @param uid 操作用户
	 * @param form 参数
	 * @return 用户列表
	 * @throws PmException
	 */
	DataGrid<UserImpl> list(String uid, UserSearchForm form) throws PmException;
	
	List<UserImpl> listByDivisionId(String divisionId) throws PmException;
	
	/**
	 * 搜索有效用户列表
	 * 
	 * @param uid 操作用户
	 * @param form 
	 * @return 用户列表
	 * @throws PmException
	 */
	List<UserImpl> listAllAvailable(String uid, PageForm form) throws PmException;
	
	/**
	 * 搜索有效用户列表
	 * 
	 * @param uid 操作用户
	 * @param form 
	 * @return 用户列表
	 * @throws PmException
	 */
	List<UserImpl> listAllEnable(String uid, PageForm form) throws PmException;

	/**
	 * 查询指定用户
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	UserImpl get(String uid, String id) throws PmException;
	
	UserImpl get(UserImpl user) throws PmException;
	
	/**
	 * 查询指定用户
	 * 
	 * @param uid 操作用户
	 * @param loginName
	 * @return
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter loginName is NULL or Empty.</td></tr>
	 * </table>
	 */
	UserImpl getByLoginName(String uid, String loginName) throws PmException;

	/**
	 * 查询指定用户，包含用户资料
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 用户信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	UserImpl getWithProfile(String uid, String id) throws PmException;

	/**
	 * 查询指定用户，包含角色列表
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 用户信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	UserImpl getWithRoles(String uid, String id) throws PmException;
	
	/**
	 * 查询指定部门，包含角色列表
	 * 
	 * @param uid 操作部门
	 * @param id
	 * @return 部门信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	UserImpl getWithRolesDivision(String uid, String id) throws PmException;

	/**
	 * 编辑用户角色
	 * 
	 * @param uid 操作用户
	 * @param userId
	 * @param roleIds
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>用户不存在</td><td>2</td><td>UserImpl not found.</td></tr>
	 * <tr><td>角色不存在</td><td>3</td><td>Role not found.</td></tr>
	 * </table>
	 */
	void editRoles(String uid, String userId, String[] roleIds) throws PmException;
	
	/**
	 * 编辑用户角色
	 * 
	 * @param uid 操作部门
	 * @param userId
	 * @param roleIds
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>部门不存在</td><td>2</td><td>UserImpl not found.</td></tr>
	 * <tr><td>角色不存在</td><td>3</td><td>Role not found.</td></tr>
	 * </table>
	 */
	void editRolesDivision(String uid, String divisionId, String[] roleIds) throws PmException;
	
	
	/**
	 * 查询用户的Email
	 * @param level
	 * @return
	 * @throws PmException
	 */
	List<UserImpl> listUserEmail(int level) throws PmException;
	
	/**
	 * 查询用户的Email
	 * @param user
	 * @param session
	 * @return
	 * @throws PmException
	 */
	void updateForApproveStatus(UserImpl user,HttpSession session) throws PmException;

	UserImpl editForPhoto(String uid, UserImpl user) throws PmException;
	
	List<UserImpl> listByCategoryId(UserImpl user, Integer categoryId) throws PmException;
	
	List<UserImpl> listAdminByCategoryId(UserImpl user, Integer categoryId) throws PmException;
	
	public int countAdminByUserId(String userId) throws PmException;
	
	List<UserImpl> listForSinger(UserImpl user) throws PmException;
	
	List<UserImpl> select(UserImpl user) throws PmException;
	
	List<UserImpl> selectUserByPermission(UserImpl user) throws PmException;

}
