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
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ActionMapper;
import com.mtf.framework.dao.ResourceMapper;
import com.mtf.framework.dao.Role2ActionMapper;
import com.mtf.framework.dao.User2ActionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Action;
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.service.IActionService;
import com.mtf.framework.util.TextUtils;

@Service("actionService")
public class ActionServiceImpl implements IActionService {
	private static final Logger		logger	= Logger.getLogger(ActionServiceImpl.class);

	private ActionMapper			actionMapper;
	private ResourceMapper			resourceMapper;
	private User2ActionMapper		user2actionMapper;
	private Role2ActionMapper		role2actionMapper;

	@Autowired
	public void setActionMapper(ActionMapper actionMapper) {
		this.actionMapper = actionMapper;
	}
	
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}
	
	@Autowired
	public void setUser2ActionMapper(User2ActionMapper user2actionMapper) {
		this.user2actionMapper = user2actionMapper;
	}
	
	@Autowired
	public void setRole2ActionMapper(Role2ActionMapper role2actionMapper) {
		this.role2actionMapper = role2actionMapper;
	}

	@Override
	public Action add(String uid, Action action) throws PmException {
		// step 1 : check parameter(s)
		if (action == null) {
			throw new PmException("Parameter action is NULL.", 1);
		} else if (TextUtils.isEmpty(action.getName())) {
			throw new PmException("Parameter action.name is NULL or Empty.", 1);
		} else if (action.getLevel() < 1 || action.getLevel() > 9) {
			throw new PmException("Parameter action.level not in [1-9].", 1);
		} else if (action.getStatus() < 0) {
			throw new PmException("Parameter action.status less than 0.", 1);
		}
		
		// step 2 : check name
		boolean isNameExists = this.actionMapper.countByName(action.getName()) > 0;
		if (isNameExists) {
			throw new PmException("Action name already exists.", 2);
		}

		// step 3 : insert action
		action.setId(UUID.randomUUID().toString());
		this.actionMapper.insert(action);
		
		return action;
	}

	@Override
	public Action edit(String uid, Action action) throws PmException {
		// step 1 : check parameter(s)
		if (action == null) {
			throw new PmException("Parameter action is NULL", 1);
		} else if (TextUtils.isEmpty(action.getName())) {
			throw new PmException("Parameter action.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(action.getName())) {
			throw new PmException("Parameter action.name is NULL or Empty.", 1);
		} else if (action.getLevel() < 1 || action.getLevel() > 9) {
			throw new PmException("Parameter action.level not in [1-9].", 1);
		} else if (action.getStatus() < 0) {
			throw new PmException("Parameter action.status less than 0.", 1);
		}
		
		// step 2 : check exists
		Action dbAction = this.actionMapper.selectById(action.getId());
		if (dbAction == null) {
			throw new PmException("Action not found.", 2);
		}

		// step 3 : check name
		if (!dbAction.getName().equalsIgnoreCase(action.getName())) {
			boolean isNameExists = this.actionMapper.countByName(action.getName()) > 0;
			if (isNameExists) {
				throw new PmException("Action name already exists.", 3);
			}
		}

		// step 4 : update action
		dbAction.setName(action.getName());
		dbAction.setDescription(action.getDescription());
		dbAction.setLevel(action.getLevel());
		dbAction.setSystem(action.getSystem());
		dbAction.setStatus(action.getStatus());
		this.actionMapper.updateById(dbAction);
		
		return action;
	}

	@Override
	public Action get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		Action action = this.actionMapper.selectById(id);
		return action;
	}

	@Override
	public void editResources(String uid, String actionId, String[] resourceIds) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(actionId)) {
			throw new PmException("Parameter actionId is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		Action action = this.actionMapper.selectById(actionId);
		if (action == null) {
			throw new PmException("Action not found.", 2);
		}
		
//		// step 3 : clear current resources
//		this.action2resourceMapper.deleteByActionId(actionId);
//
//		// step 4 : insert new resources
//		if (resourceIds != null && resourceIds.length > 0) {
//			for (String resourceId : resourceIds) {
//				Action2Resource a2r = new Action2Resource();
//				a2r.setId(UUID.randomUUID().toString());
//				a2r.setActionId(actionId);
//				a2r.setResourceId(resourceId);
//				this.action2resourceMapper.insert(a2r);
//			}
//		}
		
		// step 3 : clear current resources
		this.resourceMapper.updateActionId2Null(actionId);
		
		// step 4 : update resource
		if (resourceIds != null && resourceIds.length > 0) {
			for (String resourceId : resourceIds) {
				Resource dbResource = this.resourceMapper.selectById(resourceId);
				if (dbResource == null) {
					throw new PmException("Resource not found.", 3);
				}
				if (!TextUtils.isEmpty(dbResource.getActionId())) {
					throw new PmException("Resource already assigned to an Action.", 4);
				}
				dbResource.setActionId(actionId);
				this.resourceMapper.updateById(dbResource);
			}
		}
	}

	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty", 1);
		}
		
		// step 2 : check exists
		Action action = this.actionMapper.selectById(id);
		if (action == null) {
			throw new PmException("Action not found.", 2);
		}
		
		// step 3 : clear resource action
//		this.action2resourceMapper.deleteByActionId(actionId);
		this.resourceMapper.updateActionId2Null(id);
		
		// step 4 : delete user action
		this.user2actionMapper.deleteByActionId(id);
		
		// step 5 : delete role action
		this.role2actionMapper.deleteByActionId(id);
		
		// step 6 : delete action
		this.actionMapper.deleteById(id);
	}
	
	@Override
	public List<Action> listAll(String uid, PageForm form, Integer system) throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();;
		if (form != null) {
			if ("name".equalsIgnoreCase(form.getSort())) {
				param.put("sort", "name");
			} else if ("level".equalsIgnoreCase(form.getSort())) {
				param.put("sort", "level");
			} else if ("status".equalsIgnoreCase(form.getSort())) {
				param.put("sort", "status");
			}
			param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		}
		if (system != null) {
			param.put("system", system);
		}
		
		// step 2 : do search
		List<Action> list = this.actionMapper.selectAll(param);
		return list;
	}

}
