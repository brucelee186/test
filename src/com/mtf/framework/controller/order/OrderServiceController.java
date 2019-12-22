package com.mtf.framework.controller.order;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fr.report.core.A.e;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.CustomerImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.OrderServicePathImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.CustomerService;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.OrderServicePathService;
import com.mtf.framework.service.OrderServiceService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤配置
 * 作者:    Auto
 * 日期:    2015/10/21
**********************************************
*/
@Controller("orderServiceController")
@RequestMapping("/order/orderService")
public class OrderServiceController extends BaseController{

	@Autowired
	private OrderServiceService orderServiceService;
	
	@Autowired
	private IDivisionService divisionService; 
	
	@Autowired
	private UserDetailService userDetailService; 
	
	@Autowired
	private UserInforService userInforService; 
	
	@Autowired
	private PermissionService permissionService; 
	
	@Autowired
	private OrderServicePathService orderServicePathService; 
	
	@Autowired
	private CustomerService customerService; 

	@Autowired
	public CustomerService getCustomerService() {
		return customerService;
	}

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	@Autowired
	public OrderServicePathService getOrderServicePathService() {
		return orderServicePathService;
	}

	@Autowired
	public void setOrderServicePathService(
			OrderServicePathService orderServicePathService) {
		this.orderServicePathService = orderServicePathService;
	}

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Autowired
	public PermissionService getPermissionService() {
		return permissionService;
	}

	@Autowired
	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public IDivisionService getDivisionService() {
		return divisionService;
	}

	@Autowired
	public UserDetailService getUserDetailService() {
		return userDetailService;
	}

	@Autowired
	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	@Autowired
	public void setDivisionService(IDivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public OrderServiceService getOrderServiceService() {
		return orderServiceService;
	}

	@Autowired
	public void setOrderServiceService(OrderServiceService orderServiceService) {
		this.orderServiceService = orderServiceService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(HttpSession session, OrderServiceImpl orderService) throws Exception {
		new PmException(session);
		// 取得下拉列表数据
		ModelAndView mv = new ModelAndView("/order/orderService/searchOrderService");
		// 取得客户列表
		/*Division division = new Division();
		division.setTag("c");
		division.setStatus(0);
		List<Division> listDivisions = divisionService.select(division);
		JSONArray jsonArrayDivision = new JSONArray();
		jsonArrayDivision.add(listDivisions);
		mv.addObject("jsonArrayDivision", jsonArrayDivision);*/
		
		// 取得部门列表
		Division customer = new Division();
		customer = new Division();
		customer.setTag("c");
		customer.setStatus(0);
		customer.setLevel(1);
		List<Division> listCustomer = divisionService.select(customer);
		
		/*CustomerImpl customer = new CustomerImpl();
		customer.setStatus(0);
		customer.setType(0);
		List<CustomerImpl> listCustomer = customerService.search(customer);
		customer = new CustomerImpl();
		customer.setId("0");
		customer.setName("- -");
		listCustomer.add(0, customer);*/
		JSONArray jsonArrayDivision = new JSONArray();
		jsonArrayDivision.addAll(listCustomer);
		mv.addObject("jsonArrayDivision", jsonArrayDivision);
		
		// 取得部门列表
		Division division = new Division();
		division = new Division();
		division.setTag("d");
		division.setStatus(0);
		List<Division> listDivisions = divisionService.select(division);
		JSONArray jsonArrayDivisionDep = new JSONArray();
		jsonArrayDivisionDep.add(listDivisions);
		mv.addObject("jsonArrayDivisionDep", jsonArrayDivisionDep);
		// 司机权限值	1701003
		UserDetailImpl user = new UserDetailImpl();
		user.setCode("1701003");
		List<UserDetailImpl> listUserDetail = (List<UserDetailImpl>) userDetailService.selectUserByPermissionCode(user);
		JSONArray jsonArrayUser = new JSONArray();
		jsonArrayUser.add(listUserDetail);
		mv.addObject("jsonArrayDriver", jsonArrayUser);
		// 取得用车类别
		UserInforImpl userInfor = new UserInforImpl();
		userInfor.setType("yclx");
		// 明细
		userInfor.setFlag("i");
		List<UserInforImpl> listUserInfor = userInforService.search(userInfor);
		JSONArray jsonArrayUserInfor = new JSONArray();
		jsonArrayUserInfor.add(listUserInfor);
		mv.addObject("jsonArrayUserInfor", jsonArrayUserInfor);
		// 取得计费类别
		userInfor = new UserInforImpl();
		userInfor.setType("jflb");
		// 明细
		userInfor.setFlag("i");
		listUserInfor = userInforService.search(userInfor);
		jsonArrayUserInfor = new JSONArray();
		jsonArrayUserInfor.add(listUserInfor);
		mv.addObject("jsonArrayTypeExpense", jsonArrayUserInfor);
		// 模块信息
		mv.addObject("orderService", orderService);
		String userNameString = getUserName();
		mv.addObject("userNameString", userNameString);
		// 取得路线列表
		OrderServicePathImpl orderServicePath = new OrderServicePathImpl();
		// 记录标识(n:nromal, d:delete)
		orderServicePath.setTag("n");
		List<OrderServicePathImpl> listOrderServicePath = orderServicePathService.select(orderServicePath);
		OrderServicePathImpl orderServiceTemp = new OrderServicePathImpl();
		orderServiceTemp.setId(null);
		orderServiceTemp.setName("- -");
		listOrderServicePath.add(0, orderServiceTemp);
		JSONArray jsonArrayOrderServicePath = new JSONArray();
		jsonArrayOrderServicePath.add(listOrderServicePath);
		mv.addObject("jsonArrayOrderServicePath", jsonArrayOrderServicePath);
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
	public DataGrid<OrderServiceImpl> doSearch(OrderServiceImpl orderService, HttpSession session) throws Exception {
		new PmException(session);
		// 模块(订车 o:order, 派车 a:allocation)
		String tagModule = orderService.getTagModule();
		if (null == tagModule) {
			return null;
		}
		DataGrid<OrderServiceImpl> list = new DataGrid<OrderServiceImpl>();
		// 部门审批	1804002
		boolean approveDep = CommonUtil.checkCode("1804002");
		// 行政审批	1804003
		boolean approveAdmin = CommonUtil.checkCode("1804003");
		// 如果部门审批状态
		// 模块(订车 o:order, 派车 a:allocation, 审批 ap:approve)
		if ("ap".equals(tagModule) && approveDep && !approveAdmin) {
			// 取得用户部门审批权限
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(getUserId());
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			orderService.setListDivision(listDivision);
		} 
		/*if ("ap".equals(tagModule) && !approveDep && !approveAdmin) {
			orderService.setDriverId(getDivisionId());
		}*/
		// 如果是派车模块,取得除去状态之后数据(草稿;d,s:提交,re1)
		if ("a".equals(tagModule)) {
			List<String> listStatusOrder = new ArrayList<>();
			listStatusOrder.add("d");
			//listStatusOrder.add("s");
			listStatusOrder.add("re1");
			orderService.setListStatusOrder(listStatusOrder);
		}
		// 如果是个人状态
		if ("o".equals(tagModule)) {
			orderService.setUserId(getUserId());
		}
		list = this.orderServiceService.search(orderService);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderService
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderServiceImpl orderService, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderService/editOrderService");
		String editState = orderService.getEditState();
		if ("u".equals(editState)) {
		orderService = orderServiceService.get(orderService);
		}
		orderService.setEditState(editState);
		mv.addObject("orderService", orderService);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderService
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderServiceImpl orderService, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderService.getEditState();
		// 模块(订车 o:order, 派车 a:allocation)
		String tagModule = orderService.getTagModule();
		if ("o".equals(tagModule)) {
			orderService.setUserId(getUserId());
			orderService.setUserName(getUserName());
			orderService.setDivisionId(getDivisionId());
			orderService.setDivisionName(getDivisionName());
		} else if ("a".equals(tagModule) && !"a".equals(editState)) {
			this.orderServiceService.calcuteOrderService(orderService);
		}
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderService, session);
				orderServiceService.insert(orderService);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderService, session);
				orderServiceService.update(orderService);
			} else if ("d".equals(editState)) {
				orderServiceService.delete(orderService);
			} else if ("a".equals(editState)) {
				orderService.setStatusOrder(orderService.getApproveStatus());
				orderServiceService.update(orderService);
			}
			j.setSuccess(true);
			j.setObj(orderService);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}


}

