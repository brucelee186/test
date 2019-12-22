package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.ReimbursementImpl;
/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 报销表
 * 作者:     Auto
 * 日期:     2015/3/16
 **********************************************
 */
public interface ReimbursementMapper extends CommonMapper {
	
	List<ReimbursementImpl> selectWithItem(@Param("record") ReimbursementImpl record, @Param("statuses") String[] statuses);
	
	List<ReimbursementImpl> selectByStatuses(@Param("record") ReimbursementImpl record, @Param("statuses") String[] statuses);
	
	List<ReimbursementImpl> selectForReport(@Param("record") ReimbursementImpl record,
	                                        @Param("categoryIds") String[] categoryIds,
	                                        @Param("applicantDivisionIds") String[] applicantDivisionIds);
	
	List<ReimbursementImpl> selectForWeekReportByCustomer(@Param("record") ReimbursementImpl record);
	
	List<ReimbursementImpl> selectForWeekReportByDivision(@Param("record") ReimbursementImpl record);
	
	List<ReimbursementImpl> selectForDetail(@Param("record") ReimbursementImpl record);
	

}