package com.mtf.framework.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import java.util.ListIterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.SelecterImpl;
import com.mtf.framework.dao.SelecterMapper;
import com.mtf.framework.model.Selecter;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.SelecterService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 选项表
 * 作者:     Auto
 * 日期:     2014-03-06
**********************************************
*/
@Service("selecterService")
public class SelecterServiceImpl extends CommonServiceImpl implements SelecterService {
	@Autowired
	private SelecterMapper selecterMapper;

	@Autowired
	public SelecterMapper getSelecterMapper() {
		return selecterMapper;
	}

	@Autowired
	public void setSelecterMapper(SelecterMapper selecterMapper) {
		this.selecterMapper = selecterMapper;
	}

	/**
	 * 新增实体对象
	 * @param selecter
	 */
	public SelecterImpl insert(SelecterImpl selecterImpl) throws PmException {
		this.selecterMapper.insert(selecterImpl);
		return selecterImpl;
	}

	/**
	 * 删除实体对象
	 * @param selecter
	 */
	public int delete(SelecterImpl selecterImpl) throws PmException {
		return this.selecterMapper.delete(selecterImpl);
	}

	/**
	 * 更新实体对象
	 * @param selecter
	 */
	public boolean update(SelecterImpl selecterImpl) throws PmException {
		boolean result = true;
		this.selecterMapper.update(selecterImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param selecter
	 */
	public SelecterImpl get(SelecterImpl selecterImpl) throws PmException {
		return (SelecterImpl) this.selecterMapper.get(selecterImpl);
	}
	/**
	 * 查询实体列表
	 * @param selecter
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<SelecterImpl> select(SelecterImpl selecterImpl) throws PmException {
		DataGrid<SelecterImpl> grid = new DataGrid<SelecterImpl>();
		Object obj = selecterImpl;
		List list = selecterMapper.select(obj);
		grid.setRows(list);
		int count;
		count = selecterMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	@Override
	public List<Map<Long, Long>> selectAnswer(SelecterImpl selecterImpl) throws PmException {
		List<Map<Long, Long>> answerMap = selecterMapper.selectAnswer(selecterImpl);
		return answerMap;
	}
}