package com.mtf.framework.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ContractMapper;
import com.mtf.framework.dao.ItemsMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Items;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.service.ItemsService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;


@Service("itemsService")
public class ItemsServiceImpl extends CommonServiceImpl implements ItemsService {
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Autowired
	private ContractMapper contractMapper;
	
	@Autowired
	public ContractMapper getContractMapper() {
		return contractMapper;
	}

	@Autowired
	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	@Autowired
	public ItemsMapper getItemsMapper() {
		return itemsMapper;
	}
	
	@Autowired
	public void setItemsMapper(ItemsMapper itemsMapper) {
		this.itemsMapper = itemsMapper;
	}

	@Override
	public Items insert(Items items) throws PmException {
		Object obj = items;
		itemsMapper.insert(obj);
		return items;
	}

	/**
	 * 搜索对象列表
	 * 
	 * @param uid 操作对象
	 * @param items 参数
	 * @return 对象列表
	 * @throws PmException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<Items> select(Items items)
			throws PmException {
		DataGrid<Items> grid = new DataGrid<Items>();
		Object obj = items;
		List list = itemsMapper.select(obj);
		grid.setRows(list);
		int count;
		count = itemsMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得单一对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public Items get(Items items) throws PmException {
		Object obj = items;
		return (Items)itemsMapper.get(obj);
	}

	/**
	 * 更新单一对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public int update(Items items) throws PmException {
		return itemsMapper.update(items);
	}

	/**
	 * 删除对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public int delete(Items items) throws PmException {
		return itemsMapper.delete(items);
	}
	
	/**
	 * 删除对象并更新主表对象
	 * @param items
	 * @return
	 * @throws PmException
	 */
	public int delete(Items items, Contract contract) throws PmException {
		int res = itemsMapper.delete(items);
		return res;
	}

	/**
	 * 搜索对象列表
	 * @param items
	 * @return
	 * @throws PmException
	 */
	@SuppressWarnings("unchecked")
	public List<Items> find(Items items) throws PmException {
		Object obj = items;
		@SuppressWarnings("rawtypes")
		List list = itemsMapper.select(obj);
		return list;
	}

}
