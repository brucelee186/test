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
package com.mtf.framework.service;

import com.mtf.framework.model.common.SessionInfo;

/**
 * 检查安全性相关接口
 *
 * @author Wade.Zhu
 * @version 1.0	2013-4-25	Wade.Zhu		created.
 * @version <ver>
 */
public interface ISecurityService {

	/**
	 * 检查当前登录用户是否具有使用指定资源的权限
	 * 
	 * @param uid 操作用户
	 * @param sessionInfo 用户信息
	 * @return 验证代码
	 * 
	 * <table border="1px">
	 * <tr><th>Case</th><th>Return</th></tr>
	 * <tr><td>OK</td><td>0</td><tr>
	 * <tr><td>资源未定义</td><td>1</td></tr>
	 * <tr><td>特别拒绝</td><td>2</td></tr>
	 * <tr><td>未授权</td><td>3</td></tr>
	 * </table>
	 * <br>
	 */
	int getPassCode(String uri, SessionInfo sessionInfo);
}
