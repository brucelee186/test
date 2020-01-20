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
package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.DivisionRoleMapper;
import com.mtf.framework.dao.RoleConditionMapper;
import com.mtf.framework.dao.RoleMapper;
import com.mtf.framework.dao.User2DivisionMapper;
import com.mtf.framework.dao.User2RoleMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.User2Role;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.page.UserSearchForm;
import com.mtf.framework.service.ResourceService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.TextUtils;

@Service("userService")
public class UserServiceImpl implements UserService{

	private static final Logger	logger	= Logger.getLogger(UserServiceImpl.class);

	private UserConditionMapper			userConditionMapper;
	@Autowired
	private MessageSource			messages;
	private User2RoleMapper		user2roleMapper;
	private User2DivisionMapper	user2divisionMapper;
	@Autowired
	private RoleConditionMapper			roleConditionMapper;
	// 领导下所有员工列表
	private List<String> listUser2Divisions;

	@Autowired
	private DivisionRoleMapper	divisionRoleMapper;
	
	@Autowired
	private UserMapper	userMapper;
	
	@Autowired
	private UserDetailMapper	userDetailMapper;
	
	@Autowired
	private RoleMapper	roleMapper;
	
	@Autowired
	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
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
	public DivisionRoleMapper getDivisionRoleMapper() {
		return divisionRoleMapper;
	}

	@Autowired
	public void setDivisionRoleMapper(DivisionRoleMapper divisionRoleMapper) {
		this.divisionRoleMapper = divisionRoleMapper;
	}

	@Autowired
	public UserConditionMapper getUserConditionMapper() {
		return userConditionMapper;
	}

	@Autowired
	public void setUserConditionMapper(UserConditionMapper userConditionMapper) {
		this.userConditionMapper = userConditionMapper;
	}

	@Autowired
	private ResourceService resourceService;
	
	@Autowired
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	@Autowired
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	@Autowired
	public ResourceService getResourceService() {
		return resourceService;
	}
	
	@Autowired
	public void setResourceService(ResourceService resourceService) {
		this.resourceService = resourceService;
	}

	@Autowired
	public void setUserMapper(UserConditionMapper userConditionMapper) {
		this.userConditionMapper = userConditionMapper;
	}
	
	@Autowired
	public void setUser2RoleMapper(User2RoleMapper user2roleMapper) {
		this.user2roleMapper = user2roleMapper;
	}
	
	@Autowired
	public void setUser2DivisionMapper(User2DivisionMapper user2divisionMapper) {
		this.user2divisionMapper = user2divisionMapper;
	}

	public MessageSource getMessages() {
		return messages;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}
	

	@Override
	public SessionInfo getAsLogin(UserImpl user) throws PmException {
		SessionInfo sessionInfo = new SessionInfo();
		sessionInfo.setLoginResult(true);
		// 用户登录状态
		String status = user.getStatus();
		// 用户注册状态
		String statusRegist = user.getStatusRegist();
		Map<String, String> mapStr = user.getMapStr();
		Date addDate = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		// step 1 : check parameter(s)
		if (user == null) {
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage("Parameter user is NULL");
			return sessionInfo;
		} else if (TextUtils.isEmpty(user.getLoginName())) {
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage("Parameter user.loginname is NULL or Empty");
			return sessionInfo;
		} else if (TextUtils.isEmpty(user.getPassword())) {
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage("Parameter user.password is NULL or Empty");
			return sessionInfo;
		}
			
		// step 2 : get user info
		user.setStatus(null);
		user = this.userConditionMapper.selectByLoginnameAndPassword(user);
		if (user == null) {
			String message = mapStr.get("uidWrong");
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage(message);
			return sessionInfo;
			// 已注册游戏需要验证
		} 
		else if (("1".equals(user.getStatus()) || "3".equals(user.getStatus()) || "2".equals(user.getStatus())) && "o".equals(statusRegist)) {
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage("Please contact the administrator to activate");
			return sessionInfo;
		} 
		else if ("f".equals(user.getStatus()) ) {
			String message = mapStr.get("disableed");
			sessionInfo.setLoginResult(false);
			sessionInfo.setLoginMessage(message);
			return sessionInfo;
		}
		
		// step 3 : get user profile
//		UserProfile userProfile = this.userProfileMapper.selectByUserId(user.getId());
/*		if (userProfile == null) {
			// throw exception
			// throw new PmException(4, "Account is invalid.");
			
			// just create a new record
			userProfile = new UserProfile();
			userProfile.setId(UUID.randomUUID().toString());
			userProfile.setUserId(user.getId());
			userProfile.setFullname(user.getLoginname());
			userProfile.setLanguage("en");
			this.userProfileMapper.insert(userProfile);
		}*/
		 //  get user division name
		// step 4 : get user roles
		List<String> roleIds = null;
		List<RoleImpl> roles = this.roleConditionMapper.selectByUserId(user.getId());
		if (roles != null && !roles.isEmpty()) {
			roleIds = new ArrayList<String>(roles.size());
			for (RoleImpl dbRole : roles) {
				roleIds.add(dbRole.getId());
			}
		}
		
		// step 5 : prepare result
		sessionInfo.setUserId(user.getId());
		sessionInfo.setDisplayName(user.getDisplayName());
		/*********************************************************/
		sessionInfo.setLanguage(user.getLanguage());
		/*********************************************************/
		sessionInfo.setRoleIds(roleIds);
		sessionInfo.setLoginName(user.getLoginName());
		sessionInfo.setDatetime(user.getDatetime());
		sessionInfo.setStatus(user.getStatus());
		sessionInfo.setUser(user);
		sessionInfo.setEmail(user.getEmail());
		boolean tagSys = CommonUtil.getTrueSys();
		sessionInfo.setTagSys(tagSys);
		// 取得主角色用户等级
		User2Role user2Role = user2roleMapper.selectMainRole(user.getId());
		if (null != user2Role && null != user2Role.getLevel()) {
			sessionInfo.setUserLever(user2Role.getLevel());
		} else {
			sessionInfo.setUserLever(0);
		} 
		sessionInfo.setServerIp(CommonUtil.getConfig("serverIp"));
		sessionInfo.setPass(user.getPassword());
		sessionInfo.setNowMonth(sdf.format(addDate));
//		lastMonth
		Calendar ca = Calendar.getInstance();
		ca.setTime(addDate);
		ca.add(Calendar.MONTH, -1);
		sessionInfo.setLastMonth(sdf.format(ca.getTime()));
		//注册用户略过配资源
		try {
			String sessionStatus = sessionInfo.getStatus();
			if(!"2".equals(status) && ("0".equals(sessionStatus) || "1".equals(sessionStatus) || "2".equals(sessionStatus))){
				if (sessionInfo.getUserLever() != 9) {
						if(user.getDivisionId() == null){
							List<User2Division> u2dList = user2divisionMapper.selectByUserIdWithDivision(user.getId());
							sessionInfo.setDivisionName(u2dList.get(0).getDivision().getName());
							sessionInfo.setDivisionId(u2dList.get(0).getDivisionId());
						}else{
							sessionInfo.setDivisionName(user.getDivisionName());
							sessionInfo.setDivisionId(user.getDivisionId());
						}
				}
			}
		} catch (Exception e) {
			throw new PmException("没有找到员工部门！", 1);
		}
	
		
	
		
		
		// step 6 : get employee collection
		//User2Division user2Division = new User2Division();
		// 判断如果为领导那么取得下属员工,divisionId:部门编号
		String divisionId = user.getDivisionId();
		if(divisionId != null) {
			// (已过期,改用存储过程)
			/*user2Division.setDivisionId(divisionId);
			List<String> listEmployee = user2divisionMapper.selectEmployeeByUserId(user2Division);
			sessionInfo.setListEmployee(listEmployee);
			// 查询所有用户列表
			User2Division user2DivisionTemp = new User2Division();
			// 查询本部门除领导外的所有员工
			user2DivisionTemp.setDivisionId(divisionId);
			user2DivisionTemp.setIndex(0);
			List<User2Division> listUserDivision = user2divisionMapper.selectUser(user2DivisionTemp);*/
			// 清空员工列表(全局变量会记录曾经登录过的数据)
			listUser2Divisions = new ArrayList<String>();
			/*listUser2Divisions = user2divisionMapper.callSelectEmpListbyLeadId(user.getId());
			// 取得领导下的所有一级员工(业务员)
			// searchUserCurDiv(listUserDivision);
			sessionInfo.setListEmployee(listUser2Divisions);*/
		}
		List<User2Division> listDivision = this.user2divisionMapper.selectByUserIdWithDivision(user.getId());
		if (listDivision != null && listDivision.size() >= 1) {
			sessionInfo.setDivisionId(listDivision.get(0).getDivisionId());
			sessionInfo.setDivisionName(listDivision.get(0).getDivision().getName());
		}
		// 取得用户权限列表
		Resource resource = new Resource();
		// 访问类型 菜单(Menu):m
		resource.setAccess("m");
//		List<Resource> listResources = resourceService.selectMenu(resource);
//		System.err.println(listResources);
		return sessionInfo;
	}

	/**
	 * 查询当前用户下级的所有员工,并插入到list中
	 * (已过期,改用存储过程)
	 */
	@SuppressWarnings("unused")
	private void searchUserCurDiv(List<User2Division> listUserDivision) {
		for (int i = 0; i < listUserDivision.size(); i++) {
			// 去掉为领导的记录,领导记录会继续向下查询
			User2Division user2DivisionTemp = listUserDivision.get(i);
			// 取得当前记录假设为领导index = 1, 和条件员工编号 的情况下,查询出本部门(下级部门)的所有员工,存入list
			user2DivisionTemp.setDivisionId(null);
			List<User2Division> listEmployee = user2divisionMapper.selectUserByCondition(user2DivisionTemp);
			if (listEmployee.size() == 0) {
				listUser2Divisions.add(user2DivisionTemp.getUserId());
			} else {
				searchUserCurDiv(listEmployee);
			}
		}
	}
	
	@Override
	public UserImpl add(String uid, UserImpl user) throws PmException {
		String stateInit = user.getStateInit();
		// step 1 : check parameter(s)
		if (user == null) {
			throw new PmException("Parameter user is NULL.", 1);
		} else if (TextUtils.isEmpty(user.getLoginName())) {
			throw new PmException("Parameter user.loginName is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getPassword())) {
			throw new PmException("Parameter user.password is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getDisplayName())) {
			throw new PmException("Parameter user.displayName is NULL or Empty.", 1);
		} else if (!"r".equals(stateInit) && TextUtils.isEmpty(user.getUserId())) {
			throw new PmException("Parameter user.userId is NULL or Empty.", 1);
		} 

		// step 2 : check loginname
		boolean loginnameExists = this.userConditionMapper.countByLoginname(user.getLoginName()) > 0;
		if (loginnameExists) {
			throw new PmException("UserImpl loginname already exists.", 2);
		}

	/*	// step 3 : check email
		if (!TextUtils.isEmpty(user.getUserProfile().getEmail())) {
			boolean emailExists = this.userProfileMapper.countByEmail(user.getUserProfile().getEmail()) > 0;
			if (emailExists) {
				throw new PmException("Userprofile email already exists.", 3);
			}
		}*/

		// step 4 : save user
		user.setId(UUID.randomUUID().toString());
		user.setUserId(uid);
		user.setDatetime(new Date());
		this.userConditionMapper.insert(user);
		// 如果为新用户注册状态,添加一条明细记录
		if ("r".equals(stateInit)) {
			// 姓
			String	lastName = user.getLastName();
			// 名
			String	firstName = user.getFirstName();
			String displayName = (lastName + firstName);
			UserDetailImpl userDetail = new UserDetailImpl();
			userDetail.setLastName(lastName);
			userDetail.setFirstName(firstName);
			userDetail.setChineseName(displayName);
			userDetail.setDisplayName(displayName);
			userDetail.setUserId(user.getId());
			userDetail.setEmailPersonal(user.getEmail());
			userDetail.setLoginName(user.getLoginName());
			userDetail.setStatus(user.getStatus());
			userDetailMapper.insert(userDetail);
		}

	/*	// step 5 : save profile
		String profileId = UUID.randomUUID().toString();
		UserProfile profile = user.getUserProfile();
		profile.setId(profileId);
		profile.setUserId(user.getId());
		this.userProfileMapper.insert(profile);*/
		
		//user.setPassword(null);
		//user.setUserProfile(profile);
		return user;
	}
	
	@Override
	public UserImpl edit(String uid, UserImpl user) throws PmException {
		// step 1 : check parameter(s)
		if (user == null) {
			throw new PmException("Parameter user is NULL.", 1);
		} else if (TextUtils.isEmpty(user.getId())) {
			throw new PmException("Parameter user.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getLoginName())) {
			throw new PmException("Parameter user.loginname is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getDisplayName())) {
			throw new PmException("Parameter user.displayName is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getUserId())) {
			throw new PmException("Parameter user.userId is NULL or Empty.", 1);
		}

		// step 2 : check exists
		UserImpl dbUser = this.userConditionMapper.selectById(user.getId());
		if (dbUser == null) {
			throw new PmException("UserImpl not found.", 2);
		}
		
		// step 3 : check loginname
		if (!dbUser.getLoginName().equalsIgnoreCase(user.getLoginName())) {
			boolean loginnameExists = this.userConditionMapper.countByLoginname(user.getLoginName()) > 0;
			if (loginnameExists) {
				throw new PmException("UserImpl loginname already exists.", 3);
			}
		}
		
		// step 4 : check profile exists;
	/*	UserProfile dbUserProfile = this.userProfileMapper.selectByUserId(user.getId());
		if (dbUserProfile == null) {
			throw new PmException("UserProfile not found.", 4);
		}*/
		
		// step 5 : check email
		if (!dbUser.getEmail().equalsIgnoreCase(user.getEmail())) {
			boolean emailExists = this.userConditionMapper.countByEmail(user.getEmail()) > 0;
			if (emailExists) {
				throw new PmException("UserImpl email already exists.", 5);
			}
		}

		// step 6 : update user
		dbUser.setLoginName(user.getLoginName());
		dbUser.setDisplayName(user.getDisplayName());
		dbUser.setPassword(user.getPassword());
		dbUser.setUserId(uid);
		//dbUser.setSignature(user.getSignature());
		//dbUser.setCachet(user.getCachet());
		dbUser.setPersonalPhoto(user.getPersonalPhoto());
		dbUser.setStatus(user.getStatus());
		//dbUser.setDatetime(new Date());
		dbUser.setEmail(user.getEmail());
		dbUser.setLanguage(user.getLanguage());
		this.userConditionMapper.updateById(dbUser);
		// 更新用户明细表
		UserDetailImpl userDetail = new UserDetailImpl();
		userDetail.setUserId(user.getId());
		userDetail.setEmail(user.getEmail());
		userDetail.setLoginName(user.getLastName());
		this.userDetailMapper.update(userDetail);

		// step 7 : update profile
	/*	dbUserProfile.setFullname(user.getUserProfile().getFullname());
		dbUserProfile.setEmail(user.getUserProfile().getEmail());
		dbUserProfile.setLanguage("zh");
		this.userProfileMapper.updateById(dbUserProfile);*/

		return user;
	}
	
	@Override
	public UserImpl editForPhoto(String uid, UserImpl user) throws PmException {
		
		UserImpl dbUser = this.userConditionMapper.selectById(user.getId());
		if (dbUser == null) {
			throw new PmException("UserImpl not found.", 2);
		}
		dbUser.setPersonalPhoto(user.getPersonalPhoto());
		this.userConditionMapper.updatePhotoById(dbUser);
		return user;
	}
	
	@Override
	public UserImpl editPassword(String uid, String oldPassword, UserImpl user) throws PmException {
		// step 1 : check parameter(s)
		if (user == null) {
			throw new PmException("Parameter user is NULL.", 1);
		} else if (TextUtils.isEmpty(user.getId())) {
			throw new PmException("Parameter user.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user.getPassword())) {
			throw new PmException("Parameter user.password is NULL or Empty.", 1);
		}
		
		// step 2 : check user
		UserImpl dbUser = null;
		String pwd = user.getPassword();
		if (!TextUtils.isEmpty(oldPassword)) {
			user.setPassword(oldPassword);
			dbUser = this.userConditionMapper.selectByIdAndPassword(user);
		} else {
			dbUser = this.userConditionMapper.selectById(user.getId());
		}
		if (dbUser == null) {
			throw new PmException("UserImpl not found or Password incorrect.", 2);
		}

		// step 3 : update user
		dbUser.setPassword(pwd);
		dbUser.setUserId(uid);
		dbUser.setDatetime(new Date());
		this.userConditionMapper.updatePasswordById(dbUser);

		return user;
	}

	@Override
	public DataGrid<UserImpl> list(String uid, UserSearchForm form) throws PmException {
		if (form == null) {
			form = new UserSearchForm();
		}
		
		DataGrid<UserImpl> grid = new DataGrid<UserImpl>();
		
		// step 1 : prepare parameters
		int searchType = 0;
		HashMap<String, Object> params = new HashMap<String, Object>();
		if (!TextUtils.isEmpty(form.getLoginName())) {
			params.put("loginName", form.getLoginName());
			searchType |= 1;
		}
		if (!TextUtils.isEmpty(form.getDisplayName())) {
			params.put("displayName", form.getDisplayName());
			searchType |= 1;
		}
		if (!TextUtils.isEmpty(form.getEmail())) {
			params.put("email", form.getEmail());
			searchType |= 1;
		}
		if (!TextUtils.isEmpty(form.getGender())) {
			params.put("gender", form.getGender());
			searchType |= 1;
		}
		if (form.getInitialDate()!=null && !form.getInitialDate().equals("")) {
			params.put("initialDate", form.getInitialDate());
			searchType |= 1;
		}
		/*if ((!form.getEntryDate().equals("")) && (form.getEntryDate()!=null)) {
			params.put("initialDate", form.getEntryDate());
			searchType |= 1;
		}*/
		if (!TextUtils.isEmpty(form.getDivisionId())) {
			params.put("divisionId", form.getDivisionId());
			searchType |= 2;
		}
		if (!TextUtils.isEmpty(form.getRoleId())) {
			params.put("roleId", form.getRoleId());
			searchType |= 4;
		}

		if (!TextUtils.isEmpty(form.getSort())) {
			String formSort = form.getSort();
			String sort = null;
			if ("loginName".equalsIgnoreCase(formSort)) {
				sort = "loginName";
			} else if ("displayName".equalsIgnoreCase(formSort)) {
				sort = "CONVERT(displayName USING gbk)";
			} else if ("email".equalsIgnoreCase(formSort)) {
				sort = "C_EMAIL";
			} else if ("status".equalsIgnoreCase(formSort)) {
				sort = "status";
			}
			if (sort != null) {
				params.put("sort", sort);
				if (!TextUtils.isEmpty(form.getOrder())) {
					params.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
				}
			}
		}
		params.put("startIndex", form.getStartIndex());
		params.put("pageSize", form.getRows());

		// step 2 : do search
		int count = 0;
		List<UserImpl> userList = null;
		if ((searchType | 2) == searchType && (searchType | 4) == searchType) {
			count = this.userConditionMapper.countByDivisionIdAndRoleId(params);
			if (count > 0) {
				userList = this.userConditionMapper.selectByDivisionIdAndRoleId(params);
			}
		} else if ((searchType | 2) == searchType) {
			count = this.userConditionMapper.countByDivisionId(params);
			if (count > 0) {
				userList = this.userConditionMapper.selectByDivisionId(params);
			}
		} else if ((searchType | 4) == searchType) {
			count = this.userConditionMapper.countByRoleId(params);
			if (count > 0) {
				userList = this.userConditionMapper.selectByRoleId(params);
			}
		} else {
			count = this.userConditionMapper.countByProfile(params);
			if (count > 0) {
				userList = this.userConditionMapper.selectByProfile(params);
			}
		}

		// step 3 : fill roles and divisions
		if (userList != null && userList.size() > 0) {
			List<UserImpl> list = new ArrayList<UserImpl>();
			for (UserImpl dbUser : userList) {
				UserImpl item = dbUser;
			/*	item.setUserId(dbUser.getId());
				item.setLoginName(dbUser.getLoginName());
				item.setDisplayName(dbUser.getDisplayName());
				item.setLastUserId(dbUser.getUserId());
				item.setLastDatetime(dbUser.getDatetime());
				item.setEmail(dbUser.getEmail());
				item.setLanguage(dbUser.getLanguage());
				item.setStatus(dbUser.getStatus());
				item.setEntryDate(dbUser.getEntryDate());
				item.setGender(dbUser.getGender());
				item.setInitialDate(dbUser.getInitialDate());
				item.setApproveStatus(dbUser.getApproveStatus());*/
				
				// step 3.1 : search role
				List<RoleImpl> dbRoles = this.roleConditionMapper.selectByUserId(dbUser.getId());
				item.setRoles(dbRoles);
				
				// step 3.2 : search division
				List<User2Division> dbDivisions = this.user2divisionMapper.selectByUserIdWithDivision(dbUser.getId());
				item.setUser2Divisions(dbDivisions);
				
				list.add(item);
			}
			grid.setTotal(count);
			grid.setRows(list);
		}

		return grid;
	}	

	@Override
	public List<UserImpl> listAllAvailable(String uid, PageForm form) throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("loginname".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "loginName");
		} else if ("status".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "status");
		} else if ("datetime".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "dateTime");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		
		List<UserImpl> users = this.userConditionMapper.selectAllAvailable(param);
		return users;
	}
	
	@Override
	public List<UserImpl> listByDivisionId(String divisionId) throws PmException {
		List<UserImpl> list = this.userConditionMapper.selectByDId(divisionId);
		return list;
	}	

	@Override
	public UserImpl get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		UserImpl user = this.userConditionMapper.selectById(id);
		return user;
	}
	
	@Override
	public UserImpl getByLoginName(String uid, String loginName) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(loginName) || TextUtils.getTrimmedLength(loginName) == 0) {
			throw new PmException("Parameter loginName is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		UserImpl user = this.userConditionMapper.selectByLoginName(loginName);
		return user;
	}

	@Override
	public UserImpl getWithProfile(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		UserImpl user = this.userConditionMapper.selectByIdWithProfile(id);
		return user;
	}

	@Override
	public UserImpl getWithRoles(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		UserImpl user = this.userConditionMapper.selectByIdWithRoles(id);
		return user;
	}

	@Override
	public void editRoles(String uid, String userId, String[] roleIds) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(userId)) {
			throw new PmException("Parameter userId is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		UserImpl user = this.userConditionMapper.selectById(userId);
		if (user == null) {
			throw new PmException("UserImpl not found.", 2);
		}
		
		// step 3 : clear current roles
		this.user2roleMapper.deleteByUserId(userId);

		// step 4 : insert new role
		if (roleIds != null && roleIds.length > 0) {
			for (String roles : roleIds) {
				String roleId = roles.split("\\.")[0];
				String mainIndex = roles.split("\\.")[1];
				RoleImpl role = this.roleConditionMapper.selectById(roleId);
				if (role == null) {
					throw new PmException("RoleImpl not found.", 3);
				}
				
				User2Role u2r = new User2Role();
				u2r.setId(UUID.randomUUID().toString());
				u2r.setUserId(userId);
				u2r.setRoleId(roleId);
				u2r.setMainIndex(mainIndex);
				this.user2roleMapper.insert(u2r);
				// 如果是主角色，更新角色
				if ("1".equals(mainIndex)) {
					UserDetailImpl userDetail = new UserDetailImpl();
					String roleName = role.getName();
					userDetail.setUserId(userId);
					userDetail.setRoleId(roleId);
					userDetail.setRoleName(roleName);
					userDetail.setEditState("u");
					CommonUtil.setCommonField(userDetail);
					userDetailMapper.update(userDetail);
				}
			}
		}
	}

	@Override
	public List<UserImpl> listUserEmail(int level) throws PmException {
		List<UserImpl> listUser =null;
		// 验证前台规定的数字内查询否则抛出异常
		if (level == 0 || level == 1 || level == 4){
			UserImpl user = new UserImpl();
			user.setField3(level);
			 listUser = userConditionMapper.selectAllUserEmail(user);
		}else {
			throw new PmException("level is wrong",1);
		}
		return listUser;
	}

	@Override
	public void updateForApproveStatus(UserImpl user, HttpSession session) throws PmException{
		UserDetailImpl userDetail = new UserDetailImpl();
		String loginName = user.getLoginName();
		String status = user.getStatus();
		CommonUtil.setCommonField(userDetail);
		userDetail.setLoginName(loginName);
		userDetail.setStatus(status);
		userDetail.setJudgeUpdate("ap");
		userDetailMapper.update(userDetail);
		userConditionMapper.updateForApproveStatus(user);
	}
	
	@Override
	public List<UserImpl> listByCategoryId(UserImpl user, Integer categoryId) throws PmException {
		List<UserImpl> list = this.userConditionMapper.selectByCategoryId(user, categoryId);
		return list;
	}
	
	@Override
	public List<UserImpl> listAdminByCategoryId(UserImpl user, Integer categoryId) throws PmException {
		String codes = ConfigUtil.getPermissionAdminCodes();
		String[] codesArr = codes.split(",");
		//判断是否有行政部报销管理人员
		int count = this.userConditionMapper.countAdminByCategoryId(categoryId, codesArr);
		List<UserImpl> list = new ArrayList<UserImpl>();
		if(count > 0){
			list = this.userConditionMapper.selectAdminByCategoryId(user, categoryId, codesArr);
		}else{
			list = this.userConditionMapper.selectAllAdminByCategoryId(codesArr);
		}
		return list;
	}
	
	@Override
	public int countAdminByUserId(String userId) throws PmException {
		String codes = ConfigUtil.getPermissionAdminCodes();
		String[] codesArr = codes.split(",");
		return this.userConditionMapper.countAdminByUserId(userId, codesArr);
	}

	@Override
	public List<UserImpl> listForSinger(UserImpl user) throws PmException {
		List<UserImpl> list = new ArrayList<UserImpl>();
		String code = ConfigUtil.getPermissionSignerCode();
		list = this.userConditionMapper.selectSignerByCode(code);
		return list;
	}

	@Override
	public List<UserImpl> select(UserImpl user) throws PmException {
		return (List<UserImpl>)userConditionMapper.select(user);
	}

	/**
	 * 查询指定部门，包含角色列表
	 * 
	 * @param uid 操作部门
	 * @param id
	 * @return 部门信息
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter id is NULL or Empty.</td></tr>
	 * </table>
	 */
	public UserImpl getWithRolesDivision(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id) || TextUtils.getTrimmedLength(id) == 0) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		UserImpl user = this.userConditionMapper.selectByDivisionIdWithRoles(id);
		return user;
	}

	/**
	 * 编辑用户角色
	 * 
	 * @param uid 操作部门
	 * @param userId
	 * @param roleIds
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>部门不存在</td><td>2</td><td>UserImpl not found.</td></tr>
	 * <tr><td>角色不存在</td><td>3</td><td>Role not found.</td></tr>
	 * </table>
	 */
	@Override
	public void editRolesDivision(String uid, String divisionId,
			String[] roleIds) throws PmException {
		// step 1 : check parameter(s)
				if (TextUtils.isEmpty(divisionId)) {
					throw new PmException("Parameter divisionId is NULL or Empty.", 1);
				}
				
				DivisionRoleImpl divisionRole = new DivisionRoleImpl();
				divisionRole.setDivisionId(divisionId);
				this.divisionRoleMapper.delete(divisionRole);

				// step 4 : insert new role
				if (roleIds != null && roleIds.length > 0) {
					for (String roles : roleIds) {
						String roleId = roles.split("\\.")[0];
						String mainIndex = roles.split("\\.")[1];
						RoleImpl role = this.roleConditionMapper.selectById(roleId);
						if (role == null) {
							throw new PmException("RoleImpl not found.", 3);
						}
						
						DivisionRoleImpl divisionRoleTemp = new DivisionRoleImpl();
						divisionRoleTemp.setDivisionId(divisionId);
						divisionRoleTemp.setRoleId(roleId);
						divisionRoleTemp.setMainIndex(mainIndex);
						this.divisionRoleMapper.insert(divisionRoleTemp);
					}
				}
	}

	@Override
	public List<UserImpl> selectUserByPermission(UserImpl user) throws PmException {
		List<UserImpl> listUser = userConditionMapper.selectUserByPermission(user);
		return listUser;
	}

	@Override
	public UserImpl get(UserImpl user) throws PmException {
		return (UserImpl) userMapper.get(user);
	}

	@Override
	public List<UserImpl> listAllEnable(String uid, PageForm form)
			throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("loginname".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "loginName");
		} else if ("status".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "status");
		} else if ("datetime".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "dateTime");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		
		List<UserImpl> users = this.userConditionMapper.selectAllEnable(param);
		return users;
	}
	

}
