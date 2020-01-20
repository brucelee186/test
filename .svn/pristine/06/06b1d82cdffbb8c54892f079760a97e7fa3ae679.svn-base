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
import com.mtf.framework.model.User2Action;

/**
 * 用户行为相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface IUser2ActionService {

	
	/**
	 * 添加新用户行为
	 * <p>添加新用户行为，如果成功，则返回用户id</p>
	 * 
	 * @param uid 操作用户
	 * @param user2action
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter user2action is NULL.<br>
	 * Parameter user2action.userId is NULL or Empty.<br>
	 * Parameter user2action.actionId is NULL or Empty.<br>
	 * Parameter user2action.allow is NULL.
	 * </td></tr>
	 * <tr><td>用户行为已存在</td><td>2</td><td>User action rule already exists.</td></tr>
	 * </tbody>
	 * </table>
	 */
	User2Action add(String uid, User2Action user2action) throws PmException;
	
	/**
	 * 编辑用户行为
	 * 
	 * @param uid 操作用户
	 * @param user2action
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter user2action is NULL.<br>
	 * Parameter user2action.id is NULL.<br>
	 * Parameter user2action.userId is NULL or Empty.<br>
	 * Parameter user2action.actionId is NULL or Empty.<br>
	 * Parameter user2action.allow is NULL.
	 * </td></tr>
	 * <tr><td>用户行为不存在</td><td>2</td><td>User action rule not found.</td></tr>
	 * </table>
	 */
	User2Action edit(String uid, User2Action user2action) throws PmException;
	
	/**
	 * 删除指定用户行为
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * <tr><td>用户行为不存在</td><td>2</td><td>User action rule not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 搜索用户行为列表
	 * 
	 * @param uid 操作用户
	 * @param userId
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>用户不存在</td><td>2</td><td>User not found.</td></tr>
	 * </table>
	 */
	List<User2Action> listByUserId(String uid, String userId) throws PmException;
	
	/**
	 * 搜索用户行为列表，包含行为信息
	 * 
	 * @param uid 操作用户
	 * @param userId
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>用户不存在</td><td>2</td><td>User not found.</td></tr>
	 * </table>
	 */
	List<User2Action> listByUserIdWithAction(String uid, String userId) throws PmException;

	/**
	 * 查询指定用户行为
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
	User2Action get(String uid, String id) throws PmException;

	/**
	 * 查询指定用户行为，包含行为信息
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
	User2Action getWithAction(String uid, String id) throws PmException;
}
