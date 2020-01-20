package com.mtf.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.dao.ReimbursementItemMapper;
import com.mtf.framework.model.impl.ReimbursementItemImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.ReimbursementItemService;
import com.mtf.framework.util.UUIDUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 报销子列表
 * 作者:     Auto
 * 日期:     2015/3/16
**********************************************
*/
@Service("reimbursementItemService")
public class ReimbursementItemServiceImpl extends CommonServiceImpl implements ReimbursementItemService {
	@Autowired
	private ReimbursementItemMapper reimbursementItemMapper;

	@Autowired
	public ReimbursementItemMapper getReimbursementItemMapper() {
		return reimbursementItemMapper;
	}

	@Autowired
	public void setReimbursementItemMapper(ReimbursementItemMapper reimbursementItemMapper) {
		this.reimbursementItemMapper = reimbursementItemMapper;
	}

	
	/**
	 * 查询实体列表
	 * @param reimbursementItem
	 */
	@SuppressWarnings("unchecked")
	public List<ReimbursementItemImpl> select(ReimbursementItemImpl reimbursementItem) throws PmException {
		return (List<ReimbursementItemImpl>) this.reimbursementItemMapper.select(reimbursementItem);
	}


}