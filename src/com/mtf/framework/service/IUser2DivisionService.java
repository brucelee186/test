package com.mtf.framework.service;

import java.util.List;
import java.util.Map;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.impl.OrderCategoryImpl;
import com.mtf.framework.model.impl.User2DivisionImpl;
import com.mtf.framework.model.impl.UserImpl;

public interface IUser2DivisionService {

	/**
	 * 根据用户ID查询所属部门列表<br>
	 * 查询已有Leader的部门（用户ID是Leader的部门除外）
	 * @param uid 系统登陆用户ID
	 * @param userId 用户ID
	 * @return 用户部门列表Map<br>
	 * 		   key：userDivisions 用户所属部门列表<br>
	 *		   key：hasLeaderDivisions 已有Leader的部门列表
	 * @throws PmException
	 */
	Map<String,List<User2Division>> listByUserId(String uid, String userId) throws PmException;
	
	/**
	 * 根据部门ID查询部门用户列表<br>
	 * @param uid 系统登陆用户ID
	 * @param divisionId 部门ID
	 * @return 部门用户列表<br>
	 * @throws PmException
	 */
	List<User2Division> listByDivisionIdWithUser(String uid, String divisionId) throws PmException;
	
	/**
	 * 根据部门ID查询部门用户列表<br>
	 * @return 部门用户列表<br>
	 * @throws PmException
	 */
	List<User2Division> listByDivisionIdWithUser(UserImpl user) throws PmException;

	/**
	 * 编辑用户部门
	 * 
	 * @param uid 系统登陆用户ID
	 * @param userId 被编辑的用户ID
	 * @param divisionIds 用户所属部门ID列表
	 * @param leaderIds 所在部门属于Leader的部门ID列表
	 * @param mainIndex 标记是否为主部门
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tr><td>参数错误</td><td>1</td><td>Parameter userId is NULL or Empty.</td></tr>
	 * <tr><td>用户不存在</td><td>2</td><td>User not found.</td></tr>
	 * <tr><td>部门领导已经存在</td><td>3</td><td>Division leader already exists.</td></tr>
	 * <tr><td>部门不存在</td><td>4</td><td>Division not found.</td></tr>
	 * </table>
	 */
	void edit(String uid, String userId, String[] divisionIds, String[] leaderIds,String mainIndex, String tag) throws PmException;
	
	/**
	 * 添加新用户
	 * <p>添加成功，则返回用户id</p>
	 * 
	 * @param uid 操作用户
	 * @param user2division
	 * @return 
	 * @throws PmException
	 * 
	 * <p>异常代码参考表：</p>
	 * <table border="1px">
	 * <tr><th>Case</th><th>code</th><th>msg</th></tr>
	 * <tbody>
	 * <tr><td>用户行为已存在</td><td>2</td><td>User action rule already exists.</td></tr>
	 * </tbody>
	 * </table>
	 */
	User2Division add(String uid, User2Division user2division) throws PmException;
	
	/**
	 * 删除新用户
	 * 
	 * @param uid 操作用户
	 * @param 部门用户表ID
	 * @return 
	 * @throws PmException
	 */
	void delete(String uid, String id) throws PmException;

	/**
	 * 根据UID查询部门用户列表<br>
	 * @param uid 系统登陆用户ID
	 * @param divisionId 部门ID
	 * @return 部门用户列表<br>
	 * @throws PmException
	 */
	List<User2Division> listByDivisionIdWithUserId(String uid) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param user2Division
	 * @return
	 * @throws PmException
	 */
	public List<User2Division> select(User2Division user2Division) throws PmException;

}
