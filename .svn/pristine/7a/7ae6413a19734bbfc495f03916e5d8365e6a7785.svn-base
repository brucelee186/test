package com.mtf.framework.controller.attendance;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;
import com.mtf.framework.model.impl.AttenRecordImpl;
import com.mtf.framework.model.impl.AttendanceManageImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.service.AttenRecordService;
import com.mtf.framework.service.AttendanceManageService;
import com.mtf.framework.service.PermissionService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤审批记录
 * 作者:    Auto
 * 日期:    2015/5/15
**********************************************
*/
@Controller("attenRecordController")
@RequestMapping("/attendance/attenRecord")
public class AttenRecordController extends BaseController{

	@Autowired
	private AttenRecordService attenRecordService;
	
	@Autowired
	private PermissionService permissionService;

	@Autowired
	private AttendanceManageService attendanceManageService;

	@Autowired
	public AttendanceManageService getAttendanceManageService() {
		return attendanceManageService;
	}

	@Autowired
	public void setAttendanceManageService(
			AttendanceManageService attendanceManageService) {
		this.attendanceManageService = attendanceManageService;
	}
	@Autowired
	public PermissionService getPermissionService() {
		return permissionService;
	}

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public AttenRecordService getAttenRecordService() {
		return attenRecordService;
	}

	@Autowired
	public void setAttenRecordService(AttenRecordService attenRecordService) {
		this.attenRecordService = attenRecordService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(AttenRecordImpl attenRecord, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("/attendance/attenRecord/searchAttenRecord");
		// 取得当前用户对应的所有审批部门
		// 取得用户部门审批权限
		PermissionImpl permission = new PermissionImpl();
		permission.setParentCode("1403000");
		permission.setUserId(sessionInfo.getUserId());
		String  divisions = "'";
		String divisionIds = "";
		String tagPageCode = attenRecord.getTagPageCode();
		try {
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			if (null != listDivision && listDivision.size() >0) {
				for (int i = 0; i < listDivision.size(); i++) {
					PermissionImpl division = listDivision.get(i);
					divisions += division.getDivisionId();
					divisionIds += division.getDivisionId();
					if (i != (listDivision.size()-1)) {
						divisionIds += ",";
						divisions += "', '";
					} else {
						divisions += "'";
					}
				}
			}
		} catch (PmException e) {
			e.printStackTrace();
		}
		// 取得考勤统计日
		String dateAttenCount = "25";
		try {
			AttendanceManageImpl attenManage = new AttendanceManageImpl();
			attenManage = attendanceManageService.get(attenManage);
			dateAttenCount = attenManage.getDateAttenCount();
		} catch (Exception e) {
			e.printStackTrace();
			dateAttenCount = "25";
		}
		String dateAttenCountStart = CommonUtil.calculate("+", dateAttenCount, "1");
		if (dateAttenCount.length() == 1) {
			dateAttenCount = "0" + dateAttenCount;
		}
		
		if (dateAttenCountStart.length() == 1) {
			dateAttenCountStart = "0" + dateAttenCountStart;
		}
		String attenCollectDateStart = getLastMonth() + "-" + dateAttenCountStart;
		String attenCollectDateEnd = getCurrentMonth() + "-" + dateAttenCount;
		
		mv.addObject("attenCollectDateStart", attenCollectDateStart);
		mv.addObject("attenCollectDateEnd", attenCollectDateEnd);
		
		mv.addObject("attenRecord", attenRecord);
		mv.addObject("divisions", divisions);
		mv.addObject("divisionIds", divisionIds);
		mv.addObject("tagPageCode", tagPageCode);
		return mv;
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<AttenRecordImpl> doSearch(AttenRecordImpl attenRecord, HttpSession session) throws Exception {
		new PmException(session);
		//SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		/*String userId = sessionInfo.getUserId();
		String tag = attenRecord.getTag();*/
		/*if ("ap1".equals(tag)) {
			attenRecord.setApprover1(userId);
		} else if ("ap2".equals(tag)) {
			attenRecord.setApprover2(userId);
		}*/
		DataGrid<AttenRecordImpl> list = new DataGrid<AttenRecordImpl>();
		list = this.attenRecordService.search(attenRecord);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenRecordImpl attenRecord, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenRecord/editAttenRecord");
		String editState = attenRecord.getEditState();
		if ("u".equals(editState)) {
		attenRecord = attenRecordService.get(attenRecord);
		}
		attenRecord.setEditState(editState);
		mv.addObject("attenRecord", attenRecord);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenRecordImpl attenRecord, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenRecord.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenRecord, session);
				attenRecordService.insert(attenRecord);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenRecord, session);
				attenRecordService.update(attenRecord);
			} else if ("d".equals(editState)) {
				attenRecordService.delete(attenRecord);
			}
			j.setSuccess(true);
			j.setObj(attenRecord);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	/**
	 * 审批
	 */
	
	@RequestMapping("/approveAttendance")
	public ModelAndView approveAttendance(AttenRecordImpl attenRecord,HttpSession session) throws Exception{
		String tag = attenRecord.getTag();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		attenRecord.setApplyMonth(sessionInfo.getNowMonth());
		if ("re1".equals(tag)) {
			attenRecord.setTag("ap1");
		}
		this.attenRecordService.approve(attenRecord);
		return this.toSearch(attenRecord, session);
	}
}

