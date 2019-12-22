package com.mtf.framework.dao;

import java.util.List;
import java.util.Map;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.AttenDayImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 考勤时段
 * 作者:    Auto
 * 日期:    2015/5/6
 **********************************************
 */
public interface AttenDayConditionMapper extends CommonMapper {
	
	Map<String, AttenDayImpl> selectAttenDayMap(AttenDayImpl attenDay);

}