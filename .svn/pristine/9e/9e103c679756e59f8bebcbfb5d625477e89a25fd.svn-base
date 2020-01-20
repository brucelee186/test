/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.controller.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.dao.SysTempMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.Tetrad;
import com.mtf.framework.model.impl.AttenRuleImpl;
import com.mtf.framework.model.impl.AttenVacateImpl;
import com.mtf.framework.model.impl.CurrencyImpl;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.OrderCategoryImpl;
import com.mtf.framework.model.impl.OrderCategoryRuleImpl;
import com.mtf.framework.model.impl.OrderServicePathImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.SysTempImpl;
import com.mtf.framework.model.impl.User2DivisionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.AttenRuleService;
import com.mtf.framework.service.AttenVacateService;
import com.mtf.framework.service.CurrencyService;
import com.mtf.framework.service.DivisionService;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.IUser2DivisionService;
import com.mtf.framework.service.OrderCategoryRuleService;
import com.mtf.framework.service.OrderCategoryService;
import com.mtf.framework.service.OrderServicePathService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.UserService;

/**
 * 共同下拉框相关
 *
 * @author Neo.Yin
 * @version 1.0	2013-3-20	 Neo.Yin		created.
 * @version <ver>
 */
@Controller("droplistController")
@RequestMapping("/common/droplist")
public class DroplistCommonController extends BaseController{

	private static final Logger		logger	= Logger.getLogger(DivisionCommonController.class);
	
	private IDivisionService		iDivisionService;
	
	@Autowired
	private DivisionService		    divisionService;
	
	@Autowired
	private PermissionService		permissionService;
	
	@Autowired
	private AttenRuleService		attenRuleService;
	
	@Autowired
	private AttenVacateService		attenVacateService;
	
	@Autowired
	private UserDetailService		userDetailService;
	
	@Autowired
	private OrderServicePathService	orderServicePathService;
	
	@Autowired
	private UserInforService	    userInforService;
	
	@Autowired
	private UserService	    		userService;
	
	@Autowired
	private OrderCategoryService	orderCategoryService;
	
	@Autowired
	private OrderCategoryRuleService	orderCategoryRuleService;
	
	@Autowired
	private IUser2DivisionService	user2DivisionService;
	
	@Autowired
	private DivisionMapper divisionMapper;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private SysTempMapper sysTempMapper;
	
	@Autowired
	private DivisionConditionMapper divisionConditionMapper;
	
	@Autowired
	private UserDivisionMapper userDivisionMapper;
	
	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	@Autowired
	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
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
	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	@Autowired
	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	public DivisionService getDivisionService() {
		return divisionService;
	}

	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
	}

	public IUser2DivisionService getUser2DivisionService() {
		return user2DivisionService;
	}

	@Autowired
	public IDivisionService getiDivisionService() {
		return iDivisionService;
	}

	@Autowired
	public void setiDivisionService(IDivisionService iDivisionService) {
		this.iDivisionService = iDivisionService;
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

	public OrderCategoryService getOrderCategoryService() {
		return orderCategoryService;
	}

	public void setOrderCategoryService(OrderCategoryService orderCategoryService) {
		this.orderCategoryService = orderCategoryService;
	}

	@Autowired
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public OrderServicePathService getOrderServicePathService() {
		return orderServicePathService;
	}

	@Autowired
	public void setOrderServicePathService(
			OrderServicePathService orderServicePathService) {
		this.orderServicePathService = orderServicePathService;
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
	public AttenVacateService getAttenVacateService() {
		return attenVacateService;
	}

	@Autowired
	public void setAttenVacateService(AttenVacateService attenVacateService) {
		this.attenVacateService = attenVacateService;
	}

	@Autowired
	public AttenRuleService getAttenRuleService() {
		return attenRuleService;
	}

	@Autowired
	public void setAttenRuleService(AttenRuleService attenRuleService) {
		this.attenRuleService = attenRuleService;
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
	public void setDivisionService(IDivisionService divisionService) {
		this.iDivisionService = divisionService;
	}

	/**
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPermission")
	@ResponseBody
	public List<Pair<String, String>> doListPermission(PermissionImpl permission) throws PmException {
		List<PermissionImpl> listPermission = new ArrayList<>();
		List<Pair<String, String>> listPair = null;
		try {
			listPermission = this.permissionService.select(permission);
			if (listPermission != null && !listPermission.isEmpty()) {
				listPair = new ArrayList<>();
				for (PermissionImpl permissionTemp : listPermission) {
					listPair.add(new Pair<String, String>(permissionTemp.getCode(), permissionTemp.getName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return listPair;
	}
	
	/**
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListDivision")
	@ResponseBody
	public List<Pair<String, String>> doListDivision() throws PmException {
		List<Pair<String, String>> list = null;
		try {
			// d:division,g:group
			List<DivisionImpl> divisionList = this.iDivisionService.listAvailable(getUserId(), "d");
			if (divisionList != null && !divisionList.isEmpty()) {
				list = new ArrayList<Pair<String, String>>(divisionList.size());
				for (DivisionImpl division : divisionList) {
					list.add(new Pair<String, String>(division.getId(), division.getName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}
	
	/**
	 * 根据权限取得部门下拉列表
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListDivisionByPermission")
	@ResponseBody
	public List<Pair<String, String>> doListDivisionByPermission() throws PmException {
		List<Pair<String, String>> list = null;
		try {
			// 取得用户部门审批权限
			PermissionImpl permission = new PermissionImpl();
			permission.setParentCode("1403000");
			permission.setUserId(getUserId());
			List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
			// d:division,g:group
			if (listDivision != null && !listDivision.isEmpty()) {
				list = new ArrayList<Pair<String, String>>(listDivision.size());
				for (PermissionImpl division : listDivision) {
					list.add(new Pair<String, String>(String.valueOf(division.getDivisionId()), division.getDivisionName()));
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return list;
	}
	
	/**
	 * 根据权限取得部门下拉列表
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListDivisionAll")
	@ResponseBody
	public List<DivisionImpl> doListDivisionAll(DivisionImpl division) throws PmException {
		// 等级3
		//division.setLevel(3);
		// 普通状态
		division.setStatus(0);
		division.setTagMapper("doListDivisionAll");
		division.setSort("a.name");
		division.setOrder("ASC");
		List<DivisionImpl> listDivision = (List<DivisionImpl>) divisionMapper.select(division);
		return listDivision;
	}
	
	/**
	 * 根据权限取得部门下拉列表
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListDivisionByUser")
	@ResponseBody
	public List<Division> doListDivisionByUser(User2DivisionImpl user2Division) throws PmException {
		// 正常状态记录n:normal
		String tagPageCode = user2Division.getTagPageCode();
		List<Division> listDivision = new ArrayList<Division>();
		user2Division.setUserId(getUserId());
		List<User2Division> listUser2Division = user2DivisionService.select(user2Division);
		if (null != listUser2Division && listUser2Division.size() >0) {
			for (int i = 0; i < listUser2Division.size(); i++) {
				Division division = listUser2Division.get(i).getDivision();
				listDivision.add(division);
			}
		}
		/*if(!"1809500".equals(tagPageCode)){
		}else {
			DivisionImpl division = new DivisionImpl();
			division.setTag("d");
			division.setLevel(3);
			division.setStatus(0);
			listDivision = divisionMapper.select(division);
		}*/
		return listDivision;
	}
	
	/**
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPermissionType")
	@ResponseBody
	public List<Pair<String, String>> doListPermissionType(PermissionImpl permission) throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		listPair.add(new Pair<String, String>("m", "菜单"));
		listPair.add(new Pair<String, String>("b", "按钮"));
		listPair.add(new Pair<String, String>("l", "链接"));
		listPair.add(new Pair<String, String>("a", "审批"));
		listPair.add(new Pair<String, String>("at", "考勤"));
		return listPair;
	}
	
	/**
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListOptionDirectly")
	@ResponseBody
	public List<Pair<String, String>> doListOptionDirectly() throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		listPair.add(new Pair<String, String>("pa", "父母"));
		listPair.add(new Pair<String, String>("ma_pa", "配偶的父母"));
		listPair.add(new Pair<String, String>("ma", "配偶"));
		listPair.add(new Pair<String, String>("ch", "子女"));
		return listPair;
	}
	
	/**
	 * 取得考勤规则
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListAttenRule")
	@ResponseBody
	public List<Pair<String, String>> doListAttenRule(PermissionImpl permission) throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		AttenRuleImpl attenRule = new AttenRuleImpl();
		// 正常状态记录n:normal
		attenRule.setTag("n");
		List<AttenRuleImpl> listAttenRule = attenRuleService.select(attenRule);
		for (int i = 0; i < listAttenRule.size(); i++) {
			attenRule = listAttenRule.get(i);
			listPair.add(new Pair<String, String>(String.valueOf(attenRule.getId()), attenRule.getName()));
		}
		return listPair;
	}
	
	/**
	 * 取得请假类型
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListAttenVacate")
	@ResponseBody
	public List<Pair<String, String>> doListAttenVacate(AttenVacateImpl attenVacate) throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		// 正常状态记录n:normal
		attenVacate.setTag("n");
		attenVacate.setTagType("m");
		List<AttenVacateImpl> listAttenVacate = attenVacateService.select(attenVacate);
		for (int i = 0; i < listAttenVacate.size(); i++) {
			attenVacate = listAttenVacate.get(i);
			listPair.add(new Pair<String, String>(String.valueOf(attenVacate.getId()), attenVacate.getName()));
		}
		return listPair;
	}
	
	/**
	 * 取得请假类型
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListAttenVacateDetail")
	@ResponseBody
	public List<AttenVacateImpl> doListAttenVacateDetail(AttenVacateImpl attenVacate) throws PmException {
		attenVacate.setUserId(getUserId());
		// 正常状态记录n:normal
		attenVacate.setTag("n");
		List<AttenVacateImpl> listAttenVacate = attenVacateService.select(attenVacate);
		return listAttenVacate;
	}
	
	/**
	 * 取得请假类型
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListAttenVacateList")
	@ResponseBody
	public List<Tetrad<String, String, String,String>> doListAttenVacateList(AttenVacateImpl attenVacate) throws PmException {
		List<Tetrad<String, String, String,String>> listPair = new ArrayList<Tetrad<String, String, String,String>>();
		// 正常状态记录n:normal
		attenVacate.setTag("n");
		List<AttenVacateImpl> listAttenVacate = attenVacateService.select(attenVacate);
		for (int i = 0; i < listAttenVacate.size(); i++) {
			attenVacate = listAttenVacate.get(i);
			listPair.add(new Tetrad<String, String, String,String>(attenVacate.getDayVacateAhead(), attenVacate.getName(),attenVacate.getDuration(), String.valueOf(attenVacate.getId())));
		}
		return listPair;
	}
	
	/**
	 * 取得特定权限的员工
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPermissionUser")
	@ResponseBody
	public List<UserDetailImpl> doListPermissionUser(UserDetailImpl userDetail) throws PmException {
		List<UserDetailImpl> listUserDetail = (List<UserDetailImpl>) userDetailService.selectUserByPermissionCode(userDetail);
		return listUserDetail;
	}
	
	/**
	 * 取得小时时间下拉框
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListHour")
	@ResponseBody
	public List<Pair<String, String>> doListHour() throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		for (int i = 0; i <= 9; i++) {
			listPair.add(new Pair<String, String>("0" + i, "0" + i));
		}
		
		for (int i = 10; i < 24; i++) {
			listPair.add(new Pair<String, String>(String.valueOf(i), String.valueOf(i)));
			
		}
		return listPair;
	}
	
	/**
	 * 取得小时时间下拉框
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListMinute")
	@ResponseBody
	public List<Pair<String, String>> doListMinute(String type) throws PmException {
		List<Pair<String, String>> listPair = new ArrayList<Pair<String,String>>();
		if (null == type) {
			for (int i = 0; i <= 9; i++) {
				listPair.add(new Pair<String, String>("0" + i, "0" + i));
			}
			
			for (int i = 10; i < 59; i++) {
				listPair.add(new Pair<String, String>(String.valueOf(i), String.valueOf(i)));
				
			}
		// 如果是请假管理的情况使用整点和单小时来计算 half : ha
		} else if ("ha".equals(type)) {
			listPair.add(new Pair<String, String>("00", "00"));
			listPair.add(new Pair<String, String>("30", "30"));
		}
		return listPair;
	}
	
	/**
	 * 取得固定金额路线列表
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListOrderServicePath")
	@ResponseBody
	public List<OrderServicePathImpl> doListOrderServicePath(OrderServicePathImpl orderServicePath) throws PmException {
		// 正常状态记录n:normal
		orderServicePath.setTag("n");
		List<OrderServicePathImpl> listOrderServicePath = orderServicePathService.select(orderServicePath);
		return listOrderServicePath;
	}
	
	/**
	 * 取得组列表c:customer,g:group,d:division
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListCustomer")
	@ResponseBody
	public List<DivisionImpl> doListCustomer(DivisionImpl division) throws PmException {
		List<DivisionImpl> listDivisions = new ArrayList<DivisionImpl>();
		division.setTagStatus0("y");
		DivisionImpl divisionInner = new DivisionImpl(); 
		divisionInner.setId(null);
		divisionInner.setName("- -");
		listDivisions.add(divisionInner);
		List<DivisionImpl> listDivisions2 = divisionService.select(division);
		if (null != listDivisions2 && listDivisions2.size() > 0) {
			listDivisions.addAll(listDivisions2);
		}
		return listDivisions;
	}
	
	/**
	 * 取得组列表c:customer,g:group,d:division
	 * @param permission
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListDivisionByManager")
	@ResponseBody
	public List<UserDivisionImpl> doListDivisionByManager(UserDivisionImpl userDivision) throws PmException {
		List<UserDivisionImpl> listDivisions = new ArrayList<UserDivisionImpl>();
		UserDivisionImpl divisionInner = new UserDivisionImpl(); 
		divisionInner.setId(null);
		divisionInner.setDivisionName("- -");
		listDivisions.add(divisionInner);
		userDivision.setPositionId("gwmc2");
		userDivision.setUserId(getUserId());
		userDivision.setTagMapper("joinAttenRule");
		List<UserDivisionImpl> listDivisions2 = (List<UserDivisionImpl>) userDivisionMapper.select(userDivision);
		if (null != listDivisions2 && listDivisions2.size() > 0) {
			listDivisions.addAll(listDivisions2);
		}
		return listDivisions;
	}	
	
	/**
	 * 
	 * @param division
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUser")
	@ResponseBody
	public List<UserImpl> doListUser(UserImpl user) throws PmException {
		user.setStatus("0");
		List<UserImpl> listUsers = userService.select(user);
		return listUsers;
	}
	
	/**
	 * 
	 * @param user
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUserByPermission")
	@ResponseBody
	public List<UserImpl> doListUserByPermission(UserImpl user) throws PmException {
		// 负责人
		user.setStatus("0");
		user.setCode("1701005");
		List<UserImpl> listApproverSub1 = userService.selectUserByPermission(user);
		
		// 总监
		user = new UserImpl();
		user.setStatus("0");
		user.setCode("1701004");
		List<UserImpl> listApproverSub2 = userService.selectUserByPermission(user);
		
		// 一级审批人
		UserImpl userApprover1Head = new UserImpl();
		userApprover1Head.setDisplayName("总监");
		userApprover1Head.setId("1701004");
		// 二级审批人
		UserImpl userApprover2Head = new UserImpl();
		userApprover2Head.setDisplayName("负责人");
		userApprover2Head.setId("1701005");
		
		// 一级审批人列表
		List<UserImpl> listApprover1 = new ArrayList<UserImpl>();
		listApprover1.add(userApprover2Head);
		listApprover1.add(userApprover1Head);
		listApprover1.addAll(listApproverSub1);
		listApprover1.addAll(listApproverSub2);
		return listApprover1;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUserInfo")
	@ResponseBody
	public List<UserInforImpl> doListUserInfo(UserInforImpl userInfor) throws PmException {
		List<UserInforImpl> listUserInfor = null;
		try {
			// 查询明细数据
			userInfor.setFlag("i");
			// 按code排序
			userInfor.setSort("orderIndex");
			userInfor.setStatus("a");
			// 系统类型(系统,s,模块,m)
			userInfor.setTypeSystem("s");
			listUserInfor = userInforService.search(userInfor);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listUserInfor;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUserInfoDetail")
	@ResponseBody
	public List<UserInforImpl> doListUserInfoDetail(UserInforImpl userInfor) throws PmException {
		List<UserInforImpl> listUserInfor = null;
		try {
			// 查询明细数据
			userInfor.setFlag("i");
			// 按code排序
			userInfor.setSort("orderIndex");
			userInfor.setStatus("a");
			// 系统类型(系统,s,模块,m)
			userInfor.setTypeSystem("m");
			listUserInfor = userInforService.search(userInfor);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listUserInfor;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doMapUserInfoDetail")
	@ResponseBody
	public List<UserInforImpl> doMapUserInfoDetail(UserInforImpl userInfor) throws PmException {
		List<UserInforImpl> listUserInfor = new ArrayList<UserInforImpl>();
		Map<String, UserInforImpl> mapUserInfor = new TreeMap<>();
		try {
			String tagPageCode = userInfor.getTagPageCode();
			// 查询明细数据
			userInfor.setFlag("i");
			// 按code排序
			userInfor.setSort("orderIndex");
			userInfor.setStatus("a");
			// 系统类型(系统,s,模块,m)
			userInfor.setTypeSystem("m");
			List<UserInforImpl> listUserInforReturn = userInforService.search(userInfor);
			userInfor = new UserInforImpl();
			userInfor.setName("- -");
			listUserInfor.add(userInfor);
			listUserInfor.addAll(listUserInforReturn);
			if (null != tagPageCode && listUserInfor != null && listUserInfor.size() > 1) {
				for (int i = 1; i < listUserInfor.size(); i++) {
					UserInforImpl userInforInner = listUserInfor.get(i);
					String key = userInforInner.getCodeDetail();
					String value = userInforInner.getName();
					mapUserInfor.put(key, userInforInner);
				}
				// 负责人审批
				if ("1808200".equals(tagPageCode)) {
					mapUserInfor.remove("d");
					mapUserInfor.remove("na2");
					mapUserInfor.remove("re2");
					mapUserInfor.remove("na3");
					mapUserInfor.remove("re3");
					mapUserInfor.remove("ap2");
					mapUserInfor.remove("ap2");
					mapUserInfor.remove("ap3");
				}
				// 总监审批
				else if ("1808300".equals(tagPageCode)) {
					mapUserInfor.remove("d");
					mapUserInfor.remove("s");
					mapUserInfor.remove("na1");
					mapUserInfor.remove("re1");
					mapUserInfor.remove("ap3");
					mapUserInfor.remove("re3");
					mapUserInfor.remove("na3");
				}
				// 高管审批
				else if ("1808400".equals(tagPageCode)) {
					mapUserInfor.remove("d");
					mapUserInfor.remove("s");
					mapUserInfor.remove("na1");
					mapUserInfor.remove("na2");
					mapUserInfor.remove("re1");
					mapUserInfor.remove("re2");
				}
				// 财务审批
				else if ("1808600".equals(tagPageCode)) {
					mapUserInfor.remove("d");
					mapUserInfor.remove("s");
					mapUserInfor.remove("na1");
					mapUserInfor.remove("na2");
					mapUserInfor.remove("na3");
					mapUserInfor.remove("ap1");
					mapUserInfor.remove("ap2");
					mapUserInfor.remove("ap3");
					mapUserInfor.remove("re1");
					mapUserInfor.remove("re2");
					mapUserInfor.remove("re3");
				}
				// 报销修正
				else if ("1809500".equals(tagPageCode)) {
					mapUserInfor.remove("d");
					mapUserInfor.remove("na1");
					mapUserInfor.remove("na2");
					mapUserInfor.remove("na3");
					mapUserInfor.remove("na4");
					mapUserInfor.remove("ap1");
					mapUserInfor.remove("ap2");
					mapUserInfor.remove("ap3");
					mapUserInfor.remove("ap4");
					mapUserInfor.remove("re1");
					mapUserInfor.remove("re2");
					mapUserInfor.remove("re3");
					mapUserInfor.remove("re4");
				}
				listUserInfor = new ArrayList<UserInforImpl>();
				for (String key : mapUserInfor.keySet()){
					UserInforImpl userInforInner = new UserInforImpl();
					userInforInner = mapUserInfor.get(key);
					listUserInfor.add(userInforInner);
				}
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return listUserInfor;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListOrderCategory")
	@ResponseBody
	public List<OrderCategoryImpl> doListOrderCategory(OrderCategoryImpl orderCategory) throws PmException {
		List<OrderCategoryImpl> listOrderCategory = new ArrayList<>();
		OrderCategoryImpl orderCategoryTemp = new OrderCategoryImpl();
		orderCategoryTemp.setId(0L);
		orderCategoryTemp.setName("- -");
		listOrderCategory.add(orderCategoryTemp);
		try {
			List<OrderCategoryImpl> listOrderCategoryTemp = orderCategoryService.select(orderCategory);
			if (null != listOrderCategoryTemp && listOrderCategoryTemp.size() > 0) {
				listOrderCategory.addAll(listOrderCategoryTemp);
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listOrderCategory;
	}
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListOrderCategoryRule")
	@ResponseBody
	public List<OrderCategoryRuleImpl> doListOrderCategoryRule(OrderCategoryRuleImpl orderCategoryRule) throws PmException {
		List<OrderCategoryRuleImpl> listOrderCategory = new ArrayList<>();
		OrderCategoryRuleImpl orderCategoryRuleTemp = new OrderCategoryRuleImpl();
		orderCategoryRuleTemp.setId(0L);
		orderCategoryRuleTemp.setName("- -");
		listOrderCategory.add(orderCategoryRuleTemp);
		try {
			List<OrderCategoryRuleImpl> listOrderCategoryTemp = orderCategoryRuleService.select(orderCategoryRule);
			if (null != listOrderCategoryTemp && listOrderCategoryTemp.size() > 0) {
				listOrderCategory.addAll(listOrderCategoryTemp);
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listOrderCategory;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListCurrency")
	@ResponseBody
	public List<CurrencyImpl> doListCurrency(CurrencyImpl currency) throws PmException {
		List<CurrencyImpl> listCurrency = new ArrayList<>();
		try {
			listCurrency = currencyService.select(currency);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return listCurrency;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListPayeeName")
	@ResponseBody
	public List<SysTempImpl> doListPayeeName(SysTempImpl sysTemp) throws PmException {
		List<SysTempImpl> listPayeeName = new ArrayList<>();
		try {
			sysTemp.setOrder("DESC");
			sysTemp.setSort("modifiedDate");
			sysTemp.setUserId(getUserId());
			sysTemp.setPage(0);
			sysTemp.setRows(15);
			listPayeeName = (List<SysTempImpl>) sysTempMapper.select(sysTemp);
		} catch (Exception e) {
			throw e;
		}
		
		return listPayeeName;
	}
	
	/**
	 * 
	 * @param tag
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListCustomerTree")
	@ResponseBody
	public List<DivisionImpl> doListCustomerTree(DivisionImpl division) throws PmException {
		List<DivisionImpl> listDivision = new ArrayList<>();
		try {
			DivisionImpl divisionInner = new DivisionImpl(); 
			divisionInner.setId(null);
			divisionInner.setName("- -");
			listDivision.add(divisionInner);
			List<DivisionImpl> listDivision2 = divisionConditionMapper.selectDivisionTree(division);
			if (null != listDivision2 && listDivision2.size() > 0) {
				listDivision.addAll(listDivision2);
			}
			
		} catch (Exception e) {
			throw e;
		}
		
		return listDivision;
	}	
	
	/**
	 * 查询所有用户银行卡信息
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUserBank")
	@ResponseBody
	public List<UserDetailImpl> doListUserBank(UserDetailImpl user) throws PmException {
		user.setTagMapper("bank");
		//user.setSort("uniqueName");
		user.setSort("a.displayName");
		user.setOrder("DESC");
		List<UserDetailImpl> listUsers = userDetailService.select(user);
		return listUsers;
	}
	
	/**
	 * 查询所有用户银行卡信息
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doListUserApprover")
	@ResponseBody
	public List<UserImpl> doListUserApprover(UserImpl user) throws PmException {
		
		Integer level = user.getLevel();
		// 负责人
		user = new UserImpl();
		List<String> listCode = new ArrayList<>();
		if (1 == level) {
			// 总监
			listCode.add("1701004");
			// 负责人
			listCode.add("1701005");
		} else if (2 == level) {
			// 总监
			listCode.add("1701004");
		}else if (3 == level) {
			// 高管
			listCode.add("1701002");
		}
		user.setStatus("0");
		user.setListCode(listCode);
		List<UserImpl> listApprover = new ArrayList<UserImpl>();
		user.setId("");
		user.setDisplayName("- -");
		listApprover.add(user);
		List<UserImpl> listApproverInner = userService.selectUserByPermission(user);
		if (null != listApproverInner && listApproverInner.size() > 0) {
			listApprover.addAll(listApproverInner);
		}
		
		return listApprover;
	}
		
}
