package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.AttenRuleImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 考勤规则
 * 作者:    Auto
 * 日期:    2015/4/24
 **********************************************
 */
public interface AttenRuleConditionMapper extends CommonMapper {
	
	List<AttenRuleImpl> selectAttenCollect(AttenRuleImpl attenRule);
	
	AttenRuleImpl doGetWorkHourRange(AttenRuleImpl attenRule);

}