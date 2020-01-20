package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.EmailMapper;
import com.mtf.framework.dao.OrderCategoryServiceConditionMapper;
import com.mtf.framework.dao.OrderCategoryServiceDetailConditionMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.model.impl.OrderServiceImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 邮件
 * 作者:     Auto
 * 日期:     2015/5/27
**********************************************
*/
@Service("emailService")
public class EmailServiceImpl extends CommonServiceImpl implements EmailService {
	@Autowired
	private EmailMapper emailMapper;
	
	@Autowired
	private UserDetailMapper userDetailMapper;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	@Autowired
	private OrderCategoryServiceConditionMapper orderCategoryServiceConditionMapper;
	
	@Autowired
	private OrderCategoryServiceDetailConditionMapper orderCategoryServiceDetailConditionMapper;
	
	@Autowired
	private UserMapper userMapper;

	@Autowired
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Autowired
	public OrderCategoryServiceDetailConditionMapper getOrderCategoryServiceDetailConditionMapper() {
		return orderCategoryServiceDetailConditionMapper;
	}

	@Autowired
	public void setOrderCategoryServiceDetailConditionMapper(
			OrderCategoryServiceDetailConditionMapper orderCategoryServiceDetailConditionMapper) {
		this.orderCategoryServiceDetailConditionMapper = orderCategoryServiceDetailConditionMapper;
	}

	@Autowired
	public OrderCategoryServiceConditionMapper getOrderCategoryServiceConditionMapper() {
		return orderCategoryServiceConditionMapper;
	}

	@Autowired
	public void setOrderCategoryServiceConditionMapper(
			OrderCategoryServiceConditionMapper orderCategoryServiceConditionMapper) {
		this.orderCategoryServiceConditionMapper = orderCategoryServiceConditionMapper;
	}

	@Autowired
	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	@Autowired
	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	@Autowired
	public UserDetailMapper getUserDetailMapper() {
		return userDetailMapper;
	}

	public void setUserDetailMapper(UserDetailMapper userDetailMapper) {
		this.userDetailMapper = userDetailMapper;
	}

	@Autowired
	public EmailMapper getEmailMapper() {
		return emailMapper;
	}

	@Autowired
	public void setEmailMapper(EmailMapper emailMapper) {
		this.emailMapper = emailMapper;
	}

	/**
	 * 新增实体对象
	 * @param email
	 */
	public EmailImpl insert(EmailImpl email) throws PmException {
		this.emailMapper.insert(email);
		return email;
	}

	/**
	 * 删除实体对象
	 * @param email
	 */
	public int delete(EmailImpl email) throws PmException {
		return this.emailMapper.delete(email);
	}

	/**
	 * 更新实体对象
	 * @param email
	 */
	public boolean update(EmailImpl email) throws PmException {
		boolean result = true;
		this.emailMapper.update(email);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param email
	 */
	@SuppressWarnings("unchecked")
	public List<EmailImpl> select(EmailImpl email) throws PmException {
		return (List<EmailImpl>) this.emailMapper.select(email);
	}
	/**
	 * 查询单个实体
	 * @param email
	 */
	public EmailImpl get(EmailImpl email) throws PmException {
		return (EmailImpl) this.emailMapper.get(email);
	}
	/**
	 * 查询实体分页列表
	 * @param email
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<EmailImpl> search(EmailImpl email) throws PmException {
		DataGrid<EmailImpl> grid = new DataGrid<EmailImpl>();
		Object obj = email;
		List list = emailMapper.select(obj);
		grid.setRows(list);
		int count;
		count = emailMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMail(EmailImpl email){
		
		try {
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
					theme = "测试/" + theme + "/" + email.getEmail();
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
					//mailHtml.send();
				}
				email.setStatusSend("u");
				email.setEditState("i");
				//CommonUtil.setCommonField(email);
				email.setAddDate(new Date());
				email.setModifiedDate(new Date());
				String type = email.getType();
				if ("v".equals(type)) {
					Long typeId = email.getTypeId();
					if (null != typeId) {
						String emailTemp = email.getEmail();
						EmailImpl emailInner = new EmailImpl();
						emailInner.setType(type);
						emailInner.setTypeId(typeId);
						emailInner.setEmail(emailTemp);
						emailInner = (EmailImpl)emailMapper.get(emailInner);
						if (null == emailInner) {
							emailMapper.insert(email);
						}
					}
				}
				else {
					emailMapper.insert(email);
				}
			}
		} catch (EmailException e) {
			e.printStackTrace();
			return email;
		}
		return email;
	}
	
/*	private void sendMailForApp(String mailSbStr, PurchaseImpl purchase, List<PurchaseItemImpl> itemList) throws PmException{
		Mail mailParam = new Mail();
		mailParam.setTos(mailSbStr);
		//
		StringBuffer sb = new StringBuffer();
		sb.append(ConfigUtil.getMailBodyHeader());
		sb.append("<table class=\"mailtableh\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><td colspan=\"4\"><h2>申请审批列表</h2></td></tr>\r\n");
		sb.append("<tr><th width=\"100\" >采购号</th><th width=\"250\">申请部门</th><th width=\"240\">申请人</th><th width=\"217\">申请日期</th></tr>\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sb.append("<tr><td style=\"text-align:center;\">" + purchase.getNo() + "</td><td style=\"text-align:center;\">" + purchase.getApplicantdivisionName() + "</td><td style=\"text-align:center;\">" + purchase.getApplicantName() + "</td><td style=\"text-align:center;\">" + sdf.format(purchase.getApplicantDatetime())  + "</td></tr>\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		
		sb.append("<table class=\"mailtableh\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><th width=\"150\">部门</th><th width=\"100\">客户</th><th width=\"100\">主类别</th><th width=\"100\">次类别</th><th width=\"357\">描述</th></tr>\r\n");
		
	
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			String customerName = "";
			if(StringUtils.isBlank(item.getCustomerName()) == false){
				customerName = item.getCustomerName();
			}
			sb.append("<tr><td style=\"text-align:left;\">" + item.getDivisionName() + "</td><td style=\"text-align:left;\">" + customerName + "</td><td style=\"text-align:left;\">" + item.getCategory1Name() + "</td><td style=\"text-align:left;\">" + item.getCategory2Name() + "</td><td style=\"text-align:left;\">" + item.getDescription() + "</td></tr>\r\n");
		}
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		sb.append(ConfigUtil.getMailBodyFooter());
		
		mailParam.setContent(sb.toString());
		//增加邮件
		addMail(mailParam);
	}*/
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMail(List<EmailImpl> listEmail, Integer intervalSecond, String pathUpload) throws EmailException {
		EmailImpl email1 = new EmailImpl();
		if (null != listEmail && listEmail.size() > 0) {
			int intervalLoop = 1;
			for (int i = 0; i < listEmail.size(); i++) {
				EmailImpl email = listEmail.get(i);
				if (null == intervalSecond) {
					intervalSecond = 30;
				}	
				AttendanceImpl attendance = email.getAttendance();
				Long idAtten = attendance.getId();
				String receiver = email.getReceiver();
				EmailImpl emailTemp = new EmailImpl();
				emailTemp.setType("a");
				emailTemp.setTypeId(idAtten);
				emailTemp.setReceiver(receiver);
				emailTemp = (EmailImpl) emailMapper.get(emailTemp);
				if (null == emailTemp) {
				String template = CommonUtil.readTextContent(pathUpload + "/tempEmail/templateAttendance.jsp");
					// 取得行政部主管信息
					UserDetailImpl user = new UserDetailImpl();
					/*// gwmc3代表职位为行政部主管
				user.setPositionId("gwmc3");
				user = (UserDetailImpl) userDetailMapper.get(user);*/
					user.setCode("1701001");
					user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
					String office_user_officialTelNo = user.getOfficialTelNo();
					if (null == office_user_officialTelNo) {
						office_user_officialTelNo = "";
					}
					String office_user_chineseName = user.getChineseName();
					if (null == office_user_chineseName) {
						office_user_chineseName = "";
					}
					String office_user_englishName = user.getEnglishName();
					if (null == office_user_englishName) {
						office_user_englishName = "";
					}
					template = template.replaceAll("office_user_officialTelNo", office_user_officialTelNo);
					template = template.replaceAll("office_user_chineseName", office_user_chineseName);
					template = template.replaceAll("office_user_englishName", office_user_englishName);
					// 替换用户信
					String office_cardNo = (attendance.getCardNo() != null ? attendance.getCardNo() : "");
					String office_userName = (attendance.getUserName() != null ? attendance.getUserName() : "");
					String office_date = (attendance.getDate() != null ? attendance.getDate() : "");
					String office_ticks = (String) (attendance.getTicks() != null ? String.valueOf(attendance.getTicks()) : "");
					String office_dayStart = (attendance.getDayStart() != null ? attendance.getDayStart() : "");
					String office_dayEnd = (attendance.getDayEnd() != null ? attendance.getDayEnd() : "");
					
					template = template.replaceAll("office_cardNo", office_cardNo);
					template = template.replaceAll("office_userName", office_userName);
					template = template.replaceAll("office_date", office_date);
					template = template.replaceAll("office_ticks", office_ticks);
					template = template.replaceAll("office_dayStart", office_dayStart);
					template = template.replaceAll("office_dayEnd", office_dayEnd);
					email.setContent(template);
					try {
						if (6 == intervalLoop) {
							intervalLoop = 0;
						}
						//Thread.sleep(20 * 1000);
						email.setType("a");
						email.setTypeId(idAtten);
						this.sendMail(email);
						intervalLoop++;
					} catch (Exception e) {
						e.printStackTrace();
					}
					/*try {
					thread.sleep(intervalSecond * 10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}*/
					
				}
				}
		}
		return email1;
	
	}

	/**
	 * 发送考勤邮件,通知高管
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailAttenVacate(List<EmailImpl> listEmail) throws EmailException {
		if (null != listEmail && listEmail.size() > 0) {
			int intervalLoop = 1;
			for (int i = 0; i < listEmail.size(); i++) {
				EmailImpl email = listEmail.get(i);
				HttpSession session = CommonUtil.getHttpSession();
				String webContent = session.getServletContext().getRealPath("/upload");
				String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateAttenVacate.jsp");
				// 取得行政部主管信息
				UserDetailImpl user = new UserDetailImpl();
				/*// gwmc3代表职位为行政部主管
				user.setPositionId("gwmc3");
				user = (UserDetailImpl) userDetailMapper.get(user);*/
				user.setCode("1701001");
				user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
				// 替换用户信
				AttenVacateManageImpl attenVacateManage = email.getAttenVacateManage();
				String office_userName = (attenVacateManage.getUserName() != null ? attenVacateManage.getUserName() : "");
				String office_divisionName = (attenVacateManage.getDivisionName() != null ? attenVacateManage.getDivisionName() : "");
				String office_nameVacate = (attenVacateManage.getNameVacate() != null ? attenVacateManage.getNameVacate() : "");
				String office_dateStart = (attenVacateManage.getDateStart() != null ? attenVacateManage.getDateStart() : "");
				String office_dateEnd = (attenVacateManage.getDateEnd() != null ? attenVacateManage.getDateEnd() : "");
				String office_duration = (attenVacateManage.getDuration() != null ? attenVacateManage.getDuration() : "");
				String office_remark = (attenVacateManage.getRemark() != null ? attenVacateManage.getRemark() : "");
				
				template = template.replaceAll("office_userName", office_userName);
				template = template.replaceAll("office_divisionName", office_divisionName);
				template = template.replaceAll("office_nameVacate", office_nameVacate);
				template = template.replaceAll("office_dateStart", office_dateStart);
				template = template.replaceAll("office_dateEnd", office_dateEnd);
				template = template.replaceAll("office_duration", office_duration);
				template = template.replaceAll("office_remark", office_remark);
				email.setContent(template);
				try {
					if (6 == intervalLoop) {
						intervalLoop = 0;
						//Thread.sleep(40 * 1000);
					}
					this.sendMail(email);
					intervalLoop++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 手动发送考勤邮件,通知高管
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailAttenVacateManager(List<EmailImpl> listEmail, AttenVacateManageImpl attenVacateManage) throws EmailException {
		if (null != listEmail && listEmail.size() > 0) {
			int intervalLoop = 1;
			String durationTotal = attenVacateManage.getDurationTotal();
			for (int i = 0; i < listEmail.size(); i++) {
				EmailImpl email = listEmail.get(i);
				HttpSession session = CommonUtil.getHttpSession();
				String webContent = session.getServletContext().getRealPath("/upload");
				String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateAttenVacateManager.jsp");
				
				List<AttenVacateManageImpl> listAttenVacateManage = email.getListAttenVacateManage();
				String office_manager = "";
				for (int j = 0; j < listAttenVacateManage.size(); j++) {
					String templateDetail = CommonUtil.readTextContent(webContent + "/tempEmail/templateAttenVacateManagerDetail.jsp");
					// 替换用户信
					AttenVacateManageImpl attenVacateManageTemp = listAttenVacateManage.get(j);
					String office_userName = (attenVacateManageTemp.getUserName() != null ? attenVacateManageTemp.getUserName() : "");
					String office_divisionName = (attenVacateManageTemp.getDivisionName() != null ? attenVacateManageTemp.getDivisionName() : "");
					String office_nameVacate = (attenVacateManageTemp.getNameVacate() != null ? attenVacateManageTemp.getNameVacate() : "");
					String office_dateStart = (attenVacateManageTemp.getDateStart() != null ? attenVacateManageTemp.getDateStart() : "");
					String office_dateEnd = (attenVacateManageTemp.getDateEnd() != null ? attenVacateManageTemp.getDateEnd() : "");
					String office_duration = (attenVacateManageTemp.getDuration() != null ? attenVacateManageTemp.getDuration() : "");
					String office_remark = (attenVacateManageTemp.getRemark() != null ? attenVacateManageTemp.getRemark() : "");					
					templateDetail = templateDetail.replaceAll("office_userName", office_userName);
					templateDetail = templateDetail.replaceAll("office_divisionName", office_divisionName);
					templateDetail = templateDetail.replaceAll("office_nameVacate", office_nameVacate);
					templateDetail = templateDetail.replaceAll("office_dateStart", office_dateStart);
					templateDetail = templateDetail.replaceAll("office_dateEnd", office_dateEnd);
					templateDetail = templateDetail.replaceAll("office_duration", office_duration);
					templateDetail = templateDetail.replaceAll("office_remark", office_remark);
					office_manager += templateDetail;
				}
				//替换合计时长
				template = template.replaceAll("office_duration_total", durationTotal);
				// 替换明细部分
				// 替换标签<office_manager/>
				template = template.replaceAll("<office_manager/>", office_manager);
				email.setContent(template);
				try {
					if (6 == intervalLoop) {
						intervalLoop = 0;
						//Thread.sleep(40 * 1000);
					}
					this.sendMail(email);
					intervalLoop++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 发送考勤邮件,通知订车人
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrder(List<EmailImpl> listEmail) throws EmailException {
		if (null != listEmail && listEmail.size() > 0) {
			int intervalLoop = 1;
			for (int i = 0; i < listEmail.size(); i++) {
				EmailImpl email = listEmail.get(i);
				HttpSession session = CommonUtil.getHttpSession();
				String webContent = session.getServletContext().getRealPath("/upload");
				String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateAttenVacate.jsp");
				// 取得行政部主管信息
				UserDetailImpl user = new UserDetailImpl();
				/*// gwmc3代表职位为行政部主管
				user.setPositionId("gwmc3");
				user = (UserDetailImpl) userDetailMapper.get(user);*/
				user.setCode("1701001");
				user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
				// 替换用户信
				AttenVacateManageImpl attenVacateManage = email.getAttenVacateManage();
				String office_userName = (attenVacateManage.getUserName() != null ? attenVacateManage.getUserName() : "");
				String office_divisionName = (attenVacateManage.getDivisionName() != null ? attenVacateManage.getDivisionName() : "");
				String office_nameVacate = (attenVacateManage.getNameVacate() != null ? attenVacateManage.getNameVacate() : "");
				String office_dateStart = (attenVacateManage.getDateStart() != null ? attenVacateManage.getDateStart() : "");
				String office_dateEnd = (attenVacateManage.getDateEnd() != null ? attenVacateManage.getDateEnd() : "");
				String office_duration = (attenVacateManage.getDuration() != null ? attenVacateManage.getDuration() : "");
				
				template = template.replaceAll("office_userName", office_userName);
				template = template.replaceAll("office_divisionName", office_divisionName);
				template = template.replaceAll("office_nameVacate", office_nameVacate);
				template = template.replaceAll("office_dateStart", office_dateStart);
				template = template.replaceAll("office_dateEnd", office_dateEnd);
				template = template.replaceAll("office_duration", office_duration);
				email.setContent(template);
				try {
					if (6 == intervalLoop) {
						intervalLoop = 0;
						//Thread.sleep(40 * 1000);
					}
					this.sendMail(email);
					intervalLoop++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderServiceVehicle(List<EmailImpl> listEmail) {
	if (null != listEmail && listEmail.size() > 0) {
		int intervalLoop = 1;
		for (int i = 0; i < listEmail.size(); i++) {
			EmailImpl email = listEmail.get(i);
			UserDetailImpl userDetailInner = email.getUserDetail();
			HttpSession session = CommonUtil.getHttpSession();
			String webContent = session.getServletContext().getRealPath("/upload");
			String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateOrderServiceVehicle.jsp");
			// 取得行政部主管信息
			UserDetailImpl user = new UserDetailImpl();
			/*// gwmc3代表职位为行政部主管
			user.setPositionId("gwmc3");
			user = (UserDetailImpl) userDetailMapper.get(user);*/
			user.setCode("1701007");
			user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
			String office_user_officialTelNo = user.getOfficialTelNo();
			if (null == office_user_officialTelNo) {
				office_user_officialTelNo = "";
			}
			String office_user_chineseName = user.getChineseName();
			if (null == office_user_chineseName) {
				office_user_chineseName = "";
			}
			String office_user_englishName = user.getEnglishName();
			if (null == office_user_englishName) {
				office_user_englishName = "";
			}
			template = template.replaceAll("office_user_officialTelNo", office_user_officialTelNo);
			template = template.replaceAll("office_user_chineseName", office_user_chineseName);
			template = template.replaceAll("office_user_englishName", office_user_englishName);
			// 替换用户信
			OrderServiceImpl orderService = email.getOrderService();
			String office_divisionName = (orderService.getDivisionName() != null ? orderService.getDivisionName() : "");
			String office_customerName = (orderService.getCustomerName() != null ? orderService.getCustomerName() : "");
			String office_userName = (orderService.getUserName() != null ? orderService.getUserName() : "");
			String office_typeName = (orderService.getTypeName() != null ? orderService.getTypeName() : "");
			String office_timeTrip = (orderService.getDestination() != null ? new SimpleDateFormat("yyyy-MM-dd").format(orderService.getTimeTrip()) : "");
			String office_origin = (orderService.getOrigin()!= null ? orderService.getOrigin() : "");
			String office_destination = (orderService.getDestination() != null ? orderService.getDestination() : "");
			
			template = template.replaceAll("office_divisionName", office_divisionName);
			template = template.replaceAll("office_userName", office_userName);
			template = template.replaceAll("office_customerName", office_customerName);
			template = template.replaceAll("office_typeName", office_typeName);
			template = template.replaceAll("office_timeTrip", office_timeTrip);
			template = template.replaceAll("office_origin", office_origin);
			template = template.replaceAll("office_destination", office_destination);
			// 替换
			if(null != userDetailInner){
				//String contextPath = CommonUtil.getContextPath();
				String keyEncryption = "1801001-" + userDetailInner.getUserId();
				String url = CommonUtil.getIpServer() + "user/doLoadView.do?keyEncryption=" + keyEncryption;
				template = template.replaceAll("<office_link/>", 
						"<input type='button' value='点击进入确认页' >:&nbsp;" + url + "</input>");
			}
			email.setContent(template);
			try {
				if (6 == intervalLoop) {
					intervalLoop = 0;
					//Thread.sleep(40 * 1000);
				}
				this.sendMail(email);
				intervalLoop++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	return null;
	}
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderServiceVehicleUser(List<EmailImpl> listEmail) {
		if (null != listEmail && listEmail.size() > 0) {
			int intervalLoop = 1;
			for (int i = 0; i < listEmail.size(); i++) {
				EmailImpl email = listEmail.get(i);
				UserDetailImpl userInner = email.getUserDetail();
				HttpSession session = CommonUtil.getHttpSession();
				String webContent = session.getServletContext().getRealPath("/upload");
				String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateOrderServiceVehicleUser.jsp");
				// 取得行政部主管信息
				UserDetailImpl user = new UserDetailImpl();
				// 1701007 OA负责人权限
				user.setCode("1701007");
				user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
				String office_user_officialTelNo = user.getOfficialTelNo();
				if (null == office_user_officialTelNo) {
					office_user_officialTelNo = "";
				}
				String office_user_chineseName = user.getChineseName();
				if (null == office_user_chineseName) {
					office_user_chineseName = "";
				}
				String office_user_englishName = user.getEnglishName();
				if (null == office_user_englishName) {
					office_user_englishName = "";
				}
				template = template.replaceAll("office_user_officialTelNo", office_user_officialTelNo);
				template = template.replaceAll("office_user_chineseName", office_user_chineseName);
				template = template.replaceAll("office_user_englishName", office_user_englishName);
				// 替换用户信
				OrderServiceImpl orderService = email.getOrderService();
				String office_divisionName = (orderService.getDivisionName() != null ? orderService.getDivisionName() : "");
				String office_customerName = (orderService.getCustomerName() != null ? orderService.getCustomerName() : "");
				String office_userName = (orderService.getUserName() != null ? orderService.getUserName() : "");
				String office_typeName = (orderService.getTypeName() != null ? orderService.getTypeName() : "");
				String office_timeTrip = (orderService.getDestination() != null ? new SimpleDateFormat("yyyy-MM-dd").format(orderService.getTimeTrip()) : "");
				String office_origin = (orderService.getOrigin()!= null ? orderService.getOrigin() : "");
				String office_destination = (orderService.getDestination() != null ? orderService.getDestination() : "");
				
				template = template.replaceAll("office_divisionName", office_divisionName);
				template = template.replaceAll("office_userName", office_userName);
				template = template.replaceAll("office_customerName", office_customerName);
				template = template.replaceAll("office_typeName", office_typeName);
				template = template.replaceAll("office_timeTrip", office_timeTrip);
				template = template.replaceAll("office_origin", office_origin);
				template = template.replaceAll("office_destination", office_destination);
				// 替换
				if(null != userInner){
					String jumpPageCode = email.getJumpPageCode();
					//String contextPath = CommonUtil.getContextPath();
					if(null != jumpPageCode){
						String keyEncryption = jumpPageCode + "-" + userInner.getUserId();
						String url = CommonUtil.getIpServer() + "user/doLoadView.do?keyEncryption=" + keyEncryption;
						template = template.replaceAll("<office_link/>", 
								"<input type='button' value='点击进入审批页' >:&nbsp;" + url + "</input>");
					}
				}
				email.setContent(template);
				try {
					if (6 == intervalLoop) {
						intervalLoop = 0;
						//Thread.sleep(40 * 1000);
					}
					this.sendMail(email);
					intervalLoop++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	/**
	 * 发送报销邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderCategoryService(OrderCategoryServiceDetailImpl orderCategoryServiceDetail)
			throws EmailException {
		List<OrderCategoryServiceDetailImpl> listOrderCategoryServiceDetail = orderCategoryServiceDetailConditionMapper.selectGroupByUser(orderCategoryServiceDetail);
		if (null != listOrderCategoryServiceDetail && listOrderCategoryServiceDetail.size() > 0) {
			for (int i = 0; i < listOrderCategoryServiceDetail.size(); i++) {
				OrderCategoryServiceDetailImpl orderCategoryServiceDetailInner = new OrderCategoryServiceDetailImpl();
				orderCategoryServiceDetailInner = listOrderCategoryServiceDetail.get(i);
				int intervalLoop = 1;
				EmailImpl email = new EmailImpl();
				HttpSession session = CommonUtil.getHttpSession();
				String webContent = session.getServletContext().getRealPath("/upload");
				String template = CommonUtil.readTextContent(webContent + "/tempEmail/templateOrderCategoryServiceRimbursement.jsp");
				
				String approverEmail1 = orderCategoryServiceDetailInner.getApproverEmail1();
				String approverEmail2 = orderCategoryServiceDetailInner.getApproverEmail2();
				String approverEmail3 = orderCategoryServiceDetailInner.getApproverEmail3();
				
				String emailTemp = "";
				String approveStatus = orderCategoryServiceDetail.getApproveStatus();
				boolean tagLink = false;
				if ("s".equals(approveStatus)) {
					emailTemp = approverEmail1;
				} 
				else if ("ap1".equals(approveStatus)) {
					if (null != approverEmail2 ) {
						emailTemp = approverEmail2;
					}
					else if (null != approverEmail3) {
						emailTemp = approverEmail3;
						tagLink = true;
					}
				}
				else if ("ap2".equals(approveStatus)) {
					if (null != approverEmail3) {
						emailTemp = approverEmail3;
						tagLink = true;
					}
				}
				else if (approveStatus.startsWith("re")) {
					String applicantId = orderCategoryServiceDetailInner.getApplicantId();
					/*UserImpl user = new UserImpl();
					user.setId(applicantId);
					user = (UserImpl) userMapper.get(user);
					if (null != user) {
						emailTemp = user.getEmail();
					}*/
					if (null != applicantId) {
						UserDetailImpl user = new UserDetailImpl();
						user.setUserId(applicantId);
						user = (UserDetailImpl) userDetailMapper.get(user);
						if (null != user) {
							emailTemp = user.getEmail();
						}
					} else {
						return new EmailImpl();
					}
				}
				email.setReceiver(emailTemp);
				email.setEmail(emailTemp);
				email.setTheme("系统提醒/报销单审批");
				// 查询些编号的报销单是否发送过邮件，如果有，不予以发送
				Long typeId = orderCategoryServiceDetailInner.getId();
			/*	if (null != typeId) {
					String emailTemp2 = email.getEmail();
					EmailImpl emailExist = new EmailImpl();
					// r:报销单
					emailExist.setType("r");
					emailExist.setTypeId(typeId);
					emailExist.setEmail(emailTemp2);
					emailExist = (EmailImpl)emailMapper.get(emailExist);
					if (null != emailExist) {
						return null;
					}
				}*/
				// 替换表头信息
				Date applicantDate = orderCategoryServiceDetailInner.getApplicantDate();
				String applicantDateString = new SimpleDateFormat("yyyy-MM-dd").format(applicantDate);
				String idOrderCategoryService = orderCategoryServiceDetailInner.getIdOrderCategoryService().toString();
				String userName = orderCategoryServiceDetailInner.getUserName();
				String divisionName = orderCategoryServiceDetailInner.getDivisionName();
				String currencyName = orderCategoryServiceDetailInner.getCurrencyName();
				String remarkApprove = orderCategoryServiceDetailInner.getRemarkApprove();
				String totalAmount = String.valueOf(orderCategoryServiceDetailInner.getTotalAmount());
				
				// 如果有连接权限的情况下,替换连接
				/*<input type="button" value="点击进入审批页" >
				:&nbsp;office_link
				</input>*/
				if(tagLink){
					//String contextPath = CommonUtil.getContextPath();
					String keyEncryption = "1808400-d99001af-9e98-4a34-8399-c075b35934fd";
					String url = CommonUtil.getIpServer() + "user/doLoadView.do?keyEncryption=" + keyEncryption;
					template = template.replaceAll("<office_link/>", 
							"<input type='button' value='点击进入审批页' >:&nbsp;" + url + "</input>");
				}
				String office_idOrderCategoryService = (idOrderCategoryService != null ? idOrderCategoryService : "");
				template = template.replaceAll("office_idOrderCategoryService", office_idOrderCategoryService);
				
				String office_userName = (userName != null ? userName : "");
				template = template.replaceAll("office_userName", office_userName);
				
				String office_divisionName = (divisionName != null ? divisionName : "");
				template = template.replaceAll("office_divisionName", office_divisionName);
				
				String office_applicantDate = (applicantDateString != null ? applicantDateString : "");
				template = template.replaceAll("office_applicantDate", office_applicantDate);
				
				String office_currencyName = (currencyName != null ? currencyName : "");
				template = template.replaceAll("office_currencyName", office_currencyName);
				
				String office_remarkApprove = (remarkApprove != null ? remarkApprove : "");
				template = template.replaceAll("office_remarkApprove", office_remarkApprove);
				
				String office_totalAmount = (totalAmount != null ? totalAmount : "");
				template = template.replaceAll("office_totalAmount", office_totalAmount);
				List<OrderCategoryServiceDetailImpl> listCategoryServiceDetailServiceInner = orderCategoryServiceDetailInner.getListOrderCategoryServiceDetail();
				String office_manager = "";
				if (listCategoryServiceDetailServiceInner != null && listCategoryServiceDetailServiceInner.size() > 0) {
					for (int j = 0; j < listCategoryServiceDetailServiceInner.size(); j++) {
						String templateDetail = CommonUtil.readTextContent(webContent + "/tempEmail/templateOrderCategoryServiceRimbursementDetail.jsp");
						// 替换用户信
						OrderCategoryServiceDetailImpl orderCategoryServiceDetailTemp = listCategoryServiceDetailServiceInner.get(j);
						if ("ap1".equals(approveStatus)) {
							String approverEmail3Break = orderCategoryServiceDetailTemp.getApproverEmail3();
							String approverEmail2Break = orderCategoryServiceDetailTemp.getApproverEmail2();
							if (null == approverEmail2Break && null == approverEmail3Break) {
								continue;
							}
						}
						String office_divisionName_d = (orderCategoryServiceDetailTemp.getDivisionName() != null ? orderCategoryServiceDetailTemp.getDivisionName() : "");
						
						String customerName = orderCategoryServiceDetailTemp.getCustomerName1();
						String nameCategoryLevel1 = orderCategoryServiceDetailTemp.getNameCategoryLevel1();
						String nameCategoryLevel2 = orderCategoryServiceDetailTemp.getNameCategoryLevel2();
						String remark = orderCategoryServiceDetailTemp.getRemark();
						Double amountDouble = orderCategoryServiceDetailTemp.getAmount();
						String amount = "0.00";
						if (null != amountDouble) {
							amount = amountDouble.toString();
						}
						
						String office_customer = (customerName != null ? customerName : "");
						String office_nameCategoryLevel1 = (nameCategoryLevel1 != null ? nameCategoryLevel1 : "");
						String office_nameCategoryLevel2 = (nameCategoryLevel2 != null ? nameCategoryLevel2 : "");
						String office_remark = (remark != null ? remark : "");
						String office_amount = (amount != null ? amount : "");
						
						templateDetail = templateDetail.replaceAll("office_divisionName_d", office_divisionName_d);
						templateDetail = templateDetail.replaceAll("office_customer", office_customer);
						templateDetail = templateDetail.replaceAll("office_nameCategoryLevel1", office_nameCategoryLevel1);
						templateDetail = templateDetail.replaceAll("office_nameCategoryLevel2", office_nameCategoryLevel2);
						templateDetail = templateDetail.replace("office_remark", office_remark);
						templateDetail = templateDetail.replaceAll("office_amount", office_amount);
						office_manager += templateDetail;
					}
				}
				//替换合计时长
				// 替换明细部分
				// 替换标签<office_manager/>
				template = template.replaceAll("<office_manager/>", office_manager);
				email.setContent(template);
				try {
					if (6 == intervalLoop) {
						intervalLoop = 0;
						//Thread.sleep(40 * 1000);
					}
					this.sendMail(email);
					intervalLoop++;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		}
		return null;
	}
}