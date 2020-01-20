package com.mtf.office.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mtf.framework.model.impl.DepofficeImpl;

@Controller("controllerReport")
@RequestMapping("/report")
public class ControllerReport {
	
	/**
	 * 页面跳转
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(DepofficeImpl depOffice,HttpSession session){
	ModelAndView mv=new ModelAndView("office/report");
	return mv;
	}
	
	/**
	 * 页面跳转部门员工查询
	 */
	@RequestMapping("/toSearchDep")
	public ModelAndView toSearchDep(DepofficeImpl depOffice,HttpSession session){
	ModelAndView mv=new ModelAndView("office/reportDep");
	return mv;
	}
	
	/**
	 * 页面跳转员工查询
	 */
	@RequestMapping("/toSearchEmp")
	public ModelAndView toSearchEmp(DepofficeImpl depOffice,HttpSession session){
	ModelAndView mv=new ModelAndView("office/reportEmp");
	return mv;
	}
	
	/**
	 * 页面跳转购买查询
	 */
	@RequestMapping("/toPurchase")
	public ModelAndView toPurchase(DepofficeImpl depOffice,HttpSession session){
	ModelAndView mv=new ModelAndView("office/reportToPurchase");
	return mv;
	}
}
