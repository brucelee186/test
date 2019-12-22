package com.mtf.framework.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.report.core.A.p;
import com.mtf.framework.dao.AttMonitorLogDao;
import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Permission;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 人员信息表
 * 作者:     Auto
 * 日期:     2015/2/28
**********************************************
*/
@Service("userDetailService")
public class UserDetailServiceImpl extends CommonServiceImpl implements UserDetailService {
	@Autowired
	private UserDetailMapper userDetailMapper;

	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	@Autowired
	private UserConditionMapper userConditionMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private DivisionMapper divisionMapper;
	
	
	@Autowired
	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	@Autowired
	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
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
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
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
	public UserConditionMapper getUserMapper() {
		return userConditionMapper;
	}

	@Autowired
	public void setUserMapper(UserConditionMapper userMapper) {
		this.userConditionMapper = userMapper;
	}

	@Autowired
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	@Autowired
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	/**
	 * 新增实体对象
	 * @param userDetail
	 */
	public UserDetailImpl insert(UserDetailImpl userDetail) throws PmException {
		UserImpl user = new UserImpl();
		String cardNo = userDetail.getCardNo();
		String badgenumber = userDetail.getBadgenumber();
		user.setCardNo(cardNo);
		user.setBadgenumber(badgenumber);
		user.setId(userDetail.getUserId());
		userMapper.update(user);
		this.userDetailMapper.insert(userDetail);
		return userDetail;
	}

	/**
	 * 删除实体对象
	 * @param userDetail
	 */
	public int delete(UserDetailImpl userDetail) throws PmException {
		return this.userDetailMapper.delete(userDetail);
	}

	/**
	 * 更新实体对象
	 * @param userDetail
	 */
	public boolean update(UserDetailImpl userDetail) throws PmException {
		boolean result = true;
		
		UserImpl user = new UserImpl();
		String firstName = userDetail.getFirstName();
		String lastName = userDetail.getLastName();
		String firstNameEn = userDetail.getFirstNameEn();
		String lastNameEn = userDetail.getLastNameEn();
		
		String chineseName = "";
		String englishName = "";

		if (firstName != null && lastName != null) {
			chineseName = lastName + firstName;
			user.setChineseName(chineseName);
			userDetail.setChineseName(chineseName);
		}
		
		if (firstNameEn != null && lastNameEn != null) {
			englishName = firstNameEn + " " + lastNameEn;
			user.setEnglishName(englishName);
			userDetail.setEnglishName(englishName);
		}
		// 填写转正日期后,如果保险和公积金日期为空,那么默认使用转正日期
		Date positiveDate = userDetail.getPositiveDate();
		// 公积金开始日期 
		Date houseFundingCommenceDate = userDetail.getHouseFundingCommenceDate();
		// 保险开始日期
		Date socialSecurityCommenceDate = userDetail.getSocialSecurityCommenceDate();
		
		if (null != positiveDate && !"".equals(positiveDate)) {
			if (null == houseFundingCommenceDate || "".equals(houseFundingCommenceDate)) {
				userDetail.setHouseFundingCommenceDate(positiveDate);
			}
			if (null == socialSecurityCommenceDate || "".equals(socialSecurityCommenceDate)) {
				userDetail.setSocialSecurityCommenceDate(positiveDate);
			}
		}
		
		// 填写离职日期后,如果保险和公积金日期为空,那么默认使用离职日期
		Date departedDate = userDetail.getDepartedDate();
		// 公积金开始日期 
		Date houseFundingTerminationDate = userDetail.getHouseFundingTerminationDate();
		// 保险开始日期
		Date socialSecurityTerminationDate = userDetail.getSocialSecurityTerminationDate();
		
		if (null != departedDate && !"".equals(departedDate)) {
			if (null == houseFundingTerminationDate || "".equals(houseFundingTerminationDate)) {
				userDetail.setHouseFundingTerminationDate(departedDate);
			}
			if (null == socialSecurityTerminationDate || "".equals(socialSecurityTerminationDate)) {
				userDetail.setSocialSecurityTerminationDate(departedDate);
			}
		}
		
		// 更新主表信息
		this.setUserCommonFiled(user, userDetail);
		userConditionMapper.updateById(user);
		userDetail.setUserId(null);
		String cardNo = userDetail.getCardNo();
		if (null != cardNo && cardNo.length() > 0) {
			Long cardNoInteger = Long.valueOf(cardNo);
			userDetail.setCardNo(cardNoInteger.toString());
		}
		this.userDetailMapper.update(userDetail);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param userDetail
	 */
	@SuppressWarnings("unchecked")
	public List<UserDetailImpl> select(UserDetailImpl userDetail) throws PmException {
		return (List<UserDetailImpl>) this.userDetailMapper.select(userDetail);
	}
	/**
	 * 查询单个实体
	 * @param userDetail
	 */
	public UserDetailImpl get(UserDetailImpl userDetail) throws PmException {
		return (UserDetailImpl) this.userDetailMapper.get(userDetail);
	}
	/**
	 * 查询实体分页列表
	 * @param userDetail
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<UserDetailImpl> search(UserDetailImpl userDetail) throws PmException {
		DataGrid<UserDetailImpl> grid = new DataGrid<UserDetailImpl>();
		String searchRank = userDetail.getSearchRank();
		if (null != searchRank && searchRank.length() > 0) {
			String[] listSearchRank = searchRank.split(","); 
			userDetail.setListSearchRank(listSearchRank);
		}
		
		String searchStatus = userDetail.getSearchStatus();
		if (null != searchStatus && searchStatus.length() > 0) {
			String[] arraySearchStatus = searchStatus.split(","); 
			userDetail.setArraySearchStatus(arraySearchStatus);
		}
		
		String searchEnglishEfficien = userDetail.getSearchEnglishEfficien();
		if (null != searchEnglishEfficien && searchEnglishEfficien.length() > 0) {
			String[] arraySearchEnglishEfficien = searchEnglishEfficien.split(","); 
			userDetail.setArraySearchEnglishEfficien(arraySearchEnglishEfficien);
		}
		
		String searchMajor = userDetail.getSearchMajor();
		if (null != searchMajor && searchMajor.length() > 0) {
			String[] arraySearchMajor = searchMajor.split(","); 
			userDetail.setArraySearchMajor(arraySearchMajor);
		}
		
		String searchEducation = userDetail.getSearchEducation();
		if (null != searchEducation && searchEducation.length() > 0) {
			String[] arraySearchEducation = searchEducation.split(","); 
			userDetail.setArraySearchEducation(arraySearchEducation);
		}
		
		String searchPosition = userDetail.getSearchPosition();
		if (null != searchPosition && searchPosition.length() > 0) {
			String[] arraySearchPosition = searchPosition.split(","); 
			userDetail.setArraySearchPosition(arraySearchPosition);
		}
		String searchDivision = userDetail.getSearchDivision();
		if (null != searchDivision && searchDivision.length() > 0) {
			String[] arraySearchDivision = searchDivision.split(","); 
			userDetail.setArraySearchDivision(arraySearchDivision);
			userDetail.setTagMapper("join");
			/*String searchDivisionId = userDetail.getDivisionId();
			userDetail.setDivisionId(null);
			userDetail.setSearchDivisionId(searchDivisionId);;
			// 取得部门对应的等级
			DivisionImpl division = new DivisionImpl();
			division.setId(searchDivision);
			division = (DivisionImpl) divisionMapper.get(division);
			if (null != division) {
				Integer divisionLevel = division.getLevel();
				userDetail.setDivisionLevel(divisionLevel);
			}*/
		}
		String sort = userDetail.getSort();
		if ("positiveDate".equals(sort)) {
			String order = userDetail.getOrder();
			if ("asc".equals(order)) {
				userDetail.setOrder("desc");
			} else {
				userDetail.setOrder("asc");
			}
		}
		String searchRole = userDetail.getSearchRole();
		if (null != searchRole && searchRole.length() > 0) {
			String[] arraySearchRole = searchRole.split(","); 
			userDetail.setArraySearchRole(arraySearchRole);
			userDetail.setTagMapper("join");
		}
		userDetail.setGroup("id");
		Object obj = userDetail;
		List list = userDetailConditionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = userDetailConditionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 插入用户主表及明细
	 * @param user
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public UserDetailImpl inserUserDetail(UserImpl user, UserDetailImpl userDetail)
			throws PmException {
		String userId = UUID.randomUUID().toString();
		user.setId(userId);
		// 新建用户类型为注册游戏
		user.setStatus("2");
		user.setLoginName("LoginName" + userId);
		user.setPassword("123456");
		user.setDatetime(new Date());
		user.setEmail(userDetail.getEmailPersonal());
		this.setUserCommonFiled(user, userDetail);
		this.userConditionMapper.insert(user);
		userDetail.setUserId(userId);
		// 自动返回插入后的id
		userDetailMapper.insert(userDetail);
		return userDetail;
	}
	
	/**
	 * 设置公共字段
	 * @param user
	 * @param userDetail
	 */
	public void setUserCommonFiled(UserImpl user, UserDetailImpl userDetail) {
		user.setId(userDetail.getUserId());
		user.setCode(userDetail.getStaffCode());
		String displayName = userDetail.getChineseName();
		if (null == displayName || "".equals(displayName)) {
			displayName = userDetail.getEnglishName();
		}
		userDetail.setDisplayName(displayName);
		user.setDisplayName(displayName);
		user.setEmail(userDetail.getEmail());
		user.setEnglishName(userDetail.getEnglishName());
		user.setDepartmentId(userDetail.getDepartmentId());
		user.setModifiedDate(new Date());
		user.setLastName(userDetail.getLastName());
		user.setFirstName(userDetail.getFirstName());
		user.setCardNo(userDetail.getCardNo());
		user.setBadgenumber(userDetail.getBadgenumber());
		user.setModifyDate(new Date());
	}

	/**
	 * 通过权限值查询用户列表
	 * @param permission
	 * @return
	 */
	public List<UserDetailImpl> selectUserByPermissionCode(UserDetailImpl userDetail) {
		return userDetailConditionMapper.selectUserByPermissionCode(userDetail);
	}
}
