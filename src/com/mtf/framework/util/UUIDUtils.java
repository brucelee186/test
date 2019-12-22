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

import java.util.UUID;

import org.apache.commons.lang.StringUtils;

/**
 * 系统UUID工具类
 *
 * @author Wade.Zhu
 * @version 1.0	2013-08-10	Wade.Zhu		created.
 * @version <ver>
 */
public class UUIDUtils {
	public static String UUID_00000000_0000_0000_0000_000000000000 = "00000000-0000-0000-0000-000000000000";
	public static String UUID_10000000_0000_0000_0000_000000000000 = "10000000-0000-0000-0000-000000000000";
	public static String UUID_20000000_0000_0000_0000_000000000000 = "20000000-0000-0000-0000-000000000000";
	public static String UUID_30000000_0000_0000_0000_000000000000 = "30000000-0000-0000-0000-000000000000";
	public static String UUID_40000000_0000_0000_0000_000000000000 = "40000000-0000-0000-0000-000000000000";
	public static String UUID_50000000_0000_0000_0000_000000000000 = "50000000-0000-0000-0000-000000000000";
	public static String UUID_60000000_0000_0000_0000_000000000000 = "60000000-0000-0000-0000-000000000000";
	public static String UUID_70000000_0000_0000_0000_000000000000 = "70000000-0000-0000-0000-000000000000";
	public static String UUID_80000000_0000_0000_0000_000000000000 = "80000000-0000-0000-0000-000000000000";
	public static String UUID_90000000_0000_0000_0000_000000000000 = "90000000-0000-0000-0000-000000000000";
	public static String UUID_00000000_0000_0000_0000_000000000001 = "00000000-0000-0000-0000-000000000001";
	public static String UUID_00000000_0000_0000_0000_000000000002 = "00000000-0000-0000-0000-000000000002";
	public static String UUID_00000000_0000_0000_0000_000000000003 = "00000000-0000-0000-0000-000000000003";
	public static String UUID_00000000_0000_0000_0000_000000000004 = "00000000-0000-0000-0000-000000000004";
	public static String UUID_00000000_0000_0000_0000_000000000005 = "00000000-0000-0000-0000-000000000005";
	public static String UUID_00000000_0000_0000_0000_000000000006 = "00000000-0000-0000-0000-000000000006";
	public static String UUID_00000000_0000_0000_0000_000000000007 = "00000000-0000-0000-0000-000000000007";
	public static String UUID_00000000_0000_0000_0000_000000000008 = "00000000-0000-0000-0000-000000000008";
	public static String UUID_00000000_0000_0000_0000_000000000009 = "00000000-0000-0000-0000-000000000009";
	
	/**
	 * 检查是否是系统预置的UUID
	 * 
	 * @param uuid
	 * @return true/false
	 */
	public static boolean isPrebuildUUID(String uuid) {
		if (!isValidUUID(uuid)) {
			return false;
		}
		if (uuid.endsWith("-0000-0000-0000-000000000000")) {
			return true;
		} else if (uuid.startsWith("00000000-0000-0000-0000-")) {
			return true;
		}
		return false;
	}

	/**
	 * 验证是否合法的UUID格式
	 * @param uuid
	 * @return true/false
	 */
	public static boolean isValidUUID(String uuid) {
		if (StringUtils.isBlank(uuid) || uuid.length() != 36) {
			return false;
		}
		//String reg = "^[0-9a-z]{8}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{4}-[0-9a-z]{12}$";
		String reg = "^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$";
		return uuid.toLowerCase().matches(reg);
	}
	
	/**
	 * 生成UUID
	 * @return
	 */
	public static String genUUID() {
		return UUID.randomUUID().toString();
	}
}
