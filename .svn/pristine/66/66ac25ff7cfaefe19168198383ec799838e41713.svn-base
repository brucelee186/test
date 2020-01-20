package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.AttendanceImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/29
 **********************************************
 */
public interface AttendanceConditionMapper extends CommonMapper {
	public List<AttendanceImpl> searchMonitorCollection(AttendanceImpl attendanceImpl);
	int countAttenAbsenteeism(Object obj);
	
	List<?> selectAttenAbsence(Object obj);
	int countAttenAbsence(Object obj);
}