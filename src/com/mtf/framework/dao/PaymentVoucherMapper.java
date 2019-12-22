package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.PaymentVoucher;
import com.mtf.framework.model.common.Page;

public interface PaymentVoucherMapper {
	int deleteById(String id);

	int insert(PaymentVoucher record);

	PaymentVoucher selectById(String id);

	int updateById(PaymentVoucher record);

	int count(PaymentVoucher record);

	List<PaymentVoucher> select(@Param("record") PaymentVoucher record, @Param("page") Page page);
}