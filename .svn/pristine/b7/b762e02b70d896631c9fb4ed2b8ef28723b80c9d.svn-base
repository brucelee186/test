package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.InformationMapper;
import com.mtf.framework.model.Information;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.InformationService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 系统管理员提示信息
 * 作者:     Auto
 * 日期:     2014/1/17
**********************************************
*/
@Service("informationService")
public class InformationServiceImpl extends CommonServiceImpl implements InformationService {
	@Autowired
	private InformationMapper informationMapper;

	@Autowired
	public InformationMapper getInformationMapper() {
		return informationMapper;
	}

	@Autowired
	public void setInformationMapper(InformationMapper informationMapper) {
		this.informationMapper = informationMapper;
	}

	/**
	 * 新增实体对象
	 * @param information
	 */
	public Information insert(Information information) throws PmException {
		this.informationMapper.insert(information);
		return information;
	}

	/**
	 * 删除实体对象
	 * @param information
	 */
	public int delete(Information information) throws PmException {
		return this.informationMapper.delete(information);
	}

	/**
	 * 更新实体对象
	 * @param information
	 */
	public boolean update(Information information) throws PmException {
		boolean result = true;
		this.informationMapper.update(information);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param information
	 */
	public Information get(Information information) throws PmException {
		return (Information) this.informationMapper.get(information);
	}
	/**
	 * 查询实体列表
	 * @param information
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<Information> select(Information information) throws PmException {
		DataGrid<Information> grid = new DataGrid<Information>();
		Object obj = information;
		List list = informationMapper.select(obj);
		grid.setRows(list);
		int count;
		count = informationMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}