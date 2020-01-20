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

import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.mtf.framework.model.common.Pair;
import com.mtf.framework.model.common.Tetrad;


/**
 * 工具类
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public class Utils {

	private static final Logger	logger	= Logger.getLogger(Utils.class);
	
	public static boolean validateEmail(String email) {
		String regex = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
		return Pattern.matches(regex, email);
	}
	
	public static Locale getLocale(String language) {
		if ("zh".equalsIgnoreCase(language.trim())) {
			return Locale.CHINA;
		}
		return Locale.ENGLISH;
	}
	
	public static int getLocaleCode(Locale locale) {
		logger.debug(locale);
		
		if (locale.getLanguage().startsWith("en")) {
			return 0;
		}
		return 1;
	}
	
	public static int getLocaleCode(String locale) {
		if (locale == null || locale.trim().length() == 0 || locale.startsWith("en")) {
			return 0;
		}
		return 1;
	}
	
	public static String getIP(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = "LocalHost";
		}
		return ip;
	}
	
	public static void addTetradAPS(List<Tetrad<String, String, String, String>> list, Integer aps) {
		if(list != null && aps != null){
			if(aps == 1) {
				list.add(0, new Tetrad<String, String, String, String>("", "", "", ""));
			} else if (aps == 2) {
				list.add(0, new Tetrad<String, String, String, String>("", "----", "----", "----"));
			} else if (aps == 3) {
				list.add(0, new Tetrad<String, String, String, String>("", "Any", "Any", "Any"));
			} else if (aps == 4) {
				list.add(0, new Tetrad<String, String, String, String>("", "None", "None", "None"));
			}
		}
	}
}
