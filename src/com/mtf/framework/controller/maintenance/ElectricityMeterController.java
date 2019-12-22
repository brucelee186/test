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
import com.mtf.framework.model.impl.ElectricityMeterImpl;
import com.mtf.framework.service.ElectricityMeterService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 电表
 * 作者:    Auto
 * 日期:    2018/5/17
**********************************************
*/
@Controller("electricityMeterController")
@RequestMapping("/maintenance/electricityMeter")
public class ElectricityMeterController extends BaseController{

	@Autowired
	private ElectricityMeterService electricityMeterService;

	@Autowired
	public ElectricityMeterService getElectricityMeterService() {
		return electricityMeterService;
	}

	@Autowired
	public void setElectricityMeterService(ElectricityMeterService electricityMeterService) {
		this.electricityMeterService = electricityMeterService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/electricityMeter/searchElectricityMeter");
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
	public DataGrid<ElectricityMeterImpl> doSearch(ElectricityMeterImpl electricityMeter, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<ElectricityMeterImpl> list = new DataGrid<ElectricityMeterImpl>();
		list = this.electricityMeterService.search(electricityMeter);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param electricityMeter
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(ElectricityMeterImpl electricityMeter, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/electricityMeter/editElectricityMeter");
		String editState = electricityMeter.getEditState();
		if ("u".equals(editState)) {
		electricityMeter = electricityMeterService.get(electricityMeter);
		}
		electricityMeter.setEditState(editState);
		mv.addObject("electricityMeter", electricityMeter);
		return mv;
	}

	/**
	 * 编辑
	 * @param electricityMeter
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(ElectricityMeterImpl electricityMeter, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = electricityMeter.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(electricityMeter, session);
				electricityMeterService.insert(electricityMeter);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(electricityMeter, session);
				electricityMeterService.update(electricityMeter);
			} else if ("d".equals(editState)) {
				electricityMeterService.delete(electricityMeter);
			}
			j.setSuccess(true);
			j.setObj(electricityMeter);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

