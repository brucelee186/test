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
import com.mtf.framework.model.Unit;
import com.mtf.framework.model.common.PageForm;


public interface IUnitService {
	/**
	 * 添加新单位
	 * <p>添加新单位信息，如果成功，则返回单位id</p>
	 * 
	 * @param uid 操作用户
	 * @param unit 单位信息
	 * @return 单位id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter unit is NULL.<br>
	 * Parameter unit.from is NULL or Empty.<br>
	 * Parameter unit.ratio is NULL or below 0.<br>
	 * Parameter unit.to is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>单位已存在</td><td>2</td><td>Unit already exists.</td></tr>
	 * </table>
	 */
	Unit add(String uid, Unit unit) throws PmException;

	/**
	 * 编辑单位
	 * 
	 * @param uid 操作用户
	 * @param unit 单位信息
	 * @return 单位信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter unit is NULL.<br>
	 * Parameter unit.id is NULL or Empty.<br>
	 * Parameter unit.from is NULL or Empty.<br>
	 * Parameter unit.ratio is NULL or below 0.<br>
	 * Parameter unit.to is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>单位不存在</td><td>2</td><td>Unit not found.</td></tr>
	 * <tr><td>单位不存在</td><td>3</td><td>Unit already exists.</td></tr>
	 * </table>
	 */
	Unit edit(String uid, Unit unit) throws PmException;
	
	/**
	 * 查询指定单位
	 * 
	 * @param uid 操作用户
	 * @param id 单位id
	 * @return 单位信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	Unit get(String uid, String id) throws PmException;
	
	/**
	 * 删除单位
	 * 
	 * @param uid 操作用户
	 * @param id 单位id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * <tr><td>单位不存在</td><td>2</td><td>Unit not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 所有单位列表
	 * 
	 * @param uid 操作用户
	 * @param form 分页表单
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	List<Unit> listAll(String uid, PageForm form) throws PmException;
	
	/**
	 * 所有可用单位列表
	 * 
	 * @param uid 操作用户
	 * @param form 分页表单
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	List<Unit> listAllAvailable(String uid, PageForm form) throws PmException;
	

}
