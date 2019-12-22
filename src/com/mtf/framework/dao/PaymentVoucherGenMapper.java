package com.mtf.framework.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mtf.framework.model.PaymentVoucherGen;
import com.mtf.framework.model.common.Page;

public interface PaymentVoucherGenMapper {
	int deleteById(Integer number);

	int insert(PaymentVoucherGen record);

	PaymentVoucherGen selectById(Integer number);
	
	PaymentVoucherGen selectByTick(Long tick);

	int updateById(PaymentVoucherGen record);

	int count(PaymentVoucherGen record);

	List<PaymentVoucherGen> select(@Param("record") PaymentVoucherGen record, @Param("page") Page page);
}