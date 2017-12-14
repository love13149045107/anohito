package com.ggjj.zhzz.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.LocMapper;
import com.ggjj.zhzz.mapper.OrdersMapper;
import com.ggjj.zhzz.mapper.SkuMapper;
import com.ggjj.zhzz.mapper.StorerMapper;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.Orders;
import com.ggjj.zhzz.pojo.OrdersExample;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;
import com.ggjj.zhzz.pojo.Storer;

@Service
@Transactional
public class OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Autowired
	private SkuMapper skuMapper;

	@Autowired
	private LocMapper locMapper;

	@Autowired
	private StorerMapper storerMapper;

	public List<Sku> findAllSku() {
		SkuExample example = new SkuExample();
		return skuMapper.selectByExample(example);
	}

	public List<Orders> findAll() {
		OrdersExample example = new OrdersExample();
		List<Orders> list = ordersMapper.selectByExample(example);
		return list;
	}

	public void delete(Integer ordersId) {
		ordersMapper.deleteByPrimaryKey(ordersId);

	}

	public void insert(Orders orders) {

		Sku sku = skuMapper.selectByPrimaryKey(orders.getSku());
		Storer storer = storerMapper.selectByPrimaryKey(sku.getStorerkey());
		Loc loc = locMapper.selectByPrimaryKey(sku.getLoc());

		orders.setCompany(storer.getCompany());
		orders.setStorerkey(storer.getStorerkey());
		orders.setPhone(storer.getPhone());

		int quantity = loc.getQuantity() - orders.getQuantity();
		if (quantity >= 0) {
			loc.setQuantity(quantity);
			locMapper.updateByPrimaryKeySelective(loc);

			ordersMapper.insertSelective(orders);
		} else {
			throw new RuntimeException("����������㣬�������ⵥʧ�ܣ�" + "����Ҫ������Ϊ:"
					+ orders.getQuantity() + "�����ǿ����ֻʣ��:" + loc.getQuantity());
		}
	}

}
