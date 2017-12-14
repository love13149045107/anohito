package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.ReceiptdetailMapper;
import com.ggjj.zhzz.pojo.Receiptdetail;
import com.ggjj.zhzz.pojo.ReceiptdetailExample;
import com.ggjj.zhzz.pojo.ReceiptdetailExample.Criteria;

@Service
@Transactional
public class ReceiptdetailService {

	@Autowired
	private ReceiptdetailMapper receiptdetailMapper;

	public List<Receiptdetail> findReceiptdetailByStorerkey(Integer storerkey) {
		ReceiptdetailExample example = new ReceiptdetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andStorerkeyEqualTo(storerkey);
		return receiptdetailMapper.selectByExample(example);
	}

	public void delete(Integer receiptdetailId) {
		receiptdetailMapper.deleteByPrimaryKey(receiptdetailId);
	}

	public void insert(Receiptdetail receiptdetail) {
		receiptdetailMapper.insert(receiptdetail);
		
	}

	public void update(Receiptdetail receiptdetail) {
		receiptdetailMapper.updateByPrimaryKey(receiptdetail);
		
	}

	public Receiptdetail findReceiptdetailByReceiptdetailId(
			Integer receiptdetailId) {
		return receiptdetailMapper.selectByPrimaryKey(receiptdetailId);
	}

}
