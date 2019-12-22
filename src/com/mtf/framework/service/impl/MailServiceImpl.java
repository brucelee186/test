/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.UUIDUtils;
import com.mtf.framework.dao.MailMapper;

@Service("mailService")
/*public class MailServiceImpl extends BaseService implements IMailService {*/
public class MailServiceImpl implements IMailService {

	private MailMapper				mailMapper;
	
	@Autowired
	public void setMailMapper(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}
	
	@Override
	public Mail add(Mail mail) throws PmException {
		// step 1 : check parameter(s)
		if (mail == null) {
			throw new PmException("Parameter mail is NULL.", 1);
		} else if (StringUtils.isBlank(mail.getTos())) {
			throw new PmException("Parameter mail.tos is NULL or Empty.", 1);
		} else if (StringUtils.isBlank(mail.getSubject())) {
			throw new PmException("Parameter mail.subject is NULL or Empty.", 1);
		} else if (StringUtils.isBlank(mail.getContent())) {
			throw new PmException("Parameter mail.content is NULL or Empty.", 1);
		}
		
		// step 3 : insert into db
		mail.setId(UUIDUtils.genUUID());
		mail.setCreateDateTime(new Date());
		mail.setStatus(Mail.STATUS_WAITTING);
		
		this.mailMapper.insert(mail);

		return mail;
	}
	
	@Override
	public Mail edit(Mail mail) throws PmException {
		// step 1 : check parameter(s)
		if (mail == null) {
			throw new PmException("Parameter mail is NULL.", 1);
		} else if (!UUIDUtils.isValidUUID(mail.getId())) {
			throw new PmException("Parameter mail.id is NULL or Empty.", 1);
		} else if (!NumberUtils.between(mail.getStatus(), 0, 2)) {
			throw new PmException("Parameter mail.status is NULL or Invalid.", 1);
		}
		
		// step 2 : check exists
		Mail dbMail = this.mailMapper.selectById(mail.getId());
		if (dbMail == null) {
			throw new PmException("Mail not found.", 2);
		}
		
		// step 4 : do update
		dbMail.setRetry(mail.getRetry());
		dbMail.setStatus(mail.getStatus());
		dbMail.setUpdateDateTime(new Date());
		dbMail.setMsg(mail.getMsg());
		this.mailMapper.updateById(dbMail);
		
		return dbMail;
	}
	
	@Override
	public Mail get(String id) throws PmException {
		// step 1 : check parameter(s)
		if (StringUtils.isBlank(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		Mail mail = this.mailMapper.selectById(id);
		return mail;
	}
	
	@Override
	public void delete(String id) throws PmException {
//		// step 1 : check parameter(s)
//		if (StringUtils.isBlank(id)) {
//			throw new PmException("Parameter id is NULL or Empty.", 1);
//		}
//		
//		// step 2 : check exists
//		Mail mail = this.mailMapper.selectById(id);
//		if (mail == null) {
//			throw new PmException("Mail not found.", 1);
//		}
//		
//		// step 3 : do delete
//		this.mailMapper.deleteById(id);
	}

	@Override
	public List<Mail> listUnsend(Page page) throws PmException {
		// step 2 : do search
		List<Mail> list = this.mailMapper.selectUnsend(page);
		if (list == null) {
			list = new ArrayList<Mail>();
		}
		
		return list;
	}

	@Override
	public List<Mail> list(Mail mail, Page page) throws PmException {
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "status");
			map.put("type", "type");
			map.put("retry", "retry");
			map.put("priority", "priority");
			map.put("createDateTime", "createDateTime");
			map.put("updateDateTime", "updateDateTime");
			
			page.generateOrderBy(map);
		}
		
		// step 2 : do search
		List<Mail> list = this.mailMapper.select(mail, page);
		if (list == null) {
			list = new ArrayList<Mail>();
		}
		
		return list;
	}

	@Override
	public DataGrid<Mail> grid(Mail mail, Page page) throws PmException {
		DataGrid<Mail> result = new DataGrid<Mail>();

		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "status");
			map.put("type", "type");
			map.put("retry", "retry");
			map.put("priority", "priority");
			map.put("createDateTime", "createDateTime");
			map.put("updateDateTime", "updateDateTime");
			
			page.generateOrderBy(map);
		}
		
		// step 2 : get count
		int count = this.mailMapper.count(mail);
		result.setTotal(count);
		
		// step 3 :  get detail
		if (count > 0) {
			List<Mail> list = this.mailMapper.select(mail, page);
			result.setRows(list);
		}
		return result;
	}

	@Override
	public DataGrid<Mail> gridWithoutContent(Mail mail, Page page) throws PmException {
		DataGrid<Mail> result = new DataGrid<Mail>();

		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("status", "status");
			map.put("type", "type");
			map.put("retry", "retry");
			map.put("priority", "priority");
			map.put("createDateTime", "createDateTime");
			map.put("updateDateTime", "updateDateTime");
			
			page.generateOrderBy(map);
		}
		
		// step 2 : get count
		int count = this.mailMapper.count(mail);
		result.setTotal(count);
		
		// step 3 :  get detail
		if (count > 0) {
			List<Mail> list = this.mailMapper.selectWithoutContent(mail, page);
			result.setRows(list);
		}
		return result;
	}
	
	@Override
	public Mail addReimbursementReport(Mail mail) throws PmException {
		// step 1 : check parameter(s)
		if (mail == null) {
			throw new PmException("Parameter mail is NULL.", 1);
		} else if (StringUtils.isBlank(mail.getTos())) {
			throw new PmException("Parameter mail.tos is NULL or Empty.", 1);
		} else if (StringUtils.isBlank(mail.getSubject())) {
			throw new PmException("Parameter mail.subject is NULL or Empty.", 1);
		} else if (StringUtils.isBlank(mail.getContent())) {
			throw new PmException("Parameter mail.content is NULL or Empty.", 1);
		}
		
		// step 3 : insert into db
		// mail bean
		mail.setId(UUIDUtils.genUUID());
		//mail.setType(Mail.TYPE_REIMBURSEMENTREPORT);
		mail.setPriority(Mail.PRIORITY_NORMAL);
		mail.setIsHtml(1);
		mail.setStatus(Mail.STATUS_WAITTING);
		mail.setRetry(0);
		mail.setCreateDateTime(new Date());
		//mail.setSubject("【申请采购单提醒】");
		
		//this.mailMapper.insert(mail);

		return mail;
	}
}
