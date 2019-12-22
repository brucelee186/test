package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.SysLogMapper;
import com.mtf.framework.model.impl.SysLogImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.SysLogService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 系统日志
 * 作者:     Auto
 * 日期:     2017/4/20
**********************************************
*/
@Service("sysLogService")
public class SysLogServiceImpl extends CommonServiceImpl implements SysLogService {
	@Autowired
	private SysLogMapper sysLogMapper;

	@Autowired
	public SysLogMapper getSysLogMapper() {
		return sysLogMapper;
	}

	@Autowired
	public void setSysLogMapper(SysLogMapper sysLogMapper) {
		this.sysLogMapper = sysLogMapper;
	}

	/**
	 * 新增实体对象
	 * @param sysLog
	 */
	public SysLogImpl insert(SysLogImpl sysLog) throws PmException {
		this.sysLogMapper.insert(sysLog);
		return sysLog;
	}

	/**
	 * 删除实体对象
	 * @param sysLog
	 */
	public int delete(SysLogImpl sysLog) throws PmException {
		return this.sysLogMapper.delete(sysLog);
	}

	/**
	 * 更新实体对象
	 * @param sysLog
	 */
	public boolean update(SysLogImpl sysLog) throws PmException {
		boolean result = true;
		this.sysLogMapper.update(sysLog);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param sysLog
	 */
	@SuppressWarnings("unchecked")
	public List<SysLogImpl> select(SysLogImpl sysLog) throws PmException {
		return (List<SysLogImpl>) this.sysLogMapper.select(sysLog);
	}
	/**
	 * 查询单个实体
	 * @param sysLog
	 */
	public SysLogImpl get(SysLogImpl sysLog) throws PmException {
		return (SysLogImpl) this.sysLogMapper.get(sysLog);
	}
	/**
	 * 查询实体分页列表
	 * @param sysLog
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<SysLogImpl> search(SysLogImpl sysLog) throws PmException {
		DataGrid<SysLogImpl> grid = new DataGrid<SysLogImpl>();
		Object obj = sysLog;
		List list = sysLogMapper.select(obj);
		grid.setRows(list);
		int count;
		count = sysLogMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}