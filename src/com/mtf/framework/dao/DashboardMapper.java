package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.impl.ApplicationImpl;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.model.impl.PaymentImpl;


public interface DashboardMapper extends CommonMapper {

	List<ContractImpl> selectAll(ContractImpl contractImpl);
	List<ApplicationImpl> selectAllForApplication(ApplicationImpl applicationImpl);
	
}
