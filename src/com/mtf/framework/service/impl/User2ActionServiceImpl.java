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

import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.User2ActionMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.User2Action;
import com.mtf.framework.service.IUser2ActionService;
import com.mtf.framework.util.TextUtils;

@Service("user2actionService")
public class User2ActionServiceImpl implements IUser2ActionService {
	private static final Logger	logger	= Logger.getLogger(User2ActionServiceImpl.class);

	private User2ActionMapper	user2actionMapper;
	private UserConditionMapper			userMapper;
	
	@Autowired
	public void setUser2actionMapper(User2ActionMapper user2actionMapper) {
		this.user2actionMapper = user2actionMapper;
	}
	
	@Autowired
	public void setUserMapper(UserConditionMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public User2Action add(String uid, User2Action user2action) throws PmException {
		// step 1 : check parameter(s)
		if (user2action == null) {
			throw new PmException("Parameter user2action is NULL.", 1);
		} else if (TextUtils.isEmpty(user2action.getUserId())) {
			throw new PmException("Parameter user2action.userId is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(user2action.getActionId())) {
			throw new PmException("Parameter user2action.actionId is NULL or Empty.", 1);
		} else if (user2action.getAllow() == null || user2action.getAllow() < 0 || user2action.getAllow() > 1) {
			throw new PmException("Parameter user2action.allow not in [0,1].", 1);
		}
		
		// step 2 : check exists
		boolean isExists = this.user2actionMapper.countByUserIdAndActionId(user2action) > 0;
		if (isExists) {
			throw new PmException("User action rule already exists.", 2);
		}

		// step 3 : insert into db
		String resId = UUID.randomUUID().toString();
		user2action.setId(resId);
		this.user2actionMapper.insert(user2action);
		
		return user2action;
	}

	@Override
	public User2Action edit(String uid, User2Action user2action) throws PmException {
		// step 1 : check parameter(s)
		if (user2action == null) {
			throw new PmException("Parameter user2action is NULL.", 1);
		} else if (TextUtils.isEmpty(user2action.getId())) {
			throw new PmException("Parameter user2action.Id is NULL or Empty.", 1);
		} else if (user2action.getAllow() < 0 || user2action.getAllow() > 1) {
			throw new PmException("Parameter user2action.allow not in [0,1].", 1);
		}
		
		// step 2 : get current
		User2Action dbUser2Action = this.user2actionMapper.selectById(user2action.getId());
		if (dbUser2Action == null) {
			throw new PmException("User action rule not found.", 2);
		}
		
		// step 3 : do update
		/* skip
		dbUser2Action.setActionId(user2action.getActionId());
		dbUser2Action.setUserId(user2action.getUserId());
		*/
		dbUser2Action.setAllow(user2action.getAllow());
		this.user2actionMapper.updateAllowById(dbUser2Action);

		return dbUser2Action;
	}

	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL.", 1);
		}
		
		// step 2 : get current
		User2Action db = this.user2actionMapper.selectById(id);
		if (db == null) {
			throw new PmException("User action rule not found.", 2);
		}
		
		// step 3 : do delete
		this.user2actionMapper.deleteById(id);
	}

	@Override
	public List<User2Action> listByUserId(String uid, String userId) throws PmException {
		// step 1 : check parameter(s)
		if (userId == null) {
			throw new PmException("Parameter userId is NULL.");
		}
		
		// step 2 : check user
		User user = this.userMapper.selectById(userId);
		if (user == null) {
			throw new PmException("User not found.", 2);
		}
		
		// step 3 : do search
		List<User2Action> list = this.user2actionMapper.selectByUserIdWithAction(userId);
		return list;
	}

	@Override
	public List<User2Action> listByUserIdWithAction(String uid, String userId) throws PmException {
		// step 1 : check parameter(s)
		if (userId == null) {
			throw new PmException("Parameter userId is NULL.", 1);
		}
		
		// step 2 : check user
		User user = this.userMapper.selectById(userId);
		if (user == null) {
			throw new PmException("User not found.", 2);
		}
		
		// step 3 : do search
		List<User2Action> list = this.user2actionMapper.selectByUserIdWithAction(userId);
		return list;
	}

	@Override
	public User2Action get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL.", 1);
		}
		
		// step 2 : do search
		User2Action user2action = this.user2actionMapper.selectById(id);
		return user2action;
	}

	@Override
	public User2Action getWithAction(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL.", 1);
		}
		
		// step 2 : do search
		User2Action user2action = this.user2actionMapper.selectByIdWithAction(id);
		return user2action;
	}
}
