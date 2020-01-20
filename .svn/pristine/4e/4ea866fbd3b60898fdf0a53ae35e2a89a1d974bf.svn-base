package com.mtf.questionnaire.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.QuestionImpl;
import com.mtf.framework.model.impl.QuestionnaireImpl;
import com.mtf.framework.model.impl.SelecterImpl;
import com.mtf.framework.model.impl.UserQuestionnaireImpl;
import com.mtf.framework.service.QuestionnaireService;
import com.mtf.framework.service.SelecterService;
import com.mtf.framework.service.UserQuestionnaireService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;


@Controller("controllerUserQuestionnaire")
@RequestMapping("office/userQuset")
public class ControllerUserQuestionnaire {
	
	@Autowired
	private UserQuestionnaireService userQuestionnaireService;
	
	@Autowired
	private QuestionnaireService questionnaireService;
	
	@Autowired
	private SelecterService selecterService;


	@Autowired
	public UserQuestionnaireService getUserQuestionnaireService() {
		return userQuestionnaireService;
	}

	@Autowired
	public void setUserQuestionnaireService(UserQuestionnaireService userQuestionnaireService) {
		this.userQuestionnaireService = userQuestionnaireService;
	}

	@Autowired
	public QuestionnaireService getQuestionnaireService() {
		return questionnaireService;
	}

	@Autowired
	public void setQuestionnaireService(QuestionnaireService questionnaireService) {
		this.questionnaireService = questionnaireService;
	}
	
	@Autowired
	public SelecterService getSelecterService() {
		return selecterService;
	}

	@Autowired
	public void setSelecterService(SelecterService selecterService) {
		this.selecterService = selecterService;
	}

	/**
	 * 提交问卷信息
	 * @param userQuestionnaireImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doEdit")
	@ResponseBody
	public Json doEdit(UserQuestionnaireImpl userQuestionnaireImpl, HttpSession session) throws PmException{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json json = new Json();
		if ("".equals(userQuestionnaireImpl.getQuesId())|| null == userQuestionnaireImpl.getQuesId()) {
			json.setMsg("问卷为空");
			json.setSuccess(false);
			return json;
			
		}
		try {
			CommonUtil.setCommonField(userQuestionnaireImpl, session);
			userQuestionnaireImpl.setUserId(sessionInfo.getUserId());
			userQuestionnaireService.insert(userQuestionnaireImpl,session);
			json.setSuccess(true);
			json.setMsg("提交成功");
		}
		catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("提交失败");
			e.printStackTrace();
		}
	
		return json;
	}
	
	/**
	 * 显示问卷
	 * @param userQuestionnaireImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(UserQuestionnaireImpl userQuestionnaireImpl,HttpSession session)throws PmException{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		ModelAndView mv = new ModelAndView();
		String editState = userQuestionnaireImpl.getEditState();
		QuestionnaireImpl questionnaire = new QuestionnaireImpl();
		// 获取从登陆界面传过来的加密问卷ID
		String field1 = userQuestionnaireImpl.getField1();
		// 如果没有传参数
		if(null == field1){
			// 表示为新员工，查询默认的问卷
			questionnaire.setType("d");
		}else {
			// 如果传问卷ID，解密问卷ID
			String enId = CommonUtil.decodeStr(field1);
			Long questId = Long.parseLong(enId);
			questionnaire.setId(questId);
			// 将问卷的ID放入userQuestionnaireImol对象中
			userQuestionnaireImpl.setQuesId(questId);
		}	
		// 将员工ID放入userQuestionnaireImol对象中
		userQuestionnaireImpl.setUserId(sessionInfo.getUserId());
		// 查询当前员工是否做过当前问卷
		userQuestionnaireImpl = userQuestionnaireService.get(userQuestionnaireImpl);
		if (null == userQuestionnaireImpl) {
			// 如果返回结果为空，代表没有做过当前问卷，跳转到当前问卷中
			mv.setViewName("question/questionnaire");
		}else {
			//如果结果不为空，代表做过当前问卷，跳转到主页面
			mv.setViewName("question/questionnaireResult");
		}

		// 查询问卷，返回到页面
		questionnaire = questionnaireService.getQuestionAndSelecter(questionnaire);
		SelecterImpl selecterImpl = new SelecterImpl();
		selecterImpl.setQuesId(questionnaire.getId());
		// 查询问卷的答案，放入到session中
		List<Map<Long, Long>> answerList = selecterService.selectAnswer(selecterImpl);
		Map<Long, Long>answerMap = listTOMap(answerList);
		session.setAttribute("answerMap", answerMap);
		
		questionnaire.setEditState(editState);
		List<QuestionImpl> questionList = questionnaire.getListQuestion();
		mv.addObject("questionnaire", questionnaire);
		mv.addObject("questionList", questionList);	
		return mv;
	}
	
	
/**
 * 将List转化map
 * @param listMap
 * @return
 */
	public Map<Long, Long> listTOMap(List<Map<Long, Long>> listMap){
		Map<Long, Long> msp = new HashMap<Long, Long>();
		if (listMap.size() > 0) {
			for (int i = 0; i < listMap.size(); i++) {
				Map<Long, Long> map = listMap.get(i);
				Long id = map.get("id");
				Long questionId = map.get("questionId");
				msp.put(questionId, id);
			}
		}
		return msp;
	}
	

	

}
