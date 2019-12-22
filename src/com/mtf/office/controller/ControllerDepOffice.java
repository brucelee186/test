package com.mtf.office.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DepofficeImpl;
import com.mtf.framework.service.DepofficeService;


@Controller("controllerDepOffice")
@RequestMapping("/office/depOffice")
public class ControllerDepOffice {
	
	@Autowired
	private DepofficeService  depOfficeService;

	@Autowired
	public DepofficeService getDepOfficeService() {
		return depOfficeService;
	}

	@Autowired
	public void setDepOfficeService(DepofficeService depOfficeService) {
		this.depOfficeService = depOfficeService;
	}

	/**
	 * 页面跳转
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(DepofficeImpl depOffice,HttpSession session){
	ModelAndView mv=new ModelAndView("office/searchItem");
	mv.addObject("depoffice",depOffice);
	return mv;
	}
	
	/**
	 * 查询数据
	 */
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<DepofficeImpl> doSearch(DepofficeImpl depOfficeImpl,HttpSession session) throws Exception{
		DataGrid<DepofficeImpl> list = new DataGrid<DepofficeImpl>();
		list = depOfficeService.select(depOfficeImpl);
		return list;
	}

	
	

}
