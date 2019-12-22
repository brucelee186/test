package com.mtf.framework.service.impl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.InvoiceMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Invoice;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.service.IInvoiceService;


@Service("invoiceService")
// 抽象类可继承接口并不实现接口,而非抽象类必须实现接口的每一个方法
public class InvoiceServiceImpl implements IInvoiceService {
	
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	@Autowired
	public InvoiceMapper getInvoiceMapper() {
		return invoiceMapper;
	}

	@Autowired
	public void setInvoiceMapper(InvoiceMapper invoiceMapper) {
		this.invoiceMapper = invoiceMapper;
	}

	@Override
	public Invoice insert(Invoice invoice) throws PmException {
		invoice.setId(UUID.randomUUID().toString());
		invoice.setModified(new Date().getTime());
		Object obj = invoice;
		invoiceMapper.insert(obj);
		return invoice;
	}

	/**
	 * 搜索发票列表
	 * 
	 * @param uid 操作发票
	 * @param invoice 参数
	 * @return 发票列表
	 * @throws PmException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<Invoice> select(Invoice invoice)
			throws PmException {
		DataGrid<Invoice> grid = new DataGrid<Invoice>();
		String name = invoice.getName();
		String customerId = invoice.getCustomerId();
		if (null != name) {
			invoice.setName(name.trim());
		}
		if (null != customerId) {
			invoice.setCustomerId(customerId.trim());
		}
		//invoice.setStartIndex(invoice.getStartIndex());
		Object obj = invoice;
		List list = invoiceMapper.select(obj);
		grid.setRows(list);
		int count = invoiceMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得单一对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	public Invoice get(Invoice invoice) throws PmException {
		Object obj = invoice;
		return (Invoice)invoiceMapper.get(obj);
	}

	/**
	 * 更新单一对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	public int update(Invoice invoice) throws PmException {
		invoice.setModified(new Date().getTime());
		return invoiceMapper.update(invoice);
	}

	/**
	 * 删除对象
	 * @param invoice
	 * @return
	 * @throws PmException
	 */
	public int delete(Invoice invoice) throws PmException {
		return invoiceMapper.delete(invoice);
	}

}
