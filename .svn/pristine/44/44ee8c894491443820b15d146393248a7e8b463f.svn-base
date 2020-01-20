package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.PaymentVoucherItem;
import com.mtf.framework.model.common.Page;

public interface PaymentVoucherItemMapper {
	int deleteById(String id);

	int insert(PaymentVoucherItem record);

	PaymentVoucherItem selectById(String id);

	int updateById(PaymentVoucherItem record);

	int count(PaymentVoucherItem record);

	List<PaymentVoucherItem> select(@Param("record") PaymentVoucherItem record, @Param("page") Page page);
}