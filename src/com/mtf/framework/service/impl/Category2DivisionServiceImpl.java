package com.mtf.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.Category2DivisionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category2Division;
import com.mtf.framework.service.ICategory2DivisionService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.UUIDUtils;


@Service("category2DivisionService")
public class Category2DivisionServiceImpl extends CommonServiceImpl implements ICategory2DivisionService {
	
	
	private Category2DivisionMapper category2DivisionMapper;

	@Autowired
	public void setCategory2DivisionMapper(Category2DivisionMapper category2DivisionMapper) {
		this.category2DivisionMapper = category2DivisionMapper;
	}

	@Override
	public Category2Division add(Category2Division category2Division) throws PmException {
		category2Division.setId(UUIDUtils.genUUID());
		this.category2DivisionMapper.insert(category2Division);
		
		return category2Division;
	}

	@Override
	public Category2Division edit(Category2Division category2Division, List<String> divisionIds) throws PmException {
		
		//删除同类别下相关的行政人员
		this.category2DivisionMapper.deleteByCategoryId(category2Division.getCategoryId());
		
		//添加选择的行政人员
		for (String divisionId : divisionIds) {
			category2Division.setId(UUIDUtils.genUUID());
			category2Division.setDivisionId(divisionId);
			this.category2DivisionMapper.insert(category2Division);
		}
		
		return category2Division;
	}
	
	/**
	 * 删除对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public int delete(String id) throws PmException {
		return category2DivisionMapper.deleteById(id);
	}
	

	

}
