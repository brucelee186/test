package com.mtf.framework.controller.order;

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
import com.mtf.framework.model.impl.OrderCategoryRuleImpl;
import com.mtf.framework.service.OrderCategoryRuleService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 授权规则表 
 * 作者:    Auto
 * 日期:    2016/6/27
**********************************************
*/
@Controller("orderCategoryRuleController")
@RequestMapping("/order/orderCategoryRule")
public class OrderCategoryRuleController extends BaseController{

	@Autowired
	private OrderCategoryRuleService orderCategoryRuleService;

	@Autowired
	public OrderCategoryRuleService getOrderCategoryRuleService() {
		return orderCategoryRuleService;
	}

	@Autowired
	public void setOrderCategoryRuleService(OrderCategoryRuleService orderCategoryRuleService) {
		this.orderCategoryRuleService = orderCategoryRuleService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/order/orderCategoryRule/searchOrderCategoryRule");
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
	public DataGrid<OrderCategoryRuleImpl> doSearch(OrderCategoryRuleImpl orderCategoryRule, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderCategoryRuleImpl> list = new DataGrid<OrderCategoryRuleImpl>();
		list = this.orderCategoryRuleService.search(orderCategoryRule);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderCategoryRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderCategoryRuleImpl orderCategoryRule, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderCategoryRule/editOrderCategoryRule");
		String editState = orderCategoryRule.getEditState();
		if ("u".equals(editState)) {
		orderCategoryRule = orderCategoryRuleService.get(orderCategoryRule);
		}
		orderCategoryRule.setEditState(editState);
		mv.addObject("orderCategoryRule", orderCategoryRule);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderCategoryRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderCategoryRuleImpl orderCategoryRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderCategoryRule.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryRule, session);
				orderCategoryRuleService.insert(orderCategoryRule);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryRule, session);
				orderCategoryRuleService.update(orderCategoryRule);
			} else if ("d".equals(editState)) {
				orderCategoryRuleService.delete(orderCategoryRule);
			}
			j.setSuccess(true);
			j.setObj(orderCategoryRule);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

