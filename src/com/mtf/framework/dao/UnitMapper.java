package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.Unit;



public interface UnitMapper extends CommonMapper{
	Unit selectById(String id);
	
	List<Unit> selectByName(Unit record);

	List<Unit> selectAll(HashMap<String, Object> param);
	
	List<Unit> selectAllAvailable(HashMap<String, Object> param);



}