package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.ReceiptMapper;
import com.ggjj.zhzz.pojo.Receipt;
import com.ggjj.zhzz.pojo.ReceiptExample;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.utils.IDUtils;
import com.ggjj.zhzz.utils.StringUtils;
import com.ggjj.zhzz.vo.ReceiptRequestVo;
import com.ggjj.zhzz.vo.ReceiptVo;
import com.ggjj.zhzz.vo.ReceiptdetailVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class ReceiptService {
	@Autowired
	private ReceiptMapper receiptMapper;

	public HandResult update(Receipt receipt) {
		receiptMapper.updateByPrimaryKeySelective(receipt);
		return HandResult.ok();
	}

	public HandResult delete(String ids) {
		ReceiptExample example = new ReceiptExample();
		com.ggjj.zhzz.pojo.ReceiptExample.Criteria criteria = example.createCriteria();
		//将带逗号分隔的id转换为list
		List<Integer> sids = StringUtils.parseList(ids, "int");
		//设置删除条件
		criteria.andStorerkeyIn(sids);
		//执行删除
		receiptMapper.deleteByExample(example);
		//返回执行结果
		return HandResult.ok();
	}

	public HandResult insert(Receipt receipt) {
		receiptMapper.insert(receipt);
		return HandResult.ok();
	}

	public DatagridResult findAll(ReceiptRequestVo requestVo) {
		 //设置分页信息
        PageHelper.startPage(requestVo.getPage(), requestVo.getRows());
		ReceiptExample example = new ReceiptExample();
		 //执行查询
        List<Receipt> receipts = receiptMapper.selectByExample(example);
        //获取分页信息
        PageInfo<Receipt> pageInfo = new PageInfo<Receipt>(receipts);
        //创建返回结果
        DatagridResult datagridResult = new DatagridResult();
        datagridResult.setTotal(pageInfo.getTotal());
        datagridResult.setRows(receipts);
        //返回查询结果集
		return datagridResult;
	}



}
