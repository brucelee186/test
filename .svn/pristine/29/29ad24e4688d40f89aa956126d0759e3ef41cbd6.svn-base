package com.mtf.framework.controller.maintenance;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.impl.CurrencyImpl;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.UUIDUtils;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Currency;
import com.mtf.framework.service.CurrencyService;

/*
**********************************************
 * 项目名称：Office(办公管理系统)
 * 模块名称：控制层 -> 币种
 * 作者:     BillQi
 * 日期:     2015/5/27
**********************************************
*/
@Controller("currencyController")
@RequestMapping("/maintenance/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@Autowired
	public CurrencyService getCurrencyService() {
		return currencyService;
	}

	@Autowired
	public void setCurrencyService(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("/maintenance/basic/currency");
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doSearch")
	@ResponseBody
	public DataGrid<CurrencyImpl> doSearch(CurrencyImpl currency, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<CurrencyImpl> list = new DataGrid<CurrencyImpl>();
		list = this.currencyService.search(currency);
		return list;
	}

	
	/**
	 * 执行添加CurrencyImpl操作，返回Json
	 * @param currency 要添加的CurrencyImpl
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doAdd", method=RequestMethod.POST)
	@ResponseBody
	public Json doAdd(CurrencyImpl currency, HttpSession session) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		// validate
		if (StringUtils.isBlank(currency.getName())) {
			errList.add(new Message("name", "名称"));
		}
		if (!NumberUtils.between(currency.getStatus(), 0, 1)) {
			errList.add(new Message("status", "状态"));
		}
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		// process
		try {
			this.currencyService.insert(currency, session);
			j.setSuccess(true);
			j.setObj(currency);
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
	 * 执行编辑CurrencyImpl操作，返回Json
	 * @param currency
	 * @return
	 * @throws PmException
	 */
	@RequestMapping(value="/doEdit", method=RequestMethod.POST)
	@ResponseBody
	public Json doEdit(CurrencyImpl currency, HttpSession session) throws PmException {
		List<Message> errList = new ArrayList<Message>();
		Json j = new Json();
		// validate
		if (StringUtils.isBlank(currency.getName())) {
			errList.add(new Message("name", "名称"));
		}
		if (!NumberUtils.between(currency.getStatus(), 0, 1)) {
			errList.add(new Message("status", "状态"));
		}
		if (!errList.isEmpty()) {
			throw new PmException(0, errList);
		}
		// process
		try {
			this.currencyService.update(currency, session);
			j.setSuccess(true);
			j.setObj(currency);
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
	 * 搜索
	 * @param currency
	 * @param session
	 * @return
	 * @throws Exception
	 * （暂时不用）
	 */
	
	@RequestMapping(value = "/doSearchForRatio", method = RequestMethod.POST)
	@ResponseBody
	public Json doSearchForRatio(CurrencyImpl currency, HttpSession session) throws Exception {
		Json json = new Json();
		CurrencyImpl dbCurrency = currencyService.get(currency);
		json.setSuccess(true);
		json.setObj(dbCurrency.getRatio());
		return json;
	}

}

