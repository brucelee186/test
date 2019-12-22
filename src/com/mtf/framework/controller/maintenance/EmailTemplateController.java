package com.mtf.framework.controller.maintenance;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.model.impl.EmailTemplateImpl;
import com.mtf.framework.service.EmailTemplateService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 邮件
 * 作者:    Auto
 * 日期:    2015/5/27
**********************************************
*/
@Controller("emailTemplateController")
@RequestMapping("/maintenance/emailTemplate")
public class EmailTemplateController {

	@Autowired
	private EmailTemplateService emailTemplateService;

	@Autowired
	public EmailTemplateService getEmailTemplateService() {
		return emailTemplateService;
	}

	@Autowired
	public void setEmailTemplateService(EmailTemplateService emailTemplateService) {
		this.emailTemplateService = emailTemplateService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/emailTemplate/searchEmailTemplate");
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<EmailTemplateImpl> doSearch(EmailTemplateImpl emailTemplate, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<EmailTemplateImpl> list = new DataGrid<EmailTemplateImpl>();
		list = this.emailTemplateService.search(emailTemplate);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param emailTemplate
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(EmailTemplateImpl emailTemplate, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/emailTemplate/editEmailTemplate");
		String editState = emailTemplate.getEditState();
		if ("u".equals(editState)) {
		emailTemplate = emailTemplateService.get(emailTemplate);
		}
		emailTemplate.setEditState(editState);
		mv.addObject("emailTemplate", emailTemplate);
		return mv;
	}

	/**
	 * 编辑
	 * @param emailTemplate
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(EmailTemplateImpl emailTemplate, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = emailTemplate.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(emailTemplate, session);
				emailTemplateService.insert(emailTemplate);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(emailTemplate, session);
				emailTemplateService.update(emailTemplate);
			} else if ("d".equals(editState)) {
				emailTemplateService.delete(emailTemplate);
			}
			j.setSuccess(true);
			j.setObj(emailTemplate);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

