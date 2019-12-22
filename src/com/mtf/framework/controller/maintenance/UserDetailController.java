package com.mtf.framework.controller.maintenance;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.AttachmentImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.AttachmentService;
import com.mtf.framework.service.UserDetailService;
import com.mtf.framework.service.UserDivisionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 人员信息表
 * 作者:    Auto
 * 日期:    2015/2/26
**********************************************
*/
@Controller("userDetailController")
@RequestMapping("/maintenance/userDetail")
public class UserDetailController extends BaseController {

	@Autowired
	private UserDetailService userDetailService;
	
	@Autowired
	private AttachmentService attachmentService;
	
	@Autowired
	private AttachmentController attachmentController;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDivisionService userDivisionService;
	
	@Autowired
	private UserInforService userInforService;

	public UserDivisionService getUserDivisionService() {
		return userDivisionService;
	}

	public void setUserDivisionService(UserDivisionService userDivisionService) {
		this.userDivisionService = userDivisionService;
	}

	public UserInforService getUserInforService() {
		return userInforService;
	}

	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public UserService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public AttachmentController getAttachmentController() {
		return attachmentController;
	}

	@Autowired
	public void setAttachmentController(AttachmentController attachmentController) {
		this.attachmentController = attachmentController;
	}

	@Autowired
	public AttachmentService getAttachmentService() {
		return attachmentService;
	}

	@Autowired
	public void setAttachmentService(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}

	@Autowired
	public UserDetailService getUserDetailService() {
		return userDetailService;
	}

	@Autowired
	public void setUserDetailService(UserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		ModelAndView mv = new ModelAndView("/maintenance/user/searchUserDetail");
		// 加载分类json
		JSONArray jsonArray = new JSONArray();
		List<UserInforImpl> listUserInfor = null;
		try {
			UserInforImpl userInfor = new UserInforImpl();
			userInfor.setFlag("i");
			listUserInfor = this.userInforService.search(userInfor);
		} catch (PmException e) {
			e.printStackTrace();
		}
		jsonArray.add(listUserInfor);
		mv.addObject("jsonListUserInfor", jsonArray.toString());
		return mv;
	}

	/**
	 * 查询
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/doSearch", method=RequestMethod.POST)
	@ResponseBody
	public DataGrid<UserDetailImpl> doSearch(UserDetailImpl userDetail, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<UserDetailImpl> list = new DataGrid<UserDetailImpl>();
		list = this.userDetailService.search(userDetail);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param userDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(UserDetailImpl userDetail) throws Exception {
		ModelAndView mv = new ModelAndView("/maintenance/user/editUserDetail");
		String statusInit = userDetail.getStatusInit();
		String editState = userDetail.getEditState();
		String userId = userDetail.getUserId();
		if ("u".equals(editState)) {
			userDetail = userDetailService.get(userDetail);
			// 如果用户为创建一个新用户
		}
		if (userDetail == null && null != userId && !"".equals(userId)) {
			userDetail = new UserDetailImpl();
			userDetail.setUserId(userId);
			userDetailService.insert(userDetail);
		}
		userDetail.setEditState(editState);
		// a:所有
		if (null == statusInit) {
			statusInit = "a";
		}
		userDetail.setStatusInit(statusInit);
		// 取得用户主部门,放到userBean中
		UserDivisionImpl userDivision = new UserDivisionImpl();
		userDivision.setMainIndex(1);
		userDivision.setUserId(userId);
		userDivision = userDivisionService.get(userDivision);
		if (null != userDivision) {
			String divisionId = userDivision.getDivisionId();
			if (null != divisionId) {
				userDetail.setDivisionId(divisionId);
			}
		}
		mv.addObject("userDetail", userDetail);
		return mv;
	}

	/**
	 * 编辑
	 * @param userDetail
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(UserDetailImpl userDetail, HttpSession session) throws Exception {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		new PmException(session);
		Json j = new Json();
		String editState = userDetail.getEditState();
		String typeAttach = userDetail.getTypeAttach();
		String statusInit = userDetail.getStatusInit();
		// 取得用户需要赋值的字段
		// String attachFiled = userDetail.getAttachFiled();
		// 取得用户编号 如果没有那么重新插入一条件新用户明细数据
		String userId = userDetail.getUserId();
		if (null == userId || "".equals(userId)) {
			UserImpl user = new UserImpl();
			userDetailService.inserUserDetail(user, userDetail);
		}
		try {
			if ("i".equals(editState)) {
				if (sessionInfo != null) {
					CommonUtil.setCommonField(userDetail, session);
				}
				userDetailService.insert(userDetail);
			} else if ("u".equals(editState)) {
				if (sessionInfo != null) {
					CommonUtil.setCommonField(userDetail, session);
				}
				userDetailService.update(userDetail);
			} else if ("d".equals(editState)) {
				userDetailService.delete(userDetail);
				// edit attach 上传附件
			} else if ("ea".equals(editState)) {
				AttachmentImpl attachment = new AttachmentImpl();
				String pathClient = session.getServletContext().getRealPath(File.separator);
				attachment.setPathClient(pathClient);
				attachment.setListFile(userDetail.getListFile());
				// 根据不同附件添加相关的类型
				//attachment.setType("attachment");
				// 设置需要更新的附件下标
				attachment.setAttachIndex(userDetail.getAttachIndex());
				attachment = attachmentService.attachUpload(attachment);
				Long attachmentId = attachment.getId();
				userDetail.setAttachmentId(attachmentId);
				//
//				Class<?> classUserDetail = UserDetailImpl.class;
//				Field fieldAttachment = classUserDetail.getDeclaredField(attachFiled);
//				fieldAttachment.setAccessible(true);
//				fieldAttachment.set(userDetail, attachmentId);
				userDetail.setSavePathFile(attachment.getSavePathFile());
				// 设置附件上传类型
				userDetail.setTypeAttach(typeAttach);
				// 设置文件名
				userDetail.setAttachFileName(attachment.getFileName());
			}
			// 关闭文件流
			userDetail.setListFile(null);
			userDetail.setStatusInit(statusInit);
			j.setSuccess(true);
			j.setObj(userDetail);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	/**
	 * 跳转编辑
	 * @param userDivision
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/doListUserByDivision")
	public ModelAndView doListUserByDivision(UserDetailImpl userDetail, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/_listUserDivision");
		userDetail.setTagMapper("doListUserByDivision");
		List<UserDetailImpl> listUserDivision = userDetailService.select(userDetail);
		mv.addObject("listUserDivision", listUserDivision);
		return mv;
	}
	
}

