package com.mtf.framework.controller.reimbursement;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.PurchaseItem;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.PurchaseItemImpl;
import com.mtf.framework.service.PurchaseItemService;
import com.mtf.framework.util.JacksonUtils;
import com.mtf.framework.util.NumberUtils;


@Controller("purchaseItemController")
@RequestMapping("/office/reimbursement/purchaseItem")
public class PurchaseItemController extends BaseController {

	private PurchaseItemService purchaseItemService;
	
	@Autowired
	public void setPurchaseItemService(PurchaseItemService purchaseItemService) {
		this.purchaseItemService = purchaseItemService;
	}

	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public List<PurchaseItemImpl> doSearch(PurchaseItemImpl purchaseItem, HttpSession session) throws Exception {
		List<PurchaseItemImpl> list = new ArrayList<PurchaseItemImpl>();
		
		list = this.purchaseItemService.select(purchaseItem);
		return list;
	}
	
	@RequestMapping(value="/doSearchWithPurchase", method=RequestMethod.POST)
	@ResponseBody
	public List<PurchaseItemImpl> doSearchWithPurchase(PurchaseItemImpl purchaseItem, String no, HttpSession session) throws Exception {
		List<PurchaseItemImpl> list = new ArrayList<PurchaseItemImpl>();
		
		list = this.purchaseItemService.selectWithPurchase(purchaseItem, no, session);
		return list;
	}
	
	

}	
	

	
	
