package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ElectricityMeterImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 电表
 * 作者:     Auto
 * 日期:     2018/5/17
**********************************************
*/
public interface ElectricityMeterService {
	/**
	 * 新增实体对象
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public ElectricityMeterImpl insert(ElectricityMeterImpl electricityMeter) throws PmException;

	/**
	 * 删除实体对象
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public int delete(ElectricityMeterImpl electricityMeter) throws PmException;

	/**
	 * 更新实体对象
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public boolean update(ElectricityMeterImpl electricityMeter) throws PmException;

	/**
	 * 查询实体列表
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public List<ElectricityMeterImpl> select(ElectricityMeterImpl electricityMeter) throws PmException;

	/**
	 * 取得单一对象
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public ElectricityMeterImpl get(ElectricityMeterImpl electricityMeter) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param electricityMeter
	 * @return
	 * @throws PmException
	 */
	public DataGrid<ElectricityMeterImpl> search(ElectricityMeterImpl electricityMeter) throws PmException;

}