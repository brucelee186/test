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

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.MailUtils;

@Component("taskMailSend")
public class TaskMailSend {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void run() {
			try {
				EmailImpl email  = new EmailImpl();
				// 状态(已经发送 s:sended,未发送 u:unsend)
				email.setStatusSend("u");
				email = emailService.get(email);
				if (null != email) {
					Long id = email.getId();
					EmailImpl emailTemp  = new EmailImpl();
					if (null != id) {
						emailTemp.setStatusSend("s");
						emailTemp.setId(id);
						String emailTest = email.getReceiver();
						boolean isEmail = CommonUtil.isEmail(emailTest);
						//isEmail = false;
						if (isEmail) {
							// 取得模板
							
							HtmlEmail mailHtml = new HtmlEmail();
							
							// 设置发送主机的服务器地址
							mailHtml.setHostName(CommonUtil.getConfig("serverEmail"));
							mailHtml.setSmtpPort(465);
							
							// 设置收件人邮箱
							// String receiver = "neoyin@ManchuTimesFashion.com";
							String receiver = CommonUtil.getConfig("testEmail");
							String theme = email.getTheme();
							// 是否为测试系统 t:test测试系统,r:real 真实系统
							if (CommonUtil.getTrueSys()) {
								receiver = email.getReceiver();
							} else {
								theme = "测试/" + theme + email.getReceiver();
							}
							email.setTheme(theme);
							mailHtml.addTo(receiver, email.getReceiverName());
							
							// 发件人邮箱
							mailHtml.setFrom(CommonUtil.getConfig("adminEmail"), CommonUtil.getConfig("emailLogin"));
							
							// 如果要求身份验证，设置用户名、密码，分别为发件人在邮件服务器上注册的用户名和密码
							mailHtml.setAuthentication(CommonUtil.getConfig("emailLogin"), CommonUtil.getConfig("emailPwd"));
							
							// 设置邮件的主题
							mailHtml.setSubject(email.getTheme());
							
							// 邮件正文消息
							StringBuffer sb = new StringBuffer();
							sb.append("<html>");
							sb.append(email.getContent());
							sb.append("</html>");
							mailHtml.setMsg(sb.toString());
							mailHtml.setCharset("UTF-8");
							//String tagTest = CommonUtil.getConfig("tagTest");
							//# 测试系统是否发送邮件(可以发送y,不可以n)
							String tagSendEmail = CommonUtil.getConfig("tagSendEmail");
							if ("y".equals(tagSendEmail)) {
								mailHtml.send();
							}
							emailService.update(emailTemp);
						}
					}
					}
			} catch (PmException e) {
				e.printStackTrace();
			} catch (EmailException e) {
				e.printStackTrace();
			}
		
	}
}