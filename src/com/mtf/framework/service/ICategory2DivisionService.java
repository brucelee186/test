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
import com.mtf.framework.model.Category2Division;

/**
 * 类别部门相关服务接口
 *
 * @author Bill.Qi
 * @version 1.0	2014-4-13	Bill.Qi		created.
 * @version <ver>
 */
public interface ICategory2DivisionService {
	
	Category2Division add(Category2Division category2Division) throws PmException;
	
	int delete(String id) throws PmException;
	
	Category2Division edit(Category2Division category2Division, List<String> divisionIds) throws PmException;
	
}
