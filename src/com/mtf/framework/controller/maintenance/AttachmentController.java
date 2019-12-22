package com.mtf.framework.controller.maintenance;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.AttachmentImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.AttachmentService;
import com.mtf.framework.service.ContractService;
import com.mtf.framework.service.UserService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：控制层 -> 附件
 * 作者:     Auto
 * 日期:     2013/8/12
**********************************************
*/
@Controller("attachmentController")
@RequestMapping("/upload/attachment")
public class AttachmentController {

	@Autowired
	private AttachmentService attachmentService;
	
	@Autowired
	private ContractService contractService;

	@Autowired
	private UserService	userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	public ContractService getContractService() {
		return contractService;
	}

	@Autowired
	public void setContractService(ContractService contractService) {
		this.contractService = contractService;
	}

	/**
	 * 跳转页面
	 * @return
	 */
	@RequestMapping("/toSearch")
	public ModelAndView toSearch() {
		return new ModelAndView("");
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
	public DataGrid<AttachmentImpl> doSearch(AttachmentImpl attachmentImpl, HttpSession session) throws Exception {
		new PmException(session);
		DataGrid<AttachmentImpl> list = new DataGrid<AttachmentImpl>();
		list = this.attachmentService.select(attachmentImpl);
		return list;
	}

	/**
	 * 跳转编辑
	 * @param attachment
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/toEdit")
	public ModelAndView toEdit(AttachmentImpl attachmentImpl, HttpSession session) throws Exception {
		new PmException(session);
		ModelAndView mv = new ModelAndView("");
		String editState = attachmentImpl.getEditState();
		if ("u".equals(editState)) {
			attachmentImpl = attachmentService.get(attachmentImpl);
		}
		attachmentImpl.setEditState(editState);
		mv.addObject("attachment", attachmentImpl);
		return mv;
	}

	/**
	 * 编辑
	 * @param attachment
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/doEdit", method = RequestMethod.POST)
	@ResponseBody
	public Json doEdit(AttachmentImpl attachment, HttpSession session) throws Exception {
		new PmException(session);
		Json j = new Json();
		String editState = attachment.getEditState();
		try {
			if ("i".equals(editState)) {
				CommonUtil.setCommonField(attachment, session);
				String pathClient = session.getServletContext().getRealPath(File.separator);
				attachment.setPathClient(pathClient);
				//attachment.setListFile(userDetail.getListFile());
				// 根据不同附件添加相关的类型
				//attachment.setType("attachment");
				//attachmentService.insert(attachment);
				// 设置需要更新的附件下标
				//attachment.setAttachIndex(userDetail.getAttachIndex());
				
				attachment = attachmentService.attachUpload(attachment);
			} else if ("u".equals(editState)) {
				CommonUtil.setCommonField(attachment, session);
				attachmentService.update(attachment);
			} else if ("d".equals(editState)) {
				attachmentService.delete(attachment);
				// 取得文件服务器路径
				String savePathFile = attachment.getSavePathFile();
				File fileDelete = new File(savePathFile);
				fileDelete.delete();
			}
			j.setSuccess(true);
			j.setObj(attachment);
		} catch (PmException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
		return j;
	}

	/**
	 * 上传文件
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileUploader", method=RequestMethod.POST)
	@ResponseBody
	public Json fileUploader(AttachmentImpl attachmentImpl, HttpSession session) throws PmException{
		String code="";
		if(!"".equals(attachmentImpl.getCode())){
			code=attachmentImpl.getCode();
		}
		Long contractId = attachmentImpl.getContractId();
		String userId = attachmentImpl.getUserId();
		//文件类型 f:file, i:image
		String type = attachmentImpl.getType();
		// 文件保存路径
		String savePathFilePath = null;
		String pathFile = null;
		if (type != null) {
			pathFile = CommonUtil.getConfig("uploadPathAttachement." + type);
		} else {
			pathFile = CommonUtil.getConfig("uploadPathAttachement");
		}
		Json j = new Json();
		List<CommonsMultipartFile> listFile = attachmentImpl.getListFile();
		AttachmentImpl attachment = new AttachmentImpl();
		// 防止重复写入bug
		attachmentImpl.setListFile(null);
		try {
			for (CommonsMultipartFile commonsMultipartFile : listFile) {
				if (!commonsMultipartFile.isEmpty()) {
					String fileName = commonsMultipartFile.getFileItem().getName();
					String suffix = commonsMultipartFile.getOriginalFilename().substring(commonsMultipartFile.getOriginalFilename().indexOf("."));
					String savePathFile = pathFile + "/"+ CommonUtil.getGUID() + suffix;
					savePathFilePath = session.getServletContext().getRealPath(File.separator) + savePathFile;
					File saveFile = new File(savePathFilePath);
					if (!saveFile.exists()) {
						saveFile.createNewFile();
					}
					commonsMultipartFile.getFileItem().write(saveFile);
					attachment.setSavePathFile(savePathFile);
					//if (contractId != null) {
						attachment = new AttachmentImpl();
						attachment.setContractId(contractId);
						attachment.setUserId(userId);
						attachment.setFileName(fileName.replace(suffix, ""));
						attachment.setSuffix(suffix.replace(".", ""));
						attachment.setSavePathFile(savePathFile);
						//attachment.setCode(code);
						attachmentService.insert(attachment);
						// 只有选择是确认函时，修改合同状态
						/*if("1".equals(code)){
						// 修改合同状态，已提交确认函
						ContractImpl contractImpl=new ContractImpl();
						contractImpl.setId(contractId);
						contractImpl.setApproveState("confirm");
						CommonUtil.setCommonField(contractImpl, session);
						contractService.update(contractImpl);
						}*/
						UserImpl user=new UserImpl();
						user.setId(userId);
						user.setPersonalPhoto("/office"+savePathFile);
						userService.editForPhoto(userId ,user);
						
						
					//}
				}
			}
			j.setSuccess(true);
			j.setObj(attachment);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("单个文件不可超过30M");
			j.setSuccess(false);
		} finally {
		}
		return j;
	}
	
	/**
	 * 上传文件
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileUpload", method=RequestMethod.POST)
	@ResponseBody
	public Json fileUpload(AttachmentImpl attachmentImpl, HttpSession session) throws PmException{
		Long contractId = attachmentImpl.getContractId();
		String userId = attachmentImpl.getUserId();
		//文件类型 f:file, i:image
		String type = attachmentImpl.getType();
		// 文件保存路径
		String savePathFilePath = null;
		String pathFile = null;
		if (type != null) {
			pathFile = CommonUtil.getConfig("uploadPathAttachement." + type);
		} else {
			pathFile = CommonUtil.getConfig("uploadPathAttachement");
		}
		Json j = new Json();
		List<CommonsMultipartFile> listFile = attachmentImpl.getListFile();
		AttachmentImpl attachment = new AttachmentImpl();
		// 防止重复写入bug
		attachmentImpl.setListFile(null);
		try {
			for (CommonsMultipartFile commonsMultipartFile : listFile) {
				if (!commonsMultipartFile.isEmpty()) {
					String fileName = commonsMultipartFile.getFileItem().getName();
					String suffix = commonsMultipartFile.getOriginalFilename().substring(commonsMultipartFile.getOriginalFilename().indexOf("."));
					String savePathFile = pathFile + "/"+ CommonUtil.getGUID() + suffix;
					savePathFilePath = session.getServletContext().getRealPath(File.separator) + savePathFile;
					File saveFile = new File(savePathFilePath);
					if (!saveFile.exists()) {
						saveFile.createNewFile();
					}
					commonsMultipartFile.getFileItem().write(saveFile);
					attachment.setSavePathFile(savePathFile);
					attachment = new AttachmentImpl();
					attachment.setContractId(contractId);
					attachment.setUserId(userId);
					attachment.setFileName(fileName.replace(suffix, ""));
					attachment.setSuffix(suffix.replace(".", ""));
					attachment.setSavePathFile(savePathFile);
					attachmentService.insert(attachment);
				}
			}
			j.setSuccess(true);
			j.setObj(attachment);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("单个文件不可超过30M");
			j.setSuccess(false);
		} finally {
		}
		return j;
	}
	
	/**
	 * 上传图片
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/fileUploaderImage", method=RequestMethod.POST)
	@ResponseBody
	public Json fileUploaderImage(AttachmentImpl attachmentImpl, HttpSession session) throws PmException{
		Long contractId = attachmentImpl.getContractId();
		Json j = new Json();
		List<CommonsMultipartFile> listFile = attachmentImpl.getListFile();
		String pathFile = CommonUtil.getConfig("uploadPathAttachement");
		AttachmentImpl attachment = new AttachmentImpl();
		// 防止重复写入bug
		attachmentImpl.setListFile(null);
		try {
			for (CommonsMultipartFile commonsMultipartFile : listFile) {
				if (!commonsMultipartFile.isEmpty()) {
					String fileName = commonsMultipartFile.getFileItem().getName();
					String suffix = commonsMultipartFile.getOriginalFilename().substring(commonsMultipartFile.getOriginalFilename().indexOf("."));
					String savePathFile = pathFile + "/"+ CommonUtil.getGUID() + suffix;
					String savePathFilePath = session.getServletContext().getRealPath(File.separator) + savePathFile;
					File saveFile = new File(savePathFilePath);
					if (!saveFile.exists()) {
						saveFile.createNewFile();
					}
					commonsMultipartFile.getFileItem().write(saveFile);
					attachment = new AttachmentImpl();
					attachment.setContractId(contractId);
					attachment.setFileName(fileName.replace(suffix, ""));
					attachment.setSavePathFile(savePathFile);
					attachment.setSuffix(suffix.replace(".", ""));
					attachmentService.insert(attachment);
				}
			}
			j.setSuccess(true);
			j.setObj(attachment);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("单个文件不可超过30M");
			j.setSuccess(false);
		} finally {
		}
		return j;
	}
	
	/**
	 * 下载附件
	 * @param form
	 * @param session
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */
	@RequestMapping(value = "/loadFile")
	@ResponseBody
	public void loadFile(AttachmentImpl attachmentImpl, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedInputStream bis = null; // 从文件中读取内容
		BufferedOutputStream bos = null; // 向文件中写入内容
		try {
			attachmentImpl = attachmentService.get(attachmentImpl);
			String savePathFile = attachmentImpl.getSavePathFile();
			String fileName = attachmentImpl.getFileName();
			String suffix = attachmentImpl.getSuffix();
			fileName = fileName + "." + suffix;
			request.setCharacterEncoding("UTF-8");
			// 获得服务器上存放下载资源的地址
			String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\";
			// 获得下载文件全路径
			String downLoadPath = ctxPath + savePathFile;
			File file = new File(downLoadPath);
			if (!file.exists()) {
				return;
			}
			// 获得文件大小
			long fileLength = new File(downLoadPath).length();
			response.setContentType("text/html;charset=utf-8"); // 设置相应类型和编码
			response.setHeader("Content-disposition", "attachment;filename="
					+ new String(fileName.getBytes("utf-8"), "ISO-8859-1"));
			response.setHeader("Content-Length", String.valueOf(fileLength));
			bis = new BufferedInputStream(new FileInputStream(downLoadPath));
			bos = new BufferedOutputStream(response.getOutputStream());
			// 定义文件读取缓冲区
			byte[] buff = new byte[8000];
			int bytesRead;
			// 把下载资源写入到输出流
			while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
				bos.write(buff, 0, bytesRead);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	@RequestMapping(value = "/doDeleteFile")
	@ResponseBody
	public Json doDeleteFile(AttachmentImpl attachmentImpl, HttpServletRequest request,
			HttpServletResponse response) {
		Json j = new Json();
		try {
			
			attachmentImpl = attachmentService.get(attachmentImpl);
			//attachmentImpl = attachmentService.select(attachmentImpl);
			String savePathFile = attachmentImpl.getSavePathFile();
			String fileName = attachmentImpl.getFileName();
			String suffix = attachmentImpl.getSuffix();
			fileName = fileName + "." + suffix;
			request.setCharacterEncoding("UTF-8");
			// 获得服务器上存放下载资源的地址
			String ctxPath = request.getSession().getServletContext().getRealPath("/") + "\\";
			// 获得下载文件全路径
			String downLoadPath = ctxPath + savePathFile;
			System.err.println(downLoadPath);
			
			File file = new File(downLoadPath);
			if (file.exists()) {
				file.delete();
				attachmentService.delete(attachmentImpl);
				j.setSuccess(true);
				
			}else{
				j.setSuccess(false);
				
			}
			
		}catch(NullPointerException e){
			j.setSuccess(false);
			j.setMsg("没有图片");
			return j;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return j;
	}
}

