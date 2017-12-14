package com.ggjj.zhzz.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.StorerMapper;
import com.ggjj.zhzz.pojo.Storer;
import com.ggjj.zhzz.pojo.StorerExample;
import com.ggjj.zhzz.pojo.StorerExample.Criteria;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.utils.IDUtils;
import com.ggjj.zhzz.utils.StringUtils;
import com.ggjj.zhzz.vo.StorerRequestVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class StorerService {

	@Autowired
	private StorerMapper storerMapper;

	public HandResult update(Storer storer) {
		//根据已有选项进行更新
		storerMapper.updateByPrimaryKeySelective(storer);
		//返回执行结果
		return HandResult.ok();
	}

	public HandResult delete(String ids) {
		StorerExample example = new StorerExample();
		Criteria criteria = example.createCriteria();
		//将带逗号分隔的id转换为list
		List<Integer> sids = StringUtils.parseList(ids, "int");
		//设置删除条件
		criteria.andStorerkeyIn(sids);
		//执行删除
		storerMapper.deleteByExample(example);
		//返回执行结果
		return HandResult.ok();
	}

	public HandResult insert(Storer storer) {
		//设置主键
		storer.setStorerkey(IDUtils.getRanId());
		storerMapper.insert(storer);
		return HandResult.ok();
	}
	
	/**
	 * 分页查询货主
	 * @param requestVo
	 * @return
	 */
	public DatagridResult findStorersByPage(StorerRequestVo requestVo) {
		 //设置分页信息
        PageHelper.startPage(requestVo.getPage(), requestVo.getRows());
		StorerExample example = new StorerExample();
		 //执行查询
        List<Storer> storers = storerMapper.selectByExample(example);
        //获取分页信息
        PageInfo<Storer> pageInfo = new PageInfo<Storer>(storers);
        //创建返回结果
        DatagridResult datagridResult = new DatagridResult();
        datagridResult.setTotal(pageInfo.getTotal());
        datagridResult.setRows(storers);
        //返回查询结果集
		return datagridResult;
	}

	public Storer findStorerByStorerkey(Integer storerkey) {
		//根据主键查询单个对象
		return storerMapper.selectByPrimaryKey(storerkey);
	}
	/**
	 * 查询所有货主
	 * @return
	 */
	public List<Storer> findStores() {
		StorerExample example = new StorerExample();
		List<Storer> list = storerMapper.selectByExample(example);
		return list;
	}

}
