package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttachmentImpl;
import com.mtf.framework.model.Attachment;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：控制层接口 -> 附件
 * 作者:     Auto
 * 日期:     2013/8/12
**********************************************
*/
public interface AttachmentService {
	/**
	 * 新增实体对象
	 * @param attachmentImpl
	 * @return
	 * @throws PmException
	 */
	public AttachmentImpl insert(AttachmentImpl attachmentImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param attachment
	 * @return
	 * @throws PmException
	 */
	public int delete(AttachmentImpl attachmentImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param attachment
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttachmentImpl attachmentImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param attachment
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttachmentImpl> select(AttachmentImpl attachmentImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param attachment
	 * @return
	 * @throws PmException
	 */
	public AttachmentImpl get(AttachmentImpl attachmentImpl) throws PmException;
	
	/**
	 * 附件上传
	 * @param attachment
	 * @return
	 */
	public AttachmentImpl attachUpload (AttachmentImpl attachment) throws PmException;

}