package com.mtf.framework.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.UserInforConditionMapper;
import com.mtf.framework.dao.UserInforMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 人员信息汇总
 * 作者:     Auto
 * 日期:     2014-03-31
**********************************************
*/
@Service("userInforService")
public class UserInforServiceImpl extends CommonServiceImpl implements UserInforService {
	@Autowired
	private UserInforMapper userInforMapper;
	
	@Autowired
	private UserInforConditionMapper userInforConditionMapper;
	
	public UserInforConditionMapper getUserInforConditionMapper() {
		return userInforConditionMapper;
	}

	public void setUserInforConditionMapper(
			UserInforConditionMapper userInforConditionMapper) {
		this.userInforConditionMapper = userInforConditionMapper;
	}

	@Autowired
	public UserInforMapper getUserinforMapper() {
		return userInforMapper;
	}

	@Autowired
	public void setUserinforMapper(UserInforMapper userInforMapper) {
		this.userInforMapper = userInforMapper;
	}

	/**
	 * 新增实体对象
	 * @param userInfor
	 */
	public UserInforImpl insert(UserInforImpl userInforImpl) throws PmException {
		String flag = userInforImpl.getFlag();
		// 判断如果flag是i  代表插入选项明细
		if ("i".equals(flag)) {
			// 调用code码
			String code = codeSet(userInforImpl);
			userInforImpl.setCode(code);
		}
		this.userInforMapper.insert(userInforImpl);
		return userInforImpl;
	}

	/**
	 * 删除实体对象
	 * @param userInfor
	 */
	public int delete(UserInforImpl userInforImpl) throws PmException {
		return this.userInforMapper.delete(userInforImpl);
	}

	/**
	 * 更新实体对象
	 * @param userInfor
	 */
	public boolean update(UserInforImpl userInforImpl) throws PmException {
		boolean result = true;
		Long idMain = userInforImpl.getId();
		String typeSystem = userInforImpl.getTypeSystem();
		UserInforImpl userInforTemp = new UserInforImpl();
		userInforTemp.setPid(idMain);
		userInforTemp.setTypeSystem(typeSystem);
		userInforTemp.setTagUpdate("allow");
		userInforMapper.update(userInforTemp);
		this.userInforMapper.update(userInforImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param userInfor
	 */
	public UserInforImpl get(UserInforImpl userInforImpl) throws PmException {
		return (UserInforImpl) this.userInforMapper.get(userInforImpl);
	}
	/**
	 * 查询实体列表
	 * @param userInfor
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<UserInforImpl> select(UserInforImpl userInforImpl) throws PmException {
		DataGrid<UserInforImpl> grid = new DataGrid<UserInforImpl>();
		Object obj = userInforImpl;
		List list = userInforMapper.select(obj);
		grid.setRows(list);
		int count;
		count = userInforMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	// code码的插入
	public String codeSet(UserInforImpl userInfor){
		String type = userInfor.getType();
		String code = null;
		// 获取当前类型日期最的数据
		UserInforImpl userInforTemp = new UserInforImpl();
		userInforTemp.setPid(userInfor.getPid());
		userInforTemp.setType(type);
		userInforTemp.setSort("CAST(codeOrder AS DECIMAL)");
		userInforTemp.setOrder("DESC");
		UserInforImpl uif = (UserInforImpl) userInforMapper.get(userInforTemp);
		 if (uif == null) {
			 // 如果当前类型下没有数据，把类型加1作为code值
			code = type+1;
		 }else{
			 // 如果当前类型下有数据，获取类型后的编号继续累加
			code = uif.getCode();
			if (code.length() >= 2) {
				String count = code.substring(type.length(), code.length());
				Pattern pattern = Pattern.compile("[0-9]*");
				Matcher matcher = pattern.matcher(count);
				if (matcher.matches()) {
					int countTemp = Integer.parseInt(count);
					countTemp++;
					code = type+countTemp; 
				}
			}
		}
		return code;
	}

	/**
	 * 查询实体列表
	 * @param userInfor
	 * @return
	 * @throws PmException
	 */
	@SuppressWarnings("unchecked")
	public List<UserInforImpl> search(UserInforImpl userInforImpl)
			throws PmException {
		List<UserInforImpl> list = (List<UserInforImpl>) userInforMapper.select(userInforImpl);
		return list;
	}
	
	/**
	 * 查询实体数量
	 * @param userInfor
	 */
	public Integer count(UserInforImpl userInforImpl) throws PmException {
		Object obj = userInforImpl;
		Integer count;
		count = userInforMapper.count(obj);
		return count;
	}

	@Override
	public List<UserInforImpl> selectListMap(UserInforImpl userInfor)
			throws PmException {
		return userInforConditionMapper.selectListMap(userInfor);
	}
}