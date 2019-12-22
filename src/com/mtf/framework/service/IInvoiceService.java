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

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Invoice;
import com.mtf.framework.model.common.DataGrid;

/**
 * 发票相关服务接口
 *
 * @author Neo.Yin
 * @version 1.0	2013-6-5	Neo.Yin		created.
 * @version <ver>
 */
public interface IInvoiceService  {
	
	/**
	 * 添加新发票
	 * <p>添加新发票，如果成功，则返回发票id</p>
	 * 
	 * @param invoice 操作发票
	 * @return 发票对象
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter invoice is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>发票名称已存在</td><td>2</td><td>Invoice name already exists.</td></tr>
	 * <tr><td>客户编号已存在</td><td>3</td><td>Invoice customerid already exists.</td></tr>
	 * </tbody>
	 * </table>
	 */
	Invoice insert(Invoice invoice) throws PmException;
	
	/**
	 * 搜索发票列表
	 * 
	 * @param uid 操作发票
	 * @param form 参数
	 * @return 发票列表
	 * @throws PmException
	 */
	DataGrid<Invoice> select(Invoice invoice) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	Invoice get(Invoice invoice) throws PmException;
	
	/**
	 * 更新单一对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	int update(Invoice invoice) throws PmException;
	
	/**
	 * 删除对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	int delete(Invoice invoice) throws PmException;
}
