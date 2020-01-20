package com.mtf.framework.service.impl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.ContractMapper;
import com.mtf.framework.dao.ItemsMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Items;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.service.ContractService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;


@Service("contractService")
public class ContractServiceImpl extends CommonServiceImpl implements ContractService {
	
	@Autowired
	private ContractMapper contractMapper;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Autowired
	public ItemsMapper getItemsMapper() {
		return itemsMapper;
	}
	
	@Autowired
	public void setItemsMapper(ItemsMapper itemsMapper) {
		this.itemsMapper = itemsMapper;
	}

	@Autowired
	public ContractMapper getContractMapper() {
		return contractMapper;
	}

	@Autowired
	public void setContractMapper(ContractMapper contractMapper) {
		this.contractMapper = contractMapper;
	}

	@Override
	public ContractImpl insert(ContractImpl contractImpl) throws PmException {
		contractImpl.setModified(new Date().getTime());
		contractMapper.insert(contractImpl);
		Long contractId = contractImpl.getId();
		// 添加明细
		insertList(contractImpl);
		contractImpl = new ContractImpl();
		contractImpl.setId(contractId);
		contractImpl.setSuperId(contractId);
		// flgHistory是否为历史版本(是:y,否:n)
		contractImpl.setFlgHistory("n");
		contractMapper.update(contractImpl);
		return contractImpl;
	}

	/**
	 * 搜索发票列表
	 * 
	 * @param uid 操作发票
	 * @param contractImpl 参数
	 * @return 发票列表
	 * @throws PmException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ContractImpl> select(ContractImpl contractImpl)
			throws PmException {
		DataGrid<ContractImpl> grid = new DataGrid<ContractImpl>();
		Object obj = contractImpl;
		List list = contractMapper.select(obj);
		grid.setRows(list);
		int count;
		count = contractMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得单一对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	public ContractImpl get(ContractImpl ContractImpl) throws PmException {
		Object obj = ContractImpl;
		return (ContractImpl)contractMapper.get(obj);
	}

	/**
	 * 更新单一对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	public int update(ContractImpl contractImpl) throws PmException {
		contractImpl.setModified(new Date().getTime());
		// 编辑明细
		insertList(contractImpl);
		return contractMapper.update(contractImpl);
	}

	/**
	 * 删除对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	public int delete(ContractImpl contractImpl) throws PmException {
		Long contractId = contractImpl.getId();
		Items items = new Items();
		items.setContractId(contractId);
		itemsMapper.delete(items);
		return contractMapper.delete(contractImpl);
	}

	/**
	 * 添加对象
	 * @param contract
	 * @param listItems
	 * @return
	 * @throws PmException
	 */
	public ContractImpl insert(ContractImpl contract, List<Items> listItems)
			throws PmException {
		// 设置之前记录为历史记录
		// flgHistory 是否为历史版本(是:y,否:n)
		contract.setFlgHistory("y");
		contractMapper.update(contract);
		contract.setId(null);
		contract.setFlgHistory("n");
		// 取得原版本号
		double version = contract.getVersion();
		contract.setVersion(version + 0.1);
		contractMapper.insert(contract);
		Long contractId = contract.getId();
		Items items = null;
		for (int i = 0; i < listItems.size(); i++) {
			items = listItems.get(i);
			items.setId(null);
			items.setContractId(contractId);
			itemsMapper.insert(items);
		}
		return contract;
	}

	/**
	 * 更新单一对象
	 * @param ContractImpl
	 * @return
	 * @throws PmException
	 */
	public int update(ContractImpl contractImpl, List<Items> listItems)
			throws PmException {
		return 0;
	}
	
	/**
	 * 插入明细数据
	 * @param json
	 * @param contractId
	 */
	public void insertJson(String json, ContractImpl contractImpl) {
		Long contractId = contractImpl.getId();
		String editState = contractImpl.getEditState();
		// 如果是更新状态,那么需要删除原明细数据
		if (editState.equals("u")) {
			Items items = new Items();
			items.setContractId(contractId);
			itemsMapper.delete(items);
		}
		JSONArray jsonArray = JSONArray.fromObject(json);
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Items items = (Items) JSONObject.toBean(jsonObject, Items.class);
			items.setContractId(contractId);
			itemsMapper.insert(items);
		}
	}
	
	/**
	 * 插入明细数据
	 * @param json
	 * @param contractId
	 */
	public void insertList(ContractImpl contractImpl) {
		String tagItem = contractImpl.getTagItem();
		if (tagItem == null) {
			return;
		}
		Long contractId = contractImpl.getId();
		String editState = contractImpl.getEditState();
		// 如果是更新状态或其它状态,那么需要删除原明细数据
		if (!editState.equals("i")) {
			Items items = new Items();
			items.setContractId(contractId);
			// 货品类型 c:contract 合同, b:budget 预算
			if (tagItem.equals("c")) {
				items.setTagItem(tagItem);
				itemsMapper.delete(items);
			// 货品类型 c:contract 合同, b:budget 预算(原辅材料(budget row):br, 包装材料(budget package):bp)
			} else if (tagItem.equals("b")) {
				items.setTagItem("br");
				itemsMapper.delete(items);
				items.setTagItem("bp");
				itemsMapper.delete(items);
			}
		}
		// 货品类型 c:contract 合同, b:budget 预算
		// 取预合同品列表
		if (tagItem.equals("c")) {
			List<Items> listItems = contractImpl.getListItems();
			insertList(listItems, contractId);
		// 取预算货品列表
		} else if (tagItem.equals("b")) {
			// 取得原辅材料货品列表
			List<Items> listItems = contractImpl.getListItemsAcc();
			insertList(listItems, contractId);
			// 取得包装材料货品列表
			List<Items> listItemsPack = contractImpl.getListItemsPack();
			insertList(listItemsPack, contractId);
		}

	}
	/**
	 * 插入明细数据
	 * @param json
	 * @param contractId
	 */
	public void insertList(List<Items> listItems, Long contractId) {
		// 增加行号,方便报表排序
		int rowNo = 1;
		if (listItems!= null && listItems.size() > 0) {
			for (int i = 0; i < listItems.size(); i++) {
				Items items = listItems.get(i);
				String commodity = items.getCommodity();
				if (!commodity.equals("")) {
					items.setContractId(contractId);
					items.setRowNo(rowNo);
					rowNo++;
					itemsMapper.insert(items);
				}
			}
		}
	}
}
