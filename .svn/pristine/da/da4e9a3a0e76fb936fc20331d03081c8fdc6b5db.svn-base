package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.UserDivisionService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 员工部门中间表
 * 作者:     Auto
 * 日期:     2016/11/3
**********************************************
*/
@Service("userDivisionService")
public class UserDivisionServiceImpl extends CommonServiceImpl implements UserDivisionService {
	@Autowired
	private UserDivisionMapper userDivisionMapper;

	@Autowired
	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	@Autowired
	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
	}

	/**
	 * 新增实体对象
	 * @param userDivision
	 */
	public UserDivisionImpl insert(UserDivisionImpl userDivision) throws PmException {
		this.userDivisionMapper.insert(userDivision);
		return userDivision;
	}

	/**
	 * 删除实体对象
	 * @param userDivision
	 */
	public int delete(UserDivisionImpl userDivision) throws PmException {
		return this.userDivisionMapper.delete(userDivision);
	}

	/**
	 * 更新实体对象
	 * @param userDivision
	 */
	public boolean update(UserDivisionImpl userDivision) throws PmException {
		boolean result = true;
		this.userDivisionMapper.update(userDivision);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param userDivision
	 */
	@SuppressWarnings("unchecked")
	public List<UserDivisionImpl> select(UserDivisionImpl userDivision) throws PmException {
		return (List<UserDivisionImpl>) this.userDivisionMapper.select(userDivision);
	}
	/**
	 * 查询单个实体
	 * @param userDivision
	 */
	public UserDivisionImpl get(UserDivisionImpl userDivision) throws PmException {
		return (UserDivisionImpl) this.userDivisionMapper.get(userDivision);
	}
	/**
	 * 查询实体分页列表
	 * @param userDivision
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<UserDivisionImpl> search(UserDivisionImpl userDivision) throws PmException {
		DataGrid<UserDivisionImpl> grid = new DataGrid<UserDivisionImpl>();
		Object obj = userDivision;
		List list = userDivisionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = userDivisionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}