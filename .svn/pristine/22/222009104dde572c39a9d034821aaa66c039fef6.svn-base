package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员信息表
 * 作者:     Auto
 * 日期:     2015/2/28
**********************************************
*/
public interface UserDetailService {
	/**
	 * 新增实体对象
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public UserDetailImpl insert(UserDetailImpl userDetail) throws PmException;

	/**
	 * 删除实体对象
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public int delete(UserDetailImpl userDetail) throws PmException;

	/**
	 * 更新实体对象
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public boolean update(UserDetailImpl userDetail) throws PmException;

	/**
	 * 查询实体列表
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public List<UserDetailImpl> select(UserDetailImpl userDetail) throws PmException;

	/**
	 * 取得单一对象
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public UserDetailImpl get(UserDetailImpl userDetail) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	public DataGrid<UserDetailImpl> search(UserDetailImpl userDetail) throws PmException;
	
	/**
	 * 插入用户主表及明细
	 * @param user
	 * @param userDetail
	 * @return
	 * @throws PmException
	 */
	UserDetailImpl inserUserDetail(UserImpl user, UserDetailImpl userDetail) throws PmException;

	/**
	 * 通过权限值查询用户列表
	 * @param permission
	 * @return
	 */
	List<UserDetailImpl> selectUserByPermissionCode(UserDetailImpl userDetail);
}