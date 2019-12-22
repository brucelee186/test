package com.mtf.framework.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.SelecterImpl;
import com.mtf.framework.model.Selecter;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 选项表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
public interface SelecterService {
	/**
	 * 新增实体对象
	 * @param selecter
	 * @return
	 * @throws PmException
	 */
	public SelecterImpl insert(SelecterImpl selecterImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param selecter
	 * @return
	 * @throws PmException
	 */
	public int delete(SelecterImpl selecterImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param selecter
	 * @return
	 * @throws PmException
	 */
	public boolean update(SelecterImpl selecterImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param selecter
	 * @return
	 * @throws PmException
	 */
	public DataGrid<SelecterImpl> select(SelecterImpl selecterImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param selecter
	 * @return
	 * @throws PmException
	 */
	public SelecterImpl get(SelecterImpl selecterImpl) throws PmException;
	
	/**
	 * 取得MAP类型问题答案
	 * @param selecterImpl
	 * @return
	 * @throws PmException
	 */
	public  List<Map<Long, Long>> selectAnswer(SelecterImpl selecterImpl)throws PmException;
}