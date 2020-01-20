package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DepofficeImpl;
import com.mtf.framework.dao.DepofficeMapper;
import com.mtf.framework.model.Depoffice;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.DepofficeService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 部门办公用品
 * 作者:     Auto
 * 日期:     2013-12-17
**********************************************
*/
@Service("depOfficeService")
public class DepofficeServiceImpl extends CommonServiceImpl implements DepofficeService {
	@Autowired
	private DepofficeMapper depOfficeMapper;

	@Autowired
	public DepofficeMapper getDepofficeMapper() {
		return depOfficeMapper;
	}

	@Autowired
	public void setDepofficeMapper(DepofficeMapper depOfficeMapper) {
		this.depOfficeMapper = depOfficeMapper;
	}

	/**
	 * 新增实体对象
	 * @param depOffice
	 */
	public DepofficeImpl insert(DepofficeImpl depOfficeImpl) throws PmException {
		this.depOfficeMapper.insert(depOfficeImpl);
		return depOfficeImpl;
	}

	/**
	 * 删除实体对象
	 * @param depOffice
	 */
	public int delete(DepofficeImpl depOfficeImpl) throws PmException {
		return this.depOfficeMapper.delete(depOfficeImpl);
	}

	/**
	 * 更新实体对象
	 * @param depOffice
	 */
	public boolean update(DepofficeImpl depOfficeImpl) throws PmException {
		boolean result = true;
		this.depOfficeMapper.update(depOfficeImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param depOffice
	 */
	public DepofficeImpl get(DepofficeImpl depOfficeImpl) throws PmException {
		return (DepofficeImpl) this.depOfficeMapper.get(depOfficeImpl);
	}
	/**
	 * 查询实体列表
	 * @param depOffice
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<DepofficeImpl> select(DepofficeImpl depOfficeImpl) throws PmException {
		DataGrid<DepofficeImpl> grid = new DataGrid<DepofficeImpl>();
		Object obj = depOfficeImpl;
		List list = depOfficeMapper.select(obj);
		grid.setRows(list);
		int count;
		count = depOfficeMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}