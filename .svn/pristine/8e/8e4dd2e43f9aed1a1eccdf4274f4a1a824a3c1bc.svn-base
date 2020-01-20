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
package com.mtf.framework.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtf.framework.dao.UserDetailMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.service.AttenVacateManageService;
import com.mtf.framework.service.UserDetailService;

@Component("taskCreaterOverwork")
public class TaskCreaterOverwork {
	
	@Autowired
	private AttenVacateManageService attenVacateManageService;
	
	public AttenVacateManageService getAttenVacateManageService() {
		return attenVacateManageService;
	}

	public void setAttenVacateManageService(
			AttenVacateManageService attenVacateManageService) {
		this.attenVacateManageService = attenVacateManageService;
	}

	public void run() {
		try {
			// 取得未更新的更新员工加班记录
			AttenVacateManageImpl attenVacateManage = new AttenVacateManageImpl();
			attenVacateManage.setTagCreateOverwork("n");
			attenVacateManage = attenVacateManageService.get(attenVacateManage);
			if(null != attenVacateManage){
				attenVacateManageService.updateWorkOvertime(attenVacateManage);
			}
		} catch (PmException e) {
			e.printStackTrace();
		}
		
	}
}