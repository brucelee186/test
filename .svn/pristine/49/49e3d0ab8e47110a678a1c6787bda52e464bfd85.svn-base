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


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

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

import com.alibaba.fastjson.JSON;
import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.RbsCategory;
import com.mtf.framework.model.Reimbursement;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.ReimbursementImpl;
import com.mtf.framework.model.impl.ReimbursementItemImpl;
import com.mtf.framework.service.IDivisionService;
import com.mtf.framework.service.IRbsCategoryService;
import com.mtf.framework.service.ReimbursementItemService;
import com.mtf.framework.service.ReimbursementService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.JacksonUtils;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.PoiUtils;
import com.mtf.framework.util.UUIDUtils;


@Controller("reimbursementController")
@RequestMapping("/office/reimbursement/reimbursement")
public class ReimbursementController extends BaseController {

	private ReimbursementService		reimbursementService;
	private ReimbursementItemService	reimbursementItemService;
	private IRbsCategoryService			rbsCategoryService;
	private IDivisionService			divisionService;
	private UserService					userService;
	
	@Autowired
	public void setReimbursementService(ReimbursementService reimbursementService) {
		this.reimbursementService = reimbursementService;
	}
	
	@Autowired
	public void setReimbursementItemService(ReimbursementItemService reimbursementItemService) {
		this.reimbursementItemService = reimbursementItemService;
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

	@RequestMapping("/toMyReimbursement")
	public ModelAndView toMyReimbursement(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView("reimbursement/myReimbursement");
		List<RbsCategory> rbsCategorys = null;
		List<Division> divisionList = null;
		List<Division> itemDivisionList = null;
		
		try {
			RbsCategory rbsCategory = new RbsCategory();
			rbsCategory.setStatus(0);
			rbsCategorys = this.rbsCategoryService.list(rbsCategory, null);
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
		mv.addObject("divisionsJson", JacksonUtils.objectToJson(divisionList));
		mv.addObject("itemDivisionsJson", JacksonUtils.objectToJson(itemDivisionList));
		mv.addObject("categorysJson", JacksonUtils.objectToJson(rbsCategorys));
		mv.addObject("reimbursement", reimbursement);
		return mv;
	}
	

	@RequestMapping("/toFinancialAudit")
	public ModelAndView toFinancialAudit(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/financialAudit");
		List<Division> itemDivisionList = null;
		List<User> signersList = null;
		itemDivisionList = this.divisionService.listAll(null);
		//签字人列表
		//signersList = this.userService.listForSinger(null);
		
		//mv.addObject("signersJson", JacksonUtils.objectToJson(signersList));
		mv.addObject("itemDivisionsJson", JacksonUtils.objectToJson(itemDivisionList));
		mv.addObject("reimbursement", reimbursement);
		return mv;
	}
	
	@RequestMapping("/toReimbursementReport")
	public ModelAndView toReimbursementReport(PurchaseImpl purchase, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("reimbursement/reimbursementReport");
		return mv;
	}
	
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(ReimbursementImpl reimbursement, String reimbursementItemStr, HttpSession session) throws PmException {
		Json j = new Json();
		List<Message> errList = new ArrayList<Message>();
		//reimbursement validation
		if(reimbursement.getStatus() == null || (NumberUtils.compare(reimbursement.getStatus(), ReimbursementImpl.STATUS_SUBMIT) == false
				&& NumberUtils.compare(reimbursement.getStatus(), ReimbursementImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		
		//validation
		if (StringUtils.isBlank(reimbursement.getApplicantDivisionId()) ||StringUtils.isBlank(reimbursement.getApplicantDivisionName())) {
			errList.add(new Message("applicantDivision", "Parameter ApplicantDivision is required."));
		}
		if (StringUtils.isBlank(reimbursement.getCurrencyId())) {
			errList.add(new Message("currencyId", "Parameter CurrencyId is required."));
		}
		if (StringUtils.isBlank(reimbursement.getPayeeName())) {
			errList.add(new Message("payeeName", "Parameter PayeeName is required."));
		}
		/*if (!NumberUtils.between(reimbursement.getExchangeRate(), 1, 1000)) {
			errList.add(new Message("exchangeRate", "Parameter ExchangeRate is invalid."));
		}*/
		/*if (!NumberUtils.between(reimbursement.getActualTotalAmount(), 1, 99999)) {
			errList.add(new Message("actualTotalAmount", "Parameter ActualTotalAmount is invalid."));
		}*/
		
		
		//item validation
		if (StringUtils.isBlank(reimbursementItemStr)) {
			throw new PmException("Paramater 'reimbursementItemStr' is required!");
		}
		
		List<ReimbursementItemImpl> itemList = JacksonUtils.jsonArrayToList(reimbursementItemStr, ReimbursementItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'reimbursementItemStr' is invalid!");
		}
		for (ReimbursementItemImpl reimbursementItem : itemList) {
			if(StringUtils.isBlank(reimbursementItem.getCategory1Id()) || StringUtils.isBlank(reimbursementItem.getCategory1Name())){
				errList.add(new Message("category1", "Parameter Category1 is required."));
			}
			if(StringUtils.isBlank(reimbursementItem.getCategory2Id()) || StringUtils.isBlank(reimbursementItem.getCategory2Name())){
				errList.add(new Message("category2", "Parameter Category2 is required."));
			}
			if(NumberUtils.between(reimbursementItem.getAmount(), 0, 999999) == false){
				errList.add(new Message("amount", "Parameter Amount is invalid."));
			}
			if(StringUtils.isBlank(reimbursementItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required."));
			}
			if(StringUtils.isBlank(reimbursementItem.getDivisionId()) || StringUtils.isBlank(reimbursementItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required."));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		// process
		try {
			this.reimbursementService.insert(reimbursement, itemList, session);
			
			j.setSuccess(true);
			j.setObj(reimbursement);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(ReimbursementImpl reimbursement, String reimbursementItemStr, HttpSession session) throws PmException {
		Json j = new Json();	
		List<Message> errList = new ArrayList<Message>();
		//reimbursement validation
		//TODO 去掉submit
		if(reimbursement.getStatus() == null || (NumberUtils.compare(reimbursement.getStatus(), ReimbursementImpl.STATUS_SUBMIT) == false
				&& NumberUtils.compare(reimbursement.getStatus(), ReimbursementImpl.STATUS_DRAFT) == false)) {
			throw new PmException("Paramater 'status' is invalid!");
		}
		
		//validation
		if (StringUtils.isBlank(reimbursement.getApplicantDivisionId()) ||StringUtils.isBlank(reimbursement.getApplicantDivisionName())) {
			errList.add(new Message("no", "Parameter ApplicantDivision is required."));
		}
		if (StringUtils.isBlank(reimbursement.getCurrencyId())) {
			errList.add(new Message("currencyId", "Parameter CurrencyId is required."));
		}
		if (StringUtils.isBlank(reimbursement.getPayeeName())) {
			errList.add(new Message("payeeName", "Parameter PayeeName is required."));
		}
		
		//item validation
		if (StringUtils.isBlank(reimbursementItemStr)) {
			throw new PmException("Paramater 'reimbursementItemStr' is required!");
		}
		
		List<ReimbursementItemImpl> itemList = JacksonUtils.jsonArrayToList(reimbursementItemStr, ReimbursementItemImpl.class);
		if(itemList.size() == 0){
			throw new PmException("Paramater 'reimbursementItemStr' is invalid!");
		}
		
		for (ReimbursementItemImpl reimbursementItem : itemList) {
			if(StringUtils.isBlank(reimbursementItem.getDescription())){
				errList.add(new Message("description", "Parameter Description is required."));
			}
			if(StringUtils.isBlank(reimbursementItem.getDivisionId()) || StringUtils.isBlank(reimbursementItem.getDivisionName())){
				errList.add(new Message("division", "Parameter Division is required."));
			}
		}
		
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		try {
			this.reimbursementService.update(reimbursement, itemList, session);
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
	
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<ReimbursementImpl> doSearch(ReimbursementImpl reimbursement, String statuses, HttpSession session) throws Exception {
		
		DataGrid<ReimbursementImpl> grid = new DataGrid<ReimbursementImpl>();
		
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
		
		grid = this.reimbursementService.selectWithItem(reimbursement, statuses, session);
		return grid;
	}
	
	
	
	@RequestMapping(value="/doSearchById", method=RequestMethod.POST)
	@ResponseBody
	public Json doSearchById(ReimbursementImpl reimbursement, HttpSession session) throws Exception {
		List<Message> errList = new ArrayList<Message>();
		Json json = new Json();
		
		Map<String, Object> rMap = new HashMap<String, Object>();
		List<ReimbursementItemImpl> itemlist = new ArrayList<ReimbursementItemImpl>();
		
		try {
			ReimbursementItemImpl reimbursementItemParm = new ReimbursementItemImpl();
			reimbursementItemParm.setReimbursementId(reimbursement.getId());
			itemlist = this.reimbursementItemService.select(reimbursementItemParm);
			
			ReimbursementImpl dbReimbursement = this.reimbursementService.get(reimbursement);
			rMap.put("itemlist", itemlist);
			rMap.put("dbReimbursement", dbReimbursement);
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
	
	@RequestMapping(value="/doDelete", method=RequestMethod.POST)
	@ResponseBody
	public Json doDelete(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			
			reimbursement.setStatus(ReimbursementImpl.STATUS_CANCEL);
			this.reimbursementService.updateStatusForDelete(reimbursement, session);
			j.setSuccess(true);
			j.setObj(reimbursement);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	//暂时不用
	@RequestMapping(value="/doEditStatusForReject", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusForReject(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			
			reimbursement.setStatus(ReimbursementImpl.STATUS_AUDITFAIL);
			this.reimbursementService.updateStatusForReject(reimbursement, session);
			j.setSuccess(true);
			j.setObj(reimbursement);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doBatchEditStatusForReject", method=RequestMethod.POST)
	@ResponseBody
	public Json doBatchEditStatusForReject(String ids, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			if (StringUtils.isBlank(ids)) {
				throw new PmException("Paramater 'idsStr' is required!");
			}
			
			List<String> idsList = JacksonUtils.jsonArrayToList(ids, String.class);
			if(idsList.size() == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String reimbursementId : idsList) {
				if (!UUIDUtils.isValidUUID(reimbursementId)) {
					throw new PmException("Paramater 'reimbursementId' is invalid!");
				}
			}
			this.reimbursementService.updateBatchStatusForReject(idsList, session);
			j.setSuccess(true);
			//j.setObj();
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	
	@RequestMapping(value="/doEditStatusForSubmit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusForSubmit(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			reimbursement.setStatus(ReimbursementImpl.STATUS_SUBMIT);
			this.reimbursementService.updateStatusForSubmit(reimbursement, session);
			j.setSuccess(true);
			j.setObj(reimbursement);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value="/doEditStatusForAudit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEditStatusForAudit(ReimbursementImpl reimbursement, String idsStr, HttpSession session) throws PmException {
		Json j = new Json();
		try {
			
			if (StringUtils.isBlank(idsStr)) {
				throw new PmException("Paramater 'idsStr' is required!");
			}
			
			List<String> idsList = JacksonUtils.jsonArrayToList(idsStr, String.class);
			if(idsList.size() == 0){
				throw new PmException("Paramater 'idsStr' is invalid!");
			}
			for (String reimbursementId : idsList) {
				if (!UUIDUtils.isValidUUID(reimbursementId)) {
					throw new PmException("Paramater 'reimbursementId' is invalid!");
				}
			}
			
			this.reimbursementService.updateForAudit(reimbursement, idsList, session);
			j.setSuccess(true);
			j.setObj(idsList);
		} catch (Exception e) {
			j.setMsg(e.getMessage());
			return j;
		}
		
		return j;
	}
	
	@RequestMapping(value = "/doPdfReport", method = RequestMethod.POST)
	@ResponseBody
	public void doPdfReport(String reimbursementStr, String reimbursementItemStr, HttpSession session) throws PmException, JRException, IOException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ReimbursementImpl reimbursement = null;
		List<ReimbursementItemImpl> reimbursementItems = null;
		Map<String, Object> datas = new HashMap<String, Object>();
		JSON.DEFFAULT_DATE_FORMAT = "yyyy/MM/dd";
		
		if(StringUtils.isBlank(reimbursementStr)){
			reimbursement = new ReimbursementImpl();
		}else{
			reimbursement = JSON.parseObject(reimbursementStr, ReimbursementImpl.class);
		}
		if(StringUtils.isBlank(reimbursementItemStr)){
			reimbursementItems = new ArrayList<>();
		}else{
			reimbursementItems = JSON.parseArray(reimbursementItemStr, ReimbursementItemImpl.class);
		}
		
		List<Reimbursement> datasource = new ArrayList<>();
		datasource.add(reimbursement);

		String reimbursementFile = ConfigUtil.getReportTemplateDir() + "reimbursement.jrxml";

		datas.put("reimbursement", reimbursement);
		datas.put("reimbursementItems", reimbursementItems);
		
		JasperReport reimbursementJasperReport = JasperCompileManager.compileReport(reimbursementFile);
		
		JasperPrint reimbursementJasperPrint = JasperFillManager.fillReport(reimbursementJasperReport, datas, new JRBeanCollectionDataSource(datasource));
		
		List<JasperPrint> jasperPrintList = new ArrayList<>();
		jasperPrintList.add(reimbursementJasperPrint);
		
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setExporterInput(SimpleExporterInput.getInstance(jasperPrintList));
		getResponse().addHeader("Content-Disposition", "filename=reimbursement.pdf");
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(getResponse().getOutputStream()));
		exporter.exportReport();

	}
	
	@RequestMapping(value="/doSearchForReport", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<ReimbursementImpl> doSearchForReport(ReimbursementImpl reimbursement, String categoryIds, String applicantDivisionIds, HttpSession session) throws Exception {
		List<Message> errList = new ArrayList<Message>();
		DataGrid<ReimbursementImpl> grid = new DataGrid<ReimbursementImpl>();
		
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
		
		if(applicantDivisionIds != null){
			String[] applicantdivisionIdsArr = null;
			if(applicantDivisionIds != null ){
				applicantdivisionIdsArr = applicantDivisionIds.split(",");
			}
			if(applicantdivisionIdsArr.length == 0){
				throw new PmException("Paramater 'applicantDivisionIds' is invalid!");
			}
			for (String applicantdivisionId : applicantdivisionIdsArr) {
				if (!UUIDUtils.isValidUUID(applicantdivisionId)) {
					throw new PmException("Paramater 'applicantDivisionId' is invalid!");
				}
			}
		}
		
		try {
			grid = this.reimbursementService.selectForReport(reimbursement, categoryIds, applicantDivisionIds, session);
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
	
	/**
	 * 执行搜索score操作，返回DataGrid
	 * @param auditPo
	 * @param customerIds
	 * @return
	 * @throws VegaException
	 */
	@RequestMapping(value="/doExportReimbursementReport", method=RequestMethod.POST)
	@ResponseBody
	public void doExportReimbursementReport(ReimbursementImpl reimbursement, String categoryIds, String applicantDivisionIds, HttpSession session) throws PmException {
		DataGrid<ReimbursementImpl> grid = new DataGrid<ReimbursementImpl>();
		InputStream is = null;
		try {
			grid = this.reimbursementService.selectForReport(reimbursement, categoryIds, applicantDivisionIds, session);
			if(grid.getTotal() == 0){
				throw new PmException("没有可有数据！");
			}
			String tempFileName = "";
			if(StringUtils.isBlank(reimbursement.getSortTime())){
				tempFileName = "reimbursementReport.xlsx";
			}else{
				tempFileName = "reimbursementReport1.xlsx";
			}
			
			String  excelTemplateFileName = ConfigUtil.getReportTemplateDir() + tempFileName;
			is = new FileInputStream(excelTemplateFileName);
			
			HttpServletResponse response = getResponse();
			OutputStream out = response.getOutputStream(); 
			response.setHeader("Content-disposition", "attachment;filename=" + URLEncoder.encode(System.currentTimeMillis() + ".xlsx", "UTF-8")); 
			response.setContentType("application/msexcel;charset=UTF-8");
			
			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);
			
			List<Map<String, Object>> reimbursementList = new ArrayList<>();
			double sumTotalAmount =0.0; 
			for(int i = 0; i < grid.getTotal(); i++){
				ReimbursementImpl rbs = grid.getRows().get(i);
				
				sumTotalAmount += rbs.getSumTotalAmount();
				
				Map<String, Object> reimbursementMap = new HashMap<>();
				reimbursementMap.put("applicantDivisionName", rbs.getApplicantDivisionName());
				reimbursementMap.put("sumTotalAmount", rbs.getSumTotalAmount());
				if(StringUtils.isBlank(reimbursement.getSortTime()) == false){
					if(reimbursement.getSortTime().equalsIgnoreCase("year")){
						reimbursementMap.put("period", rbs.getYearApplicantDatetime());
					}else if(reimbursement.getSortTime().equalsIgnoreCase("quarter")){
						reimbursementMap.put("period", rbs.getQuarterApplicantDatetime());
					}else{
						reimbursementMap.put("period", rbs.getMonthApplicantDatetime());
					}
				}
				reimbursementMap.put("category1Name", rbs.getListReimbursementItem().get(0).getCategory1Name());
				reimbursementMap.put("category2Name", rbs.getListReimbursementItem().get(0).getCategory2Name());
				
				reimbursementList.add(reimbursementMap);
			}
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

			Map<String, Object> datas = new HashMap<>();
			datas.put("now", sdf.format(new Date()));
			datas.put("reimbursementList", reimbursementList);
			datas.put("sumTotalAmount", sumTotalAmount);
			PoiUtils.fillTemplate(sheet, datas);
						
			wb.write(out);
			is.close();
			out.close();
		} catch (PmException e) {
			List<Message> errList = new ArrayList<Message>();
			
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