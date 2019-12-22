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
import com.mtf.framework.model.impl.AttMonitorLogImpl;
import com.mtf.framework.service.AttMonitorLogService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 门禁数据
 * 作者:    Auto
 * 日期:    2015/4/29
**********************************************
*/
@Controller("attMonitorLogController")
@RequestMapping("/attendance/attMonitorLog")
public class AttMonitorLogController {

	@Autowired
	private AttMonitorLogService attMonitorLogService;

	@Autowired
	public AttMonitorLogService getAttMonitorLogService() {
		return attMonitorLogService;
	}

	@Autowired
	public void setAttMonitorLogService(AttMonitorLogService attMonitorLogService) {
		this.attMonitorLogService = attMonitorLogService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/attendance/attMonitorLog/searchAttMonitorLog");
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
	public DataGrid<AttMonitorLogImpl> doSearch(AttMonitorLogImpl attMonitorLog, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttMonitorLogImpl> list = new DataGrid<AttMonitorLogImpl>();
		list = this.attMonitorLogService.search(attMonitorLog);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attMonitorLog
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttMonitorLogImpl attMonitorLog, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attMonitorLog/editAttMonitorLog");
		String editState = attMonitorLog.getEditState();
		if ("u".equals(editState)) {
		attMonitorLog = attMonitorLogService.get(attMonitorLog);
		}
		attMonitorLog.setEditState(editState);
		mv.addObject("attMonitorLog", attMonitorLog);
		return mv;
	}

	/**
	 * 编辑
	 * @param attMonitorLog
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttMonitorLogImpl attMonitorLog, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attMonitorLog.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attMonitorLog, session);
				attMonitorLogService.insert(attMonitorLog);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attMonitorLog, session);
				attMonitorLogService.update(attMonitorLog);
			} else if ("d".equals(editState)) {
				attMonitorLogService.delete(attMonitorLog);
			}
			j.setSuccess(true);
			j.setObj(attMonitorLog);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

