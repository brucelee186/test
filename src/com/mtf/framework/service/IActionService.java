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
import com.mtf.framework.model.Action;
import com.mtf.framework.model.common.PageForm;

/**
 * 行为相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface IActionService {
	/**
	 * 添加新行为
	 * <p>添加新行为信息，如果成功，则返回行为id</p>
	 * 
	 * @param uid 操作用户
	 * @param action 行为信息
	 * @return 行为id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter action is NULL.<br>
	 * Parameter action.name is NULL or Empty.<br>
	 * Parameter action.level not in [1-9].<br>
	 * Parameter action.status less than 0.
	 * </td></tr>
	 * <tr><td>行为名称已存在</td><td>2</td><td>Action name already exists.</td></tr>
	 * </table>
	 */
	Action add(String uid, Action action) throws PmException;

	/**
	 * 编辑行为
	 * 
	 * @param uid 操作用户
	 * @param action 行为信息
	 * @return 行为信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter action is NULL.<br>
	 * Parameter action.id is NULL or Empty.<br>
	 * Parameter action.name is NULL or Empty.<br>
	 * Parameter action.level not in [1-9].<br>
	 * Parameter action.status less than 0.
	 * </td></tr>
	 * <tr><td>行为不存在</td><td>2</td><td>Action not found.</td></tr>
	 * <tr><td>行为名称已存在</td><td>3</td><td>Action name already exists.</td></tr>
	 * </table>
	 */
	Action edit(String uid, Action action) throws PmException;
	
	/**
	 * 编辑行为资源
	 * 
	 * @param uid 操作用户
	 * @param actionId 行为id
	 * @param resourceIds 资源id列表
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter actionId is NULL or Empty.</td></tr>
	 * <tr><td>行为不存在</td><td>2</td><td>Action not found.</td></tr>
	 * <tr><td>资源不存在</td><td>3</td><td>Resource not found.</td></tr>
	 * <tr><td>资源已被分配</td><td>4</td><td>Resource already assigned to an Action.</td></tr>
	 * </table>
	 */
	void editResources(String uid, String actionId, String[] resourceIds) throws PmException;
	
	/**
	 * 查询指定行为
	 * 
	 * @param uid 操作用户
	 * @param id 行为id
	 * @return 行为信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	Action get(String uid, String id) throws PmException;
	
	/**
	 * 删除行为
	 * 
	 * @param uid 操作用户
	 * @param id 行为id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * <tr><td>行为不存在</td><td>2</td><td>Action not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 所有行为列表
	 * 
	 * @param uid 操作用户
	 * @param form 分页表单
	 * @param system
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	List<Action> listAll(String uid, PageForm form, Integer system) throws PmException;
}
