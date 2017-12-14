package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.LocMapper;
import com.ggjj.zhzz.mapper.ReceiptMapper;
import com.ggjj.zhzz.mapper.ReceiptdetailMapper;
import com.ggjj.zhzz.mapper.SkuMapper;
import com.ggjj.zhzz.mapper.StorerMapper;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.Receipt;
import com.ggjj.zhzz.pojo.ReceiptExample;
import com.ggjj.zhzz.pojo.Receiptdetail;
import com.ggjj.zhzz.pojo.ReceiptdetailExample;
import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.Storer;
import com.ggjj.zhzz.pojo.ReceiptdetailExample.Criteria;
import com.ggjj.zhzz.vo.ReceiptVo;
import com.ggjj.zhzz.vo.ReceiptdetailVo;

@Service
@Transactional
public class ReceiptService {

	@Autowired
	private StorerMapper storerMapper;

	@Autowired
	private SkuMapper skuMapper;

	@Autowired
	private LocMapper locMapper;

	@Autowired
	private ReceiptMapper receiptMapper;

	@Autowired
	private ReceiptdetailMapper receiptdetailMapper;

	public void insert(ReceiptdetailVo receiptdetailVo) {
		receiptMapper.insert(receiptdetailVo.getReceipt());
		receiptdetailMapper.insert(receiptdetailVo);
	}

	public List<Receipt> findAll() {
		ReceiptExample example = new ReceiptExample();
		return receiptMapper.selectByExample(example);
	}

	public void delete(Integer storerkey) {
		ReceiptdetailExample example = new ReceiptdetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andStorerkeyEqualTo(storerkey);
		List<Receiptdetail> list = receiptdetailMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				ReceiptdetailExample ex = new ReceiptdetailExample();
				;
				Criteria cr = ex.createCriteria();
				cr.andStorerkeyEqualTo(storerkey);
				receiptdetailMapper.deleteByExample(ex);
			}
		}
		receiptMapper.deleteByPrimaryKey(storerkey);
	}

	public ReceiptVo takeGoods(Integer storerkey) {
		ReceiptVo receiptVo = new ReceiptVo();

		Receipt receipt = receiptMapper.selectByPrimaryKey(storerkey);
		receiptVo.setAddress(receipt.getAddress());
		receiptVo.setComment(receipt.getComment());
		receiptVo.setCompany(receipt.getCompany());
		receiptVo.setPhone(receipt.getPhone());
		receiptVo.setStatus(receipt.getStatus());
		receiptVo.setStorerkey(receipt.getStorerkey());
		receiptVo.setType(receipt.getType());

		ReceiptdetailExample example = new ReceiptdetailExample();
		Criteria criteria = example.createCriteria();
		criteria.andStorerkeyEqualTo(storerkey);
		List<Receiptdetail> list = receiptdetailMapper.selectByExample(example);
		receiptVo.setReceiptdetails(list);

		return receiptVo;
	}

	public void executeTakeGoods(ReceiptVo receiptVo) {
		// storer
		Storer storer = new Storer();
		storer.setStorerkey(receiptVo.getStorerkey());
		storer.setCompany(receiptVo.getCompany());
		storer.setPhone(receiptVo.getPhone());
		storer.setAddress(receiptVo.getAddress());
		Storer temp = storerMapper.selectByPrimaryKey(receiptVo.getStorerkey());
		if (temp != null) {
			storerMapper.updateByPrimaryKeySelective(storer);
		} else {
			storerMapper.insertSelective(storer);
		}

		// loc & sku
		List<Receiptdetail> receiptdetails = receiptVo.getReceiptdetails();
		for (int i = 0; i < receiptdetails.size(); i++) {
			Receiptdetail receiptdetail = receiptdetails.get(i);

			Loc loc = new Loc();
			loc.setLoc(receiptdetail.getLoc());
			loc.setQuantity(receiptdetail.getQuantity());
			locMapper.updateByPrimaryKeySelective(loc);

			Sku sku = new Sku();
			sku.setSku(receiptdetail.getSku());
			sku.setLoc(receiptdetail.getLoc());
			sku.setName(receiptdetail.getName());
			sku.setWeight(receiptdetail.getWeight());
			sku.setStorerkey(receiptdetail.getStorerkey());
			sku.setCategory(receiptdetail.getCategory());
			skuMapper.insertSelective(sku);// maybe the one throws exception if
			// sku'primary key is existed
		}

		// ok!
		Receipt receipt = new Receipt();
		receipt.setStorerkey(receiptVo.getStorerkey());
		receipt.setStatus("���ջ�");
		receiptMapper.updateByPrimaryKeySelective(receipt);
	}

	public Receipt findReceiptByPrimaryKey(Integer storerkey) {
		return receiptMapper.selectByPrimaryKey(storerkey);
	}

}
