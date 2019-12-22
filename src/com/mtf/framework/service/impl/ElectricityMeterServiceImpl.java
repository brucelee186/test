package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.ElectricityMeterMapper;
import com.mtf.framework.model.impl.ElectricityMeterImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.ElectricityMeterService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 电表
 * 作者:     Auto
 * 日期:     2018/5/17
**********************************************
*/
@Service("electricityMeterService")
public class ElectricityMeterServiceImpl extends CommonServiceImpl implements ElectricityMeterService {
	@Autowired
	private ElectricityMeterMapper electricityMeterMapper;

	@Autowired
	public ElectricityMeterMapper getElectricityMeterMapper() {
		return electricityMeterMapper;
	}

	@Autowired
	public void setElectricityMeterMapper(ElectricityMeterMapper electricityMeterMapper) {
		this.electricityMeterMapper = electricityMeterMapper;
	}

	/**
	 * 新增实体对象
	 * @param electricityMeter
	 */
	public ElectricityMeterImpl insert(ElectricityMeterImpl electricityMeter) throws PmException {
		this.electricityMeterMapper.insert(electricityMeter);
		return electricityMeter;
	}

	/**
	 * 删除实体对象
	 * @param electricityMeter
	 */
	public int delete(ElectricityMeterImpl electricityMeter) throws PmException {
		return this.electricityMeterMapper.delete(electricityMeter);
	}

	/**
	 * 更新实体对象
	 * @param electricityMeter
	 */
	public boolean update(ElectricityMeterImpl electricityMeter) throws PmException {
		boolean result = true;
		this.electricityMeterMapper.update(electricityMeter);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param electricityMeter
	 */
	@SuppressWarnings("unchecked")
	public List<ElectricityMeterImpl> select(ElectricityMeterImpl electricityMeter) throws PmException {
		return (List<ElectricityMeterImpl>) this.electricityMeterMapper.select(electricityMeter);
	}
	/**
	 * 查询单个实体
	 * @param electricityMeter
	 */
	public ElectricityMeterImpl get(ElectricityMeterImpl electricityMeter) throws PmException {
		return (ElectricityMeterImpl) this.electricityMeterMapper.get(electricityMeter);
	}
	/**
	 * 查询实体分页列表
	 * @param electricityMeter
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ElectricityMeterImpl> search(ElectricityMeterImpl electricityMeter) throws PmException {
		DataGrid<ElectricityMeterImpl> grid = new DataGrid<ElectricityMeterImpl>();
		Object obj = electricityMeter;
		List list = electricityMeterMapper.select(obj);
		grid.setRows(list);
		int count;
		count = electricityMeterMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}