package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenRecordImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 考勤审批记录
 * 作者:     Auto
 * 日期:     2015/5/15
**********************************************
*/
public interface AttenRecordService {
	/**
	 * 新增实体对象
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public AttenRecordImpl insert(AttenRecordImpl attenRecord) throws PmException;

	/**
	 * 删除实体对象
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public int delete(AttenRecordImpl attenRecord) throws PmException;

	/**
	 * 更新实体对象
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttenRecordImpl attenRecord) throws PmException;

	/**
	 * 查询实体列表
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public List<AttenRecordImpl> select(AttenRecordImpl attenRecord) throws PmException;

	/**
	 * 取得单一对象
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public AttenRecordImpl get(AttenRecordImpl attenRecord) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenRecordImpl> search(AttenRecordImpl attenRecord) throws PmException;
	
	/**
	 * 审批
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public boolean approve(AttenRecordImpl attenRecord) throws PmException;

}