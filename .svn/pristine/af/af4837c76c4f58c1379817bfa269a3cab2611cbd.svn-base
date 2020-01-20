package com.mtf.office.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fr.third.org.apache.poi.hssf.usermodel.HSSFCell;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFCellStyle;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFFont;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFRow;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFSheet;
import com.fr.third.org.apache.poi.hssf.usermodel.HSSFWorkbook;
import com.fr.third.org.apache.poi.hssf.util.HSSFColor;
import com.mtf.framework.controller.contract.ContractController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.ItemruleImpl;
import com.mtf.framework.model.impl.PaymentImpl;
import com.mtf.framework.service.ItemruleService;
import com.mtf.framework.service.PaymentService;

import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;


@Controller("ControllerItemrule")
@RequestMapping("/office/itemrule")
public class ControllerItemrule extends ContractController{

	//TODO
	
	@Autowired
	private PaymentService paymentService;

	@Autowired
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@Autowired
	private ItemruleService itemruleService;

	@Autowired
	public void setItemruleService(ItemruleService itemruleService) {
		this.itemruleService = itemruleService;
	}

	
	/**
	 * 跳转搜索页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(ItemruleImpl itemruleImpl,HttpSession session) {
		itemruleImpl.setViewPath("office/searchItemrule");
		ModelAndView mv=new ModelAndView(itemruleImpl.getViewPath());
		mv.addObject("itemrule", itemruleImpl);
		return mv;
	}
	
	/**
	 * 跳转搜索页面
	 * @return
	 * @throws PmException 
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(ItemruleImpl itemruleImpl,HttpSession session) throws PmException {
		itemruleImpl.setViewPath("office/editItemrule");
		ModelAndView mv=new ModelAndView(itemruleImpl.getViewPath());
		Long irid =itemruleImpl.getId();
		if(null != irid ){
			ItemruleImpl ir = new ItemruleImpl();
			ir = itemruleService.get(itemruleImpl);
			mv.addObject("itemrule", ir);
		}
		
		return mv;
	}
	
	/**
	 * 付款管理表编辑
	 * @param contract
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit (ItemruleImpl itemruleImpl, HttpSession session) throws Exception {
		Json j = new Json();
		
		if (TextUtils.isEmpty(itemruleImpl.getType())) {
			j.setSuccess(false);
			j.setMsg("名称不能为空");
			return j;
		}else if(TextUtils.isEmpty(itemruleImpl.getUnit())){
			j.setSuccess(false);
			j.setMsg("单位不能为空");
			return j;
		}else if("".equals(itemruleImpl.getAmountDefault())){
			j.setSuccess(false);
			j.setMsg("默认数量不能为空");
			return j;
		}else if("".equals(itemruleImpl.getPrice())){
			j.setSuccess(false);
			j.setMsg("单价不能为空不能为空");
			return j;
		}else if("".equals(itemruleImpl.getAmountMax())){
			j.setSuccess(false);
			j.setMsg("数量上限不能为空");
			return j;
		}else if(TextUtils.isNumeric(Integer.toString(itemruleImpl.getAmountDefault()))){
			j.setSuccess(false);
			j.setMsg("默认数量必须是数字");
			return j;
		}else if(TextUtils.isNumeric(Integer.toString(itemruleImpl.getAmountMax()))){
			j.setSuccess(false);
			j.setMsg("数量上限必须是数字");
			return j;
		}else if(20 < itemruleImpl.getType().length()){
			j.setSuccess(false);
			j.setMsg("名称不能输入过长");
			return j;
		}else if(20 < itemruleImpl.getSpecification().length()){
			j.setSuccess(false);
			j.setMsg("规格不能输入过长");
			return j;
		}else if(20 < itemruleImpl.getUnit().length()){
			j.setSuccess(false);
			j.setMsg("单位不能输入过长");
			return j;
		}else if(10 < String.valueOf(itemruleImpl.getPrice()).length()){
			j.setSuccess(false);
			j.setMsg("单价不能输入过长");
			return j;
		}else if(0 >= itemruleImpl.getAmountDefault()){
			j.setSuccess(false);
			j.setMsg("默认数量必须大于0");
			return j;
		}else if(0 >= itemruleImpl.getAmountMax()){
			j.setSuccess(false);
			j.setMsg("数量上限必须大于0");
			return j;
		}else if(99 < itemruleImpl.getAmountDefault()){
			j.setSuccess(false);
			j.setMsg("默认数量最大为99");
			return j;
		}else if(99 < itemruleImpl.getAmountMax()){
			j.setSuccess(false);
			j.setMsg("数量上限最大为99");
			return j;
		}else if(itemruleImpl.getAmountDefault() > itemruleImpl.getAmountMax()){
			j.setSuccess(false);
			j.setMsg("数量上限必须大于等于默认数量");
			return j;
		}
		
		
		String dateStr = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		try {
			Long irid =itemruleImpl.getId();
			if(null == irid ){
				itemruleImpl.setAddDate(dateStr);
				itemruleService.insert(itemruleImpl);
			}else{
				itemruleImpl.setModifiedDate(dateStr);
				itemruleService.update(itemruleImpl);
			}
			j.setSuccess(true);
			j.setObj(itemruleImpl);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<ItemruleImpl> doSearch(ItemruleImpl itemruleImpl, HttpSession session) throws Exception {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Integer userLevel = sessionInfo.getUserLever();
		itemruleImpl.setUserLevel(userLevel);
		DataGrid<ItemruleImpl> list = new DataGrid<ItemruleImpl>();
		list = this.itemruleService.select(itemruleImpl);
		return list;
	}
	
	@RequestMapping(value="/doSearchItem", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<PaymentImpl> doSearchItem(PaymentImpl paymentImpl, HttpSession session) throws Exception {
		DataGrid<PaymentImpl> list = new DataGrid<PaymentImpl>();
		list = this.paymentService.selectItem(paymentImpl);
		return list;
	}
	
	@RequestMapping(value="/doSearchByName", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<ItemruleImpl> doSearchByName(ItemruleImpl itemruleImpl, HttpSession session) throws  PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Integer userLevel = sessionInfo.getUserLever();
		itemruleImpl.setUserLevel(userLevel);
		DataGrid<ItemruleImpl> result = null;
			result = this.itemruleService.selectByName(itemruleImpl);
			if (result == null) {
				result = new DataGrid<ItemruleImpl>();
			}
		
		return result;
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/doPrint", method=RequestMethod.POST)
	public void doPrint(ItemruleImpl itemruleImpl, HttpSession session, HttpServletResponse resp) throws  Exception {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Integer userLevel = sessionInfo.getUserLever();
		itemruleImpl.setUserLevel(userLevel);
		DataGrid<ItemruleImpl> result = null;
			result = this.itemruleService.selectByName(itemruleImpl);
			if (result == null) {
				result = new DataGrid<ItemruleImpl>();
			}
			//1
			HSSFWorkbook wb = new HSSFWorkbook();
			//2
			HSSFSheet sheet = wb.createSheet("办公用品表");
			sheet.setColumnWidth((short) 0, (short) 5000);
			sheet.setColumnWidth((short) 1, (short) 3000);
			sheet.setColumnWidth((short) 2, (short) 3000);
			sheet.setColumnWidth((short) 3, (short) 3000);
			sheet.setColumnWidth((short) 4, (short) 3000);
			sheet.setColumnWidth((short) 5, (short) 5000);
			//3
			HSSFRow row = sheet.createRow((int)0);
			//4
			HSSFCellStyle styleHead = wb.createCellStyle();
			styleHead.setFillForegroundColor(HSSFColor.WHITE.index);
			styleHead.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			styleHead.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			styleHead.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			styleHead.setBorderRight(HSSFCellStyle.BORDER_THIN);
			styleHead.setBorderTop(HSSFCellStyle.BORDER_THIN);
			styleHead.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			//设置字体
			HSSFFont font=wb.createFont();
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			styleHead.setFont(font);
			
			// 5
			HSSFCellStyle style = wb.createCellStyle();
			style.setFillForegroundColor(HSSFColor.WHITE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);

			HSSFCell cell = row.createCell((short)0);
			cell.setCellValue("名称"); cell.setCellStyle(styleHead);
			cell = row.createCell((short)1);
			cell.setCellValue("规格"); cell.setCellStyle(styleHead);
			cell = row.createCell((short)2);
			cell.setCellValue("单位"); cell.setCellStyle(styleHead);
			cell = row.createCell((short)3);
			cell.setCellValue("价格"); cell.setCellStyle(styleHead);
			cell = row.createCell((short)4);
			cell.setCellValue("供应商"); cell.setCellStyle(styleHead);
			cell = row.createCell((short)5);
			cell.setCellValue("备注"); cell.setCellStyle(styleHead);
			//6
			for(int i=0;i<result.getRows().size();i++){
				row = sheet.createRow((int)i+1);
				ItemruleImpl iri = (ItemruleImpl)result.getRows().get(i);
				HSSFCell cell0 = row.createCell((short)0);
				cell0.setCellValue(iri.getType()); cell0.setCellStyle(style);
				
				HSSFCell cell1 = row.createCell((short)1);
				cell1.setCellValue(iri.getSpecification()); cell1.setCellStyle(style);
				
				HSSFCell cell2 = row.createCell((short)2);
				cell2.setCellValue(iri.getUnit()); cell2.setCellStyle(style);
				
				HSSFCell cell3 = row.createCell((short)3);
				cell3.setCellValue((double)iri.getPrice()); cell3.setCellStyle(style);
				
				HSSFCell cell4 = row.createCell((short)4);
				cell4.setCellValue(iri.getSupplier()); cell4.setCellStyle(style);
				
				HSSFCell cell5 = row.createCell((short)5);
				cell5.setCellValue(iri.getRemarks()); cell5.setCellStyle(style);
			}
			//7
			try {
				
				resp.reset();
				resp.setContentType("application/vnd.ms-excel");
				resp.addHeader("Content-Disposition", "attachment;filename=office_supply.xls");
				ServletOutputStream outputStream = resp.getOutputStream();
				wb.write(outputStream);
				outputStream.close();
			}catch (FileNotFoundException e) {  
				    throw new Exception(" 生成导出Excel文件出错! ", e);  
			}catch (IOException e) {  
				    throw new Exception(" 写入Excel文件出错! ", e);  
			}catch (Exception e) {
				e.printStackTrace();
			}
		
	}
}
