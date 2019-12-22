package com.mtf.framework.service;

import java.util.List;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.EmailTemplateImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 邮件
 * 作者:     Auto
 * 日期:     2015/5/27
**********************************************
*/
public interface EmailTemplateService {
	/**
	 * 新增实体对象
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public EmailTemplateImpl insert(EmailTemplateImpl emailTemplate) throws PmException;

	/**
	 * 删除实体对象
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public int delete(EmailTemplateImpl emailTemplate) throws PmException;

	/**
	 * 更新实体对象
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public boolean update(EmailTemplateImpl emailTemplate) throws PmException;

	/**
	 * 查询实体列表
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public List<EmailTemplateImpl> select(EmailTemplateImpl emailTemplate) throws PmException;

	/**
	 * 取得单一对象
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public EmailTemplateImpl get(EmailTemplateImpl emailTemplate) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param emailTemplate
	 * @return
	 * @throws PmException
	 */
	public DataGrid<EmailTemplateImpl> search(EmailTemplateImpl emailTemplate) throws PmException;

}