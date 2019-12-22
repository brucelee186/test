package com.mtf.framework.service.impl;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.BuyerMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Buyer;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.service.IBuyerService;


@Service("buyerService")
public class BuyerServiceImpl implements IBuyerService {
	
	@Autowired
	private BuyerMapper buyerMapper;
	
	@Autowired
	public BuyerMapper getBuyerMapper() {
		return buyerMapper;
	}

	@Autowired
	public void setBuyerMapper(BuyerMapper buyerMapper) {
		this.buyerMapper = buyerMapper;
	}

	@Override
	public Buyer insert(Buyer buyer) throws PmException {
		buyer.setId(UUID.randomUUID().toString());
		buyer.setModified(new Date().getTime());
		Object obj = buyer;
		buyerMapper.insert(obj);
		return buyer;
	}

	/**
	 * 搜索发票列表
	 * 
	 * @param uid 操作发票
	 * @param buyer 参数
	 * @return 发票列表
	 * @throws PmException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<Buyer> select(Buyer buyer)
			throws PmException {
		DataGrid<Buyer> grid = new DataGrid<Buyer>();
		String name = buyer.getName();
		if (null != name) {
			buyer.setName(name.trim());
		}
		//buyer.setStartIndex(buyer.getStartIndex());
		Object obj = buyer;
		List list = buyerMapper.select(obj);
		grid.setRows(list);
		int count;
		count = buyerMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得单一对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	public Buyer get(Buyer buyer) throws PmException {
		Object obj = buyer;
		return (Buyer)buyerMapper.get(obj);
	}

	/**
	 * 更新单一对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	public int update(Buyer buyer) throws PmException {
		buyer.setModified(new Date().getTime());
		return buyerMapper.update(buyer);
	}

	/**
	 * 删除对象
	 * @param buyer
	 * @return
	 * @throws PmException
	 */
	public int delete(Buyer buyer) throws PmException {
		return buyerMapper.delete(buyer);
	}

}
