package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.PurchaseImpl;
/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 采购表
 * 作者:     Auto
 * 日期:     2015/3/4
 **********************************************
 */
public interface PurchaseMapper extends CommonMapper {
	List<PurchaseImpl> selectWithItem(@Param("record") PurchaseImpl record,
	                                  @Param("statuses") String[] statuses,
	                                  @Param("categoryIds") List<String> categoryIds,
	                                  @Param("category2Id") String category2Id);
	
	List<PurchaseImpl> selectByUserId(@Param("record") PurchaseImpl record, @Param("statuses") String[] statuses);
	
	List<PurchaseImpl> selectForReport(@Param("record") PurchaseImpl record,
	                                   @Param("categoryIds") String[] categoryIds,
	                                   @Param("applicantdivisionIds") String[] applicantdivisionIds);
	
	
	List<PurchaseImpl> selectForMonthReportByApplicant(@Param("record") PurchaseImpl record);
	
	List<PurchaseImpl> selectForMonthReportByCustomer(@Param("record") PurchaseImpl record);
}