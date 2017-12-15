package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.LocMapper;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.LocExample;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.LocExample;
import com.ggjj.zhzz.pojo.LocExample.Criteria;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.utils.IDUtils;
import com.ggjj.zhzz.utils.StringUtils;
import com.ggjj.zhzz.vo.LocRequestVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class LocService {

	@Autowired
	private LocMapper locMapper;

	public HandResult update(Loc loc) {
		locMapper.updateByPrimaryKeySelective(loc);
		return HandResult.ok();
	}

	public HandResult delete(String ids) {
		LocExample example = new LocExample();
		Criteria criteria = example.createCriteria();
		//将带逗号分隔的id转换为list
		List<Integer> sids = StringUtils.parseList(ids, "int");
		//设置删除条件
		criteria.andLocIn(sids);
		//执行删除
		locMapper.deleteByExample(example);
		//返回执行结果
		return HandResult.ok();
	}

	public HandResult insert(Loc loc) {
		//设置主键
		loc.setLoc(IDUtils.getRanId());
		locMapper.insert(loc);
		return HandResult.ok();
	}

	public DatagridResult findAll(LocRequestVo requestVo) {
		 //设置分页信息
        PageHelper.startPage(requestVo.getPage(), requestVo.getRows());
		LocExample example = new LocExample();
		 //执行查询
        List<Loc> locs = locMapper.selectByExample(example);
        //获取分页信息
        PageInfo<Loc> pageInfo = new PageInfo<Loc>(locs);
        //创建返回结果
        DatagridResult datagridResult = new DatagridResult();
        datagridResult.setTotal(pageInfo.getTotal());
        datagridResult.setRows(locs);
        //返回查询结果集
		return datagridResult;
	}

	public Loc findLocByLoc(Integer locid) {
		return locMapper.selectByPrimaryKey(locid);
	}

}
