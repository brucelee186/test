package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.MailImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 邮件
 * 作者:     Auto
 * 日期:     2015/5/22
**********************************************
*/
public interface MailService {
	/**
	 * 新增实体对象
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public MailImpl insert(MailImpl mail) throws PmException;

	/**
	 * 删除实体对象
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public int delete(MailImpl mail) throws PmException;

	/**
	 * 更新实体对象
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public boolean update(MailImpl mail) throws PmException;

	/**
	 * 查询实体列表
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public List<MailImpl> select(MailImpl mail) throws PmException;

	/**
	 * 取得单一对象
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public MailImpl get(MailImpl mail) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	public DataGrid<MailImpl> search(MailImpl mail) throws PmException;

}