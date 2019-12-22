package com.mtf.framework.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.dao.BudgetMapper;
import com.mtf.framework.dao.ContractMapper;
import com.mtf.framework.dao.ItemsMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Items;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.BudgetImpl;
import com.mtf.framework.model.impl.ContractImpl;
import com.mtf.framework.service.BudgetService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 合同
 * 作者:     Auto
 * 日期:     2013-09-26
**********************************************
*/
@Service("BudgetImplService")
public class BudgetServiceImpl extends CommonServiceImpl implements BudgetService {
	@Autowired
	private BudgetMapper budgetMapper;
	@Autowired
	private ItemsMapper itemsMapper;
	@Autowired
	private ContractMapper contractMapper;
	
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

	@Autowired
	public BudgetMapper getBudgetMapper() {
		return budgetMapper;
	}

	@Autowired
	public void setBudgetMapper(BudgetMapper budgetMapper) {
		this.budgetMapper = budgetMapper;
	}

	/**
	 * 新增实体对象
	 * @param BudgetImpl
	 */
	public BudgetImpl insert(BudgetImpl budgetImpl,ContractImpl contractImpl) throws PmException {
		budgetImpl.setModified(new Date().getTime());
		// flgHistory是否为历史版本(是:y,否:n)
		contractImpl.setFlgHistory("n");
		contractMapper.insert(contractImpl);
		Long contractId = contractImpl.getId();
		contractImpl = new ContractImpl();
		contractImpl.setId(contractId);
		contractImpl.setSuperId(contractId);
		contractMapper.update(contractImpl);
		budgetImpl.setContractId(contractId);
		budgetMapper.insert(budgetImpl);
		// 添加明细
		insertList(budgetImpl);
//		// 添加决算表
//		budgetImpl.setType("a");
//		budgetImpl.setId(null);
//		budgetMapper.insert(budgetImpl);
//		insertList(budgetImpl);
		return budgetImpl;
	}
	
	public BudgetImpl insert(BudgetImpl budgetImpl) throws PmException {
		// b:预算，a:决算
		String typeBudget = budgetImpl.getType();
		if ("a".equals(typeBudget)) {
			budgetImpl.setId(null);
		}
		budgetImpl.setModified(new Date().getTime());
		budgetMapper.insert(budgetImpl);
		// 添加明细
		insertList(budgetImpl);
		// 更新合同总金额
		updateContract(budgetImpl);
		return budgetImpl;
	}
	/**
	 * 删除实体对象
	 * @param BudgetImpl
	 */
	public int delete(BudgetImpl budgetImpl) throws PmException {
		budgetMapper.delete(budgetImpl);
		// 更新合同总金额
		updateContract(budgetImpl);
		return 0;
	}

	/**
	 * 更新实体对象
	 * @param BudgetImpl
	 */
	public boolean update(BudgetImpl budgetImpl) throws PmException {
		String typeBudget = budgetImpl.getType();
		budgetImpl.setModified(new Date().getTime());
		// 添加明细
		boolean result = true;
		this.budgetMapper.update(budgetImpl);
		insertList(budgetImpl);
		// 更新合同总金额
		if ("b".equals(typeBudget)) {
			updateContract(budgetImpl);
		}
		return result;
	}
	
	/**
	 * 查询单个实体
	 * @param BudgetImpl
	 */
	public BudgetImpl get(BudgetImpl budgetImpl) throws PmException {
		return (BudgetImpl) this.budgetMapper.get(budgetImpl);
	}
	/**
	 * 查询实体列表
	 * @param BudgetImpl
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<BudgetImpl> select(BudgetImpl budgetImpl) throws PmException {
		DataGrid<BudgetImpl> grid = new DataGrid<BudgetImpl>();
		Object obj = budgetImpl;
		List list = budgetMapper.select(obj);
		grid.setRows(list);
		int count;
		count = budgetMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	/**
	 * 查询实体列表
	 * @param BudgetImpl
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<BudgetImpl> search(BudgetImpl budgetImpl) throws PmException {
		return (List) budgetMapper.select(budgetImpl);
	}
	/**
	 * 插入明细数据
	 * @param json
	 * @param contractId
	 */
	public void insertList(BudgetImpl budgetImpl) {
		Long budgetId = budgetImpl.getId();
		String type=budgetImpl.getType();
		String editState = budgetImpl.getEditState();
		// 如果是更新状态或其它状态,那么需要删除原明细数据
		if (editState != null && !editState.equals("i")) {
			Items items = new Items();
			items.setBudgetId(budgetId);
			// 货品类型 c:contract 合同, b:BudgetImpl 预算
			// 货品类型 c:contract 合同, b:BudgetImpl 预算(原辅材料(BudgetImpl row):br, 包装材料(BudgetImpl package):bp)
			items.setTagItem("br");
			itemsMapper.delete(items);
			items.setTagItem("bp");
			itemsMapper.delete(items);

		}
		// 货品类型 c:contract 合同, b:BudgetImpl 预算
		// 取预合同品列表
		// 取得原辅材料货品列表
		List<Items> listItems = budgetImpl.getListItemsAcc();
		insertList(listItems, budgetId,type);
		// 取得包装材料货品列表
		List<Items> listItemsPack = budgetImpl.getListItemsPack();
		insertList(listItemsPack, budgetId,type);
		

	}
	/**
	 * 插入明细数据
	 * @param json
	 * @param contractId
	 */
	public void insertList(List<Items> listItems, Long budgetId ,String type) {
		// 增加行号,方便报表排序
		int rowNo = 1;
		if (listItems!= null && listItems.size() > 0) {
			for (int i = 0; i < listItems.size(); i++) {
				Items items = listItems.get(i);
				String commodity = items.getCommodity();
				if (!commodity.equals("")) {
					items.setId(null);
					items.setBudgetId(budgetId);
					items.setRowNo(rowNo);
					items.setBudgetType(type);
					rowNo++;
					itemsMapper.insert(items);
				}
			}
		}
	}
	
	/**
	 * 合同复制
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	@Override
	public BudgetImpl insert(ContractImpl contract, List<BudgetImpl> listBudget) throws PmException {
		String editState=contract.getEditState();
		// c:合同复制状态
		if("c".equals(editState)){
			contract.setId(null);
			contract.setFlgHistory("n");
		}else{
		// 设置之前记录为历史记录
		// flgHistory 是否为历史版本(是:y,否:n)
		contract.setFlgHistory("y");
		contractMapper.update(contract);
		contract.setId(null);
		contract.setFlgHistory("n");
		// 取得原版本号
		double version = contract.getVersion();
		contract.setVersion(version + 0.1);
		}
		contractMapper.insert(contract);
		Long contractId = contract.getId();
		// 合同为复制状态时
		if ("c".equals(editState)) {
			ContractImpl contractImpl=new ContractImpl();
			contractImpl.setId(contractId);
			contractImpl.setSuperId(contractId);
			// flgHistory是否为历史版本(是:y,否:n)
			contractImpl.setFlgHistory("n");
			contractMapper.update(contractImpl);
		}
		BudgetImpl budget = new BudgetImpl();
		for (int i = 0; i < listBudget.size(); i++) {
			budget = listBudget.get(i);
			// 添加预算表
			budget.setContractId(contractId);
			budget.setId(null);
			budgetMapper.insert(budget);
			// 添加明细
			insertList(budget);
		}
		return budget;
	}

	/**
	 * 复制预算为决算
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl copyBudget2Current(BudgetImpl budget)
			throws PmException {
		try {
			// 预算类型: budget b,核算类型: business accounting a;
			budget.setType("b");
			List<BudgetImpl> listBudget = searchBudget(budget);
			// 取得决算表对象
			budget.setType("a");
			List<BudgetImpl> listBudgetCur = searchBudget(budget);
			BudgetImpl budgetTemp = new BudgetImpl();
			Items itemsTemp = new Items();
			//如果原决算表有数据,那么删除原决算数组
			for (int i = 0; i < listBudgetCur.size(); i++) {
				budgetTemp = listBudgetCur.get(i);
				itemsTemp.setBudgetId(budgetTemp.getId());
				itemsMapper.delete(itemsTemp);
				budgetMapper.delete(budgetTemp);
			}
			// 复制预算为决算
			this.insert(budget, listBudget);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 复制预算为决算
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl insert(BudgetImpl budget, List<BudgetImpl> listBudget)
			throws PmException {
		String typeBudget = budget.getType();
		for (int i = 0; i < listBudget.size(); i++) {
			budget = listBudget.get(i);
			Long budgetId = budget.getId();
			budget.setId(null);
			budget.setBudgetId(budgetId);
			budget.setType(typeBudget);
			budgetMapper.insert(budget);
			insertList(budget);
		}
		return budget;
	}
	
	@SuppressWarnings("rawtypes")
	private List<BudgetImpl> searchBudget(BudgetImpl budget) throws Exception{
		@SuppressWarnings("unchecked")
		List<BudgetImpl> listBudget = (List) budgetMapper.select(budget);
		List<BudgetImpl> listBudgetDetail = new ArrayList<>();
		for (int i = 0; i < listBudget.size(); i++) {
			budget = listBudget.get(i);
			Long budgetId = budget.getId();
			if (budgetId != null) {
				budget = getBudgetDetail(budget);
				listBudgetDetail.add(budget);
			}
		}
		return listBudgetDetail;
	}

	/**
	 * 取得预算对应的明细
	 * @param budget
	 * @return
	 * @throws PmException
	 */
	@SuppressWarnings("rawtypes")
	public BudgetImpl getBudgetDetail(BudgetImpl budget) throws PmException {
		budget = (BudgetImpl) budgetMapper.get(budget);
		Long budgetId = budget.getId();
		if (budgetId != null) {
			Items items = new Items();
			items.setBudgetId(budgetId);
			// 搜索预算类型货品列表
			// 预算(原辅材料(budget row):br
			items.setTagItem("br");
			@SuppressWarnings("unchecked")
			List<Items> listItemsAcc = (List) itemsMapper.select(items);
			budget.setListItemsAcc(listItemsAcc);
			// 包装材料(budget package):bp
			items.setTagItem("bp");
			@SuppressWarnings("unchecked")
			List<Items> listItemsPack = (List) itemsMapper.select(items);
			budget.setListItemsPack(listItemsPack);
		}
		return budget;
	}

	/**
	 * 合同变更
	 * @param contractImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public ModelAndView modifyContract(ContractImpl contract, List<BudgetImpl> listBudget)
			throws PmException {
		return null;
	}
	
	/**
	 * 更新合同总金额
	 * @param contract
	 */
	private void updateContract(BudgetImpl budget) {
		Long contractId = budget.getContractId();
		// 取得预算金额的累加
		String sumFOB = budgetMapper.sumFOB(budget);
		ContractImpl contract = new ContractImpl();
		contract.setId(contractId);
		contract.setTotalValue(sumFOB);
		contract.setApprover(budget.getModifiedUser());
		contract.setApproverDate(budget.getModifiedDate());
		contract.setModifiedDate(budget.getModifiedDate());
		contract.setModifiedUser(budget.getModifiedUser());
		contractMapper.update(contract);
	}
}
