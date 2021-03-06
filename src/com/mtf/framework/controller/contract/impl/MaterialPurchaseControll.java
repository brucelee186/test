package com.mtf.framework.controller.contract.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.contract.ContractController;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.service.ContractService;
import com.mtf.framework.service.ItemsService;
import com.mtf.framework.util.Constants;


@Controller("materialPurchaseController")
@RequestMapping("/contract/materialPurchase")
public class MaterialPurchaseControll extends ContractController{
	
	private ContractService contractService;
	private ItemsService itemsService;
	
	@Autowired
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}
	@Autowired
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	
	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(ContractImpl contractImpl,HttpSession session) {
		contractImpl.setViewPath("contract/materialPurchase/searchMaterialPurchaseContract");
		return super.toSearch(contractImpl,session);
	}
	
	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<ContractImpl> doSearch(ContractImpl contractImpl, HttpSession session) throws Exception {
		return super.doSearch(contractImpl, session);
	}
	
	/**
	 * 跳转编辑
	 * @param contract
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(ContractImpl contractImpl, HttpSession session) throws Exception {
		contractImpl.setViewPath("contract/materialPurchase/editMaterialPurchaseContract");
		return super.toEdit(contractImpl, session);
	}

	/**
	 * 编辑
	 * @param contract
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit (ContractImpl contractImpl, HttpSession session) throws Exception {
		return super.doEdit(contractImpl, session);
	}
	/**
	 * 编辑
	 * @param contract
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/submitApprove", method = RequestMethod.GET)
	public ModelAndView submitApprove (ContractImpl contractImpl, HttpSession session) throws Exception {
		contractImpl.setViewPath("contract/materialPurchase/searchMaterialPurchaseContract");
		return super.submitApprove(contractImpl, session);
	}

	/**
	 * 合同变更
	 */
	@RequestMapping(value = "/modifyContract", method = RequestMethod.GET)
	public ModelAndView modifyContract(ContractImpl contractImpl, HttpSession session) {
		contractImpl.setViewPath("contract/materialPurchase/editMaterialPurchaseContract");
		return super.modifyContract(contractImpl, session);
	}
}
