package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenVacateTypeImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/6/17
**********************************************
*/
public interface AttenVacateTypeService {
	/**
	 * 新增实体对象
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public AttenVacateTypeImpl insert(AttenVacateTypeImpl attenVacateType) throws PmException;

	/**
	 * 删除实体对象
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public int delete(AttenVacateTypeImpl attenVacateType) throws PmException;

	/**
	 * 更新实体对象
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttenVacateTypeImpl attenVacateType) throws PmException;

	/**
	 * 查询实体列表
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public List<AttenVacateTypeImpl> select(AttenVacateTypeImpl attenVacateType) throws PmException;

	/**
	 * 取得单一对象
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public AttenVacateTypeImpl get(AttenVacateTypeImpl attenVacateType) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attenVacateType
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenVacateTypeImpl> search(AttenVacateTypeImpl attenVacateType) throws PmException;

}