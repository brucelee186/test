package com.mtf.framework.controller.attendance;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.model.impl.AttendanceManageImpl;
import com.mtf.framework.service.AttendanceManageService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/8/5
**********************************************
*/
@Controller("attendanceManageController")
@RequestMapping("/attendance/attendanceManage")
public class AttendanceManageController extends BaseController{

	@Autowired
	private AttendanceManageService attendanceManageService;

	@Autowired
	public AttendanceManageService getAttendanceManageService() {
		return attendanceManageService;
	}

	@Autowired
	public void setAttendanceManageService(AttendanceManageService attendanceManageService) {
		this.attendanceManageService = attendanceManageService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/attendance/attendanceManage/searchAttendanceManage");
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
	public DataGrid<AttendanceManageImpl> doSearch(AttendanceManageImpl attendanceManage, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttendanceManageImpl> list = new DataGrid<AttendanceManageImpl>();
		list = this.attendanceManageService.search(attendanceManage);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attendanceManage
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttendanceManageImpl attendanceManage, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attendanceManage/editAttendanceManage");
		String editState = attendanceManage.getEditState();
		if ("u".equals(editState)) {
		attendanceManage = attendanceManageService.get(attendanceManage);
		}
		attendanceManage.setEditState(editState);
		mv.addObject("attendanceManage", attendanceManage);
		return mv;
	}

	/**
	 * 编辑
	 * @param attendanceManage
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttendanceManageImpl attendanceManage, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attendanceManage.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attendanceManage, session);
				attendanceManageService.insert(attendanceManage);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attendanceManage, session);
				attendanceManageService.update(attendanceManage);
			} else if ("d".equals(editState)) {
				attendanceManageService.delete(attendanceManage);
			}
			j.setSuccess(true);
			j.setObj(attendanceManage);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

