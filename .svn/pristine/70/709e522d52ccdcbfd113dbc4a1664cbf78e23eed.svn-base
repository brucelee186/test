package com.mtf.framework.controller.attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.dao.AttMonitorLogDao;
import com.mtf.framework.dao.AttenRuleConditionMapper;
import com.mtf.framework.dao.AttenRuleMapper;
import com.mtf.framework.dao.AttendanceMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.AttMonitorLogImpl;
import com.mtf.framework.model.impl.AttenDayImpl;
import com.mtf.framework.model.impl.AttenRuleImpl;
import com.mtf.framework.model.impl.AttendanceImpl;
import com.mtf.framework.service.AttenDayService;
import com.mtf.framework.service.AttenRuleService;
import com.mtf.framework.util.CommonUtil;

import net.sf.json.JSONArray;

/*
**********************************************
 * 项目名称: 人力资源管理系统
 * 模块名称: 控制层 -> 考勤规则
 * 作者:    Auto
 * 日期:    2015/4/24
**********************************************
*/
@Controller("attenRuleController")
@RequestMapping("/attendance/attenRule")
public class AttenRuleController {

	@Autowired
	private AttenRuleService attenRuleService;
	
	@Autowired
	private AttenDayService attenDayService;
	
	@Autowired
	private AttenRuleMapper attenRuleMapper;
	
	@Autowired
	private AttenRuleConditionMapper attenRuleConditionMapper;
	
	@Autowired
	public AttenRuleConditionMapper getAttenRuleConditionMapper() {
		return attenRuleConditionMapper;
	}

	@Autowired
	public void setAttenRuleConditionMapper(
			AttenRuleConditionMapper attenRuleConditionMapper) {
		this.attenRuleConditionMapper = attenRuleConditionMapper;
	}

	@Autowired
	public AttenRuleMapper getAttenRuleMapper() {
		return attenRuleMapper;
	}

	@Autowired
	public void setAttenRuleMapper(AttenRuleMapper attenRuleMapper) {
		this.attenRuleMapper = attenRuleMapper;
	}

	@Autowired
	public AttenDayService getAttenDayService() {
		return attenDayService;
	}

	@Autowired
	public void setAttenDayService(AttenDayService attenDayService) {
		this.attenDayService = attenDayService;
	}

	@Autowired
	public AttenRuleService getAttenRuleService() {
		return attenRuleService;
	}

	@Autowired
	public void setAttenRuleService(AttenRuleService attenRuleService) {
		this.attenRuleService = attenRuleService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() throws Exception{
		ModelAndView mv = new ModelAndView("/attendance/attenRule/searchAttenRule");
		// 加载时间段json
		JSONArray jsonArray = new JSONArray();
		List<AttenDayImpl> listAttenDay = attenDayService.select(new AttenDayImpl());
		jsonArray.add(listAttenDay);
		mv.addObject("jsonListAttenDay", jsonArray.toString());
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
	public DataGrid<AttenRuleImpl> doSearch(AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttenRuleImpl> list = new DataGrid<AttenRuleImpl>();
		list = this.attenRuleService.search(attenRule);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attenRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("/attendance/attenRule/editAttenRule");
		String editState = attenRule.getEditState();
		if ("u".equals(editState)) {
		attenRule = attenRuleService.get(attenRule);
		}
		attenRule.setEditState(editState);
		mv.addObject("attenRule", attenRule);
		return mv;
	}

	/**
	 * 编辑
	 * @param attenRule
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attenRule.getEditState();
		// 设置为普通状态
		attenRule.setTag("n");
		try {
			if ("i".equals(editState)) {
				attenRuleService.insert(attenRule);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attenRule, session);
				attenRuleService.update(attenRule);
			} else if ("d".equals(editState)) {
				// 删除时只是变更为禁用状态 
				//attenRule.setTag("d");
				attenRule.setTag(null);
				attenRuleService.delete(attenRule);
			}
			j.setSuccess(true);
			j.setObj(attenRule);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	@RequestMapping(value = "/doAttenCollectFromDataSource2", method = RequestMethod.POST)
	@ResponseBody
	public Json doAttenCollectFromDataSource2 (AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String collectDate = attenRule.getCollectDate();
		AttMonitorLogDao attMonitorLogDao = (AttMonitorLogDao) CommonUtil.ac.getBean("attMonitorLogDao");
		AttendanceMapper attendanceMapper = (AttendanceMapper) CommonUtil.ac.getBean("attendanceMapper");
		AttMonitorLogImpl attMonitorLog = new AttMonitorLogImpl();
		// 如果为空取当前日
		if (null == collectDate) {
			collectDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		}
		attMonitorLog.setCollectDate(collectDate);
		List<Map<String, Object>> listMonitor = attMonitorLogDao.search(attMonitorLog);
		if (null != listMonitor && listMonitor.size() >0) {
			for (int i = 0; i < listMonitor.size(); i++) {
				AttendanceImpl attendance = new AttendanceImpl();
				Map<String, Object> mapAttendance = listMonitor.get(i);
				Date date2 = new Date();
				try {
					String date =  String.valueOf(mapAttendance.get("date"));
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String badgenumber = (String)mapAttendance.get("badgenumber");
				
				attendance.setUserName((String)mapAttendance.get("userName"));
				attendance.setCardNo(badgenumber);
				attendance.setDay(String.valueOf(mapAttendance.get("day")));
				attendance.setTimeStart((Date)mapAttendance.get("timeStart"));
				attendance.setTimeEnd((Date)mapAttendance.get("timeEnd"));
				attendance.setDateMonth(String.valueOf(mapAttendance.get("dateMonth")));
				attendance.setDateWeek(String.valueOf(mapAttendance.get("dateWeek")));
				//attendance.setDate(date2);
				attendance.setDayStart(String.valueOf(mapAttendance.get("dayStart")));
				attendance.setDayEnd(String.valueOf(mapAttendance.get("dayEnd")));
				attendance.setTimeWork(String.valueOf(mapAttendance.get("timeWork")));
				attendance.setLate((String)mapAttendance.get("late"));
				attendance.setLeaveEarly((String)mapAttendance.get("leaveEarly"));
				attendance.setStatusAttendance((String)mapAttendance.get("statusAttendance"));
				attendance.setFestivelName((String)mapAttendance.get("festivelName"));
				attendance.setLoopYear((String)mapAttendance.get("loopYear"));
				attendance.setTypeDate((String)mapAttendance.get("typeDate"));
				Date dateNow = new Date();
				attendance.setAddDate(dateNow);
				attendance.setModifiedDate(dateNow);
				try {
					// 查询本条信息是否存在,如果不存在,插入,存在更新
					AttendanceImpl attendanceTemp = new AttendanceImpl();
					//attendanceTemp.setDate(date2);
					attendanceTemp.setCardNo(badgenumber);
					attendanceTemp = (AttendanceImpl) attendanceMapper.get(attendanceTemp);
					if (null == attendanceTemp) {
							attendanceMapper.insert(attendance);
					} 
					else {
						attendance.setAddDate(null);
						attendance.setAddIp(null);
						attendance.setAddUser(null);
						attendance.setStatusAttendance(null);
						attendanceMapper.update(attendance);
					}
					j.setSuccess(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return j;
	}
	
	@RequestMapping(value = "/doAttenCollect1", method = RequestMethod.POST)
	@ResponseBody
	public Json doAttenCollect1 (AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String collectDate = attenRule.getCollectDate();
		AttMonitorLogDao attMonitorLogDao = (AttMonitorLogDao) CommonUtil.ac.getBean("attMonitorLogDao");
		AttendanceMapper attendanceMapper = (AttendanceMapper) CommonUtil.ac.getBean("attendanceMapper");
		AttMonitorLogImpl attMonitorLog = new AttMonitorLogImpl();
		if (null == collectDate || "".equals(collectDate)) {
			// 如果为空取当前日期的前一天
			Calendar ca = Calendar.getInstance();
			ca.setTime(new Date());
			ca.add(Calendar.DAY_OF_MONTH, -1);
			collectDate = new SimpleDateFormat("yyyy-MM-dd").format(ca.getTime());
		}
		attMonitorLog.setCollectDate(collectDate);
		List<Map<String, Object>> listMonitor = attMonitorLogDao.search(attMonitorLog);
		if (null != listMonitor && listMonitor.size() >0) {
			for (int i = 0; i < listMonitor.size(); i++) {
				AttendanceImpl attendance = new AttendanceImpl();
				Map<String, Object> mapAttendance = listMonitor.get(i);
				Date date2 = new Date();
				try {
					String date =  String.valueOf(mapAttendance.get("date"));
					date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				
				String typeDate = (String)mapAttendance.get("typeDate");
				String badgenumber = (String)mapAttendance.get("badgenumber");
				String statusAttendance = (String)mapAttendance.get("statusAttendance");
				attendance.setUserName((String)mapAttendance.get("userName"));
				attendance.setCardNo(badgenumber);
				attendance.setDay(String.valueOf(mapAttendance.get("day")));
				attendance.setTimeStart((Date)mapAttendance.get("timeStart"));
				attendance.setTimeEnd((Date)mapAttendance.get("timeEnd"));
				attendance.setDateMonth(String.valueOf(mapAttendance.get("dateMonth")));
				attendance.setDateWeek(String.valueOf(mapAttendance.get("dateWeek")));
				//attendance.setDate(date2);
				attendance.setDayStart(String.valueOf(mapAttendance.get("dayStart")));
				attendance.setDayEnd(String.valueOf(mapAttendance.get("dayEnd")));
				attendance.setTimeWork(String.valueOf(mapAttendance.get("timeWork")));
				attendance.setLate((String)mapAttendance.get("late"));
				attendance.setLeaveEarly((String)mapAttendance.get("leaveEarly"));
				attendance.setFestivelName((String)mapAttendance.get("festivelName"));
				attendance.setLoopYear((String)mapAttendance.get("loopYear"));
				// 取得当前
				// 如果节假日管理中的日期类型(f:假日,w:周末变更为上班日期)为工作日w,那么按考勤日计算，如果节假日管理中的日期类型为f,那么按节假日计算
				if (null == typeDate || "".equals(typeDate) || "w".equals(typeDate)) {
					typeDate = "w";
				}
				
				// 如果状态为节假日，那么采集数据状态为no
				if (null != typeDate && "f".equals(typeDate)) {
					statusAttendance = "no";
				}
				
				attendance.setStatusAttendance(statusAttendance);
				attendance.setTypeDate(typeDate);
				
				Date dateNow = new Date();
				attendance.setAddDate(dateNow);
				attendance.setModifiedDate(dateNow);
				try {
					// 查询本条信息是否存在,如果不存在,插入,存在更新
					AttendanceImpl attendanceTemp = new AttendanceImpl();
					//attendanceTemp.setDate(date2);
					attendanceTemp.setCardNo(badgenumber);
					attendanceTemp = (AttendanceImpl) attendanceMapper.get(attendanceTemp);
					if (null == attendanceTemp) {
							attendanceMapper.insert(attendance);
					} 
					else {
						attendance.setAddDate(null);
						attendance.setAddIp(null);
						attendance.setAddUser(null);
//						if (null == typeDate || "w".equals(typeDate)) {
//							statusAttendance = null;
//						}
//						attendance.setStatusAttendance(statusAttendance);
						Long id = attendanceTemp.getId();
						attendance.setId(id);
						attendanceMapper.update(attendance);
					}
					j.setSuccess(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		}
		return j;
	}
	
	
	@RequestMapping(value = "/doAttenCollect", method = RequestMethod.POST)
	@ResponseBody
	public Json doAttenCollect (AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		j.setSuccess(true);
		try {
			// 如果为真实系统再采集
			// tagAttenCollect 测试系统是否可以采集考勤(可以采集y,不可以n) 测试用
			if (CommonUtil.getTrueSys() || "y".equals(CommonUtil.getConfig("tagAttenCollect"))){
			//if (CommonUtil.getTrueSys()){
				attenRuleService.doMonitorCollection(attenRule);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
	
	@RequestMapping(value = "/doGetWorkHourRange", method = RequestMethod.POST)
	@ResponseBody
	public Json doGetWorkHourRange (AttenRuleImpl attenRule, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		j.setSuccess(true);
		try {
			attenRule = (AttenRuleImpl) attenRuleConditionMapper.doGetWorkHourRange(attenRule);
			if(null != attenRule){
				j.setObj(attenRule);
			}
		} catch (Exception e) {
			e.printStackTrace();
			j.setSuccess(false);
		}
		return j;
	}
}