package com.ggjj.zhzz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.LocMapper;
import com.ggjj.zhzz.mapper.ReceiptdetailMapper;
import com.ggjj.zhzz.mapper.SkuMapper;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.LocExample;
import com.ggjj.zhzz.pojo.Receiptdetail;
import com.ggjj.zhzz.pojo.ReceiptdetailExample;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.SkuExample;
import com.ggjj.zhzz.pojo.LocExample.Criteria;

@Service
@Transactional
public class DictService {
	
	@Autowired
	private LocMapper locMapper;
	
	@Autowired
	private SkuMapper skuMapper;
	
	@Autowired
	private ReceiptdetailMapper receiptdetailMapper;
	
	public List<Loc> findEmptyLocCount(){
		SkuExample example=new SkuExample();
		List<Sku> list=skuMapper.selectByExample(example);
		
		ReceiptdetailExample exa=new ReceiptdetailExample();
		List<Receiptdetail> list2 = receiptdetailMapper.selectByExample(exa);
		
		List<Integer> values=new ArrayList<Integer>();
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				values.add(list.get(i).getLoc());
			}
		}
		if(list2!=null&&list2.size()>0){
			for (int i = 0; i < list2.size(); i++) {
				values.add(list2.get(i).getLoc());
			}
		}
		
		LocExample ex=new LocExample();
		Criteria criteria = ex.createCriteria();
		if(values.size()>0){
			criteria.andLocNotIn(values);
		}
		List<Loc> count= locMapper.selectByExample(ex);
		return count;

	}

}
