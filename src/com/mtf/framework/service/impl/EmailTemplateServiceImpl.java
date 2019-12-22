package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.dao.EmailTemplateMapper;
import com.mtf.framework.model.impl.EmailTemplateImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.EmailTemplateService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 邮件
 * 作者:     Auto
 * 日期:     2015/5/27
**********************************************
*/
@Service("emailTemplateService")
public class EmailTemplateServiceImpl extends CommonServiceImpl implements EmailTemplateService {
	@Autowired
	private EmailTemplateMapper emailTemplateMapper;

	@Autowired
	public EmailTemplateMapper getEmailTemplateMapper() {
		return emailTemplateMapper;
	}

	@Autowired
	public void setEmailTemplateMapper(EmailTemplateMapper emailTemplateMapper) {
		this.emailTemplateMapper = emailTemplateMapper;
	}

	/**
	 * 新增实体对象
	 * @param emailTemplate
	 */
	public EmailTemplateImpl insert(EmailTemplateImpl emailTemplate) throws PmException {
		this.emailTemplateMapper.insert(emailTemplate);
		return emailTemplate;
	}

	/**
	 * 删除实体对象
	 * @param emailTemplate
	 */
	public int delete(EmailTemplateImpl emailTemplate) throws PmException {
		return this.emailTemplateMapper.delete(emailTemplate);
	}

	/**
	 * 更新实体对象
	 * @param emailTemplate
	 */
	public boolean update(EmailTemplateImpl emailTemplate) throws PmException {
		boolean result = true;
		this.emailTemplateMapper.update(emailTemplate);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param emailTemplate
	 */
	@SuppressWarnings("unchecked")
	public List<EmailTemplateImpl> select(EmailTemplateImpl emailTemplate) throws PmException {
		return (List<EmailTemplateImpl>) this.emailTemplateMapper.select(emailTemplate);
	}
	/**
	 * 查询单个实体
	 * @param emailTemplate
	 */
	public EmailTemplateImpl get(EmailTemplateImpl emailTemplate) throws PmException {
		return (EmailTemplateImpl) this.emailTemplateMapper.get(emailTemplate);
	}
	/**
	 * 查询实体分页列表
	 * @param emailTemplate
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<EmailTemplateImpl> search(EmailTemplateImpl emailTemplate) throws PmException {
		DataGrid<EmailTemplateImpl> grid = new DataGrid<EmailTemplateImpl>();
		Object obj = emailTemplate;
		List list = emailTemplateMapper.select(obj);
		grid.setRows(list);
		int count;
		count = emailTemplateMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}