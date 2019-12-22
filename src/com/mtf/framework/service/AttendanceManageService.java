﻿package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttendanceManageImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/8/5
**********************************************
*/
public interface AttendanceManageService {
	/**
	 * 新增实体对象
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public AttendanceManageImpl insert(AttendanceManageImpl attendanceManage) throws PmException;

	/**
	 * 删除实体对象
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public int delete(AttendanceManageImpl attendanceManage) throws PmException;

	/**
	 * 更新实体对象
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttendanceManageImpl attendanceManage) throws PmException;

	/**
	 * 查询实体列表
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public List<AttendanceManageImpl> select(AttendanceManageImpl attendanceManage) throws PmException;

	/**
	 * 取得单一对象
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public AttendanceManageImpl get(AttendanceManageImpl attendanceManage) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attendanceManage
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttendanceManageImpl> search(AttendanceManageImpl attendanceManage) throws PmException;

}