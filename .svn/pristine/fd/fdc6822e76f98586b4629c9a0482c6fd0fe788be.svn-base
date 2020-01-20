package com.mtf.framework.controller.maintenance;

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
import com.mtf.framework.model.impl.SysLogImpl;
import com.mtf.framework.service.SysLogService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 系统日志
 * 作者:    Auto
 * 日期:    2017/4/20
**********************************************
*/
@Controller("sysLogController")
@RequestMapping("/maintenance/sysLog")
public class SysLogController extends BaseController{

	@Autowired
	private SysLogService sysLogService;

	@Autowired
	public SysLogService getSysLogService() {
		return sysLogService;
	}

	@Autowired
	public void setSysLogService(SysLogService sysLogService) {
		this.sysLogService = sysLogService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/sysLog/searchSysLog");
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
	public DataGrid<SysLogImpl> doSearch(SysLogImpl sysLog, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<SysLogImpl> list = new DataGrid<SysLogImpl>();
		list = this.sysLogService.search(sysLog);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param sysLog
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(SysLogImpl sysLog, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/sysLog/editSysLog");
		String editState = sysLog.getEditState();
		if ("u".equals(editState)) {
		sysLog = sysLogService.get(sysLog);
		}
		sysLog.setEditState(editState);
		mv.addObject("sysLog", sysLog);
		return mv;
	}

	/**
	 * 编辑
	 * @param sysLog
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(SysLogImpl sysLog, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = sysLog.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(sysLog, session);
				sysLogService.insert(sysLog);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(sysLog, session);
				sysLogService.update(sysLog);
			} else if ("d".equals(editState)) {
				sysLogService.delete(sysLog);
			}
			j.setSuccess(true);
			j.setObj(sysLog);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

