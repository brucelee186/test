package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Division;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DepofficeImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.dao.DepofficeMapper;
import com.mtf.framework.dao.DivisionConditionMapper;
import com.mtf.framework.dao.OfficeMapper;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.OfficeService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品申请表
 * 作者:     Auto
 * 日期:     2013-12-12
**********************************************
*/
@Service("officeService")
public class OfficeServiceImpl extends CommonServiceImpl implements OfficeService {
	@Autowired
	private OfficeMapper officeMapper;
	
	@Autowired
	private DepofficeMapper depOfficeMapper;
	
	@Autowired
	private DivisionConditionMapper divisionConditionMapper;

	
	@Autowired
	public DivisionConditionMapper getDivisionConditionMapper() {
		return divisionConditionMapper;
	}

	@Autowired
	public void setDivisionConditionMapper(
			DivisionConditionMapper divisionConditionMapper) {
		this.divisionConditionMapper = divisionConditionMapper;
	}

	@Autowired
	public OfficeMapper getOfficeMapper() {
		return officeMapper;
	}

	@Autowired
	public void setOfficeMapper(OfficeMapper officeMapper) {
		this.officeMapper = officeMapper;
	}
	
	@Autowired
	public DepofficeMapper getDepOfficeMapper() {
		return depOfficeMapper;
	}

	@Autowired
	public void setDepOfficeMapper(DepofficeMapper depOfficeMapper) {
		this.depOfficeMapper = depOfficeMapper;
	}


	/**
	 * 新增实体对象
	 * @param office
	 */
	public OfficeImpl insert(OfficeImpl officeImpl) throws PmException {
		this.officeMapper.insert(officeImpl);
		return officeImpl;
	}

	/**
	 * 删除实体对象
	 * @param office
	 */
	public int delete(OfficeImpl officeImpl) throws PmException {
		return this.officeMapper.delete(officeImpl);
	}

	/**
	 * 更新实体对象
	 * @param office
	 */
	public boolean update(OfficeImpl officeImpl) throws PmException {
		boolean result = true;
		this.officeMapper.update(officeImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param office
	 */
	public OfficeImpl get(OfficeImpl officeImpl) throws PmException {
		
		return (OfficeImpl) this.officeMapper.get(officeImpl);
	}
	/**
	 * 查询实体列表
	 * @param office
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<OfficeImpl> select(OfficeImpl officeImpl) throws PmException {
		DataGrid<OfficeImpl> grid = new DataGrid<OfficeImpl>();
		Object obj = officeImpl;
		List list = officeMapper.select(obj);
		grid.setRows(list);
		int count;
		count = officeMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}


	/**
	 * 审批
	 */
	@Override
	public void updateApprove(OfficeImpl office,SessionInfo sessionInfo) throws PmException {
		int userLevel = sessionInfo.getUserLever();
		Date addDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		OfficeImpl officeImpl = new OfficeImpl();
		officeImpl.setUserLevel(userLevel);
		// 根据部门ID查询部门信息
		Division division = divisionConditionMapper.selectById(office.getDepartmentId());
		// 部门经理审批
		if (1 == userLevel || 7 == userLevel) {
			DepofficeImpl depoffice = new DepofficeImpl();
			depoffice.setApproveState("approve1");
			depoffice.setDepartmentId(division.getId());
			// 审批     a:审批，r:驳回
			if ("a".equals(office.getEditState())) {
				// 查询当前记录是否是审批过的二次审批
				DepofficeImpl deoff = (DepofficeImpl) depOfficeMapper.get(depoffice);
				// 获取部门汇总数据Id
				OfficeImpl OffDep = this.addDepOffice(office,division,sessionInfo);
				// 第一次审批
				if (null == deoff) {
					depoffice.setDepartmentId(division.getId());
					depoffice.setDepartment(division.getName());
					depoffice.setLeaderId(sessionInfo.getUserId());
					depoffice.setLeaderName(sessionInfo.getDisplayName());
					depoffice.setAddDate(addDate);
					depoffice.setModifiedDate(addDate);
					depoffice.setApproveState("approve1");
					// 标记为部门信息
					depoffice.setFlag("d");
					depOfficeMapper.insert(depoffice);
					officeImpl.setDepOfficeId(depoffice.getId());
				}else {
					officeImpl.setDepOfficeId(deoff.getId());
				}
					// 第二次审批
					String[] officeIds = office.getOfficeIds();
					for(int i = 0; i<officeIds.length ;i++){
						Long id = Long.parseLong(officeIds[i]);
						officeImpl.setApproveState("approve1");
						officeImpl.setId(id);
						officeImpl.setLeaderId(sessionInfo.getUserId());
						officeImpl.setLeaderName(sessionInfo.getDisplayName());
						officeImpl.setApprove1Date(new Date());
						// 部门审批汇总Id
						officeImpl.setPid(OffDep.getPid());
						officeMapper.update(officeImpl);
					}
				
			
			// 驳回
			}else if ("r".equals(office.getEditState())) {
				String[] officeIds = office.getOfficeIds();
				for(int i = 0; i<officeIds.length ;i++){
					Long id = Long.parseLong(officeIds[i]);
					officeImpl.setApproveState("reject");
					officeImpl.setId(id);
					officeImpl.setApprove1Date(new Date());
					officeMapper.update(officeImpl);
				}
				
			}
			
			
		
		// 行政部审批		
		}else if (2 == userLevel) {
			// 添加行政部审批后标记信息
			DepofficeImpl departmentOff = new DepofficeImpl();
			departmentOff.setDepartment("行政");
			// 标记为行政部信息
			departmentOff.setFlag("a");
			departmentOff.setAddDate(addDate);
			departmentOff.setApplyMonth(sdf.format(addDate));
			departmentOff.setModifiedDate(new Date());
			departmentOff.setApproveState("approve2");
			depOfficeMapper.insert(departmentOff);
			// 更新部门申请记录状态
			DepofficeImpl depoffice = new DepofficeImpl();
			depoffice.setApproveState("approve2");
			depoffice.setModifiedDate(new Date());
			depoffice.setApplyMonth(sdf.format(addDate));
			depoffice.setPid(departmentOff.getId());
			depOfficeMapper.update(depoffice);
			
			// 更新Office表申请记录状态
			officeImpl.setApproveState("approve2");
			officeImpl.setApprove2Date(new Date());
			officeImpl.setApplyMonth(sdf.format(addDate));
			officeMapper.updateApprove(officeImpl);
			
			
		}
		
	}
	
	//添加部门审批后汇总信息
	public OfficeImpl addDepOffice(OfficeImpl office,Division division,SessionInfo sessionInfo){
		Date nowDate = new Date();
		// 按条件查询部门汇总数据
		OfficeImpl officeDep = new OfficeImpl();
		officeDep.setFlag("d");
		officeDep.setDepartmentId(office.getDepartmentId());
		officeDep.setDepartment(division.getName());
		List<String> listApproveState = new ArrayList<>();
		listApproveState.add("approve1");
		officeDep.setListApproveState(listApproveState);
		OfficeImpl offDep = (OfficeImpl) officeMapper.get(officeDep);
		// 如果没有符合的记录，添加一条记录
		if (null == offDep) {
			officeDep.setAddDate(nowDate);
			officeDep.setModifiedDate(nowDate);
			officeDep.setUserId(sessionInfo.getUserId());
			officeDep.setUserName(sessionInfo.getDisplayName());
			officeDep.setApproveState("approve1");
			officeMapper.insert(officeDep);
			office.setPid(officeDep.getId());
		}else {
			office.setPid(offDep.getId());
			// 如果存在，那么更新当前记录
			OfficeImpl officeTemp = new OfficeImpl();
			officeTemp.setId(offDep.getId());
			officeTemp.setApprove1Date(new Date());
			officeTemp.setModifiedDate(new Date());
			officeMapper.update(officeTemp);
		}
		return office;
	}


}