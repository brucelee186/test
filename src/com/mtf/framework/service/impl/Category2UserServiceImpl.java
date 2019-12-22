package com.mtf.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.Category2UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Category2User;
import com.mtf.framework.service.ICategory2UserService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.UUIDUtils;


@Service("category2UserService")
public class Category2UserServiceImpl extends CommonServiceImpl implements ICategory2UserService {
	
	
	private Category2UserMapper category2UserMapper;

	@Autowired
	public void setCategory2UserMapper(Category2UserMapper category2UserMapper) {
		this.category2UserMapper = category2UserMapper;
	}

	@Override
	public Category2User add(Category2User category2User) throws PmException {
		category2User.setId(UUIDUtils.genUUID());
		this.category2UserMapper.insert(category2User);
		
		return category2User;
	}
	
	@Override
	public Category2User edit(Category2User category2User, List<String> userIds) throws PmException {
		
		//删除同类别下相关的行政人员
		this.category2UserMapper.deleteByCategoryId(category2User.getCategoryId());
		
		//添加选择的行政人员
		for (String userId : userIds) {
			category2User.setId(UUIDUtils.genUUID());
			category2User.setUserId(userId);
			this.category2UserMapper.insert(category2User);
		}
		
		return category2User;
	}

	/**
	 * 删除对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public int delete(String id) throws PmException {
		return category2UserMapper.deleteById(id);
	}
	

	

}
