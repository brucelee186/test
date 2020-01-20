package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.SysTempMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.model.impl.SysTempImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.SysTempService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 系统缓存
 * 作者:     Auto
 * 日期:     2017/9/18
**********************************************
*/
@Service("sysTempService")
public class SysTempServiceImpl extends CommonServiceImpl implements SysTempService {
	@Autowired
	private SysTempMapper sysTempMapper;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserConditionMapper userConditionMapper;
	
	@Autowired
	public UserMapper getUserMapper() {
		return userMapper;
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

	/**
	 * 新增实体对象
	 * @param sysTemp
	 */
	public SysTempImpl insert(SysTempImpl sysTemp) throws PmException {
		String type = sysTemp.getType();
		if(type != null && "ocsrp".equals(type)){
			/*String payeeName = sysTemp.getText1();
			String bankName = sysTemp.getText2();
			String bankCard = sysTemp.getText3();
			String phoneNo = sysTemp.getText4();
			String email = sysTemp.getText5();
			String status = sysTemp.getText6();*/
			String userId = getUserId();
			String userName = getUserName();
			sysTemp.setUserId(userId);
			sysTemp.setUserName(userName);
			sysTemp.setContent(userName);
			sysTemp.setText7(getUserId());
			Long id = sysTemp.getId();
			if (null == id) {
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("i");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.insert(sysTemp);
			} else {
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("u");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.update(sysTemp);
			}
			// 状态(0 启用, 1 离职, 2 注册, 3 驳回, 4 试用, 5 外部人员, 6 外部人员禁用)
			/*String userStatus = "5";
			if(status != null && "f".equals(status)){
				userStatus = "6";
			}
			Long id = sysTemp.getId();
			if (null == id) {
				// 插入新用户
				UserImpl user = new UserImpl();
				String userIdInner = UUID.randomUUID().toString();
				user.setDisplayName(payeeName + "(Other)");
				user.setLoginName(userIdInner);
				user.setPassword(userIdInner);
				user.setId(userIdInner);
				user.setStatus(userStatus);
				userConditionMapper.insert(user);
				
				UserDetailImpl userDetail = new UserDetailImpl();
				userDetail.setUserId(userIdInner);
				userDetail.setUniqueName(payeeName + "(Other)");
				userDetail.setBankCard(bankCard);
				userDetail.setBankName(bankName);
				userDetail.setPhoneNo(phoneNo);
				userDetail.setEmail(email);
				userDetail.setStatus(userStatus);
				userDetailMapper.insert(userDetail);
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("i");
				sysTemp.setText7(userDetail.getUserId());
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.insert(sysTemp);
			} else {
				// 更新用户
				String userIdInner = sysTemp.getText7();
				UserImpl user = new UserImpl();
				user.setDisplayName(payeeName + "(Other)");
				user.setLoginName(userIdInner);
				user.setPassword(userIdInner);
				user.setId(userIdInner);
				user.setStatus(userStatus);
				user.setEditState("u");
				CommonUtil.setCommonField(user);
				userMapper.update(user);
				
				UserDetailImpl userDetail = new UserDetailImpl();
				userDetail.setUserId(userIdInner);
				userDetail.setUniqueName(payeeName + "(Other)");
				userDetail.setBankCard(bankCard);
				userDetail.setBankName(bankName);
				userDetail.setPhoneNo(phoneNo);
				userDetail.setEmail(email);
				userDetail.setStatus(userStatus);
				userDetail.setEditState("u");
				CommonUtil.setCommonField(userDetail);
				userDetailMapper.update(userDetail);
				sysTemp.setUserName(userName);
				sysTemp.setTagUpdate("u");
				CommonUtil.setCommonField(sysTemp);
				sysTempMapper.update(sysTemp);
			}*/
		}
		return sysTemp;
	}

	/**
	 * 删除实体对象
	 * @param sysTemp
	 */
	public int delete(SysTempImpl sysTemp) throws PmException {
		return this.sysTempMapper.delete(sysTemp);
	}

	/**
	 * 更新实体对象
	 * @param sysTemp
	 */
	public boolean update(SysTempImpl sysTemp) throws PmException {
		boolean result = true;
		this.sysTempMapper.update(sysTemp);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param sysTemp
	 */
	@SuppressWarnings("unchecked")
	public List<SysTempImpl> select(SysTempImpl sysTemp) throws PmException {
		return (List<SysTempImpl>) this.sysTempMapper.select(sysTemp);
	}
	/**
	 * 查询单个实体
	 * @param sysTemp
	 */
	public SysTempImpl get(SysTempImpl sysTemp) throws PmException {
		return (SysTempImpl) this.sysTempMapper.get(sysTemp);
	}
	/**
	 * 查询实体分页列表
	 * @param sysTemp
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<SysTempImpl> search(SysTempImpl sysTemp) throws PmException {
		DataGrid<SysTempImpl> grid = new DataGrid<SysTempImpl>();
		Object obj = sysTemp;
		List list = sysTempMapper.select(obj);
		grid.setRows(list);
		int count;
		count = sysTempMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}