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
import com.mtf.framework.model.Currency;

/**
 * 货币相关服务接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface ICurrencyService {
	/**
	 * 添加新货币
	 * <p>添加新货币信息，如果成功，则返回货币id</p>
	 * 
	 * @param uid 操作用户
	 * @param currency 货币信息
	 * @return 货币id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter currency is NULL.<br>
	 * Parameter currency.name is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>货币已存在</td><td>2</td><td>Currency name already exists.</td></tr>
	 * </table>
	 */
	Currency add(String uid, Currency currency) throws PmException;

	/**
	 * 编辑货币
	 * 
	 * @param uid 操作用户
	 * @param currency 货币信息
	 * @return 货币信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter currency is NULL.<br>
	 * Parameter currency.id is NULL or Empty.<br>
	 * Parameter currency.name is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>货币不存在</td><td>2</td><td>Currency not found.</td></tr>
	 * </table>
	 */
	Currency edit(String uid, Currency currency) throws PmException;
	
	/**
	 * 查询指定货币
	 * 
	 * @param uid 操作用户
	 * @param id 货币id
	 * @return 货币信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	Currency get(String uid, String id) throws PmException;
	
	/**
	 * 删除货币
	 * 
	 * @param uid 操作用户
	 * @param id 货币id
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * <tr><td>货币不存在</td><td>2</td><td>Currency not found.</td></tr>
	 * </table>
	 */
	void delete(String uid, String id) throws PmException;
	
	/**
	 * 所有货币列表
	 * 
	 * @param uid 操作用户
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	List<Currency> listAll(String uid) throws PmException;
}
