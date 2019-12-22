package com.mtf.framework.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.OrderCategoryImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.service.OrderCategoryService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 分类科目表
 * 作者:    Auto
 * 日期:    2016/5/23
**********************************************
*/
@Controller("orderCategoryController")
@RequestMapping("/order/orderCategory")
public class OrderCategoryController extends BaseController{

	@Autowired
	private OrderCategoryService orderCategoryService;

	@Autowired
	public OrderCategoryService getOrderCategoryService() {
		return orderCategoryService;
	}

	@Autowired
	public void setOrderCategoryService(OrderCategoryService orderCategoryService) {
		this.orderCategoryService = orderCategoryService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(OrderCategoryImpl orderCategory) {
		ModelAndView mv = new ModelAndView("/order/orderCategory/searchOrderCategory"); 
		mv.addObject("orderCategory", orderCategory);
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
	public DataGrid<OrderCategoryImpl> doSearch(OrderCategoryImpl orderCategory, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderCategoryImpl> list = new DataGrid<OrderCategoryImpl>();
		list = this.orderCategoryService.search(orderCategory);
		return list;
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearchList", method=RequestMethod.POST)
	@ResponseBody
	public List<OrderCategoryImpl> doSearchList(OrderCategoryImpl orderCategory, HttpSession session) throws Exception {
		new PmException(session);
		List<OrderCategoryImpl> list = new ArrayList<>();
		list = this.orderCategoryService.select(orderCategory);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderCategory
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderCategoryImpl orderCategory, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderCategory/editOrderCategory");
		String editState = orderCategory.getEditState();
		if ("u".equals(editState)) {
		orderCategory = orderCategoryService.get(orderCategory);
		}
		orderCategory.setEditState(editState);
		mv.addObject("orderCategory", orderCategory);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderCategory
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderCategoryImpl orderCategory, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderCategory.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderCategory, session);
				orderCategoryService.insert(orderCategory);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderCategory, session);
				orderCategoryService.update(orderCategory);
			} else if ("d".equals(editState)) {
				orderCategoryService.delete(orderCategory);
			}
			j.setSuccess(true);
			j.setObj(orderCategory);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

