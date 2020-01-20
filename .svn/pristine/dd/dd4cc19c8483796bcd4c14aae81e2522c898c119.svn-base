package com.mtf.office.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.model.User;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.page.EmailForm;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;



@Controller("controllerEmail")
@RequestMapping("/office/email")
public class ControllerEmail {
	
	private UserService			userService;
	
	@Autowired
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@RequestMapping("/toEdit")
	public ModelAndView toEdit(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("office/editEmail");
		return mv;
	}
	
	
	
	@RequestMapping("/doSend")
	@ResponseBody
	public Json toSend(EmailForm email,HttpSession session) throws Exception{
		Json j = new Json();
		int level = 0;
		// 将前台flag转化成level
		if(!"".equals(email.getFlag())){
			level = Integer.parseInt(email.getFlag());
		}
		List<UserImpl> listUser = userService.listUserEmail(level);
		// 将前台的邮箱插入到需要发送人列表中
		UserImpl adminUser = new UserImpl();
		adminUser.setEmail("ZoeXu@ManchuTimesFashion.com");
		adminUser.setDisplayName("徐婧祎");
		listUser.add(adminUser);
		for(User user:listUser){
			String dbEmail = user.getEmail();
			try {
				if (dbEmail.length()>4) {
					sendMail(dbEmail,user.getDisplayName() , email);
				}
			}
			catch (Exception e) {
				continue;
			}
		}
		j.setSuccess(true);
		return j;
	}
	
	
	
	
	public void sendMail(String mail, String username, EmailForm emails)
			throws EmailException {

		HtmlEmail email = new HtmlEmail();

		// 设置发送主机的服务器地址
		email.setHostName(CommonUtil.getConfig("serverEmail"));

		// 设置收件人邮箱
		email.addTo(mail, username);

		// 发件人邮箱
		email.setFrom(CommonUtil.getConfig("adminEmail"), "Admin");

		// 如果要求身份验证，设置用户名、密码，分别为发件人在邮件服务器上注册的用户名和密码
		email.setAuthentication("Admin", CommonUtil.getConfig("emailPwd"));

		// 设置邮件的主题
		email.setSubject(emails.getTheme());

		// 邮件正文消息
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append(emails.getContent());
		sb.append("</html>");
		email.setMsg(sb.toString());
		email.setCharset("UTF-8");
		email.send();
	}
}
