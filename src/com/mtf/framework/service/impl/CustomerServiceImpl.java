package com.mtf.framework.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.Tetrad;
import com.mtf.framework.dao.CustomerMapper;
import com.mtf.framework.model.impl.CustomerImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.CustomerService;


/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 客户
 * 作者:     Auto
 * 日期:     2015/4/3
**********************************************
*/
@Service("customerService")
public class CustomerServiceImpl extends CommonServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}

	@Autowired
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	@Override
	public List<Tetrad<String, String, String, String>> listTetrad(CustomerImpl customer) throws PmException {
		List<Tetrad<String, String, String, String>> list = this.customerMapper.selectTetrad(customer);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}
	
	@Override
	public List<CustomerImpl> list(CustomerImpl customer) throws PmException {
		List<CustomerImpl> list = this.customerMapper.selectForCustomer(customer);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<CustomerImpl> search(CustomerImpl customer) throws PmException {
		return (List<CustomerImpl>) customerMapper.selectCustomer(customer);
	}
}