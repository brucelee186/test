package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.dao.AttenRecordMapper;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.model.impl.AttenRecordImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttenRecordService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤审批记录
 * 作者:     Auto
 * 日期:     2015/5/15
**********************************************
*/
@Service("attenRecordService")
public class AttenRecordServiceImpl extends CommonServiceImpl implements AttenRecordService {
	@Autowired
	private AttenRecordMapper attenRecordMapper;
	
	@Autowired
	private AttendanceMapper attendanceMapper;

	public AttendanceMapper getAttendanceMapper() {
		return attendanceMapper;
	}

	public void setAttendanceMapper(AttendanceMapper attendanceMapper) {
		this.attendanceMapper = attendanceMapper;
	}

	@Autowired
	public AttenRecordMapper getAttenRecordMapper() {
		return attenRecordMapper;
	}

	@Autowired
	public void setAttenRecordMapper(AttenRecordMapper attenRecordMapper) {
		this.attenRecordMapper = attenRecordMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenRecord
	 */
	public AttenRecordImpl insert(AttenRecordImpl attenRecord) throws PmException {
		this.attenRecordMapper.insert(attenRecord);
		return attenRecord;
	}

	/**
	 * 删除实体对象
	 * @param attenRecord
	 */
	public int delete(AttenRecordImpl attenRecord) throws PmException {
		return this.attenRecordMapper.delete(attenRecord);
	}

	/**
	 * 更新实体对象
	 * @param attenRecord
	 */
	public boolean update(AttenRecordImpl attenRecord) throws PmException {
		boolean result = true;
		this.attenRecordMapper.update(attenRecord);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenRecord
	 */
	@SuppressWarnings("unchecked")
	public List<AttenRecordImpl> select(AttenRecordImpl attenRecord) throws PmException {
		return (List<AttenRecordImpl>) this.attenRecordMapper.select(attenRecord);
	}
	/**
	 * 查询单个实体
	 * @param attenRecord
	 */
	public AttenRecordImpl get(AttenRecordImpl attenRecord) throws PmException {
		return (AttenRecordImpl) this.attenRecordMapper.get(attenRecord);
	}
	/**
	 * 查询实体分页列表
	 * @param attenRecord
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenRecordImpl> search(AttenRecordImpl attenRecord) throws PmException {
		DataGrid<AttenRecordImpl> grid = new DataGrid<AttenRecordImpl>();
		Object obj = attenRecord;
		List list = attenRecordMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenRecordMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 审批
	 * @param attenRecord
	 * @return
	 * @throws PmException
	 */
	public boolean approve(AttenRecordImpl attenRecord) throws PmException {
		String approveState = attenRecord.getTag();
		boolean result = true;
		if ("ap1".equals(approveState) || "re1".equals(approveState)) {
			
//			String approveMonth = attenRecord.getApplyMonth();
//			attenRecord.setApplyMonth(approveMonth);
			// 查询本月数据是否存在
			attenRecord.setJudApprove("ap1");
			AttenRecordImpl attenRecordTemp = (AttenRecordImpl) attenRecordMapper.get(attenRecord);
			Long idAttenRecord;
			if (null == attenRecordTemp) {
				attenRecord.setEditState("i");
				CommonUtil.setCommonModifyField(attenRecord);
				attenRecord.setDepartment("部门审批");
				attenRecord.setApproveDate1(new Date());
				attenRecord.setApprover1(attenRecord.getModifiedUser());
				idAttenRecord = attenRecordMapper.insert(attenRecord);
			}
			else {
				idAttenRecord = attenRecordTemp.getId();
				attenRecord.setEditState("u");
				CommonUtil.setCommonModifyField(attenRecord);
				attenRecord.setDepartment("部门审批");
				attenRecord.setApprover1(attenRecord.getModifiedUser());
				attenRecord.setApproveDate1(new Date());
				attenRecord.setId(idAttenRecord);
				attenRecordMapper.update(attenRecord);
			}
			
			// 审批状态  save:保存，submit:提交审批，commit：审批完毕
			// 取得所有被审批的编号
			String attenIds = attenRecord.getField1();
			String[] attenIdArray = attenIds.split(",");
			if (attenIdArray != null && attenIdArray.length > 0) {
				for (int i = 0; i < attenIdArray.length; i++) {
					Long id = Long.valueOf(attenIdArray[i]);
					AttendanceImpl attendance = new AttendanceImpl();
					attendance.setId(id);
					attendance.setStatusAttendance(approveState);
					attendance.setAttendRecordIdAp1(idAttenRecord);
					attendanceMapper.update(attendance);
				}
			} else{
				result = false;
			}
		
		} 
		// 二级行政部审批
		else if ("ap2".equals(approveState)) {
			// 审批状态  save:保存，submit:提交审批，commit：审批完毕
			// 取得月份
			attenRecord.setTag("ap2");
			String approveMonth = attenRecord.getApplyMonth();
			// 查询本月数据是否存在
			AttenRecordImpl attenRecordTemp = (AttenRecordImpl) attenRecordMapper.get(attenRecord);
			Long idAttenRecord;
			if (null == attenRecordTemp) {
				attenRecord.setEditState("i");
				CommonUtil.setCommonModifyField(attenRecord);
				attenRecord.setDepartment("行政部审批");
				attenRecord.setApproveDate2(new Date());
				attenRecord.setApprover2(attenRecord.getModifiedUser());
				idAttenRecord = attenRecordMapper.insert(attenRecord);
			}
			else {
				idAttenRecord = attenRecordTemp.getId();
				attenRecord.setId(idAttenRecord);
				attenRecord.setEditState("u");
				CommonUtil.setCommonModifyField(attenRecord);
				attenRecord.setDepartment("行政部审批");
				attenRecord.setApproveDate2(new Date());
				attenRecord.setApproveState("ap2");
				attenRecord.setApprover2(attenRecord.getModifiedUser());
				attenRecordMapper.update(attenRecord);
			}
			// 更新考勤状态
			AttendanceImpl attendance = new AttendanceImpl();
			attendance.setDateMonth(approveMonth);
			attendance.setStatusApprove("ap2");
			attendance.setJudApprove("ap2");
			attendance.setAttendRecordIdAp2(idAttenRecord);
			attendanceMapper.update(attendance);
		}
		return result;
	}
}