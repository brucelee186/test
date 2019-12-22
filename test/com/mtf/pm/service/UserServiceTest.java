package com.mtf.pm.service;

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
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.page.UserSearchDataGridItem;
import com.mtf.framework.model.page.UserSearchForm;
import com.mtf.framework.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserServiceTest {

	private static final Logger	logger	= Logger.getLogger(UserServiceTest.class);

	@Autowired
	UserService			userService;

	@Before
	public void setup() {
	}

	@Test
	public void testGetAsLogin() throws Exception {
		User user = new User();
		user.setLoginname("sys");
		user.setPassword("123456");
		SessionInfo sessionInfo = userService.getAsLogin(user);
		Assert.notNull(sessionInfo);
		logger.debug(JSONObject.toJSON(sessionInfo).toString());
	}
	
	@Test
	public void testList() throws Exception {
		UserSearchForm form = new UserSearchForm();
		form.setPage(1);
		form.setRows(100);
		DataGrid<UserSearchDataGridItem> result = userService.list("", form);
		Assert.notNull(result);
		logger.debug(JSONObject.toJSON(result).toString());
	}
}
