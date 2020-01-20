package com.mtf.questionnaire.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.QuestionImpl;
import com.mtf.framework.model.impl.QuestionnaireImpl;
import com.mtf.framework.service.QuestionnaireService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.Constants;

@Controller("controllerQuestionnaire")
@RequestMapping("office/quest")
public class ControllerQuestionnaire {

	@Autowired
	private QuestionnaireService	questionnaireService;

	@Autowired
	public QuestionnaireService getQuestionnaireService() {
		return questionnaireService;
	}

	@Autowired
	public void setQuestionnaireService(QuestionnaireService questionnaireService) {
		this.questionnaireService = questionnaireService;
	}

	/**
	 * 跳转到编辑页面或者预览页面
	 * 
	 * @param questionnaire
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(QuestionnaireImpl questionnaire, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("question/editQuestion");
		String editState = questionnaire.getEditState();
		// 添加状态
		if ("i".equals(editState)) {
			mv.addObject("questionnaire", questionnaire);
		}
		// 修改状态
		else if ("u".equals(editState)) {
			questionnaire = questionnaireService.getQuestionAndSelecter(questionnaire);
			questionnaire.setEditState(editState);
			List<QuestionImpl> questionList = questionnaire.getListQuestion();
			mv.addObject("questionnaire", questionnaire);
			mv.addObject("questionList", questionList);
		}
		return mv;
	}

	/**
	 * 编辑
	 * 
	 * @param questionnaire
	 * @param session
	 * @return
	 * @throws PmException
	 */

	@RequestMapping("/doEdit")
	@ResponseBody
	public Json doEdit(QuestionnaireImpl questionnaire, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Json json = new Json();
		// 问卷状态
		String editState = questionnaire.getEditState();
		// 问卷类型
		String questType = questionnaire.getType();
		// 问卷中问题的个数
		if (null == questionnaire.getListQuestion()) {
			json.setSuccess(false);
			json.setMsg("必须添加问题才能保存");
			return json;
		}
		// 判断问卷中是否有默认问卷，如果有默认问卷，就禁止添加
		if ("d".equals(questType)) {
			QuestionnaireImpl quest = new QuestionnaireImpl();
			quest.setType(questType);
			quest = questionnaireService.get(quest);
			if (null != quest) {
				// 如果为修改状态
				if ("u".equals(editState)) {
					Long questId = questionnaire.getId();
					// 如果修改的不是当前默认问卷
					if (questId.compareTo(quest.getId()) > 0) {
						json.setSuccess(false);
						json.setMsg("问卷中已经有默认问卷，请选择其他问卷");
						return json;
					}

				} else {
					json.setSuccess(false);
					json.setMsg("问卷中已经有默认问卷，请选择其他问卷");
					return json;
				}

			}

		}
		// 添加问卷
		if ("i".equals(editState)) {
			CommonUtil.setCommonField(questionnaire, session);
			questionnaireService.insert(questionnaire);
			json.setSuccess(true);
			json.setMsg("创建问卷成功");
			// 修改问卷
		} else if ("u".equals(editState)) {
			questionnaire.setModifyUser(sessionInfo.getUserId());
			questionnaire.setModifyIp(sessionInfo.getIp());
			questionnaire.setModifyDate(new Date());
			questionnaireService.update(questionnaire);
			json.setSuccess(true);
			json.setMsg("修改成功");

		}
		return json;
	}

	/**
	 * 跳转到搜索页面
	 * 
	 * @param questionnaire
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(QuestionnaireImpl questionnaire) throws PmException {
		ModelAndView mv = new ModelAndView("question/searchQuest");
		mv.addObject("questionnaire", questionnaire);
		return mv;
	}

	/**
	 * 搜索查询
	 * 
	 * @param questionnaire
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doSearch")
	@ResponseBody
	public DataGrid<QuestionnaireImpl> doSearch(QuestionnaireImpl questionnaire, HttpSession session) throws PmException {
		DataGrid<QuestionnaireImpl> list = questionnaireService.select(questionnaire);
		return list;

	}

	/**
	 * 返回问卷链接
	 * 
	 * @return
	 */
	@RequestMapping("/getLink")
	@ResponseBody
	public Json getLink(@RequestParam("questId") String questId) {
		Json json = new Json();
		try {
			// 对问卷的ID进行加密
			String enString = CommonUtil.encodeStr(questId);
			String link = "/indexQuest.do?quesId=" + enString;
			json.setSuccess(true);
			json.setMsg(link);
		}
		catch (Exception e) {
			json.setSuccess(false);
			json.setMsg("显示失败");
		}
		return json;
	}

	/**
	 * 预览问卷
	 * 
	 * @param questionnaireImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/preview")
	public ModelAndView preview(QuestionnaireImpl questionnaireImpl, HttpSession session) throws PmException {
		ModelAndView mv = new ModelAndView("question/questionnaire");
		String editState = questionnaireImpl.getEditState();
		questionnaireImpl = questionnaireService.getQuestionAndSelecter(questionnaireImpl);
		questionnaireImpl.setEditState(editState);
		List<QuestionImpl> questionList = questionnaireImpl.getListQuestion();
		mv.addObject("questionnaire", questionnaireImpl);
		mv.addObject("questionList", questionList);
		return mv;
	}
}
