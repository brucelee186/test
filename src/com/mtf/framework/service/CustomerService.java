package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.Tetrad;
import com.mtf.framework.model.impl.CustomerImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 客户
 * 作者:     Auto
 * 日期:     2015/4/3
**********************************************
*/
public interface CustomerService {
	
	public List<Tetrad<String, String, String, String>> listTetrad(CustomerImpl customer) throws PmException;
	
	/**
	 * 根据类型、状态、PID检索客户信息
	 * @param customer
	 * @return 执行结果，不为null
	 * @throws PmException
	 */
	List<CustomerImpl> list(CustomerImpl customer) throws PmException;
	
	List<CustomerImpl> search(CustomerImpl customer) throws PmException;
	
	

}