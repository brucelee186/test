package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.Page;

public interface MailMapper {

	// 单表通用操作
	int deleteById(String id);

	int insert(Mail record);

	Mail selectById(String id);

	int updateById(Mail record);
	
	int count(@Param("record") Mail record);
	
	List<Mail> select(@Param("record") Mail record, @Param("page") Page page);
	
	List<Mail> selectWithoutContent(@Param("record") Mail record, @Param("page") Page page);
	
	List<Mail> selectUnsend(@Param("page") Page page);
}