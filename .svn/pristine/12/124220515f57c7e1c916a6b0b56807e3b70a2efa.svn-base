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
import com.mtf.framework.model.impl.AttenDayImpl;
import com.mtf.framework.service.AttenDayService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤时段
 * 作者:    Auto
 * 日期:    2015/5/6
**********************************************
*/
@Controller("attenDayController")
@RequestMapping("/attendance/attenDay")
public class AttenDayController {

	@Autowired
	private AttenDayService attenDayService;

	@Autowired
	public AttenDayService getAttenDayService() {
		return attenDayService;
	}

	@Autowired
	public void setAttenDayService(AttenDayService attenDayService) {
		this.attenDayService = attenDayService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/attendance/attenDay/searchAttenDay");
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
	public DataGrid<AttenDayImpl> doSearch(AttenDayImpl attenDay, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttenDayImpl> list = new DataGrid<AttenDayImpl>();
		list = this.attenDayService.search(attenDay);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenDay
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenDayImpl attenDay, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenDay/editAttenDay");
		String editState = attenDay.getEditState();
		if ("u".equals(editState)) {
		attenDay = attenDayService.get(attenDay);
		}
		attenDay.setEditState(editState);
		mv.addObject("attenDay", attenDay);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenDay
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenDayImpl attenDay, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenDay.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenDay, session);
				attenDayService.insert(attenDay);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenDay, session);
				attenDayService.update(attenDay);
			} else if ("d".equals(editState)) {
				attenDayService.delete(attenDay);
			}
			j.setSuccess(true);
			j.setObj(attenDay);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

