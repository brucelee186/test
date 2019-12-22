package com.mtf.framework.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.mtf.framework.editor.DateEditor;
import com.mtf.framework.editor.DoubleEditor;
import com.mtf.framework.editor.IntegerEditor;
import com.mtf.framework.editor.LongEditor;
import com.mtf.framework.editor.StringEditor;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.OrderServiceRecordService;
import com.mtf.framework.service.UserService;


public abstract class BaseController {
	
	// 请求线程
	private static ThreadLocal<HttpServletRequest>	request_threadLocal	= new ThreadLocal<HttpServletRequest>();

	// 响应线程
	private static ThreadLocal<HttpServletResponse>	reponse_threadLocal	= new ThreadLocal<HttpServletResponse>();
	
	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setRequest(HttpServletRequest request) {
		request_threadLocal.set(request);
	}

	public HttpServletRequest getRequest() {
		return request_threadLocal.get();
	}

	public void removeRequest() {
		request_threadLocal.remove();
	}

	public void setResponse(HttpServletResponse response) {
		reponse_threadLocal.set(response);
	}

	public HttpServletResponse getResponse() {
		return reponse_threadLocal.get();
	}

	public void removeResponse() {
		reponse_threadLocal.remove();
	}
	
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor(true));
		binder.registerCustomEditor(Integer.class, new IntegerEditor(true));
		binder.registerCustomEditor(Long.class, new LongEditor(true));
		binder.registerCustomEditor(Double.class, new DoubleEditor(true));
		binder.registerCustomEditor(String.class, new StringEditor(true));
	}
	
	public String convertCollection2Json(Object o) {
		JSONArray json = new JSONArray();
		try {
			json = JSONArray.fromObject(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != json)
			return json.toString();
		return "";
	}
	
	/**
	 * 向客户端写入文件，非强制下载
	 * 
	 * @param file
	 * @throws IOException
	 */
	protected final void responseFile(File file) throws IOException {
		responseFile(file, null, false);
	}
	/**
	 * 向客户端写入文件，并指定强制下载
	 * 
	 * @param file
	 * @param isDownload 是否强制下载
	 * @throws IOException
	 */
	protected final void responseFile(File file, boolean isDownload) throws IOException {
		responseFile(file, null, isDownload);
	}
	
	/**
	 * 向客户端写入文件
	 * 
	 * @param file
	 * @param newname 客户端显示的文件名
	 * @param isDownload 是否强制下载
	 * @throws IOException
	 */
	protected final void responseFile(File file, String newname, boolean isDownload) throws IOException {
		HttpServletResponse response = getResponse();
		HttpServletRequest request = getRequest();
		// 清空response
		response.reset();
		if(StringUtils.equals(request.getHeader("If-None-Match"), Long.toString(file.lastModified()))){
			response.setStatus(304);
			return;
		}

		if(isDownload){
			// 设置response的Header
			response.addHeader("Content-Disposition", "attachment;filename=" + (newname == null ? file.getName() : newname));
			// 以流的形式下载文件。
			response.setContentType("application/octet-stream");
		}else{
			// 设置response的Header
			response.addHeader("Content-Disposition", "filename=" + (newname == null ? file.getName() : newname));
			String name = newname;
			if (name == null) name = file.getName().toLowerCase();
			String contentType = null;
			if (name.endsWith(".pdf")) { contentType = "application/pdf"; }
			else if (name.endsWith(".doc") || name.endsWith(".docx")) { contentType = "application/msword"; }
			else if (name.endsWith(".xls")) { contentType = "application/vnd.ms-excel"; }
			else if (name.endsWith(".xlsx")) { contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"; }
			else if (name.endsWith(".rar")) { contentType = "application/tar"; }
			else if (name.endsWith(".zip")) { contentType = "application/zip"; }
			else if (name.endsWith(".rtf")) { contentType = "application/ttf"; }
			else if (name.endsWith(".gif")) { contentType = "image/gif"; }
			else if (name.endsWith(".tiff")) { contentType = "image/tiff"; }
			else if (name.endsWith(".jpg") || name.endsWith(".jpeg")) { contentType = "image/jpeg"; }
			else if (name.endsWith(".png")) { contentType = "image/png"; }
			else if (name.endsWith(".bmp")) { contentType = "image/bmp"; }
			if (!StringUtils.isBlank(contentType)) {
				response.setContentType(contentType);
			}
		}
		
		response.addHeader("Content-Length", Long.toString(file.length()));
		response.setHeader("ETag", Long.toString(file.lastModified()));
		
		try{
			// 循环取出流中的数据
			InputStream in = new FileInputStream(file);
			byte[] b = new byte[128];
			int len;
			ServletOutputStream out = response.getOutputStream();
			while ((len = in.read(b)) > 0) {
				out.write(b, 0, len);
			}
			out.flush();
			in.close();
		}catch(IOException e){
			response.setHeader("ETag", "");
			throw e;
		}
	}
	
	/**	
	 * 取得会话基础类
	 * @return
	 */
	public SessionInfo getSessionInfo() {
		HttpServletRequest request = this.request_threadLocal.get();
		HttpSession session = request.getSession();
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute("sessionInfo");
		return sessionInfo;
	}
	
	/**
	 * 取得用户编号
	 * @return
	 */
	public String getUserId() {
		String userId = this.getSessionInfo().getUserId();
		return userId;
	}
	
	public String getUserName() {
		String userName = this.getSessionInfo().getDisplayName();
		return userName;
	}
	
	
	public boolean getTagSys() {
		boolean tagSys = this.getSessionInfo().getTagSys();
		return tagSys;
	}
	
	/**
	 * 取得员工卡号
	 * @return
	 */
	public String getCardNo() {
		User user = this.getSessionInfo().getUser();
		return user.getCardNo();
	}
	
	public String getDivisionId() {
		String divisionId = this.getSessionInfo().getDivisionId();
		return divisionId;
	}
	
	public String getDivisionName() {
		String divisionName = this.getSessionInfo().getDivisionName();
		return divisionName;
	}
	
	public String getIp() {
		String ip = this.getSessionInfo().getIp();
		return ip;
	}

	public String getLastMonth() {
		return this.getSessionInfo().getLastMonth();
	}
	
	public String getEmail() {
		return this.getSessionInfo().getUser().getEmail();
	}
	
	/**
	 * 取得本月
	 * @return
	 */
	public String getCurrentMonth() {
		return this.getSessionInfo().getNowMonth();
	}
	
	/**
	 * 取得用户等级
	 * @return
	 */
	public Integer getUserLevel() {
		return this.getSessionInfo().getUserLever();
	}
	
	
	public List<UserImpl> searchUserListByPermission(String permissionCode) {
		List<UserImpl> listUser = new ArrayList<>();
		try {
			UserImpl user = new UserImpl();
			user.setCode(permissionCode);
			listUser = userService.selectUserByPermission(user);
		} catch (PmException e) {
			e.printStackTrace();
		}
		return listUser;
	}
	
	public UserImpl getUserByPermission(String permissionCode) {
		UserImpl user = new UserImpl();
		List<UserImpl> listUser = new ArrayList<>();
		try {
			user.setCode(permissionCode);
			listUser = userService.selectUserByPermission(user);
			if (null != listUser && listUser.size() == 1) {
				user = listUser.get(0);
			}
		} catch (PmException e) {
			e.printStackTrace();
		}
		return user;
	}
}
