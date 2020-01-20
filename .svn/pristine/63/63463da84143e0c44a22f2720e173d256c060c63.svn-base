package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.DivisionService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 部门表
 * 作者:     Auto
 * 日期:     2016/10/12
**********************************************
*/
@Service("divisionService")
public class DivisionServiceImpl extends CommonServiceImpl implements DivisionService {
	@Autowired
	private DivisionMapper divisionMapper;

	@Autowired
	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	@Autowired
	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
	}

	/**
	 * 新增实体对象
	 * @param division
	 */
	public DivisionImpl insert(DivisionImpl division) throws PmException {
		this.divisionMapper.insert(division);
		return division;
	}

	/**
	 * 删除实体对象
	 * @param division
	 */
	public int delete(DivisionImpl division) throws PmException {
		return this.divisionMapper.delete(division);
	}

	/**
	 * 更新实体对象
	 * @param division
	 */
	public boolean update(DivisionImpl division) throws PmException {
		boolean result = true;
		this.divisionMapper.update(division);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param division
	 */
	@SuppressWarnings("unchecked")
	public List<DivisionImpl> select(DivisionImpl division) throws PmException {
		return (List<DivisionImpl>) this.divisionMapper.select(division);
	}
	/**
	 * 查询单个实体
	 * @param division
	 */
	public DivisionImpl get(DivisionImpl division) throws PmException {
		return (DivisionImpl) this.divisionMapper.get(division);
	}
	/**
	 * 查询实体分页列表
	 * @param division
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<DivisionImpl> search(DivisionImpl division) throws PmException {
		DataGrid<DivisionImpl> grid = new DataGrid<DivisionImpl>();
		Object obj = division;
		List list = divisionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = divisionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}