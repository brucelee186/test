package com.mtf.framework.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.OrderCategoryMapper;
import com.mtf.framework.dao.OrderCategoryServiceMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.UserDivision;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.OrderServiceRecordImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.ReimbursementImpl;
import com.mtf.framework.model.impl.ReimbursementItemImpl;
import com.mtf.framework.model.impl.RolePermissionImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.DivisionService;
import com.mtf.framework.service.OrderCategoryService;
import com.mtf.framework.service.OrderCategoryServiceDetailService;
import com.mtf.framework.service.OrderCategoryServiceService;
import com.mtf.framework.service.OrderServiceRecordService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.ReimbursementService;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.impl.OrderServiceDetailServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤审批记录
 * 作者:    Auto
 * 日期:    2015/11/30
**********************************************
*/
@Controller("orderServiceRecordController")
@RequestMapping("/order/orderServiceRecord")
public class OrderServiceRecordController extends BaseController{

	@Autowired
	private OrderServiceRecordService orderServiceRecordService;
	
	@Autowired
	private ReimbursementService reimbursementService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private OrderCategoryServiceService orderCategoryServiceService;
	
	@Autowired
	private OrderCategoryServiceDetailService orderCategoryServiceDetailService;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	private OrderCategoryServiceMapper orderCategoryServiceMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDivisionMapper userDivisionMapper;

	@Autowired
	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	@Autowired
	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
	}

	@Autowired
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public OrderCategoryServiceMapper getOrderCategoryServiceMapper() {
		return orderCategoryServiceMapper;
	}

	@Autowired
	public void setOrderCategoryServiceMapper(
			OrderCategoryServiceMapper orderCategoryServiceMapper) {
		this.orderCategoryServiceMapper = orderCategoryServiceMapper;
	}

	@Autowired
	public DivisionService getDivisionService() {
		return divisionService;
	}

	@Autowired
	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	@Autowired
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	@Autowired
	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	@Autowired
	public OrderCategoryServiceService getOrderCategoryServiceService() {
		return orderCategoryServiceService;
	}

	@Autowired
	public void setOrderCategoryServiceService(
			OrderCategoryServiceService orderCategoryServiceService) {
		this.orderCategoryServiceService = orderCategoryServiceService;
	}

	@Autowired
	public OrderCategoryServiceDetailService getOrderCategoryServiceDetailService() {
		return orderCategoryServiceDetailService;
	}

	@Autowired
	public void setOrderCategoryServiceDetailService(
			OrderCategoryServiceDetailService orderCategoryServiceDetailService) {
		this.orderCategoryServiceDetailService = orderCategoryServiceDetailService;
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
	public ReimbursementService getReimbursementService() {
		return reimbursementService;
	}

	@Autowired
	public void setReimbursementService(ReimbursementService reimbursementService) {
		this.reimbursementService = reimbursementService;
	}

	@Autowired
	public OrderServiceRecordService getOrderServiceRecordService() {
		return orderServiceRecordService;
	}

	@Autowired
	public void setOrderServiceRecordService(OrderServiceRecordService orderServiceRecordService) {
		this.orderServiceRecordService = orderServiceRecordService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(OrderServiceRecordImpl orderServiceRecord, HttpSession session) {
		ModelAndView mv = new ModelAndView("/order/orderServiceRecord/searchOrderServiceRecord");
		String tagPageCode = orderServiceRecord.getTagPageCode();
		if (null != tagPageCode) {
			mv.addObject("tagPageCode", tagPageCode);
		}
		// 取得用户部门审批权限
		/*PermissionImpl permission = new PermissionImpl();
		permission.setParentCode("1403000");
		permission.setUserId(getUserId());
		List<PermissionImpl> listDivision;
		try {
			listDivision = permissionService.searchUserDivisionByPermission(permission);
			if (null != listDivision && listDivision.size() > 0) {
				String arrayDivision = "";
				for (int i = 0; i < listDivision.size(); i++) {
					String divisionId = listDivision.get(i).getDivisionId();
					arrayDivision += "'" + divisionId + "'";
					if (i != listDivision.size() - 1) {
						arrayDivision += ",";
					}
				}
				mv.addObject("arrayDivision", arrayDivision);
			}
		} catch (PmException e) {
			e.printStackTrace();
		}*/
		//报销 tagPageCode=1808700
		mv.addObject("codePermission", "1403000");
		mv.addObject("userId", getUserId());
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
	public DataGrid<OrderServiceRecordImpl> doSearch(OrderServiceRecordImpl orderServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<OrderServiceRecordImpl> list = new DataGrid<OrderServiceRecordImpl>();
		String tagPageCode = orderServiceRecord.getTagPageCode();
		// 数据类型(订车:ov order vehicle, 报销:or order reimbursement)
		String typeRecord = "ov";
		// 订车报销:1805000,报销统计: 1808700 
		if ("1808700".equals(tagPageCode)) {
			typeRecord = "or";
			orderServiceRecord.setApproverId(getUserId());
		}
		orderServiceRecord.setTypeRecord(typeRecord);
		list = this.orderServiceRecordService.search(orderServiceRecord);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderServiceRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderServiceRecordImpl orderServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderServiceRecord/editOrderServiceRecord");
		String editState = orderServiceRecord.getEditState();
		if ("u".equals(editState)) {
			orderServiceRecord = orderServiceRecordService.get(orderServiceRecord);
		}
		orderServiceRecord.setEditState(editState);
		mv.addObject("orderServiceRecord", orderServiceRecord);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderServiceRecord
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit")
	@ResponseBody
	public Json doEdit(OrderServiceRecordImpl orderServiceRecord, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderServiceRecord.getEditState();
		j.setSuccess(true);
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderServiceRecord, session);
				orderServiceRecordService.insert(orderServiceRecord);
			} else if ("u".equals(editState) || "a".equals(editState)) {
				CommonUtil.setCommonField(orderServiceRecord, session);
				orderServiceRecordService.update(orderServiceRecord);
			} else if ("d".equals(editState)) {
				orderServiceRecordService.delete(orderServiceRecord);
			}
			// 创建报销单草稿 cr:createReimbursement
			else if ("cr".equals(editState)) {
				// 看报表月总报表编号是否生成过报销单
				Long idOrderServiceRecord = orderServiceRecord.getId();
				OrderCategoryServiceImpl orderCategoryServiceTemp = new OrderCategoryServiceImpl();
				orderCategoryServiceTemp.setIdOrderServiceRecord(idOrderServiceRecord);	
				orderCategoryServiceTemp = orderCategoryServiceService.get(orderCategoryServiceTemp);
//				if (orderCategoryServiceTemp != null) {
//					j.setSuccess(false);
//					j.setMsg("已经生成过报销单,不可重复生成!");
//				}
//				else 
				{
					// 停车过路过桥费 14 父编号 137
					// 公车车费 17 父编号 137
					orderServiceRecord.setIdCategoryLevel2("17");
					orderServiceRecord.setNameCategoryLevel2("公车车费");
					this.inserOrderCategoryService(orderServiceRecord);
					orderServiceRecord.setIdCategoryLevel2("14");
					orderServiceRecord.setNameCategoryLevel2("停车过路过桥费");
					this.inserOrderCategoryService(orderServiceRecord);
					/* 旧报销系统
				List<OrderServiceImpl> listOrderService = orderServiceRecordService.selectOrderServiceRecordForReimburse(orderServiceRecord);
				ReimbursementImpl reimbursement = new ReimbursementImpl();
				reimbursement.setApplicantDivisionId("ab817736-8197-462e-a15b-910ec799efdb");
				reimbursement.setApplicantDivisionName("行政部");
				reimbursement.setApplicantId(getUserId());
				reimbursement.setApplicantName(getUserName());
				// 付款人姓名
				reimbursement.setPayeeName("");
				List<ReimbursementItemImpl> itemList = new ArrayList<>();
				Double totalAmount = 0.00;
				ReimbursementItemImpl reimbursementItem = new ReimbursementItemImpl();
				// 每六条记录为一个报销单
				int stepInsert = 6;
				for (int i = 0; i < listOrderService.size(); i++) {
					OrderServiceImpl orderService = listOrderService.get(i);
					reimbursementItem = new ReimbursementItemImpl();
					reimbursementItem.setAmount(orderService.getSumExpenseTotal());
					reimbursementItem.setCategory1Id("14");
					reimbursementItem.setCategory1Name("车费");
					reimbursementItem.setCategory2Id("16");
					reimbursementItem.setCategory2Name("派车费");
					reimbursementItem.setDescription("订车管理自动生成");
					reimbursementItem.setDivisionId(orderService.getDivisionId());
					reimbursementItem.setDivisionName(orderService.getDivisionName());
					reimbursementItem.setCustomerId(orderService.getCustomer());
					reimbursementItem.setCustomerName(orderService.getCustomerName());
					Double sumExpenseTotal = orderService.getSumExpenseTotal();
					if (null != sumExpenseTotal) {
						totalAmount += orderService.getSumExpenseTotal();
						reimbursementItem.setAmount(sumExpenseTotal);
					} else {
						reimbursementItem.setAmount(0.00);
					}
					reimbursementItem.setIndex(0);
					itemList.add(reimbursementItem);
					// 如果超过六条,插入一条报销草稿记录
					if ((i + 1) % stepInsert == 0 || (i + 1) == listOrderService.size()) {
						reimbursement.setTotalAmount(totalAmount);
						reimbursement.setCurrencyId("1");
						reimbursementService.insert(reimbursement, itemList, session);
						totalAmount = 0.00;
						itemList = new ArrayList<ReimbursementItemImpl>();
					}
				}
				// 生成停车过路费报销单
				itemList = new ArrayList<>();
				for (int i = 0; i < listOrderService.size(); i++) {
					OrderServiceImpl orderService = listOrderService.get(i);
					reimbursementItem = new ReimbursementItemImpl();
					reimbursementItem.setAmount(orderService.getSumExpenseTotal());
					reimbursementItem.setCategory1Id("14");
					reimbursementItem.setCategory1Name("车费");
					reimbursementItem.setCategory2Id("17");
					reimbursementItem.setCategory2Name("停车过路过桥费");
					reimbursementItem.setDescription("订车管理自动生成");
					reimbursementItem.setDivisionId(orderService.getDivisionId());
					reimbursementItem.setDivisionName(orderService.getDivisionName());
					reimbursementItem.setCustomerId(orderService.getCustomer());
					reimbursementItem.setCustomerName(orderService.getCustomerName());
					Double sumExpenseOther = orderService.getSumExpenseOther();
					if (null != sumExpenseOther) {
						totalAmount += orderService.getSumExpenseOther();
						reimbursementItem.setAmount(sumExpenseOther);
					} else {
						reimbursementItem.setAmount(0.00);
					}
					reimbursementItem.setIndex(0);
					itemList.add(reimbursementItem);
					// 如果超过六条,插入一条报销草稿记录
					if ((i + 1) % stepInsert == 0 || (i + 1) == listOrderService.size()) {
						reimbursement.setTotalAmount(totalAmount);
						reimbursement.setCurrencyId("1");
						reimbursementService.insert(reimbursement, itemList, session);
						totalAmount = 0.00;
						itemList = new ArrayList<ReimbursementItemImpl>();
					}
				}
					 */
					
					/*for (int i = 0; i < listOrderService.size(); i++) {
					OrderServiceImpl orderService = listOrderService.get(i);
					orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetail.setAmount(orderService.getSumExpenseTotal());
					orderCategoryServiceDetail.setIdCategoryLeve1("137");
					orderCategoryServiceDetail.setNameCategoryLevel1("车费");
					orderCategoryServiceDetail.setIdCategoryLevel2("153");
					orderCategoryServiceDetail.setNameCategoryLevel2("派车费");
					orderCategoryServiceDetail.setRemark("订车管理自动生成");
					orderCategoryServiceDetail.setDivisionId(orderService.getDivisionId());
					orderCategoryServiceDetail.setDivisionName(orderService.getDivisionName());
					orderCategoryServiceDetail.setCustomerId(orderService.getCustomer());
					orderCategoryServiceDetail.setCustomerName(orderService.getCustomerName());
					orderCategoryServiceDetail.setApproverId1(approverId1);
					orderCategoryServiceDetail.setApproverName1(approverName1);
					orderCategoryServiceDetail.setApproveNeed1("y");
					orderCategoryServiceDetail.setStatus("d");
					orderCategoryServiceDetail.setApproveStatus1("na");
					Double sumExpenseTotal = orderService.getSumExpenseTotal();
					if (null != sumExpenseTotal) {
						totalAmount += orderService.getSumExpenseTotal();
						orderCategoryServiceDetail.setAmount(sumExpenseTotal);
					} else {
						orderCategoryServiceDetail.setAmount(0.00);
					}
					//orderCategoryServiceDetail.setIndex(0);
					listOrderCategoryServiceDetail.add(orderCategoryServiceDetail);
					// 如果超过六条,插入一条报销草稿记录
					if ((i + 1) % stepInsert == 0 || (i + 1) == listOrderService.size()) {
						orderCategoryService.setTotalAmountRmb(totalAmount);
						orderCategoryService.setTotalAmount(totalAmount);
						orderCategoryService.setCurrencyCode("cu1");
						orderCategoryService.setExchangeRate("1.00");
						orderCategoryService.setTypeData("r");
						orderCategoryService.setStatus("d");
						orderCategoryService.setApplicantName(approverName1);
						orderCategoryService.setApplicantId(approverId1);
						
						orderCategoryService.setApplicantDate(new Date());
						orderCategoryServiceService.insert(orderCategoryService);
						Long idOrderCategoryServiceInner = orderCategoryService.getId();
						totalAmount = 0.00;
						for (int k = 0; k < listOrderCategoryServiceDetail.size(); k++) {
							OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = listOrderCategoryServiceDetail.get(k);
							orderCategoryServiceDetailInner.setId(null);
							orderCategoryServiceDetailInner.setIdOrderCategoryService(idOrderCategoryServiceInner);
							orderCategoryServiceDetailInner.setDivisionId(getDivisionId());
							orderCategoryServiceDetailService.insert(orderCategoryServiceDetailInner);
						}
						listOrderCategoryServiceDetail = new ArrayList<OrderCategoryServiceDetailImpl>();
					}
				}*/
					// 生成停车过路费报销单
					/*itemList = new ArrayList<>();
				for (int i = 0; i < listOrderService.size(); i++) {
					OrderServiceImpl orderService = listOrderService.get(i);
					orderCategoryServiceDetail = new ReimbursementItemImpl();
					orderCategoryServiceDetail.setAmount(orderService.getSumExpenseTotal());
					orderCategoryServiceDetail.setCategory1Id("14");
					orderCategoryServiceDetail.setCategory1Name("车费");
					orderCategoryServiceDetail.setCategory2Id("17");
					orderCategoryServiceDetail.setCategory2Name("停车过路过桥费");
					orderCategoryServiceDetail.setDescription("订车管理自动生成");
					orderCategoryServiceDetail.setDivisionId(orderService.getDivisionId());
					orderCategoryServiceDetail.setDivisionName(orderService.getDivisionName());
					orderCategoryServiceDetail.setCustomerId(orderService.getCustomer());
					orderCategoryServiceDetail.setCustomerName(orderService.getCustomerName());
					Double sumExpenseOther = orderService.getSumExpenseOther();
					if (null != sumExpenseOther) {
						totalAmount += orderService.getSumExpenseOther();
						orderCategoryServiceDetail.setAmount(sumExpenseOther);
					} else {
						orderCategoryServiceDetail.setAmount(0.00);
					}
					orderCategoryServiceDetail.setIndex(0);
					itemList.add(orderCategoryServiceDetail);
					// 如果超过六条,插入一条报销草稿记录
					if ((i + 1) % stepInsert == 0 || (i + 1) == listOrderService.size()) {
						reimbursement.setTotalAmount(totalAmount);
						reimbursement.setCurrencyId("1");
						reimbursementService.insert(reimbursement, itemList, session);
						totalAmount = 0.00;
						itemList = new ArrayList<ReimbursementItemImpl>();
					}
				}*/
				}
				}
			j.setObj(orderServiceRecord);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/doApprove")
	public ModelAndView doApprove(OrderServiceRecordImpl orderServiceRecord, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("/order/orderServiceRecord/searchOrderServiceRecord");
		String tagPageCode = orderServiceRecord.getTagPageCode();
		CommonUtil.setCommonField(orderServiceRecord, session);
		orderServiceRecord.setApproverId(getUserId());
		orderServiceRecord.setApproverName(getUserName());
		orderServiceRecord.setApproveDate(new Date());
		if ("1805000".equals(tagPageCode)) {
			orderServiceRecordService.update(orderServiceRecord);
		}
		String typeRecord = orderServiceRecord.getTypeRecord();
		// 数据类型(订车:ov order vehicle, 报销:or order reimbursement)

		// status状态标识(e:enable 有效, d:disable 无效,d:drift 草稿,s:submit 提交,a:approving 审批中,re:驳回,af:affirm 账务确认,c:complete 完成)
		// 报销统计1808800
		if ("or".equals(typeRecord) && tagPageCode == "1808800") {
			orderServiceRecordService.update(orderServiceRecord);
		}
		// 报销签字审批: 1808701,合并报销签字: 1808702, 报销签字驳回: 1808703， 报销签字: 1808700
		else if (("1808701".equals(tagPageCode)) || ("1808702".equals(tagPageCode)) || "1808703".equals(tagPageCode)) {
			String status = orderServiceRecord.getStatus();
			// 财务确认
			if ("1808701".equals(tagPageCode) && "af".equals(status)) {
				orderServiceRecordService.insert(orderServiceRecord);
			}
			Long idOrderServiceRecord = orderServiceRecord.getId();
			// 合并时的主编号
			Long ididOrderServiceRecordMerge = orderServiceRecord.getIdOrderServiceRecord();
			if("1808702".equals(tagPageCode)){
				idOrderServiceRecord = ididOrderServiceRecordMerge;
			}
			String strOrderService = orderServiceRecord.getField1();
			// 取得档期
			String month = orderServiceRecord.getMonth();
			if (null != strOrderService && strOrderService.length() > 0) {
				String[] arrOrderService = strOrderService.split(",");
				for (int i = 0; i < arrOrderService.length; i++) {
					Long idOrderCategoryService = Long.valueOf(arrOrderService[i]);
					OrderCategoryServiceImpl orderCategoryService = new OrderCategoryServiceImpl();
					orderCategoryService.setEditState("u");
					orderCategoryService.setId(idOrderCategoryService);
					orderCategoryService.setIdOrderServiceRecord(idOrderServiceRecord);
					orderCategoryService.setStatus("c");
					if (null != month) {
						orderCategoryService.setMonth(month);
					}
					if ("c".equals(status)) {
						orderCategoryService.setTagUpdate("rejectOrderCategoryService");
						orderCategoryService.setIdOrderServiceRecord(null);
						orderCategoryService.setStatus("af");
					}
					// 报销合并
					CommonUtil.setCommonField(orderCategoryService);
					orderCategoryServiceMapper.update(orderCategoryService);
				}
			}
			
			// 取得本条记录对应的报销单数量,如果为零,那么删除
			if("c".equals(status) && null != idOrderServiceRecord){
				OrderCategoryServiceImpl orderCategoryService = new OrderCategoryServiceImpl();
				orderCategoryService.setIdOrderServiceRecord(idOrderServiceRecord);
				orderCategoryService = orderCategoryServiceService.get(orderCategoryService);
				if (null == orderCategoryService) {
					orderServiceRecord = new OrderServiceRecordImpl();
					orderServiceRecord.setId(idOrderServiceRecord);;
					orderServiceRecordService.delete(orderServiceRecord);
				}
			}
			// 报销审批: 1808701,合并报销签字: 1808702, 报销驳回: 1808703,报销签字 1808700
			tagPageCode = "1808700";
		}
	
		mv.addObject("tagPageCode", tagPageCode);
		mv.addObject("userId", getUserId());
		return mv;
	}
	
	private void inserOrderCategoryService(OrderServiceRecordImpl orderServiceRecord){
		try {
			Long idOrderServiceRecord = orderServiceRecord.getId();
			// 二级科目编号
			String idCategoryLevel2 = orderServiceRecord.getIdCategoryLevel2();
			// 二级科目名称
			String nameCategoryLevel2 = orderServiceRecord.getNameCategoryLevel2();
			List<OrderServiceImpl> listOrderService = orderServiceRecordService.selectOrderServiceRecordForDriver(orderServiceRecord);
			OrderCategoryServiceImpl orderCategoryService = new OrderCategoryServiceImpl();
			orderCategoryService.setApplicantDivisionId("ab817736-8197-462e-a15b-910ec799efdb");
			orderCategoryService.setApplicantDivisionName("行政部");
			orderCategoryService.setApplicantId(getUserId());
			orderCategoryService.setApplicantName(getUserName());
			// 付款人姓名
			orderCategoryService.setPayeeName("");
			List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail = new ArrayList<>();
			
			OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
			// 每六条记录为一个报销单
			int stepInsert = 6;
			// 默认订车报销审批人	1701008
			/*UserImpl user = getUserByPermission("1701008");
			String approverId1 = user.getId();
			String approverName1 = user.getDisplayName();*/
			String driverIdLast = "";
			
			RolePermissionImpl rolePermission = new RolePermissionImpl();
			//rolePermission.setTypeId(getDivisionId());
			// 可选所有报销部门权限	7101001
			rolePermission.setCode("7101001");
			rolePermission = rolePermissionService.get(rolePermission);
			String divisionId = rolePermission.getTypeId();
			List<OrderCategoryServiceImpl> listOrderCategoryServiceInsert = new ArrayList<OrderCategoryServiceImpl>();
			for (int i = 0; i < listOrderService.size(); i++) {
				OrderServiceImpl orderService = listOrderService.get(i);
				String driverId = orderService.getDriverId();
				if (null != driverId && !driverId.equals(driverIdLast)){
					String nameDriver = orderService.getNameDriver();
					orderCategoryService = new OrderCategoryServiceImpl();
					orderCategoryService.setCurrencyCode("cu1");
					orderCategoryService.setExchangeRate("1.00");
					orderCategoryService.setTypeData("r");
					orderCategoryService.setStatus("d");
					orderCategoryService.setApplicantName(getUserName());
					orderCategoryService.setApplicantId(getUserId());
					orderCategoryService.setApplicantDate(new Date());
					orderCategoryService.setPayeeName(nameDriver);
					orderCategoryService.setIdOrderServiceRecord(idOrderServiceRecord);
					orderCategoryService.setApplicantDivisionId(divisionId);
					// 停车过路过桥费  14 父编号 137 现金 fkfs1 定额 fplx3
					if("14".equals(idCategoryLevel2)){
						// 发票类型
						// typePaymentCode 付款方式编号
						// typePaymentName 付款方式名称
						// typeInvoiceCode 发票类型编号
						// typeInvoiceName 发票类型名称
						// 付款方式 现金 fkfs1
						orderCategoryService.setTypePaymentName("现金");
						orderCategoryService.setTypePaymentCode("fkfs1");
						// 发票类型 定额 fplx3
						orderCategoryService.setTypeInvoiceName("定额");
						orderCategoryService.setTypeInvoiceCode("fplx3");
					} 
					// 公车车费 17 父编号 137 现金 fkfs1 其它 fplx2
					else if("17".equals(idCategoryLevel2)){
						// 发票类型
						// typePaymentCode 付款方式编号
						// typePaymentName 付款方式名称
						// typeInvoiceCode 发票类型编号
						// typeInvoiceName 发票类型名称
						// 付款方式 现金 fkfs1
						orderCategoryService.setTypePaymentName("现金");
						orderCategoryService.setTypePaymentCode("fkfs1");
						// 发票类型 其它 fplx2
						orderCategoryService.setTypeInvoiceName("其它");
						orderCategoryService.setTypeInvoiceCode("fplx2");
					}
					listOrderCategoryServiceInsert.add(orderCategoryService);
					listOrderCategoryServiceDetail = new ArrayList<OrderCategoryServiceDetailImpl>();
				}
				
				// 停车过路过桥费 14 父编号 137
				// 公车车费 17 父编号 137
				orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
				orderCategoryServiceDetail.setAmount(orderService.getSumExpenseTotal());
				orderCategoryServiceDetail.setIdCategoryLeve1("137");
				orderCategoryServiceDetail.setNameCategoryLevel1("车费");
				orderCategoryServiceDetail.setIdCategoryLevel2(idCategoryLevel2);
				orderCategoryServiceDetail.setNameCategoryLevel2(nameCategoryLevel2);
				orderCategoryServiceDetail.setRemark(orderService.getRemark());
				orderCategoryServiceDetail.setDivisionId(orderService.getDivisionId());
				orderCategoryServiceDetail.setDivisionName(orderService.getDivisionName());
				orderCategoryServiceDetail.setCustomerId1(orderService.getCustomer());
				orderCategoryServiceDetail.setCustomerName1(orderService.getCustomerName());
				orderCategoryServiceDetail.setStatus("d");
				Double sumExpenseTotal = 0.00;
				// 公车车费 17 父编号 137
				// 停车过路过桥费 14 父编号 137
				if("17".equals(idCategoryLevel2)){
					sumExpenseTotal = orderService.getSumExpenseTotal();
				}
				else if ("14".equals(idCategoryLevel2)) {
					sumExpenseTotal = orderService.getSumExpenseOther();
				}
				if (null != sumExpenseTotal) {
					orderCategoryServiceDetail.setAmount(sumExpenseTotal);
					orderCategoryServiceDetail.setAmountRmb(sumExpenseTotal);
				} else {
					orderCategoryServiceDetail.setAmount(0.00);
					orderCategoryServiceDetail.setAmountRmb(0.00);
				}
				//orderCategoryServiceDetail.setIndex(0);
				
				String divisionIdTemp = orderService.getDivisionId();
				// 根据部门和科目编号取得审批人
				RolePermissionImpl rolePermissionTemp = new RolePermissionImpl();
				// 角色类型(s:系统,d:部门,u:用户)
				rolePermissionTemp.setType("d");
				rolePermissionTemp.setCode(idCategoryLevel2);
				rolePermissionTemp.setTypeIdRole(divisionIdTemp);
				rolePermissionTemp.setParentCode("2002000");
				RolePermissionImpl rolePermissionTemp2 = new RolePermissionImpl();
				rolePermissionTemp2 = (RolePermissionImpl) rolePermissionService.get(rolePermissionTemp);
				String approver1 = null;
				if (null != rolePermissionTemp2) {
					approver1 = rolePermissionTemp2.getApprover1();
				}
				// 负责人 1701005, 总监 	1701004, 高管 1701002
				if ("1701005".equals(approver1) || null == approver1 
						//所有情况都让周老师审批
						|| null != approver1) {
					// 根据部门编号取得本部门负责人
					UserDivision userDivision = new UserDivision();
					userDivision.setDivisionId(divisionId);
					// 负责人 	gwmc2
					userDivision.setPositionId("gwmc2");
					List<UserDivisionImpl> listUserDivision = (List<UserDivisionImpl>) userDivisionMapper.select(userDivision);
					if (null != listUserDivision && listUserDivision.size() == 1) {
						userDivision = listUserDivision.get(0);
						String userId = userDivision.getUserId();
						orderCategoryServiceDetail.setApproverId1(userId);
						User user2 = new User();
						user2.setId(userId);
						user2 = (User) userMapper.get(user2);
						String userNameManager = user2.getDisplayName();
						String email = user2.getEmail();
						orderCategoryServiceDetail.setApproverEmail1(email);
						if (null != userNameManager){
							orderCategoryServiceDetail.setApproverName1(userNameManager);
						}
						orderCategoryServiceDetail.setApproveNeed1("y");
						orderCategoryServiceDetail.setApproveStatus1("na");
					}
					else {
						orderCategoryServiceDetail.setApproverId1(approver1);
						User user2 = new User();
						user2.setId(approver1);
						user2 = (User) userMapper.get(user2);
						String userNameManager = user2.getDisplayName();
						String email = user2.getEmail();
						orderCategoryServiceDetail.setApproverEmail1(email);
						if (null != userNameManager){
							orderCategoryServiceDetail.setApproverName1(userNameManager);
						}
						orderCategoryServiceDetail.setApproveNeed1("y");
						orderCategoryServiceDetail.setApproveStatus1("na");
					}
				}
				listOrderCategoryServiceDetail.add(orderCategoryServiceDetail);
				// 1 如果是同一司机记录数小于6条,那第直接插入
				// 2 如果是同一司机记录数大于6条,那么也需要插入一条新记录
				/*if ((i + 1) % stepInsert == 0 || (i + 1) == listOrderService.size()) {
					orderCategoryService.setListOrderCategoryServiceDetail(listOrderCategoryServiceDetail);
				}*/
				orderCategoryService.setListOrderCategoryServiceDetail(listOrderCategoryServiceDetail);
				driverIdLast = driverId;
			}
			if (null != listOrderCategoryServiceInsert && listOrderCategoryServiceInsert.size() > 0) {
				
				List<OrderCategoryServiceDetailImpl> listCategoryServiceDetailInsert = new ArrayList<>();
				for (int i = 0; i < listOrderCategoryServiceInsert.size(); i++) {
					OrderCategoryServiceImpl orderCategoryServiceInner = listOrderCategoryServiceInsert.get(i);
					List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetailInner = orderCategoryServiceInner.getListOrderCategoryServiceDetail();
					for (int k = 0; k < listOrderCategoryServiceDetailInner.size(); k++) {
						OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = listOrderCategoryServiceDetailInner.get(k);
						// 如果为6条记录的情况下,那么插入一条主表记录,如果不够六条,并且再无记录的情况下,那么插入不够六条的记录
						listCategoryServiceDetailInsert.add(orderCategoryServiceDetailInner);
						if ((k+1)%stepInsert == 0 || (k+1 == listOrderCategoryServiceDetailInner.size())) {
							orderCategoryServiceInner.setEditState("i");
							CommonUtil.setCommonField(orderCategoryServiceInner);
							orderCategoryServiceService.insert(orderCategoryServiceInner);
							Double totalAmount = 0.00;
							Long idOrderCategoryServiceTemp = orderCategoryServiceInner.getId();
							for (int k2 = 0; k2 < listCategoryServiceDetailInsert.size(); k2++) {
								OrderCategoryServiceDetailImpl orderCategoryServiceDetailInsertTemp = new OrderCategoryServiceDetailImpl();
								orderCategoryServiceDetailInsertTemp = listCategoryServiceDetailInsert.get(k2);
								orderCategoryServiceDetailInsertTemp.setEditState("i");
								CommonUtil.setCommonField(orderCategoryServiceDetailInsertTemp);
								orderCategoryServiceDetailInsertTemp.setId(null);
								orderCategoryServiceDetailInsertTemp.setIdOrderCategoryService(idOrderCategoryServiceTemp);
								orderCategoryServiceDetailInsertTemp.setRemark("来自 No." + idOrderServiceRecord + " 订车报销自动生成");
								Double amount = orderCategoryServiceDetailInsertTemp.getAmount();
								if (null != amount && amount > 0) {
									orderCategoryServiceDetailService.insert(orderCategoryServiceDetailInsertTemp);
								}
								totalAmount += orderCategoryServiceDetailInsertTemp.getAmountRmb();
							}
							if (null != totalAmount && totalAmount > 0) {
								OrderCategoryServiceImpl orderCategoryServiceTemp2 = new OrderCategoryServiceImpl();
								orderCategoryServiceTemp2.setTotalAmountRmb(totalAmount);
								orderCategoryServiceTemp2.setTotalAmount(totalAmount);
								orderCategoryServiceTemp2.setId(idOrderCategoryServiceTemp);
								orderCategoryServiceTemp2.setEditState("u");
								orderCategoryServiceMapper.update(orderCategoryServiceTemp2);
							}
							else {
								OrderCategoryServiceImpl orderCategoryServiceTemp2 = new OrderCategoryServiceImpl();
								orderCategoryServiceTemp2.setId(idOrderCategoryServiceTemp);
								orderCategoryServiceMapper.delete(orderCategoryServiceTemp2);
							}
							listCategoryServiceDetailInsert = new ArrayList<OrderCategoryServiceDetailImpl>();
						}
					}
				}
			}
		} catch (PmException e) {
			e.printStackTrace();
		}
	}
}