package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenDayImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 考勤时段
 * 作者:     Auto
 * 日期:     2015/5/6
**********************************************
*/
public interface AttenDayService {
	/**
	 * 新增实体对象
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public AttenDayImpl insert(AttenDayImpl attenDay) throws PmException;

	/**
	 * 删除实体对象
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public int delete(AttenDayImpl attenDay) throws PmException;

	/**
	 * 更新实体对象
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttenDayImpl attenDay) throws PmException;

	/**
	 * 查询实体列表
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public List<AttenDayImpl> select(AttenDayImpl attenDay) throws PmException;

	/**
	 * 取得单一对象
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public AttenDayImpl get(AttenDayImpl attenDay) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attenDay
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenDayImpl> search(AttenDayImpl attenDay) throws PmException;

}