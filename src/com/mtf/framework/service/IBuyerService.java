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
import com.mtf.framework.model.Buyer;
import com.mtf.framework.model.common.DataGrid;

/**
 * 买方相关服务接口
 *
 * @author Neo.Yin
 * @version 1.0	2013-6-5	Neo.Yin		created.
 * @version <ver>
 */
public interface IBuyerService {
	
	/**
	 * 添加新买方
	 * <p>添加新买方，如果成功，则返回买方id</p>
	 * 
	 * @param buyer 操作买方
	 * @return 买方对象
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter buyer is NULL or Empty.<br>
	 * </td></tr>
	 * <tr><td>买方名称已存在</td><td>2</td><td>Buyer name already exists.</td></tr>
	 * <tr><td>客户编号已存在</td><td>3</td><td>Buyer customerid already exists.</td></tr>
	 * </tbody>
	 * </table>
	 */
	Buyer insert(Buyer buyer) throws PmException;
	
	/**
	 * 搜索买方列表
	 * 
	 * @param uid 操作买方
	 * @param form 参数
	 * @return 买方列表
	 * @throws PmException
	 */
	DataGrid<Buyer> select(Buyer buyer) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	Buyer get(Buyer buyer) throws PmException;
	
	/**
	 * 更新单一对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	int update(Buyer buyer) throws PmException;
	
	/**
	 * 删除对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	int delete(Buyer buyer) throws PmException;
}
