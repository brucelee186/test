package com.mtf.office.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User2Division;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.ItemImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.service.IUser2DivisionService;
import com.mtf.framework.service.OfficeService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;


@Controller("controllerOffice")
@RequestMapping("/office/office")
public class ControllerOffice {
	
	@Autowired
	private OfficeService officeSevice;
	
	@Autowired
	private MessageSource messages;
	
	@Autowired
	private IUser2DivisionService user2DivisionSerbice;
	
	@Autowired
	private PermissionService permissionService;

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public OfficeService getOfficeSevice() {
		return officeSevice;
	}

	@Autowired
	public void setOfficeSevice(OfficeService officeSevice) {
		this.officeSevice = officeSevice;
	}
	
	@Autowired
	public MessageSource getMessages() {
		return messages;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	@Autowired
	public IUser2DivisionService getUser2DivisionSerbice() {
		return user2DivisionSerbice;
	}

	@Autowired
	public void setUser2DivisionSerbice(IUser2DivisionService user2DivisionSerbice) {
		this.user2DivisionSerbice = user2DivisionSerbice;
	}

	/**
	 * 页面跳转
	 * @throws PmException 
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(OfficeImpl office,HttpSession session) throws PmException{
	SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
	ModelAndView mv=new ModelAndView("office/searchItem");
	// 取得用户部门审批权限
	PermissionImpl permission = new PermissionImpl();
	permission.setParentCode("1401000");
	permission.setUserId(sessionInfo.getUserId());
	List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
//	List<User2Division> u2dList = user2DivisionSerbice.listByDivisionIdWithUserId(sessionInfo.getUserId());
	int count = 0;
	mv.addObject("office",office);
	if (0 == listDivision.size()){
		mv.addObject("count", count);
	}else {
		count = 1;
		mv.addObject("count", count);
		mv.addObject("divisionList", listDivision);
	}
	return mv;
	}
	
	/**
	 * 跳转页面
	 */
	@RequestMapping("/toAdd")
	public ModelAndView toAdd(ItemImpl itemImpl,HttpSession session){
	ModelAndView mv=new ModelAndView("office/editItem");
	mv.addObject("item", itemImpl);
	return mv;
	}
	/**
	 * 跳转页面
	 */
	@RequestMapping("/toOfficeAdd")
	public ModelAndView toOfficeAdd(OfficeImpl officeImpl,HttpSession session){
	ModelAndView mv=new ModelAndView("office/editOffice");
	mv.addObject("office", officeImpl);
	return mv;
	}
	/**
	 * 查询数据
	 */
	
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<OfficeImpl> doSearch(OfficeImpl officeImpl,HttpSession session) throws Exception{
		new PmException(session);
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		String userId = sessionInfo.getUserId();
		officeImpl.setUserId(userId);
		//  用户等级 1 员工 2 业务经理 3 事业经理 4 总经理
		Integer userLevel = sessionInfo.getUserLever();
		officeImpl.setUserLevel(userLevel);
		List<String> listEmployee = sessionInfo.getListEmployee();
		if (listEmployee == null) {
			listEmployee = new ArrayList<>();
			listEmployee.add(userId);
		}
		// 如果为领导那么查询下属员工
		officeImpl.setListEmployee(listEmployee);
		// 如果为领导那么查询已提交的合同
		// 审批状态集合(saved:已保存, submit:已提交, reject1:一级驳回, reject2:二级驳回, approval1:一级审批完毕, approval2:二级审批完毕)
		List<String> listApproveState = new ArrayList<>();
		if (0 == userLevel || 6 == userLevel) {
			listApproveState.add("reject");
			listApproveState.add("submit");
			listApproveState.add("approve2");
			listApproveState.add("approve1");
			//officeImpl.setDepartmentId(sessionInfo.getDivisionId());
		}
		if (1 == userLevel || 7 == userLevel) {
			listApproveState.add("submit");
			listApproveState.add("reject");
			listApproveState.add("approve1");
			listApproveState.add("approve2");
			if (null == officeImpl.getDepartmentId()){
				officeImpl.setDepartmentId(sessionInfo.getDivisionId());
			}else {
				officeImpl.setDepartmentId(officeImpl.getDepartmentId());
			}
			
		}
		// 高管部
		if (4 == userLevel) {
			listApproveState.add("approve1");
			listApproveState.add("approve2");
		}
		// 行政部临时用户
		if (5 == userLevel || 2 == userLevel) {
			listApproveState.add("reject");
			listApproveState.add("disable");
			listApproveState.add("submit");
			listApproveState.add("approve2");
			listApproveState.add("approve1");
		}
		
		if (2 == userLevel) {
			officeImpl.setUserId(null);
		}
		
		officeImpl.setListApproveState(listApproveState);
		// 每次查询用员工集合是下一级的所有审批的员工编号和本级自己本身员工编号
		DataGrid<OfficeImpl> list = new DataGrid<OfficeImpl>();
		list = officeSevice.select(officeImpl);
		return list;
		
	}
	/**
	 * 审批
	 */
	
	@RequestMapping("/submitApprove")
	public ModelAndView submitApprove(OfficeImpl officeImppl,HttpSession session) throws Exception{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		String[] officeIds = null;
		String offId = officeImppl.getField1();
		if (!TextUtils.isEmpty(offId) && TextUtils.getTrimmedLength(offId) > 0) {
			officeIds = offId.split(",");
			officeImppl.setOfficeIds(officeIds);
		}
		try {
			officeSevice.updateApprove(officeImppl,sessionInfo);
		}
		catch (Exception e) {
			throw e;
		}
		OfficeImpl office=new OfficeImpl();
		
		return this.toSearch(office, session);
	}
	
	/**
	 * 查询
	 * @param officeImpl
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doGetOffice")
	@ResponseBody
	public Json doGetOffice(OfficeImpl officeImpl,HttpSession session) throws Exception{
		Json j = new Json();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		//查询office表中是否有下面三种状态记录
		List<String> listApproveState = new ArrayList<>();
			listApproveState.add("reject");
			listApproveState.add("submit");
			listApproveState.add("approve1");
		officeImpl.setUserId(sessionInfo.getUserId());
		officeImpl.setListApproveState(listApproveState);
		// 查询个人信息
		officeImpl.setFlag("p");
		try {
			officeImpl = officeSevice.get(officeImpl);
			if (null == officeImpl) {
				// 没有返回记录表示可以添加新申请
				j.setSuccess(true);
			}else {
				j.setSuccess(false);
				j.setObj(officeImpl);
				j.setMsg(this.messages.getMessage("office.dialogue.finishedAndEdit", null,null));
			}
			
		}
		catch (Exception e) {
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping("/doUdSearch")
	@ResponseBody
	public List<User2Division> doUdSearch(HttpSession session) throws PmException{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		List<User2Division> u2dList = user2DivisionSerbice.listByDivisionIdWithUserId(sessionInfo.getUserId());
		return u2dList;
	}

}
