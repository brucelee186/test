package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.SysLogImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 系统日志
 * 作者:     Auto
 * 日期:     2017/4/20
**********************************************
*/
public interface SysLogService {
	/**
	 * 新增实体对象
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public SysLogImpl insert(SysLogImpl sysLog) throws PmException;

	/**
	 * 删除实体对象
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public int delete(SysLogImpl sysLog) throws PmException;

	/**
	 * 更新实体对象
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public boolean update(SysLogImpl sysLog) throws PmException;

	/**
	 * 查询实体列表
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public List<SysLogImpl> select(SysLogImpl sysLog) throws PmException;

	/**
	 * 取得单一对象
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public SysLogImpl get(SysLogImpl sysLog) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param sysLog
	 * @return
	 * @throws PmException
	 */
	public DataGrid<SysLogImpl> search(SysLogImpl sysLog) throws PmException;

}