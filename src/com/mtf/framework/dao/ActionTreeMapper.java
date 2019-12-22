package com.mtf.framework.dao;

import com.mtf.framework.model.ActionTree;

public interface ActionTreeMapper {

	int deleteById(String id);

	int insert(ActionTree record);

	ActionTree selectById(String id);

	int updateById(ActionTree record);
}