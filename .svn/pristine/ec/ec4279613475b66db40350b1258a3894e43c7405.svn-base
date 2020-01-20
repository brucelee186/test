package com.mtf.framework.controller.maintenance;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.dao.SysTempConditionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.model.impl.SysTempImpl;
import com.mtf.framework.service.SysTempService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 系统缓存
 * 作者:    Auto
 * 日期:    2017/9/18
**********************************************
*/
@Controller("sysTempController")
@RequestMapping("/maintenance/sysTemp")
public class SysTempController extends BaseController{

	@Autowired
	private SysTempService sysTempService;
	
	@Autowired
	private SysTempConditionMapper sysTempConditionMapper;

	@Autowired
	public SysTempConditionMapper getSysTempConditionMapper() {
		return sysTempConditionMapper;
	}

	@Autowired
	public void setSysTempConditionMapper(
			SysTempConditionMapper sysTempConditionMapper) {
		this.sysTempConditionMapper = sysTempConditionMapper;
	}

	@Autowired
	public SysTempService getSysTempService() {
		return sysTempService;
	}

	@Autowired
	public void setSysTempService(SysTempService sysTempService) {
		this.sysTempService = sysTempService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/sysTemp/searchSysTemp");
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
	public DataGrid<SysTempImpl> doSearch(SysTempImpl sysTemp, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<SysTempImpl> list = new DataGrid<SysTempImpl>();
		String type = sysTemp.getType();
		if ("ocsrp".equals(type)) {
			sysTemp.setSort("a.text6 asc, a.modifiedDate");
			sysTemp.setOrder("desc");
		}
		sysTemp.setUserId(getUserId());
		
		list = this.sysTempService.search(sysTemp);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param sysTemp
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(SysTempImpl sysTemp, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/sysTemp/editSysTemp");
		String editState = sysTemp.getEditState();
		if ("u".equals(editState)) {
		sysTemp = sysTempService.get(sysTemp);
		}
		sysTemp.setEditState(editState);
		mv.addObject("sysTemp", sysTemp);
		return mv;
	}

	/**
	 * 编辑
	 * @param sysTemp
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(SysTempImpl sysTemp, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		boolean res = true;
		String editState = sysTemp.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(sysTemp, session);
				sysTempService.insert(sysTemp);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(sysTemp, session);
				sysTempService.update(sysTemp);
			} else if ("d".equals(editState)) {
				sysTempService.delete(sysTemp);
			}
			
		} catch (Exception e) {
			res = false;
		}
		j.setObj(sysTemp);
		j.setSuccess(res);
		return j;
	}

	public SysTempImpl getLastContent() {
		SysTempImpl sysTemp = new SysTempImpl();
		sysTemp.setUserId(getUserId()); 	
		sysTemp.setType("ocsrp");
		sysTemp.setSort("modifiedDate");
		sysTemp.setOrder("DESC");
		SysTempImpl sysTemp2 = (SysTempImpl) sysTempConditionMapper.getLastContent(sysTemp);
		return sysTemp2;
	}
}

