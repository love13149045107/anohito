package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.LocMapper;
import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.pojo.LocExample;

@Service
@Transactional
public class LocService {

	@Autowired
	private LocMapper locMapper;

	public void update(Loc loc) {
		locMapper.updateByPrimaryKeySelective(loc);
	}

	public void delete(Integer loc) {
		locMapper.deleteByPrimaryKey(loc);
	}

	public void insert(Loc loc) {
		locMapper.insert(loc);
	}

	public List<Loc> findAll() {
		LocExample example = new LocExample();
		return locMapper.selectByExample(example);
	}

	public Loc findLocByLoc(Integer locid) {
		return locMapper.selectByPrimaryKey(locid);
	}

}
