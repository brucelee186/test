package com.mtf.framework.controller.attendance;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fr.report.core.A.DA;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.UserInfor;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.AttenVacateManageService;
import com.mtf.framework.service.AttendanceService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/15
**********************************************
*/
@Controller("attendanceController") 
@RequestMapping("/attendance/attendance")
public class AttendanceController extends BaseController{

	@Autowired
	private AttendanceService attendanceService;
	
	@Autowired
	private AttenVacateManageService attenVacateManageService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private UserInforService userInforService;

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public PermissionService getPermissionService() {
		return permissionService;
	}

	@Autowired
	public AttenVacateManageService getAttenVacateManageService() {
		return attenVacateManageService;
	}

	@Autowired
	public void setAttenVacateManageService(
			AttenVacateManageService attenVacateManageService) {
		this.attenVacateManageService = attenVacateManageService;
	}

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public AttendanceService getAttendanceService() {
		return attendanceService;
	}

	@Autowired
	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(AttendanceImpl attendance, HttpSession session) {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("/attendance/attendance/searchAttendance");
		String tagPageCode = attendance.getTagPageCode();
		try {
			// 取得用户部门审批权限
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(sessionInfo.getUserId());
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			mv.addObject("attendance", attendance);
			mv.addObject("divisionList", listDivision);
			// 取得地点下拉列表
			UserInforImpl userInfor = new UserInforImpl();
			userInfor.setType("bqdd");
			// 明细
			userInfor.setFlag("i");
			List<UserInforImpl> listUserInfor = userInforService.search(userInfor);
			JSONArray jsonArrayUserInfor = new JSONArray();
			jsonArrayUserInfor.add(listUserInfor);
			mv.addObject("jsonArraySigninLocation", jsonArrayUserInfor);
			
			// 取得时间段下拉列表
			userInfor = new UserInforImpl();
			userInfor.setType("bqsjd");
			// 明细
			userInfor.setFlag("i");
			listUserInfor = userInforService.search(userInfor);
			jsonArrayUserInfor = new JSONArray();
			jsonArrayUserInfor.add(listUserInfor);
			mv.addObject("jsonArraySigninDate", jsonArrayUserInfor);
			mv.addObject("tagPageCode", tagPageCode);
			// 取得开始和结果默认查询时间
			Date dateEnd = new Date();
			//Calendar calendar = Calendar.getInstance();
			//calendar.setTime(dateEnd);
			//calendar.add(Calendar.MONDAY, -1);
			//Date dateStart = calendar.getTime();
			//mv.addObject("dateStart", dateStart);
			mv.addObject("dateEnd", dateEnd);
		} catch (PmException e) {
			e.printStackTrace();
		}
		return mv;
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch2", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<AttendanceImpl> doSearch2(AttendanceImpl attendance, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttendanceImpl> list = new DataGrid<AttendanceImpl>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		// 取得查询状态,如果是审批,那么查询所有,被签查询个人
		String tagSearch = attendance.getTagSearch();
		if (null != tagSearch && "re".equals(tagSearch)) {
			String userId = sessionInfo.getUserId();
			attendance.setUserId(userId);
		} else if (tagSearch.equals("ap1")) {
			// 取得用户部门审批权限
			attendance.setStatusAttendance("re");
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(sessionInfo.getUserId());
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			attendance.setListDivision(listDivision);
			// 根据权限取得对应的审批数据
		} else if (tagSearch.equals("ap2")) {
			// 取得用户部门审批权限
			String statusAttendance = attendance.getStatusAttendance();
			/*if (null == statusAttendance) {
				attendance.setStatusAttendance("ap1");
			}*/
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(sessionInfo.getUserId());
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			attendance.setListDivision(listDivision);
			// 根据权限取得对应的审批数据
		}
		// 根据权限取得对应的审批数据
		list = this.attendanceService.search(attendance);
		return list;
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
	public DataGrid<AttendanceImpl> doSearch(AttendanceImpl attendance, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttendanceImpl> list = new DataGrid<AttendanceImpl>();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		String tagSearch = attendance.getTagSearch();
		// 考勤调整 1619000
		String tagPageCode = attendance.getTagPageCode();
		if ("re".equals(tagSearch) || "1619000".equals(tagPageCode)) {
			// 取得查询状态,如果是审批,那么查询所有,被签查询个人
			Integer userLevel = getUserLevel();
			if (9 != userLevel && !"1619000".equals(tagPageCode)) {
				String userId = sessionInfo.getUserId();
				attendance.setUserId(userId);
			}
			// 如果是考勤调整情况下，只填写结束日期默认只查询开始与结束为同一天的记录
			if("1619000".equals(tagPageCode)){
				Date dateStart = attendance.getDateStart();
				Date dateEnd = attendance.getDateEnd();
				if(null == dateStart || "".equals(dateStart) && null != dateEnd && !"".equals(dateEnd)){
					dateStart = dateEnd;
					attendance.setDateStart(dateStart);
				}
			}
			// 根据权限取得对应的审批数据
			list = this.attendanceService.search(attendance);
			// 如果为查询旷工的情况
		} else if ("ab".equals(tagSearch)) {
			list = attendanceService.searchAttenAbsence(attendance);
		}
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attendance
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttendanceImpl attendance, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attendance/editAttendance");
		String editState = attendance.getEditState();
		if ("u".equals(editState)) {
			attendance = attendanceService.get(attendance);
		}
		attendance.setEditState(editState);
		mv.addObject("attendance", attendance);
		return mv;
	}

	/**
	 * 编辑
	 * @param attendance
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttendanceImpl attendance, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attendance.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attendance, session);
				attendanceService.insert(attendance);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attendance, session);
				attendanceService.update(attendance);
			} else if ("a".equals(editState)) {
				CommonUtil.setCommonField(attendance, session);
				attendanceService.update(attendance);
			} else if ("d".equals(editState)) {
				attendanceService.delete(attendance);
			}
			j.setSuccess(true);
			j.setObj(attendance);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	/**
	 * 编辑
	 * @param attendanceTemp
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/reCheckin", method = RequestMethod.POST)
	@ResponseBody
	public Json reCheckin(AttendanceImpl attendance, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String tagPageCode = attendance.getTagPageCode();
		try {
			// 取得审批标记
			String tagSearch = attendance.getTagSearch();
			Long idVacateManage = null;
			// 如果为考勤调整那么不走以下流程
			if("1619000".equals(tagPageCode)){
				Long idAttendance = attendance.getId();
				//String tagAdjust = attendance.getTagAdjust();
				//String tagAdjust = attendance.getTagAdjust();
				AttendanceImpl attendanceTemp = new AttendanceImpl();
				attendanceTemp.setId(idAttendance);
				attendanceTemp = attendanceService.get(attendanceTemp);
				String tagAdjust = attendanceTemp.getTagAdjust();
				String statusAttendance = "no";
				String remark = attendance.getRemark();
				attendanceTemp.setRemark(remark);
				if(null == tagAdjust || "".equals(tagAdjust) || "n".equals(tagAdjust)){
					tagAdjust = "y";
					attendanceTemp.setTagAdjust(tagAdjust);
					attendanceService.calculateAttendanceWork(attendanceTemp);
				// 如果是撤销情况下
				} else {
					tagAdjust = "n";
					statusAttendance = "ns";
					attendanceTemp.setRemark("");
					attendanceTemp.setTagAdjust(tagAdjust);
					attendanceService.calculateAttendanceWork(attendanceTemp);
				}
				attendanceTemp.setStatusAttendance(statusAttendance);
				attendanceTemp.setSigninLocation("bqdd14");
				attendanceService.update(attendanceTemp);
				
			}
			else if (null != tagSearch && "re".equals(tagSearch)) {
				CommonUtil.setCommonField(attendance, session);
				// remark: re,补签
				attendance.setStatusAttendance(tagSearch);
				Long attendanceId = attendance.getId();
				AttendanceImpl attendanceTemp = new AttendanceImpl();
				attendanceTemp.setId(attendanceId);
				attendanceTemp = attendanceService.get(attendanceTemp);
				String dateSign = attendanceTemp.getDate();
				//　补签时，插入到主表中一条记录，预留审批
				AttenVacateManageImpl attenVacateManageTemp = new AttenVacateManageImpl();
				attenVacateManageTemp.setDateStart(dateSign);
				attenVacateManageTemp.setDateEnd(dateSign);
				attenVacateManageTemp.setUserId(getUserId());
				attenVacateManageTemp.setTypeData("a");
				attenVacateManageTemp = attenVacateManageService.get(attenVacateManageTemp);
				AttenVacateManageImpl attenVacateManage = new AttenVacateManageImpl();
				// 数据类型(v:vacate请假，a:attendance考勤)
				attenVacateManage.setTypeData("a");
				attenVacateManage.setName("补签");
				attenVacateManage.setUserId(getUserId());
				attenVacateManage.setUserName(getUserName());
				attenVacateManage.setDateStart(dateSign);
				attenVacateManage.setDateEnd(dateSign);
				attenVacateManage.setDivisionId(attendanceTemp.getDivisionId());
				attenVacateManage.setDivisionName(attendanceTemp.getDivisionName());
				attenVacateManage.setCardNo(getCardNo());
				attenVacateManage.setApproveStatus("s");
				if (null == attenVacateManageTemp) {
					attenVacateManage.setEditState("i");
					CommonUtil.setCommonField(attenVacateManage);
					attenVacateManageService.insert(attenVacateManage);
					idVacateManage = attenVacateManage.getId();
				} else {
					String remark = attenVacateManageTemp.getRemark();
					String remarkReject = attenVacateManageTemp.getRemarkReject();
					attenVacateManage.setRemark(remark);
					attenVacateManage.setRemarkReject(remarkReject);
					attenVacateManage.setEditState("u");
					CommonUtil.setCommonField(attenVacateManage);
					idVacateManage = attenVacateManageTemp.getId();
					attenVacateManage.setId(idVacateManage);
					attenVacateManageService.update(attenVacateManage);
				}
				// 更新父类编号
				attendance.setIdVacateManage(idVacateManage);
				// 数据类型(v:vacate请假，a:attendance考勤)
				attendance.setStatusVacate("a");
				// 忽略idVacate为更新条件
				attendance.setUpIgnoreIdVacate("y");
				attendanceService.update(attendance);
			} else if (tagSearch.startsWith("ap") || tagSearch.startsWith("re")) {
				// 截取所有字符串
				String arrayId = attendance.getArrayId();
				String[] arrayStringId = arrayId.split(",");
				if (null != arrayStringId && arrayStringId.length >0) {
					for (int i = 0; i < arrayStringId.length; i++) {
						attendance = new AttendanceImpl();
						Long id = Long.valueOf(arrayStringId[i]);
						CommonUtil.setCommonField(attendance, session);
						// remark: re,补签
						attendance.setId(id);
						attendance.setStatusAttendance(tagSearch);
						attendance.setIdVacateManage(idVacateManage);
						attendanceService.update(attendance);
					}
				}
			}
			j.setSuccess(true);
			j.setObj(attendance);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

