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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.MailUtils;

@Component("mailSendTask")
public class MailSendTask {
	
	private static final Logger		logger	= Logger.getLogger(MailSendTask.class);

	private boolean					isSysRelMode = false;
	private String[]				devMailList = null;

	private IMailService			mailService;
	
	@Autowired
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}
	
	public MailSendTask() {
		//this.isSysRelMode = StringUtils.equalsIgnoreCase("r", CommonUtil.getConfig("tagTest"));
		// 变更为绑定物理网卡形式
		
		this.isSysRelMode = CommonUtil.getTrueSys();
		this.devMailList = new String[] {
				"wadezhu@manchutimesfashion.com",
				"billqi@manchutimesfashion.com",
				"neoyin@manchutimesfashion.com",
				"suzieli@manchutimesfashion.com"
		};
	}
	
	private String preSubject(String subject) {
		if (isSysRelMode) {
			return subject;
		}
		return "[TEST]" + subject;
	}
	
	private String preContent(String content, boolean isHtml) {
		if (isSysRelMode) {
			return content;
		}
		if (isHtml) {
			String suffix = "<br /><br />\r\n"
							+ "-------------------------------------------------------<br />\r\n"
							+ "Please note:<br />\r\n"
							+ "this mail is sent by the <span style=\"color:red\">TEST</span> System, the content is meaningless, please ignore.<br />\r\n"
							+ "-------------------------------------------------------<br />\r\n";
			
			content = content.replace("</body>", suffix + "</body>");
		} else {
			content = content 
					+ "\r\n\r\n-------------------------------------------------------\r\n"
					+ "Please note:\r\n"
					+ "this mail is sent by the TEST System, the content is meaningless, please ignore.\r\n"
					+ "-------------------------------------------------------";
		}
		return content;
	}
	
	private void preAddress(String[] mailArr) {
		if (isSysRelMode) {
			return;
		}
		if (mailArr == null) {
			return;
		}
		for (int i = 0; i < mailArr.length; i ++) {
			String m = mailArr[i];
			boolean skip = false;
			for (String dm : devMailList) {
				if (StringUtils.equalsIgnoreCase(m,  dm)) {
					skip = true;
					break;
				}
			}
			if (!skip) {
				mailArr[i] = m.replaceAll("@", "_test@");
			}
		}
		
	}
	
	public void run() {
		//String tagTest = CommonUtil.getConfig("tagTest");
		// 变更为绑定物理网卡形式
		if (CommonUtil.getTrueSys()) {
			Page page = new Page();
			page.setPage(1);
			page.setRows(5); // 邮件服务器设定的默认收发速度是每分钟5封
			
			try {
				List<Mail> mailList = this.mailService.listUnsend(page);
				if (mailList == null || mailList.isEmpty()) {
					return;
				}
				
				for (Mail m : mailList) {
					try {
						String[] toArr = m.getToArr();
						String[] ccArr = m.getCcArr();
						String[] bccArr = m.getBccArr();
						String subject = m.getSubject();
						String content = m.getContent();
						boolean isHtml = m.getIsHtml() == 1;
						Integer priority = m.getPriority();
						String[] extFileArr = m.getExtFileArr();
						
						preAddress(toArr);
						preAddress(ccArr);
						preAddress(bccArr);
						subject = preSubject(subject);
						content = preContent(content, isHtml);
						
						try {
							MailUtils.sendMail(toArr, ccArr, bccArr, subject, content, isHtml, priority, extFileArr, null);
							m.setStatus(Mail.STATUS_SENT);
						} catch (Exception e) {
							m.setRetry(m.getRetry() + 1);
							m.setMsg(e.getMessage());
							if (m.getRetry().intValue() >= 2) {
								m.setStatus(Mail.STATUS_FAILED);
							}
							logger.warn("Send mail Failed [id=" + m.getId() + ", retry=" + m.getRetry() + "]");
						}
						m.setUpdateDateTime(new Date());
						
						//this.mailService.edit(m);
					} catch (Exception ex) {
						logger.error(ex);
					}
					//编辑
					this.mailService.edit(m);
				}
			} catch(PmException e) {
				logger.error(e);
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}
}