package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserInforImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 人员信息汇总
 * 作者:     Auto
 * 日期:     2014-03-31
**********************************************
*/
public interface UserInforService {
	/**
	 * 新增实体对象
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public UserInforImpl insert(UserInforImpl userInforImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public int delete(UserInforImpl userInforImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public boolean update(UserInforImpl userInforImpl) throws PmException;

	/**
	 * 查询实体列表
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public DataGrid<UserInforImpl> select(UserInforImpl userInforImpl) throws PmException;
	
	/**
	 * 查询实体列表
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public List<UserInforImpl> search(UserInforImpl userInforImpl) throws PmException;
	
	
	/**
	 * 查询实体映射
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public List<UserInforImpl> selectListMap(UserInforImpl userInforImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	public UserInforImpl get(UserInforImpl userInforImpl) throws PmException;
	
	/**
	 * 查询实体数量
	 * @param userInfor
	 */
	public Integer count(UserInforImpl userInforImpl) throws PmException;

}