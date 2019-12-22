package com.mtf.framework.controller.reimbursement;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.service.ReimbursementItemService;


@Controller("reimbursementItemController")
@RequestMapping("/office/reimbursement/reimbursementItem")
public class ReimbursementItemController extends BaseController {

	private ReimbursementItemService reimbursementItemService;
	
	@Autowired
	public void setReimbursementItemService(ReimbursementItemService reimbursementItemService) {
		this.reimbursementItemService = reimbursementItemService;
	}	

}	

