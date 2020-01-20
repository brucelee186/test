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
import com.mtf.framework.model.impl.AttenVacateTypeImpl;
import com.mtf.framework.service.AttenVacateTypeService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/6/17
**********************************************
*/
@Controller("attenVacateTypeController")
@RequestMapping("/attendance/attenVacateType")
public class AttenVacateTypeController {

	@Autowired
	private AttenVacateTypeService attenVacateTypeService;

	@Autowired
	public AttenVacateTypeService getAttenVacateTypeService() {
		return attenVacateTypeService;
	}

	@Autowired
	public void setAttenVacateTypeService(AttenVacateTypeService attenVacateTypeService) {
		this.attenVacateTypeService = attenVacateTypeService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/attendance/attenVacateType/searchAttenVacateType");
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
	public DataGrid<AttenVacateTypeImpl> doSearch(AttenVacateTypeImpl attenVacateType, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttenVacateTypeImpl> list = new DataGrid<AttenVacateTypeImpl>();
		list = this.attenVacateTypeService.search(attenVacateType);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenVacateType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenVacateTypeImpl attenVacateType, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenVacateType/editAttenVacateType");
		String editState = attenVacateType.getEditState();
		if ("u".equals(editState)) {
		attenVacateType = attenVacateTypeService.get(attenVacateType);
		}
		attenVacateType.setEditState(editState);
		mv.addObject("attenVacateType", attenVacateType);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenVacateType
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenVacateTypeImpl attenVacateType, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenVacateType.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenVacateType, session);
				attenVacateTypeService.insert(attenVacateType);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenVacateType, session);
				attenVacateTypeService.update(attenVacateType);
			} else if ("d".equals(editState)) {
				attenVacateTypeService.delete(attenVacateType);
			}
			j.setSuccess(true);
			j.setObj(attenVacateType);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

