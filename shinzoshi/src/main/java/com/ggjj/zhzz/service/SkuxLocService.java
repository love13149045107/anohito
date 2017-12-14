package com.ggjj.zhzz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ggjj.zhzz.mapper.SkuxLocMapper;
import com.ggjj.zhzz.pojo.SkuxLoc;


@Service
@Transactional
public class SkuxLocService {

	@Autowired
	private SkuxLocMapper skuxLocMapper;
	
	public List<SkuxLoc> findSkuxLoc(){
		return skuxLocMapper.findSkuxLoc();
		
	}


}
