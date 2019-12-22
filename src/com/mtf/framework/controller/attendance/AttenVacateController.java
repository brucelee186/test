package com.mtf.framework.controller.attendance;

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
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.model.impl.AttenVacateImpl;
import com.mtf.framework.service.AttenVacateService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/5/5
**********************************************
*/
@Controller("attenVacateController")
@RequestMapping("/attendance/attenVacate")
public class AttenVacateController extends BaseController{

	@Autowired
	private AttenVacateService attenVacateService;

	@Autowired
	public AttenVacateService getAttenVacateService() {
		return attenVacateService;
	}

	@Autowired
	public void setAttenVacateService(AttenVacateService attenVacateService) {
		this.attenVacateService = attenVacateService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/attendance/attenVacate/searchAttenVacate");
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
	public DataGrid<AttenVacateImpl> doSearch(AttenVacateImpl attenVacate, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttenVacateImpl> list = new DataGrid<AttenVacateImpl>();
		list = this.attenVacateService.search(attenVacate);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenVacate
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenVacateImpl attenVacate, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenVacate/editAttenVacate");
		String editState = attenVacate.getEditState();
		if ("u".equals(editState)) {
		attenVacate = attenVacateService.get(attenVacate);
		}
		attenVacate.setEditState(editState);
		mv.addObject("attenVacate", attenVacate);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenVacate
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenVacateImpl attenVacate, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenVacate.getEditState();
		try {
			if ("i".equals(editState)) {
				// d:delete,n:normal
				attenVacate.setTag("n");
				CommonUtil.setCommonField(attenVacate, session);
				attenVacateService.insert(attenVacate);
			} else if ("u".equals(editState)) {
				// d:delete,n:normal
				CommonUtil.setCommonField(attenVacate, session);
				attenVacateService.update(attenVacate);
			} else if ("d".equals(editState)) {
				// d:delete,n:normal
				//attenVacate.setTag("d");
				//attenVacateService.update(attenVacate);
				attenVacateService.delete(attenVacate);
			}
			j.setSuccess(true);
			j.setObj(attenVacate);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	/**
	 * 编辑
	 * @param attenVacate
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getAttenVacate", method = RequestMethod.POST)
	@ResponseBody
	public Json getAttenVacate(AttenVacateImpl attenVacate, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		try {
			attenVacate.setUserId(getUserId());
			attenVacate = attenVacateService.get(attenVacate);
			j.setSuccess(true);
			j.setObj(attenVacate);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

