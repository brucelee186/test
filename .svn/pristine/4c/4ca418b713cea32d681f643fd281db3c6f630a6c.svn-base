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
package com.mtf.framework.service.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ResourceMapper;
import com.mtf.framework.dao.Role2ActionMapper;
import com.mtf.framework.dao.User2ActionMapper;
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.User2Action;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.service.ISecurityService;

@Service("sercurityService")
public class SecurityServiceImpl implements ISecurityService {
	private static final Logger	logger	= Logger.getLogger(ResourceServiceImpl.class);

	private User2ActionMapper	user2actionMapper;
	private Role2ActionMapper	role2actionMapper;
	private ResourceMapper		resourceMapper;

	@Autowired
	public void setUser2ActionMapper(User2ActionMapper user2actionMapper) {
		this.user2actionMapper = user2actionMapper;
	}

	@Autowired
	public void setRole2ActionMapper(Role2ActionMapper role2actionMapper) {
		this.role2actionMapper = role2actionMapper;
	}
	
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public int getPassCode(String uri, SessionInfo sessionInfo) {
		// step 1 : get action
		Resource resource = this.resourceMapper.selectByUri(uri);
		// 资源未定义
		if (resource == null) {
			return 1;
		}
		
//		// step 2 : check resource access level
//		if (resource.getAccess() == 0 || resource.getAccess() == 1 || resource.getAccess() == 2) {
//			return 0;
//		}

		// step 3 : user - action
		User2Action u2a = new User2Action();
		u2a.setUserId(sessionInfo.getUserId());
		u2a.setActionId(resource.getActionId());
		User2Action user2action = this.user2actionMapper.selectByUserIdAndActionId(u2a);
		
		if (user2action != null) {
			// 特别拒绝
			if (user2action.getAllow() == 0) {
				return 2;
			}
			// 特别允许
			else if (user2action.getAllow() == 1) {
				return 0;
			}
		}

		// step 4 : role - action
		if (sessionInfo.getRoleIds() == null || sessionInfo.getRoleIds().isEmpty()) {
			return 3;
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("actionId", resource.getActionId());
		param.put("roleIds", sessionInfo.getRoleIds());
		int roles2Action = this.role2actionMapper.countByActionIdAndRoleIds(param);
		if (roles2Action > 0) {
			return 0;
		} else {
			// 未授权
			return 3;
		}
	}
}
