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
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.Category2DivisionMapper;
import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.RbsCategoryMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.IRbsCategoryService;

@Service("rbsCategoryService")
public class RbsCategoryServiceImpl implements IRbsCategoryService {

	private RbsCategoryMapper			rbsCategoryMapper;
	private Category2DivisionMapper		category2DivisionMapper;
	@Autowired
	private DivisionConditionMapper				divisionConditionMapper;

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
	public void setRbsCategoryMapper(RbsCategoryMapper rbsCategoryMapper) {
		this.rbsCategoryMapper = rbsCategoryMapper;
	}

	@Autowired
	public void setCategory2DivisionMapper(Category2DivisionMapper category2DivisionMapper) {
		this.category2DivisionMapper = category2DivisionMapper;
	}
	


	@Override
	public RbsCategory add(RbsCategory rbsCategory) throws PmException {
		// step 1 : check parameter(s)
		if (rbsCategory == null) {
			throw new PmException("Parameter rbsCategory is NULL.", 1);
		}
		
		// step 2 : check name
		/*boolean isNameExists = this.rbsCategoryMapper.countByName(rbsCategory.getCategoryName()) > 0;
		if (isNameExists) {
			throw new PmException("Category name already exists.", 2);
		}
*/
		// step 2 : insert into db
		if(rbsCategory.getPid() == null){
			rbsCategory.setPid(0);
			rbsCategory.setIdLevel(1);
		}else{
			rbsCategory.setIdLevel(2);
		}
		
		this.rbsCategoryMapper.insert(rbsCategory);

		return rbsCategory;
	}
	

	@Override
	public void delete(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}

		// step 3 : do delete
		int result = this.rbsCategoryMapper.deleteById(id);
		
		if(result == 0) {
			throw new PmException("RbsCategory not found.", 1);
		}
	}
	
	@Override
	public RbsCategory edit(RbsCategory rbsCategory) throws PmException {
		// step 1 : check parameter(s)
		if (rbsCategory == null) {
			throw new PmException("Parameter rbsCategory is NULL.", 1);
		}
		
		// step 2 : check exists
		RbsCategory dbCategory = this.rbsCategoryMapper.selectById(rbsCategory.getId());
		if (dbCategory == null) {
			throw new PmException("rbsCategory not found.", 2);
		}
		
		// step 4 : do update
		if(rbsCategory.getPid() == null){
			dbCategory.setPid(0);
			dbCategory.setIdLevel(1);
		}else{
			dbCategory.setIdLevel(2);
			dbCategory.setPid(rbsCategory.getPid());
		}
		dbCategory.setCategoryName(rbsCategory.getCategoryName());
		dbCategory.setCategoryDescription(rbsCategory.getCategoryDescription());
		dbCategory.setStatus(rbsCategory.getStatus());
		this.rbsCategoryMapper.updateById(dbCategory);
		
		return rbsCategory;
	}

	@Override
	public RbsCategory get(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		RbsCategory dbCategory = this.rbsCategoryMapper.selectById(id);
		return dbCategory;
	}

	@Override
	public DataGrid<RbsCategory> grid(RbsCategory rbsCategory, Page page) throws PmException {
		DataGrid<RbsCategory> result = new DataGrid<RbsCategory>();
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("xx", "C_xx");
			page.generateOrderBy(map);
		}
		
		// step 2 : get count;
		int count = rbsCategoryMapper.count(rbsCategory);
		result.setTotal(count);
		
		// step 3 : do query
		if (count > 0) {
			List<RbsCategory> trimList = this.rbsCategoryMapper.select(rbsCategory, page);
			// step 3 : fill result
			if (trimList != null && trimList.size() > 0) {
				result.setRows(trimList);
			}
		}
		
		return result;
	}
	
	@Override
	public List<RbsCategory> list(RbsCategory rbsCategory, Page page) throws PmException {
		// step 1 : do search
		List<RbsCategory> list = this.rbsCategoryMapper.select(rbsCategory, page);
		if (list == null) {
			list = new ArrayList<RbsCategory>();
		}
		
		return list;
	}
	
	@Override
	public List<RbsCategory> listForLv1(RbsCategory rbsCategory) throws PmException {
		// step 1 : do search
		List<RbsCategory> list = this.rbsCategoryMapper.selectForLv1(rbsCategory);
		if (list == null) {
			list = new ArrayList<RbsCategory>();
		}
		
		return list;
	}

}
