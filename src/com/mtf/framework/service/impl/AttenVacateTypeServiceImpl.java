package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttenVacateTypeMapper;
import com.mtf.framework.model.impl.AttenVacateTypeImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttenVacateTypeService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/6/17
**********************************************
*/
@Service("attenVacateTypeService")
public class AttenVacateTypeServiceImpl extends CommonServiceImpl implements AttenVacateTypeService {
	@Autowired
	private AttenVacateTypeMapper attenVacateTypeMapper;

	@Autowired
	public AttenVacateTypeMapper getAttenVacateTypeMapper() {
		return attenVacateTypeMapper;
	}

	@Autowired
	public void setAttenVacateTypeMapper(AttenVacateTypeMapper attenVacateTypeMapper) {
		this.attenVacateTypeMapper = attenVacateTypeMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenVacateType
	 */
	public AttenVacateTypeImpl insert(AttenVacateTypeImpl attenVacateType) throws PmException {
		this.attenVacateTypeMapper.insert(attenVacateType);
		return attenVacateType;
	}

	/**
	 * 删除实体对象
	 * @param attenVacateType
	 */
	public int delete(AttenVacateTypeImpl attenVacateType) throws PmException {
		return this.attenVacateTypeMapper.delete(attenVacateType);
	}

	/**
	 * 更新实体对象
	 * @param attenVacateType
	 */
	public boolean update(AttenVacateTypeImpl attenVacateType) throws PmException {
		boolean result = true;
		this.attenVacateTypeMapper.update(attenVacateType);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenVacateType
	 */
	@SuppressWarnings("unchecked")
	public List<AttenVacateTypeImpl> select(AttenVacateTypeImpl attenVacateType) throws PmException {
		return (List<AttenVacateTypeImpl>) this.attenVacateTypeMapper.select(attenVacateType);
	}
	/**
	 * 查询单个实体
	 * @param attenVacateType
	 */
	public AttenVacateTypeImpl get(AttenVacateTypeImpl attenVacateType) throws PmException {
		return (AttenVacateTypeImpl) this.attenVacateTypeMapper.get(attenVacateType);
	}
	/**
	 * 查询实体分页列表
	 * @param attenVacateType
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenVacateTypeImpl> search(AttenVacateTypeImpl attenVacateType) throws PmException {
		DataGrid<AttenVacateTypeImpl> grid = new DataGrid<AttenVacateTypeImpl>();
		Object obj = attenVacateType;
		List list = attenVacateTypeMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenVacateTypeMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}