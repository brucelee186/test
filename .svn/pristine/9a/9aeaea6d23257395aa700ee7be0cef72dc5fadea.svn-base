package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.SysHistoryMapper;
import com.mtf.framework.model.impl.SysHistoryImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.SysHistoryService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 系统历史表
 * 作者:     Auto
 * 日期:     2016/5/26
**********************************************
*/
@Service("sysHistoryService")
public class SysHistoryServiceImpl extends CommonServiceImpl implements SysHistoryService {
	@Autowired
	private SysHistoryMapper sysHistoryMapper;

	@Autowired
	public SysHistoryMapper getSysHistoryMapper() {
		return sysHistoryMapper;
	}

	@Autowired
	public void setSysHistoryMapper(SysHistoryMapper sysHistoryMapper) {
		this.sysHistoryMapper = sysHistoryMapper;
	}

	/**
	 * 新增实体对象
	 * @param sysHistory
	 */
	public SysHistoryImpl insert(SysHistoryImpl sysHistory) throws PmException {
		this.sysHistoryMapper.insert(sysHistory);
		return sysHistory;
	}

	/**
	 * 删除实体对象
	 * @param sysHistory
	 */
	public int delete(SysHistoryImpl sysHistory) throws PmException {
		return this.sysHistoryMapper.delete(sysHistory);
	}

	/**
	 * 更新实体对象
	 * @param sysHistory
	 */
	public boolean update(SysHistoryImpl sysHistory) throws PmException {
		boolean result = true;
		this.sysHistoryMapper.update(sysHistory);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param sysHistory
	 */
	@SuppressWarnings("unchecked")
	public List<SysHistoryImpl> select(SysHistoryImpl sysHistory) throws PmException {
		return (List<SysHistoryImpl>) this.sysHistoryMapper.select(sysHistory);
	}
	/**
	 * 查询单个实体
	 * @param sysHistory
	 */
	public SysHistoryImpl get(SysHistoryImpl sysHistory) throws PmException {
		return (SysHistoryImpl) this.sysHistoryMapper.get(sysHistory);
	}
	/**
	 * 查询实体分页列表
	 * @param sysHistory
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<SysHistoryImpl> search(SysHistoryImpl sysHistory) throws PmException {
		DataGrid<SysHistoryImpl> grid = new DataGrid<SysHistoryImpl>();
		Object obj = sysHistory;
		List list = sysHistoryMapper.select(obj);
		grid.setRows(list);
		int count;
		count = sysHistoryMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}