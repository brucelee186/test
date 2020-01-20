package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.common.Tetrad;
import com.mtf.framework.model.impl.CustomerImpl;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：模型层 -> 客户
 * 作者:     Auto
 * 日期:     2015/4/3
 **********************************************
 */
public interface CustomerMapper extends CommonMapper {
	
	List<Tetrad<String, String, String, String>> selectTetrad(CustomerImpl record);
	
	List<CustomerImpl> selectForCustomer(CustomerImpl record);
	
	List<CustomerImpl> search(CustomerImpl record);
	List<CustomerImpl> selectCustomer(CustomerImpl record);

}