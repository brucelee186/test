package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.impl.UserImpl;

public interface UserConditionMapper extends CommonMapper {

	int deleteById(String id);

	int insert(UserImpl record);

	UserImpl selectById(String id);

	int updateById(UserImpl record);

	int updatePhotoById(UserImpl record);

	int updatePasswordById(UserImpl user);

	UserImpl selectByIdAndPassword(UserImpl user);

	UserImpl selectByLoginnameAndPassword(UserImpl user);


	UserImpl selectByIdWithProfile(String id);
	UserImpl selectByIdWithRoles(String id);
	
	UserImpl selectByDivisionIdWithRoles(String id);

	List<UserImpl> selectByIdWithDivisions(String id);

	UserImpl selectByIdWithUser2Actions(String id);

	int countByLoginname(String loginName);//update 'loginName'

	List<UserImpl> selectByProfile(HashMap<String, Object> params);

	int countByProfile(HashMap<String, Object> params);

	List<UserImpl> selectByRoleId(HashMap<String, Object> params);

	int countByRoleId(HashMap<String, Object> params);

	List<UserImpl> selectByDivisionId(HashMap<String, Object> params);

	int countByDivisionId(HashMap<String, Object> params);

	List<UserImpl> selectByDivisionIdAndRoleId(HashMap<String, Object> params);

	int countByDivisionIdAndRoleId(HashMap<String, Object> params);
	
	List<UserImpl> selectAllAvailable(HashMap<String, Object> param);
	
	List<UserImpl> selectAllEnable(HashMap<String, Object> param);
	
	int countByEmail(String email);
	
	List<UserImpl> selectAllUserEmail(UserImpl user);
	
	void updateForApproveStatus(UserImpl user);
	
	UserImpl selectByLoginName(String loginName);
	
	UserImpl selectByDisplayName(String displayName);
	
	List<UserImpl> selectByDId(String divisionId);
	
	List<UserImpl> selectUserIdByCategoryId(String categoryId);
	
	List<UserImpl> selectUserIdByCategoryIdAndAmount(@Param("categoryId") String categoryId, @Param("pid") String pid, @Param("minPermissionAmount") double minPermissionAmount, @Param("codes") String[] codes);
	
	List<UserImpl> selectUserIdByCategoryIdAndLevel(@Param("categoryId") String categoryId, @Param("pid") String pid, @Param("reqLevel") int reqLevel, @Param("codes") String[] codes);
	
	List<UserImpl> selectByCategoryId(@Param("record")UserImpl record, @Param("categoryId") Integer categoryId);
	
	List<UserImpl> selectAdminByCategoryId(@Param("record")UserImpl record, @Param("categoryId") Integer categoryId, @Param("codes") String[] codes);
	
	int countAdminByCategoryId(@Param("categoryId") Integer categoryId, @Param("codes") String[] codes);
	
	List<UserImpl> selectAllAdminByCategoryId(@Param("codes") String[] codes);
	
	int countAdminByUserId(@Param("userId")String userId, @Param("codes") String[] codes);
	
	List<UserImpl> selectByCode(@Param("code") String code, @Param("amount") double amount);
	
	List<String> selectCategoryIdByUserIdAndCodes(@Param("userId") String userId, @Param("codes") String[] codes);
	
	List<UserImpl> selectSignerByCode(@Param("code") String code);
	
	List<UserImpl> selectUserByPermission(UserImpl user);
	
	
	List<UserImpl> selectForLeaderEmail(@Param("userId") String userId,@Param("rolesManagerIds") String[] rolesManagerIds);
	
	UserImpl getForEmail(UserImpl userParam);
}