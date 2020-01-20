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
import com.mtf.framework.model.impl.OrderCategoryServiceRecordImpl;
import com.mtf.framework.service.OrderCategoryServiceRecordService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 报销审批记录
 * 作者:    Auto
 * 日期:    2017/10/18
**********************************************
*/
@Controller("orderCategoryServiceRecordController")
@RequestMapping("/order/orderCategoryServiceRecord")
public class OrderCategoryServiceRecordController extends BaseController{

	@Autowired
	private OrderCategoryServiceRecordService orderCategoryServiceRecordService;

	@Autowired
	public OrderCategoryServiceRecordService getOrderCategoryServiceRecordService() {
		return orderCategoryServiceRecordService;
	}

	@Autowired
	public void setOrderCategoryServiceRecordService(OrderCategoryServiceRecordService orderCategoryServiceRecordService) {
		this.orderCategoryServiceRecordService = orderCategoryServiceRecordService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/order/orderCategoryServiceRecord/searchOrderCategoryServiceRecord");
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
	public DataGrid<OrderCategoryServiceRecordImpl> doSearch(OrderCategoryServiceRecordImpl orderCategoryServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderCategoryServiceRecordImpl> list = new DataGrid<OrderCategoryServiceRecordImpl>();
		list = this.orderCategoryServiceRecordService.search(orderCategoryServiceRecord);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderCategoryServiceRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderCategoryServiceRecordImpl orderCategoryServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderCategoryServiceRecord/editOrderCategoryServiceRecord");
		String editState = orderCategoryServiceRecord.getEditState();
		if ("u".equals(editState)) {
		orderCategoryServiceRecord = orderCategoryServiceRecordService.get(orderCategoryServiceRecord);
		}
		orderCategoryServiceRecord.setEditState(editState);
		mv.addObject("orderCategoryServiceRecord", orderCategoryServiceRecord);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderCategoryServiceRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderCategoryServiceRecordImpl orderCategoryServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderCategoryServiceRecord.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryServiceRecord, session);
				orderCategoryServiceRecordService.insert(orderCategoryServiceRecord);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryServiceRecord, session);
				orderCategoryServiceRecordService.update(orderCategoryServiceRecord);
			} else if ("d".equals(editState)) {
				orderCategoryServiceRecordService.delete(orderCategoryServiceRecord);
			}
			j.setSuccess(true);
			j.setObj(orderCategoryServiceRecord);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

