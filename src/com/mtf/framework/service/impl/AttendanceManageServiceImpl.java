package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.AttendanceManageMapper;
import com.mtf.framework.model.impl.AttendanceManageImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttendanceManageService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 请假管理
 * 作者:     Auto
 * 日期:     2015/8/5
**********************************************
*/
@Service("attendanceManageService")
public class AttendanceManageServiceImpl extends CommonServiceImpl implements AttendanceManageService {
	@Autowired
	private AttendanceManageMapper attendanceManageMapper;

	@Autowired
	public AttendanceManageMapper getAttendanceManageMapper() {
		return attendanceManageMapper;
	}

	@Autowired
	public void setAttendanceManageMapper(AttendanceManageMapper attendanceManageMapper) {
		this.attendanceManageMapper = attendanceManageMapper;
	}

	/**
	 * 新增实体对象
	 * @param attendanceManage
	 */
	public AttendanceManageImpl insert(AttendanceManageImpl attendanceManage) throws PmException {
		this.attendanceManageMapper.insert(attendanceManage);
		return attendanceManage;
	}

	/**
	 * 删除实体对象
	 * @param attendanceManage
	 */
	public int delete(AttendanceManageImpl attendanceManage) throws PmException {
		return this.attendanceManageMapper.delete(attendanceManage);
	}

	/**
	 * 更新实体对象
	 * @param attendanceManage
	 */
	public boolean update(AttendanceManageImpl attendanceManage) throws PmException {
		boolean result = true;
		this.attendanceManageMapper.update(attendanceManage);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attendanceManage
	 */
	@SuppressWarnings("unchecked")
	public List<AttendanceManageImpl> select(AttendanceManageImpl attendanceManage) throws PmException {
		return (List<AttendanceManageImpl>) this.attendanceManageMapper.select(attendanceManage);
	}
	/**
	 * 查询单个实体
	 * @param attendanceManage
	 */
	public AttendanceManageImpl get(AttendanceManageImpl attendanceManage) throws PmException {
		return (AttendanceManageImpl) this.attendanceManageMapper.get(attendanceManage);
	}
	/**
	 * 查询实体分页列表
	 * @param attendanceManage
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttendanceManageImpl> search(AttendanceManageImpl attendanceManage) throws PmException {
		DataGrid<AttendanceManageImpl> grid = new DataGrid<AttendanceManageImpl>();
		Object obj = attendanceManage;
		List list = attendanceManageMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attendanceManageMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}