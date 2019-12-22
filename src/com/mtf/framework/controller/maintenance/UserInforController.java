package com.mtf.framework.controller.maintenance;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.controller.BaseController;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.UserInfor;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.UserInforImpl;
import com.mtf.framework.service.UserInforService;
import com.mtf.framework.util.CommonUtil;


@Controller("userInfoController")
@RequestMapping("/maintenance/userInfo")
public class UserInforController extends BaseController{
	
	private static final Logger		logger	= Logger.getLogger(UserInforController.class);
	
	@Autowired
	private UserInforService userinforService;

	@Autowired
	public UserInforService getUserinforService() {
		return userinforService;
	}

	@Autowired
	public void setUserinforService(UserInforService userinforService) {
		this.userinforService = userinforService;
	}
	
	/**
	 * 跳转查询
	 * @param userinfor
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch(UserInfor userinfor,HttpSession session)throws PmException{
	ModelAndView mv = new ModelAndView("maintenance/userInfor/userInfo");
	return mv;
	}
	
	/**
	 * 编辑
	 * @param userinfor
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doEdit")
	@ResponseBody
	public Json doEdit(UserInforImpl userInforImpl,HttpSession session)throws Exception{
		Json json = new Json();
		String editState = userInforImpl.getEditState();
		String type = userInforImpl.getType();
		String flag = userInforImpl.getFlag();
		// 系统类型(系统,s,模块,m)
		//String typeSystem = userInforImpl.getTypeSystem();
		// 如果是系统权限,那么检查全表内为系统权限的下接选项是否有重复
//		if("s".equals(typeSystem)){
//			
//		}
//		// 如果是模块权限,那么检查本模块下是否有重复选项
//		else if ("m".equals(typeSystem)) {
//			
//		}
		// 添加
		if ("i".equals(editState)) {
			// 创建新的对象查询
			/*if ("s".equals(flag)) {
				UserInforImpl userInfor = new UserInforImpl();
				userInfor.setType(type);
				userInfor.setFlag(flag);
				userInfor = userinforService.get(userInfor);
				if (null != userInfor) {
					json.setMsg("当前类型值已经存在,请重新填写");
					json.setSuccess(false);
					return json;
				}
			}*/
			/*boolean judgeExist = this.checkCodeUnique(userInforImpl);
			if (!judgeExist) {
				json.setMsg("当前类型值已经存在,请重新填写");
				json.setSuccess(false);
				return json;
			}*/
			
			userInforImpl.setAddUser(getUserId());
			userInforImpl.setAddDate(new Date());
			userInforImpl.setModifiedUser(getUserId());
			userInforImpl.setModifiedDate(new Date());
			userInforImpl.setAddIp(getIp());
			userInforImpl.setModifiedIp(getIp());
			if ("s".equals(flag)) {
				userInforImpl.setCode(type);
			}
			try {
				userinforService.insert(userInforImpl);
			} catch (Exception e) {
				json.setMsg("当前类型值已经存在,请重新填写");
				json.setSuccess(false);
				return json;
			}
			json.setSuccess(true);
		// 修改
		}else if ("u".equals(editState)) {
			/*boolean judgeExist = this.checkCodeUnique(userInforImpl);
			if (!judgeExist) {
				json.setMsg("当前类型值已经存在,请重新填写");
				json.setSuccess(false);
				return json;
			}*/
			userInforImpl.setModifiedDate(new Date());
			try {
				userinforService.update(userInforImpl);
			} catch (Exception e) {
				json.setMsg("当前类型值已经存在,请重新填写");
				json.setSuccess(false);
				return json;
			}
			json.setSuccess(true);
			
		// 删除
		}else if ("d".equals(editState)) {
			userinforService.delete(userInforImpl);
			json.setSuccess(true);
			json.setMsg("删除成功");
		}{
			
		}
		return json;
		
	}
	
	/**
	 * 查询
	 * @param userInforImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	@RequestMapping("/doSearch")
	@ResponseBody
	public DataGrid<UserInforImpl> doSearch(UserInforImpl userInforImpl,HttpSession session)throws PmException{
		DataGrid<UserInforImpl> list = userinforService.select(userInforImpl);
		return list;
	}
	
	/**
	 * 检查下拉框编码唯一性
	 * @param userInfor
	 */
	private boolean checkCodeUnique(UserInforImpl userInfor) throws Exception{
		boolean result = true;
		String editState = userInfor.getEditState();
		String type = userInfor.getType();
		String flag = userInfor.getFlag();
		String code = userInfor.getCode();
		Long idUserInfor = userInfor.getId();
		// 系统类型(系统,s,模块,m)
		String typeSystem = userInfor.getTypeSystem();
		// 如果是系统权限,那么检查全表内为系统权限的下接选项是否有重复
		// 标记s:选项，i为内容
		// 主类型
		if("s".equals(typeSystem)){
			UserInforImpl userInforTemp = new UserInforImpl();
			userInforTemp.setType(type);
			// 标记s:选项，i为内容
			userInforTemp.setFlag(flag);
			userInforTemp = userinforService.get(userInforTemp);
			String typeSystemTemp = userInforTemp.getTypeSystem();
			// 如果之前的记录为模块类型,后变更为系统类型需要对明细做唯一验证
			if ("m".equals(typeSystemTemp)) {
				UserInforImpl userInforTemp2 = new UserInforImpl();
				List<UserInforImpl> listUserInforTemp = userinforService.search(userInforTemp2);
			}
			if (null != userInforTemp) {
				result = false;
			}
		}
		// 如果是模块权限,那么检查本模块下是否有重复选项
		else if ("m".equals(typeSystem)) {
			UserInforImpl userInforTemp = new UserInforImpl();
			userInforTemp.setCode(code);
			userInforTemp.setType(type);
			userInforTemp.setFlag(flag);
			userInforTemp.setTypeSystem(typeSystem);
			userInforTemp = userinforService.get(userInforTemp);
			Integer countUserinfor = userinforService.count(userInforTemp);
			if ("i".equals(editState)) {
				result = false;
				
			}
			else if ("u".equals(editState)) {
				Long idUserInforTemp = userInforTemp.getId();
				if (null != idUserInforTemp && !idUserInforTemp.equals(idUserInfor)) {
					result = false;
				}
			}
			if (null != userInforTemp) {
				result = false;
			}
			
		}
		// 明细选项
		else if ("i".equals(flag)) {
			
		}
		return result;
	}

}
