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
package com.mtf.pm.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.alibaba.fastjson.JSONObject;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.FabricType;
import com.mtf.framework.service.IFabricTypeService;
import com.mtf.framework.service.UserService;


/**
 * Description
 *
 * @author DaiXin.Wang
 * @version 1.0	2013-5-16	DaiXin.Wang		created.
 * @version <ver>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class FabricTypeServiceTest {
	
	private static final Logger	logger	= Logger.getLogger(FabricTypeServiceTest.class);
	
	@Autowired
	UserService userService;
	
	@Before
	public void setup(){
		
	}
	@Test
	public void testlist() throws Exception{
		List<FabricType> fabricList=userService.listByPid("460f4f88-52c2-4d50-8275-0d0739e6237d", "eee52b11-c8ba-4029-9a44-e224f4744e9d");
		Assert.assertNotNull(fabricList);
		logger.debug(JSONObject.toJSON(fabricList).toString());
		
		
		
	}

}
