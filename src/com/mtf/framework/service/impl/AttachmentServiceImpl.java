package com.mtf.framework.service.impl;

import java.io.File;
import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.fr.web.core.service.AttachmentUploadAction;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.Json;
import com.mtf.framework.model.impl.AttachmentImpl;
import com.mtf.framework.model.impl.OrderCategoryServiceImpl;
import com.mtf.framework.dao.AttachmentMapper;
import com.mtf.framework.dao.OrderCategoryServiceMapper;
import com.mtf.framework.model.Attachment;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.AttachmentService;
import com.mtf.framework.service.OrderCategoryServiceService;
import com.mtf.framework.util.CommonUtil;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 附件
 * 作者:     Auto
 * 日期:     2013/8/12
**********************************************
*/
@Service("attachmentService")
public class AttachmentServiceImpl extends CommonServiceImpl implements AttachmentService {
	@Autowired
	private AttachmentMapper attachmentMapper;
	
	@Autowired
	private OrderCategoryServiceMapper orderCategoryServiceMapper;

	@Autowired
	public OrderCategoryServiceMapper getOrderCategoryServiceMapper() {
		return orderCategoryServiceMapper;
	}

	@Autowired
	public void setOrderCategoryServiceMapper(
			OrderCategoryServiceMapper orderCategoryServiceMapper) {
		this.orderCategoryServiceMapper = orderCategoryServiceMapper;
	}

	@Autowired
	public AttachmentMapper getAttachmentMapper() {
		return attachmentMapper;
	}

	@Autowired
	public void setAttachmentMapper(AttachmentMapper attachmentMapper) {
		this.attachmentMapper = attachmentMapper;
	}

	/**
	 * 新增实体对象
	 * @param attachment
	 */
	public AttachmentImpl insert(AttachmentImpl attachmentImpl) throws PmException {
		attachmentImpl.setUserName(getUserName());
		attachmentImpl.setUserId(getUserId());
		this.attachmentMapper.insert(attachmentImpl);
		return attachmentImpl;
	}

	/**
	 * 删除实体对象
	 * @param attachment
	 */
	public int delete(AttachmentImpl attachmentImpl) throws PmException {
		return this.attachmentMapper.delete(attachmentImpl);
	}

	/**
	 * 更新实体对象
	 * @param attachment
	 */
	public boolean update(AttachmentImpl attachmentImpl) throws PmException {
		boolean result = true;
		this.attachmentMapper.update(attachmentImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param attachment
	 */
	public AttachmentImpl get(AttachmentImpl attachmentImpl) throws PmException {
		return (AttachmentImpl) this.attachmentMapper.get(attachmentImpl);
	}
	/**
	 * 查询实体列表
	 * @param attachment
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttachmentImpl> select(AttachmentImpl attachmentImpl) throws PmException {
		DataGrid<AttachmentImpl> grid = new DataGrid<AttachmentImpl>();
		Object obj = attachmentImpl;
		List list = attachmentMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attachmentMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	/**
	 * 附件上传
	 * @param attachment
	 * @return
	 */
	public AttachmentImpl attachUpload (AttachmentImpl attachment) throws PmException {
		String relevanceTable = attachment.getRelevanceTable();
		Long relevanceId = attachment.getRelevanceId();
		
		//文件类型 f:file, i:image
		String type = attachment.getType();
		// 文件保存路径
		String savePathFilePath = null;
		String pathFile = null;
		if (type != null) {
			pathFile = CommonUtil.getConfig("uploadPathAttachement." + type);
		} else {
			pathFile = CommonUtil.getConfig("uploadPathAttachement");
		}
		Json j = new Json();
		List<CommonsMultipartFile> listFile = attachment.getListFile();
		AttachmentImpl attachmentTemp = new AttachmentImpl();
		// 防止重复写入bug
		attachmentTemp.setListFile(null);
		// 取得需要写入附件的下标
		Integer attachIndex = attachment.getAttachIndex();
		try {
			if (null != attachIndex && null != listFile && !listFile.isEmpty()) {
				CommonsMultipartFile commonsMultipartFile = listFile.get(attachIndex);
				if (!commonsMultipartFile.isEmpty()) {
					String fileName = commonsMultipartFile.getFileItem().getName();
					String suffix = commonsMultipartFile.getOriginalFilename().substring(commonsMultipartFile.getOriginalFilename().indexOf("."));
					String savePathFile = pathFile + "/"+ CommonUtil.getGUID() + suffix;
					String pathClient = attachment.getPathClient();
					savePathFilePath = pathClient + savePathFile;
					File saveFile = new File(savePathFilePath);
					if (!saveFile.exists()) {
						saveFile.createNewFile();
					}
					commonsMultipartFile.getFileItem().write(saveFile);
					attachmentTemp.setSavePathFile(savePathFile);
					attachmentTemp = new AttachmentImpl();
					attachmentTemp.setUserId(getUserId());
					attachmentTemp.setUserName(getUserName());
					attachmentTemp.setFileName(fileName.replace(suffix, ""));
					attachmentTemp.setSuffix(suffix.replace(".", ""));
					attachmentTemp.setSavePathFile(savePathFile);
					if (relevanceId != null) {
						attachmentTemp.setRelevanceId(relevanceId);
					}
					if (relevanceTable != null) {
						attachmentTemp.setRelevanceTable(relevanceTable);
					}
					attachmentMapper.insert(attachmentTemp);
					if (relevanceId != null && relevanceTable !=null) {
						if ("orderCategoryService".equals(relevanceTable)) {
							AttachmentImpl attachmentInner = new AttachmentImpl();
							attachmentInner.setRelevanceId(relevanceId);
							attachmentInner.setRelevanceTable(relevanceTable);
							List<AttachmentImpl> listAttachment = (List<AttachmentImpl>) attachmentMapper.select(attachmentInner);
							if (null != listAttachment && listAttachment.size() > 0) {
								OrderCategoryServiceImpl orderCategoryService = new OrderCategoryServiceImpl();
								orderCategoryService.setId(relevanceId);
								orderCategoryService.setCountAttachment(listAttachment.size());
								orderCategoryServiceMapper.update(orderCategoryService);
							}
						}
					}
				}
			}
			j.setObj(attachmentTemp);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("单个文件不可超过30M");
			j.setSuccess(false);
		}
		
		
		return attachmentTemp;
	}
	
	/**
	 * 附件上传
	 * @param attachment
	 * @return
	 */
	public AttachmentImpl attachUploadV2 (AttachmentImpl attachment) throws PmException {
		//文件类型 f:file, i:image
		String type = attachment.getType();
		// 文件保存路径
		String savePathFilePath = null;
		String pathFile = null;
		if (type != null) {
			pathFile = CommonUtil.getConfig("uploadPathAttachement." + type);
		} else {
			pathFile = CommonUtil.getConfig("uploadPathAttachement");
		}
		Json j = new Json();
		List<CommonsMultipartFile> listFile = attachment.getListFile();
		AttachmentImpl attachmentTemp = new AttachmentImpl();
		// 防止重复写入bug
		attachmentTemp.setListFile(null);
		// 取得需要写入附件的下标
		Integer attachIndex = attachment.getAttachIndex();
		try {
			if (null != attachIndex && null != listFile && !listFile.isEmpty()) {
				CommonsMultipartFile commonsMultipartFile = listFile.get(attachIndex);
				if (!commonsMultipartFile.isEmpty()) {
					String fileName = commonsMultipartFile.getFileItem().getName();
					String suffix = commonsMultipartFile.getOriginalFilename().substring(commonsMultipartFile.getOriginalFilename().indexOf("."));
					String savePathFile = pathFile + "/"+ CommonUtil.getGUID() + suffix;
					String pathClient = attachment.getPathClient();
					savePathFilePath = pathClient + savePathFile;
					File saveFile = new File(savePathFilePath);
					if (!saveFile.exists()) {
						saveFile.createNewFile();
					}
					commonsMultipartFile.getFileItem().write(saveFile);
					attachmentTemp.setSavePathFile(savePathFile);
					attachmentTemp = new AttachmentImpl();
					attachmentTemp.setFileName(fileName.replace(suffix, ""));
					attachmentTemp.setSuffix(suffix.replace(".", ""));
					attachmentTemp.setSavePathFile(savePathFile);
					attachmentMapper.insert(attachmentTemp);
				}
			}
			j.setObj(attachmentTemp);
			j.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			j.setMsg("单个文件不可超过30M");
			j.setSuccess(false);
		}
		return attachmentTemp;
	}
}