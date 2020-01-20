package com.mtf.framework.service.impl;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.script.function.DECIMAL;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.UserQuestionImpl;
import com.mtf.framework.model.impl.UserQuestionnaireImpl;
import com.mtf.framework.model.impl.UserSelecterImpl;
import com.mtf.framework.dao.UserQuestionMapper;
import com.mtf.framework.dao.UserQuestionnaireMapper;
import com.mtf.framework.dao.UserSelecterMapper;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.UserQuestionnaireService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 人员问卷关联表
 * 作者:     Auto
 * 日期:     2014-03-03
**********************************************
*/
@Service("userQuestionnaireService")
public class UserQuestionnaireServiceImpl extends CommonServiceImpl implements UserQuestionnaireService {
	@Autowired
	private UserQuestionnaireMapper userQuestionnaireMapper;
	
	@Autowired
	private UserQuestionMapper userQuestionMapper;
	
	@Autowired
	private UserSelecterMapper userSelecterMapper;

	@Autowired
	public UserQuestionnaireMapper getUserQuestionnaireMapper() {
		return userQuestionnaireMapper;
	}

	@Autowired
	public void setUserQuestionnaireMapper(UserQuestionnaireMapper userQuestionnaireMapper) {
		this.userQuestionnaireMapper = userQuestionnaireMapper;
	}

	@Autowired
	public UserSelecterMapper getUserSelecterMapper() {
		return userSelecterMapper;
	}

	@Autowired
	public void setUserSelecterMapper(UserSelecterMapper userSelecterMapper) {
		this.userSelecterMapper = userSelecterMapper;
	}
	

	@Autowired
	public UserQuestionMapper getUserQuestionMapper() {
		return userQuestionMapper;
	}

	@Autowired
	public void setUserQuestionMapper(UserQuestionMapper userQuestionMapper) {
		this.userQuestionMapper = userQuestionMapper;
	}

	/**
	 * 新增实体对象
	 * @param userQuestionnaire
	 */
	@SuppressWarnings("unchecked")
	public UserQuestionnaireImpl insert(UserQuestionnaireImpl userQuestionnaireImpl,HttpSession session) throws PmException {
		this.userQuestionnaireMapper.insert(userQuestionnaireImpl);
		Map<Long, Long> answerMap = (Map<Long, Long>) session.getAttribute("answerMap");
		//获取分数
		String score = insertListQuestion(userQuestionnaireImpl ,answerMap);
		userQuestionnaireImpl.setScore(score);
		//将分数更新到问卷中
		userQuestionnaireMapper.update(userQuestionnaireImpl);
		return userQuestionnaireImpl;
	}

	/**
	 * 删除实体对象
	 * @param userQuestionnaire
	 */
	public int delete(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException {
		return this.userQuestionnaireMapper.delete(userQuestionnaireImpl);
	}

	/**
	 * 更新实体对象
	 * @param userQuestionnaire
	 */
	public boolean update(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException {
		boolean result = true;
		this.userQuestionnaireMapper.update(userQuestionnaireImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param userQuestionnaire
	 */
	public UserQuestionnaireImpl get(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException {
		return (UserQuestionnaireImpl) this.userQuestionnaireMapper.get(userQuestionnaireImpl);
	}
	/**
	 * 查询实体列表
	 * @param userQuestionnaire
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<UserQuestionnaireImpl> select(UserQuestionnaireImpl userQuestionnaireImpl) throws PmException {
		DataGrid<UserQuestionnaireImpl> grid = new DataGrid<UserQuestionnaireImpl>();
		Object obj = userQuestionnaireImpl;
		List list = userQuestionnaireMapper.select(obj);
		grid.setRows(list);
		int count;
		count = userQuestionnaireMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	// 添加问卷的问题list
	public String insertListQuestion(UserQuestionnaireImpl userQuestionnaireImpl, Map<Long, Long> answerMap) {
		String userId = userQuestionnaireImpl.getUserId();
		// 分数
		float score = 0;
		// 计答对题数
		float count = 0;

		Long quesId = userQuestionnaireImpl.getQuesId();
		// 取得问题的list
		List<UserQuestionImpl> listQuestion = userQuestionnaireImpl.getUserQuestionList();
		if (listQuestion != null && listQuestion.size() > 0) {
			for (int i = 0; i < listQuestion.size(); i++) {
				UserQuestionImpl userQuestion = listQuestion.get(i);
				Long questionId = userQuestion.getQuestionId();
				UserSelecterImpl userSelecter = userQuestion.getUserSelecter();
				// 判断当前题目是否有选项
				if (null != userSelecter) {
				Long selecerId = userSelecter.getSelecterId();
				if (!(null == questionId) && !(null == selecerId)) {
					// 根据当前问题ID，在答案map中查询对应的选项ID
					Long sid = answerMap.get(questionId);
					//如果答案的选项ID和前台穿来的选项ID相等计数加1
					if (sid.equals(selecerId)) {
						userQuestion.setResult("y");
						userSelecter.setResult("y");
						count++;
					} else {
						userQuestion.setResult("n");
						userSelecter.setResult("n");
					}
				}
				}else {
					userSelecter = new UserSelecterImpl();
					userQuestion.setResult("n");
					userSelecter.setResult("n");
				}
				// 加入问卷id
				userQuestion.setQuesId(quesId);
				userQuestion.setUserId(userId);
				// 插入到user问题表中
				userQuestionMapper.insert(userQuestion);

				// 加入问卷id
				userSelecter.setQuesId(quesId);
				
				// 加入问题id
				userSelecter.setQuestionId(questionId);
				// 插入到user选项表中
				userSelecter.setUserId(userId);
				userSelecterMapper.insert(userSelecter);
			}
			// 计算得分
			float questionCount = listQuestion.size();
			score = count / questionCount * 100;

		}
		return new DecimalFormat("#.0").format(score);
	}
	

}