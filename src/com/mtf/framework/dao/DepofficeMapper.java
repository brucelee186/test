package com.mtf.framework.dao;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.DepofficeImpl;
/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 部门办公用品
 * 作者:     Auto
 * 日期:     2013-12-17
 **********************************************
 */
public interface DepofficeMapper extends CommonMapper {
	int updateApprove(DepofficeImpl depOffice);

}