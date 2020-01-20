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

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.impl.DivisionImpl;

/**
 * 部门相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface IDivisionService {
	
	/**
	 * 添加新部门
	 * <p>添加新部门信息，如果成功，则返回部门id</p>
	 * 
	 * @param uid 操作用户
	 * @param division
	 * @return 部门信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>
	 * Parameter division is NULL.<br>
	 * Parameter division.name is NULL or Empty.<br>
	 * Parameter division.userId is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>名称已存在</td><td>2</td><td>Division name already exists.</td></tr>
	 * <tr><td>隶属部门不存在</td><td>2</td><td>Parent division not found.</td></tr>
	 * </table>
	 */
	Division add(String uid, Division division) throws PmException;
	
	/**
	 * 查询指定部门
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 部门信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL.</td></tr>
	 * </table>
	 */
	Division get(String uid, String id) throws PmException;

	/**
	 * 编辑部门信息
	 * 
	 * @param uid 操作用户
	 * @param resource
	 * @return 部门信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter division is NULL.<br>
	 * Parameter division.id is NULL or Empty.<br>
	 * Parameter division.name is NULL or Empty.<br>
	 * Parameter division.userId is NULL or Empty.<br>
	 * Parameter division.status not in [0,1].<br>
	 * </td></tr>
	 * <tr><td>部门不存在</td><td>2</td><td>Division not found.</td></tr>
	 * <tr><td>部门名称已存在</td><td>3</td><td>Division name already exists.</td></tr>
	 * <tr><td>隶属部门不存在</td><td>3</td><td>Parent division not found.</td></tr>
	 * </table>
	 */
	Division edit(String uid, Division division) throws PmException;
	
	/**
	 * 删除部门
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL.</td></tr>
	 * <tr><td>部门不存在</td><td>1</td><td>Division not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 搜索全部部门
	 * 
	 * @param uid 操作用户
	 * @return 部门列表
	 * @throws PmException
	 */
	List<Division> listAll(String uid) throws PmException;
	
	
	/**
	 * 搜索全部部门
	 * 
	 * @param uid 操作用户
	 * @return 部门列表
	 * @throws PmException
	 */
	List<Division> selectForDivisionGroup(Division division) throws PmException;
	
	/**
	 * 搜索人员对应部门
	 * 
	 * @param uid 操作用户
	 * @return 部门列表
	 * @throws PmException
	 */
	List<Division> listByUserId(String uid) throws PmException;
	
	/**
	 * 搜索组
	 * 
	 * @param division 操作用户
	 * @return 部门列表
	 * @throws PmException
	 */
	List<Division> listByCategoryId(Division division, Integer categoryId) throws PmException;
	
	List<Division> listForGroup(Division division) throws PmException;
	

	/**
	 * 按Tag搜索全部部门
	 * 
	 * @param uid 操作用户
	 * @param tag 标签
	 * @return 部门列表
	 * @throws PmException
	 */
	List<DivisionImpl> listAvailable(String uid, String tag) throws PmException;
	
	Division addWithCategory(Division division, Integer categoryId, HttpSession session) throws PmException;
	
	Division addForGroup(Division division, HttpSession session) throws PmException;
	
	Division editWithCategory(Division division, Integer categoryId, HttpSession session) throws PmException;
	
	Division editForGroup(Division division, HttpSession session) throws PmException;
	List<Division> select(Division division) ;
}
