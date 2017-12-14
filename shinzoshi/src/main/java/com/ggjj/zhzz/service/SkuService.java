package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.SkuMapper;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;
import com.ggjj.zhzz.pojo.SkuExample;
import com.ggjj.zhzz.pojo.SkuExample.Criteria;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.utils.IDUtils;
import com.ggjj.zhzz.utils.StringUtils;
import com.ggjj.zhzz.vo.SkuRequestVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class SkuService {
	
	@Autowired
	private SkuMapper skuMapper;
	
	public HandResult update(Sku sku){
		//根据已有选项进行更新
		skuMapper.updateByPrimaryKeySelective(sku);
		//返回执行结果
		return HandResult.ok();
	}
	
	public HandResult delete(String ids){
		SkuExample example = new SkuExample();
		Criteria criteria = example.createCriteria();
		//将带逗号分隔的id转换为list
		List<Integer> sids = StringUtils.parseList(ids, "int");
		//设置删除条件
		criteria.andSkuIn(sids);
		//执行删除
		skuMapper.deleteByExample(example);
		//返回执行结果
		return HandResult.ok();
	}
	
	public HandResult insert(Sku sku){
		//设置主键
		sku.setSku(IDUtils.getRanId());
		skuMapper.insert(sku);
		return HandResult.ok();
	}
	
	public DatagridResult findAll(SkuRequestVo requestVo){
		 //设置分页信息
        PageHelper.startPage(requestVo.getPage(), requestVo.getRows());
		SkuExample example = new SkuExample();
		 //执行查询
        List<Sku> skus = skuMapper.selectByExample(example);
        //获取分页信息
        PageInfo<Sku> pageInfo = new PageInfo<Sku>(skus);
        //创建返回结果
        DatagridResult datagridResult = new DatagridResult();
        datagridResult.setTotal(pageInfo.getTotal());
        datagridResult.setRows(skus);
        //返回查询结果集
		return datagridResult;
	}
	
	public Sku findSkuBySku(Integer sku){
		return skuMapper.selectByPrimaryKey(sku);
	}

}
