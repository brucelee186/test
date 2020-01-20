package com.mtf.framework.controller.order;

import java.util.List;

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
import com.mtf.framework.model.impl.OrderServiceDetailImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.service.OrderServiceDetailService;
import com.mtf.framework.service.OrderServiceService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/10/26
**********************************************
*/
@Controller("orderServiceDetailController")
@RequestMapping("/order/orderServiceDetail")
public class OrderServiceDetailController extends BaseController{

	@Autowired
	private OrderServiceDetailService orderServiceDetailService;
	
	@Autowired
	private OrderServiceService orderServiceService;

	@Autowired
	public OrderServiceService getOrderServiceService() {
		return orderServiceService;
	}

	@Autowired
	public void setOrderServiceService(OrderServiceService orderServiceService) {
		this.orderServiceService = orderServiceService;
	}

	@Autowired
	public OrderServiceDetailService getOrderServiceDetailService() {
		return orderServiceDetailService;
	}

	@Autowired
	public void setOrderServiceDetailService(OrderServiceDetailService orderServiceDetailService) {
		this.orderServiceDetailService = orderServiceDetailService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/order/orderServiceDetail/searchOrderServiceDetail");
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
	public DataGrid<OrderServiceDetailImpl> doSearch(OrderServiceDetailImpl orderServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderServiceDetailImpl> list = new DataGrid<OrderServiceDetailImpl>();
		Long idOrderService = orderServiceDetail.getIdOrderService();
		if (null != idOrderService && !"".equals(idOrderService)) {
			list = this.orderServiceDetailService.search(orderServiceDetail);
		}
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderServiceDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderServiceDetailImpl orderServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderServiceDetail/editOrderServiceDetail");
		String editState = orderServiceDetail.getEditState();
		if ("u".equals(editState)) {
		orderServiceDetail = orderServiceDetailService.get(orderServiceDetail);
		}
		orderServiceDetail.setEditState(editState);
		mv.addObject("orderServiceDetail", orderServiceDetail);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderServiceDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderServiceDetailImpl orderServiceDetail, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderServiceDetail.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderServiceDetail, session);
				orderServiceDetailService.update(orderServiceDetail);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderServiceDetail, session);
				orderServiceDetailService.update(orderServiceDetail);
			} else if ("d".equals(editState)) {
				orderServiceDetailService.update(orderServiceDetail);
			}
			j.setSuccess(true);
			j.setObj(orderServiceDetail);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	private void updateOrderService(OrderServiceDetailImpl orderServiceDetail) throws PmException{
		Long idOrderService = orderServiceDetail.getIdOrderService();
		// 取得所有公里数计算费用
		orderServiceDetail = new OrderServiceDetailImpl();
		orderServiceDetail.setIdOrderService(idOrderService);
		// 公里表数
		Double mileageTotal = 0.00;
		List<OrderServiceDetailImpl> listOrderServiceDetail = (List<OrderServiceDetailImpl>) orderServiceDetailService.select(orderServiceDetail);
		if (null != listOrderServiceDetail && listOrderServiceDetail.size() > 0) {
			for (int i = 0; i < listOrderServiceDetail.size(); i++) {
				Double mileage = listOrderServiceDetail.get(i).getMileage();
				if (null != mileage && "".equals(mileage)) {
					mileageTotal += mileage;
				}
			}
			OrderServiceImpl orderService = new OrderServiceImpl();
			orderService.setId(idOrderService);
			orderService = orderServiceService.get(orderService);
			orderService.setMileage(mileageTotal);
			
		}
	}
}

