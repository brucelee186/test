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
import com.mtf.framework.model.impl.SysHistoryImpl;
import com.mtf.framework.service.SysHistoryService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 系统历史表
 * 作者:    Auto
 * 日期:    2016/5/26
**********************************************
*/
@Controller("sysHistoryController")
@RequestMapping("/maintenance/sysHistory")
public class SysHistoryController extends BaseController{

	@Autowired
	private SysHistoryService sysHistoryService;

	@Autowired
	public SysHistoryService getSysHistoryService() {
		return sysHistoryService;
	}

	@Autowired
	public void setSysHistoryService(SysHistoryService sysHistoryService) {
		this.sysHistoryService = sysHistoryService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/sysHistory/searchSysHistory");
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
	public DataGrid<SysHistoryImpl> doSearch(SysHistoryImpl sysHistory, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<SysHistoryImpl> list = new DataGrid<SysHistoryImpl>();
		list = this.sysHistoryService.search(sysHistory);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param sysHistory
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(SysHistoryImpl sysHistory, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/sysHistory/editSysHistory");
		String editState = sysHistory.getEditState();
		if ("u".equals(editState)) {
		sysHistory = sysHistoryService.get(sysHistory);
		}
		sysHistory.setEditState(editState);
		mv.addObject("sysHistory", sysHistory);
		return mv;
	}

	/**
	 * 编辑
	 * @param sysHistory
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(SysHistoryImpl sysHistory, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = sysHistory.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(sysHistory, session);
				sysHistoryService.insert(sysHistory);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(sysHistory, session);
				sysHistoryService.update(sysHistory);
			} else if ("d".equals(editState)) {
				sysHistoryService.delete(sysHistory);
			}
			j.setSuccess(true);
			j.setObj(sysHistory);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

