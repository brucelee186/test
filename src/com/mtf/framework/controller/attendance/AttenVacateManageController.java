package com.mtf.framework.controller.attendance;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.mtf.framework.dao.AttenVacateManageMapper;
import com.mtf.framework.dao.UserDetailConditionMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.AttenVacateImpl;
import com.mtf.framework.model.impl.AttenVacateManageImpl;
import com.mtf.framework.model.impl.EmailImpl;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.UserDetailImpl;
import com.mtf.framework.model.impl.UserDivisionImpl;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.AttenVacateManageService;
import com.mtf.framework.service.AttenVacateService;
import com.mtf.framework.service.DivisionService;
import com.mtf.framework.service.EmailService;
import com.mtf.framework.service.PermissionService;
import com.mtf.framework.service.UserDivisionService;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 请假管理
 * 作者:    Auto
 * 日期:    2015/6/18
**********************************************
*/
@Controller("attenVacateManageController")
@RequestMapping("/attendance/attenVacateManage")
public class AttenVacateManageController extends BaseController{

	@Autowired
	private AttenVacateManageService attenVacateManageService;
	
	@Autowired
	private AttenVacateService attenVacateService;
	
	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserInforService userInforService;
	
	@Autowired
	private UserDetailConditionMapper userDetailConditionMapper;
	
	
	@Autowired
	private UserDivisionService userDivisionService;
	
	@Autowired
	private AttenVacateManageMapper attenVacateManageMapper;
	
	@Autowired
	private DivisionService divisionService;
	
	@Autowired
	public DivisionService getDivisionService() {
		return divisionService;
	}

	@Autowired
	public void setDivisionService(DivisionService divisionService) {
		this.divisionService = divisionService;
	}

	public AttenVacateManageMapper getAttenVacateManageMapper() {
		return attenVacateManageMapper;
	}

	@Autowired
	public void setAttenVacateManageMapper(
			AttenVacateManageMapper attenVacateManageMapper) {
		this.attenVacateManageMapper = attenVacateManageMapper;
	}

	@Autowired
	public UserDivisionService getUserDivisionService() {
		return userDivisionService;
	}

	@Autowired
	public void setUserDivisionService(UserDivisionService userDivisionService) {
		this.userDivisionService = userDivisionService;
	}

	@Autowired
	public UserDetailConditionMapper getUserDetailConditionMapper() {
		return userDetailConditionMapper;
	}

	@Autowired
	public void setUserDetailConditionMapper(
			UserDetailConditionMapper userDetailConditionMapper) {
		this.userDetailConditionMapper = userDetailConditionMapper;
	}

	@Autowired
	public UserInforService getUserInforService() {
		return userInforService;
	}

	@Autowired
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}

	@Autowired
	public EmailService getEmailService() {
		return emailService;
	}

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public PermissionService getPermissionService() {
		return permissionService;
	}

	public void setPermissionService(PermissionService permissionService) {
		this.permissionService = permissionService;
	}

	@Autowired
	public AttenVacateService getAttenVacateService() {
		return attenVacateService;
	}

	@Autowired
	public void setAttenVacateService(AttenVacateService attenVacateService) {
		this.attenVacateService = attenVacateService;
	}

	@Autowired
	public AttenVacateManageService getAttenVacateManageService() {
		return attenVacateManageService;
	}

	@Autowired
	public void setAttenVacateManageService(AttenVacateManageService attenVacateManageService) {
		this.attenVacateManageService = attenVacateManageService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(AttenVacateManageImpl attenVacateManage) throws Exception {
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/searchAttenVacateManage");
		String tagPageCode = attenVacateManage.getTagPageCode();
		mv.addObject("attenVacateManage", attenVacateManage);
		mv.addObject("tagPageCode", tagPageCode);
		return mv;
	}
	
	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearchOvertime")
	public ModelAndView toSearchOvertime(AttenVacateManageImpl attenVacateManage) throws Exception {
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/searchAttenVacateManageOvertime");
		String tagPageCode = attenVacateManage.getTagPageCode();
		if("16200100".equals(tagPageCode)){
			// od 部门加班
			attenVacateManage.setTypeData("od");
		}
		else if("16200200".equals(tagPageCode)){
			// op个人加班
			attenVacateManage.setTypeData("op");
			attenVacateManage.setDivisionId(getDivisionId()); 
			attenVacateManage.setDivisionName(getDivisionName());
			attenVacateManage.setUserId(getCardNo());
			attenVacateManage.setUserName(getUserName());
			attenVacateManage.setUserIdList(getUserId());
			attenVacateManage.setUserNameList(getUserName());
		}
		// 加班修正
		else if("16200400".equals(tagPageCode)){
			// m 加班修正
			attenVacateManage.setTypeData("m");
			attenVacateManage.setDivisionId(""); 
		}
		// 取得负责人对应的部门
		if("16200100".equals(tagPageCode)){
		}
		/*UserDivisionImpl userDivision = new UserDivisionImpl();
		userDivision.setUserId(getUserId());
		userDivision.setPositionId("gwmc2");
		List<UserDivisionImpl> listUserDivision = userDivisionService.select(userDivision);
		if(null != listUserDivision && listUserDivision.size() > 0){
			
		}*/
		mv.addObject("attenVacateManage", attenVacateManage);
		mv.addObject("tagPageCode", tagPageCode);
		return mv;
	}
	
	/**
	 * 跳转到审批介面
	 * @param attenVacateManage
	 * @return
	 */
	@RequestMapping("/toSearchApprove")
	public ModelAndView toSearchApprove(AttenVacateManageImpl attenVacateManage) throws Exception {
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/searchAttenVacateManageApprove");
		mv.addObject("attenVacateManage", attenVacateManage);
		String tagPageCode = attenVacateManage.getTagPageCode();
		
		// 取得地点下拉列表
		UserInforImpl userInfor = new UserInforImpl();
		userInfor.setType("bqdd");
		// 明细
		userInfor.setFlag("i");
		List<UserInforImpl> listUserInfor = userInforService.search(userInfor);
		JSONArray jsonArrayUserInfor = new JSONArray();
		jsonArrayUserInfor.add(listUserInfor);
		mv.addObject("jsonArraySigninLocation", jsonArrayUserInfor);
		
		// 取得时间段下拉列表
		userInfor = new UserInforImpl();
		userInfor.setType("bqsjd");
		// 明细
		userInfor.setFlag("i");
		listUserInfor = userInforService.search(userInfor);
		jsonArrayUserInfor = new JSONArray();
		jsonArrayUserInfor.add(listUserInfor);
		mv.addObject("jsonArraySigninDate", jsonArrayUserInfor);
		mv.addObject("tagPageCode", tagPageCode);
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
	public DataGrid<AttenVacateManageImpl> doSearch(AttenVacateManageImpl attenVacateManage, HttpSession session) throws Exception {
	new PmException(session);
		String typeData = attenVacateManage.getTypeData();
		if (null == typeData) {
			return null;
		}
		String tagSelectColumn = null;
		String tagPageCode = attenVacateManage.getTagPageCode();
		// 加班审批页面
		if("16200300".equals(tagPageCode)){
			attenVacateManage.setTagMapper("searchOverWorkApprove");
			attenVacateManage.setTypeData(null);
			tagSelectColumn = "n";
		}
		// 加班修正
		if("16200400".equals(tagPageCode)){
			attenVacateManage.setTagMapper("searchOverWorkModify");
			attenVacateManage.setTypeData(null);
			tagSelectColumn = "n";
		}
		if("1606000".equals(tagPageCode)){
			attenVacateManage.setTypeData(typeData);
			tagSelectColumn = "n";
		}
		// 部门请假审批
		if ("v".equals(typeData) || "od".equals(typeData) || "op".equals(typeData)) {
			tagSelectColumn = "n";
		}
		DataGrid<AttenVacateManageImpl> list = new DataGrid<AttenVacateManageImpl>();
		// tagPage:页面标记(审批页approve:a,录入页input:i);
		String tagPage  = attenVacateManage.getTagPage();
		if ("i".equals(tagPage)) {
			// 如果是个人的情况
			attenVacateManage.setUserId(getUserId());
		} else if ("a".equals(tagPage)) {
			// 查询是否有部门审批权限
			// 取得当前用户对应的所有审批部门
			// 部门审批	1605004
			boolean approveDep = CommonUtil.checkCode("1605004");
			// 行政审批	1605005
			//boolean approveAdmin = CommonUtil.checkCode("1605005");
			// 高管审批权限,大于等于五天以上的假期
			boolean approveAp3 = CommonUtil.checkCode("1605007");
			//if (approveDep || approveAdmin || approveAp3) {
			if (approveDep) {
				// 取得用户部门审批权限
				PermissionImpl permission = new PermissionImpl();
				permission.setParentCode("1403000");
				permission.setUserId(getUserId());
				List<PermissionImpl> listDivision = permissionService.searchUserDivisionByPermission(permission);
				attenVacateManage.setListDivision(listDivision);
			} 
			// 如果有高管权限,查询五天以上请假记录
			if (approveAp3) {
				attenVacateManage.setSe_duration("5");
			}
			// 不使用tagSelectComunm
		}
		attenVacateManage.setTagSelectColumn(tagSelectColumn);
		list = this.attenVacateManageService.search(attenVacateManage);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenVacateManage
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenVacateManageImpl attenVacateManage, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenVacateManage/editAttenVacateManage");
		String editState = attenVacateManage.getEditState();
		if ("u".equals(editState)) {
			attenVacateManage = attenVacateManageService.get(attenVacateManage);
		}
		attenVacateManage.setEditState(editState);
		// 算出可用年假
		
		mv.addObject("attenVacateManage", attenVacateManage);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenVacateManage
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit")
	@ResponseBody
	public Json doEdit(AttenVacateManageImpl attenVacateManage, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String tagPageCode = attenVacateManage.getTagPageCode();
		String editState = attenVacateManage.getEditState();
		String approveStatus = attenVacateManage.getApproveStatus();
		String typeData = attenVacateManage.getTypeData();
		// 计算年度
		String dateStart = attenVacateManage.getDateStart();
		// 取得年度
		String yearString = "";
		String code = "";
		String codeDetail ="";
		
		// 取得请假类型 数据类型(v:vacate请假，a:attendance考勤) // 部门加班申请	16200100 // 个人加班申请	16200200
		if ((!"a".equals(editState) && !"d".equals(editState)) || "16200100".equals(tagPageCode)) {
			Long idVacate = attenVacateManage.getIdVacate();
			AttenVacateImpl attenVacate = new AttenVacateImpl();
			attenVacate.setId(idVacate);
			attenVacate = attenVacateService.get(attenVacate);
			code = attenVacate.getCode();
			
			Long idVacateDetail = attenVacateManage.getIdVacateDetail();
			AttenVacateImpl attenVacateDetail = new AttenVacateImpl();
			attenVacateDetail.setId(idVacateDetail);
			attenVacateDetail = attenVacateService.get(attenVacateDetail);
			codeDetail = attenVacateDetail.getCode();
		}
		// 部门加班申请	16200100
		// 个人加班申请	16200200
		if(!"a".equals(editState)){
			if("16200100".equals(tagPageCode) || "16200200".equals(tagPageCode) || "16200400".equals(tagPageCode)){
				String userId = attenVacateManage.getUserIdList();
				String attenVacateManageName = "部门加班 ";
				String attenVacateManageTypeData = "od";
				if ("16200200".equals(tagPageCode)) {
					attenVacateManageName = "个人加班";
					attenVacateManageTypeData = "op";
				}
				if ("16200400".equals(tagPageCode)) {
					attenVacateManageName = "加班修正";
					attenVacateManageTypeData = "m";
				}
				String rangeArea = attenVacateManage.getRangeArea();
				String dateWeek = attenVacateManage.getDateWeek();
				if("1".equals(dateWeek)){
					rangeArea = "周日";
				} else if ("7".equals(dateWeek)) {
					rangeArea = "周六";
				} else if ("0".equals(dateWeek) && rangeArea != null && rangeArea.length() > 0) {
					rangeArea = rangeArea.split(" - ")[0];
				}
				if ("i".equals(editState)) {
					CommonUtil.setCommonField(attenVacateManage, session);
					attenVacateManage.setUserName(getUserName());
					attenVacateManage.setUserId(getUserId());
					attenVacateManage.setBadgenumber(CommonUtil.getCardNo());
					attenVacateManage.setApproveStatus("s");
					attenVacateManage.setCardNo(CommonUtil.getCardNo());
					attenVacateManage.setCode(code);
					attenVacateManage.setCodeDetail(codeDetail);
					attenVacateManage.setDateEnd(dateStart);
					attenVacateManage.setName(attenVacateManageName);
					attenVacateManage.setTypeVacateDate("h");
					if("16200400".equals(tagPageCode)){
						attenVacateManage.setTagModifyOverwork("n");
					}
					// o:over work division 部门加班
					attenVacateManage.setTypeData(attenVacateManageTypeData);
					attenVacateManage.setRangeArea(rangeArea);
					// 变更字符串为可查询模式
					/*String userIdList = attenVacateManage.getUserIdList();
				if(null != userIdList){
					String[] arrUser = userIdList.split(",");
					if(null != arrUser && arrUser.length > 0){
						String userIdListModify = "'";
						for (int i = 0; i < arrUser.length; i++) {
							userIdListModify += arrUser[i] + "',";
						}
						userIdListModify = userIdListModify.substring(0, userIdListModify.length() - 1);
						attenVacateManage.setUserIdList(userIdListModify);
					}
				}*/
					attenVacateManageMapper.insert(attenVacateManage);
					// 插入对应的考勤记录
				} else if ("u".equals(editState)) {
					CommonUtil.setCommonField(attenVacateManage, session);
					attenVacateManage.setUserName(getUserName());
					attenVacateManage.setUserId(getUserId());
					attenVacateManage.setApproveStatus("s");
					attenVacateManage.setDateEnd(dateStart);
					attenVacateManage.setName(attenVacateManageName);
					attenVacateManage.setCardNo(CommonUtil.getCardNo());
					attenVacateManage.setCode(code);
					attenVacateManage.setCodeDetail(codeDetail);
					// o:over work division 部门加班
					attenVacateManage.setTypeVacateDate("h");
					attenVacateManage.setTypeData(attenVacateManageTypeData);
					attenVacateManage.setRangeArea(rangeArea);
					attenVacateManageMapper.update(attenVacateManage);
				}
				j.setSuccess(true);
				j.setObj(attenVacateManage);
				return j;
			}
		}

		if (null != dateStart && dateStart.length() >= 4) {
			yearString = dateStart.substring(0, 4);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			yearString = format.format(new Date());
		}
		attenVacateManage.setYear(yearString);
		
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attenVacateManage, session);
				attenVacateManage.setDivisionId(getDivisionId());
				attenVacateManage.setDivisionName(getDivisionName());
				attenVacateManage.setUserName(getUserName());
				attenVacateManage.setUserId(getUserId());
				attenVacateManage.setBadgenumber(CommonUtil.getCardNo());
				attenVacateManage.setApproveStatus("s");
				/*Long idVacate = attenVacateManage.getIdVacate();
				AttenVacateImpl attenVacate = new AttenVacateImpl();
				attenVacate.setId(idVacate);
				attenVacate = attenVacateService.get(attenVacate);
				attenVacateManage.setNameVacate(attenVacate.getName());*/
				attenVacateManage.setCardNo(CommonUtil.getCardNo());
				attenVacateManage.setCode(code);
				attenVacateManage.setCodeDetail(codeDetail);
				attenVacateManage.setName("请假");
				attenVacateManageService.insert(attenVacateManage);
				// 插入对应的考勤记录
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenVacateManage, session);
				attenVacateManage.setDivisionId(getDivisionId());
				attenVacateManage.setDivisionName(getDivisionName());
				attenVacateManage.setUserName(getUserName());
				attenVacateManage.setUserId(getUserId());
				attenVacateManage.setApproveStatus("s");
				attenVacateManage.setName("请假");
				/*Long idVacate = attenVacateManage.getIdVacate();
				AttenVacateImpl attenVacate = new AttenVacateImpl();
				attenVacate.setId(idVacate);
				attenVacate = attenVacateService.get(attenVacate);
				attenVacateManage.setNameVacate(attenVacate.getName());*/
				attenVacateManage.setCardNo(CommonUtil.getCardNo());
				attenVacateManage.setCode(code);
				attenVacateManage.setCodeDetail(codeDetail);
				attenVacateManageService.update(attenVacateManage);
			} else if ("d".equals(editState)) {
				// attenVacateManage.setTag("d");
				attenVacateManage.setYear(null);
				attenVacateManageService.delete(attenVacateManage);
			// 审批或驳回
			} else if ("a".equals(editState)) {
				// 如果是加班审批的情况下
				if("16200300".equals(tagPageCode) || "16200400".equals(tagPageCode)){
					// 一级审批或驳回
					String arrayVacates = attenVacateManage.getArrayVatateId();
					String remarkReject = attenVacateManage.getRemarkReject();
					String[] arrayVacate = arrayVacates.split(",");
					if (null != arrayVacate && arrayVacate.length >0) {
						for (int i = 0; i < arrayVacate.length; i++) {
							String vacateIdString = arrayVacate[i].split("-")[0];
							Long vataceId = Long.valueOf(vacateIdString);
							attenVacateManage = new AttenVacateManageImpl();
							attenVacateManage.setId(vataceId);
							//attenVacateManage.setTypeData(typeData);
							attenVacateManage.setApproveDate(new Date());
							attenVacateManage.setApproveName(getUserName());
							attenVacateManage.setApproveId(getUserId());
							attenVacateManage.setApproveStatus(approveStatus);
							attenVacateManage.setRemarkReject(remarkReject);
							attenVacateManage.setTagCreateOverwork("n");
							if("16200400".equals(tagPageCode)){
								attenVacateManage.setTagModifyOverwork("n");
							}
							if(null != vacateIdString){
								attenVacateManageMapper.update(attenVacateManage);
							}
							//attenVacateManageService.updateWorkOvertime(attenVacateManage);
						}
					}
					j.setSuccess(true);
					j.setObj(attenVacateManage);
					return j;
				}
				// 一级审批或驳回
				String arrayVacates = attenVacateManage.getArrayVatateId();
				String remarkReject = attenVacateManage.getRemarkReject();
				String[] arrayVacate = arrayVacates.split(",");
				List<EmailImpl> listEmail = new ArrayList<>();
				if (null != arrayVacate && arrayVacate.length >0) {
					for (int i = 0; i < arrayVacate.length; i++) {
						String vacateIdString = arrayVacate[i].split("-")[0];
						Long vataceId = Long.valueOf(vacateIdString);
						attenVacateManage = new AttenVacateManageImpl();
						attenVacateManage.setId(vataceId);
						AttenVacateManageImpl attenVacateManageInner = attenVacateManageService.get(attenVacateManage);
						// 计算请假时长(按小时)
						if(null != attenVacateManageInner){
							String typeVacateData = attenVacateManageInner.getTypeVacateDate();
							if(null != typeVacateData && "h".equals(typeVacateData)){
								String hourStart = attenVacateManageInner.getHourStart();
								String hourEnd = attenVacateManageInner.getHourEnd();
								String minuteStart = attenVacateManageInner.getMinuteStart();
								String minuteEnd = attenVacateManageInner.getMinuteEnd();
								SimpleDateFormat hhmmss = new SimpleDateFormat("HH:mm:ss");
								Date dateDayStart = hhmmss.parse(hourStart + ":" + minuteStart + ":00");
								Date dateDayEnd = hhmmss.parse(hourEnd + ":" + minuteEnd + ":00");
								
								Double durationTemp = (double) (dateDayEnd.getTime() - dateDayStart.getTime());
								Double durationAttenVacateHour = durationTemp/(3600000);
								attenVacateManage.setDurationAttenVacateHour(durationAttenVacateHour);
							}
						}
						attenVacateManage.setTypeData(typeData);
						attenVacateManage.setApproveDate(new Date());
						attenVacateManage.setApproveName(getUserName());
						attenVacateManage.setApproveId(getUserId());
						attenVacateManage.setApproveStatus(approveStatus);
						attenVacateManage.setRemarkReject(remarkReject);
						attenVacateManageService.update(attenVacateManage);
						// 二级审批超过五天,发送邮件给高级管理人员
						if ("ap2".equals(approveStatus)) {
							Long idVacateManage = attenVacateManage.getId();
							attenVacateManage = new AttenVacateManageImpl();
							attenVacateManage.setId(idVacateManage);
							AttenVacateManageImpl attenVacateManageTemp = (AttenVacateManageImpl) attenVacateManageService.get(attenVacateManage);
							attenVacateManageTemp.setTypeData(typeData);
							String sender = attenVacateManageTemp.getUserId();
							String senderName = attenVacateManageTemp.getUserName();
							String duration = attenVacateManageTemp.getDuration();
							// 取得发邮件标记，如果发送过，再不发送邮件
							String tagEmail = attenVacateManageTemp.getTagEmail();
							if (null != duration && duration.length() > 0 && null == tagEmail) {
								Double db_duration = Double.valueOf(duration);
								Double db_compare = 5.00;
								if (db_duration >= db_compare) {
									EmailImpl email = new EmailImpl();
									email.setSender(sender);
									email.setSenderName(senderName);
									email.setType("v");
									email.setTypeId(idVacateManage);
									//String tagTest = CommonUtil.getConfig("tagTest");
									// 修正采集方法为绑定服务器物理网卡的形式
									boolean tagSys = CommonUtil.getTagSys();
									if (tagSys) {
										email.setReceiver("LiuXiMing@ManchuTimesFashion.com");
									} else {
										email.setReceiver("neoyin@ManchuTimesFashion.com");
									}
									email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请");
									email.setAttenVacateManage(attenVacateManageTemp);
									email.setEmail("LiuXiMing@ManchuTimesFashion.com");
									listEmail.add(email);
									email = new EmailImpl();
									email.setSender(sender);
									email.setSenderName(senderName);
									email.setType("v");
									email.setTypeId(idVacateManage);
									if (tagSys) {
										email.setReceiver("JoeZhou@ManchuTimesFashion.com");
									} else {
										email.setReceiver("neoyin@ManchuTimesFashion.com");
									}
									email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请/邮件备份");
									email.setAttenVacateManage(attenVacateManageTemp);
									email.setEmail("JoeZhou@ManchuTimesFashion.com");
									listEmail.add(email);
									email = new EmailImpl();
									email.setSender(sender);
									email.setSenderName(senderName);
									email.setType("v");
									email.setTypeId(idVacateManage);
									email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请/邮件备份");
									email.setAttenVacateManage(attenVacateManageTemp);
									email.setReceiver("neoyin@ManchuTimesFashion.com");
									email.setEmail("neoyin@ManchuTimesFashion.com");
									listEmail.add(email);
								}
								// 更新发邮件状态
								AttenVacateManageImpl attenVacateManageForEmail = new AttenVacateManageImpl();
								attenVacateManageForEmail.setId(idVacateManage);
								attenVacateManageForEmail.setTagEmail("s");
								attenVacateManageForEmail.setRemarkReject("");
								attenVacateManageService.updateEmail(attenVacateManageForEmail);
							}
						}
					}
					if (listEmail != null && listEmail.size() > 0) {
						emailService.sendMailAttenVacate(listEmail);
					}
				}
			}
			j.setSuccess(true);
			j.setObj(attenVacateManage);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}
	
	/**
	 * 发送高管邮件
	 * @param attenVacateManage
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doSendMail")
	@ResponseBody
	public Json doSendMail(AttenVacateManageImpl attenVacateManage, HttpSession session) throws Exception {
		new PmException(session);
		boolean success = true;
		Json j = new Json();
		String editState = attenVacateManage.getEditState();
		String approveStatus = attenVacateManage.getApproveStatus();
		String typeData = attenVacateManage.getTypeData();
		// 计算年度
		String dateStart = attenVacateManage.getDateStart();
		// 取得年度
		String yearString = "";
		if (null != dateStart && dateStart.length() >= 4) {
			yearString = dateStart.substring(0, 4);
		} else {
			SimpleDateFormat format = new SimpleDateFormat("yyyy");
			yearString = format.format(new Date());
		}
		attenVacateManage.setYear(yearString);
		
		try {
			String arrayVacates = attenVacateManage.getArrayVatateId();
			String[] arrayVacate = arrayVacates.split(",");
			List<EmailImpl> listEmail = new ArrayList<>();
			
			if (null != arrayVacate && arrayVacate.length >= 1) {
				attenVacateManage = new AttenVacateManageImpl();
				attenVacateManage.setArrayVacate(arrayVacate);
				List<AttenVacateManageImpl> attenVacateManageList = attenVacateManageService.select(attenVacateManage);
				// 验证用户名是否相同,不同的不予以发送
				String userNameBefore = "";
				// 取得高管请假时长
				Double vacateDayMangager = Double.valueOf(CommonUtil.getConfig("vacateDayMangager"));
				Double vacateDaySum = 0.00;
				// 有不同的用户标记,true,有
				// 记录中有发送过邮件的标记 true,已发送
				for (int i = 0; i < attenVacateManageList.size(); i++) {
					AttenVacateManageImpl attenVacateManageTemp = attenVacateManageList.get(i);
					String userNameNow = attenVacateManageTemp.getUserId();
					if (i >= 1 && !userNameNow.equals(userNameBefore)) {
						success  = false;
						j.setSuccess(success);
						j.setObj(attenVacateManage);
						j.setMsg("请选择同一用户记录");
						return j;
					}
					// 如果有不是行政审批的记录(ap2),那么不予以通过
					String approveStatusTemp = attenVacateManageTemp.getApproveStatus();
					if (!"ap2".equals(approveStatusTemp)) {
						success  = false;
						j.setSuccess(success);
						j.setObj(attenVacateManage);
						j.setMsg("列表中有未行政审批的记录");
						return j;
					}
					// 如果有已经发送过邮件的记录,那么做出标记
					String tagEmail = attenVacateManageTemp.getTagEmail();
					// 发邮件标记(s:sent,u:unsent)
					if ("s".equals(tagEmail)) {
						j.setAlert(true);
					}
					userNameBefore = userNameNow;
					vacateDaySum += Double.valueOf(attenVacateManageTemp.getDuration());
				}
				// 如果时长累加不大于等五天,不予以通过
				if (vacateDaySum < vacateDayMangager) {
					success  = false;
					j.setSuccess(success);
					j.setObj(attenVacateManage);
					j.setMsg("请假时长累计小于5天");
					return j;
				}
				attenVacateManage.setDurationTotal(String.valueOf(vacateDaySum));
				EmailImpl email = new EmailImpl();
				if (CommonUtil.getTrueSys()) {
					email.setReceiver("LiuXiMing@ManchuTimesFashion.com");
				} else {
					email.setReceiver("neoyin@ManchuTimesFashion.com");
				}
				email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请");
				email.setListAttenVacateManage(attenVacateManageList);
				email.setEmail("LiuXiMing@ManchuTimesFashion.com");
				listEmail.add(email);
				
				email = new EmailImpl();
				// 取得行政部主管信息
				UserDetailImpl user = new UserDetailImpl();
				/*// gwmc3代表职位为行政部主管
				user.setPositionId("gwmc3");
				user = (UserDetailImpl) userDetailMapper.get(user);*/
				user.setCode("1701001");
				user = (UserDetailImpl) userDetailConditionMapper.selectUserByPermission(user);
				if (CommonUtil.getTrueSys()) {
					email.setReceiver(user.getEmail());
				} else {
					email.setReceiver("neoyin@ManchuTimesFashion.com");
				}
				email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请/邮件备份");
				email.setListAttenVacateManage(attenVacateManageList);
				email.setEmail(user.getEmail());
				listEmail.add(email);
				
				email = new EmailImpl();
				email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请/邮件备份");
				email.setListAttenVacateManage(attenVacateManageList);
				email.setReceiver("neoyin@ManchuTimesFashion.com");
				email.setEmail("neoyin@ManchuTimesFashion.com");
				listEmail.add(email);
				
				email = new EmailImpl();
				if (CommonUtil.getTrueSys()) {
					email.setReceiver(user.getEmail());
				} else {
					email.setReceiver("neoyin@ManchuTimesFashion.com");
				}
				
				listEmail.add(email);
				email.setTheme("系统提醒/员工休假审批/五天或五天以上的休假申请/邮件备份");
				email.setListAttenVacateManage(attenVacateManageList);
				email.setEmail("JoeZhou@ManchuTimesFashion.com");
				
				listEmail.add(email);
				
				// 更新发邮件状态
				for (int i = 0; i < arrayVacate.length; i++) {
					// 更新发邮件状态
					AttenVacateManageImpl attenVacateManageForEmail = new AttenVacateManageImpl();
					attenVacateManageForEmail.setId(Long.valueOf(arrayVacate[i]));
					attenVacateManageForEmail.setTagEmail("s");
					attenVacateManageForEmail.setRemarkReject("");
					attenVacateManageService.updateEmail(attenVacateManageForEmail);
					
				}
				if (listEmail != null && listEmail.size() > 0) {
					emailService.sendMailAttenVacateManager(listEmail, attenVacateManage);
				}
				
			}
			j.setSuccess(success);
			j.setObj(attenVacateManage);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

}

