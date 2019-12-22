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
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.service.EmailService;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 邮件
 * 作者:    Auto
 * 日期:    2015/5/27
**********************************************
*/
@Controller("emailController")
@RequestMapping("/maintenance/email")
public class EmailController {

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

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/email/searchEmail");
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
	public DataGrid<EmailImpl> doSearch(EmailImpl email, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<EmailImpl> list = new DataGrid<EmailImpl>();
		list = this.emailService.search(email);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param email
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(EmailImpl email, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/maintenance/email/editEmail");
		String editState = email.getEditState();
		if ("u".equals(editState)) {
		email = emailService.get(email);
		}
		email.setEditState(editState);
		mv.addObject("email", email);
		return mv;
	}

	/**
	 * 编辑
	 * @param email
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(EmailImpl email, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = email.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(email, session);
				emailService.insert(email);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(email, session);
				emailService.update(email);
			} else if ("d".equals(editState)) {
				emailService.delete(email);
			}
			j.setSuccess(true);
			j.setObj(email);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

