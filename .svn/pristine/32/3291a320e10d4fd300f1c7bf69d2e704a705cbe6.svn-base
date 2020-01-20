package com.mtf.framework.controller.attendance;

import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.AttenFestivalImpl;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.service.AttenFestivalService;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 节假日管理
 * 作者:    Auto
 * 日期:    2015/4/21
**********************************************
*/
@Controller("attenFestivalController")
@RequestMapping("/attendance/attenFestival")
public class AttenFestivalController {

	@Autowired
	private AttenFestivalService attenFestivalService;
	
	@Autowired
	private IDivisionService divisionService;

	@Autowired
	public IDivisionService getDivisionService() {
		return divisionService;
	}
	
	@Autowired
	public void setDivisionService(IDivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public AttenFestivalService getAttenFestivalService() {
		return attenFestivalService;
	}

	@Autowired
	public void setAttenFestivalService(AttenFestivalService attenFestivalService) {
		this.attenFestivalService = attenFestivalService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/attendance/attenFestival/searchAttenFestival");
		// 加载时间段json
		JSONArray jsonArray = new JSONArray();
		List<DivisionImpl> listDivision = null;
		try {
			listDivision = this.divisionService.listAvailable(null, "d");
		} catch (PmException e) {
			e.printStackTrace();
		}
		jsonArray.add(listDivision);
		mv.addObject("jsonListDivision", jsonArray.toString());
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
	public DataGrid<AttenFestivalImpl> doSearch(AttenFestivalImpl attenFestival, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttenFestivalImpl> list = new DataGrid<AttenFestivalImpl>();
		attenFestival.setTag("m");
		list = this.attenFestivalService.search(attenFestival);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenFestival
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenFestivalImpl attenFestival, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenFestival/editAttenFestival");
		String editState = attenFestival.getEditState();
		if ("u".equals(editState)) {
		attenFestival = attenFestivalService.get(attenFestival);
		}
		attenFestival.setEditState(editState);
		mv.addObject("attenFestival", attenFestival);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenFestival
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenFestivalImpl attenFestival, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenFestival.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenFestival, session);
				attenFestivalService.insert(attenFestival);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenFestival, session);
				attenFestivalService.update(attenFestival);
			} else if ("d".equals(editState)) {
				attenFestivalService.delete(attenFestival);
			}
			j.setSuccess(true);
			j.setObj(attenFestival);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

