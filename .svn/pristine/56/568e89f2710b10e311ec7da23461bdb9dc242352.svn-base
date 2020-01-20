package com.mtf.framework.controller.reimbursement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.PurchaseItemImpl;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.IRbsCategoryService;
import com.mtf.framework.service.PurchaseItemService;
import com.mtf.framework.service.PurchaseService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.JacksonUtils;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.PoiUtils;
import com.mtf.framework.util.UUIDUtils;

@Controller("purchaseController")
@RequestMapping("/office/reimbursement/purchase")
public class PurchaseController extends BaseController {

	private PurchaseService 		purchaseService;
	private PurchaseItemService 	purchaseItemService;
	private IRbsCategoryService		rbsCategoryService;
	private IDivisionService		divisionService;
	private UserService				userService;

	@Autowired
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@Autowired
	public void setPurchaseItemService(PurchaseItemService purchaseItemService) {
		this.purchaseItemService = purchaseItemService;
	}
	
	@Autowired
	public void setRbsCategoryService(IRbsCategoryService rbsCategoryService) {
		this.rbsCategoryService = rbsCategoryService;
	}
	
	@Autowired
	public void setDivisionService(IDivisionService divisionService) {
		this.divisionService = divisionService;
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping("/toMyPurchase")
	public ModelAndView toMyPurchase(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/myPurchase");
		List<RbsCategory> rbsCategoryList = null;
		List<Division> divisionList = null;
		List<Division> itemDivisionList = null;
		try {
			RbsCategory rbsCategory = new RbsCategory();
			rbsCategory.setStatus(0);
			rbsCategoryList = this.rbsCategoryService.list(rbsCategory, null);
			divisionList = this.divisionService.listByUserId(sessionInfo.getUserId());
			//如果是行政部就查所有部门
			int count = this.userService.countAdminByUserId(sessionInfo.getUserId());
			if(count > 0){
				itemDivisionList = this.divisionService.listAll(null);
			}else{
				itemDivisionList = divisionList;
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		mv.addObject("categorysJson", JacksonUtils.objectToJson(rbsCategoryList));
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		mv.addObject("itemDivisionsJson", JacksonUtils.objectToJson(itemDivisionList));
		mv.addObject("purchase", purchase);
		return mv;
	}
	
	@RequestMapping("/toMyQuote")
	public ModelAndView toMyQuote(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/myQuote");
		List<RbsCategory> rbsCategoryList = null;
		List<Division> divisionList = null;
		List<Division> itemDivisionList = null;
		try {
			RbsCategory rbsCategory = new RbsCategory();
			rbsCategory.setStatus(0);
			rbsCategoryList = this.rbsCategoryService.list(rbsCategory, null);
			divisionList = this.divisionService.listByUserId(sessionInfo.getUserId());
			//如果是行政部就查所有部门
			int count = this.userService.countAdminByUserId(sessionInfo.getUserId());
			if(count > 0){
				itemDivisionList = this.divisionService.listAll(null);
			}else{
				itemDivisionList = divisionList;
			}
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		mv.addObject("categorysJson", JacksonUtils.objectToJson(rbsCategoryList));
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		mv.addObject("itemDivisionsJson", JacksonUtils.objectToJson(itemDivisionList));
		mv.addObject("purchase", purchase);
		return mv;
	}
	
	@RequestMapping("/toApproveLv1")
	public ModelAndView toApproveLv1(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/waitingApproveLv1");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listByUserId(sessionInfo.getUserId());
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toApproveLv2")
	public ModelAndView toApproveLv2(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/waitingApproveLv2");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toCheck")
	public ModelAndView toCheck(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/checkPurchase");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toHistoryApprove")
	public ModelAndView toHistoryApprove(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/historyApprove");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	
	@RequestMapping("/toEvaluate")
	public ModelAndView toEvaluate(PurchaseImpl purchase, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/waitingEvaluate");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toPurchase")
	public ModelAndView toPurchase(PurchaseImpl purchase, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/waitingPurchase");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toHistoryPurchase")
	public ModelAndView toHistoryPurchase(PurchaseImpl purchase, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/historyPurchase");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		mv.addObject("purchase", purchase);
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toMyWatch")
	public ModelAndView toMyWatch(PurchaseImpl purchase, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/myWatcher");
		List<Division> divisionList = null;
		
		divisionList = this.divisionService.listAll(null);
		
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		return mv;
	}
	
	@RequestMapping("/toPurchaseReport")
	public ModelAndView toPurchaseReport(PurchaseImpl purchase, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/purchaseReport");
		return mv;
	}
	
	
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(PurchaseImpl purchase, String purchaseItemStr, HttpSession session) throws PmException {
		Json j = new Json();
		List<Message> errList = new ArrayList<Message>();
		//purchase validation
		if(purchase.getStatus() == null || (NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT) == false
				&& NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		//validation
		if (StringUtils.isBlank(purchase.getApplicantdivisionId()) ||StringUtils.isBlank(purchase.getApplicantdivisionName())) {
			errList.add(new Message("applicantDivision", "Parameter ApplicantDivision is required."));
		}
		
		//item validation
		if (StringUtils.isBlank(purchaseItemStr)) {
			throw new PmException("Paramater 'purchaseItemStr' is required!");
		}
		
		List<PurchaseItemImpl> itemList = JacksonUtils.jsonArrayToList(purchaseItemStr, PurchaseItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'purchaseItemStr' is invalid!");
		}
		for (PurchaseItemImpl purchaseItem : itemList) {
			if(StringUtils.isBlank(purchaseItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required."));
			}
			if(StringUtils.isBlank(purchaseItem.getDivisionId()) || StringUtils.isBlank(purchaseItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required."));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		// process
		try {
			this.purchaseService.insert(purchase, itemList, session);
			
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doAddForQuote", method=RequestMethod.POST)
	@ResponseBody
	public Json doAddForQuote(PurchaseImpl purchase, String purchaseItemStr, HttpSession session) throws PmException {
		Json j = new Json();
		List<Message> errList = new ArrayList<Message>();
		//purchase validation
		if(purchase.getStatus() == null || (NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_QUOTE) == false
				&& NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		
		//validation
		if (StringUtils.isBlank(purchase.getApplicantdivisionId()) ||StringUtils.isBlank(purchase.getApplicantdivisionName())) {
			errList.add(new Message("applicantDivision", "Parameter ApplicantDivision is required."));
		}
		if (StringUtils.isBlank(purchase.getQuoteCurrencyId())) {
			errList.add(new Message("currencyId", "Parameter CurrencyId is required."));
		}
		if (!NumberUtils.between(purchase.getExchangeRate(), 0, 100)) {
			errList.add(new Message("exchangeRate", "Parameter ExchangeRate is invalid."));
		}
		
		//item validation
		if (StringUtils.isBlank(purchaseItemStr)) {
			throw new PmException("Paramater 'purchaseItemStr' is required!");
		}
		
		List<PurchaseItemImpl> itemList = JacksonUtils.jsonArrayToList(purchaseItemStr, PurchaseItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'purchaseItemStr' is invalid!");
		}
		for (PurchaseItemImpl purchaseItem : itemList) {
			if(StringUtils.isBlank(purchaseItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required!"));
			}
			if(StringUtils.isBlank(purchaseItem.getDivisionId()) || StringUtils.isBlank(purchaseItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required!"));
			}
			if(NumberUtils.between(purchaseItem.getQuoteAmount(), 0, 100000) == false){
				errList.add(new Message("quoteAmount", "Parameter quoteAmount is invalid!"));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		// process
		try {
			this.purchaseService.insertForQuote(purchase, itemList, session);
			
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(PurchaseImpl purchase, String purchaseItemStr, HttpSession session) throws PmException {
		Json j = new Json();	
		List<Message> errList = new ArrayList<Message>();
		//purchase validation
		if(purchase.getStatus() == null || (NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT) == false
				&& NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		
		//validation
		if (StringUtils.isBlank(purchase.getApplicantdivisionId()) ||StringUtils.isBlank(purchase.getApplicantdivisionName())) {
			errList.add(new Message("applicantDivision", "Parameter ApplicantDivision is required."));
		}
		
		//item validation
		if (StringUtils.isBlank(purchaseItemStr)) {
			throw new PmException("Paramater 'purchaseItemStr' is required!");
		}
		
		List<PurchaseItemImpl> itemList = JacksonUtils.jsonArrayToList(purchaseItemStr, PurchaseItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'purchaseItemStr' is invalid!");
		}
		
		
		for (PurchaseItemImpl purchaseItem : itemList) {
			if(StringUtils.isBlank(purchaseItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required."));
			}
			if(StringUtils.isBlank(purchaseItem.getDivisionId()) || StringUtils.isBlank(purchaseItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required."));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			//purchase.setTotalAmount(itemList.get(0).getQuoteAmount());
			this.purchaseService.update(purchase, itemList, session);
			j.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		}catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditForQuote", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditForQuote(PurchaseImpl purchase, String purchaseItemStr, HttpSession session) throws PmException {
		Json j = new Json();	
		List<Message> errList = new ArrayList<Message>();
		//purchase validation
		if(purchase.getStatus() == null || (NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_QUOTE) == false
				&& NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		
		//validation
		if (StringUtils.isBlank(purchase.getApplicantdivisionId()) ||StringUtils.isBlank(purchase.getApplicantdivisionName())) {
			errList.add(new Message("no", "Parameter ApplicantDivision is required."));
		}
		if (StringUtils.isBlank(purchase.getQuoteCurrencyId())) {
			errList.add(new Message("currencyId", "Parameter CurrencyId is required."));
		}
		if (!NumberUtils.between(purchase.getExchangeRate(), 0, 100)) {
			errList.add(new Message("exchangeRate", "Parameter ExchangeRate is invalid."));
		}
		
		//item validation
		if (StringUtils.isBlank(purchaseItemStr)) {
			throw new PmException("Paramater 'purchaseItemStr' is required!");
		}
		
		List<PurchaseItemImpl> itemList = JacksonUtils.jsonArrayToList(purchaseItemStr, PurchaseItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'purchaseItemStr' is invalid!");
		}
		
		for (PurchaseItemImpl purchaseItem : itemList) {
			if(StringUtils.isBlank(purchaseItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required."));
			}
			if(StringUtils.isBlank(purchaseItem.getDivisionId()) || StringUtils.isBlank(purchaseItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required."));
			}
			if(NumberUtils.between(purchaseItem.getQuoteAmount(), 0, 100000) == false){
				errList.add(new Message("quoteAmount", "Parameter quoteAmount is invalid!"));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			this.purchaseService.updateForQuote(purchase, itemList, session);
			j.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		}catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditQuoteAmount", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditQuoteAmount(PurchaseImpl purchase, String purchaseItemStr, HttpSession session) throws PmException {
		Json j = new Json();
		
		List<Message> errList = new ArrayList<Message>();
		
		//item validation
		if (StringUtils.isBlank(purchaseItemStr)) {
			throw new PmException("Paramater 'purchaseItemStr' is required!");
		}
		
		List<PurchaseItemImpl> itemList = JacksonUtils.jsonArrayToList(purchaseItemStr, PurchaseItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'purchaseItemStr' is invalid!");
		}
		
		for (PurchaseItemImpl purchaseItem : itemList) {
			if(NumberUtils.between(purchaseItem.getQuoteAmount(), 0, 100000) == false){
				errList.add(new Message("quoteAmount", "Parameter QuoteAmount is invalid."));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			this.purchaseService.updateQuoteAmount(purchase, itemList, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditStatusSubmit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusSubmit(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			purchase.setStatus(PurchaseImpl.STATUS_SUBMIT);
			this.purchaseService.updateForStatus(purchase, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditStatusQuote", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusQuote(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			purchase.setStatus(PurchaseImpl.STATUS_QUOTE);
			this.purchaseService.updateForStatus(purchase, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doBatchEditStatusPurchase", method=RequestMethod.POST)
	@ResponseBody
	public Json doBatchEditStatusPurchase(PurchaseImpl purchase, String ids, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			if (StringUtils.isBlank(ids)) {
				throw new PmException("Paramater 'ids' is required!");
			}
			
			List<String> idsList = JacksonUtils.jsonArrayToList(ids, String.class);
			if(idsList.size() == 0){
				throw new PmException("Paramater 'ids' is invalid!");
			}
			for (String purchaseId : idsList) {
				if (!UUIDUtils.isValidUUID(purchaseId)) {
					throw new PmException("Paramater 'purchaseId' is invalid!");
				}
			}
			
			purchase.setStatus(PurchaseImpl.STATUS_PURCHASED);
			this.purchaseService.updateBatchForStatus(purchase, idsList, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditStatusComplete", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusComplete(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			purchase.setStatus(PurchaseImpl.STATUS_COMPLETE);
			this.purchaseService.updateForStatus(purchase, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	

	@RequestMapping(value="/doApproveLv1", method=RequestMethod.POST)
	@ResponseBody
	public Json doApproveLv1(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			this.purchaseService.updateForStatusLv1(purchase, comment, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doBatchApproveLv1", method=RequestMethod.POST)
	@ResponseBody
	public Json doBatchApproveLv1(String ids, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			if (StringUtils.isBlank(ids)) {
				throw new PmException("Paramater 'idsStr' is required!");
			}
			
			List<String> idsList = JacksonUtils.jsonArrayToList(ids, String.class);
			if(idsList.size() == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String purchaseId : idsList) {
				if (!UUIDUtils.isValidUUID(purchaseId)) {
					throw new PmException("Paramater 'purchaseId' is invalid!");
				}
			}
			
			this.purchaseService.updateBatchForStatusLv1(idsList, session);
			j.setSuccess(true);
			//j.setObj(ids);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}

	@RequestMapping(value="/doApproveLv2", method=RequestMethod.POST)
	@ResponseBody
	public Json doApproveLv2(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			this.purchaseService.updateForStatusLv2(purchase, comment, session);
			j.setSuccess(true);
			//j.setObj(ids);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doBatchApproveLv2", method=RequestMethod.POST)
	@ResponseBody
	public Json doBatchApproveLv2(String ids, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			if (StringUtils.isBlank(ids)) {
				throw new PmException("Paramater 'idsStr' is required!");
			}
			
			List<String> idsList = JacksonUtils.jsonArrayToList(ids, String.class);
			if(idsList.size() == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String purchaseId : idsList) {
				if (!UUIDUtils.isValidUUID(purchaseId)) {
					throw new PmException("Paramater 'purchaseId' is invalid!");
				}
			}
			this.purchaseService.updateBatchForStatusLv2(idsList, session);
			j.setSuccess(true);
			//j.setObj(ids);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doApproveReject", method=RequestMethod.POST)
	@ResponseBody
	public Json doApproveReject(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			this.purchaseService.updateForStatusReject(purchase, comment, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doDelete", method=RequestMethod.POST)
	@ResponseBody
	public Json doDelete(PurchaseImpl purchase, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			purchase.setStatus(PurchaseImpl.STATUS_CANCEL);
			this.purchaseService.updateForStatus(purchase, session);
			j.setSuccess(true);
			j.setObj(purchase);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PurchaseImpl> doSearch(PurchaseImpl purchase, String statuses, HttpSession session) throws Exception {
		if(statuses != null){
			String[] statusesArr = null;
			if(statuses != null ){
				statusesArr = statuses.split(",");
			}
			if(statusesArr.length == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String status : statusesArr) {
				if (!NumberUtils.between(Integer.parseInt(status), 0, 9)) {
					throw new PmException("Paramater 'status' is invalid!");
				}
			}
		}
		
		DataGrid<PurchaseImpl> grid = new DataGrid<PurchaseImpl>();
		grid = this.purchaseService.selectWithItem(purchase, statuses, session);
		return grid;
	}
	
	@RequestMapping(value="/doSearchForMyWatcher", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PurchaseImpl> doSearchForMyWatcher(PurchaseImpl purchase, String statuses, HttpSession session) throws Exception {
		if(statuses != null){
			String[] statusesArr = null;
			if(statuses != null ){
				statusesArr = statuses.split(",");
			}
			if(statusesArr.length == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String status : statusesArr) {
				if (!NumberUtils.between(Integer.parseInt(status), 0, 9)) {
					throw new PmException("Paramater 'status' is invalid!");
				}
			}
		}
		
		DataGrid<PurchaseImpl> grid = new DataGrid<PurchaseImpl>();
		grid = this.purchaseService.selectForMyWatch(purchase, statuses, session);
		return grid;
	}
	
	/**
	 * 执行添加purcahseWatcher参数操作，返回Json
	 * @param idsStr
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doAddForWatcher", method=RequestMethod.POST)
	@ResponseBody
	public Json doAddForWatcher(String idsStr, HttpSession session) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		
		// validation
		if (StringUtils.isBlank(idsStr)) {
			throw new PmException("Paramater 'idsStr' is required!");
		}
		
		List<String> idsList = JacksonUtils.jsonArrayToList(idsStr, String.class);
		if(idsList.size() == 0){
			throw new PmException("Paramater 'idsStr' is invalid!");
		}
		for (String id : idsList) {
			if (!UUIDUtils.isValidUUID(id)) {
				throw new PmException("Paramater 'id' is invalid!");
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			this.purchaseService.insert(idsList, session);
			j.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}
	
	/**
	 * 执行删除purcahseWatcher参数操作，返回Json
	 * @param purcahseWatcher
	 * @param idsStr
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doDeleteForWatcher", method=RequestMethod.POST)
	@ResponseBody
	public Json doDeleteForWatcher(String idsStr) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		
		// validation
		if (StringUtils.isBlank(idsStr)) {
			throw new PmException("Paramater 'idsStr' is required!");
		}
		
		List<String> idsList = JacksonUtils.jsonArrayToList(idsStr, String.class);
		if(idsList.size() == 0){
			throw new PmException("Paramater 'idsStr' is invalid!");
		}
		for (String id : idsList) {
			if (!UUIDUtils.isValidUUID(id)) {
				throw new PmException("Paramater 'id' is invalid!");
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			this.purchaseService.delete(idsList);
			j.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}

	@RequestMapping(value="/doSearchForReport", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PurchaseImpl> doSearchForReport(PurchaseImpl purchase, String categoryIds, String applicantdivisionIds, HttpSession session) throws Exception {
		List<Message> errList = new ArrayList<Message>();
		DataGrid<PurchaseImpl> grid = new DataGrid<PurchaseImpl>();
		if(categoryIds != null){
			String[] categoryIdsArr = null;
			if(categoryIds != null ){
				categoryIdsArr = categoryIds.split(",");
			}
			if(categoryIdsArr.length == 0){
				throw new PmException("Paramater 'categoryIds' is invalid!");
			}
			for (String categoryId : categoryIdsArr) {
				//TODO
				if (!NumberUtils.between(Integer.parseInt(categoryId), 0, 100)) {
					throw new PmException("Paramater 'categoryId' is invalid!");
				}
			}
		}
		
		if(applicantdivisionIds != null){
			String[] applicantdivisionIdsArr = null;
			if(applicantdivisionIds != null ){
				applicantdivisionIdsArr = applicantdivisionIds.split(",");
			}
			if(applicantdivisionIdsArr.length == 0){
				throw new PmException("Paramater 'applicantdivisionIds' is invalid!");
			}
			for (String applicantdivisionId : applicantdivisionIdsArr) {
				if (!UUIDUtils.isValidUUID(applicantdivisionId)) {
					throw new PmException("Paramater 'applicantdivisionId' is invalid!");
				}
			}
		}
		
		try {
			grid = this.purchaseService.selectForReport(purchase, categoryIds, applicantdivisionIds, session);
		} catch (PmException e) {
			errList.add(new Message(e.getMessage()));
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		
		return grid;
	}
	
	@RequestMapping(value="/doSearchById", method=RequestMethod.POST)
	@ResponseBody
	public Json doSearchById(PurchaseImpl purchase, HttpSession session) throws Exception {
		List<Message> errList = new ArrayList<Message>();
		Json json = new Json();
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<PurchaseItemImpl> itemlist = new ArrayList<PurchaseItemImpl>();
		
		try {
			PurchaseItemImpl purchaseItemParm = new PurchaseItemImpl();
			purchaseItemParm.setPurchaseId(purchase.getId());
			itemlist = this.purchaseItemService.select(purchaseItemParm);
			
			PurchaseImpl dbPurchase = this.purchaseService.get(purchase);
			rMap.put("itemlist", itemlist);
			rMap.put("dbPurchase", dbPurchase);
			json.setObj(rMap);
			json.setSuccess(true);
		} catch (PmException e) {
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return json;
	}
	
	/**
	 * 执行搜索score操作，返回DataGrid
	 * @param auditPo
	 * @param customerIds
	 * @return
	 * @throws VegaException
	 */
	@RequestMapping(value="/doExportPurchaseReport", method=RequestMethod.POST)
	@ResponseBody
	public void doExportPurchaseReport(PurchaseImpl purchase, String categoryIds, String applicantdivisionIds, HttpSession session) throws PmException {
		DataGrid<PurchaseImpl> grid = new DataGrid<PurchaseImpl>();
		InputStream is = null;
		try {
			grid = this.purchaseService.selectForReport(purchase, categoryIds, applicantdivisionIds, session);
			if(grid.getTotal() == 0){
				throw new PmException("没有可有数据！");
			}
			String tempFileName = "";
			if(StringUtils.isBlank(purchase.getSortTime())){
				tempFileName = "purchseReport.xlsx";
			}else{
				tempFileName = "purchseReport1.xlsx";
			}
			
			String  excelTemplateFileName = ConfigUtil.getReportTemplateDir() + tempFileName;
			is = new FileInputStream(excelTemplateFileName);
			
			HttpServletResponse response = getResponse();
			OutputStream out = response.getOutputStream(); 
			response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(System.currentTimeMillis() + ".xlsx", "UTF-8")); 
			response.setContentType("application/msexcel;charset=UTF-8");
			
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0); 
			
			List<Map<String, Object>> purchaseList = new ArrayList<>();
			double sumTotalAmount =0.0; 
			for(int i = 0; i < grid.getTotal(); i++){
				PurchaseImpl pur = grid.getRows().get(i);
				
				sumTotalAmount += pur.getTotalAmount();
				
				Map<String, Object> purchaseMap = new HashMap<>();
				purchaseMap.put("applicantdivisionName", pur.getApplicantdivisionName());
				purchaseMap.put("totalAmount", pur.getTotalAmount());
				if(StringUtils.isBlank(purchase.getSortTime()) == false){
					if(purchase.getSortTime().equalsIgnoreCase("year")){
						purchaseMap.put("period", pur.getYearApplicantDatetime());
					}else if(purchase.getSortTime().equalsIgnoreCase("quarter")){
						purchaseMap.put("period", pur.getQuarterApplicantDatetime());
					}else{
						purchaseMap.put("period", pur.getMonthApplicantDatetime());
					}
				}
				purchaseMap.put("category1Name", pur.getListPurchaseItem().get(0).getCategory1Name());
				purchaseMap.put("category2Name", pur.getListPurchaseItem().get(0).getCategory2Name());
				
				purchaseList.add(purchaseMap);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			Map<String, Object> datas = new HashMap<>();
			datas.put("now", sdf.format(new Date()));
			datas.put("purchaseList", purchaseList);
			datas.put("sumTotalAmount", sumTotalAmount);
			PoiUtils.fillTemplate(sheet, datas);
						
			wb.write(out);
			is.close();
			out.close();
		} catch (PmException e) {
			List<Message> errList = new ArrayList<Message>();
			// TODO
			errList.add(new Message(e.getMessage()));
			
			e.setCode(0);
			e.setObj(errList);
			throw e;
		} catch (FileNotFoundException e) {
			throw new PmException("没有找到模板文件");
		} catch (InvalidFormatException e) {
			throw new PmException("模板文件格式异常");
		} catch (IOException e) {
			throw new PmException("生成文件异常");
		} catch (Exception e) {
			throw e;
		} finally{
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
	
}
