package com.mtf.framework.dao;

import java.util.HashMap;
import java.util.List;

import com.mtf.framework.dao.common.CommonMapper;
import com.mtf.framework.model.Goods;

public interface GoodsMapper extends CommonMapper{
	List<Goods> selectBySearch(HashMap<String, Object> param);
	int countBySearch(HashMap<String, Object> param);

}