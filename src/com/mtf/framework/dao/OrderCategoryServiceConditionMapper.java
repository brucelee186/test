package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
/*
 **********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 模型层 -> 科目申请服务
 * 作者:    Auto
 * 日期:    2016/6/22
 **********************************************
 */
public interface OrderCategoryServiceConditionMapper extends CommonMapper {

	List<OrderCategoryServiceImpl> selectDetailList(OrderCategoryServiceImpl orderCategoryService);
	
	OrderCategoryServiceImpl getLast(OrderCategoryServiceImpl orderCategoryService);
}