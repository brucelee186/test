package com.mtf.framework.dao;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.impl.UserImpl;

public interface User2DivisionMapper {

	User2Division selectById(String id);
	
	List<User2Division> selectByUserId(String userId);
	
	List<User2Division> selectByDivisionId(String divisionId);
	
	List<User2Division> selectByDivisionIdWithUser(String divisionId);
	
	List<User2Division> selectByDivisionWithUser(UserImpl user);
	
	List<User2Division> selectByUserIdWithDivision(String userId);
	
	User2Division selectByUserIdWithDivisionAndMain(String userId);
	
	
	List<User2Division> selectAllLeadersExcludeUserId(String userId);
	
	List<User2Division> selectLeadersMainUserId(String userId);
	
	int countLeadersByDivisionId(String divisionId);

	int countLeadersByDivisionIdAndNotUserId(User2Division user2Division);
	
	int countByUserIdAndDivisionId(User2Division user2Division);
	
	int insert(User2Division record);

	int updateById(User2Division record);
	
	int updateByUserAndDivision(User2Division record);
	
	int updateMainIndexByUser(User2Division record);

	int deleteById(String id);

	void deleteByDivisionId(String divisionId);

	void deleteByUserId(String userId);
	
	User2Division selectLeadByUserId(User2Division user2Division);
	
	List<String> selectEmployeeByUserId(User2Division user2Division);
	
	/**
	 * 查询所有用户及部门
	 * @param user2Division
	 * @return
	 */
	List<User2Division> selectUser(User2Division user2Division);
	
	/**
	 * 查询所有用户及部门
	 * @param user2Division
	 * @return
	 */
	List<User2Division> selectUserByCondition(User2Division user2Division);
	
	/**
	 * 调用存储过程:根据用户编号取得下属所有基层员工
	 * @param userId
	 * @return
	 */
	List<String> callSelectEmpListbyLeadId(String userId);
	
	/**
	 * 根据用户权限查询用户可审批的部门
	 * @param uid
	 * @return
	 * @throws PmException
	 */
	List<User2Division> searchUserDivisionByPermission(User2Division user2Division); 


}