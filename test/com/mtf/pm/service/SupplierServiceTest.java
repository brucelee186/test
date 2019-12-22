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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mtf.framework.dao.TransitGroupMapper;
import com.mtf.framework.model.TransitGroup;
import com.mtf.framework.service.ISupplierService;


/**
 * Description
 *
 * @author MTF_Liu_Xiaolei
 * @version 1.0	2013-5-17	MTF_Liu_Xiaolei		created.
 * @version <ver>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class SupplierServiceTest {
	private ISupplierService supplierService;
	
	@Autowired
	public void setSupplierService(ISupplierService supplierService) {
		this.supplierService = supplierService;
	}
	@Test
	public void listAllTransitGroup(){
		List<TransitGroup> list = this.supplierService.listAllTransitGroup("1");
		}

}
