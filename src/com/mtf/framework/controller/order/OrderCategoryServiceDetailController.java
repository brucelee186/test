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
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.service.OrderCategoryServiceDetailService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 科目申请服务
 * 作者:    Auto
 * 日期:    2016/6/22
**********************************************
*/
@Controller("orderCategoryServiceDetailController")
@RequestMapping("/order/orderCategoryServiceDetail")
public class OrderCategoryServiceDetailController extends BaseController{

	@Autowired
	private OrderCategoryServiceDetailService orderCategoryServiceDetailService;

	@Autowired
	public OrderCategoryServiceDetailService getOrderCategoryServiceDetailService() {
		return orderCategoryServiceDetailService;
	}

	@Autowired
	public void setOrderCategoryServiceDetailService(OrderCategoryServiceDetailService orderCategoryServiceDetailService) {
		this.orderCategoryServiceDetailService = orderCategoryServiceDetailService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/order/orderCategoryServiceDetail/searchOrderCategoryServiceDetail");
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
	public DataGrid<OrderCategoryServiceDetailImpl> doSearch(OrderCategoryServiceDetailImpl orderCategoryServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderCategoryServiceDetailImpl> list = new DataGrid<OrderCategoryServiceDetailImpl>();
		list = this.orderCategoryServiceDetailService.search(orderCategoryServiceDetail);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderCategoryServiceDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderCategoryServiceDetailImpl orderCategoryServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderCategoryServiceDetail/editOrderCategoryServiceDetail");
		String editState = orderCategoryServiceDetail.getEditState();
		if ("u".equals(editState)) {
		orderCategoryServiceDetail = orderCategoryServiceDetailService.get(orderCategoryServiceDetail);
		}
		orderCategoryServiceDetail.setEditState(editState);
		mv.addObject("orderCategoryServiceDetail", orderCategoryServiceDetail);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderCategoryServiceDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderCategoryServiceDetailImpl orderCategoryServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderCategoryServiceDetail.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryServiceDetail, session);
				orderCategoryServiceDetailService.insert(orderCategoryServiceDetail);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryServiceDetail, session);
				orderCategoryServiceDetailService.update(orderCategoryServiceDetail);
			} else if ("d".equals(editState)) {
				orderCategoryServiceDetailService.delete(orderCategoryServiceDetail);
			}
			j.setSuccess(true);
			j.setObj(orderCategoryServiceDetail);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

