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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.Category2DivisionMapper;
import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.DivisionMapper;
import com.mtf.framework.dao.User2DivisionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category2Division;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DivisionImpl;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;
import com.mtf.framework.util.UUIDUtils;

@Service("IDivisionService")
public class IDivisionServiceImpl implements IDivisionService {

	private static final Logger		logger	= Logger.getLogger(IDivisionServiceImpl.class);

	
	@Autowired
	private DivisionConditionMapper				divisionConditionMapper;
	private User2DivisionMapper			user2divisionMapper;
	private Category2DivisionMapper		category2DivisionMapper;
	private DivisionMapper		divisionMapper;
	
	
	@Autowired
	public DivisionMapper getDivisionMapper() {
		return divisionMapper;
	}

	@Autowired
	public void setDivisionMapper(DivisionMapper divisionMapper) {
		this.divisionMapper = divisionMapper;
	}

	@Autowired
	public DivisionConditionMapper getDivisionConditionMapper() {
		return divisionConditionMapper;
	}

	@Autowired
	public void setDivisionConditionMapper(
			DivisionConditionMapper divisionConditionMapper) {
		this.divisionConditionMapper = divisionConditionMapper;
	}

	@Autowired
	public void setUser2DivisionMapper(User2DivisionMapper user2divisionMapper) {
		this.user2divisionMapper = user2divisionMapper;
	}
	
	@Autowired
	public void setCategory2DivisionMapper(Category2DivisionMapper category2DivisionMapper) {
		this.category2DivisionMapper = category2DivisionMapper;
	}

	@Override
	public Division add(String uid, Division division) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} else if (TextUtils.isEmpty(division.getName())) {
			throw new PmException("Parameter division.name is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(division.getUserId())) {
			throw new PmException("Parameter division.userId is NULL or Empty.", 1);
		}
		
		// step 2 : check name
		boolean isNameExists = this.divisionConditionMapper.countByName(division.getName()) > 0;
		if (isNameExists) {
			throw new PmException("Division name already exists.", 2);
		}
		
		// step 3 : check parent division
		if (!TextUtils.isEmpty(division.getPid())) {
			Division pdivision = this.divisionConditionMapper.selectById(division.getPid());
			if (pdivision == null) {
				throw new PmException("Parent division not found.", 3);
			}
		}

		// step 4 : insert into db
		division.setId(UUID.randomUUID().toString());
		division.setUserId(uid);
		division.setDatetime(new Date());
		this.divisionConditionMapper.insert(division);

		return division;
	}
	
	@Override
	public Division addWithCategory(Division division, Integer categoryId, HttpSession session) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} 
		

		// step 3 : insert into db
		
		String uuid = UUIDUtils.genUUID();
		
		Category2Division category2Division = new Category2Division();
		category2Division.setId(UUIDUtils.genUUID());
		category2Division.setDivisionId(division.getId());
		category2Division.setCategoryId(categoryId);
		this.category2DivisionMapper.insert(category2Division);
		
		/*division.setId(uuid);
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		division.setUserId(sessionInfo.getUserId());
		division.setDatetime(new Date());
		division.setStatus(0);
		division.setTag(1);
		this.divisionMapper.insert(division);*/
		
		return division;
	}
	
	@Override
	public Division addForGroup(Division division, HttpSession session) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} else if (TextUtils.isEmpty(division.getName())) {
			throw new PmException("Parameter division.name is NULL or Empty.", 1);
		}
		
		// step 2 : check name
		boolean isNameExists = this.divisionConditionMapper.countByName(division.getName()) > 0;
		if (isNameExists) {
			throw new PmException("Division name already exists.", 2);
		}
		// TODO pid不重复
		
		// step 3 : insert into db
		
		String uuid = UUIDUtils.genUUID();
		
		division.setId(uuid);
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		division.setUserId(sessionInfo.getUserId());
		division.setDatetime(new Date());
		division.setStatus(0);
		division.setTag("g");
		this.divisionConditionMapper.insert(division);
		
		return division;
	}
	
	@Override
	public Division editWithCategory(Division division, Integer categoryId, HttpSession session) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} 
		
		Division dbDivision = this.divisionConditionMapper.selectById(division.getId());
		if (dbDivision == null) {
			throw new PmException("Division not found.", 2);
		}
		
		dbDivision.setName(division.getName());
		dbDivision.setDescription(division.getDescription());
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		dbDivision.setUserId(sessionInfo.getUserId());
		dbDivision.setDatetime(new Date());
		dbDivision.setStatus(division.getStatus());
		this.divisionConditionMapper.updateById(dbDivision);
		
		return division;
	}
	
	@Override
	public Division editForGroup(Division division, HttpSession session) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} else if (TextUtils.isEmpty(division.getName())) {
			throw new PmException("Parameter division.name is NULL or Empty.", 1);
		}
		
		Division dbDivision = this.divisionConditionMapper.selectById(division.getId());
		if (dbDivision == null) {
			throw new PmException("Division not found.", 2);
		}
		
		// step 2 : check name
		if(StringUtils.equals(dbDivision.getName(), division.getName()) == false){
			boolean isNameExists = this.divisionConditionMapper.countByName(division.getName()) > 0;
			if (isNameExists) {
				throw new PmException("Division name already exists.", 2);
			}
		}
		
		dbDivision.setName(division.getName());
		dbDivision.setDescription(division.getDescription());
		//dbDivision.setPid(division.getPid());
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		dbDivision.setUserId(sessionInfo.getUserId());
		dbDivision.setDatetime(new Date());
		dbDivision.setStatus(division.getStatus());
		this.divisionConditionMapper.updateById(dbDivision);
		
		return division;
	}



	@Override
	public Division get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		// step 2 : do search
		Division division = this.divisionConditionMapper.selectById(id);
		return division;
	}

	@Override
	public Division edit(String uid, Division division) throws PmException {
		// step 1 : check parameter(s)
		if (division == null) {
			throw new PmException("Parameter division is NULL.", 1);
		} else if (TextUtils.isEmpty(division.getId())) {
			throw new PmException("Parameter division.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(division.getName())) {
			throw new PmException("Parameter division.name is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(division.getUserId())) {
			throw new PmException("Parameter division.userId is NULL or Empty.", 1);
		}
		
		// step 2 : get current
		Division dbDivision = this.divisionConditionMapper.selectById(division.getId());
		if (dbDivision == null) {
			throw new PmException("Division not found.", 2);
		}
		
		// step 3 : check name
		if (!dbDivision.getName().equalsIgnoreCase(division.getName())) {
			boolean isNameExists = this.divisionConditionMapper.countByName(division.getName()) > 0;
			if (isNameExists) {
				throw new PmException("Division name already exists.", 3);
			}
		}
		
		// step 4 : check parent division
		if (!TextUtils.isEmpty(division.getPid())) {
			Division pdivision = this.divisionConditionMapper.selectById(division.getPid());
			if (pdivision == null) {
				throw new PmException("Parent division not found.", 4);
			}
		}

		// step 5 : do update
		dbDivision.setName(division.getName());
		dbDivision.setDescription(division.getDescription());
		dbDivision.setNameEng(division.getNameEng());
		dbDivision.setDepTitle(division.getDepTitle());
		dbDivision.setPid(division.getPid());
		dbDivision.setTag(division.getTag());
		dbDivision.setLevel(division.getLevel());
		dbDivision.setUserId(uid);
		dbDivision.setDatetime(new Date());
		dbDivision.setStatus(division.getStatus());
		this.divisionConditionMapper.updateById(dbDivision);
		
		return division;
	}

	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : get current
		Division dbDivision = this.divisionConditionMapper.selectById(id);
		if (dbDivision == null) {
			throw new PmException("Division not found.", 2);
		}
		
		// step 3 : clear user division
		this.user2divisionMapper.deleteByDivisionId(id);
		
		// step 4 : delete division
		this.divisionConditionMapper.deleteById(id);
	}

	@Override
	public List<Division> listAll(String uid) throws PmException {
		List<Division> list = this.divisionConditionMapper.selectAll();
		return list;
	}
	
	@Override
	public List<Division> listByUserId(String uid) throws PmException {
		List<Division> list = this.divisionConditionMapper.selectByUserId(uid);
		return list;
	}
	
	@Override
	public List<Division> listByCategoryId(Division division, Integer categoryId) throws PmException {
		//List<Division> list = this.divisionMapper.selectByCategoryId(division, categoryId);
		List<Division> list = new ArrayList<Division>();
		int count = this.divisionConditionMapper.countGroupByCategoryId(categoryId);
		if(count > 0){
			list = this.divisionConditionMapper.selectGroupByCategoryId(division, categoryId);
		}else{
			list = this.divisionConditionMapper.selectAllGroupForCategory(division);
		}
		
		return list;
	}

	@Override
	public List<DivisionImpl> listAvailable(String uid, String tag) throws PmException {
		List<DivisionImpl> list = this.divisionConditionMapper.selectByTag(tag);
		return list;
	}

	@Override
	public List<Division> listForGroup(Division division) throws PmException {
		List<Division> list = this.divisionConditionMapper.selectAllGroup();
		return list;
	}

	/**
	 * 搜索全部部门
	 * 
	 * @param uid 操作用户
	 * @return 部门列表
	 * @throws PmException
	 */
	public List<Division> selectForDivisionGroup(Division division)
			throws PmException {
		List<Division> list = this.divisionConditionMapper.selectForDivisionGroup(division);
		return list;
	}

	@Override
	public List<Division> select(Division division){
		return this.divisionConditionMapper.select(division);
	}
	
	/**
	 * 新增实体对象
	 * @param division
	 */
	public DivisionImpl insert(DivisionImpl division) throws PmException {
		this.divisionMapper.insert(division);
		return division;
	}

	/**
	 * 删除实体对象
	 * @param division
	 */
	public int delete(DivisionImpl division) throws PmException {
		return this.divisionMapper.delete(division);
	}

	/**
	 * 更新实体对象
	 * @param division
	 */
	public boolean update(DivisionImpl division) throws PmException {
		boolean result = true;
		this.divisionMapper.update(division);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param division
	 */
/*	@SuppressWarnings("unchecked")
	public List<DivisionImpl> select(DivisionImpl division) throws PmException {
		List<DivisionImpl> listRes = (List<DivisionImpl>) this.divisionMapper.select(division);
		return listRes;
	}*/
	/**
	 * 查询单个实体
	 * @param division
	 */
	public DivisionImpl get(DivisionImpl division) throws PmException {
		return (DivisionImpl) this.divisionMapper.get(division);
	}
	/**
	 * 查询实体分页列表
	 * @param division
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<DivisionImpl> search(DivisionImpl division) throws PmException {
		DataGrid<DivisionImpl> grid = new DataGrid<DivisionImpl>();
		Object obj = division;
		List list = divisionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = divisionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}
