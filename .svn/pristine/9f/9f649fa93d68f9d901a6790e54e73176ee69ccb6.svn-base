package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttenVacateMapper;
import com.mtf.framework.model.impl.AttenVacateImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttenVacateService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/5/5
**********************************************
*/
@Service("attenVacateService")
public class AttenVacateServiceImpl extends CommonServiceImpl implements AttenVacateService {
	@Autowired
	private AttenVacateMapper attenVacateMapper;

	@Autowired
	public AttenVacateMapper getAttenVacateMapper() {
		return attenVacateMapper;
	}

	@Autowired
	public void setAttenVacateMapper(AttenVacateMapper attenVacateMapper) {
		this.attenVacateMapper = attenVacateMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenVacate
	 */
	public AttenVacateImpl insert(AttenVacateImpl attenVacate) throws PmException {
		this.attenVacateMapper.insert(attenVacate);
		return attenVacate;
	}

	/**
	 * 删除实体对象
	 * @param attenVacate
	 */
	public int delete(AttenVacateImpl attenVacate) throws PmException {
		return this.attenVacateMapper.delete(attenVacate);
	}

	/**
	 * 更新实体对象
	 * @param attenVacate
	 */
	public boolean update(AttenVacateImpl attenVacate) throws PmException {
		Long id = attenVacate.getId();
		boolean result = true;
		if (null == id || "".equals(id)) {
			attenVacateMapper.insert(attenVacate);
		} else {
			this.attenVacateMapper.update(attenVacate);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenVacate
	 */
	@SuppressWarnings("unchecked")
	public List<AttenVacateImpl> select(AttenVacateImpl attenVacate) throws PmException {
		return (List<AttenVacateImpl>) this.attenVacateMapper.select(attenVacate);
	}
	/**
	 * 查询单个实体
	 * @param attenVacate
	 */
	public AttenVacateImpl get(AttenVacateImpl attenVacate) throws PmException {
		return (AttenVacateImpl) this.attenVacateMapper.get(attenVacate);
	}
	/**
	 * 查询实体分页列表
	 * @param attenVacate
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenVacateImpl> search(AttenVacateImpl attenVacate) throws PmException {
		DataGrid<AttenVacateImpl> grid = new DataGrid<AttenVacateImpl>();
		Object obj = attenVacate;
		List list = attenVacateMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenVacateMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}