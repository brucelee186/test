package com.mtf.pm.controller.user;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.mtf.framework.controller.user.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring.xml", "classpath:spring-mybatis.xml", "classpath:spring-mvc.xml" })
public class UserControllerTest {

	private static final Logger	logger	= Logger.getLogger(UserControllerTest.class);

	@Autowired
	UserController				userController;

	MockMvc						mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	@Test
	public void testDoLogin() throws Exception {
		final String uri = "/user/doLogin.action";
		MockHttpServletRequestBuilder req = MockMvcRequestBuilders.post(uri);

		req.accept(MediaType.APPLICATION_JSON);
		req = req.param("uid", "sys");
		req = req.param("pwd", "sys");
		
		ResultActions ra = this.mockMvc.perform(req);
		MvcResult mr = ra.andReturn();
		
		String result = mr.getResponse().getContentAsString();
		logger.debug(result);
	}
}
