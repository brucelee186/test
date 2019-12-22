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
import com.mtf.framework.model.impl.OrderServicePathImpl;
import com.mtf.framework.service.OrderServicePathService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/10/28
**********************************************
*/
@Controller("orderServicePathController")
@RequestMapping("/order/orderServicePath")
public class OrderServicePathController extends BaseController{

	@Autowired
	private OrderServicePathService orderServicePathService;

	@Autowired
	public OrderServicePathService getOrderServicePathService() {
		return orderServicePathService;
	}

	@Autowired
	public void setOrderServicePathService(OrderServicePathService orderServicePathService) {
		this.orderServicePathService = orderServicePathService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/order/orderServicePath/searchOrderServicePath");
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
	public DataGrid<OrderServicePathImpl> doSearch(OrderServicePathImpl orderServicePath, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderServicePathImpl> list = new DataGrid<OrderServicePathImpl>();
		list = this.orderServicePathService.search(orderServicePath);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderServicePath
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderServicePathImpl orderServicePath, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderServicePath/editOrderServicePath");
		String editState = orderServicePath.getEditState();
		if ("u".equals(editState)) {
		orderServicePath = orderServicePathService.get(orderServicePath);
		}
		orderServicePath.setEditState(editState);
		mv.addObject("orderServicePath", orderServicePath);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderServicePath
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderServicePathImpl orderServicePath, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderServicePath.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderServicePath, session);
				orderServicePathService.insert(orderServicePath);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderServicePath, session);
				orderServicePathService.update(orderServicePath);
			} else if ("d".equals(editState)) {
				orderServicePathService.delete(orderServicePath);
			}
			j.setSuccess(true);
			j.setObj(orderServicePath);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

