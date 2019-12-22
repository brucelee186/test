package com.mtf.framework.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttenDayMapper;
import com.mtf.framework.model.impl.AttenDayImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttenDayService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤时段
 * 作者:     Auto
 * 日期:     2015/5/6
**********************************************
*/
@Service("attenDayService")
public class AttenDayServiceImpl extends CommonServiceImpl implements AttenDayService {
	@Autowired
	private AttenDayMapper attenDayMapper;

	@Autowired
	public AttenDayMapper getAttenDayMapper() {
		return attenDayMapper;
	}

	@Autowired
	public void setAttenDayMapper(AttenDayMapper attenDayMapper) {
		this.attenDayMapper = attenDayMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenDay
	 */
	public AttenDayImpl insert(AttenDayImpl attenDay) throws PmException {
		this.attenDayMapper.insert(attenDay);
		return attenDay;
	}

	/**
	 * 删除实体对象
	 * @param attenDay
	 */
	public int delete(AttenDayImpl attenDay) throws PmException {
		return this.attenDayMapper.delete(attenDay);
	}

	/**
	 * 更新实体对象
	 * @param attenDay
	 */
	public boolean update(AttenDayImpl attenDay) throws PmException {
		boolean result;
		result = true;
		try {
			Long id = attenDay.getId();
			// 拼接hour与minute字段
			String hourStart = attenDay.getHourStart();
			String hourEnd = attenDay.getHourEnd();
			String minuteStart = attenDay.getMinuteStart();
			String minuteEnd = attenDay.getMinuteEnd();
			String timeStartString = hourStart + ":" + minuteStart + ":00";
			String timeEndString = hourEnd + ":" + minuteEnd + ":00";
			SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
			Date timeStart = format.parse(timeStartString);
			Date timeEnd = format.parse(timeEndString);
			attenDay.setTimeStart(timeStart);
			attenDay.setTimeEnd(timeEnd);
			
			// 计算工作时长(包括午休时间)
			Double dateStart =  Double.valueOf(hourStart) + (Double.valueOf(minuteStart) - 10)/60;
			Double dateEnd =  Double.valueOf(hourEnd) + (Double.valueOf(minuteEnd) + 10)/60;
			Double workDuration = dateEnd - dateStart;
			attenDay.setWorkDuration(workDuration);
			if (null == id || "".equals(id)) {
				this.attenDayMapper.insert(attenDay);
			} else {
				this.attenDayMapper.update(attenDay);
			}
		} catch (ParseException e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenDay
	 */
	@SuppressWarnings("unchecked")
	public List<AttenDayImpl> select(AttenDayImpl attenDay) throws PmException {
		return (List<AttenDayImpl>) this.attenDayMapper.select(attenDay);
	}
	/**
	 * 查询单个实体
	 * @param attenDay
	 */
	public AttenDayImpl get(AttenDayImpl attenDay) throws PmException {
		return (AttenDayImpl) this.attenDayMapper.get(attenDay);
	}
	/**
	 * 查询实体分页列表
	 * @param attenDay
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenDayImpl> search(AttenDayImpl attenDay) throws PmException {
		DataGrid<AttenDayImpl> grid = new DataGrid<AttenDayImpl>();
		Object obj = attenDay;
		List list = attenDayMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenDayMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}