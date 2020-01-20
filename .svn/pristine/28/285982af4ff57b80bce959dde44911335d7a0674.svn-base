package com.mtf.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.OrderServiceDetailMapper;
import com.mtf.framework.dao.OrderServiceMapper;
import com.mtf.framework.dao.OrderServicePathMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.OrderServiceDetailImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.OrderServicePathImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.OrderServiceService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.model.Email;
import com.mtf.framework.model.UserDivision;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 考勤配置
 * 作者:     Auto
 * 日期:     2015/10/21
**********************************************
*/
@Service("orderServiceService")
public class OrderServiceServiceImpl extends CommonServiceImpl implements OrderServiceService {
	@Autowired
	private OrderServiceMapper orderServiceMapper;
	
	@Autowired
	private OrderServiceDetailMapper orderServiceDetailMapper;
	
	@Autowired
	private OrderServicePathMapper orderServicePathMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
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
	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	@Autowired
	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	@Autowired
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	@Autowired
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public OrderServicePathMapper getOrderServicePathMapper() {
		return orderServicePathMapper;
	}

	public void setOrderServicePathMapper(
			OrderServicePathMapper orderServicePathMapper) {
		this.orderServicePathMapper = orderServicePathMapper;
	}

	@Autowired
	public OrderServiceDetailMapper getOrderServiceDetailMapper() {
		return orderServiceDetailMapper;
	}

	@Autowired
	public void setOrderServiceDetailMapper(
			OrderServiceDetailMapper orderServiceDetailMapper) {
		this.orderServiceDetailMapper = orderServiceDetailMapper;
	}

	@Autowired
	public OrderServiceMapper getOrderServiceMapper() {
		return orderServiceMapper;
	}

	@Autowired
	public void setOrderServiceMapper(OrderServiceMapper orderServiceMapper) {
		this.orderServiceMapper = orderServiceMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderService
	 */
	public OrderServiceImpl insert(OrderServiceImpl orderService) throws PmException {
		String tagEditState = orderService.getTagEditState();
		// 已派车状态(d:draft 草稿,s:提交,a:分配)
		if ("d".equals(tagEditState)) {
			orderService.setStatusOrder("d");
		} else if ("s".equals(tagEditState)) {
			orderService.setStatusOrder("s");
		}
		this.orderServiceMapper.insert(orderService);
		// 如果是提交状态发送邮件
		String statusOrder = orderService.getStatusOrder();
		String tagModule = orderService.getTagModule();
		// 模块(订车 o:order, 派车 a:allocation)
		if("o".equals(tagModule) && "s".equals(statusOrder)){
			this.sendMail(orderService);
		}
		return orderService;
	}

	/**
	 * 删除实体对象
	 * @param orderService
	 */
	public int delete(OrderServiceImpl orderService) throws PmException {
		return this.orderServiceMapper.delete(orderService);
	}

	/**
	 * 更新实体对象
	 * @param orderService
	 */
	public boolean update(OrderServiceImpl orderService) throws PmException {
		boolean result = true;
		String tagModule = orderService.getTagModule();
		String tagEditState = orderService.getTagEditState();
		String editState = orderService.getEditState();
		String statusOrder = orderService.getStatusOrder();
		String approveStatus = orderService.getApproveStatus();
		Long idOrderService = orderService.getId();
		String driverId = orderService.getDriverId();
		// 模块(订车 o:order, 派车 a:allocation)
		if ("o".equals(tagModule)) {
			// 如果是正常编辑状态
			if ("u".equals(editState)) {
				// 计费类别(固定金额:jflb1, 公里数:jflb2)
				String typeExpense = orderService.getTypeExpense();
				if ("jflb1".equals(typeExpense)) {
					// 更新子表
					this.inserDetail(orderService);
				}
				if ("d".equals(tagEditState) || "s".equals(tagEditState)) {
					orderService.setStatusOrder(tagEditState);
				}
				// 如果是确认操作
				// 如果是订车单确认操作,取得当前记录原始状态 affim 确认
				if ("af".equals(approveStatus)) {
					// 取得当前订单状态, 行政派车: draft allocation da 派车中, submit allocation sa 已派车
					if ("sa".equals(statusOrder)) {
						orderService.setStatusOrder("asa");
						// 行政录入派车单: draft input aollcation dia 录入派车单草稿, sumbit input aollcation sia 录入派车单完成
					} else if ("sia".equals(statusOrder)) {
						// affirm input aollcation aia 员工派车单确认
						orderService.setStatusOrder("aia");
					}
				}
			} 
			this.orderServiceMapper.update(orderService);
			if("s".equals(tagEditState)){
				this.sendMail(orderService);
			}
		}
		if ("ap".equals(tagModule) && "a".equals(editState)) {
			String idString = orderService.getIdString();
			if (null != idString && idString.length() > 0) {
				 String[] idStringArray = idString.split(",");
				 for (int i = 0; i < idStringArray.length; i++) {
					Long id = Long.valueOf(idStringArray[i]);
					orderService.setId(id);
					orderServiceMapper.update(orderService);
				}
			}
		}
		// 订车状态(
		// 1员工申请: d draft 草稿 s sumbit 提交,            
		// 2部门审批:ap1 ,                                            
		// 3行政派车: draft allocation da 派车中 submit allocation sa 已派车,
		// 4用车人派车确认: affirm submit allocation  asa,
		// 5行政录入派车单: draft input aollcation dia 录入派车单草稿, sumbit input aollcation sia 录入派车单完成,
		// 6用车人派车单确认: affirm input aollcation aia, 
		// 7行政审批: ap2)
		// 模块(订车 o:order, 派车 a:allocation)
		if ("a".equals(tagModule)) {
			if ("u".equals(editState)) {
				// 如果是部门审批状态,那赋值如下
				if ("ap2".equals(statusOrder) || "ap1".equals(statusOrder) || "da".equals(statusOrder) || "sa".equals(statusOrder)) {
					// 已派车状态(d:draft 草稿,s:提交,a:分配)
					if ("d".equals(tagEditState)) {
							orderService.setStatusOrder("da");
					} else if ("s".equals(tagEditState)) {
							orderService.setStatusOrder("sa");
					}
				}
				// 如果是员工派车单确认: affirm input aollcation aia
				if ("asa".equals(statusOrder) || "dia".equals(statusOrder) || "aia".equals(statusOrder)) {
					// 已派车状态(d:draft 草稿,s:提交,a:分配)
					if ("d".equals(tagEditState)) {
						orderService.setStatusOrder("dia");
					} else if ("s".equals(tagEditState)) {
						orderService.setStatusOrder("sia");
					}
				}
				// 取得司机牌照
				UserDetailImpl userDetail = new UserDetailImpl();
				userDetail.setUserId(driverId);
				userDetail = (UserDetailImpl) userDetailMapper.get(userDetail);
				String vehiclePlateNo = userDetail.getBadgenumber(); 
				orderService.setVehiclePlateNo(vehiclePlateNo);
				orderServiceMapper.update(orderService);
				// submit allocation sa 已派车
				statusOrder = orderService.getStatusOrder();
				if ("sa".equals(statusOrder)) {
					try {
						// 取得订车人邮箱
						// 取得订车人信息
						OrderServiceImpl orderServiceT = new OrderServiceImpl();
						orderServiceT.setId(idOrderService);
						orderServiceT = (OrderServiceImpl) orderServiceMapper.get(orderServiceT);
						String userId = orderServiceT.getUserId();
						UserDetailImpl userDetailTemp = new UserDetailImpl();
						userDetailTemp.setUserId(userId);
						userDetailTemp = (UserDetailImpl) userDetailMapper.get(userDetailTemp);
						String mail = userDetailTemp.getEmail();
						if (null != mail && mail.length() > 5) {
							EmailImpl email = new EmailImpl();
							//String tagTest = CommonUtil.getConfig("tagTest");
							if (CommonUtil.getTagSys()) {
								email.setReceiver(mail);
							} else {
								email.setReceiver("neoyin@ManchuTimesFashion.com");
							}
							
							email.setTheme("系统提醒/订车确认");
							email.setOrderService(orderServiceT);
							email.setUserDetail(userDetailTemp);
							List<EmailImpl> listEmail = new ArrayList<>();
							listEmail.add(email);
							emailService.sendMailOrderServiceVehicle(listEmail);
						}
					} catch (EmailException e) {
						e.printStackTrace();
					}
				}
				// 计费类别(固定金额:jflb1, 公里数:jflb2)
				String typeExpense = orderService.getTypeExpense();
				if (null != typeExpense && "jflb1".equals(typeExpense)) {
					// 更新子表
					this.inserDetail(orderService);
				}
			}
			else if ("a".equals(editState)) {
				String idString = orderService.getIdString();
				if (null != idString && idString.length() > 0) {
					 String[] idStringArray = idString.split(",");
					 for (int i = 0; i < idStringArray.length; i++) {
						Long id = Long.valueOf(idStringArray[i]);
						orderService.setId(id);
						orderServiceMapper.update(orderService);
					}
				}
			}
			
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderService
	 */
	@SuppressWarnings("unchecked")
	public List<OrderServiceImpl> select(OrderServiceImpl orderService) throws PmException {
		return (List<OrderServiceImpl>) this.orderServiceMapper.select(orderService);
	}
	@SuppressWarnings("unchecked")
	public void select() throws PmException {
		System.err.println("ok");
	}
	/**
	 * 查询单个实体
	 * @param orderService
	 */
	public OrderServiceImpl get(OrderServiceImpl orderService) throws PmException {
		return (OrderServiceImpl) this.orderServiceMapper.get(orderService);
	}
	/**
	 * 查询实体分页列表
	 * @param orderService
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderServiceImpl> search(OrderServiceImpl orderService) throws PmException {
		DataGrid<OrderServiceImpl> grid = new DataGrid<OrderServiceImpl>();
		Object obj = orderService;
		List list = orderServiceMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderServiceMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	
	public void inserDetail(OrderServiceImpl orderService) {
		Long idOrderService = orderService.getId();
		OrderServiceDetailImpl orderServiceDetail = new OrderServiceDetailImpl();
		orderServiceDetail.setIdOrderService(idOrderService);
		// 取得json列表对象
		String jsonListString = orderService.getJsonListString();
		if (jsonListString != null && jsonListString.length() > 1) {
			// 删除所有子表信息
			orderServiceDetailMapper.delete(orderServiceDetail);
			JSONArray jsonArray = JSONArray.fromObject(jsonListString);
			orderServiceDetail = new OrderServiceDetailImpl();
			@SuppressWarnings("unchecked")
			List<OrderServiceDetailImpl> listOrderService = (List<OrderServiceDetailImpl>) CommonUtil.JSON2List(jsonArray, new OrderServiceDetailImpl());
			for (int i = 0; i < listOrderService.size(); i++) {
				orderServiceDetail = listOrderService.get(i);
				orderServiceDetail.setIdOrderService(idOrderService);
				orderServiceDetailMapper.insert(orderServiceDetail);
			}
		}
	}
	
	public OrderServiceImpl calcuteOrderService(OrderServiceImpl orderService) {
		try {
			// 派车模块自动计算实际费用
			// 公里数,双倍
			// 计费类别(固定金额:jflb1, 公里数:jflb2)
			// 固定金额,直接取值
			String typeExpense = orderService.getTypeExpense();
			if(null == typeExpense){
				return orderService;
			}
			// 实际费用
			Double expenseActual = orderService.getExpenseActual();
			if ("".equals(expenseActual) || null == expenseActual) {
				expenseActual = 0.00;
			}
			// 通行费 
			Double expensePass = orderService.getExpensePass();
			if ("".equals(expensePass) || null == expensePass) {
				expensePass = 0.00;
			}
			// 其它费用 
			Double expenseOther = orderService.getExpenseOther();
			if ("".equals(expenseOther) || null == expenseOther) {
				expenseOther = 0.00;
			}
			// 合计
			Double expenseTotal = orderService.getExpenseTotal();
			if ("".equals(expenseTotal) || null == expenseTotal) {
				expenseTotal = 0.00;
			}
			
			// 公里表数
			Double mileage = orderService.getMileage();
			if ("".equals(mileage) || null == mileage) {
				mileage = 0.00;
			}
			// 固定金额,直接取值
			if ("jflb1".equals(typeExpense)) {
				// 计算金额
				Long idOrderServicePath = orderService.getIdOrderServicePath();
				OrderServicePathImpl orderServicePath = new OrderServicePathImpl();
				orderServicePath.setId(idOrderServicePath);
				orderServicePath = (OrderServicePathImpl) orderServicePathMapper.get(orderServicePath);
				// 实际费用
				expenseActual = orderServicePath.getExpense();
				mileage = orderServicePath.getMileage();
			}
			// 公里数,按双倍金额
			else if ("jflb2".equals(typeExpense)) {
				// 计算金额
				expenseActual = mileage * 2;
			}
			expenseTotal = expenseActual + expensePass + expenseOther;
			orderService.setExpenseActual(expenseActual);
			orderService.setExpenseTotal(expenseTotal);
			orderService.setMileage(mileage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderService;
	}
	
	private void sendMail(OrderServiceImpl orderService) {
		String statusOrder = orderService.getStatusOrder();
		Long idOrderService = orderService.getId();
		// 用车人
		if ("s".equals(statusOrder)) {
			try {
				// 取得订车负责人邮箱
				// 取得订车人信息
				OrderServiceImpl orderServiceT = new OrderServiceImpl();
				orderServiceT.setId(idOrderService);
				orderServiceT = (OrderServiceImpl) orderServiceMapper.get(orderServiceT);
				String userId = orderService.getUserId();
				UserDetailImpl userDetailTemp = new UserDetailImpl();
				userDetailTemp.setUserId(userId);
				userDetailTemp = (UserDetailImpl) userDetailMapper.get(userDetailTemp);
				String mail = userDetailTemp.getEmail();
				if (null != mail && mail.length() > 5) {
					EmailImpl email = new EmailImpl();
					// 1701007 OA负责人权限
					UserDetailImpl user = new UserDetailImpl();
					user.setCode("1701007");
					user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
					email.setReceiver(user.getEmail());
					email.setTheme("系统提醒/订车申请/行政审批");
					email.setOrderService(orderServiceT);
					email.setUserDetail(user);
					email.setJumpPageCode("1803001");
					List<EmailImpl> listEmail = new ArrayList<>();
					listEmail.add(email);
					
					// 经理审批
					// 根据部门编号取得本部门负责人
					UserDivision userDivision = new UserDivision();
					userDivision.setDivisionId(getDivisionId());
					
					// 负责人 	gwmc2
					userDivision.setPositionId("gwmc2");
					List<UserDivisionImpl> listUserDivision = (List<UserDivisionImpl>) userDivisionMapper.select(userDivision);
					if(listUserDivision != null && listUserDivision.size() > 0){
						for (int i = 0; i < listUserDivision.size(); i++) {
							UserDivisionImpl userDivisionInner = listUserDivision.get(i);
							String userIdInner = userDivisionInner.getUserId();
							UserDetailImpl userDetailInner = new UserDetailImpl();
							userDetailInner.setUserId(userIdInner);
							userDetailInner = (UserDetailImpl) userDetailMapper.get(userDetailInner);
							if(null != userDetailInner){
								String mailInner = userDetailInner.getEmail();
								if(null != mailInner){
									email = new EmailImpl();
									email.setReceiver(mailInner);
									email.setUserDetail(userDetailInner);
									email.setTheme("系统提醒/订车申请/经理审批");
									email.setOrderService(orderServiceT);
									email.setJumpPageCode("1804001");
									listEmail.add(email);
								}
							}
						}
					}
					
					emailService.sendMailOrderServiceVehicleUser(listEmail);
				}
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
	}
}