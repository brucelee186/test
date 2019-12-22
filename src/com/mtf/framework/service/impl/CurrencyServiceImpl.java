package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.dao.CurrencyMapper;
import com.mtf.framework.model.impl.CurrencyImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.CurrencyService;
import com.mtf.framework.util.Constants;

/*
**********************************************
 * 项目名称：Office(办公管理系统)
 * 模块名称：基础资料 -> 货币
 * 作者:     BillQi
 * 日期:     2015/5/27
**********************************************
*/
@Service("currencyService")
public class CurrencyServiceImpl extends CommonServiceImpl implements CurrencyService {
	@Autowired
	private CurrencyMapper currencyMapper;

	@Autowired
	public CurrencyMapper getCurrencyMapper() {
		return currencyMapper;
	}

	@Autowired
	public void setCurrencyMapper(CurrencyMapper currencyMapper) {
		this.currencyMapper = currencyMapper;
	}

	/**
	 * 新增实体对象
	 * @param currency
	 */
	public CurrencyImpl insert(CurrencyImpl currency, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		currency.setCreateDatetime(new Date());
		currency.setCreateUserId(sessionInfo.getUserId());
		currency.setCreateUserName(sessionInfo.getDisplayName());
		this.currencyMapper.insert(currency);
		return currency;
	}

	/**
	 * 删除实体对象
	 * @param currency
	 */
	public int delete(CurrencyImpl currency) throws PmException {
		return this.currencyMapper.delete(currency);
	}

	/**
	 * 更新实体对象
	 * @param currency
	 */
	public boolean update(CurrencyImpl currency, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		CurrencyImpl currencyParm = new CurrencyImpl();
		currencyParm.setId(currency.getId());
		CurrencyImpl dbCurrency = (CurrencyImpl)this.currencyMapper.get(currencyParm);
		
		dbCurrency.setName(currency.getName());
		dbCurrency.setRatio(currency.getRatio());
		dbCurrency.setStatus(currency.getStatus());
		
		dbCurrency.setUpdateDatetime(new Date());
		dbCurrency.setUpdateUserId(sessionInfo.getUserId());
		dbCurrency.setUpdateUserName(sessionInfo.getDisplayName());
		this.currencyMapper.update(dbCurrency);
		return result;
	}
	/**
	 * 查询实体列表
	 * @param currency
	 */
	@SuppressWarnings("unchecked")
	public List<CurrencyImpl> select(CurrencyImpl currency) throws PmException {
		return (List<CurrencyImpl>) this.currencyMapper.select(currency);
	}
	/**
	 * 查询单个实体
	 * @param currency
	 */
	public CurrencyImpl get(CurrencyImpl currency) throws PmException {
		return (CurrencyImpl) this.currencyMapper.get(currency);
	}
	/**
	 * 查询实体分页列表
	 * @param currency
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<CurrencyImpl> search(CurrencyImpl currency) throws PmException {
		DataGrid<CurrencyImpl> grid = new DataGrid<CurrencyImpl>();
		Object obj = currency;
		List list = currencyMapper.select(obj);
		grid.setRows(list);
		int count;
		count = currencyMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}