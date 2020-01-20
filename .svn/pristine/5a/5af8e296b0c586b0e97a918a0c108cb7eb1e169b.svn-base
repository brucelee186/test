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

import com.mtf.framework.dao.CategoryMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;
import com.mtf.framework.service.ICategoryService;

@Service("categoryService")
public class CategoryServiceImpl implements ICategoryService {

	private CategoryMapper		categoryMapper;

	@Autowired
	public void setCategoryMapper(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}
	@Override
	public Category add(Category category) throws PmException {
		// step 1 : check parameter(s)
		if (category == null) {
			throw new PmException("Parameter category is NULL.", 1);
		}

		// step 2 : insert into db
		this.categoryMapper.insert(category);

		return category;
	}

	@Override
	public void delete(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}

		// step 3 : do delete
		int result = this.categoryMapper.deleteById(id);
		
		if(result == 0) {
			throw new PmException("Category not found.", 1);
		}
	}
	
	@Override
	public Category edit(Category category) throws PmException {
		// step 1 : check parameter(s)
		if (category == null) {
			throw new PmException("Parameter category is NULL.", 1);
		}
		
		// step 2 : check exists
		Category dbCategory = this.categoryMapper.selectById(category.getId());
		if (dbCategory == null) {
			throw new PmException("category not found.", 2);
		}
		
		// step 4 : do update
//		dbCategory.setName(category.getName());
//		dbCategory.setStatus(category.getStatus());
//		dbCategory.setUpdateUserId(getUserId());
//		dbCategory.setUpdateUserName(getUserName());
//		dbCategory.setIndex(category.getIndex());
//		dbCategory.setUpdateDatetime(new Date());
		this.categoryMapper.updateById(dbCategory);
		
		return category;
	}

	@Override
	public Category get(Integer id) throws PmException {
		// step 1 : check parameter(s)
		if (id == null) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		Category dbCategory = this.categoryMapper.selectById(id);
		return dbCategory;
	}

	@Override
	public DataGrid<Category> grid(Category category, Page page) throws PmException {
		DataGrid<Category> result = new DataGrid<Category>();
		// step 1 : prepare parameters
		if(page != null && !StringUtils.isBlank(page.getSort())) {
			HashMap<String, String> map = new HashMap<String, String>();
			//map.put("xx", "C_xx");
			page.generateOrderBy(map);
		}
		
		// step 2 : get count;
		int count = categoryMapper.count(category);
		result.setTotal(count);;
		
		// step 3 : do query
		if (count > 0) {
			List<Category> trimList = this.categoryMapper.select(category, page);
			// step 3 : fill result
			if (trimList != null && trimList.size() > 0) {
				result.setRows(trimList);
			}
		}
		
		return result;
	}
	
	@Override
	public List<Category> list(Category category, Page page) throws PmException {
		// step 1 : do search
		List<Category> list = this.categoryMapper.select(category, page);
		if (list == null) {
			list = new ArrayList<Category>();
		}
		
		return list;
	}
}
