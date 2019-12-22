package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttMonitorLogMapper;
import com.mtf.framework.model.impl.AttMonitorLogImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttMonitorLogService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 门禁数据
 * 作者:     Auto
 * 日期:     2015/4/29
**********************************************
*/
@Service("attMonitorLogService")
public class AttMonitorLogServiceImpl extends CommonServiceImpl implements AttMonitorLogService {
	@Autowired
	private AttMonitorLogMapper attMonitorLogMapper;

	@Autowired
	public AttMonitorLogMapper getAttMonitorLogMapper() {
		return attMonitorLogMapper;
	}

	@Autowired
	public void setAttMonitorLogMapper(AttMonitorLogMapper attMonitorLogMapper) {
		this.attMonitorLogMapper = attMonitorLogMapper;
	}

	/**
	 * 新增实体对象
	 * @param attMonitorLog
	 */
	public AttMonitorLogImpl insert(AttMonitorLogImpl attMonitorLog) throws PmException {
		this.attMonitorLogMapper.insert(attMonitorLog);
		return attMonitorLog;
	}

	/**
	 * 删除实体对象
	 * @param attMonitorLog
	 */
	public int delete(AttMonitorLogImpl attMonitorLog) throws PmException {
		return this.attMonitorLogMapper.delete(attMonitorLog);
	}

	/**
	 * 更新实体对象
	 * @param attMonitorLog
	 */
	public boolean update(AttMonitorLogImpl attMonitorLog) throws PmException {
		boolean result = true;
		this.attMonitorLogMapper.update(attMonitorLog);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attMonitorLog
	 */
	@SuppressWarnings("unchecked")
	public List<AttMonitorLogImpl> select(AttMonitorLogImpl attMonitorLog) throws PmException {
		return (List<AttMonitorLogImpl>) this.attMonitorLogMapper.select(attMonitorLog);
	}
	/**
	 * 查询单个实体
	 * @param attMonitorLog
	 */
	public AttMonitorLogImpl get(AttMonitorLogImpl attMonitorLog) throws PmException {
		return (AttMonitorLogImpl) this.attMonitorLogMapper.get(attMonitorLog);
	}
	/**
	 * 查询实体分页列表
	 * @param attMonitorLog
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttMonitorLogImpl> search(AttMonitorLogImpl attMonitorLog) throws PmException {
		DataGrid<AttMonitorLogImpl> grid = new DataGrid<AttMonitorLogImpl>();
		Object obj = attMonitorLog;
		List list = attMonitorLogMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attMonitorLogMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}