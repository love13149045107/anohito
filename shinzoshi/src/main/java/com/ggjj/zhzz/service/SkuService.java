package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.SkuMapper;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;

@Service
@Transactional
public class SkuService {
	
	@Autowired
	private SkuMapper skuMapper;
	
	public void update(Sku sku){
		skuMapper.updateByPrimaryKeySelective(sku);
	}
	
	public void delete(Integer storerkey){
		skuMapper.deleteByPrimaryKey(storerkey);
	}
	
	public void insert(Sku sku){
		skuMapper.insert(sku);
	}
	
	public List<Sku> findAll(){
		SkuExample example=new SkuExample();
		List<Sku> list = skuMapper.selectByExample(example);
		return list;
	}
	
	public Sku findSkuBySku(Integer sku){
		return skuMapper.selectByPrimaryKey(sku);
	}

}
