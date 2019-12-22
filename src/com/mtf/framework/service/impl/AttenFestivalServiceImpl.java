package com.mtf.framework.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Date;

import org.bouncycastle.crypto.tls.AlertDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.informix.util.dateUtil;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttenFestivalMapper;
import com.mtf.framework.model.impl.AttenFestivalImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttenFestivalService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 节假日管理
 * 作者:     Auto
 * 日期:     2015/4/21
**********************************************
*/
@Service("attenFestivalService")
public class AttenFestivalServiceImpl extends CommonServiceImpl implements AttenFestivalService {
	@Autowired
	private AttenFestivalMapper attenFestivalMapper;

	@Autowired
	public AttenFestivalMapper getAttenFestivalMapper() {
		return attenFestivalMapper;
	}

	@Autowired
	public void setAttenFestivalMapper(AttenFestivalMapper attenFestivalMapper) {
		this.attenFestivalMapper = attenFestivalMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenFestival
	 */
	public AttenFestivalImpl insert(AttenFestivalImpl attenFestival) throws PmException {
		this.attenFestivalMapper.insert(attenFestival);
		return attenFestival;
	}

	/**
	 * 删除实体对象
	 * @param attenFestival
	 */
	public int delete(AttenFestivalImpl attenFestival) throws PmException {
		Long id = Long.valueOf(attenFestival.getIdString());
		attenFestival.setId(id);
		AttenFestivalImpl attenFestival2 = new AttenFestivalImpl();
		attenFestival2.setPid(id);
		this.attenFestivalMapper.delete(attenFestival2);
		return this.attenFestivalMapper.delete(attenFestival);
	}

	/**
	 * 更新实体对象
	 * @param attenFestival
	 */
	public boolean update(AttenFestivalImpl attenFestival) throws PmException {
		boolean result = true;
		String idString = attenFestival.getIdString();
		// 如果没有编号，那么添加一条新记录
		String dayStartString = attenFestival.getDayStartString();
		String dayEndString = attenFestival.getDayEndString();
		try {
			// 起始时间
			Date dayStart = new SimpleDateFormat("yyyy-MM-dd").parse(dayStartString);
			attenFestival.setDayStart(dayStart);
			// 结束时间
			if (null != dayEndString && !"".equals(dayEndString)) {
				Date dayEnd = new SimpleDateFormat("yyyy-MM-dd").parse(dayEndString);;
				attenFestival.setDayEnd(dayEnd);
			} else {
				attenFestival.setDayEnd(null);
			}
			// m:主数据，d:明细
			attenFestival.setTag("m");
			// 取得按年循环标记，如果为否，那么设置年度
			String loopYear = attenFestival.getLoopYear();
			if (null != loopYear && "n".equals(loopYear)) {
				// 设置年度
				Calendar calendar = Calendar.getInstance();
				Integer year = calendar.get(Calendar.YEAR);
				//Date annual = new SimpleDateFormat("yyyy").parse(String.valueOf(year));
				attenFestival.setAnnual(String.valueOf(year));
			}
			
			if (null == idString) {
				this.attenFestivalMapper.insert(attenFestival);
				// 根据起始结束日期，插入明细数据
				attenFestival.setPid(attenFestival.getId());
			} else {
				Long id = Long.valueOf(attenFestival.getIdString());
				attenFestival.setId(id);
				
				this.attenFestivalMapper.update(attenFestival);
				attenFestival.setPid(id);
				// 删除明细数据
				AttenFestivalImpl attenFestivalTemp = new AttenFestivalImpl();
				if (id != null && !"".equals(id)) {
					attenFestivalTemp.setPid(id);
					attenFestivalMapper.delete(attenFestivalTemp);
				}
			}
			
			if (null == dayEndString || "".equals(dayEndString)) {
				attenFestival.setTag("d");
				attenFestival.setId(null);
				this.insertDetail(attenFestival);
			} else {
				attenFestival.setTag("d");
				attenFestival.setId(null);
				this.insertDetail(attenFestival);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void insertDetail(AttenFestivalImpl attenFestival) {
		Long pid = attenFestival.getPid();
		// 删除明细数据
		AttenFestivalImpl attenFestivalTemp = new AttenFestivalImpl();
		attenFestivalTemp.setPid(pid);
		attenFestivalMapper.delete(attenFestivalTemp);
		// 循环遍历日期
		Date dayStart = attenFestival.getDayStart();
		Date dayEnd = attenFestival.getDayEnd();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(dayStart);
		int dayStartOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		int startOfYear = calendar.get(calendar.YEAR);
		int dayAbsolute = 0;
		if (null != dayEnd) {
			calendar.setTime(dayEnd);
			int dayEndOfYear = calendar.get(Calendar.DAY_OF_YEAR);
			dayAbsolute = dayEndOfYear - dayStartOfYear;
			// 如果跨年那么计算决对值是取得上一年的天数
			if (dayEndOfYear < dayStartOfYear) {
				calendar.set(startOfYear, Calendar.DECEMBER, 31);
				int daysYear = calendar.get(Calendar.DAY_OF_YEAR);
				if (daysYear > 300 && daysYear < 400) {
					dayAbsolute = dayEndOfYear + daysYear - dayStartOfYear;
				}
			}
		}
		attenFestival.setDate(dayStart);
		String day =  new SimpleDateFormat("MM-dd").format(dayStart);
		attenFestival.setDay(day);
		for (int i = 0; i <= dayAbsolute; i++) {
			attenFestival.setId(null);
			// 根据起始结束日期，插入明细数据
			attenFestival.setPid(pid);
			attenFestival.setTag("d");
			/*if (i != 0) {
			}*/
			Date date = attenFestival.getDate();
			calendar.setTime(date);
			date = calendar.getTime();
			day = new SimpleDateFormat("MM-dd").format(date);
			attenFestival.setDate(date);
			attenFestival.setDay(day);
			this.attenFestivalMapper.insert(attenFestival);
			calendar.add(Calendar.DATE, 1);
			date = calendar.getTime();
			attenFestival.setDate(date);
		}
	}
	/**
	 * 查询实体列表
	 * @param attenFestival
	 */
	@SuppressWarnings("unchecked")
	public List<AttenFestivalImpl> select(AttenFestivalImpl attenFestival) throws PmException {
		return (List<AttenFestivalImpl>) this.attenFestivalMapper.select(attenFestival);
	}
	
	/**
	 * 查询单个实体
	 * @param attenFestival
	 */
	public AttenFestivalImpl get(AttenFestivalImpl attenFestival) throws PmException {
		return (AttenFestivalImpl) this.attenFestivalMapper.get(attenFestival);
	}
	
	/**
	 * 查询实体分页列表
	 * @param attenFestival
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenFestivalImpl> search(AttenFestivalImpl attenFestival) throws PmException {
		DataGrid<AttenFestivalImpl> grid = new DataGrid<AttenFestivalImpl>();
		Object obj = attenFestival;
		List list = attenFestivalMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenFestivalMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}