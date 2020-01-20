package com.mtf.office.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.ItemImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.service.ItemService;
import com.mtf.framework.service.OfficeService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.TextUtils;



@Controller("controllerItem")
@RequestMapping("/office/item")
public class ControllerItem {
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private MessageSource messages;

	@Autowired
	public ItemService getItemService() {
		return itemService;
	}

	@Autowired
	public void setItemService(ItemService itemService) {
		this.itemService = itemService;
	}
	
	@Autowired
	public OfficeService getOfficeService() {
		return officeService;
	}

	@Autowired
	public void setOfficeService(OfficeService officeService) {
		this.officeService = officeService;
	}

	@Autowired
	public MessageSource getMessages() {
		return messages;
	}

	@Autowired
	public void setMessages(MessageSource messages) {
		this.messages = messages;
	}

	/**
	 * 编辑
	 */
	
	@RequestMapping("/doEdit")
	@ResponseBody
	public Json doEdit(@RequestParam("ruleIds") String ruleId,@RequestParam("amounts") String amount,ItemImpl itemImpl,HttpSession session)throws Exception{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		String editState = itemImpl.getEditState();
		int userLevel = sessionInfo.getUserLever();
		Json j = new Json();
		if(TextUtils.isEmpty(ruleId)){
			j.setSuccess(false);
			j.setMsg(this.messages.getMessage("office.error.submit", null,null));
			return j;
		}
		OfficeImpl officeImpl = new OfficeImpl();
		// 获取当前系统时间
		Date addDate = new Date();
		try {
			String[] ruleIds = null;
			String[] amounts = null;
			if (!TextUtils.isEmpty(ruleId) && TextUtils.getTrimmedLength(ruleId) > 0) {
				ruleIds = ruleId.split(",");
			}
			if (!TextUtils.isEmpty(amount) && TextUtils.getTrimmedLength(amount) > 0) {
				amounts = amount.split(",");
			}
			// 提交审批
		if ("i".equals(editState)) {
				officeImpl.setDepartment(sessionInfo.getDivisionName());
				officeImpl.setDepartmentId(sessionInfo.getDivisionId());
				officeImpl.setUserId(sessionInfo.getUserId());
				officeImpl.setUserName(sessionInfo.getDisplayName());
				officeImpl.setAddDate(addDate);
				officeImpl.setFlag("p");
				officeImpl.setModifiedDate(addDate);
				// 如果申请人是高管人员，提交状态为部门确认
				if (userLevel == 4) {
					officeImpl.setApproveState("approve1");
				}else {
					officeImpl.setApproveState("submit");
				}
				this.itemService.insertItemRule(ruleIds, amounts,officeImpl,session);
			
		}
		// 修改
		else if ("u".equals(editState)) {
			// 添加用户的等级
			itemImpl.setUserLevel(userLevel);
			this.itemService.update(ruleIds, amounts,itemImpl,session);
		}
		j.setSuccess(true);
		} catch (PmException e) {
			j.setSuccess(false);
			j.setMsg(e.getMessage());
		} catch (Exception e) {
			throw e;
		}
		
		return j;
	}



	/**
	 * 跳转到编辑页面
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(ItemImpl itemImpl,HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView("office/editItem");
		mv.addObject("item",itemImpl);
		return mv;
	}

	/**
	 * 查询数据
	 */
	@RequestMapping("/doSearch")
	@ResponseBody
	public DataGrid<ItemImpl> doSearch(ItemImpl itemImpl,HttpSession session)throws Exception{
		DataGrid<ItemImpl> list = itemService.select(itemImpl);
		return list;
				
	}
	

}
