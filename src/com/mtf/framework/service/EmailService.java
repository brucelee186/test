package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.mail.EmailException;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceDetailImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 邮件
 * 作者:     Auto
 * 日期:     2015/5/27
**********************************************
*/
public interface EmailService {
	/**
	 * 新增实体对象
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl insert(EmailImpl email) throws PmException;

	/**
	 * 删除实体对象
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public int delete(EmailImpl email) throws PmException;

	/**
	 * 更新实体对象
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public boolean update(EmailImpl email) throws PmException;

	/**
	 * 查询实体列表
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public List<EmailImpl> select(EmailImpl email) throws PmException;

	/**
	 * 取得单一对象
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl get(EmailImpl email) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public DataGrid<EmailImpl> search(EmailImpl email) throws PmException;

	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMail(EmailImpl email) throws EmailException;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailAttenVacate(List<EmailImpl> listEmail) throws EmailException;
	
	/**
	 * 手动发送考勤邮件,通知高管
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailAttenVacateManager(List<EmailImpl> listEmail, AttenVacateManageImpl attenVacateManage) throws EmailException;
	
	/**
	 * 发送报销邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderCategoryService(OrderCategoryServiceDetailImpl orderCategoryServiceDetail) throws EmailException;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderServiceVehicle(List<EmailImpl> listEmail) throws EmailException;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrderServiceVehicleUser(List<EmailImpl> listEmail) throws EmailException;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMailOrder(List<EmailImpl> listEmail) throws EmailException;
	
	/**
	 * 发送邮件
	 * @param email
	 * @return
	 * @throws PmException
	 */
	public EmailImpl sendMail(List<EmailImpl> listEmail, Integer intervalSecond, String pathUpload) throws EmailException;
}