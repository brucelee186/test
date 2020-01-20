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
package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;

/**
 * 邮件相关服务接口
 *
 * @author Bill.Qi
 * @version 1.0 2015-6-25 Bill.Qi created.
 * @version <ver>
 */
public interface IMailService {

	Mail add(Mail mail) throws PmException;

	Mail edit(Mail mail) throws PmException;

	Mail get(String id) throws PmException;

	void delete(String id) throws PmException;

	List<Mail> list(Mail mail, Page page) throws PmException;

	DataGrid<Mail> grid(Mail mail, Page page) throws PmException;

	DataGrid<Mail> gridWithoutContent(Mail mail, Page page) throws PmException;

	List<Mail> listUnsend(Page page) throws PmException;

	Mail addReimbursementReport(Mail mail) throws PmException;
}
