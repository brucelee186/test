package com.mtf.framework.controller.maintenance;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.RolePermissionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.model.impl.OrderCategoryRuleImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.RolePermissionImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.DivisionRoleService;
import com.mtf.framework.service.OrderCategoryRuleService;
import com.mtf.framework.service.OrderCategoryService;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 角色权限列表
 * 作者:    Auto
 * 日期:    2015/1/15
**********************************************
*/
@Controller("rolePermissionController")
@RequestMapping("/maintenance/rolePermission")
public class RolePermissionController  extends BaseController {

	@Autowired
	private RolePermissionService rolePermissionService;
	
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	private OrderCategoryService orderCategoryService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private UserService	userService;
	
	@Autowired
	private OrderCategoryRuleService orderCategoryRuleService;
	
	@Autowired
	private UserInforService userInforService;
	
	@Autowired
	private DivisionRoleService divisionRoleService;

	@Autowired
	public DivisionRoleService getDivisionRoleService() {
		return divisionRoleService;
	}

	@Autowired
	public void setDivisionRoleService(DivisionRoleService divisionRoleService) {
		this.divisionRoleService = divisionRoleService;
	}

	public UserInforService getUserInforService() {
		return userInforService;
	}

	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public OrderCategoryRuleService getOrderCategoryRuleService() {
		return orderCategoryRuleService;
	}

	@Autowired
	public void setOrderCategoryRuleService(
			OrderCategoryRuleService orderCategoryRuleService) {
		this.orderCategoryRuleService = orderCategoryRuleService;
	}

	@Autowired
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RolePermissionMapper getRolePermissionMapper() {
		return rolePermissionMapper;
	}

	public void setRolePermissionMapper(RolePermissionMapper rolePermissionMapper) {
		this.rolePermissionMapper = rolePermissionMapper;
	}

	@Autowired
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
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
	public RolePermissionService getRolePermissionService() {
		return rolePermissionService;
	}

	@Autowired
	public void setRolePermissionService(RolePermissionService rolePermissionService) {
		this.rolePermissionService = rolePermissionService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/rolePermission/searchRolePermission");
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
	public DataGrid<RolePermissionImpl> doSearch(RolePermissionImpl rolePermission, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<RolePermissionImpl> list = new DataGrid<RolePermissionImpl>();
		list = this.rolePermissionService.select(rolePermission);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param rolePermission
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(RolePermissionImpl rolePermission, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/role/editRolePermission");
		String typeSys = rolePermission.getTypeSys();
		String typeExtends = rolePermission.getTypeExtends();
		// 角色权限类型
		String type = rolePermission.getType();
		String roleId = rolePermission.getRoleId();
		String divisionId = rolePermission.getTypeId();
		// 系统权限类型 s:系统,d:部门,u:用户
		// 继承状态(e:extends 继承,u:unextends 非继承)
		if("u".equals(typeExtends)){
			if ("u".equals(type)) {
				// 取得权限表所有数据并生成列
				RolePermissionImpl permission = rolePermissionService.searchPermissionList(rolePermission);
				String editState = rolePermission.getEditState();
				if ("u".equals(editState)) {
					rolePermission = rolePermissionService.get(rolePermission);
				}
				rolePermission.setEditState(editState);
				rolePermission.setTypeSys(typeSys);
				mv.addObject("rolePermission", rolePermission);
				mv.addObject("permission", permission);
			}
			else if ("d".equals(type)) {
				// 根据部门编号取得部门角色编号
				DivisionRoleImpl divisionRole = new DivisionRoleImpl();
				divisionRole.setDivisionId(divisionId);
				divisionRole = divisionRoleService.get(divisionRole);
				//String roleIdDep = divisionRole.getRoleId();
				//rolePermission.setRoleId(roleIdDep);
				RolePermissionImpl permission = rolePermissionService.searchPermissionList(rolePermission);
				String editState = rolePermission.getEditState();
				if ("u".equals(editState)) {
					rolePermission = rolePermissionService.get(rolePermission);
				}
				rolePermission.setEditState(editState);
				rolePermission.setTypeSys(typeSys);
				rolePermission.setType(type);
				rolePermission.setTypeId(divisionId);
				mv.addObject("rolePermission", rolePermission);
				mv.addObject("permission", permission);
				/*if (null != divisionRole) {
				}*/
			}
			
		} 
		// 继承状态(e:extends 继承,u:unextends 非继承)
		else if ("e".equals(typeExtends)) {
			mv = new ModelAndView("/maintenance/role/editRolePermissionSystem");
			if ("u".equals(type)) {
				// 取得限定金额
				OrderCategoryRuleImpl orderCategoryRule = new OrderCategoryRuleImpl();
				List<OrderCategoryRuleImpl> listOrderCategoryRule = orderCategoryRuleService.select(orderCategoryRule);
				orderCategoryRule = new OrderCategoryRuleImpl();
				orderCategoryRule.setName("- -");
				listOrderCategoryRule.add(0, orderCategoryRule);
				mv.addObject("listOrderCategoryRule", listOrderCategoryRule);
				
				// 取得审批类型列表 listApproveAmount
				UserInforImpl userInfor = new UserInforImpl();
				userInfor.setStatus("a");
				userInfor.setType("spje");
				userInfor.setFlag("i");
				List<UserInforImpl> listApproveAmount = userInforService.search(userInfor);
				userInfor = new UserInforImpl();
				userInfor.setName("- -");
				listApproveAmount.add(0, userInfor);
				mv.addObject("listApproveAmount", listApproveAmount);
			}
			// 如果是系统角色那么取得一级审批人,二级审批人默认列表
			if ("s".equals(type)) {
				
				// 总监
				UserImpl user = new UserImpl();
				
				// 一级审批人
				UserImpl userApproverHead = new UserImpl();
				userApproverHead.setDisplayName("- -");
				userApproverHead.setCode("0");
				
				UserImpl userApprover1Head = new UserImpl();
				userApprover1Head.setDisplayName("总监");
				userApprover1Head.setCode("1701004");
				List<UserImpl> listApproverSub1 = userService.selectUserByPermission(userApprover1Head);
				// 二级审批人
				UserImpl userApprover2Head = new UserImpl();
				userApprover2Head.setDisplayName("负责人");
				userApprover2Head.setCode("1701005");
				List<UserImpl> listApproverSub2 = userService.selectUserByPermission(userApprover2Head);
				// 三级审批人
				UserImpl userApprover3Head = new UserImpl();
				userApprover3Head.setDisplayName("高管");
				userApprover3Head.setCode("1701002");
				
				userApprover1Head.setId("1701004");
				userApprover2Head.setId("1701005");
				userApprover3Head.setId("1701002");
				// 一级审批人列表
				List<UserImpl> listApprover1 = new ArrayList<UserImpl>();
				//listApprover1.add(userApproverHead);
				listApprover1.add(userApprover1Head);
				listApprover1.addAll(listApproverSub1);
				listApprover1.addAll(listApproverSub2);
				listApprover1.add(0, userApprover2Head);
				mv.addObject("listApprover1", listApprover1);
				
				// 二级审批人列表
				List<UserImpl> listApprover2 = new ArrayList<UserImpl>();
				listApprover2.add(userApprover1Head);
				listApprover2.add(userApprover2Head);
				listApprover2.addAll(listApproverSub2);
				listApprover2.addAll(listApproverSub1);
				listApprover2.add(0, userApproverHead);
				mv.addObject("listApprover2", listApprover2);
				
				List<UserImpl> listApprover3 = new ArrayList<UserImpl>();
				listApprover3.add(userApproverHead);
				listApprover3.add(userApprover3Head);
				mv.addObject("listApprover3", listApprover3);
				
				// 取得审批类型列表 listApproveType
				UserInforImpl userInfor = new UserInforImpl();
				userInfor.setStatus("a");
				userInfor.setType("splx");
				userInfor.setFlag("i");
				List<UserInforImpl> listApproveType = userInforService.search(userInfor);
				mv.addObject("listApproveType", listApproveType);
				
				
			}
			// 如果是部门权限取得一级审批人,二级审批人列表
			if ("d".equals(type)) {
				
				// 负责人
				/*UserImpl user = new UserImpl();
				List<String> listCode = new ArrayList<>();
				listCode.add("1701004");
				listCode.add("1701005");
				user.setStatus("0");
				user.setListCode(listCode);
				List<UserImpl> listApprover = userService.selectUserByPermission(user);
				mv.addObject("listApprover", listApprover);*/
				
				// 取得审批类型
				
				// 总监
				UserImpl user = new UserImpl();
				
				// 一级审批人
				UserImpl userApproverHead = new UserImpl();
				userApproverHead.setDisplayName("- -");
				userApproverHead.setCode("0");
				
				UserImpl userApprover1Head = new UserImpl();
				userApprover1Head.setDisplayName("总监");
				userApprover1Head.setCode("1701004");
				List<UserImpl> listApproverSub1 = userService.selectUserByPermission(userApprover1Head);
				// 二级审批人
				UserImpl userApprover2Head = new UserImpl();
				userApprover2Head.setDisplayName("负责人");
				userApprover2Head.setCode("1701005");
				List<UserImpl> listApproverSub2 = userService.selectUserByPermission(userApprover2Head);
				// 三级审批人
				UserImpl userApprover3Head = new UserImpl();
				userApprover3Head.setDisplayName("高管");
				userApprover3Head.setCode("1701002");
				
				userApprover1Head.setId("1701004");
				userApprover2Head.setId("1701005");
				userApprover3Head.setId("1701002");
				// 一级审批人列表
				List<UserImpl> listApprover1 = new ArrayList<UserImpl>();
				//listApprover1.add(userApproverHead);
				listApprover1.add(userApprover1Head);
				listApprover1.addAll(listApproverSub1);
				listApprover1.addAll(listApproverSub2);
				listApprover1.add(0, userApprover2Head);
				mv.addObject("listApprover1", listApprover1);
				
				// 二级审批人列表
				List<UserImpl> listApprover2 = new ArrayList<UserImpl>();
				listApprover2.add(userApprover1Head);
				listApprover2.add(userApprover2Head);
				listApprover2.addAll(listApproverSub2);
				listApprover2.addAll(listApproverSub1);
				listApprover2.add(0, userApproverHead);
				mv.addObject("listApprover2", listApprover2);
				
				List<UserImpl> listApprover3 = new ArrayList<UserImpl>();
				listApprover3.add(userApproverHead);
				listApprover3.add(userApprover3Head);
				mv.addObject("listApprover3", listApprover3);
				
				// 取得审批类型列表 listApproveType
				UserInforImpl userInfor = new UserInforImpl();
				userInfor.setStatus("a");
				userInfor.setType("splx");
				userInfor.setFlag("i");
				List<UserInforImpl> listApproveType = userInforService.search(userInfor);
				mv.addObject("listApproveType", listApproveType);
				
				
			}
			// 如果是角色类型是用户,或者是部门,那就需要取得系统权限
			// 取得系统权限表所有数据并生成列
			rolePermission.setType(null);
			RolePermissionImpl permission = rolePermissionService.searchPermissionList(rolePermission);
			String editState = rolePermission.getEditState();
			if ("u".equals(editState)) {
				rolePermission = rolePermissionService.get(rolePermission);
				// 如果是个人取得审批金额范围
				List<OrderCategoryRuleImpl> listOrderCategoryRule = new ArrayList<OrderCategoryRuleImpl>();
				OrderCategoryRuleImpl orderCategoryRule = new OrderCategoryRuleImpl();
				listOrderCategoryRule = orderCategoryRuleService.select(orderCategoryRule);
				mv.addObject("listOrderCategoryRule", listOrderCategoryRule);
			}
			rolePermission.setEditState(editState);
			// 根据系统权限类型取得外表权限列表
			// 取得系统权限二级列表
			List<PermissionImpl> listPermission = permission.getListPermission();
			if (null != listPermission && listPermission.size() > 0) {
				for (int i = 0; i < listPermission.size(); i++) {
					PermissionImpl permissionLevel1 = listPermission.get(i);
					String typeSysPermission = permissionLevel1.getTypeSys();
					// 记录类型(r: reference 引用外表,n: non reference 非外用外表)
					if (null != typeSysPermission && ("r".equals(typeSysPermission))) {
						List<PermissionImpl> listPermissionSystem = permissionLevel1.getListPermissionLevel2();
						if (null != listPermissionSystem && listPermissionSystem.size() >0) {
							for (int j = 0; j < listPermissionSystem.size(); j++) {
								List<PermissionImpl> listPermissionLevel3List = new ArrayList<PermissionImpl>();
								List<PermissionImpl> listPermissionLevel3Permission = new ArrayList<PermissionImpl>();
								PermissionImpl permissionTemp = listPermissionSystem.get(j);
								listPermissionLevel3Permission = permissionTemp.getListPermissionLevel3();
								String parentCode3 = permissionTemp.getCode();
//					Map<String, String> permissionMap = new HashMap<String, String>();
//					if (listPermissionLevel3Permission != null && listPermissionLevel3Permission.size() > 0) {
//						for (int j = 0; j < listPermissionLevel3Permission.size(); j++) {
//							PermissionImpl permissionTempInner = listPermissionLevel3Permission.get(j);
//							String key = String.valueOf(permissionTempInner.getId());
//							//String value = permissionTempInner.getName();
//							permissionMap.put(key, "1");
//						}
//					}
								RolePermissionImpl rolePermissionForEdit = new RolePermissionImpl();
								rolePermissionForEdit.setRoleId(roleId);
								rolePermissionForEdit.setParentCode(parentCode3);
								List<RolePermissionImpl> listRolePermissionForEdit = (List<RolePermissionImpl>) rolePermissionMapper.select(rolePermissionForEdit);
								// 取得继承权限 
								Map<String, RolePermissionImpl> mapRolePermissionForEdit = new HashMap<String, RolePermissionImpl>();
								if (null != listRolePermissionForEdit && listRolePermissionForEdit.size() > 0) {
									for (int k = 0; k < listRolePermissionForEdit.size(); k++) {
										rolePermissionForEdit = new RolePermissionImpl();
										rolePermissionForEdit = listRolePermissionForEdit.get(k);
										String key = rolePermissionForEdit.getCode();
										String value = rolePermissionForEdit.getHaveExtends();
										mapRolePermissionForEdit.put(key, rolePermissionForEdit);
									}
									
								}
								// 取得 复选框状态 
								RolePermissionImpl permissionForMap = new RolePermissionImpl();
								String parentCodeTemp = permissionTemp.getCode();
								permissionForMap.setParentCode(parentCodeTemp);
								permissionForMap.setTypeSys(typeSys);
								permissionForMap.setRoleId(roleId);
								Set<Map<String, String>> setMapPermission = rolePermissionService.selectMap(permissionForMap);
								// 取得系统权限
								Map<String, String>  mapPermissionSys = new HashMap<String, String>();
								if ("d".equals(type)) {
									permissionForMap = new RolePermissionImpl();
									permissionForMap.setParentCode(parentCodeTemp);
									permissionForMap.setType("s");
									permissionForMap.setTypeSys("r");
									Set<Map<String, String>> setMapPermissionSys = rolePermissionService.selectMap(permissionForMap);
									mapPermissionSys = this.setToMap(setMapPermissionSys, parentCodeTemp);
								}
								// 取得部门权限
								Map<String, String>  mapPermissionDiv = new HashMap<String, String>();
								if ("u".equals(type)) {
									RolePermissionImpl rolePermissionDiv = new RolePermissionImpl();
									rolePermissionDiv.setTypeId(divisionId);
									rolePermissionDiv.setParentCode(parentCodeTemp);
									rolePermissionDiv.setType("d");
									rolePermissionDiv.setTypeSys("r");
									Set<Map<String, String>> setMapPermissionDiv = rolePermissionService.selectMap(rolePermissionDiv);
									mapPermissionDiv = this.setToMap(setMapPermissionDiv, parentCodeTemp);
								}
								Map<String, String>  mapPermission = this.setToMap(setMapPermission, parentCodeTemp);
								// 取得部门权限,如果是用户权限类型
								if ("u".equals(type)) {
									permissionForMap = new RolePermissionImpl();
									permissionForMap.setParentCode(parentCodeTemp);
									permissionForMap.setType("s");
									permissionForMap.setTypeSys("r");
									Set<Map<String, String>> setMapPermissionSys = rolePermissionService.selectMap(permissionForMap);
									mapPermissionSys = this.setToMap(setMapPermissionSys, parentCodeTemp);
								}
								String bag = permissionTemp.getBag();
								if (null != bag && !"".equals(bag)) {
									String parentCode = permissionTemp.getCode();
									// 取得包名
									// 类名
									String clazz = permissionTemp.getClazz();
									// 取得编号
									String perSysCode = permissionTemp.getValue1();
									// 取得显示名
									String perSysName = permissionTemp.getValue2();
									// 取得方法名
									String method = permissionTemp.getMethod();
									// 取得共同包名
									String packageBean = CommonUtil.getConfig("package.bean");
									String packageBeanImpl = packageBean + ".impl";
									String packageService = CommonUtil.getConfig("package.service");
									String packageServiceImpl = packageService + ".impl";
									
									String beanService = clazz.substring(0, 1).toLowerCase() + clazz.substring(1) + "Service";
									//String beanMapper = clazz.substring(0, 1).toLowerCase() + clazz.substring(1) + "Mapper";
									
									// 构造类
									Class classBean = Class.forName(packageBean + "." + clazz);
									Class classBase = classBean.getSuperclass();
									Class classPage = classBase.getSuperclass();
									Class classBeanImpl = Class.forName(packageBeanImpl + "." + clazz + "Impl");
									Class classServiceImpl = Class.forName(packageServiceImpl + "." + clazz + "ServiceImpl");
									Class classService = Class.forName(packageService + "." + clazz + "Service");
									
									// 构造service
									//Class classSerivice = Class.forName()
									Object objBean = classBean.newInstance();
									Object objBeanImpl = classBeanImpl.newInstance();
									//Object objService = classService.newInstance();
									Object objServiceImpl = classServiceImpl.newInstance();
//					OrderCategoryService objService = (OrderCategoryService) CommonUtil.ac.getBean(beanService);
//					OrderCategoryMapper mapper = (OrderCategoryMapper) CommonUtil.ac.getBean(beanMapper);
//					List<OrderCategoryImpl> listObj = objService.select(new OrderCategoryImpl());
//					//System.err.println(listObj);
//					Method[] specificMethod = ReflectionUtils.getUniqueDeclaredMethods(OrderCategoryService.class);
//					System.err.println(specificMethod);
//					Method[] specificMethod2 = ReflectionUtils.getAllDeclaredMethods(OrderCategoryService.class);
//					System.err.println(specificMethod2);
//					Method method2 = ReflectionUtils.findMethod(OrderCategoryServiceImpl.class, "get");
//					System.err.println(method2);
//					
//					Method methodBean = OrderCategoryImpl.class.getDeclaredMethod("getParName", null);
//					System.err.println(methodBean);
//					
//					Method meService = OrderCategoryServiceImpl.class.getDeclaredMethod("select", OrderCategoryImpl.class);
//					System.err.println(meService);
									
									// 使用反射取得
									Object objService = CommonUtil.ac.getBean(beanService);
									Method methodService = objService.getClass().getDeclaredMethod(method, classBeanImpl);
									// ORDER BY ${sort} ${order}
									Field fieSort = classPage.getDeclaredField("sort");
									fieSort.setAccessible(true);
									fieSort.set(objBeanImpl, "a.text1,");
									Field fieOrder = classPage.getDeclaredField("order");
									fieOrder.setAccessible(true);
									fieOrder.set(objBeanImpl, "a.level");
									// 调用方法,取得bean中权限列表
									List<Object> listObj= (List<Object>) methodService.invoke(objService, objBeanImpl);
									listPermissionLevel3List = new ArrayList<PermissionImpl>();
									if (null != listObj && listObj.size() > 0) {
										for (int k = 0; k < listObj.size(); k++) {
											Object objTemp = listObj.get(k);
											Class<?> claObjTempImpl = objTemp.getClass();
											Class<?> claObjTemp = claObjTempImpl.getSuperclass();
											Field fieCode = claObjTemp.getDeclaredField(perSysCode);
											Field fieName = claObjTemp.getDeclaredField(perSysName);
											Field fieParentName = claObjTempImpl.getDeclaredField("parName");
											fieCode.setAccessible(true);
											fieName.setAccessible(true);
											fieParentName.setAccessible(true);
											Long perCode = (Long) fieCode.get(objTemp);
											String perCodeString = String.valueOf(perCode);
											String perName = (String) fieName.get(objTemp);
											String parentName = (String) fieParentName.get(objTemp);
											parentName = parentName == null ? "" : parentName;
											PermissionImpl permissionTemp2 = new PermissionImpl();;
											RolePermissionImpl rolePermissionForEditTemp = mapRolePermissionForEdit.get(perCodeString);
											if ("d".equals(type)) {
												String formGrand = mapPermissionSys.get(perCodeString);
												
												if (null != formGrand) {
													permissionTemp2.setFromGrand("y");
												}
												if (null != rolePermissionForEditTemp) {
													String tagHaveExtends = rolePermissionForEditTemp.getHaveExtends();
													if (null != tagHaveExtends) {
														permissionTemp2.setHaveExtends("n");
													}
													String approver1 = rolePermissionForEditTemp.getApprover1();
													if (null != approver1) {
														permissionTemp2.setApprover1(approver1);
													}
													String approver2 = rolePermissionForEditTemp.getApprover2();
													if (null != approver2) {
														permissionTemp2.setApprover2(approver2);
													}
													String approver3 = rolePermissionForEditTemp.getApprover3();
													if (null != approver3) {
														permissionTemp2.setApprover3(approver3);
													}
													String approveType = rolePermissionForEditTemp.getApproveType();
													if (null != approveType) {
														permissionTemp2.setApproveType(approveType);
													}
												}
											}
											if ("u".equals(type)) {
												String fromGrand = mapPermissionSys.get(perCodeString);
												if (null != fromGrand) {
													permissionTemp2.setFromGrand("y");
												}
												String fromSuper = mapPermissionDiv.get(perCodeString);
												if (null != fromSuper) {
													permissionTemp2.setFromSuper("y");
												}
												if (null != rolePermissionForEditTemp) {
													String tagHaveExtends = rolePermissionForEditTemp.getHaveExtends();
													if (null != tagHaveExtends) {
														permissionTemp2.setHaveExtends("n");
													}
													Long approver1LimitRuleId = rolePermissionForEditTemp.getApprover1LimitRuleId();
													if (null != approver1LimitRuleId) {
														permissionTemp2.setApprover1LimitRuleId(approver1LimitRuleId);
													}
													Double approver1AmonutLower = rolePermissionForEditTemp.getApprover1AmonutLower();
													if (null != approver1AmonutLower) {
														permissionTemp2.setApprover1AmonutLower(approver1AmonutLower);
													}
												}
												
											}
											// 分为两种情况,非继承使用本角色权限,继承使用上级权限,上级没有,并且为继承使用上级权限
											String isPermission = mapPermission.get(perCodeString);
											if (null != isPermission && "y".equals(rolePermissionForEditTemp.getHaveCode())) {
												permissionTemp2.setTagPermission("y");
											}
											permissionTemp2.setParentCode(parentCode);
											permissionTemp2.setCode(perCodeString);
											if ("".equals(parentName)) {
												permissionTemp2.setName(perName);
											}
											else {
												permissionTemp2.setName(parentName + " 一  " + perName);
											}
											// 添加系统科目,部门科目,自科目关联
											listPermissionLevel3List.add(permissionTemp2);
											
										}
									}
									permissionTemp.setListPermissionLevel3(listPermissionLevel3List);
//					Class classObjService = objService.getClass();
//					Method[] methods = classObjService.getDeclaredMethods();
//					Method method2 = classObjService.getDeclaredMethod("select", classObjService);
//					Class<?> c = Class.forName("com.mtf.framework.service.impl.OrderCategoryServiceImpl");
//					Object object = c.newInstance();
//					Method m = object.getClass().getMethod("select");
//					Method method1= classObjService.getDeclaredMethod("select", new Class[]{}) ; 
//					Method[] method1 = classObjService.getMethods();
//					 取得方法
//					Method methodSelect = objService.getClass().getDeclaredMethod(method, objService.getClass());
//					Method methodService = classObjService.getDeclaredMethod(method, objService.getClass());
//					methodSelect.setAccessible(true);
//					// 取得科目列表
//					OrderCategoryImpl orderCategory = new OrderCategoryImpl();
//					List<OrderCategoryImpl> listOrderCategory = orderCategoryService.select(orderCategory);
//					mv.addObject("listObj", listOrderCategory);
//					permission.getListPermission().get(0).getListPermissionLevel2().get(i).setListPermissionLevel3(listPermissionLevel3);
								}
							}
//			permissionTemp.setListPermissionLevel3(listPermissionTemp);
//			// 取得系统权限表所有数据并生成列
//			//	RolePermissionImpl permission = rolePermissionService.searchPermissionList(rolePermission);
//			// 根据系统权限类型取得外表权限列表
//			// 取得系统权限二级列表
//				List<PermissionImpl> listPermissionSystem = permission.getListPermission().get(0).getListPermissionLevel2();
//			
//			listPermissionSystem.get(i).setListPermissionLevel3(listPermissionTemp);
							rolePermission.setTypeSys(typeSys);
							rolePermission.setType(type);
						}
					}
				}
				
				
			}
			rolePermission.setTypeId(divisionId);
			mv.addObject("rolePermission", rolePermission);
			mv.addObject("permission", permission);
		}
		return mv;
	}

	/**
	 * 编辑
	 * @param rolePermission
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(RolePermissionImpl rolePermission, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = rolePermission.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(rolePermission, session);
				rolePermissionService.insert(rolePermission, session);
			} else if ("u".equals(editState)) {
				rolePermissionService.editRolePermission(rolePermission, session);
			} else if ("d".equals(editState)) {
				rolePermissionService.delete(rolePermission);
			} else if ("c".equals(editState)) {
				rolePermissionService.copyRolePermission(rolePermission, session);
			}
			j.setSuccess(true);
			j.setObj(rolePermission);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	private Map<String, String> setToMap(Set<Map<String, String>> set, String parentCodeTemp){
		Iterator<Map<String, String>> it = set.iterator();
		Map<String, String>  mapPermission = new HashMap<String, String>();
		while (it.hasNext()) {
		Map<String, String> map = (HashMap<String, String> ) it.next();
			String code = map.get("code");
			mapPermission.put(code, parentCodeTemp);
		}
		return mapPermission;
	}
}

