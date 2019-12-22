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
package com.mtf.framework.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;

/**
 * 邮件发送工具类
 *
 * @author Wade.Zhu
 * @version 1.0	2013-11-29	Wade.Zhu		created.
 * @version <ver>
 */
public class MailUtils {
	private static final Logger	logger	= Logger.getLogger(MailUtils.class);

	/**
	 * 发送纯文本邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String to, String subject, String content) throws Exception {
		sendMail(new String[] { to }, null, null, subject, content, false, 0, null, null);
	}
	/**
	 * 发送纯文本邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param content 文本
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String to, String subject, String content, int priority) throws Exception {
		sendMail(new String[] { to }, null, null, subject, content, false, priority, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param to 收件人
	 * @param cc 抄送人
	 * @param subject 主题
	 * @param content 文本
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String to, String cc, String subject, String content, int priority) throws Exception {
		sendMail(new String[] { to }, new String[] { cc }, null, subject, content, false, priority, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param to 收件人
	 * @param ccs 抄送人列表
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String to, String[] ccs, String subject, String content) throws Exception {
		sendMail(new String[] { to }, ccs, null, subject, content, false, 0, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param to 收件人
	 * @param cc 抄送人
	 * @param bcc 密送人
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String to, String cc, String bcc, String subject, String content) throws Exception {
		sendMail(new String[] { to }, new String[] { cc }, new String[] { bcc }, subject, content, false, 0, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param tos 收件人列表
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String[] tos, String subject, String content) throws Exception {
		sendMail(tos, null, null, subject, content, false, 0, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param tos 收件人列表
	 * @param cc 抄送人
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String[] tos, String cc, String subject, String content) throws Exception {
		sendMail(tos, new String[] { cc }, null, subject, content, false, 0, null, null);
	}

	/**
	 * 发送纯文本邮件
	 * @param tos 收件人列表
	 * @param ccs 抄送人列表
	 * @param subject 主题
	 * @param content 文本
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendTextMail(String[] tos, String[] ccs, String subject, String content) throws Exception {
		sendMail(tos, ccs, null, subject, content, false, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param html HTML内容
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String to, String subject, String html, int priority) throws Exception {
		sendMail(new String[] { to }, null, null, subject, html, true, priority, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param to 收件人
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String to, String subject, String html) throws Exception {
		sendMail(new String[] { to }, null, null, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param to 收件人
	 * @param cc 抄送人
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String to, String cc, String subject, String html) throws Exception {
		sendMail(new String[] { to }, new String[] { cc }, null, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param to 收件人
	 * @param ccs 抄送人列表
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String to, String[] ccs, String subject, String html) throws Exception {
		sendMail(new String[] { to }, ccs, null, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param to 收件人
	 * @param cc 抄送人
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String to, String cc, String bcc, String subject, String html) throws Exception {
		sendMail(new String[] { to }, new String[] { cc }, new String[] { bcc }, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param tos 收件人列表
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String[] tos, String subject, String html) throws Exception {
		sendMail(tos, null, null, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param tos 收件人列表
	 * @param cc 抄送人
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String[] tos, String cc, String subject, String html) throws Exception {
		sendMail(tos, new String[] { cc }, null, subject, html, true, 0, null, null);
	}

	/**
	 * 发送HTML邮件
	 * @param tos 收件人列表
	 * @param ccs 抄送人列表
	 * @param subject 主题
	 * @param html HTML内容
	 * @return 发送是否成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendHtmlMail(String[] tos, String[] ccs, String subject, String html) throws Exception {
		sendMail(tos, ccs, null, subject, html, true, 0, null, null);
	}
	
	/**
	 * 发送邮件
	 * @param tos 收件人地址列表
	 * @param ccs 抄送人地址列表
	 * @param bccs 密送人地址列表
	 * @param subject 主题
	 * @param content 内容
	 * @param isHtml 内容是否未HTML格式
	 * @param extFiles 附件（仅当isHtml=true时有效）
	 * @return 是否发送成功
	 * @throws Exception 
	 * @see MailUtils#sendMail(String[], String[], String[], String, String, boolean, int, String)
	 */
	public static void sendMail(String[] tos, String[] ccs, String[] bccs, String subject, String content, boolean isHtml, String[] extFiles) throws Exception {
		sendMail(tos, ccs, bccs, subject, content, isHtml, 0, extFiles, null);
	}
	
	/**
	 * 发送邮件
	 * @param tos 收件人地址列表
	 * @param ccs 抄送人地址列表
	 * @param bccs 密送人地址列表
	 * @param subject 主题
	 * @param content 内容
	 * @param isHtml 内容是否未HTML格式
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @param extFiles 附件（仅当isHtml=true时有效）
	 * @return 是否发送成功
	 * @throws Exception 
	 */
	public static void sendMail(String[] tos, String[] ccs, String[] bccs, String subject, String content, boolean isHtml, Integer priority, String[] extFiles, String[] extFileAlias) throws Exception {
		String host = ConfigUtil.getMailSmtpHost();
		String port = ConfigUtil.getMailSmtpPort();
		boolean auth = ConfigUtil.getMailSmtpAuth();
		String uid = ConfigUtil.getMailSmtpUid();
		String pwd = ConfigUtil.getMailSmtpPwd();
		String from = ConfigUtil.getMailSmtpFrom();
		
		sendMail(host, port, auth, uid, pwd, from, tos, ccs, bccs, subject, content, isHtml, priority, extFiles, extFileAlias);
	}
	
	/**
	 * 发送邮件
	 * @param sender 发件人邮箱
	 * @param tos 收件人地址列表
	 * @param ccs 抄送人地址列表
	 * @param bccs 密送人地址列表
	 * @param subject 主题
	 * @param content 内容
	 * @param isHtml 内容是否未HTML格式
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @param extFiles 附件（仅当isHtml=true时有效）
	 * @return 是否发送成功
	 * @throws Exception 
	 */
	public static void sendMail(String sender, String[] tos, String[] ccs, String[] bccs, String subject, String content, boolean isHtml, Integer priority, String[] extFiles, String[] extFileAlias) throws Exception {
		String host = ConfigUtil.getMailSmtpHost();
		String port = ConfigUtil.getMailSmtpPort();
		boolean auth = ConfigUtil.getMailSmtpAuth();
		String uid = ConfigUtil.getMailSmtpUid();
		String pwd = ConfigUtil.getMailSmtpPwd();
		
		sendMail(host, port, auth, uid, pwd, sender, tos, ccs, bccs, subject, content, isHtml, priority, extFiles, extFileAlias);
	}
	
	/**
	 * 发送邮件
	 * @param host SMTP服务器地址
	 * @param port SMTP服务器端口
	 * @param auth SMTP服务器是否需要严重
	 * @param uid SMTP用户名（auth=true）
	 * @param pwd SMTP密码（auth=true）
	 * @param tos 收件人地址列表
	 * @param ccs 抄送人地址列表
	 * @param bccs 密送人地址列表
	 * @param subject 主题
	 * @param content 内容
	 * @param isHtml 内容是否未HTML格式
	 * @param priority 优先级（0：默认；1：最高；3：普通；5：最低）
	 * @param extFiles 附件（仅当isHtml=true时有效）
	 * @return 是否发送成功
	 * @throws Exception 
	 */
	public static void sendMail(final String host, final String port, final boolean auth, final String uid, final String pwd, final String from, final String[] tos, final String[] ccs, final String[] bccs, final String subject, final String content, final boolean isHtml, final Integer priority, final String[] extFiles, final String[] extFileAlias) throws Exception {
		if ((tos == null || tos.length == 0)
			&& (ccs == null || ccs.length == 0)
			&& (bccs == null || bccs.length == 0)) {
			return;
		}
		try {
			Authenticator authenticator = null;
			Properties pro = new Properties();
			pro.put("mail.smtp.host", host);
			pro.put("mail.smtp.port", port);
			pro.put("mail.smtp.auth", auth);
			if (auth) {
				// 如果需要身份认证，则创建一个密码验证器
				authenticator = new Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(uid, pwd);
					}
				};
			}
			// 根据邮件会话属性和密码验证器构造一个发送邮件的session
			Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
			// 根据session创建一个邮件消息
			Message mailMessage = new MimeMessage(sendMailSession);
			// 创建邮件发送者地址
			Address fromAddress = new InternetAddress(from);
			// 设置邮件消息的发送者
			mailMessage.setFrom(fromAddress);
			// 创建邮件的接收者地址，并设置到邮件消息中
			if (tos != null && tos.length > 0) {
				if (tos.length == 1) {
					// 创建邮件的接收者地址，并设置到邮件消息中
					Address toAddress = new InternetAddress(tos[0].trim());
					mailMessage.setRecipient(Message.RecipientType.TO, toAddress);
				} else {
					Address[] tosAddress = new InternetAddress[tos.length];
					for (int i = 0; i < tos.length; i ++) {
						tosAddress[i] = new InternetAddress(tos[i].trim());
					}
					mailMessage.setRecipients(Message.RecipientType.TO, tosAddress);
				}
			}
			// 创建邮件的抄送者地址，并设置到邮件消息中
			if (ccs != null && ccs.length > 0) {
				if (ccs.length == 1) {
					// 创建邮件的接收者地址，并设置到邮件消息中
					Address ccAddress = new InternetAddress(ccs[0]);
					mailMessage.setRecipient(Message.RecipientType.CC, ccAddress);
				} else {
					Address[] ccsAddress = new InternetAddress[ccs.length];
					for (int i = 0; i < ccs.length; i ++) {
						ccsAddress[i] = new InternetAddress(ccs[i]);
					}
					mailMessage.setRecipients(Message.RecipientType.CC, ccsAddress);
				}
			}
			// 创建邮件的密送者地址，并设置到邮件消息中
			if (bccs != null && bccs.length > 0) {
				if (bccs.length == 1) {
					// 创建邮件的接收者地址，并设置到邮件消息中
					Address bccAddress = new InternetAddress(bccs[0]);
					mailMessage.setRecipient(Message.RecipientType.BCC, bccAddress);
				} else {
					Address[] bccsAddress = new InternetAddress[bccs.length];
					for (int i = 0; i < bccs.length; i ++) {
						bccsAddress[i] = new InternetAddress(bccs[i]);
					}
					mailMessage.setRecipients(Message.RecipientType.BCC, bccsAddress);
				}
			}
			// 设置邮件消息的主题
			mailMessage.setSubject(subject);
			// 设置邮件消息的主要内容
			// HTML格式
			if (isHtml) {
				// MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
				Multipart mainPart = new MimeMultipart();
				// 创建一个包含HTML内容的MimeBodyPart
				BodyPart html = new MimeBodyPart();
				// 添加附件
				if(extFiles != null) {
					addTach(extFiles, extFileAlias, mainPart);
				}
				// 设置HTML内容
				html.setContent(content, "text/html; charset=utf-8");
				mainPart.addBodyPart(html);
				// 将MiniMultipart对象设置为邮件内容
				mailMessage.setContent(mainPart);
			}
			// 纯文本格式
			else {
				mailMessage.setText(content);
			}
			// 设置邮件优先级
			if (priority != null && priority.intValue() > 0) {
				int pri = priority;
				if (priority > 5) pri = 5;
				mailMessage.setHeader("X-Priority", "" + pri);
			}
			// 设置邮件消息发送的时间
			mailMessage.setSentDate(new Date());
			// 发送邮件
			Transport.send(mailMessage);
		} catch (Exception ex) {
			logger.error(ex);
			throw ex;
		}
	}
	
	public static String formatContent(String src, Object... params) {
		if (src != null && params != null && params.length > 0) {
			for (int i = 0; i < params.length; i ++) {
				src = src.replaceAll("<vega>" + i + "</vega>", params[i] == null ? "null" : StringEscapeUtils.escapeHtml(params[i].toString()));
			}
		}
		return src;
	}
	
	//添加多个附件 
	public static void addTach(String[] fileList, String[] extFileAlias, Multipart multipart) throws MessagingException, UnsupportedEncodingException {
		for (int index = 0; index < fileList.length; index++) {
			MimeBodyPart mailArchieve = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(fileList[index]);
			mailArchieve.setDataHandler(new DataHandler(fds));
			if(extFileAlias == null || extFileAlias.length <= index){
				mailArchieve.setFileName(MimeUtility.encodeText(fds.getName()));
			} else {
				mailArchieve.setFileName(MimeUtility.encodeText(extFileAlias[index]));
			}
			multipart.addBodyPart(mailArchieve);
		}
	}
}
