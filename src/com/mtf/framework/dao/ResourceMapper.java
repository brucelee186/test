package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Resource;

public interface ResourceMapper {

	int deleteById(String id);

	int insert(Resource record);

	Resource selectById(String id);

	int updateById(Resource record);

	int updateByIdWithoutActionId(Resource record);

	int countByName(String name);

	int countByUri(String uri);

	List<Resource> selectBySearch(HashMap<String, Object> params);

	int countBySearch(HashMap<String, Object> params);

	List<Resource> selectAll();

	List<Resource> selectAllUnsigned(HashMap<String, Object> params);

	List<Resource> selectByActionId(String actionId);

	int updateActionId2Null(String actionId);

	Resource selectByUri(String uri);
	
	/**
	 * 搜索菜单
	 * @param resource
	 * @return
	 * @throws PmException
	 */
	List<Resource> selectMenu(Resource resource);
}