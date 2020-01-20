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
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.page.ResourceSearchForm;

/**
 * 资源相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface ResourceService {
	
	/**
	 * 添加新资源
	 * <p>添加新资源信息，如果成功，则返回资源id</p>
	 * 
	 * @param uid 操作用户
	 * @param resource
	 * @return 资源信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>
	 * Parameter resource is NULL.<br>
	 * Parameter resource.name is NULL or Empty.<br>
	 * Parameter resource.uri is NULL or Empty.<br>
	 * Parameter resource.level not in [1-9].<br>
	 * Parameter resource.access not in [1-9].
	 * </td></tr>
	 * <tr><td>资源名称已存在</td><td>1</td><td>Resource name already exists.</td></tr>
	 * <tr><td>资源路径已存在</td><td>1</td><td>Resource uri already exists.</td></tr>
	 * </table>
	 */
	Resource add(String uid, Resource resource) throws PmException;
	
	/**
	 * 查询指定资源
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @return 资源信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL.</td></tr>
	 * </table>
	 */
	Resource get(String uid, String id) throws PmException;

	/**
	 * 编辑资源信息
	 * <p>排除actionId</p>
	 * 
	 * @param uid 操作用户
	 * @param resource
	 * @return 资源信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter resource is NULL.<br>
	 * Parameter resource.id is NULL or Empty.<br>
	 * Parameter resource.name is NULL or Empty.<br>
	 * Parameter resource.uri is NULL or Empty.<br>
	 * Parameter resource.level not in [1-9].<br>
	 * Parameter resource.access not in [1-9].
	 * </td></tr>
	 * <tr><td>资源不存在</td><td>2</td><td>Resource not found.</td></tr>
	 * <tr><td>资源名称已存在</td><td>3</td><td>Resource name already exists.</td></tr>
	 * <tr><td>资源路径已存在</td><td>4</td><td>Resource uri already exists.</td></tr>
	 * </table>
	 */
	Resource edit(String uid, Resource resource) throws PmException;
	
	/**
	 * 删除资源
	 * 
	 * @param uid 操作用户
	 * @param id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL.</td></tr>
	 * <tr><td>资源不存在</td><td>1</td><td>Resource not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 搜索资源列表
	 * 
	 * @param uid 操作用户
	 * @param form 参数
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	DataGrid<Resource> list(String uid, ResourceSearchForm form) throws PmException;
	
	/**
	 * 搜索全部资源
	 * 
	 * @param uid 操作用户
	 * @return 资源列表
	 * @throws PmException
	 */
	List<Resource> listAll(String uid) throws PmException;
	
	/**
	 * 搜索指定行为的资源
	 * 
	 * @param uid 操作用户
	 * @return 资源列表
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter actionId is NULL or Empty.</td></tr>
	 * <tr><td>行为未找到</td><td>1</td><td>Action not found.</td></tr>
	 * </table>
	 */
	List<Resource> listByActionId(String uid, String actionId) throws PmException;
	
	/**
	 * 搜索全部未指定到行为的资源
	 * 
	 * @param uid 操作用户
	 * @return 资源列表
	 * @throws PmException
	 */
	List<Resource> listAllUnsigned(String uid, PageForm form) throws PmException;
	
	/**
	 * 搜索菜单
	 * @param resource
	 * @return
	 * @throws PmException
	 */
	List<Resource> selectMenu(Resource resource) throws PmException;
}
