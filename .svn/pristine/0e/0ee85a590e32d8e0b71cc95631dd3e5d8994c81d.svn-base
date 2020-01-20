package com.mtf.framework.controller.order;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.OrderCategoryServiceConditionMapper;
import com.mtf.framework.dao.RolePermissionConditionMapper;
import com.mtf.framework.dao.SysTempConditionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.OrderCategoryImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.RolePermissionImpl;
import com.mtf.framework.model.impl.SysTempImpl;
import com.mtf.framework.service.DivisionRoleService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.OrderCategoryService;
import com.mtf.framework.service.OrderCategoryServiceService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.SysTempService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.JacksonUtils;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 申请报销
 * 作者:    Auto
 * 日期:    2016/6/20
**********************************************
*/
@Controller("orderCategoryServiceController")
@RequestMapping("/order/orderCategoryService")
public class OrderCategoryServiceController extends BaseController{

	@Autowired
	private OrderCategoryServiceService orderCategoryServiceService;
	
	@Autowired
	private OrderCategoryService orderCategoryService;
	
	@Autowired
	private OrderCategoryServiceConditionMapper orderCategoryServiceConditionMapper;
	
	@Autowired
	private IDivisionService iDivisionService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private RolePermissionConditionMapper rolePermissionConditionMapper;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private DivisionRoleService divisionRoleService;
	
	@Autowired
	private SysTempService sysTempService;
	
	@Autowired
	private SysTempConditionMapper sysTempConditionMapper;
	
	@Autowired
	private DivisionConditionMapper divisionConditionMapper;
	
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
	public DivisionConditionMapper getDivisionConditionMapper() {
		return divisionConditionMapper;
	}

	@Autowired
	public void setDivisionConditionMapper(
			DivisionConditionMapper divisionConditionMapper) {
		this.divisionConditionMapper = divisionConditionMapper;
	}

	@Autowired
	public SysTempConditionMapper getSysTempConditionMapper() {
		return sysTempConditionMapper;
	}

	@Autowired
	public void setSysTempConditionMapper(
			SysTempConditionMapper sysTempConditionMapper) {
		this.sysTempConditionMapper = sysTempConditionMapper;
	}

	@Autowired
	public SysTempService getSysTempService() {
		return sysTempService;
	}

	@Autowired
	public void setSysTempService(SysTempService sysTempService) {
		this.sysTempService = sysTempService;
	}

	@Autowired
	public DivisionRoleService getDivisionRoleService() {
		return divisionRoleService;
	}

	@Autowired
	public void setDivisionRoleService(DivisionRoleService divisionRoleService) {
		this.divisionRoleService = divisionRoleService;
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
	public EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
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
	public RolePermissionConditionMapper getRolePermissionConditionMapper() {
		return rolePermissionConditionMapper;
	}

	@Autowired
	public void setRolePermissionConditionMapper(
			RolePermissionConditionMapper rolePermissionConditionMapper) {
		this.rolePermissionConditionMapper = rolePermissionConditionMapper;
	}


	@Autowired
	public OrderCategoryService getOrderCategoryService() {
		return orderCategoryService;
	}

	@Autowired
	public void setOrderCategoryService(OrderCategoryService orderCategoryService) {
		this.orderCategoryService = orderCategoryService;
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
	public IDivisionService getiDivisionService() {
		return iDivisionService;
	}

	@Autowired
	public void setiDivisionService(IDivisionService iDivisionService) {
		this.iDivisionService = iDivisionService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("/order/orderCategoryService/searchOrderCategoryService");
		Map<String, RolePermissionImpl> mapOrderCategory = new HashMap<String, RolePermissionImpl>();
		String status = orderCategoryService.getStatus();
		// m 报销模块, a 报销审批模块
		String tagPage = orderCategoryService.getTagPage();
		String parentCode = null;
		String tagPageCode = orderCategoryService.getTagPageCode();
		String permissionCusTag = "n";
		// 财务审核 1808600
		if ("1808600".equals(tagPageCode)) {
			status = "na4";
			orderCategoryService.setCountApprovePercent(100);
		}
		if ("1808400".equals(tagPageCode)) {
			status = "a";
		}
		if ("1808100".equals(tagPageCode)) {
			status = "a";
		}
		else if ("1808200".equals(tagPageCode)) {
			status = "na1";
		}
		else if ("1808300".equals(tagPageCode)) {
			status = "na2";
		}
		else if ("1808400".equals(tagPageCode)) {
			status = "na3";
		}
		// 报销修正
		if ("1809500".equals(tagPageCode)) {
			status = "a";
		}
		if ("m".equals(tagPage)) {
			// 申请科目
			// parentCode = "2001000";
			// 修正统一使用审批科目做为申请科目
			parentCode = "2002000";
		} 
		// m 报销模块, a 报销审批模块
		else if ("a".equals(tagPage)) {
			// 审批科目
			parentCode = "2002000";
			
		}
		orderCategoryService.setParentCode(parentCode);
		this.searchCategoryPermissionList(orderCategoryService);
		mv.addObject("jsonArrayLevel1", JacksonUtils.objectToJson(orderCategoryService.getListOrderCategoryLevel1()));
		mv.addObject("jsonArrayLevel2", JacksonUtils.objectToJson(orderCategoryService.getListOrderCategoryLevel2()));
		Division division = new Division();
		division.setTag("d");
		division.setStatus(0);
		division.setLevel(3);
		division.setOrder("name");
		// 取得用户需要的部门列表
		List<Division> listDivisions = new ArrayList<Division>();
		// m 报销模块, a 报销审批模块
		if ("m".equals(tagPage)) {
			// 取得是否修改报销部门权限 1808150
			// boolean permResDiv = CommonUtil.checkCode("2002000");
			// 行政部编号 ab817736-8197-462e-a15b-910ec799efdb
			RolePermissionImpl rolePermission = new RolePermissionImpl();
			rolePermission.setTypeId(getDivisionId());
			// 可选所有报销部门权限	7101001
			rolePermission.setCode("7101001");
			rolePermission = rolePermissionService.get(rolePermission);
			if (null == rolePermission) {
				division.setId(getDivisionId());
				division.setName(getDivisionName());
				listDivisions.add(division);
			}
			else {
				listDivisions = iDivisionService.select(division);
			}
			// 取得部门限定权限
			RolePermissionImpl rolePermissionTemp = new RolePermissionImpl();
			// 无客户限定 1812001
			/*rolePermissionTemp.setCode("1812001");
			rolePermissionTemp.setDivisionId(getDivisionId());
			List<RolePermissionImpl> listPermissionCusTag = rolePermissionConditionMapper.selectRolePermissionDiv(rolePermissionTemp);
			if (listPermissionCusTag != null && listPermissionCusTag.size() >= 1) {
				// 可以不填客户
				permissionCusTag = "y";
			}*/
			// m 报销模块, a 报销审批模块
			
			// 如果是报销模式,取得最后一次的收款人
			SysTempImpl sysTemp = new SysTempImpl();
			sysTemp.setUserId(getUserId()); 	
			sysTemp.setType("ocsrp");
			sysTemp.setSort("modifiedDate");
			sysTemp.setOrder("DESC");
			
			SysTempImpl sysTemp2 = (SysTempImpl) sysTempConditionMapper.getLastContent(sysTemp);
			if (null != sysTemp2) {
				mv.addObject("sysTemp", sysTemp2);
			}
			else {
				mv.addObject("sysTemp", "");
			}
			
			// 如果是报销模式,取得最后一次的收款人V2
			OrderCategoryServiceImpl orderCategoryServiceLast = new OrderCategoryServiceImpl();
			orderCategoryServiceLast.setApplicantId(getUserId());
			orderCategoryServiceLast.setSort("id");
			orderCategoryServiceLast.setOrder("DESC");
			orderCategoryServiceLast = orderCategoryServiceConditionMapper.getLast(orderCategoryServiceLast);
			if (null == orderCategoryServiceLast) {
				orderCategoryServiceLast = new OrderCategoryServiceImpl();
			}
			mv.addObject("orderCategoryServiceLast", orderCategoryServiceLast);
		} else if ("a".equals(tagPage)) {
			listDivisions = iDivisionService.select(division);
		}
		
		JSONArray jsonArrayDivision = new JSONArray();
		jsonArrayDivision.add(listDivisions);
		// 取得客户列表
		Division customer = new Division();
		customer.setStatus(0);
		customer.setTag("c");
		//List<Division> listCustomer = iDivisionService.select(customer);
		//JSONArray jsonArrayCustomer = new JSONArray();
		//jsonArrayCustomer.add(listCustomer);
		List<DivisionImpl> listCustomer = divisionConditionMapper.selectByTagOnly("c");
		mv.addObject("jsonArrayCustomer", JacksonUtils.objectToJson(listCustomer));
	
		mv.addObject("jsonArrayDivision", jsonArrayDivision);
		//mv.addObject("jsonArrayCustomer", jsonArrayCustomer);
		mv.addObject("status", status);
		mv.addObject("orderCategoryService", orderCategoryService);
		mv.addObject("divisionMainId", getDivisionId());
		//System.err.println(getDivisionId());
		mv.addObject("permissionCusTag", permissionCusTag);
		mv.addObject("userName", getUserName());
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
	public DataGrid<OrderCategoryServiceImpl> doSearch(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		String tagPage = orderCategoryService.getTagPage();
		if (null == tagPage) {
			return null;
		}
		String status = orderCategoryService.getStatus();
		DataGrid<OrderCategoryServiceImpl> list = new DataGrid<OrderCategoryServiceImpl>();
		String tagPageCode = orderCategoryService.getTagPageCode();
		// 财务审核 1808600
		if ("1808600".equals(tagPageCode)) {
			orderCategoryService.setCountApprovePercent(100);
			String seaOrderCategory = orderCategoryService.getSeaOrderCategory();
			if (null != seaOrderCategory && seaOrderCategory.length() > 0) {
				String[] listSeaOrderCategory = seaOrderCategory.split(","); 
				orderCategoryService.setListSeaOrderCategory(listSeaOrderCategory);
			}
			// 财务审核 1808600
			// 状态列表 
			List<String> listStatus = new ArrayList<String>();
			listStatus.add("c");
			// 财务待审
			if (null == status || "na4".equals(status)) {
				orderCategoryService.setStatus("ap");
			// 财务审批完成
			} else if ("ap4".equals(status)) {
				orderCategoryService.setStatus("af");
			// 财务驳回
			} else if ("re4".equals(status)) {
				orderCategoryService.setStatus("re");
				//orderCategoryService.setApproveStatus4("re4");
				//orderCategoryService.setApproveCondition4("re4");
			} else if ("a".equals(status)) {
				orderCategoryService.setStatus(null);
			}
			//orderCategoryService.setApproverId(getUserId());
			//orderCategoryService.setApproveStatus4("na");
			//orderCategoryService.setApproveCondition4("na");
			list = this.orderCategoryServiceService.search(orderCategoryService);
			return list;
		}
		
		// 报销修正
		if ("1809500".equals(tagPageCode)) {
			// 状态列表 
			List<String> listStatusMain = new ArrayList<String>();
			if ("s".equals(status)) {
				listStatusMain.add("s");
			// 财务审批完成
			} else if ("ap1".equals(status) || "ap2".equals(status) || "ap3".equals(status)) {
				status = "ap";
			} else if ("a".equals(status) || null == status) {
				status = null;
				listStatusMain.add("s");
				listStatusMain.add("ap");
			}
			orderCategoryService.setStatus(null);
			orderCategoryService.setListStatusMain(listStatusMain);
			list = this.orderCategoryServiceService.search(orderCategoryService);
			return list;			
		}
		
		// 数据类型(r:Reimbursement 报销,a:applicant 申请)
		String typeDate = orderCategoryService.getTypeData();
		String[] tagPageTemp = tagPage.split(",");
		if (tagPageTemp.length > 1) {
			tagPage = tagPageTemp[0];
		}
		// m:管理,a:审批
		if ("a".equals(tagPage)) {
			// 部门审批	1804002
			boolean approveDep = CommonUtil.checkCode("1701005");
			// 总监审批	1804003
			boolean approveAdmin = CommonUtil.checkCode("1701004");
			// 取得高管权限
			boolean approveTopManager = CommonUtil.checkCode("1701002");
			// 部门审批
			boolean approveManager = CommonUtil.checkCode("1808200");
			// 总监审批 1808300
			boolean approveMajordomo = CommonUtil.checkCode("1808300");
			// 高管审批
			boolean approveMajordTop = CommonUtil.checkCode("1808400");
			// 如果审批人是总监,那么查询所有总监对应的客户记录
	/*		if ("r".equals(typeDate) || "a".equals(typeDate)) {
				// 总监审批 1808300
				boolean approveMajordomo = CommonUtil.checkCode("1808300");
				// 如果是总监权限,总得总监可以审批的客户
				// 取得用户部门审批权限
				PermissionImpl permission = new PermissionImpl();
				permission.setParentCode("1404000");
				permission.setUserId(getUserId());
				List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
				//attenVacateManage.setListDivision(listDivision);
				
			}*/
			OrderCategoryServiceImpl orderCategoryServiceTemp = new OrderCategoryServiceImpl();
			orderCategoryServiceTemp.setParentCode("2002000");
			this.searchCategoryPermissionList(orderCategoryServiceTemp);
			List<OrderCategoryImpl> listOrderCategoryLevel2 = orderCategoryServiceTemp.getListOrderCategoryLevel2();
			if (listOrderCategoryLevel2 != null && listOrderCategoryLevel2.size() > 0) {
				//orderCategoryService.setListOrderCategoryLevel2(listOrderCategoryLevel2);
				// 取得用户部门审批权限
				PermissionImpl permission = new PermissionImpl();
				// 
				String parentCode = "1403000";
				
				// 如果是总监取得可以审批的客户
				// 数据类型(r:Reimbursement 报销,a:applicant 申请)
				if (!approveTopManager && ("r".equals(typeDate) || "a".equals(typeDate))) {
			
					// 如果是总监权限,总得总监可以审批的客户
					// 取得用户部门审批权限
					if (approveMajordomo) {
						parentCode = "1404000";
					}
					
				}
				
				List<String> listStatus = new ArrayList<String>();
				/*if (!approveMajordTop) {
					permission.setParentCode(parentCode);
					permission.setUserId(getUserId());
					List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
					
					if (approveManager) {
						//orderCategoryService.setListDivision(listDivision);
					}
					else if (approveMajordomo) {
						orderCategoryService.setListCustomer(listDivision);
						
					}
					listStatus.add("s");
				}*/
				if ("1808200".equals(tagPageCode)) {
					orderCategoryService.setApproverId1(getUserId());
					//listStatus.add("s");
					orderCategoryService.setApproveCondition1("na");
					orderCategoryService.setApproveStatus1("na");
				}
				else if ("1808300".equals(tagPageCode)) {
					orderCategoryService.setApproverId2(getUserId());
					orderCategoryService.setApproveStatus2("na");
					orderCategoryService.setApproveCondition3("na");
					orderCategoryService.setApproveStatus1("ap");
				}
				else if ("1808400".equals(tagPageCode)) {
					orderCategoryService.setApproverId3(getUserId());
					orderCategoryService.setApproveStatus3("na");
					orderCategoryService.setApproveCondition3("na");
					if (null == status) {
						status = "na3";
					}
				}
				
				orderCategoryService.setStatus(null);
				listStatus.add("ap1");
				listStatus.add("re1");
				listStatus.add("ap2");
				listStatus.add("re2");
				listStatus.add("ap3");
				listStatus.add("re3");
				//orderCategoryService.setListStatus(listStatus);
				orderCategoryService.setStatusCondition("d");
			}
		}
		// m:管理,a:审批
		else if ("m".equals(tagPage)) {
			String userId = getUserId();
			orderCategoryService.setApplicantId(userId);
			orderCategoryService.setStatus(null);
		}
		if ("a".equals(status)) {
			orderCategoryService.setStatus(null);
			orderCategoryService.setApproveStatus1(null);
			orderCategoryService.setApproveCondition1(null);
			orderCategoryService.setApproveStatus2(null);
			orderCategoryService.setApproveCondition2(null);
			orderCategoryService.setApproveStatus3(null);
			orderCategoryService.setApproveCondition3(null);
		}
		else if ("d".equals(status)) {
			orderCategoryService.setStatus(status);
		}
		else if ("s".equals(status)) {
			orderCategoryService.setStatus(status);
		}
		if ("ap1".equals(status)) {
			orderCategoryService.setApproveStatus1("ap");
		} else if ("ap2".equals(status)) {
			orderCategoryService.setApproveStatus2("ap");
		}
		else if ("ap3".equals(status)) {
			orderCategoryService.setApproveStatus3("ap");
		}
		if ("re1".equals(status)) {
			orderCategoryService.setApproveStatus1("re");
		} else if ("re2".equals(status)) {
			orderCategoryService.setApproveStatus2("re");
		}
		else if ("re3".equals(status)) {
			orderCategoryService.setApproveStatus3("re");
		} 
		if ("na1".equals(status)) {
			orderCategoryService.setApproveStatus1("na");
		} else if ("na2".equals(status)) {
			orderCategoryService.setApproveStatus1("ap");
			orderCategoryService.setApproveStatus2("na");
		}
		else if ("na3".equals(status)) {
			orderCategoryService.setApproveStatus3("na");
			orderCategoryService.setApproveCondition3("na3");
		}
		list = this.orderCategoryServiceService.search(orderCategoryService);
		return list;
	}
	
	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearchFinance", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<OrderCategoryServiceImpl> doSearchFinance(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		new PmException(session);
		String status = orderCategoryService.getStatus();
		DataGrid<OrderCategoryServiceImpl> list = new DataGrid<OrderCategoryServiceImpl>();
		String tagPageCode = orderCategoryService.getTagPageCode();
		// 数据类型(r:Reimbursement 报销,a:applicant 申请)
		String typeDate = orderCategoryService.getTypeData();
		// 财务审核 1808600
		if ("1808600".equals(tagPageCode)) {
			// 部门审批	1804002
			boolean approveDep = CommonUtil.checkCode("1701005");
			// 总监审批	1804003
			boolean approveAdmin = CommonUtil.checkCode("1701004");
			// 取得高管权限
			boolean approveTopManager = CommonUtil.checkCode("1701002");
			// 部门审批
			boolean approveManager = CommonUtil.checkCode("1808200");
			// 总监审批 1808300
			boolean approveMajordomo = CommonUtil.checkCode("1808300");
			// 高管审批
			boolean approveMajordTop = CommonUtil.checkCode("1808400");
			// 如果审批人是总监,那么查询所有总监对应的客户记录
			/*		if ("r".equals(typeDate) || "a".equals(typeDate)) {
				// 总监审批 1808300
				boolean approveMajordomo = CommonUtil.checkCode("1808300");
				// 如果是总监权限,总得总监可以审批的客户
				// 取得用户部门审批权限
				PermissionImpl permission = new PermissionImpl();
				permission.setParentCode("1404000");
				permission.setUserId(getUserId());
				List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
				//attenVacateManage.setListDivision(listDivision);
				
			}*/
			OrderCategoryServiceImpl orderCategoryServiceTemp = new OrderCategoryServiceImpl();
			orderCategoryServiceTemp.setParentCode("2002000");
			this.searchCategoryPermissionList(orderCategoryServiceTemp);
			List<OrderCategoryImpl> listOrderCategoryLevel2 = orderCategoryServiceTemp.getListOrderCategoryLevel2();
			if (listOrderCategoryLevel2 != null && listOrderCategoryLevel2.size() > 0) {
				//orderCategoryService.setListOrderCategoryLevel2(listOrderCategoryLevel2);
				// 取得用户部门审批权限
				PermissionImpl permission = new PermissionImpl();
				// 
				String parentCode = "1403000";
				
				// 如果是总监取得可以审批的客户
				// 数据类型(r:Reimbursement 报销,a:applicant 申请)
				if (!approveTopManager && ("r".equals(typeDate) || "a".equals(typeDate))) {
					
					// 如果是总监权限,总得总监可以审批的客户
					// 取得用户部门审批权限
					if (approveMajordomo) {
						parentCode = "1404000";
					}
					
				}
				
				List<String> listStatus = new ArrayList<String>();
				/*if (!approveMajordTop) {
					permission.setParentCode(parentCode);
					permission.setUserId(getUserId());
					List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
					
					if (approveManager) {
						//orderCategoryService.setListDivision(listDivision);
					}
					else if (approveMajordomo) {
						orderCategoryService.setListCustomer(listDivision);
						
					}
					listStatus.add("s");
				}*/
				if ("1808200".equals(tagPageCode)) {
					orderCategoryService.setApproverId1(getUserId());
					//listStatus.add("s");
					orderCategoryService.setApproveCondition1("na");
					orderCategoryService.setApproveStatus1("na");
				}
				else if ("1808300".equals(tagPageCode)) {
					orderCategoryService.setApproverId2(getUserId());
					orderCategoryService.setApproveStatus2("na");
					orderCategoryService.setApproveCondition3("na");
					orderCategoryService.setApproveStatus1("ap");
				}
				else if ("1808400".equals(tagPageCode)) {
					orderCategoryService.setApproverId3(getUserId());
					orderCategoryService.setApproveStatus3("na");
					orderCategoryService.setApproveCondition3("na");
				}
				// 财务审核 1808600
				else if ("1808600".equals(tagPageCode)) {
					orderCategoryService.setApproverId4(getUserId());
					//orderCategoryService.setApproveStatus4("na");
					orderCategoryService.setApproveCondition4("na");
				}
				
				orderCategoryService.setStatus(null);
				listStatus.add("ap1");
				listStatus.add("re1");
				listStatus.add("ap2");
				listStatus.add("re2");
				listStatus.add("ap3");
				listStatus.add("re3");
				//orderCategoryService.setListStatus(listStatus);
				orderCategoryService.setStatusCondition("d");
			}
		}
		list = this.orderCategoryServiceService.search(orderCategoryService);
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
	public List<OrderCategoryServiceImpl> doSearchList(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		new PmException(session);
		List<OrderCategoryServiceImpl> list = new ArrayList<OrderCategoryServiceImpl>();
		list = this.orderCategoryServiceService.select(orderCategoryService);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param orderCategoryService
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/order/orderCategoryService/editOrderCategoryService");
		String editState = orderCategoryService.getEditState();
		if ("u".equals(editState)) {
			orderCategoryService = orderCategoryServiceService.get(orderCategoryService);
		}
		orderCategoryService.setEditState(editState);
		mv.addObject("orderCategoryService", orderCategoryService);
		return mv;
	}

	/**
	 * 编辑
	 * @param orderCategoryService
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = orderCategoryService.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryService, session);
				orderCategoryService.setApplicantName(getUserName());
				orderCategoryService.setApplicantDate(new Date());
				orderCategoryService.setApplicantId(getUserId());
				orderCategoryServiceService.insert(orderCategoryService);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(orderCategoryService, session);
				//orderCategoryService.setApplicantDate(new Date());
				orderCategoryService.setApplicantName(getUserName());
				orderCategoryServiceService.update(orderCategoryService);
			} else if ("d".equals(editState)) {
				orderCategoryServiceService.delete(orderCategoryService);
			} else if ("a".equals(editState) || "af".equals(editState)) {
				orderCategoryServiceService.update(orderCategoryService);
			}
			// 修正审批人modify approver
			else if ("ma".equals(editState)) {
				orderCategoryServiceService.update(orderCategoryService);
			}
			j.setSuccess(true);
			j.setObj(orderCategoryService);
		} catch (PmException e) {
			j.setSuccess(false);
			throw e;
		} catch (Exception e) {
			j.setSuccess(false);
			throw e;
		}
		return j;
	}
	
	/**
	 * 编辑
	 * @param orderCategoryService
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doSearchJson", method = RequestMethod.POST)
	@ResponseBody
	public Json doSearchJson(OrderCategoryServiceImpl orderCategoryService, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		boolean res = true;
		try {
			List<OrderCategoryServiceImpl> listOrderCategoryService = orderCategoryServiceService.select(orderCategoryService);
			if (null != listOrderCategoryService && listOrderCategoryService.size() == 1) {
				j.setObj(listOrderCategoryService.get(0));
			} else {
				 throw new Exception();
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		j.setSuccess(res);
		return j;
	}

	private Map<String, RolePermissionImpl> listToMap(List<RolePermissionImpl> listRolePermission){
		Map<String , RolePermissionImpl> mapCategory = new HashMap<String, RolePermissionImpl>();
		if (null != listRolePermission && listRolePermission.size() > 0) {
			for (int i = 0; i < listRolePermission.size(); i++) {
				RolePermissionImpl rolePermissionTemp = listRolePermission.get(i);
				String key = rolePermissionTemp.getCode();
				RolePermissionImpl value = rolePermissionTemp;
				mapCategory.put(key, value);
			}
		}
		return mapCategory;
	}
	
	private void searchCategoryPermissionList(OrderCategoryServiceImpl orderCategoryService) {
		String parentCode = orderCategoryService.getParentCode();
		String typeData = orderCategoryService.getTypeData();
		OrderCategoryImpl orderCategory = new OrderCategoryImpl();
		RolePermissionImpl rolePermission = new RolePermissionImpl();
		Map<String, RolePermissionImpl> mapOrderCategory = new HashMap<String, RolePermissionImpl>();
		// 系统科目列表
		rolePermission.setType("s");
		rolePermission.setTypeSys("r");
		rolePermission.setParentCode(parentCode);
		rolePermission.setTypeData(typeData);
		List<RolePermissionImpl> listCategorySys = rolePermissionConditionMapper.selectRolePermissionSys(rolePermission);
		Map<String, RolePermissionImpl> mapCategorySys = this.listToMap(listCategorySys);
		mapOrderCategory.putAll(mapCategorySys);
		
		// 部门科目 列表
		orderCategory = new OrderCategoryImpl();
		rolePermission.setTypeSys("r");
		rolePermission.setType("d");
		rolePermission.setParentCode(parentCode);
		rolePermission.setDivisionId(getDivisionId());
		rolePermission.setTypeData(typeData);
		List<RolePermissionImpl> listCategoryDiv = rolePermissionConditionMapper.selectRolePermissionDiv(rolePermission);
		Map<String, RolePermissionImpl> mapCategoryDiv = this.listToMap(listCategoryDiv);
		mapOrderCategory.putAll(mapCategoryDiv);
		
		
		// 用户科目列表
		orderCategory = new OrderCategoryImpl();
		rolePermission.setTypeSys("r");
		rolePermission.setType("u");
		rolePermission.setParentCode(parentCode);
		rolePermission.setTypeData(typeData);
		rolePermission.setUserId(getUserId());
		List<RolePermissionImpl> listCategoryUser = rolePermissionConditionMapper.selectRolePermissionUser(rolePermission);
		Map<String, RolePermissionImpl> mapCategoryUser = this.listToMap(listCategoryUser);
		mapOrderCategory.putAll(mapCategoryUser);
		
		List<OrderCategoryImpl> listOrderCategoryLevel1 = new ArrayList<OrderCategoryImpl>();
		List<OrderCategoryImpl> listOrderCategoryLevel2 = new ArrayList<OrderCategoryImpl>();
		
		for (String key : mapOrderCategory.keySet()) {
			// 取得键对应的系统科目
			RolePermissionImpl rolePermissionSys = mapCategorySys.get(key);
			String categoryName = "";
			Integer level = null;
			String pid = null;
			boolean tagHaveCode = false;
			if (null != rolePermissionSys) {
				categoryName = rolePermissionSys.getName();
				level = rolePermissionSys.getLevel();
				pid = rolePermissionSys.getPid();
				// 取得选中状态
				String codeSys = rolePermissionSys.getCode();
				if (codeSys != null) {
					tagHaveCode = true;
				}
			}
			
			// 同理
			RolePermissionImpl rolePermissionDiv = mapCategoryDiv.get(key);
			if (null != rolePermissionDiv) {
				categoryName = rolePermissionDiv.getName();
				level = rolePermissionDiv.getLevel();
				pid = rolePermissionDiv.getPid();
				// 取得code
				String codeDiv = rolePermissionDiv.getCode();
				String haveExtendsDiv = rolePermissionDiv.getHaveExtends();
				String haveCodeDiv = rolePermissionDiv.getHaveCode();
				// 如果不存在,延用父状态
				// 如果存在,取得继承状态,并更新状态
				if (null != codeDiv) {
					// 如果为继承,取得继承状态,并更新状态
					if ("n".equals(haveExtendsDiv)) {
						if ("n".equals(haveCodeDiv)) {
							tagHaveCode = false;
						}
						else {
							tagHaveCode = true;
						}
					}
				}
			}
			
			// 同理
			RolePermissionImpl rolePermissionUser = mapCategoryUser.get(key);
			if (null != rolePermissionUser) {
				categoryName = rolePermissionUser.getName();
				level = rolePermissionUser.getLevel();
				pid = rolePermissionUser.getPid();
				// 取得code
				String codeUser = rolePermissionUser.getCode();
				String haveExtendsUser = rolePermissionUser.getHaveExtends();
				String haveCodeUser = rolePermissionUser.getHaveCode();
				
				// 如果不存在,延用父状态
				// 如果存在,取得继承状态,并更新状态
				if (null != codeUser) {
					// 如果为继承,取得继承状态,并更新状态
					if ("n".equals(haveExtendsUser)) {
						if ("n".equals(haveCodeUser)) {
							tagHaveCode = false;
						}
						else {
							tagHaveCode = true;
						}
					}
				}
			}
			
			if (tagHaveCode && null != level) {
				OrderCategoryImpl orderCategoryTemp = new OrderCategoryImpl();
				orderCategoryTemp.setId(Long.valueOf(key));
				orderCategoryTemp.setName(categoryName);
				orderCategoryTemp.setLevel(level);
				if (1 == level) {
					listOrderCategoryLevel1.add(orderCategoryTemp);
				} 
				else if (2 == level) {
					orderCategoryTemp.setPid(Long.valueOf(pid));
					listOrderCategoryLevel2.add(orderCategoryTemp);
					
				}
			}
		}
		orderCategoryService.setListOrderCategoryLevel1(listOrderCategoryLevel1);
		orderCategoryService.setListOrderCategoryLevel2(listOrderCategoryLevel2);
	}
	
	/**
	 * 取得最后一条信息
	 * @param orderCategoryService
	 * @return
	 */
	@RequestMapping(value = "/getOrderCategoryServiceLast", method = RequestMethod.POST)
	@ResponseBody
	public Json getOrderCategoryServiceLast(OrderCategoryServiceImpl orderCategoryService) {
		Json j = new Json();
		boolean res = true;
		try {
			orderCategoryService = new OrderCategoryServiceImpl();
			orderCategoryService.setApplicantId(getUserId());
			orderCategoryService.setTypeData("r");
			orderCategoryService.setSort("id");
			orderCategoryService.setOrder("DESC");
			orderCategoryService = orderCategoryServiceConditionMapper.getLast(orderCategoryService);
			if(null == orderCategoryService){
				orderCategoryService = new OrderCategoryServiceImpl();
			}
		} catch (Exception e) {
			e.printStackTrace();
			res = false;
		}
		j.setObj(orderCategoryService);
		j.setSuccess(res);
		return j;
	}
}

