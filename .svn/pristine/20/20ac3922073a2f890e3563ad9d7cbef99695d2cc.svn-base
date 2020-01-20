package com.mtf.framework.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.GoodsMapper;
import com.mtf.framework.dao.UnitMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Goods;
import com.mtf.framework.model.Unit;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.PageForm;
import com.mtf.framework.service.IGoodsService;

@Service("goodsService")
public class GoodsServiceImpl implements IGoodsService {

	private static final Logger	logger	= Logger.getLogger(GoodsServiceImpl.class);

	private GoodsMapper			goodsMapper;
	private UnitMapper			unitMapper;

	@Autowired
	public void setUnitMapper(UnitMapper unitMapper) {
		this.unitMapper = unitMapper;
	}

	@Autowired
	public void setGoodsMapper(GoodsMapper goodsMapper) {
		this.goodsMapper = goodsMapper;
	}

	@Override
	public Goods insert(String uid, Goods goods) throws PmException {
		if(goods==null){
			throw new PmException("Parameter goods is NULL or Empty.");
		}
		Unit unit=null;
		if(goods.getUnit_id()!=null){
			unit=unitMapper.selectById(goods.getUnit_id());
		}
		goods.setAddUser(uid);
		goods.setModified(new Date().getTime());
		goods.setAddDate(new Date());
		goods.setUnit(unit.getName());
		this.goodsMapper.insert(goods);
		return goods;
	}

	@Override
	public DataGrid<Goods> select(String uid, PageForm form, Goods goods) throws PmException {
		if (form == null) {
			form = new PageForm();
		}
		HashMap<String, Object> param = new HashMap<String, Object>();
		DataGrid<Goods> result = new DataGrid<Goods>();
		if (goods != null) {
			if (null != goods.getStatus()) {
				param.put("status", goods.getStatus());
			}
			if (null != goods.getCommodity()) {
				param.put("commodity", goods.getCommodity());
			}
			if ("commodity".equalsIgnoreCase(form.getSort())) {
				param.put("sort", "commodity");
			}
			param.put("startIndex", form.getStartIndex());
			param.put("pageSize", form.getRows());
			int count = goodsMapper.countBySearch(param);
			if (count != 0) {
				result.setTotal(count);
			}
			List<Goods> list = goodsMapper.selectBySearch(param);
			if (list.size() != 0) {
				result.setRows(list);
			}
		}
		return result;
	}

	@Override
	public Goods get(String uid, Goods goods) throws PmException {
		return null;
	}

	@Override
	public int update(String uid, Goods goods) throws PmException {
		if (goods == null) {
			throw new PmException("Parameter goods is NULL or Empty.");
		}
		Unit unit=null;
		if(goods.getUnit_id()!=null){
			unit=unitMapper.selectById(goods.getUnit_id());
		}else {
			unit.setName(null);
		}
		
		goods.setModifiedUser(uid);
		goods.setModified(new Date().getTime());
		goods.setAddDate(new Date());
		goods.setUnit(unit.getName());
		int flag = goodsMapper.update(goods);
		return flag;
	}

	@Override
	public int delete(String uid, Goods goods) throws PmException {
		if (goods == null) {
			throw new PmException("Parameter goods is NULL or Empty.");
		}
		int flag = goodsMapper.delete(goods);
		return flag;
	}

}
