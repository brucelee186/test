package com.mtf.office.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Information;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.ItemImpl;
import com.mtf.framework.model.impl.ItemruleImpl;
import com.mtf.framework.service.InformationService;
import com.mtf.framework.util.TextUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：控制层 -> 币种
 * 作者:     Auto
 * 日期:     2013/7/24
**********************************************
*/
@Controller("controllerInformation")
@RequestMapping("/information")
public class ControllerInformation {

	@Autowired
	private InformationService informationService;
	
	@Autowired
	public void setInformationService(InformationService informationService) {
		this.informationService = informationService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("office/searchInformation");
	}

	/**
	 * 编辑
	 * @param information
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doAdd", method = RequestMethod.POST)
	@ResponseBody
	public Json doAdd(Information information, HttpSession session) throws Exception {
		new PmException(session);
		//insert
		Json j = new Json();
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
			//if
			information.setAddDate(dateStr);
			informationService.insert(information);
			j.setSuccess(true);
			j.setObj(information);
		return j;
	}
	
	@RequestMapping(value = "/doUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Json doUpdate(Information information, HttpSession session) throws Exception {
		new PmException(session);
		//update
		Json j = new Json();
		Information info =new Information();
		info = informationService.get(information);
		if(0 == info.getStatus()){
			info.setStatus(1);
		}else if(1 == info.getStatus()){
			info.setStatus(0);
		}
		
		informationService.update(info);
		j.setSuccess(true);
		j.setObj(information);
		return j;
	}
	
	/**
	 * 查询
	 * @param information
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doGetInfo", method = RequestMethod.POST)
	@ResponseBody
	public Json doGetInfo(Information information, HttpSession session) throws Exception {
		Json j = new Json();
		information.setStatus(0);
		Information info =new Information();
		DataGrid<Information> gi= informationService.select(information);
		//info=informationService.get(information);
		j.setSuccess(true);
		j.setObj(gi);
		return j;
	}

	/**
	 * 查询列表
	 */
	@RequestMapping("/doSearch")
	@ResponseBody
	public DataGrid<Information> doSearch(Information information,HttpSession session)throws Exception{
		DataGrid<Information> list=informationService.select(information);
		return list;
				
	}
	
	/**
	 * 跳转到编辑页面
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(Information information,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("office/editInformation");
		//mv.addObject("information",information);
		Long iid =information.getId();
		if(null != iid ){
			Information info = new Information();
			info = informationService.get(information);
			
			mv.addObject("information", info);
		}
		return mv;
	}
	
	/**
	 * 付款管理表编辑
	 * @param contract
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit (Information information, HttpSession session) throws Exception {
		Json j = new Json();

		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		try {
			Long iid =information.getId();
			if(null == iid ){
				information.setAddDate(dateStr);
				informationService.insert(information);
			}else{
				information.setModifiedDate(dateStr);
				informationService.update(information);
			}
			j.setSuccess(true);
			j.setObj(information);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	@RequestMapping(value = "/doDelete", method = RequestMethod.POST)
	@ResponseBody
	public Json doDelete(Information information, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		informationService.delete(information);
		j.setSuccess(true);
		j.setObj(information);
		return j;
	}
	

}

