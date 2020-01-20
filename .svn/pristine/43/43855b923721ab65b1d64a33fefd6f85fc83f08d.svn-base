package com.mtf.pm.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;
import com.mtf.framework.model.Role;
import com.mtf.framework.service.IRoleService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class RoleServiceTest {

	private static final Logger	logger	= Logger.getLogger(RoleServiceTest.class);

	@Autowired
	IRoleService			roleService;

	@Before
	public void setup() {
	}

	@Test
	public void testListAllAvailable() throws Exception {
		List<Role> list = roleService.listAllAvailable("", null, null);
		Assert.notNull(list);
		logger.debug(JSONObject.toJSON(list).toString());
	}
}
