package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.HistoryMapper;
import com.mtf.framework.model.History;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.HistoryService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 人员信息表
 * 作者:     Auto
 * 日期:     2014/4/22
**********************************************
*/
@Service("historyService")
public class HistoryServiceImpl extends CommonServiceImpl implements HistoryService {
	@Autowired
	private HistoryMapper historyMapper;

	@Autowired
	public HistoryMapper getHistoryMapper() {
		return historyMapper;
	}

	@Autowired
	public void setHistoryMapper(HistoryMapper historyMapper) {
		this.historyMapper = historyMapper;
	}
	/**
	 * 新增实体对象
	 * @param history
	 */
	public History insertForVersioin(History history) throws PmException {
		this.historyMapper.insertForVersioin(history);
		return history;
	}
	/**
	 * 新增实体对象
	 * @param history
	 */
	public History insert(History history) throws PmException {
		this.historyMapper.insert(history);
		return history;
	}

	/**
	 * 删除实体对象
	 * @param history
	 */
	public int delete(History history) throws PmException {
		return this.historyMapper.delete(history);
	}

	/**
	 * 更新实体对象
	 * @param history
	 */
	public boolean update(History history) throws PmException {
		boolean result = true;
		this.historyMapper.update(history);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param history
	 */
	public History get(History history) throws PmException {
		return (History) this.historyMapper.get(history);
	}
	/**
	 * 查询单个实体时间最大的 
	 * @param history
	 */
	public History getMax(History history) throws PmException {
		return (History) this.historyMapper.getMax(history);
	}
	/**
	 * 查询实体列表
	 * @param history
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<History> select(History history) throws PmException {
		DataGrid<History> grid = new DataGrid<History>();
		
		Object obj = history;
		List list = historyMapper.select(obj);
		grid.setRows(list);
		int count;
		count = historyMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}