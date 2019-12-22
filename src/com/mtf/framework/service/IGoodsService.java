package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Goods;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;


public interface IGoodsService {
	

	/**
	 * 添加新货品
	 * <p>添加新货品，如果成功，则返回货品id</p>
	 * 
	 * @param contract 调用货品
	 * @return 货品信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>参数错误</td><td>1</td>
	 * <td>
	 * Parameter goods is NULL or Empty.<br>
	 * </td></tr>
	 * </tbody>
	 * </table>
	 */
	Goods insert(String uid,Goods goods) throws PmException;
	
	/**
	 * 搜索货品列表
	 * 
	 * @param uid 操作合同
	 * @param form 参数
	 * @return 货品列表
	 * @throws PmException
	 */
	DataGrid<Goods> select(String uid,PageForm form,Goods goods) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param Contract
	 * @return
	 * @throws PmException
	 */
	Goods get(String uid,Goods goods) throws PmException;
	
	/**
	 * 更新单一对象
	 * @param Contract
	 * @return
	 * @throws PmException
	 */
	int update(String uid,Goods goods) throws PmException;
	
	/**
	 * 删除对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	int delete(String uid,Goods goods) throws PmException;

}
