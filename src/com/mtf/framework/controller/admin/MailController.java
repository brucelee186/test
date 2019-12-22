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
package com.mtf.framework.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.MailUtils;
import com.mtf.framework.util.UUIDUtils;

/**
 * 邮件日志相关入口控制器
 *
 * @author Wade.Zhu
 * @version 1.0	2014-03-11	Wade.Zhu		created.
 * @version <ver>
 */
@Controller("adminMailController")
@RequestMapping("/admin/mail")
public class MailController extends BaseController {

	private IMailService		mailService;
	
	@Autowired
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}
	
	/**
	 * 跳转到搜索Mail页面
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public String toSearch() throws PmException {
		return "admin/system/mail";
	}
	
	/**
	 * 执行搜索Mail操作，返回DataGrid
	 * @param mail
	 * @param page
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<Mail> doSearch(Mail mail, Page page) throws PmException {
		DataGrid<Mail> result = null;
		try {
			result = this.mailService.gridWithoutContent(mail, page);
		} catch (PmException e) {
			List<Message> errList = new ArrayList<>();
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return result;
	}
	
	/**
	 * 跳转到编辑Mail页面
	 * @param id
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(String id) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		// validate
		if (!UUIDUtils.isValidUUID(id)) {
			throw new PmException();
		}
		// process
		Mail mail = null;
		try {
			mail = this.mailService.get(id);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		if (mail == null) {
			errList.add(new Message("邮件"));
			throw new PmException(0, errList);
		}
		ModelAndView mv = new ModelAndView("admin/mail/edit");
		mv.addObject("mail", mail);
		return mv;
	}
	
	/**
	 * 执行编辑Mail操作，返回Json
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(Mail mail) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		// validate
		if (!UUIDUtils.isValidUUID(mail.getId())) {
			throw new PmException();
		}
		
		// process
		try {
			this.mailService.edit(mail);
			j.setSuccess(true);
			j.setObj(mail);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doGet", method=RequestMethod.POST)
	@ResponseBody
	public Json doGet(Mail mail) throws PmException {
		Json j = new Json();
		try {
			mail = this.mailService.get(mail.getId());
			if (mail != null) {
				j.setSuccess(true);
				j.setObj(mail);
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	/**
	 * 执行发送Mail操作，返回Json
	 * @param mail
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doSend", method=RequestMethod.POST)
	@ResponseBody
	public Json doSend(Mail mail) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		// validate
		if (!UUIDUtils.isValidUUID(mail.getId())) {
			throw new PmException();
		}
		
		// process
		try {
			mail = this.mailService.get(mail.getId());
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		if (mail == null) {
			errList.add(new Message("mail"));
			throw new PmException(0, errList);
		}

		//boolean isSysRelMode = StringUtils.equalsIgnoreCase("r", CommonUtil.getConfig("tagTest"));
		// 修改为绑定物理网卡方式判断
		boolean isSysRelMode = CommonUtil.getTrueSys();
		String[] devMailList = {
				"wadezhu@manchutimesfashion.com",
				"sunshouren@manchutimesfashion.com",
				"billqi@manchutimesfashion.com",
				"neoyin@manchutimesfashion.com",
				"johnnytan@manchutimesfashion.com",
				"suzieli@manchutimesfashion.com",
				"joezhou@manchutimesfashion.com"
		};
		String[] tosArr = null;
		String[] ccsArr = null;
		String[] bccsArr = null;
		if (!StringUtils.isBlank(mail.getTos())) {
			tosArr = mail.getTos().split(";");
			if (!isSysRelMode) {
				for (int i = 0; i < tosArr.length; i ++) {
					String to = tosArr[i];
					boolean skip = false;
					for (String dm : devMailList) {
						if (StringUtils.equalsIgnoreCase(to,  dm)) {
							skip = true;
							break;
						}
					}
					if (!skip) {
						tosArr[i] = to.replaceAll("@", "_test@");
					}
				}
			}
		}
		if (!StringUtils.isBlank(mail.getCcs())) {
			ccsArr = mail.getCcs().split(";");
			if (!isSysRelMode) {
				for (int i = 0; i < ccsArr.length; i ++) {
					String cc = ccsArr[i];
					boolean skip = false;
					for (String dm : devMailList) {
						if (StringUtils.equalsIgnoreCase(cc,  dm)) {
							skip = true;
							break;
						}
					}
					if (!skip) {
						ccsArr[i] = cc.replaceAll("@", "_test@");
					}
				}
			}
		}
		if (!StringUtils.isBlank(mail.getBccs())) {
			bccsArr = mail.getBccs().split(";");
			if (!isSysRelMode) {
				for (int i = 0; i < bccsArr.length; i ++) {
					String bcc = bccsArr[i];
					boolean skip = false;
					for (String dm : devMailList) {
						if (StringUtils.equalsIgnoreCase(bcc,  dm)) {
							skip = true;
							break;
						}
					}
					if (!skip) {
						bccsArr[i] = bcc.replace("@", "_test@");
					}
				}
			}
		}
		
		if (!isSysRelMode) {
			String subject = mail.getSubject();
			subject = "[TEST]" + subject;
			mail.setSubject(subject);
			
			String content = mail.getContent();
			if (mail.getIsHtml() == 1) {
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
			mail.setContent(content);
		}
		
		String[] extFiles = null;
		if(mail.getExtFile() != null){
			extFiles = mail.getExtFile().split(";");
		}
		try {
			MailUtils.sendMail(tosArr, ccsArr, bccsArr, mail.getSubject(), mail.getContent(), mail.getIsHtml() == 1, mail.getPriority(), extFiles, null);
			mail.setStatus(mail.STATUS_SENT);
			
			j.setSuccess(true);
		} catch (Exception e) {
			mail.setRetry(mail.getRetry() + 1);
			mail.setMsg(e.getMessage());
			mail.setStatus(Mail.STATUS_FAILED);
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		}
		j.setObj(mail);
		this.mailService.edit(mail);
		return j;
	}
	
	/**
	 * 执行删除Mail操作，返回Json
	 * @param id
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doDelete", method=RequestMethod.POST)
	@ResponseBody
	public Json doDelete(String id) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		// validate
		if (!UUIDUtils.isValidUUID(id)) {
			throw new PmException();
//			errList.add(new Message("id", genRequiredParameterMessageByValue("邮件ID")));
		}
//		if (!errList.isEmpty()) {
//			throw new PmException(0, errList);
//		}
		Json j = new Json();
		
		// process
		try {
			this.mailService.delete(id);
			j.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	/***
	 * 下载文件
	 * 
	 * @param request
	 * @param response
	 * @param storeFile
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toDownload")
	@ResponseBody
	public void toDownload(String filename) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		if (StringUtils.isBlank(filename)) {
			errList.add(new Message());
			throw new PmException(0, errList);
		}

		String fullPath = filename;

		File file = new File(fullPath);
		if (!file.exists()) {
			errList.add(new Message("文件不存在."));
			throw new PmException(0, errList);
		}

		try {
			responseFile(file);
		} catch (IOException e) {
			errList.add(new Message("文件读取失败."));
			throw new PmException(0, errList);
		}
	}
}
