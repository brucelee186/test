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
package com.mtf.framework.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.MailUtils;

@Component("taskUpdateUser")
public class TaskUpdateUser {
	
	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private UserDetailMapper userDetailMapper;

	@Autowired
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	@Autowired
	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	@Autowired
	public UserDetailService getUserDetailService() {
		return userDetailService;
	}

	@Autowired
	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	public void run() {
		try {
			// 更新司龄
			UserDetailImpl userDetail = new UserDetailImpl();
			userDetail.setTagMapper("taskUpdateUserSeniority");
			userDetailService.update(userDetail);
			// 更新年龄
			userDetail.setTagMapper("taskUpdateUserAge");
			userDetailService.update(userDetail);
			// 更新用户唯一姓名
			userDetail.setTagMapper("taskUpdateUserUniqueName");
			userDetailService.update(userDetail);
		} catch (PmException e) {
			e.printStackTrace();
		}
		
	}
}