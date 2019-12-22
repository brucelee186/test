package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.dao.OrderCategoryMapper;
import com.mtf.framework.dao.OrderCategoryServiceConditionMapper;
import com.mtf.framework.dao.OrderCategoryServiceDetailConditionMapper;
import com.mtf.framework.dao.OrderCategoryServiceDetailMapper;
import com.mtf.framework.dao.OrderCategoryServiceMapper;
import com.mtf.framework.dao.RolePermissionMapper;
import com.mtf.framework.dao.SysHistoryMapper;
import com.mtf.framework.dao.SysTempMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.UserDivision;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.CurrencyImpl;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.model.impl.RolePermissionImpl;
import com.mtf.framework.model.impl.SysHistoryImpl;
import com.mtf.framework.model.impl.SysTempImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.CurrencyService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.OrderCategoryServiceService;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 科目申请服务
 * 作者:     Auto
 * 日期:     2016/6/22
**********************************************
*/
@Service("orderCategoryServiceService")
public class OrderCategoryServiceServiceImpl extends CommonServiceImpl implements OrderCategoryServiceService {
	@Autowired
	private OrderCategoryServiceMapper orderCategoryServiceMapper;
	
	@Autowired
	private OrderCategoryServiceDetailMapper orderCategoryServiceDetailMapper;
	
	@Autowired
	private OrderCategoryServiceConditionMapper orderCategoryServiceConditionMapper;
	
	@Autowired
	private OrderCategoryMapper orderCategoryMapper;
	
	@Autowired
	private DivisionMapper divisionMapper;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private UserDivisionMapper userDivisionMapper;
	
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private UserInforService userInforService;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	@Autowired
	private OrderCategoryServiceDetailConditionMapper orderCategoryServiceDetailConditionMapper;
	
	@Autowired
	private SysTempMapper sysTempMapper;
	
	@Autowired
	private SysHistoryMapper sysHistoryMapper;
	
	@Autowired
	public SysHistoryMapper getSysHistoryMapper() {
		return sysHistoryMapper;
	}

	@Autowired
	public void setSysHistoryMapper(SysHistoryMapper sysHistoryMapper) {
		this.sysHistoryMapper = sysHistoryMapper;
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
	public SysTempMapper getSysTempMapper() {
		return sysTempMapper;
	}

	@Autowired
	public void setSysTempMapper(SysTempMapper sysTempMapper) {
		this.sysTempMapper = sysTempMapper;
	}

	@Autowired
	public OrderCategoryServiceDetailConditionMapper getOrderCategoryServiceDetailConditionMapper() {
		return orderCategoryServiceDetailConditionMapper;
	}

	@Autowired
	public void setOrderCategoryServiceDetailConditionMapper(
			OrderCategoryServiceDetailConditionMapper orderCategoryServiceDetailConditionMapper) {
		this.orderCategoryServiceDetailConditionMapper = orderCategoryServiceDetailConditionMapper;
	}

	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	@Autowired
	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	@Autowired
	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@Autowired
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Autowired
	public RolePermissionMapper getRolePermissionMapper() {
		return rolePermissionMapper;
	}

	@Autowired
	public void setRolePermissionMapper(RolePermissionMapper rolePermissionMapper) {
		this.rolePermissionMapper = rolePermissionMapper;
	}

	@Autowired
	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	@Autowired
	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
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
	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	@Autowired
	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
	}

	@Autowired
	public OrderCategoryMapper getOrderCategoryMapper() {
		return orderCategoryMapper;
	}

	@Autowired
	public void setOrderCategoryMapper(OrderCategoryMapper orderCategoryMapper) {
		this.orderCategoryMapper = orderCategoryMapper;
	}

	@Autowired
	public OrderCategoryServiceConditionMapper getOrderCategoryServiceConditionMapper() {
		return orderCategoryServiceConditionMapper;
	}

	@Autowired
	public void setOrderCategoryServiceConditionMapper(
			OrderCategoryServiceConditionMapper orderCategoryServiceConditionMapper) {
		this.orderCategoryServiceConditionMapper = orderCategoryServiceConditionMapper;
	}

	@Autowired
	public OrderCategoryServiceDetailMapper getOrderCategoryServiceDetailMapper() {
		return orderCategoryServiceDetailMapper;
	}

	@Autowired
	public void setOrderCategoryServiceDetailMapper(
			OrderCategoryServiceDetailMapper orderCategoryServiceDetailMapper) {
		this.orderCategoryServiceDetailMapper = orderCategoryServiceDetailMapper;
	}

	@Autowired
	public OrderCategoryServiceMapper getOrderCategoryServiceMapper() {
		return orderCategoryServiceMapper;
	}

	@Autowired
	public void setOrderCategoryServiceMapper(OrderCategoryServiceMapper orderCategoryServiceMapper) {
		this.orderCategoryServiceMapper = orderCategoryServiceMapper;
	}

	/**
	 * 新增实体对象
	 * @param orderCategoryService
	 */
	public OrderCategoryServiceImpl insert(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		orderCategoryService.setId(null);
		String applicantDivisionId = orderCategoryService.getApplicantDivisionId();
		String status = orderCategoryService.getStatus();
		String payeeId = orderCategoryService.getPayeeId();
		if (null != applicantDivisionId) {
			DivisionImpl division = new DivisionImpl();
			division.setId(applicantDivisionId);
			division = (DivisionImpl) divisionMapper.get(division);
			String applicantDivisionName = division.getName();
			orderCategoryService.setApplicantDivisionName(applicantDivisionName);
		}
		this.orderCategoryServiceMapper.insert(orderCategoryService);
		//this.payNameHandler2(orderCategoryService);
		this.inserDetail(orderCategoryService);
		Double totalAmount = orderCategoryService.getTotalAmount();
		Double totalAmountRmb = orderCategoryService.getTotalAmountRmb();
		Long id = orderCategoryService.getId();
		orderCategoryService = new OrderCategoryServiceImpl();
		orderCategoryService.setId(id);
		orderCategoryService.setTotalAmount(totalAmount);
		orderCategoryService.setTotalAmountRmb(totalAmountRmb);
		// 取得银行卡信息
		if (payeeId != null) {
			orderCategoryService.setPayeeId(payeeId);
			this.updateBankInfo(orderCategoryService);
		}
		orderCategoryServiceMapper.update(orderCategoryService);
		if ("s".equals(status) 
				//|| "t".equals(CommonUtil.getConfig("tagTest"))
			) {
			Long idOrderCategoryService = orderCategoryService.getId();
			// 如果是提交状态,发送邮件
			OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
			orderCategoryServiceDetailTemp2.setIdOrderCategoryService(idOrderCategoryService);
			orderCategoryServiceDetailTemp2.setStatus("s");
			orderCategoryServiceDetailTemp2.setApproveCondition1("ap");
			orderCategoryServiceDetailTemp2.setApproveStatus("s");
			try {
				emailService.sendMailOrderCategoryService(orderCategoryServiceDetailTemp2);
			} catch (EmailException e) {
				e.printStackTrace();
			}
		}
		return orderCategoryService;
	}

	/**
	 * 删除实体对象
	 * @param orderCategoryService
	 */
	public int delete(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		Long idOrderCategoryService = orderCategoryService.getId();
		OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
		orderCategoryServiceDetail.setIdOrderCategoryService(idOrderCategoryService);
		orderCategoryServiceDetailMapper.delete(orderCategoryServiceDetail);
		int res = this.orderCategoryServiceMapper.delete(orderCategoryService);
		return res;
	}

	/**
	 * 更新实体对象
	 * @param orderCategoryService
	 */
	public boolean update(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		String editState = orderCategoryService.getEditState();
		boolean result = true;
		String status = orderCategoryService.getStatus();
		String payeeId = orderCategoryService.getPayeeId();
		if ("u".equals(editState)) {
			//this.orderCategoryServiceMapper.update(orderCategoryService);
			this.inserDetail(orderCategoryService);
			Double totalAmount = orderCategoryService.getTotalAmount();
			Long id = orderCategoryService.getId();
			//orderCategoryService = new OrderCategoryServiceImpl();
			orderCategoryService.setId(id);
			if (!"s".equals(status)) {
				orderCategoryService.setTotalAmount(totalAmount);
			}
			DivisionImpl division = new DivisionImpl();
			String applicantDivisionId = orderCategoryService.getApplicantDivisionId();
			if (null != applicantDivisionId) {
				division.setId(applicantDivisionId);
				division = (DivisionImpl) divisionMapper.get(division);
				String applicantDivisionName = division.getName();
				orderCategoryService.setApplicantDivisionName(applicantDivisionName);
			}
			orderCategoryService.setStatus(status);
			orderCategoryService.setRemarkApprove(" ");
			double totalAmountRmb = orderCategoryService.getTotalAmountRmb();
			if (0 == totalAmountRmb) {
				OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
				orderCategoryServiceDetail.setIdOrderCategoryService(id);
				orderCategoryServiceDetail = orderCategoryServiceDetailConditionMapper.sumAmountRmbById(orderCategoryServiceDetail);
				if (null != orderCategoryServiceDetail) {
					totalAmountRmb = orderCategoryServiceDetail.getTotalAmountRmb();
					if (totalAmountRmb > 0) {
						orderCategoryService.setTotalAmountRmb(totalAmountRmb);
					}
					totalAmount = orderCategoryServiceDetail.getTotalAmount();
					if (totalAmount > 0) {
						orderCategoryService.setTotalAmount(totalAmount);
					}
				}
			}
			
			// 取得银行卡信息
			if (payeeId != null) {
				orderCategoryService.setPayeeId(payeeId);
				this.updateBankInfo(orderCategoryService);
			}
			orderCategoryServiceMapper.update(orderCategoryService);
			//this.payNameHandler2(orderCategoryService);
			if ("s".equals(status)) {
				Long idOrderCategoryService = orderCategoryService.getId();
				// 如果是提交状态,发送邮件
				OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
				orderCategoryServiceDetailTemp2.setIdOrderCategoryService(idOrderCategoryService);
				orderCategoryServiceDetailTemp2.setStatus("s");
				orderCategoryServiceDetailTemp2.setApproveCondition1("ap");
				orderCategoryServiceDetailTemp2.setApproveStatus("s");
				try {
					emailService.sendMailOrderCategoryService(orderCategoryServiceDetailTemp2);
				} catch (EmailException e) {
					e.printStackTrace();
				}
			}
		}
		else if ("a".equals(editState)) {
			String remarkApprove = orderCategoryService.getRemarkApprove();
			String arrayId = orderCategoryService.getArrayId();
			String tagPageCode = orderCategoryService.getTagPageCode();
			List<OrderCategoryServiceImpl> listOrderCategoryService = new ArrayList<OrderCategoryServiceImpl>();
			// 一级审批或驳回
			// 根据职位取得审批科级
			// 取得高管权限
			// 部门审批 经理(负责人) 1701005
			String approveStatus = "";
			String approveLevel = "1";
			//boolean approveDep = CommonUtil.checkCode("1701005");
			// 经理审批	1808200
			if ("1808200".equals(tagPageCode)) {
				approveLevel = "1";
			}
			// 总监审批 1701004
			//boolean approveAdmin = CommonUtil.checkCode("1701004");
			// 总监审批	1808300
			if ("1808300".equals(tagPageCode)) {
				approveLevel = "2";
			}
			// 高管审批 1701002
			//boolean approveTopManager = CommonUtil.checkCode("1701002");
			// 高管审批1808400
			if ("1808400".equals(tagPageCode)) {
				approveLevel = "3";
			}
			// 财务审批 1808600
			if ("1808600".equals(tagPageCode)) {
				approveLevel = "4";
			}
			approveStatus =  status + approveLevel;
			//String remarkReject = orderCategoryService.getRemarkReject();
			String[] arrayOrderCategoryService = arrayId.split(",");
			if (null != arrayOrderCategoryService && arrayOrderCategoryService.length >0) {
				for (int i = 0; i < arrayOrderCategoryService.length; i++) {
					String orderCategoryServiceIdString = arrayOrderCategoryService[i].split("-")[0];
					Long orderCategoryServiceId = Long.valueOf(orderCategoryServiceIdString);
					orderCategoryService = new OrderCategoryServiceImpl();
					orderCategoryService.setId(orderCategoryServiceId);
					orderCategoryService.setApproveDate(new Date());
					orderCategoryService.setApproverName(CommonUtil.getUserName());
					orderCategoryService.setApproverId(CommonUtil.getUserId());
					orderCategoryService.setStatus(approveStatus);
					//orderCategoryService.setStatus("ap1");
					//orderCategoryService.setRemarkReject(remarkReject);
					//orderCategoryServiceMapper.update(orderCategoryService);
					// 更新明细
					OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetail.setIdOrderCategoryService(orderCategoryServiceId);
					OrderCategoryServiceImpl orderCategoryServiceTemp = new OrderCategoryServiceImpl();
					
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp = new OrderCategoryServiceDetailImpl();
					if ("1".equals(approveLevel)) {
						orderCategoryServiceDetail.setApproveStatus1(status);
						orderCategoryServiceDetail.setApproveDate1(new Date());
						orderCategoryServiceDetail.setApproverId1(getUserId());
						orderCategoryServiceTemp.setApproveCondition1(status);
						orderCategoryServiceTemp.setApproverId1(getUserId());
					}
					else if ("2".equals(approveLevel)) {
						orderCategoryServiceDetail.setApproveStatus2(status);
						orderCategoryServiceDetail.setApproveDate2(new Date());
						orderCategoryServiceDetail.setApproverId2(getUserId());
						orderCategoryServiceTemp.setApproveCondition2(status);
						orderCategoryServiceTemp.setApproverId2(getUserId());
					}
					else if ("3".equals(approveLevel)) {
						orderCategoryServiceDetail.setApproveStatus3(status);
						orderCategoryServiceDetail.setApproveDate3(new Date());
						orderCategoryServiceDetail.setApproverId3(getUserId());
						orderCategoryServiceTemp.setApproveCondition3(status);
						orderCategoryServiceTemp.setApproverId3(getUserId());
					}
					else if ("4".equals(approveLevel)) {
						orderCategoryServiceDetail.setApproveStatus4(status);
						orderCategoryServiceDetail.setApproveDate4(new Date());
						orderCategoryServiceDetail.setApproverId4(getUserId());
						orderCategoryServiceTemp.setApproveCondition4(status);
						//orderCategoryServiceTemp.setApproverId4(getUserId());
					}
					orderCategoryServiceDetail.setApproveStatus(approveStatus);
					// 忽略编号 
					orderCategoryServiceDetail.setTagUpdate("iId");
//					orderCategoryServiceDetailTemp.setId(id);
					orderCategoryServiceTemp.setId(orderCategoryServiceId);
					List<OrderCategoryServiceImpl> listOrderCategory = (List<OrderCategoryServiceImpl>) orderCategoryServiceConditionMapper.select(orderCategoryServiceTemp);
					if (null != listOrderCategory && 1 == listOrderCategory.size()) {
						OrderCategoryServiceImpl orderCategoryServiceInner = new OrderCategoryServiceImpl();
						orderCategoryServiceInner = listOrderCategory.get(0);
						listOrderCategoryService.add(orderCategoryServiceInner);
						List<OrderCategoryServiceDetailImpl> listCategoryServiceDetail = orderCategoryServiceInner.getListOrderCategoryServiceDetail();
						if (null != listCategoryServiceDetail && listCategoryServiceDetail.size() > 0) {
							for (int j = 0; j < listCategoryServiceDetail.size(); j++) {
								// 将所有审批人以人为单位分组
								OrderCategoryServiceDetailImpl orderCategoryServiceDetailInnerTemp = listCategoryServiceDetail.get(j);
								String approveNeed1 = orderCategoryServiceDetailInnerTemp.getApproveNeed1();
								String approveNeed2 = orderCategoryServiceDetailInnerTemp.getApproveNeed2();
								String approveNeed3 = orderCategoryServiceDetailInnerTemp.getApproveNeed3();
								String approveStatusOrigin1 = orderCategoryServiceDetailInnerTemp.getApproveStatus1();
								String approveStatusOrigin2 = orderCategoryServiceDetailInnerTemp.getApproveStatus2();
								String approveStatusOrigin3 = orderCategoryServiceDetailInnerTemp.getApproveStatus3();
								Long idOrderCategoryServiceDetail = orderCategoryServiceDetailInnerTemp.getIdOrderCategoryServiceDetail();
								OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = new OrderCategoryServiceDetailImpl();
								orderCategoryServiceDetailInner.setId(idOrderCategoryServiceDetail);
								if ("1".equals(approveLevel)) {
									orderCategoryServiceDetailInner.setApproveStatus1(status);
									orderCategoryServiceDetailInner.setApproveDate1(new Date());
									orderCategoryServiceDetailInner.setApproverId1(getUserId());
								}
								else if ("2".equals(approveLevel)) {
									orderCategoryServiceDetailInner.setApproveStatus2(status);
									orderCategoryServiceDetailInner.setApproveDate2(new Date());
									orderCategoryServiceDetailInner.setApproverId2(getUserId());
								}
								else if ("3".equals(approveLevel)) {
									orderCategoryServiceDetailInner.setApproveStatus3(status);
									orderCategoryServiceDetailInner.setApproveDate3(new Date());
									orderCategoryServiceDetailInner.setApproverId3(getUserId());
								}
								else if ("4".equals(approveLevel)) {
									orderCategoryServiceDetailInner.setApproveStatus4(status);
									orderCategoryServiceDetailInner.setApproveDate4(new Date());
									orderCategoryServiceDetailInner.setApproveNeed4("y");
									//orderCategoryServiceDetailInner.setApproverId4(getUserId());
									orderCategoryServiceDetailInner.setApproverName4(getUserName());
								}
								// 计算审批进程
								String approveStatus1 = orderCategoryServiceDetailInner.getApproveStatus1();
								String approveStatus2 = orderCategoryServiceDetailInner.getApproveStatus2();
								String approveStatus3 = orderCategoryServiceDetailInner.getApproveStatus3();
								Integer countApprove = 0;
								Integer countDetail = 0;
								if ("y".equals(approveNeed1)) {
									countDetail++;
									if ("ap".equals(approveStatus1) || "ap".equals(approveStatusOrigin1)) {
										countApprove++;
									}
								} 
								if ("y".equals(approveNeed2)) {
									countDetail++;
									if ("ap".equals(approveStatus2) || "ap".equals(approveStatusOrigin2)) {
										countApprove++;
									}
								} 
								if ("y".equals(approveNeed3)) {
									countDetail++;
									if ("ap".equals(approveStatus3) || "ap".equals(approveStatusOrigin3)) {
										countApprove++;
									}
								} 
								if (0 != countDetail) {
									int countApprovePercent = countApprove*100/countDetail;
									orderCategoryServiceDetailInner.setCountApprovePercent(countApprovePercent);
								}
								orderCategoryServiceDetailInner.setCountApprove(countApprove);
								orderCategoryServiceDetailInner.setCountDetail(countDetail);
								orderCategoryServiceDetailInner.setStatus(approveStatus);
								orderCategoryServiceDetailInner.setApproveStatus(approveStatus);
								orderCategoryServiceDetailMapper.update(orderCategoryServiceDetailInner);
							}
						}
					}
					OrderCategoryServiceImpl orderCategoryServiceTemp2 = new OrderCategoryServiceImpl();
					orderCategoryServiceTemp2.setApproveStatus(approveStatus);
					orderCategoryServiceTemp2.setId(orderCategoryServiceId);
					this.updateApprove(orderCategoryServiceTemp2);
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetailTemp2.setIdOrderCategoryService(orderCategoryServiceId);
					orderCategoryServiceDetailTemp2.setApproveStatus(approveStatus);
					if ("ap1".equals(approveStatus)) {
						orderCategoryServiceDetailTemp2.setApproveStatus1("ap");
						orderCategoryServiceDetailTemp2.setApproverId1(getUserId());
						orderCategoryServiceDetailTemp2.setApproveCondition1("ap");
					}
					else if ("ap2".equals(approveStatus)) {
						orderCategoryServiceDetailTemp2.setApproveStatus2("ap");
						orderCategoryServiceDetailTemp2.setApproverId2(getUserId());
						orderCategoryServiceDetailTemp2.setApproveCondition2("ap");
					}
					else if (approveStatus.startsWith("re")) {
						orderCategoryServiceDetailTemp2.setTagMapper("approveConditionReject");
					}
//					for (int j = 0; j < listOrderCategory.size(); j++) {
//						OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp = 
//					}
					//orderCategoryServiceDetailMapper.update(orderCategoryServiceDetail);
//					// 更新主表信息
//					// 取得主表记录数
//					OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
//					orderCategoryServiceDetailTemp2.setIdOrderCategoryService(orderCategoryServiceId);
//					orderCategoryServiceDetailTemp2.setCountApprovePercent(100);
//					List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetailDone = (List<OrderCategoryServiceDetailImpl>) orderCategoryServiceDetailMapper.select(orderCategoryServiceDetailTemp2);
//					orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
//					orderCategoryServiceDetailTemp2.setIdOrderCategoryService(orderCategoryServiceId);
//					List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetailAll = (List<OrderCategoryServiceDetailImpl>) orderCategoryServiceDetailMapper.select(orderCategoryServiceDetailTemp2);
//					int countDetail = listOrderCategoryServiceDetailAll.size();
//					int countApprove = listOrderCategoryServiceDetailDone.size();
//					int countApprovePercent = countApprove*100/countDetail;
//					
//					orderCategoryService.setCountDetail(countDetail);
//					orderCategoryService.setCountApprove(countApprove);
//					orderCategoryService.setCountApprovePercent(countApprovePercent);
//					orderCategoryServiceMapper.update(orderCategoryService);
					// 更新主表信息
					OrderCategoryServiceImpl orderCategoryServiceTemp3 = new OrderCategoryServiceImpl();
					orderCategoryServiceTemp3.setStatus(status);
					orderCategoryServiceTemp3.setId(orderCategoryServiceId);
					if("re".equals(status) && null != remarkApprove && remarkApprove.length() > 0){
						remarkApprove = "(" + getUserName() + ") " + remarkApprove;
						orderCategoryServiceTemp3.setRemarkApprove(remarkApprove);
					} 
					orderCategoryServiceMapper.update(orderCategoryServiceTemp3);
					try {
						if (!"ap3".equals(approveStatus)){
							emailService.sendMailOrderCategoryService(orderCategoryServiceDetailTemp2);
						}
					} catch (EmailException e) {
						e.printStackTrace();
					}
				}
			}
				/*else if ("re".equals(status)) {
					String[] arrayOrderCategoryService = arrayId.split(",");
					if (null != arrayOrderCategoryService && arrayOrderCategoryService.length >0) {
						String approveStatus = "re1";
						// 经理审批	1808200
						if ("1808200".equals(tagPageCode)) {
							approveStatus = "re1";
						}
						// 总监审批	1808300
						if ("1808300".equals(tagPageCode)) {
							approveStatus = "re2";
						}
						// 高管审批1808400
						if ("1808400".equals(tagPageCode)) {
							approveStatus = "re3";
						}
						for (int i = 0; i < arrayOrderCategoryService.length; i++) {
							String orderCategoryServiceIdString = arrayOrderCategoryService[i].split("-")[0];
							Long orderCategoryServiceId = Long.valueOf(orderCategoryServiceIdString);
							orderCategoryService = new OrderCategoryServiceImpl();
							orderCategoryService.setId(orderCategoryServiceId);
							orderCategoryService.setStatus(approveStatus);
							orderCategoryServiceMapper.update(orderCategoryService);
						}
					}*/
		}
		// 财务部确认
		else if ("af".equals(editState)) {
			String arrayId = orderCategoryService.getArrayId();
			String[] arrayOrderCategoryService = arrayId.split(",");
			if (null != arrayOrderCategoryService && arrayOrderCategoryService.length >0) {
				for (int i = 0; i < arrayOrderCategoryService.length; i++) {
					String orderCategoryServiceIdString = arrayOrderCategoryService[i].split("-")[0];
					Long idOrderCategoryService = Long.valueOf(orderCategoryServiceIdString);
					orderCategoryService = new OrderCategoryServiceImpl();
					orderCategoryService.setId(idOrderCategoryService);
					orderCategoryService.setApproveDate(new Date());
					orderCategoryService.setApproverName(CommonUtil.getUserName());
					orderCategoryService.setApproverId(CommonUtil.getUserId());
					orderCategoryService.setStatus("af");
					orderCategoryServiceMapper.update(orderCategoryService);
					
					OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetail.setIdOrderCategoryService(idOrderCategoryService);
					orderCategoryServiceDetail.setApproveDate4(new Date());
					orderCategoryServiceDetail.setApproverName4(CommonUtil.getUserName());
					orderCategoryServiceDetail.setApproverId4(CommonUtil.getUserId());
					orderCategoryServiceDetail.setApproveNeed4("y");
					orderCategoryServiceDetail.setApproveStatus4("ap");
					// 忽略编号 
					orderCategoryServiceDetail.setTagUpdate("iId");
					orderCategoryServiceDetailMapper.update(orderCategoryServiceDetail);
			
					
					
					
				}
			}
		} 
		// 修改审批人modify approver
		else if ("ma".equals(editState)) {
			String jsonListString = orderCategoryService.getJsonListString();
			if (jsonListString != null && jsonListString.length() > 1) {
				JSONArray jsonArray = JSONArray.fromObject(jsonListString);
				OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
				@SuppressWarnings("unchecked")
				List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail = (List<OrderCategoryServiceDetailImpl>) CommonUtil.JSON2List(jsonArray, new OrderCategoryServiceDetailImpl());
				Date atomDate = new Date();
				Long atomId = atomDate.getTime();
				String logDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(atomDate);
				int modifyOrder = 0;
				for (int i = 0; i < listOrderCategoryServiceDetail.size(); i++) {
					orderCategoryServiceDetail = listOrderCategoryServiceDetail.get(i);
					Long idDetail= orderCategoryServiceDetail.getIdOrderCategoryServiceDetail();
					String approverId1 = orderCategoryServiceDetail.getApproverId1();
					String approverId2 = orderCategoryServiceDetail.getApproverId2();
					String approverId3 = orderCategoryServiceDetail.getApproverId3();
					String approveStatus1 = orderCategoryServiceDetail.getApproveStatus1();
					String approveStatus2 = orderCategoryServiceDetail.getApproveStatus2();
					String approveStatus3 = orderCategoryServiceDetail.getApproveStatus3();
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetailInner.setId(idDetail);
					if (!"ap".equals(approveStatus1)){
						if (null != approverId1 && approverId1.length() == 36) {
							UserDetailImpl user = new UserDetailImpl();
							user.setUserId(approverId1);
							user = (UserDetailImpl) userDetailMapper.get(user);
							if (null != user) {
								String email = user.getEmail();
								String displayName = user.getDisplayName();
								orderCategoryServiceDetailInner.setApproverId1(approverId1);
								orderCategoryServiceDetailInner.setApproverEmail1(email);
								orderCategoryServiceDetailInner.setApproverName1(displayName);
								orderCategoryServiceDetailInner.setApproveNeed1("y");
								orderCategoryServiceDetailInner.setApproveStatus1("na");
							}
						}
					}
					if (!"ap".equals(approveStatus2)){
						if (null != approverId2 && approverId2.length() == 36) {
							UserDetailImpl user = new UserDetailImpl();
							user.setUserId(approverId2);
							user = (UserDetailImpl) userDetailMapper.get(user);
							if (null != user) {
								String email = user.getEmail();
								String displayName = user.getDisplayName();
								orderCategoryServiceDetailInner.setApproverId2(approverId2);
								orderCategoryServiceDetailInner.setApproverEmail2(email);
								orderCategoryServiceDetailInner.setApproverName2(displayName);
								orderCategoryServiceDetailInner.setApproveNeed2("y");
								orderCategoryServiceDetailInner.setApproveStatus2("na");
							}
						} else {
							orderCategoryServiceDetailInner.setApproverId2("");
							orderCategoryServiceDetailInner.setApproverEmail2("");
							orderCategoryServiceDetailInner.setApproverName2("");
							orderCategoryServiceDetailInner.setApproveNeed2("");
							orderCategoryServiceDetailInner.setApproveStatus2("");
						}
					}
					
					if (!"ap".equals(approveStatus3)){
						if (null != approverId3 && approverId3.length() == 36) {
							UserDetailImpl user = new UserDetailImpl();
							user.setUserId(approverId3);
							user = (UserDetailImpl) userDetailMapper.get(user);
							if (null != user) {
								String email = user.getEmail();
								String displayName = user.getDisplayName();
								orderCategoryServiceDetailInner.setApproverId3(approverId3);
								orderCategoryServiceDetailInner.setApproverEmail3(email);
								orderCategoryServiceDetailInner.setApproverName3(displayName);
								orderCategoryServiceDetailInner.setApproveNeed3("y");
								orderCategoryServiceDetailInner.setApproveStatus3("na");
							}
						} else {
							orderCategoryServiceDetailInner.setApproverId3("");
							orderCategoryServiceDetailInner.setApproverEmail3("");
							orderCategoryServiceDetailInner.setApproverName3("");
							orderCategoryServiceDetailInner.setApproveNeed3("");
							orderCategoryServiceDetailInner.setApproveStatus3("");
						}
					}
					orderCategoryServiceDetailInner.setTagUpdate("egnoreArrpoveId");
					// 取得原记录
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailOrigin = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetailOrigin.setId(idDetail);
					orderCategoryServiceDetailOrigin = (OrderCategoryServiceDetailImpl) orderCategoryServiceDetailMapper.get(orderCategoryServiceDetailOrigin);
					String approverId1Origin = orderCategoryServiceDetailOrigin.getApproverId1();
					String approverId2Origin = orderCategoryServiceDetailOrigin.getApproverId2();
					String approverId3Origin = orderCategoryServiceDetailOrigin.getApproverId3();
					String approverName1Origin = orderCategoryServiceDetailOrigin.getApproverName1();
					String approverName2Origin = orderCategoryServiceDetailOrigin.getApproverName2();
					String approverName3Origin = orderCategoryServiceDetailOrigin.getApproverName3();
					
					String approverId1Modify = orderCategoryServiceDetail.getApproverId1();
					String approverId2Modify = orderCategoryServiceDetail.getApproverId2();
					String approverId3Modify = orderCategoryServiceDetail.getApproverId3();
					String approverName1Modify = orderCategoryServiceDetail.getApproverName1();
					String approverName2Modify = orderCategoryServiceDetail.getApproverName2();
					String approverName3Modify = orderCategoryServiceDetail.getApproverName3();
					
					// 更新一级审批人日志
					orderCategoryServiceDetailOrigin.setAtomId(atomId);
					orderCategoryServiceDetailOrigin.setLogDate(logDate);
					if (!"ap".equals(approveStatus1)){
						modifyOrder++;
						orderCategoryServiceDetailOrigin.setModifyOrder(modifyOrder);
						orderCategoryServiceDetailOrigin.setColumnName("一级审批人");
						orderCategoryServiceDetailOrigin.setApproverIdOrigin(approverId1Origin);
						orderCategoryServiceDetailOrigin.setApproverIdModify(approverId1Modify);
						orderCategoryServiceDetailOrigin.setApproverNameOrigin(approverName1Origin);
						orderCategoryServiceDetailOrigin.setApproverNameModify(approverName1Modify);
						this.insertSysHistory(orderCategoryServiceDetailOrigin);
					}
					
					// 更新二级审批人日志
					if (!"ap".equals(approveStatus2)){
						modifyOrder++;
						orderCategoryServiceDetailOrigin.setModifyOrder(modifyOrder);
						orderCategoryServiceDetailOrigin.setColumnName("二级审批人");
						orderCategoryServiceDetailOrigin.setApproverIdOrigin(approverId2Origin);
						orderCategoryServiceDetailOrigin.setApproverIdModify(approverId2Modify);
						orderCategoryServiceDetailOrigin.setApproverNameOrigin(approverName2Origin);
						orderCategoryServiceDetailOrigin.setApproverNameModify(approverName2Modify);
						this.insertSysHistory(orderCategoryServiceDetailOrigin);
					}
					
					// 更新三级审批人日志
					if (!"ap".equals(approveStatus3)){
						modifyOrder++;
						orderCategoryServiceDetailOrigin.setModifyOrder(modifyOrder);
						orderCategoryServiceDetailOrigin.setColumnName("三级审批人");
						orderCategoryServiceDetailOrigin.setApproverIdOrigin(approverId3Origin);
						orderCategoryServiceDetailOrigin.setApproverIdModify(approverId3Modify);
						orderCategoryServiceDetailOrigin.setApproverNameOrigin(approverName3Origin);
						orderCategoryServiceDetailOrigin.setApproverNameModify(approverName3Modify);
						this.insertSysHistory(orderCategoryServiceDetailOrigin);
					}
					
					// 更新审批人
					orderCategoryServiceDetailInner.setEditState("u");
					CommonUtil.setCommonField(orderCategoryServiceDetailInner);
					orderCategoryServiceDetailMapper.update(orderCategoryServiceDetailInner);
				}
			}
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param orderCategoryService
	 */
	@SuppressWarnings("unchecked")
	public List<OrderCategoryServiceImpl> select(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		return (List<OrderCategoryServiceImpl>) this.orderCategoryServiceConditionMapper.select(orderCategoryService);
	}
	/**
	 * 查询单个实体
	 * @param orderCategoryService
	 */
	public OrderCategoryServiceImpl get(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		return (OrderCategoryServiceImpl) this.orderCategoryServiceMapper.get(orderCategoryService);
	}
	/**
	 * 查询实体分页列表
	 * @param orderCategoryService
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OrderCategoryServiceImpl> search(OrderCategoryServiceImpl orderCategoryService) throws PmException {
		DataGrid<OrderCategoryServiceImpl> grid = new DataGrid<OrderCategoryServiceImpl>();
		Object obj = orderCategoryService;
		orderCategoryService.setGroup("a.id");
		List list = orderCategoryServiceConditionMapper.select(obj);
		grid.setRows(list);
		int count = 0;
		count = orderCategoryServiceConditionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	private void inserDetail(OrderCategoryServiceImpl orderCategoryService) {
		Double totalAmount = 0.00;
		Long idOrderCategoryService = orderCategoryService.getId();
		OrderCategoryServiceDetailImpl orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
		orderCategoryServiceDetail.setIdOrderCategoryService(idOrderCategoryService);
		String status = orderCategoryService.getStatus();
		String currencyCode = orderCategoryService.getCurrencyCode();
		Long currencyId = 1L;
		Double exchangeRate = 1.00;
		UserInforImpl userInfor = new UserInforImpl();
		userInfor.setCode(currencyCode);
		try {
			userInfor = (UserInforImpl) userInforService.get(userInfor);
			String codeDetail = userInfor.getCodeDetail();
			if (null != codeDetail) {
				currencyId = Long.valueOf(codeDetail);
				try {
					CurrencyImpl currency = new CurrencyImpl();
					currency.setId(currencyId);
					currency = (CurrencyImpl) currencyService.get(currency);
					exchangeRate = currency.getRatio();
				} catch (PmException e1) {
					e1.printStackTrace();
				}
			}
		} catch (PmException e2) {
			e2.printStackTrace();
		}
		// 取得json列表对象
		String jsonListString = orderCategoryService.getJsonListString();
		if (jsonListString != null && jsonListString.length() > 1) {
			// 删除所有子表信息
			orderCategoryServiceDetailMapper.delete(orderCategoryServiceDetail);
			JSONArray jsonArray = JSONArray.fromObject(jsonListString);
			orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
			@SuppressWarnings("unchecked")
			List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail = (List<OrderCategoryServiceDetailImpl>) CommonUtil.JSON2List(jsonArray, new OrderCategoryServiceDetailImpl());
			for (int i = 0; i < listOrderCategoryServiceDetail.size(); i++) {
				orderCategoryServiceDetail = listOrderCategoryServiceDetail.get(i);
				orderCategoryServiceDetail.setIdOrderCategoryService(idOrderCategoryService);
				CommonUtil.setCommonField(orderCategoryServiceDetail);
				if (null == orderCategoryServiceDetail.getIdCategoryLeve1()) {
					break;
				}
				Double amount = orderCategoryServiceDetail.getAmount();
				Double amountRmb = amount * exchangeRate;
				totalAmount += amount;
				
				// 取得客户的一二级id级名称,并赋值
				String customerId = orderCategoryServiceDetail.getCustomerId();
				// 如果客户为空,那么不取客户
				if ("NULL".equals(customerId) || "0".equals(customerId)) {
					orderCategoryServiceDetail.setCustomerId1("0");
					orderCategoryServiceDetail.setCustomerName1("- -");
				} else {
					String customerName = orderCategoryServiceDetail.getCustomerName();
					DivisionImpl customer = new DivisionImpl();
					customer.setTag("c");
					customer.setId(customerId);
					customer = (DivisionImpl) divisionMapper.get(customer);
					String pid = customer.getPid();
					if (null != pid && !"".equals(pid)) {
						customer = new DivisionImpl();
						customer.setTag("c");
						customer.setId(pid);
						customer = (DivisionImpl) divisionMapper.get(customer);
						String customerId1 = customer.getId();
						String customerName1 = customer.getName();
						
						orderCategoryServiceDetail.setCustomerId1(customerId1);
						orderCategoryServiceDetail.setCustomerName1(customerName1);
						orderCategoryServiceDetail.setCustomerId2(customerId);
						orderCategoryServiceDetail.setCustomerName2(customerName);
					} else {
						orderCategoryServiceDetail.setCustomerId1(customerId);
						orderCategoryServiceDetail.setCustomerName1(customerName);
						orderCategoryServiceDetail.setCustomerId2(null);
						orderCategoryServiceDetail.setCustomerName2(null);
						
					}
				}
				// 取得一,二,三级审批人
				String divisionId = orderCategoryService.getApplicantDivisionId();
				// 根据部门和科目编号取得审批人
				String code = orderCategoryServiceDetail.getIdCategoryLevel2();
				//String parentCode = orderCategoryServiceDetail.getIdCategoryLevel2();
				RolePermissionImpl rolePermission = new RolePermissionImpl();
				// 角色类型(s:系统,d:部门,u:用户)
				rolePermission.setType("d");
				rolePermission.setCode(code);
				rolePermission.setTypeIdRole(divisionId);
				rolePermission.setParentCode("2002000");
				RolePermissionImpl rolePermissionTemp = new RolePermissionImpl();
				int countDetail = 0;
				try {
					rolePermissionTemp = (RolePermissionImpl) rolePermissionService.get(rolePermission);
					if (null != rolePermissionTemp) {
						
						String approver1 = rolePermissionTemp.getApprover1();
						String approver2 = rolePermissionTemp.getApprover2();
						String approver3 = rolePermissionTemp.getApprover3();
						// 取得高管对应的额度 1701002
						/*RolePermissionImpl rolePermissionTemp4 = new RolePermissionImpl();
						rolePermissionTemp4.setCode("1701002");
						rolePermissionTemp4 = (RolePermissionImpl) rolePermissionMapper.get(rolePermissionTemp4);
						String roleId = rolePermissionTemp4.getRoleId();*/
						Double categoryAmount = orderCategoryServiceDetail.getAmount();
						if (null != approver1 && !"".equals(approver1)) {
							// 负责人 1701005, 总监 	1701004, 高管 1701002
							if ("1701005".equals(approver1)) {
								// 根据部门编号取得本部门负责人
								UserDivision userDivision = new UserDivision();
								userDivision.setDivisionId(divisionId);
								// 负责人 	gwmc2
								userDivision.setPositionId("gwmc2");
								userDivision.setTagMapper("status0");
								List<UserDivisionImpl> listUserDivision = (List<UserDivisionImpl>) userDivisionMapper.select(userDivision);
								if (null != listUserDivision && listUserDivision.size() == 1) {
									userDivision = listUserDivision.get(0);
									String userId = userDivision.getUserId();
									orderCategoryServiceDetail.setApproverId1(userId);
									User user = new User();
									user.setId(userId);
									user = (User) userMapper.get(user);
									String userNameManager = user.getDisplayName();
									String email = user.getEmail();
									orderCategoryServiceDetail.setApproverEmail1(email);
									if (null != userNameManager){
										orderCategoryServiceDetail.setApproverName1(userNameManager);
									}
									orderCategoryServiceDetail.setApproveNeed1("y");
									orderCategoryServiceDetail.setApproveStatus1("na");
									countDetail++;
								}
							}
							else {
								orderCategoryServiceDetail.setApproverId1(approver1);
								User user = new User();
								user.setId(approver1);
								user = (User) userMapper.get(user);
								String userNameManager = user.getDisplayName();
								String email = user.getEmail();
								orderCategoryServiceDetail.setApproverEmail1(email);
								if (null != userNameManager){
									orderCategoryServiceDetail.setApproverName1(userNameManager);
								}
								orderCategoryServiceDetail.setApproveNeed1("y");
								orderCategoryServiceDetail.setApproveStatus1("na");
								countDetail++;
							}
						}
						if (null != approver2 && !"".equals(approver2)) {
							// 负责人 1701005, 总监 	1701004, 高管 1701002
							customerId = orderCategoryServiceDetail.getCustomerId1();
							if ("1701004".equals(approver2)) {
								// 如果需要总监审批,根据客户取得对应的总监
								if (null != customerId && !"0".equals(customerId)) {
									RolePermissionImpl rolePermissionTemp2 = new RolePermissionImpl();
									// 总监客户权限 1404000
									rolePermissionTemp2.setParentCode("1404000");
									rolePermissionTemp2.setValue1(customerId);
									rolePermissionTemp2 = (RolePermissionImpl) rolePermissionMapper.get(rolePermissionTemp2);
									if (null != rolePermissionTemp2) {
										RolePermissionImpl rolePermissionTemp3 = rolePermissionTemp2;
										String userIdSupervisor = rolePermissionTemp3.getUserId();
										User user = new User();
										user.setId(userIdSupervisor);
										user = (User) userMapper.get(user);
										String userNameSupervisor = user.getDisplayName();
										String email = user.getEmail();
										orderCategoryServiceDetail.setApproverEmail2(email);
										if (null != userNameSupervisor){
											orderCategoryServiceDetail.setApproverName2(userNameSupervisor);
										}
										orderCategoryServiceDetail.setApproverId2(userIdSupervisor);
										orderCategoryServiceDetail.setApproveNeed2("y");
										orderCategoryServiceDetail.setApproveStatus2("na");
										countDetail++;
									}
								}
								else {
									orderCategoryServiceDetail.setApproverId2("");
									orderCategoryServiceDetail.setApproveNeed2("");
									orderCategoryServiceDetail.setApproveStatus2("");
									orderCategoryServiceDetail.setApproverName2("");
								}
								// 如果部门为空的情况下,加上三级审批人为刘总
								/*else{
									// 取得报销三级审批人(唯一)	1701009
									UserDetailImpl user = new UserDetailImpl();
									user.setCode("1701009");
									user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
									String idManager = user.getUserId();
									String nameManager = user.getDisplayName();
									String emailManager = user.getEmail();
									orderCategoryServiceDetail.setApproverId3(idManager);
									orderCategoryServiceDetail.setApproveNeed3("y");
									orderCategoryServiceDetail.setApproveStatus3("na");
									orderCategoryServiceDetail.setApproverName3(nameManager);
									orderCategoryServiceDetail.setApproverEmail3(emailManager);
								}*/
							}
							else if (null != customerId && !"0".equals(customerId)) {
								orderCategoryServiceDetail.setApproverId2(approver2);
								User user = new User();
								user.setId(approver2);
								user = (User) userMapper.get(user);
								String userNameSupervisor = user.getDisplayName();
								String email = user.getEmail();
								orderCategoryServiceDetail.setApproverEmail2(email);
								if (null != userNameSupervisor){
									orderCategoryServiceDetail.setApproverName2(userNameSupervisor);
								}
								orderCategoryServiceDetail.setApproveNeed2("y");
								orderCategoryServiceDetail.setApproveStatus2("na");
								countDetail++;
							}
							else {
								orderCategoryServiceDetail.setApproverId2("");
								orderCategoryServiceDetail.setApproveNeed2("");
								orderCategoryServiceDetail.setApproveStatus2("");
								orderCategoryServiceDetail.setApproverName2("");
							}
						}
						else {
							orderCategoryServiceDetail.setApproverId2("");
							orderCategoryServiceDetail.setApproveNeed2("");
							orderCategoryServiceDetail.setApproveStatus2("");
							orderCategoryServiceDetail.setApproverName2("");
						}
						RolePermissionImpl rolePermissionTemp5 = new RolePermissionImpl();
						// 角色类型(s:系统,d:部门,u:用户)
						rolePermissionTemp5.setType("u");
						rolePermissionTemp5.setCode(code);
						// 取得报销三级审批人(唯一)	1701009
						UserDetailImpl user = new UserDetailImpl();
						user.setCode("1701009");
						user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
						
						// 高管角色编号
						rolePermissionTemp5.setRoleId("2184f16a-a915-4e34-a41d-270a7743515f");
						rolePermissionTemp5.setParentCode("2002000");
						rolePermissionTemp5 = (RolePermissionImpl) rolePermissionMapper.get(rolePermissionTemp5);
						String approveNeed2Temp = orderCategoryServiceDetail.getApproveNeed2();
						if ((null != user && null != rolePermissionTemp5) || 
								// 如果需要总监审批,但客户为空并且没有查询到二级审批人的情况下,那么找刘总
								(null != approver2 && !"".equals(approver2) && "0".equals(customerId)) && !"y".equals(approveNeed2Temp)) {
							Double approver1AmonutLower = null;
							if(rolePermissionTemp5 != null){
								approver1AmonutLower = rolePermissionTemp5.getApprover1AmonutLower();
							}
							String idManager = user.getUserId();
							String nameManager = user.getDisplayName();
							String emailManager = user.getEmail();
							// 查看是否需要审批金额限定
							if (null != approver1AmonutLower && approver1AmonutLower > 0) {
								if (null != approver1AmonutLower && amountRmb >= approver1AmonutLower) {
									orderCategoryServiceDetail.setApproverId3(idManager);
									orderCategoryServiceDetail.setApproveNeed3("y");
									orderCategoryServiceDetail.setApproveStatus3("na");
									orderCategoryServiceDetail.setApproverName3(nameManager);
									orderCategoryServiceDetail.setApproverEmail3(emailManager);
								}
								else {
									orderCategoryServiceDetail.setApproverId3("");
									orderCategoryServiceDetail.setApproveNeed3("");
									orderCategoryServiceDetail.setApproveStatus3("");
									orderCategoryServiceDetail.setApproverName3("");
								}
							}
							else if (null == approver1AmonutLower) {
								orderCategoryServiceDetail.setApproverId3(idManager);
								orderCategoryServiceDetail.setApproveNeed3("y");
								orderCategoryServiceDetail.setApproveStatus3("na");
								orderCategoryServiceDetail.setApproverName3(nameManager);
								orderCategoryServiceDetail.setApproverEmail3(emailManager);
								countDetail++;
							}
						}
						else {
							orderCategoryServiceDetail.setApproverId3("");
							orderCategoryServiceDetail.setApproveNeed3("");
							orderCategoryServiceDetail.setApproveStatus3("");
							orderCategoryServiceDetail.setApproverName3("");
						}
					}
					else {
						// 返回无此权限
					}
				} catch (PmException e) {
					e.printStackTrace();
				}
				orderCategoryServiceDetail.setCountDetail(countDetail);
				orderCategoryServiceDetail.setStatus(status);
				orderCategoryServiceDetail.setAmountRmb(amountRmb);
				orderCategoryServiceDetail.setExchangeRate(exchangeRate.toString());
				orderCategoryServiceDetail.setId(null);
				orderCategoryServiceDetail.setApproveNeed4("n");
				orderCategoryServiceDetail.setApproverId4("");
				orderCategoryServiceDetail.setApproverName4("");
				orderCategoryServiceDetailMapper.insert(orderCategoryServiceDetail);
			}
		} 
		else if ("s".equals(status)) {
			orderCategoryServiceDetail = new OrderCategoryServiceDetailImpl();
			orderCategoryServiceDetail.setIdOrderCategoryService(idOrderCategoryService);
			orderCategoryServiceDetail.setStatus(status);
			// ingal ID
			orderCategoryServiceDetail.setTagUpdate("iId");
			orderCategoryServiceDetailMapper.update(orderCategoryServiceDetail);
		}
		orderCategoryService.setTotalAmount(totalAmount);
		Double totalAmountRmb = totalAmount * exchangeRate;
		orderCategoryService.setTotalAmountRmb(totalAmountRmb);
		orderCategoryService.setExchangeRate(exchangeRate.toString());
	}

	/**
	 * 查询实体分页列表
	 * @param orderCategoryService
	 * @return
	 * @throws PmException
	 */
	@Override
	public DataGrid<OrderCategoryServiceImpl> searchJson(
			OrderCategoryServiceImpl orderCategoryService) throws PmException {
		DataGrid<OrderCategoryServiceImpl> grid = new DataGrid<OrderCategoryServiceImpl>();
		Object obj = orderCategoryService;
		List list = orderCategoryServiceConditionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = orderCategoryServiceConditionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	private void updateApprove(OrderCategoryServiceImpl orderCategoryService) {
		Long orderCategoryServiceId = orderCategoryService.getId();
		String approveStatus = orderCategoryService.getApproveStatus();
		List<OrderCategoryServiceImpl> listOrderCategory = (List<OrderCategoryServiceImpl>) orderCategoryServiceConditionMapper.select(orderCategoryService);
		if (null != listOrderCategory && 1 == listOrderCategory.size()) {
			OrderCategoryServiceImpl orderCategoryServiceInner = listOrderCategory.get(0);
			List<OrderCategoryServiceDetailImpl> listCategoryServiceDetail = orderCategoryServiceInner.getListOrderCategoryServiceDetail();
			if (null != listCategoryServiceDetail && listCategoryServiceDetail.size() > 0) {
				for (int j = 0; j < listCategoryServiceDetail.size(); j++) {
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailInnerTemp = listCategoryServiceDetail.get(j);
					String approveNeed1 = orderCategoryServiceDetailInnerTemp.getApproveNeed1();
					String approveNeed2 = orderCategoryServiceDetailInnerTemp.getApproveNeed2();
					String approveNeed3 = orderCategoryServiceDetailInnerTemp.getApproveNeed3();
					String approveStatusOrigin1 = orderCategoryServiceDetailInnerTemp.getApproveStatus1();
					String approveStatusOrigin2 = orderCategoryServiceDetailInnerTemp.getApproveStatus2();
					String approveStatusOrigin3 = orderCategoryServiceDetailInnerTemp.getApproveStatus3();
					Long idOrderCategoryServiceDetail = orderCategoryServiceDetailInnerTemp.getIdOrderCategoryServiceDetail();
					OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = new OrderCategoryServiceDetailImpl();
					orderCategoryServiceDetailInner.setId(idOrderCategoryServiceDetail);
					if ("ap1".equals(approveStatus)) {
						orderCategoryServiceDetailInner.setApproveStatus1("ap");
						orderCategoryServiceDetailInner.setApproveDate1(new Date());
						orderCategoryServiceDetailInner.setApproverId1(getUserId());
						
					}
					else if ("ap2".equals(approveStatus)) {
						orderCategoryServiceDetailInner.setApproveStatus2("ap");
						orderCategoryServiceDetailInner.setApproveDate2(new Date());
						orderCategoryServiceDetailInner.setApproverId2(getUserId());
					}
					else if ("ap3".equals(approveStatus)) {
						orderCategoryServiceDetailInner.setApproveStatus3("ap");
						orderCategoryServiceDetailInner.setApproveDate3(new Date());
						orderCategoryServiceDetailInner.setApproverId3(getUserId());
					}
					// 计算审批进程
					String approveStatus1 = orderCategoryServiceDetailInner.getApproveStatus1();
					String approveStatus2 = orderCategoryServiceDetailInner.getApproveStatus2();
					String approveStatus3 = orderCategoryServiceDetailInner.getApproveStatus3();
					Integer countApprove = 0;
					Integer countDetail = 0;
					if ("y".equals(approveNeed1)) {
						countDetail++;
						if ("ap".equals(approveStatus1) || "ap".equals(approveStatusOrigin1)) {
							countApprove++;
						}
					} 
					if ("y".equals(approveNeed2)) {
						countDetail++;
						if ("ap".equals(approveStatus2) || "ap".equals(approveStatusOrigin2)) {
							countApprove++;
						}
					} 
					if ("y".equals(approveNeed3)) {
						countDetail++;
						if ("ap".equals(approveStatus3) || "ap".equals(approveStatusOrigin3)) {
							countApprove++;
						}
					} 
					if (0 != countDetail) {
						int countApprovePercent = countApprove*100/countDetail;
						orderCategoryServiceDetailInner.setCountApprovePercent(countApprovePercent);
					}
					orderCategoryServiceDetailInner.setCountApprove(countApprove);
					orderCategoryServiceDetailInner.setCountDetail(countDetail);
					orderCategoryServiceDetailMapper.update(orderCategoryServiceDetailInner);
				}
			}
		}
		// 更新主表信息
		// 取得主表记录数
		OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
		orderCategoryServiceDetailTemp2.setIdOrderCategoryService(orderCategoryServiceId);
		orderCategoryServiceDetailTemp2.setCountApprovePercent(100);
		List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetailDone = (List<OrderCategoryServiceDetailImpl>) orderCategoryServiceDetailMapper.select(orderCategoryServiceDetailTemp2);
		orderCategoryServiceDetailTemp2 = new OrderCategoryServiceDetailImpl();
		orderCategoryServiceDetailTemp2.setIdOrderCategoryService(orderCategoryServiceId);
		List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetailAll = (List<OrderCategoryServiceDetailImpl>) orderCategoryServiceDetailMapper.select(orderCategoryServiceDetailTemp2);
		Integer countDetail = listOrderCategoryServiceDetailAll.size();
		Integer countApprove = listOrderCategoryServiceDetailDone.size();
		Integer countApprovePercent = countApprove*100/countDetail;
		
		orderCategoryService.setCountDetail(countDetail);
		orderCategoryService.setCountApprove(countApprove);
		orderCategoryService.setCountApprovePercent(countApprovePercent);
		// 状态标识(e:enable 有效, d:disable 无效,d:drift 草稿,s:submit 提交,c:complete 完成,a:approving 审批中)
		String status = orderCategoryService.getStatus();
		if (approveStatus.startsWith("ap") || (countApprovePercent > 0 && countApprovePercent < 100)) {
			status = "a";
		}
		if (100 == countApprovePercent) {
			status = "c";
		}
		orderCategoryService.setStatus(status);
		orderCategoryServiceMapper.update(orderCategoryService);
	}
	
	/**
	 * 收款人自动缓存
	 * @param orderCategoryService
	 */
	private void payNameHandler(OrderCategoryServiceImpl orderCategoryService) {
		String payeeName = orderCategoryService.getPayeeName();
		if(null != payeeName && payeeName.length() > 0){
			String userId = getUserId();
			String userName = getUserName();
			SysTempImpl sysTemp = new SysTempImpl();
			sysTemp.setUserId(userId); 	
			payeeName.trim();
			payeeName.replace(" ", "");
			sysTemp.setContent(payeeName);
			sysTemp.setType("ocsrp");
			SysTempImpl sysTemp2 = (SysTempImpl) sysTempMapper.get(sysTemp);
			if(null == sysTemp2){
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("i");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.insert(sysTemp);
			} else {
				Long idSysTemp = sysTemp2.getId();
				sysTemp.setId(idSysTemp);
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("u");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.update(sysTemp);
			}
		}
	}
	
	
	/**
	 * 收款人自动缓存
	 * @param orderCategoryService
	 */
	private void payNameHandler2(OrderCategoryServiceImpl orderCategoryService) {
		String payeeName = orderCategoryService.getPayeeName();
		if(null != payeeName && payeeName.length() > 0){
			String userId = getUserId();
			String userName = getUserName();
			String userIdInner = orderCategoryService.getPayeeId();
			SysTempImpl sysTemp = new SysTempImpl();
			sysTemp.setUserId(userId); 	
			sysTemp.setContent(payeeName);
			sysTemp.setType("ocsrp");
			SysTempImpl sysTemp2 = (SysTempImpl) sysTempMapper.get(sysTemp);
			if(null == sysTemp2){
				sysTemp.setUserName(userName);
				sysTemp.setText1(payeeName);
				sysTemp.setText7(userIdInner);
				sysTemp.setTagUpdate("i");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.insert(sysTemp);
			} else {
				sysTemp.setText1(payeeName);
				sysTemp.setText7(userIdInner);
				Long idSysTemp = sysTemp2.getId();
				sysTemp.setId(idSysTemp);
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("u");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.update(sysTemp);
			}
			// 更新用户信息
			UserDetailImpl userDetail = new UserDetailImpl();
			userDetail.setUserId(userIdInner);
			userDetail.setEditState("u");
			CommonUtil.setCommonField(userDetail);
			userDetailMapper.update(userDetail);
		}
	}
	
	private void updateBankInfo(OrderCategoryServiceImpl orderCategoryService) {
		String payeeId = orderCategoryService.getPayeeId();
		// 取得银行卡号和开户银行并更新
		if (null != payeeId && payeeId.length() == 36) {
			UserDetailImpl userDetailInner = new UserDetailImpl();
			userDetailInner.setUserId(payeeId);
			userDetailInner = (UserDetailImpl) userDetailMapper.get(userDetailInner);
			if (null != userDetailInner) {
				String bankName = userDetailInner.getBankName();
				String bankCard = userDetailInner.getBankCard();
				if ((null == bankName || "".equals(bankName)) && null != bankCard) {
					bankName = "浦发银行";
				}
				orderCategoryService.setBankCard(bankCard);
				orderCategoryService.setBankName(bankName);
			}
		}
	}
	
	private void insertSysHistory(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) {
		
		Long columnId = orderCategoryServiceDetail.getId();
		Long columnIdMain = orderCategoryServiceDetail.getIdOrderCategoryService();
		Integer modifyOrder = orderCategoryServiceDetail.getModifyOrder();
		Long atomId = orderCategoryServiceDetail.getAtomId();
		String logDate = orderCategoryServiceDetail.getLogDate();
		String columnName = orderCategoryServiceDetail.getColumnName();
		String approverIdOrigin = orderCategoryServiceDetail.getApproverIdOrigin();
		String approverNameOrigin = orderCategoryServiceDetail.getApproverNameOrigin();
		String approverIdModify = orderCategoryServiceDetail.getApproverIdModify();
		String approverNameModify = orderCategoryServiceDetail.getApproverNameModify();
		
		// 如果一级审批人不同,添加日志
		
		if (!approverIdOrigin.equals(approverIdModify)) {
			SysHistoryImpl sysHistory = new SysHistoryImpl();
			sysHistory.setPreId(approverIdOrigin);
			sysHistory.setAftId(approverIdModify);
			if(null == approverNameOrigin || "".equals(approverNameOrigin) || "- -".equals(approverNameOrigin)){
				approverNameOrigin = "空";
			}
			if(null == approverNameModify || "".equals(approverNameModify) || "- -".equals(approverNameModify)){
				approverNameModify = "空";
			}
			sysHistory.setPreText(approverNameOrigin);
			sysHistory.setAftText(approverNameModify);
			sysHistory.setTableName("orderCategoryServiceDetail");
			sysHistory.setColumnId(columnId);
			sysHistory.setColumnIdMain(columnIdMain);
			// 修正报销审批人ModifyOrderCategoryServiceApprover:mosa
			sysHistory.setType("mosa");
			sysHistory.setUserId(getUserId());
			sysHistory.setUserName(getUserName());
			sysHistory.setDisplayName(getUserName());
			sysHistory.setLoginName(getSessionInfo().getUser().getLoginName());
			sysHistory.setLog(approverNameOrigin + " -> " + approverNameModify);
			sysHistory.setModifyOrder(modifyOrder);
			sysHistory.setColumnName(columnName);
			sysHistory.setLogDate(logDate);
			// 添加原子批量标识
			if (null != atomId) {
				sysHistory.setAtomId(atomId);
			}
			sysHistory.setEditState("i");
			CommonUtil.setCommonField(sysHistory);
			sysHistoryMapper.insert(sysHistory);
		}
	}
}