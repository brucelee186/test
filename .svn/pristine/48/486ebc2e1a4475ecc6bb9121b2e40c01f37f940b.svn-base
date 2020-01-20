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
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.UnitMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Unit;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.service.IUnitService;
import com.mtf.framework.util.TextUtils;



@Service("unitService")
public class UnitServiceImpl implements IUnitService {
	private static final Logger	logger	= Logger.getLogger(UnitServiceImpl.class);

	private UnitMapper			unitMapper;

	@Autowired
	public void setUnitMapper(UnitMapper unitMapper) {
		this.unitMapper = unitMapper;
	}

	@Override
	public Unit add(String uid, Unit unit) throws PmException {
		// step 1 : check parameter(s)
		if (unit == null) {
			throw new PmException("Parameter unit is NULL.", 1);
		}
		// step 2 : check exists
			List<Unit> selectByName = this.unitMapper.selectByName(unit);
			if (selectByName != null && !selectByName.isEmpty()) {
				throw new PmException("Unit already exists.", 2);
				}
		// step 3 : insert into db
		unit.setAddUser(uid);
		unit.setModified(new Date().getTime());
		this.unitMapper.insert(unit);
		return unit;
	}
	
	@Override
	public Unit edit(String uid, Unit unit) throws PmException {
		// step 1 : check parameter(s)
		if (unit == null) {
			throw new PmException("Parameter unit is NULL.", 1);
		} else if (TextUtils.isEmpty(unit.getId())) {
			throw new PmException("Parameter unit.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(unit.getName())) {
			throw new PmException("Parameter unit.from is NULL or Empty.", 1);
		} 
		// step 2 : check exists
		Unit dbUnit = this.unitMapper.selectById(unit.getId());
		if (dbUnit == null) {
			throw new PmException("Unit not found.", 2);
		}
		
		// step 3 : check exists
		if (!dbUnit.getName().equalsIgnoreCase(unit.getName())) {
			List<Unit> selectByName = this.unitMapper.selectByName(unit);
			if (selectByName!= null && !selectByName.isEmpty()) {
				throw new PmException("Unit already exists.", 3);
			}
		}
		
		// step 4 : do update
		dbUnit.setName(unit.getName());
		dbUnit.setAddDate(new Date());
		dbUnit.setModifiedDate(new Date());
		dbUnit.setStatus(unit.getStatus());
		dbUnit.setModifiedUser(uid);
		this.unitMapper.update(unit);
		return unit;
	}
	
	@Override
	public Unit get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		Unit unit = this.unitMapper.selectById(id);
		return unit;
	}
	
	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		Unit unit = this.unitMapper.selectById(id);
		if (unit == null) {
			throw new PmException("Resource not found.", 1);
		}
		
		// step 3 : do delete
		this.unitMapper.delete(id);
	}

	@Override
	public List<Unit> listAll(String uid, PageForm form) throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("from".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "C_FROM");
		} else if ("to".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "C_TO");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		
		// step 2 : do search
		List<Unit> list = this.unitMapper.selectAll(param);
		return list;
	}
	
	@Override
	public List<Unit> listAllAvailable(String uid, PageForm form) throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("from".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "C_FROM");
		} else if ("to".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "C_TO");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		
		// step 2 : do search
		List<Unit> list = this.unitMapper.selectAllAvailable(param);
		return list;
	}


}
