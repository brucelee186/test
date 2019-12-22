package com.mtf.framework.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.DivisionRoleMapper;
import com.mtf.framework.dao.PermissionConditionMapper;
import com.mtf.framework.dao.PermissionMapper;
import com.mtf.framework.dao.RoleConditionMapper;
import com.mtf.framework.dao.RoleMapper;
import com.mtf.framework.dao.RolePermissionConditionMapper;
import com.mtf.framework.dao.RolePermissionMapper;
import com.mtf.framework.dao.UserDivisionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Permission;
import com.mtf.framework.model.Role;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.DivisionRoleImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.RoleImpl;
import com.mtf.framework.model.impl.RolePermissionImpl;
import com.mtf.framework.service.RolePermissionService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 角色权限列表
 * 作者:     Auto
 * 日期:     2015/1/15
**********************************************
*/
@Service("rolePermissionService")
public class RolePermissionServiceImpl extends CommonServiceImpl implements RolePermissionService {
	@Autowired
	private RolePermissionMapper rolePermissionMapper;
	
	@Autowired
	private PermissionConditionMapper permissionConditionMapper;
	
	@Autowired
	private RolePermissionConditionMapper rolePermissionConditionMapper;
	
	@Autowired
	private RoleConditionMapper roleConditionMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserDivisionMapper userDivisionMapper;
	
	@Autowired
	private DivisionRoleMapper divisionRoleMapper;
	
	@Autowired
	private PermissionMapper permissionMapper;

	@Autowired
	public PermissionMapper getPermissionMapper() {
		return permissionMapper;
	}

	@Autowired
	public void setPermissionMapper(PermissionMapper permissionMapper) {
		this.permissionMapper = permissionMapper;
	}

	@Autowired
	public DivisionRoleMapper getDivisionRoleMapper() {
		return divisionRoleMapper;
	}

	@Autowired
	public void setDivisionRoleMapper(DivisionRoleMapper divisionRoleMapper) {
		this.divisionRoleMapper = divisionRoleMapper;
	}

	public RoleMapper getRoleMapper() {
		return roleMapper;
	}

	public void setRoleMapper(RoleMapper roleMapper) {
		this.roleMapper = roleMapper;
	}

	@Autowired
	public UserDivisionMapper getUserDivisionMapper() {
		return userDivisionMapper;
	}

	@Autowired
	public void setUserDivisionMapper(UserDivisionMapper userDivisionMapper) {
		this.userDivisionMapper = userDivisionMapper;
	}

	@Autowired
	public RoleConditionMapper getRoleConditionMapper() {
		return roleConditionMapper;
	}

	@Autowired
	public void setRoleConditionMapper(RoleConditionMapper roleConditionMapper) {
		this.roleConditionMapper = roleConditionMapper;
	}

	@Autowired
	public RolePermissionConditionMapper getRolePermissionConditionMapper() {
		return rolePermissionConditionMapper;
	}

	@Autowired
	public void setRolePermissionConditionMapper(
			RolePermissionConditionMapper rolePermissionConditionMapper) {
		this.rolePermissionConditionMapper = rolePermissionConditionMapper;
	}

	@Autowired
	public PermissionConditionMapper getPermissionConditionMapper() {
		return permissionConditionMapper;
	}

	@Autowired
	public void setPermissionConditionMapper(
			PermissionConditionMapper permissionConditionMapper) {
		this.permissionConditionMapper = permissionConditionMapper;
	}

	@Autowired
	public RolePermissionMapper getRolePermissionMapper() {
		return rolePermissionMapper;
	}

	@Autowired
	public void setRolePermissionMapper(RolePermissionMapper rolePermissionMapper) {
		this.rolePermissionMapper = rolePermissionMapper;
	}

	/**
	 * 新增实体对象
	 * @param rolePermission
	 */
	public RolePermissionImpl insert(RolePermissionImpl rolePermission, HttpSession session) throws PmException {
		// 取得所有权限code
		Map<String, RolePermissionImpl> mapRolePermission = rolePermission.getMapRolePermission();
		Iterator<String> iteratorCodeTemp;
		String codeTemp;
		String roleId = rolePermission.getRoleId();
		Set<String> setKeyCode = mapRolePermission.keySet();
		if (setKeyCode != null && setKeyCode.size() > 0) {
			iteratorCodeTemp = setKeyCode.iterator();
			while (iteratorCodeTemp.hasNext()) {
				codeTemp = iteratorCodeTemp.next();
				rolePermission = new RolePermissionImpl();
				rolePermission.setCode(codeTemp);
				rolePermission.setRoleId(roleId);
				CommonUtil.setCommonField(rolePermission, session);
				this.rolePermissionMapper.insert(rolePermission);
			}
		}
		return rolePermission;
	}

	/**
	 * 删除实体对象
	 * @param rolePermission
	 */
	public int delete(RolePermissionImpl rolePermission) throws PmException {
		return this.rolePermissionMapper.delete(rolePermission);
	}

	/**
	 * 更新实体对象
	 * @param rolePermission
	 */
	public boolean update(RolePermissionImpl rolePermission) throws PmException {
		boolean result = true;
		this.rolePermissionMapper.update(rolePermission);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param rolePermission
	 */
	public RolePermissionImpl get(RolePermissionImpl rolePermission) throws PmException {
		return (RolePermissionImpl) this.rolePermissionMapper.get(rolePermission);
	}
	/**
	 * 查询实体列表
	 * @param rolePermission
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<RolePermissionImpl> select(RolePermissionImpl rolePermission) throws PmException {
		DataGrid<RolePermissionImpl> grid = new DataGrid<RolePermissionImpl>();
		Object obj = rolePermission;
		List list = rolePermissionMapper.select(obj);
		grid.setRows(list);
		int count;
		count = rolePermissionMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	/**
	 * 取得权限表以角色权限数据
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl searchPermissionList(
			RolePermissionImpl rolePermission) throws PmException {
		PermissionImpl permission = new PermissionImpl();
		String roleId = rolePermission.getRoleId();
		String typeSys = rolePermission.getTypeSys();
		String type = rolePermission.getType();
		// 取得角色信息
		Role role = new Role();
		role = roleConditionMapper.selectById(roleId);
		String roleName = role.getName();
		rolePermission.setRoleName(roleName);
		permission.setRoleId(roleId);
		permission.setTypeSys(typeSys);
		permission.setType(type);
		List<PermissionImpl> listPermission = permissionConditionMapper.searchPermissionList(permission);
		rolePermission.setListPermission(listPermission);
		return rolePermission;
	}

	/**
	 * 编辑角色权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl editRolePermission(RolePermissionImpl rolePermission, HttpSession session) throws PmException {
		String typeSys = rolePermission.getTypeSys();
		// 角色类型(s:系统,d:部门,u:用户)
		String type = rolePermission.getType();
		String typeId = rolePermission.getTypeId();
		// 记录类型(r: reference 引用外表,n: non reference 非外用外表)
		if ("n".equals(typeSys)) {
			// 取得所有权限code
			Map<String, RolePermissionImpl> mapRolePermission = new HashMap<String, RolePermissionImpl>();
			Iterator<String> iteratorCodeTemp;
			String codeTemp;
			String roleId = rolePermission.getRoleId();
			HashMap<String, RolePermissionImpl> mapRolePermission1 = rolePermission.getMapRolePermission1();
			HashMap<String, RolePermissionImpl> mapRolePermission2 = rolePermission.getMapRolePermission2();
			HashMap<String, RolePermissionImpl> mapRolePermission3 = rolePermission.getMapRolePermission3();
			if (null != mapRolePermission1) {
				mapRolePermission.putAll(mapRolePermission1);
			}
			if (null != mapRolePermission2) {
				mapRolePermission.putAll(mapRolePermission2);
				
			}
			if (null != mapRolePermission3) {
				mapRolePermission.putAll(mapRolePermission3);
				
			}
			Set<String> setKeyCode = mapRolePermission.keySet();
			if ("d".equals(type)) {
				// 取得部门编号存入typeId
				/*String roleIdDep = rolePermission.getRoleId();
				// 根据部门编号取得部门角色编号
				DivisionRoleImpl divisionRole = new DivisionRoleImpl();
				divisionRole.setRoleId(roleIdDep);
				divisionRole = (DivisionRoleImpl) divisionRoleMapper.get(divisionRole);
				String divisionIdType = divisionRole.getDivisionId();
				System.err.println(divisionIdType);*/
			}
			if (setKeyCode != null && setKeyCode.size() > 0) {
				// 删除当前角色的所有权限
				rolePermission.setTypeId(null);
				rolePermissionMapper.delete(rolePermission);
				iteratorCodeTemp = setKeyCode.iterator();
				while (iteratorCodeTemp.hasNext()) {
					rolePermission = new RolePermissionImpl();
					// 取得父编号
					codeTemp = iteratorCodeTemp.next();
					PermissionImpl permissionInner = new PermissionImpl();
					permissionInner.setCode(codeTemp);
					permissionInner = (PermissionImpl) permissionMapper.get(permissionInner);
					if (null != permissionInner) {
						String parentCode = permissionInner.getParentCode();
						if (null != parentCode && parentCode.length() > 0) {
							rolePermission.setParentCode(parentCode);
						}
					}
					rolePermission.setCode(codeTemp);
					rolePermission.setRoleId(roleId);
					rolePermission.setTypeSys(typeSys);
					rolePermission.setType(type);
					if (null != typeId) {
						rolePermission.setTypeId(typeId);
					}
					CommonUtil.setCommonField(rolePermission, session);
					this.rolePermissionMapper.insert(rolePermission);
				}
			}
		}
		// 记录类型(r: reference 引用外表,n: non reference 非外用外表)
		else if ("r".equals(typeSys)) {
			// 取得所有权限code
			Map<String, RolePermissionImpl> mapRolePermission = new HashMap<String, RolePermissionImpl>();
			String roleId = rolePermission.getRoleId();
			HashMap<String, RolePermissionImpl> mapRolePermission1 = rolePermission.getMapRolePermission1();
			HashMap<String, RolePermissionImpl> mapRolePermission2 = rolePermission.getMapRolePermission2();
			HashMap<String, RolePermissionImpl> mapRolePermission3 = rolePermission.getMapRolePermission3();
			if (null != mapRolePermission1 && mapRolePermission1.size() > 0) {
				mapRolePermission.putAll(mapRolePermission1);
			}
			if (null != mapRolePermission2 && mapRolePermission2.size() > 0) {
				mapRolePermission.putAll(mapRolePermission2);
			}
			if (null != mapRolePermission3 && mapRolePermission3.size() > 0) {
				mapRolePermission.putAll(mapRolePermission3);
			}
			if (null != mapRolePermission && mapRolePermission.size() > 0) {
				RolePermissionImpl rolePermissionDel = new RolePermissionImpl();
				rolePermissionDel.setRoleId(roleId);
				rolePermissionMapper.delete(rolePermissionDel);
				// 取得需要审批的负责人,总监,高管
				/*UserDivisionImpl userDivision = new UserDivisionImpl();
				String divisionId = rolePermission.getDivisionId();
				UserDivisionImpl userDivision = new UserDivisionImpl();
				List<UserDivisionImpl> listUserDivision = (List<UserDivisionImpl>) userDivisionMapper.select(userDivision);
				if (null != listUserDivision && listUserDivision.size() == 1) {
					
				}*/
				Iterator<Map.Entry<String, RolePermissionImpl>> it = mapRolePermission.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, RolePermissionImpl> entry = (Map.Entry<String, RolePermissionImpl>) it.next();
					String keyString = entry.getKey();
					RolePermissionImpl valueBean = entry.getValue();
					String[] keyArray = keyString.split("_");
					if (null != keyArray && keyArray.length == 2) {
						String parentCode =  keyArray[0];
						String code = keyArray[1];
						String haveExtends = valueBean.getHaveExtends();
						String codeChecked = valueBean.getCode3();
						String approver1 = valueBean.getApprover1();
						String approver2 = valueBean.getApprover2();
						String approver3 = valueBean.getApprover3();
						String approveType = valueBean.getApproveType();
						Long approver1LimitRuleId = valueBean.getApprover1LimitRuleId();
						Double approver1AmonutLower = valueBean.getApprover1AmonutLower();
						if ((null != haveExtends || "s".equals(type)) && null != codeChecked) {
							rolePermission = new RolePermissionImpl();
							rolePermission.setCode(code);
							rolePermission.setParentCode(parentCode);
							rolePermission.setRoleId(roleId);
							rolePermission.setTypeSys(typeSys);
							rolePermission.setType(type);
							rolePermission.setTypeId(typeId);
							rolePermission.setHaveExtends("n");
							rolePermission.setApprover1(approver1);
							rolePermission.setApprover2(approver2);
							rolePermission.setApprover3(approver3);
							rolePermission.setApproveType(approveType);
							rolePermission.setApprover1LimitRuleId(approver1LimitRuleId);
							rolePermission.setApprover1AmonutLower(approver1AmonutLower);
							if (null == codeChecked && !"s".equals(type)) {
								rolePermission.setHaveCode("n");
							} else {
								rolePermission.setHaveCode("y");
							}
							CommonUtil.setCommonField(rolePermission, session);
							this.rolePermissionMapper.insert(rolePermission);
						} 
					}
				}
			}
		}
		return rolePermission;
	}

	/**
	 * 取得角色权限列表
	 * @param listRole
	 * @return
	 * @throws PmException
	 */
	public Map<String, String> SearchRolePermission(List<String> listRole)
			throws PmException {
		// 取得权限列表
		RolePermissionImpl rolePermission = new RolePermissionImpl();
		rolePermission.setListRolePermissionInit(listRole);
		Map<String, String> mapRolePermission = new java.util.HashMap<>();
		List<RolePermissionImpl> listRolePermission = rolePermissionConditionMapper.selectLoginPermission(rolePermission);
		for (RolePermissionImpl rolePermissionTemp : listRolePermission) {
			mapRolePermission.put(rolePermissionTemp.getCode(), rolePermissionTemp.getRoleId());
		}
		return mapRolePermission;
	}

	/**
	 * 查询用户审批时所具有的部门权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public List<String> searchRolePermissionDivision(
			RolePermissionImpl rolePermission) throws PmException {
		return null;
	}

	/**
	 * 搜索权限键值对
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public Set<Map<String, String>> selectMap(RolePermissionImpl rolePermission)
			throws PmException {
		return rolePermissionConditionMapper.selectMap(rolePermission);
	}

	/**
	 * 复制角色权限
	 * @param rolePermission
	 * @return
	 * @throws PmException
	 */
	public RolePermissionImpl copyRolePermission(
			RolePermissionImpl rolePermission, HttpSession session)
			throws PmException {
		String roleId = rolePermission.getRoleId();
		Long idRolePermission = rolePermission.getId();
		RoleImpl role = new RoleImpl();
		role.setId(roleId);
		role = (RoleImpl) roleMapper.get(role);
		String name = role.getName();
		name = "复制角色/" + name;
		role.setName(name);
		role.setTypeId(null);
		role.setId(UUID.randomUUID().toString());
		CommonUtil.setCommonField(role);
		roleMapper.insert(role);
		String roleIdNew = role.getId();
		RolePermissionImpl rolePermissionTemp = new RolePermissionImpl();
		rolePermissionTemp.setId(idRolePermission);
		rolePermissionTemp = (RolePermissionImpl) rolePermissionMapper.get(rolePermissionTemp);
		RolePermissionImpl rolePermissionTemp2 = new RolePermissionImpl();
		rolePermissionTemp2.setRoleId(roleId);
		List<RolePermissionImpl> listRolePermission = (List<RolePermissionImpl>) rolePermissionMapper.select(rolePermissionTemp2);
		DivisionRoleImpl divisionRole = new DivisionRoleImpl();
		divisionRole.setRoleId(roleIdNew);
		CommonUtil.setCommonField(divisionRole);
		divisionRoleMapper.insert(divisionRole);
		if (null != listRolePermission && listRolePermission.size() > 0) {
			for (int i = 0; i < listRolePermission.size(); i++) {
				RolePermissionImpl rolePermissionInner = listRolePermission.get(i);
				rolePermissionInner.setEditState("i");
				rolePermissionInner.setRoleId(roleIdNew);
				rolePermissionInner.setId(null);
				CommonUtil.setCommonField(rolePermissionInner);
				rolePermissionMapper.insert(rolePermissionInner);
				
			}
		}
		return rolePermission;
	}
}