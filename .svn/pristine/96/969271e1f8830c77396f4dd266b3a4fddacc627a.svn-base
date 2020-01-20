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

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Page;

public interface IRbsCategoryService {

	RbsCategory add(RbsCategory rbsCategory) throws PmException;
	
	RbsCategory edit(RbsCategory rbsCategory) throws PmException;

	RbsCategory get(Integer id) throws PmException;

	void delete(Integer id) throws PmException;
	
	List<RbsCategory> list(RbsCategory rbsCategory, Page page) throws PmException;
	
	List<RbsCategory> listForLv1(RbsCategory rbsCategory) throws PmException;

	DataGrid<RbsCategory> grid(RbsCategory rbsCategory, Page page) throws PmException;
}
