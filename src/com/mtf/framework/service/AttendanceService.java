package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttendanceImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 门禁数据
 * 作者:     Auto
 * 日期:     2015/4/15
**********************************************
*/
public interface AttendanceService {
	/**
	 * 新增实体对象
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public AttendanceImpl insert(AttendanceImpl attendance) throws PmException;

	/**
	 * 删除实体对象
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public int delete(AttendanceImpl attendance) throws PmException;

	/**
	 * 更新实体对象
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttendanceImpl attendance) throws PmException;

	/**
	 * 查询实体列表
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public List<AttendanceImpl> select(AttendanceImpl attendance) throws PmException;

	/**
	 * 取得单一对象
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public AttendanceImpl get(AttendanceImpl attendance) throws PmException;
	
	/**
	 * 取得工作时间,及负荷计算后的考勤记录
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public AttendanceImpl calculateAttendanceWork(AttendanceImpl attendance) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttendanceImpl> search(AttendanceImpl attendance) throws PmException;
	
	/**
	 * 查询实体分页列表
	 * @param attendance
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttendanceImpl> searchAttenAbsence(AttendanceImpl attendance) throws PmException;

}