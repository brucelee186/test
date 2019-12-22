package com.mtf.framework.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserSelecterImpl;
import com.mtf.framework.dao.UserSelecterMapper;
import com.mtf.framework.model.UserSelecter;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.UserSelecterService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 人员选择选项表
 * 作者:     Auto
 * 日期:     2014-03-03
**********************************************
*/
@Service("userSelecterService")
public class UserSelecterServiceImpl extends CommonServiceImpl implements UserSelecterService {
	@Autowired
	private UserSelecterMapper userSelecterMapper;

	@Autowired
	public UserSelecterMapper getUserselecterMapper() {
		return userSelecterMapper;
	}

	@Autowired
	public void setUserselecterMapper(UserSelecterMapper userSelecterMapper) {
		this.userSelecterMapper = userSelecterMapper;
	}

	/**
	 * 新增实体对象
	 * @param userSelecter
	 */
	public UserSelecterImpl insert(UserSelecterImpl userSelecterImpl) throws PmException {
		this.userSelecterMapper.insert(userSelecterImpl);
		return userSelecterImpl;
	}

	/**
	 * 删除实体对象
	 * @param userSelecter
	 */
	public int delete(UserSelecterImpl userSelecterImpl) throws PmException {
		return this.userSelecterMapper.delete(userSelecterImpl);
	}

	/**
	 * 更新实体对象
	 * @param userSelecter
	 */
	public boolean update(UserSelecterImpl userSelecterImpl) throws PmException {
		boolean result = true;
		this.userSelecterMapper.update(userSelecterImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param userSelecter
	 */
	public UserSelecterImpl get(UserSelecterImpl userSelecterImpl) throws PmException {
		return (UserSelecterImpl) this.userSelecterMapper.get(userSelecterImpl);
	}
	/**
	 * 查询实体列表
	 * @param userSelecter
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<UserSelecterImpl> select(UserSelecterImpl userSelecterImpl) throws PmException {
		DataGrid<UserSelecterImpl> grid = new DataGrid<UserSelecterImpl>();
		Object obj = userSelecterImpl;
		List list = userSelecterMapper.select(obj);
		grid.setRows(list);
		int count;
		count = userSelecterMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}