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
import com.mtf.framework.dao.ResourceMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Action;
import com.mtf.framework.model.Resource;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.model.page.ResourceSearchForm;
import com.mtf.framework.service.ResourceService;
import com.mtf.framework.util.TextUtils;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {
	private static final Logger	logger	= Logger.getLogger(ResourceServiceImpl.class);

	private ActionMapper		actionMapper;
	private ResourceMapper		resourceMapper;

	@Autowired
	public void setActionMapper(ActionMapper actionMapper) {
		this.actionMapper = actionMapper;
	}
	
	@Autowired
	public void setResourceMapper(ResourceMapper resourceMapper) {
		this.resourceMapper = resourceMapper;
	}

	@Override
	public Resource add(String uid, Resource resource) throws PmException {
		// step 1 : check parameter(s)
		if (resource == null) {
			throw new PmException("Parameter resource is NULL.", 1);
		} else if (TextUtils.isEmpty(resource.getName())) {
			throw new PmException("Parameter resource.name is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(resource.getUri())) {
			throw new PmException("Parameter resource.uri is NULL or Empty.", 1);
		} 
//		else if (resource.getLevel() < 1 || resource.getLevel() > 9) {
//			throw new PmException("Parameter resource.level not in [1-9].", 1);
//		} else if (resource.getAccess() < 1 || resource.getAccess() > 9) {
//			throw new PmException("Parameter resource.access not in [1-9].", 1);
//		}
		
		// step 2 : check name
		/*boolean isNameExists = this.resourceMapper.countByName(resource.getName()) > 0;
		if (isNameExists) {
			throw new PmException("Resource name already exists.", 2);
		}*/

		// step 3 : check uri
		/*boolean isUriExists = this.resourceMapper.countByUri(resource.getUri()) > 0;
		if (isUriExists) {
			throw new PmException("Resource uri already exists.", 3);
		}*/

		// step 4 : insert into db
		resource.setId(UUID.randomUUID().toString());
		Date date = new Date();
		resource.setAddDate(date);
		resource.setModifiedDate(date);
		this.resourceMapper.insert(resource);
		return resource;
	}
	
	@Override
	public Resource edit(String uid, Resource resource) throws PmException {
		// step 1 : check parameter(s)
		if (resource == null) {
			throw new PmException("Parameter resource is NULL.", 1);
		} else if (TextUtils.isEmpty(resource.getId())) {
			throw new PmException("Parameter resource.id is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(resource.getName())) {
			throw new PmException("Parameter resource.name is NULL or Empty.", 1);
		} else if (TextUtils.isEmpty(resource.getUri())) {
			throw new PmException("Parameter resource.uri is NULL or Empty.", 1);
		} 
		/*else if (resource.getLevel() < 1 || resource.getLevel() > 9) {
			throw new PmException("Parameter resource.level not in [1-9].", 1);
		} else if (resource.getAccess() < 1 || resource.getAccess() > 9) {
			throw new PmException("Parameter resource.access not in [1-9].", 1);
		}*/
		
		// step 2 : check exists
		Resource dbResource = this.resourceMapper.selectById(resource.getId());
		if (dbResource == null) {
			throw new PmException("Resource not found.", 2);
		}
		
		// step 3 : check name
		if (!dbResource.getName().equalsIgnoreCase(resource.getName())) {
			boolean isNameExists = this.resourceMapper.countByName(resource.getName()) > 0;
			if (isNameExists) {
				throw new PmException("Resource name already exists.", 3);
			}
		}
		
		// step 4 : check uri
		if (!dbResource.getUri().equalsIgnoreCase(resource.getUri())) {
			boolean isUriExists = this.resourceMapper.countByUri(resource.getUri()) > 0;
			if (isUriExists) {
				throw new PmException("Resource uri already exists.", 4);
			}
		}
		
		// step 5 : do update
		dbResource.setName(resource.getName());
		dbResource.setUri(resource.getUri());
		dbResource.setLevel(resource.getLevel());
		dbResource.setDescription(resource.getDescription());
		dbResource.setAccess(resource.getAccess());
		dbResource.setModifiedDate(new Date());
		this.resourceMapper.updateByIdWithoutActionId(dbResource);
		
		return resource;
	}
	
	@Override
	public Resource get(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : do search
		Resource resource = this.resourceMapper.selectById(id);
		return resource;
	}
	
	@Override
	public void delete(String uid, String id) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(id)) {
			throw new PmException("Parameter id is NULL or Empty.", 1);
		}
		
		// step 2 : check exists
		Resource resource = this.resourceMapper.selectById(id);
		if (resource == null) {
			throw new PmException("Resource not found.", 2);
		}
		
		// step 3 : do delete
		this.resourceMapper.deleteById(id);
	}

	@Override
	public DataGrid<Resource> list(String uid, ResourceSearchForm form) throws PmException {
		DataGrid<Resource> result = new DataGrid<Resource>();

		// step 1 : prepare parameters
		if (form == null) {
			form = new ResourceSearchForm();
		}
		HashMap<String, Object> params = new HashMap<String, Object>();
		
		if (!TextUtils.isEmpty(form.getName())) {
			params.put("name", form.getName());
		}
		if (!TextUtils.isEmpty(form.getUri())) {
			params.put("uri", form.getUri());
		}
		if (!TextUtils.isEmpty(form.getUri())) {
		}
		if (form.getLevel() != null && form.getLevel() > 0 && form.getLevel() < 10) {
			params.put("level", form.getLevel());
		}
		if (form.getAccess() != null && form.getAccess() > 0 && form.getAccess() < 10) {
			params.put("access", form.getAccess());
		}
		if (!TextUtils.isEmpty(form.getSort())) {
			String formSort = form.getSort();
			String sort = null;
			if ("name".equalsIgnoreCase(formSort)) {
				sort = "name";
			} else if ("uri".equalsIgnoreCase(formSort)) {
				sort = "uri";
			} else if ("level".equalsIgnoreCase(formSort)) {
				sort = "level";
			} else if ("access".equalsIgnoreCase(formSort)) {
				sort = "access";
			}
			if (sort != null) {
				params.put("sort", sort);
				if (!TextUtils.isEmpty(form.getOrder())) {
					params.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
				}
			}
		}
		params.put("startIndex", form.getStartIndex());
		params.put("pageSize", form.getRows());
		
		// step 2 : get count
		int count = this.resourceMapper.countBySearch(params);
		result.setTotal(count);
		
		// step 3 :  get detail
		if (count > 0) {
			List<Resource> resourceList = this.resourceMapper.selectBySearch(params);
			// step 3 : fill result
			if (resourceList != null && resourceList.size() > 0) {
				result.setRows(resourceList);
			}
		}
		return result;
	}

	@Override
	public List<Resource> listAll(String uid) throws PmException {
		List<Resource> list = this.resourceMapper.selectAll();
		return list;
	}
	
	@Override
	public List<Resource> listAllUnsigned(String uid, PageForm form) throws PmException {
		// step 1 : prepare parameters
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		if ("name".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "name");
		} else if ("level".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "level");
		} else if ("uri".equalsIgnoreCase(form.getSort())) {
			param.put("sort", "uri");
		}
		param.put("order", "desc".equalsIgnoreCase(form.getOrder()) ? "DESC" : "ASC");
		
		// step 2 : do search
		List<Resource> list = this.resourceMapper.selectAllUnsigned(param);
		return list;
	}

	@Override
	public List<Resource> listByActionId(String uid, String actionId) throws PmException {
		// step 1 : check parameter(s)
		if (TextUtils.isEmpty(actionId)) {
			throw new PmException("Parameter actionId is NULL or Empty.", 1);
		}
		
		// step 2 : check action exists
		Action action = this.actionMapper.selectById(actionId);
		if (action == null) {
			throw new PmException("Action not found.", 2);
		}
		
		// step 3 : do search
		List<Resource> list = this.resourceMapper.selectByActionId(actionId);
		return list;
	}

	/**
	 * 搜索菜单
	 * @param resource
	 * @return
	 * @throws PmException
	 */
	public List<Resource> selectMenu(Resource resource) throws PmException {
		return this.resourceMapper.selectMenu(resource);
	}
}
