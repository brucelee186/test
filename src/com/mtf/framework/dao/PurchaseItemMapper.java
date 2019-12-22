package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.PurchaseItemImpl;
/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 采购子列表
 * 作者:     Auto
 * 日期:     2015/3/5
 **********************************************
 */
public interface PurchaseItemMapper extends CommonMapper {

	int deleteByPurchaseId(PurchaseItemImpl purchaseItem);
	List<PurchaseItemImpl> selectWithPurchase(@Param("record") PurchaseItemImpl record, @Param("no") String no, @Param("userId") String userId);
}