package com.mtf.framework.model.impl;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mtf.framework.model.Attachment;

/*
 **********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 附件
 * 作者:     Auto
 * 日期:     2013/8/13
 **********************************************
 */
public class AttachmentImpl extends Attachment {
	private static final long serialVersionUID = 1L;
	//文件类型 a:attachment, i:image, f:file
	private String type;
	
	// 客户端附件路径
	private String pathClient;
	
	// 需要写入的附件下标
	private Integer attachIndex;
	
	//附件列表
	private List<CommonsMultipartFile> listFile;
	
	// 上传文件对象
	private  CommonsMultipartFile file;
	
	public CommonsMultipartFile getFile() {
		return file;
	}
	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}
	public Integer getAttachIndex() {
		return attachIndex;
	}
	public void setAttachIndex(Integer attachIndex) {
		this.attachIndex = attachIndex;
	}
	public String getPathClient() {
		return pathClient;
	}
	public void setPathClient(String pathClient) {
		this.pathClient = pathClient;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<CommonsMultipartFile> getListFile() {
		return listFile;
	}
	public void setListFile(List<CommonsMultipartFile> listFile) {
		this.listFile = listFile;
	}
}