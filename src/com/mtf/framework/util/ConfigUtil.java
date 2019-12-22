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

import java.io.File;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.commons.lang.StringUtils;

import com.fr.report.core.A.t;

/**
 * 系统配置信息工具类，用于读取system.properties文件里的常量设置
 *
 * @author Wade.Zhu
 * @version 1.0	2013-06-22	Wade.Zhu		created.
 * @version 1.1	2013-06-25	Wade.Zhu		add getDoubleFormat()
 * @version <ver>
 */
public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("system", Locale.ROOT);

	private final static String DEFAULT_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	private final static String DEFAULT_DATETIME_MINUTE_FORMAT = "yyyy-MM-dd HH:mm";
	private final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
	private final static String DEFAULT_TIME_FORMAT = "HH:mm:ss";
	private final static int DEFAULT_MAX_UPLOAD = 32505856;
	private final static String DEFAULT_EXT_UPLOAD = "txt,rar,zip,doc,docx,xls,xlsx,jpg,jpeg,gif,png,swf,wmv,avi,wma,mp3,mid";
	private final static String DEFAULT_DIR_UPLOAD = "upload";
	private final static String DEFAULT_DOUBLE_FORMAT = "%.6f";
	private final static boolean	DEFAULT_CACHE = false;
	
	private static String datetimeFormatString = null;
	private static String datetimeMinuteFormatString = null;
	private static String dateFormatString = null;
	private static String timeFormatString = null;
	private static int uploadFileMaxSize = 0;
	private static String uploadFileExts = null;
	private static String uploadFileDir = null;
	private static String doubleFormatString = null;
	
	private static String	reportTemplateDir = null;
	
	private static String	mailSmtpHost = null;
	private static String	mailSmtpPort = null;
	private static boolean	mailSmtpAuth = false;
	private static String	mailSmtpUid = null;
	private static String	mailSmtpPwd = null;
	private static String	mailSmtpFrom = null;
	private static String	mailBodyHeader = null;
	private static String	mailBodyFooter = null;
	private static String	sysMode = null;
	private static String	approvalAmount = null;
	private static boolean	cache = false;
	
	private static String	permissionAppCodes = null;
	private static String	permissionAppDomesticCodes = null;
	private static String	permissionAppInternationalCodes = null;
	private static String	permissionPurCodes = null;
	private static String	permissionPurDomesticCodes = null;
	private static String	permissionPurInternationalCodes = null;
	private static String	permissionPurMaxCode = null;
	private static String	permissionAdminCodes = null;
	private static String	permissionCidDomCode = null;
	private static String	permissionCidInterCode = null;
	private static String	permissionSignerCode = null;
	private static String	permissionDomesticCategoryId = null;
	private static String	mailReimbursementReportReceiver = null;
	
	private ConfigUtil() {
	}
	
	/**
	 * 读取配置文件中dateformat.datetime的值，如果没有配置，则返回默认格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getDateTimeFormatString() {
		if (datetimeFormatString == null) {
			datetimeFormatString = bundle.getString("dateformat.datetime");
		}
		if (datetimeFormatString == null || datetimeFormatString.trim().length() == 0) {
			datetimeFormatString = DEFAULT_DATETIME_FORMAT;
		}
		
		return datetimeFormatString;
	}
	
	/**
	 * 读取配置文件中dateformat.datetime的值，如果没有配置，则返回默认格式为yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String getDateTimeMinuteFormatString() {
		if (datetimeMinuteFormatString == null) {
			datetimeMinuteFormatString = bundle.getString("dateformat.datetime.minute");
		}
		if (datetimeMinuteFormatString == null || datetimeMinuteFormatString.trim().length() == 0) {
			datetimeMinuteFormatString = DEFAULT_DATETIME_MINUTE_FORMAT;
		}
		
		return datetimeMinuteFormatString;
	}
	
	/**
	 * 读取配置文件中dateformat.datetime的值，如果没有配置，则返回默认格式为yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static String getYearFormatString() {
		if (datetimeFormatString == null) {
			datetimeFormatString = bundle.getString("dateformat.year");
		}
		if (datetimeFormatString == null || datetimeFormatString.trim().length() == 0) {
			datetimeFormatString = DEFAULT_DATETIME_FORMAT;
		}
		
		return datetimeFormatString;
	}
	
	/**
	 * 读取配置文件中dateformat.date的值，如果没有配置，则返回默认格式为yyyy-MM-dd
	 * @return
	 */
	public static String getDateFormatString() {
		if (dateFormatString == null) {
			dateFormatString = bundle.getString("dateformat.date");
		}
		if (dateFormatString == null || dateFormatString.trim().length() == 0) {
			dateFormatString = DEFAULT_DATE_FORMAT;
		}
		
		return dateFormatString;
	}

	/**
	 * 读取配置文件中dateformat.time的值，如果没有配置，则返回默认格式为HH:mm:ss
	 * @return
	 */
	public static String getTimeFormatString() {
		if (timeFormatString == null) {
			timeFormatString = bundle.getString("dateformat.time");
		}
		if (timeFormatString == null || timeFormatString.trim().length() == 0) {
			timeFormatString = DEFAULT_TIME_FORMAT;
		}
		
		return timeFormatString;
	}

	/**
	 * 读取配置文件中upload.max的值
	 * 
	 * @return
	 */
	public static final int getUploadFileMaxSize() {
		if (uploadFileMaxSize == 0) {
			String str = bundle.getString("upload.max");
			if (str != null && TextUtils.isDigitsOnly(str)) {
				uploadFileMaxSize = Integer.valueOf(str);
			} else {
				uploadFileMaxSize = DEFAULT_MAX_UPLOAD;
			}
		}
		return uploadFileMaxSize;
	}

	/**
	 * 读取配置文件中upload.ext的值
	 * 
	 * @return
	 */
	public static final String getUploadFileExts() {
		if (uploadFileExts == null) {
			uploadFileExts = bundle.getString("upload.ext");
		}
		if (TextUtils.isEmpty(uploadFileExts)) {
			uploadFileExts = DEFAULT_EXT_UPLOAD;
		}
		return uploadFileExts;
	}

	/**
	 * 读取配置文件中upload.dir的值
	 * 
	 * @return
	 */
	public static final String getUploadFileDir() {
		if (uploadFileDir == null) {
			uploadFileDir = bundle.getString("upload.dir");
		}
		if (TextUtils.isEmpty(uploadFileDir)) {
			uploadFileDir = DEFAULT_DIR_UPLOAD;
		}
		return uploadFileDir;
	}
	/**
	 * 读取配置文件中numformat.double的值
	 * 
	 * @return
	 */
	public static final String getDoubleFormat() {
		if (doubleFormatString == null) {
			doubleFormatString = bundle.getString("numformat.double");
		}
		if (TextUtils.isEmpty(doubleFormatString)) {
			doubleFormatString = DEFAULT_DATE_FORMAT;
		}
		return doubleFormatString;
	}
	
	/**
	 * 读取配置文件中report.template.dir的值
	 * 
	 * @return
	 */
	public static final String getReportTemplateDir() {
		final String key = "report.template.dir";
		if (reportTemplateDir == null && bundle.containsKey(key)) {
			reportTemplateDir = bundle.getString(key);
			if (reportTemplateDir != null && reportTemplateDir != "" && !reportTemplateDir.endsWith("/") && !reportTemplateDir.endsWith(File.separator)) {
				reportTemplateDir += File.separator;
			}
		}
		return reportTemplateDir;
	}
	
	/**
	 * 读取配置文件中mail.smtp.host的值
	 * 
	 * @return
	 */
	public static final String getMailSmtpHost() {
		final String key = "mail.smtp.host";
		if (mailSmtpHost == null && bundle.containsKey(key)) {
			mailSmtpHost = bundle.getString(key);
		}
		return mailSmtpHost;
	}
	
	/**
	 * 读取配置文件中mail.smtp.port的值
	 * 
	 * @return
	 */
	public static final String getMailSmtpPort() {
		final String key = "mail.smtp.port";
		if (mailSmtpPort == null && bundle.containsKey(key)) {
			mailSmtpPort = bundle.getString(key);
		}
		return mailSmtpPort;
	}
	
	/**
	 * 读取配置文件中mail.smtp.auth的值
	 * 
	 * @return
	 */
	public static final boolean getMailSmtpAuth() {
		final String key = "mail.smtp.auth";
		if (mailSmtpAuth == false && bundle.containsKey(key)) {
			String str = bundle.getString(key);
			if (!StringUtils.isBlank(str) && StringUtils.isNumeric(str)) {
				mailSmtpAuth = Boolean.valueOf(str);
			}
		}
		return mailSmtpAuth;
	}
	
	/**
	 * 读取配置文件中mail.smtp.uid的值
	 * 
	 * @return
	 */
	public static final String getMailSmtpUid() {
		final String key = "mail.smtp.uid";
		if (mailSmtpUid == null && bundle.containsKey(key)) {
			mailSmtpUid = bundle.getString(key);
		}
		return mailSmtpUid;
	}
	
	/**
	 * 读取配置文件中mail.smtp.pwd的值
	 * 
	 * @return
	 */
	public static final String getMailSmtpPwd() {
		final String key = "mail.smtp.pwd";
		if (mailSmtpPwd == null && bundle.containsKey(key)) {
			mailSmtpPwd = bundle.getString(key);
		}
		return mailSmtpPwd;
	}
	
	/**
	 * 读取配置文件中mail.smtp.from的值
	 * 
	 * @return
	 */
	public static final String getMailSmtpFrom() {
		final String key = "mail.smtp.from";
		if (mailSmtpFrom == null && bundle.containsKey(key)) {
			mailSmtpFrom = bundle.getString(key);
		}
		return mailSmtpFrom;
	}
	
	/**
	 * 读取配置文件中mail.body.header的值
	 * 
	 * @return
	 */
	public static final String getMailBodyHeader() {
		final String key = "mail.body.header";
		if (mailBodyHeader == null && bundle.containsKey(key)) {
			mailBodyHeader = bundle.getString(key);
		}
		return mailBodyHeader;
	}
	
	/**
	 * 读取配置文件中mail.body.footer的值
	 * 
	 * @return
	 */
	public static final String getMailBodyFooter() {
		final String key = "mail.body.footer";
		if (mailBodyFooter == null && bundle.containsKey(key)) {
			mailBodyFooter = bundle.getString(key);
		}
		return mailBodyFooter;
	}
	
	/**
	 * 读取配置文件中sys.mode的值
	 * 
	 * @return test/dev/rel
	 */
	public static final String getSysMode() {
		final String key = "sys.mode";
		if (sysMode == null && bundle.containsKey(key)) {
			sysMode = bundle.getString(key);
		}
		return sysMode;
	}
	
	
	/**
	 * 读取配置文件中approval.amount的值
	 * 
	 * @return 
	 */
	public static final double getApprovalAmount() {
		final String key = "approval.amount";
		double approvalAmountdouble = 0.0;
		if (approvalAmount == null && bundle.containsKey(key)) {
			approvalAmount = bundle.getString(key);
			approvalAmountdouble = Double.valueOf(approvalAmount);
		}
		return approvalAmountdouble;
	}
	
	
	/**
	 * 读取配置文件中sys.cache的值，如果没有配置，则返回默认false
	 * @return
	 */
	public static boolean getCache() {
		final String key = "sys.cache";
		if (cache == false && bundle.containsKey(key)) {
			String str = bundle.getString(key);
			if (StringUtils.equalsIgnoreCase("true", str)) {
				cache = true;
			} else if ("1".equals(str)) {
				cache = true;
			} else {
				cache = DEFAULT_CACHE;
			}
		}
		
		return cache;
	}
	
	/**
	 * 读取配置文件中permission.app.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionAppCodes() {
		final String key = "permission.app.codes";
		if (permissionAppCodes == null && bundle.containsKey(key)) {
			permissionAppCodes = bundle.getString(key);
		}
		return permissionAppCodes;
	}
	
	/**
	 * 读取配置文件中permission.app.domestic.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionAppDomesticCodes() {
		final String key = "permission.app.domestic.codes";
		if (permissionAppDomesticCodes == null && bundle.containsKey(key)) {
			permissionAppDomesticCodes = bundle.getString(key);
		}
		return permissionAppDomesticCodes;
	}
	
	/**
	 * 读取配置文件中permission.app.international.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionAppInternationalCodes() {
		final String key = "permission.app.international.codes";
		if (permissionAppInternationalCodes == null && bundle.containsKey(key)) {
			permissionAppInternationalCodes = bundle.getString(key);
		}
		return permissionAppInternationalCodes;
	}
	
	/**
	 * 读取配置文件中permission.pur.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionPurCodes() {
		final String key = "permission.pur.codes";
		if (permissionPurCodes == null && bundle.containsKey(key)) {
			permissionPurCodes = bundle.getString(key);
		}
		return permissionPurCodes;
	}
	
	/**
	 * 读取配置文件中permission.pur.domestic.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionPurDomesticCodes() {
		final String key = "permission.pur.domestic.codes";
		if (permissionPurDomesticCodes == null && bundle.containsKey(key)) {
			permissionPurDomesticCodes = bundle.getString(key);
		}
		return permissionPurDomesticCodes;
	}
	
	/**
	 * 读取配置文件中permission.pur.international.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionPurInternationalCodes() {
		final String key = "permission.pur.international.codes";
		if (permissionPurInternationalCodes == null && bundle.containsKey(key)) {
			permissionPurInternationalCodes = bundle.getString(key);
		}
		return permissionPurInternationalCodes;
	}
	
	/**
	 * 读取配置文件中permission.pur.max.code的值
	 * 
	 * @return 
	 */
	public static final String getPermissionPurMaxCode() {
		final String key = "permission.pur.max.code";
		if (permissionPurMaxCode == null && bundle.containsKey(key)) {
			permissionPurMaxCode = bundle.getString(key);
		}
		return permissionPurMaxCode;
	}
	
	/**
	 * 读取配置文件中permission.admin.codes的值
	 * 
	 * @return 
	 */
	public static final String getPermissionAdminCodes() {
		final String key = "permission.admin.codes";
		if (permissionAdminCodes == null && bundle.containsKey(key)) {
			permissionAdminCodes = bundle.getString(key);
		}
		return permissionAdminCodes;
	}
	
	/**
	 * 读取配置文件中permission.categoryId.domestic.code的值
	 * 
	 * @return 
	 */
	public static final String getPermissionCidDomCode() {
		final String key = "permission.categoryId.domestic.code";
		if (permissionCidDomCode == null && bundle.containsKey(key)) {
			permissionCidDomCode = bundle.getString(key);
		}
		return permissionCidDomCode;
	}
	
	/**
	 * 读取配置文件中permission.categoryId.international.code的值
	 * 
	 * @return 
	 */
	public static final String getPermissionCidInterCode() {
		final String key = "permission.categoryId.international.code";
		if (permissionCidInterCode == null && bundle.containsKey(key)) {
			permissionCidInterCode = bundle.getString(key);
		}
		return permissionCidInterCode;
	}
	
	/**
	 * 读取配置文件中permission.signer.codee的值
	 * 
	 * @return 
	 */
	public static final String getPermissionSignerCode() {
		final String key = "permission.signer.code";
		if (permissionSignerCode == null && bundle.containsKey(key)) {
			permissionSignerCode = bundle.getString(key);
		}
		return permissionSignerCode;
	}
	
	
	/**
	 * 读取配置文件中permission.domestic.categoryId的值
	 * 
	 * @return 
	 */
	public static final String getPermissionDomesticCategoryId() {
		final String key = "permission.domestic.categoryId";
		if (permissionDomesticCategoryId == null && bundle.containsKey(key)) {
			permissionDomesticCategoryId = bundle.getString(key);
		}
		return permissionDomesticCategoryId;
	}
	
	
	/**
	 * 读取配置文件中permission.domestic.categoryId的值
	 * 
	 * @return 
	 */
	public static final String getMailReimbursementReportReceiver() {
		String key = "mail.reimbursement.report.recevier";
		String tagTest = CommonUtil.getConfig("tagTest");
		if ("t".equals(tagTest)) {
			key = "mail.reimbursement.report.recevier.test";
		}
		if (mailReimbursementReportReceiver == null && bundle.containsKey(key)) {
			mailReimbursementReportReceiver = bundle.getString(key);
		}
		return mailReimbursementReportReceiver;
	}
}
