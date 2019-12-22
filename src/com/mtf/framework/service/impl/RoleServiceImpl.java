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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ActionMapper;
import com.mtf.framework.dao.DivisionRoleMapper;
import com.mtf.framework.dao.Role2ActionMapper;
import com.mtf.framework.dao.RoleConditionMapper;
import com.mtf.framework.dao.User2RoleMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Action;
import com.mtf.framework.model.Role2Action;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.service.IRoleService;
import com.mtf.framework.util.TextUtils;

@Service("roleService")
public class RoleServiceImpl implements IRoleService {
	private static final Logger	logger	= Logger.getLogger(ResourceServiceImpl.class);

	private ActionMapper		actionMapper;
	private User2RoleMapper		user2roleMapper;
	private Role2ActionMapper	role2actionMapper;
	@Autowired
	private RoleConditionMapper	roleConditionMapper;
	
	@Autowired
	private DivisionRoleMapper	divisionRoleMapper;

	@Autowired
	public DivisionRoleMapper getDivisionRoleMapper() {
		return divisionRoleMapper;
	}

	@Autowired
	public void setDivisionRoleMapper(DivisionRoleMapper divisionRoleMapper) {
		this.divisionRoleMapper = divisionRoleMapper;
	}

	@Autowired
	public RoleConditionMapper getRoleConditionMapper() {
		return roleConditionMapper;
	}

	@Autowired
	public void setRoleConditionMapper(RoleConditionMapper roleConditionMapper) {
		this.roleConditionMapper = roleConditionMapper;
	}

	@Autowired
	public void setActionMapper(ActionMapper actionMapper) throws PmException {
		this.actionMapper = actionMapper;
	}
	
	@Autowired
	public void setUser2RoleMapper(User2RoleMapper user2roleMapper) throws PmException {
		this.user2roleMapper = user2roleMapper;
	}

	@Autowired
	public void setRole2ActionMapper(Role2ActionMapper role2actionMapper) throws PmException {
		this.role2actionMapper = role2actionMapper;
	}

	@Override
	public List<RoleImpl> listAllAvailable(String uid, PageForm form, Integer system) throws PmException {
		// step 1 : check parameter(s)
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("name".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "CONVERT(name USING gbk)");
		} else if ("level".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "level");
		} else if ("datetime".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "dateTime");
		} else if ("status".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "status");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		if (system != null) {
			param.put("system", system);
		}
		param.put("status", 0);
		
		// step 2 : do search
		List<RoleImpl> list = this.roleConditionMapper.selectAll(param);
		return list;
	}
	
	@Override
	public List<RoleImpl> listAll(String uid, PageForm form, Integer system, String type) throws PmException {
		// step 1 : check parameter(s)
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("name".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "name");
		} else if ("level".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "level");
		} else if ("datetime".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "dateTime");
		} else if ("status".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "status");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		if (system != null) {
			param.put("system", system);
		}
		if (null != type) {
			param.put("type", type);
		}
		
		// step 2 : do search
		List<RoleImpl> list = this.roleConditionMapper.selectAll(param);
		return list;
	}

	@Override
	public RoleImpl add(String uid, RoleImpl role) throws PmException {
		// step 1 : check parameter(s)
		if (role == null) {
			throw new PmException("Parameter role is NULL.", 1);
		} else if (TextUtils.isEmpty(role.getName())) {
			throw new PmException("Parameter role.name is NULL or Empty.", 1);
		} else if (role.getLevel() < 1 || role.getLevel() > 9) {
			throw new PmException("Parameter role.level not in [1-9].", 1);
		} else if (role.getSystem() < 0 || role.getSystem() > 1) {
			throw new PmException("Parameter role.system not in [0, 1].", 1);
		//} else if (TextUtils.isEmpty(role.getUserId())) {
		//	throw new PmException("Parameter role.userId is NULL or Empty.", 1);
		} else if (role.getStatus() < 0) {
			throw new PmException("Parameter role.status less than 0.", 1);
		}
		
		// step 2 : check name
		boolean isNameExists = this.roleConditionMapper.countByName(role.getName()) > 0;
		if (isNameExists) {
			throw new PmException("Role name already exists.", 2);
		}
		
		// step 3 : do add
		role.setId(UUID.randomUUID().toString());
		role.setUserId(uid);
		role.setDateTime(new Date());
		this.roleConditionMapper.insert(role);

		return role;
	}
	
	@Override
	public RoleImpl edit(String uid, RoleImpl role) throws PmException {
		// step 1 : check parameter(s)
		if (role == null) {
			throw new PmException("Parameter role is NULL", 1);
		} else if (TextUtils.isEmpty(role.getName())) {
			throw new PmException("Parameter role.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(role.getName())) {
			throw new PmException("Parameter role.name is NULL or Empty.", 1);
		} else if (role.getLevel() < 1 || role.getLevel() > 9) {
			throw new PmException("Parameter role.level not in [1-9].", 1);
//		} else if (TextUtils.isEmpty(role.getUserId())) {
//			throw new PmException("Parameter role.userId is NULL or Empty.", 1);
		} else if (role.getStatus() < 0) {
			throw new PmException("Parameter role.status less than 0.", 1);
		}
		
		// step 2 : check exists
		RoleImpl dbRole = this.roleConditionMapper.selectById(role.getId());
		if (dbRole == null) {
			throw new PmException("Role not found.", 2);
		}

		// step 3 : check name
		if (!dbRole.getName().equalsIgnoreCase(role.getName())) {
			boolean isNameExists = this.roleConditionMapper.countByName(role.getName()) > 0;
			if (isNameExists) {
				throw new PmException("Role name already exists.", 3);
			}
		}

		// step 4 : update action
		dbRole.setName(role.getName());
		dbRole.setLevel(role.getLevel());
		dbRole.setDescription(role.getDescription());
		dbRole.setSystem(role.getSystem());
		dbRole.setUserId(uid);
		dbRole.setType(role.getType());
		dbRole.setTypeExtends(role.getTypeExtends());
		dbRole.setTypeId(role.getTypeId());
		dbRole.setTypeSys(role.getTypeSys());
		dbRole.setDateTime(new Date());
		dbRole.setStatus(role.getStatus());
		this.roleConditionMapper.updateById(dbRole);
		// 如果是部门角色,更新部门权限
		// 角色类型(s:系统,d:部门,u:用户)
		String type = dbRole.getType();
		if ("d".equals(type)) {
			DivisionRoleImpl divisionRole = new DivisionRoleImpl();
			String roleId = dbRole.getId();
			String divisionId = dbRole.getTypeId();
			if ("NULL".equals(divisionId)) {
				divisionId = null;
				String tagUpdate = "divisionIdNull";
				divisionRole.setTagUpdate(tagUpdate);
			}
			divisionRole.setDivisionId(divisionId);
			divisionRole.setRoleId(roleId);
			divisionRoleMapper.update(divisionRole);
		}
		return role;
	}

	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		RoleImpl role = this.roleConditionMapper.selectById(id);
		if (role == null) {
			throw new PmException("Role not found.", 2);
		}
		
		// step 3 : clear role actions
		this.role2actionMapper.deleteByRoleId(id);
		
		// step 4 : clear user role
		this.user2roleMapper.deleteByRoleId(id);
		
		// step 5 : delete role
		this.roleConditionMapper.deleteById(id);
	}
	
	@Override
	public RoleImpl get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		RoleImpl role = this.roleConditionMapper.selectById(id);
		return role;
	}

	@Override
	public RoleImpl getWithActions(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		RoleImpl role = this.roleConditionMapper.selectByIdWithActions(id);
		return role;
	}

	@Override
	public void editActions(String uid, String roleId, String[] actionIds) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(roleId)) {
			throw new PmException("Parameter roleId is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		RoleImpl role = this.roleConditionMapper.selectById(roleId);
		if (role == null) {
			throw new PmException("Role not found.", 2);
		}
		
		// step 3 : clear current actions
		this.role2actionMapper.deleteByRoleId(roleId);

		// step 4 : insert new actions
		if (actionIds != null && actionIds.length > 0) {
			for (String actionId : actionIds) {
				Action action = this.actionMapper.selectById(actionId);
				if (action == null) {
					throw new PmException("Action not found.", 3);
				}
				
				Role2Action r2a = new Role2Action();
				r2a.setId(UUID.randomUUID().toString());
				r2a.setRoleId(roleId);
				r2a.setActionId(actionId);
				this.role2actionMapper.insert(r2a);
			}
		}
	}
}
