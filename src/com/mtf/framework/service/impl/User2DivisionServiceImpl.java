package com.mtf.framework.service.impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.dao.User2DivisionMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.User;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.UserDetail;
import com.mtf.framework.model.UserDivision;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.IUser2DivisionService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.TextUtils;

@Service("user2DivisionService")
public class User2DivisionServiceImpl extends CommonServiceImpl implements IUser2DivisionService {

	private UserConditionMapper			userConditionMapper;
	@Autowired
	private UserMapper userMapper;
	
	private User2DivisionMapper	user2divisionMapper;
	
	@Autowired
	private DivisionConditionMapper		divisionConditionMapper;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	@Autowired
	private DivisionMapper divisionMapper;
	
	@Autowired
	private UserDivisionMapper userDivisionMapper;
	
	@Autowired
	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	@Autowired
	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
	}

	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
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
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	@Autowired
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
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
	public void setUserMapper(UserConditionMapper userMapper) {
		this.userConditionMapper = userMapper;
	}

	@Autowired
	public void setUser2DivisionMapper(User2DivisionMapper user2divisionMapper) {
		this.user2divisionMapper = user2divisionMapper;
	}

	@Override
		// step 1 : check parameter(s)
	public User2Division add(String uid, User2Division user2division) throws PmException {
		if (user2division == null) {
			throw new PmException("Parameter user2division is NULL.", 1);
		} else if (TextUtils.isEmpty(user2division.getUserId())) {
			throw new PmException("Parameter user2division.userId is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user2division.getDivisionId())) {
			throw new PmException("Parameter user2division.divisionId is NULL or Empty.", 1);
		} 
		/*else if (user2division.getIndex() == null || user2division.getIndex() < 0 || user2division.getIndex() > 1) {
			throw new PmException("Parameter user2division.index not in [0,1].", 1);
		}*/
		
		// step 2 : check exists
		boolean isExists = this.user2divisionMapper.countByUserIdAndDivisionId(user2division) > 0;
		/*if (isExists) {
			throw new PmException("User division relevance already exists.", 2);
		}*/
		
		/*if(user2division.getIndex() == 1){
			isExists = this.user2divisionMapper.countLeadersByDivisionId(user2division.getDivisionId()) > 0;
			if (isExists) {
				throw new PmException("Division Leader already exists.", 3);
			}
		}*/

		Integer mainIndex = user2division.getMainIndex();
		String divisionId = user2division.getDivisionId();
		Integer level = user2division.getLevel();
		Class<?> clazzUserDivision = UserDivision.class;
		UserDivisionImpl userDivision = new UserDivisionImpl();
		String tag = user2division.getTag();
		String userId = user2division.getUserId();
		if (level >= 1) {
			for (int i = level; i >= 1; i--) {
				//取得当前部门父编号
				DivisionImpl divisionInner = new DivisionImpl();
				divisionInner.setId(divisionId);
				divisionInner = (DivisionImpl) divisionMapper.get(divisionInner);
				if (null != divisionInner) {
					String divisionIdLevel = divisionInner.getId();
					String divisionNameLevel = divisionInner.getNameEng();
					String pid = divisionInner.getPid();
					try {
						Field fDivisionIdLevel = clazzUserDivision.getDeclaredField("divisionId" + i);
						fDivisionIdLevel.setAccessible(true);
						fDivisionIdLevel.set(userDivision, divisionIdLevel);
						// 如果为三级部门，那么更新主部门
						if (3 == i && "d".equals(tag) && 1 == mainIndex ) {
							// 更新用户主部门
							UserImpl userTemp = new UserImpl();
							userTemp.setId(userId);
							userTemp.setDepartmentId(divisionIdLevel);
							userMapper.update(userTemp);
							UserDetail userDetail = new UserDetail();
							userDetail.setUserId(userId);
							userDetail.setDepartmentId(divisionIdLevel);
							userDetailMapper.update(userDetail);
						}
					} catch (NoSuchFieldException e) {
						e.printStackTrace();
					} catch (SecurityException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					}
					divisionId = pid;
					// 如果为level并用是客户的情况下更新顾客表
					if ("c".equals(tag) && 1 == level) {
						UserDetail userDetailTemp = new UserDetail();
						userDetailTemp.setUserId(userId);
						userDetailTemp.setWorkGroupName(divisionNameLevel);
						userDetailTemp.setWorkGroupId(divisionIdLevel);
						userDetailMapper.update(userDetailTemp);
					}
				}
			}
		}
		if(!isExists){
			// step 3 : insert into db
			String resId = UUID.randomUUID().toString();
			user2division.setId(resId);
			if (1 == mainIndex) {
				user2division.setMainIndex(0);
				this.user2divisionMapper.updateMainIndexByUser(user2division);
			}
			user2division.setMainIndex(mainIndex);
			user2division.setTag(tag);
			this.user2divisionMapper.insert(user2division);
		} else {
			if (1 == mainIndex) {
				user2division.setMainIndex(0);
				this.user2divisionMapper.updateMainIndexByUser(user2division);
			}
			user2division.setTag(tag);
			user2division.setMainIndex(mainIndex);
			this.user2divisionMapper.updateByUserAndDivision(user2division);
			
		}
		// 更新员工主部门
		/*if (1 == mainIndex && "d".equals(tag)) {
			String divisionIdTemp = user2division.getDivisionId();
			UserImpl userTemp = new UserImpl();
			userTemp.setId(userId);
			userTemp.setDepartmentId(divisionIdTemp);
			userMapper.update(userTemp);
		}*/
		// 更新员工部门层次
		String idUserDivision = user2division.getId();
		userDivision.setId(idUserDivision);
		userDivision.setEditState("u");
		userDivision.setModifiedDate(new Date());
		userDivision.setModifiedIp(getIp());
		userDivision.setModifiedUser(getUserId());
		userDivision.setTag(tag);
		userDivisionMapper.update(userDivision);
		// 更新用户表，主部分编号
		return user2division;
	}
	
	@Override
	public void edit(String uid, String userId, String[] divisionIds, String[] leaderIds ,String mainIndex, String tag) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(userId)) {
			throw new PmException("Parameter userId is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		User user = this.userConditionMapper.selectById(userId);
		if (user == null) {
			throw new PmException("User not found.", 2);
		}

		List<String> leaders = new ArrayList<String>();
		/*if(leaderIds != null){
			Collections.addAll(leaders, leaderIds);		
			User2Division user2Division = null;
			for(String leaderId:leaderIds){
				user2Division = new User2Division();
				user2Division.setUserId(userId);
				user2Division.setDivisionId(leaderId);
				int count = user2divisionMapper.countLeadersByDivisionIdAndNotUserId(user2Division);
				
				if(count > 0) {
					throw new PmException("Division leader already exists.", 3);
				}
			}
		}*/
		// 更新用户主部门
		DivisionImpl division1 = new DivisionImpl();
		division1 = (DivisionImpl) divisionMapper.get(division1);
		UserImpl userTemp = new UserImpl();
		userTemp.setId(userId);
		userTemp.setDepartmentId(mainIndex);
		userMapper.update(userTemp);
		UserDetail userDetail = new UserDetail();
		userDetail.setUserId(userId);
		userDetail.setDepartmentId(mainIndex);
		userDetail.setDivisionId(mainIndex);
		userDetailMapper.update(userDetail);
		// step 3 : clear current divisions
		UserDivisionImpl userDivisionTemp = new UserDivisionImpl();
		userDivisionTemp.setUserId(userId);
		userDivisionTemp.setTag(tag);
		this.userDivisionMapper.delete(userDivisionTemp);
		
		UserDivisionImpl userDivision = new UserDivisionImpl();
		
		// step 4 : insert new divisions
		if (divisionIds[0] != null && divisionIds != null && divisionIds.length > 0) {
			for (String divisionObj : divisionIds) {
				String[] arrayDivision = divisionObj.split(" ");
				String divisionId = arrayDivision[0];
				String positionId = arrayDivision[1];
				
				// 如果为领导，那么更新此部门下所有员工的直属领导
				if("gwmc2".equals(positionId)){
					UserDetailImpl userDetail2 = new UserDetailImpl();
					userDetail2.setUserId(userId);
					userDetail2 = (UserDetailImpl) userDetailMapper.get(userDetail2);
					if (null != userDetail2) {
						String userName = userDetail2.getDisplayName();
						String userId2 = userDetail2.getUserId();
						UserDetailImpl userDetail3 = new UserDetailImpl();
						userDetail3.setTagUpdate("immediateSuperior");
						userDetail3.setDivisionId(divisionId);
						userDetail3.setImmediateSuperiorName(userName);
						userDetail3.setImmediateSuperiorId(userId2);
						userDetailMapper.update(userDetail3);
						
					}
				}
				
				Division division = this.divisionConditionMapper.selectById(divisionId);
				if (division == null) {
					throw new PmException("Division not found.", 4);
				}
				
				User2Division u2d = new User2Division();
				u2d.setId(UUID.randomUUID().toString());
				u2d.setUserId(userId);
				u2d.setDivisionId(divisionId);
				
				int index = 0;
				int main= 0;
				if(leaders.contains(divisionId)){
					index = 1;
				}
				if (divisionId.equals(mainIndex)) {
					main = 1;
					//如果为主部门的情况，更新用户明细表的主部门
					String divisionName = division.getNameEng();
					UserDetail userDetailTemp = new UserDetail();
					userDetailTemp.setUserId(userId);
					userDetailTemp.setDivisionName(divisionName);
					userDetailTemp.setDivisionId(divisionId);
					userDetailTemp.setSecondaryDepartment(divisionName);
					
					// 更新员工部门层级,只有为主部门的情况下可以更新
					Integer level = division.getLevel();
					
					Class<?> clazzUserDivision = UserDivision.class;
					Class<?> clazzUserDetail = UserDetail.class;
					if (level >= 1) {
						for (int i = level; i >= 1; i--) {
							//取得当前部门父编号
							DivisionImpl divisionInner = new DivisionImpl();
							divisionInner.setId(divisionId);
							divisionInner = (DivisionImpl) divisionMapper.get(divisionInner);
							if (null != divisionInner) {
								String divisionIdLevel = divisionInner.getId();
								String divisionNameLevel = divisionInner.getNameEng();
								String pid = divisionInner.getPid();
								try {
									Field fDivisionIdLevel = clazzUserDivision.getDeclaredField("divisionId" + i);
									Field fUserDetailDivisionIdLevel = clazzUserDetail.getDeclaredField("divisionId" + i);
									Field fUserDetailDivisionIdName = clazzUserDetail.getDeclaredField("divisionName" + i);
									fDivisionIdLevel.setAccessible(true);
									fUserDetailDivisionIdLevel.setAccessible(true);
									fUserDetailDivisionIdName.setAccessible(true);
									fDivisionIdLevel.set(userDivision, divisionIdLevel);
									fUserDetailDivisionIdLevel.set(userDetailTemp, divisionIdLevel);
									fUserDetailDivisionIdName.set(userDetailTemp, divisionNameLevel);
									// 如果为三级部门，那么更新主部门
									if (3 == i) {
										// 更新用户主部门
										userTemp = new UserImpl();
										userTemp.setId(userId);
										userTemp.setDepartmentId(divisionIdLevel);
										userMapper.update(userTemp);
										userDetail = new UserDetail();
										userDetail.setUserId(userId);
										userDetail.setDepartmentId(divisionIdLevel);
										//userDetail.setDivisionId(divisionIdLevel);
										userDetailMapper.update(userDetail);
										// 更新员工直属领导
										UserDetailImpl userSuperior = new UserDetailImpl();
										userSuperior.setPositionId("gwmc2");
										// 优先考虑主部门领导， 不是主部门的领导也可以
										//userSuperior.setMainIndex(1);
										userSuperior.setStatus("0");
										userSuperior.setDepartmentId(divisionIdLevel);
										userSuperior = (UserDetailImpl) userDetailConditionMapper.getSuperior(userSuperior);
										if(null != userSuperior){
											String userSuperiorName = userSuperior.getDisplayName();
											String userSuperiorId = userSuperior.getUserId();
											UserDetailImpl userDetail3 = new UserDetailImpl();
											userDetail3.setImmediateSuperiorName(userSuperiorName);
											userDetail3.setImmediateSuperiorId(userSuperiorId);
											userDetail3.setUserId(userId);
											userDetailMapper.update(userDetail3);
										}
									}
								} catch (NoSuchFieldException e) {
									e.printStackTrace();
								} catch (SecurityException e) {
									e.printStackTrace();
								} catch (Exception e) {
									e.printStackTrace();
								}
								divisionId = pid;
							}
						}
					}
					userDetailMapper.update(userDetailTemp);
		}
				u2d.setMainIndex(main);
				u2d.setIndex(index);
				u2d.setPositionId(positionId);
				u2d.setTag(tag);
				this.user2divisionMapper.insert(u2d);
				if(main == 1){
					// 更新员工部门层次
					String idUserDivision = u2d.getId();
					userDivision.setId(idUserDivision);
					userDivision.setEditState("u");
					userDivision.setModifiedDate(new Date());
					userDivision.setModifiedIp(getIp());
					userDivision.setModifiedUser(getUserId());
					userDivisionMapper.update(userDivision);
				}
			}
		}

	}

	@Override
	public List<User2Division> listByDivisionIdWithUser(String uid, String divisionId) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(divisionId)) {
			throw new PmException("Parameter divisionId is NULL or Empty.", 1);
		}
		
		List<User2Division> users = this.user2divisionMapper.selectByDivisionIdWithUser(divisionId);
		
		return users;
	}
	
	@Override
	public List<User2Division> listByDivisionIdWithUser(UserImpl user) throws PmException {
		// step 1 : check parameter(s)
		String divisionId = user.getDivisionId();
		if (TextUtils.isEmpty(divisionId)) {
			throw new PmException("Parameter divisionId is NULL or Empty.", 1);
		}
		
		List<User2Division> users = this.user2divisionMapper.selectByDivisionWithUser(user);
		
		return users;
	}

	@Override
	public Map<String, List<User2Division>> listByUserId(String uid, String userId) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(userId)) {
			throw new PmException("Parameter userId is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		User user = this.userConditionMapper.selectById(userId);
		if (user == null) {
			throw new PmException("User not found.", 2);
		}
		
		Map<String, List<User2Division>> map = new HashMap<String, List<User2Division>>();
		
		List<User2Division> userDivisions = this.user2divisionMapper.selectByUserId(userId);
		List<User2Division> hasLeaderDivisions = this.user2divisionMapper.selectAllLeadersExcludeUserId(userId);
		List<User2Division> hasLeaderMainDivisons = this.user2divisionMapper.selectLeadersMainUserId(userId);
		
		map.put("userDivisions", userDivisions);
		map.put("hasLeaderDivisions", hasLeaderDivisions);
		map.put("hasLeaderMainDivisons", hasLeaderMainDivisons);
		return map;
	}

	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter ID is NULL.", 1);
		}
		
		// step 2 : do delete
		this.user2divisionMapper.deleteById(id);
	}

	@Override
	public List<User2Division> listByDivisionIdWithUserId(String uid) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(uid)) {
			throw new PmException("Parameter uid is NULL or Empty.", 1);
		}
		List<User2Division> users = this.user2divisionMapper.selectByUserIdWithDivision(uid);
		return users;
	}
	
	/**
	 * 查询实体列表
	 * @param user2Division
	 * @return
	 * @throws PmException
	 */
	@Override
	public List<User2Division> select(User2Division user2Division)
			throws PmException {
		List<User2Division> listDivision = this.user2divisionMapper.selectByUserIdWithDivision(user2Division.getUserId());
		return listDivision;
	}

}
