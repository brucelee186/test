package com.mtf.framework.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.mtf.framework.util.JsonDateTimeSerializer;


public class Mail implements Serializable {

	private static final long	serialVersionUID	= 1L;

	public static final int		PRIORITY_HIGH		= 1;
	public static final int		PRIORITY_NORMAL		= 3;
	public static final int		PRIORITY_LOW		= 5;

	public static final int		TYPE_PURCHASE		= 1;
	public static final int		TYPE_REIMBURSEMENT	= 2;
	public static final int		TYPE_REIMBURSEMENTREPORT	= 3;
	

	public static final int		STATUS_WAITTING		= 0;
	public static final int		STATUS_SENT			= 1;
	public static final int		STATUS_FAILED		= 2;

	// basic
	private String				id;
	private Integer				type;
	private String				tos;
	private String				ccs;
	private String				bccs;
	private String				subject;
	private String				content;
	private Integer				priority;
	private Integer				isHtml;
	private String				extFile;
	private Integer				retry;
	private Date				createDateTime;
	private Integer				status;
	private Date				updateDateTime;
	private String				msg;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTos() {
		return tos;
	}

	public void setTos(String tos) {
		this.tos = tos;
	}

	/**
	 * 追加TO邮箱地址
	 * 
	 * @param to
	 */
	public void addTo(String to) {
		if (this.tos == null) {
			this.tos = to;
		} else if (to != null && to.trim().length() > 0) {
			this.tos += ";" + to;
		}
	}

	public String getCcs() {
		return ccs;
	}

	public void setCcs(String ccs) {
		this.ccs = ccs;
	}

	/**
	 * 追加CC邮箱地址
	 * 
	 * @param cc
	 */
	public void addCc(String cc) {
		if (this.ccs == null) {
			this.ccs = cc;
		} else if (cc != null && cc.trim().length() > 0) {
			this.ccs += ";" + cc;
		}
	}

	public String getBccs() {
		return bccs;
	}

	public void setBccs(String bccs) {
		this.bccs = bccs;
	}

	/**
	 * 追加BCC邮箱地址
	 * 
	 * @param bcc
	 */
	public void addBcc(String bcc) {
		if (this.bccs == null) {
			this.bccs = bcc;
		} else if (bcc != null && bcc.trim().length() > 0) {
			this.bccs += ";" + bcc;
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getIsHtml() {
		return isHtml;
	}

	public void setIsHtml(Integer isHtml) {
		this.isHtml = isHtml;
	}

	public String getExtFile() {
		return extFile;
	}

	public void setExtFile(String extFile) {
		this.extFile = extFile;
	}

	public Integer getRetry() {
		return retry;
	}

	public void setRetry(Integer retry) {
		this.retry = retry;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@JsonSerialize(using = JsonDateTimeSerializer.class)
	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	// extra
	public String[] getToArr() {
		return tos == null ? null : tos.split(";");
	}

	public String[] getCcArr() {
		return ccs == null ? null : ccs.split(";");
	}

	public String[] getBccArr() {
		return bccs == null ? null : bccs.split(";");
	}
	
	public String[] getExtFileArr() {
		return extFile == null ? null : extFile.split(";");
	}
}