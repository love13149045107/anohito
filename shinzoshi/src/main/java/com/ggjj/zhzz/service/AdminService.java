package com.ggjj.zhzz.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggjj.zhzz.mapper.AdminMapper;
import com.ggjj.zhzz.pojo.Admin;
import com.ggjj.zhzz.pojo.AdminExample;
import com.ggjj.zhzz.pojo.AdminExample.Criteria;
import com.ggjj.zhzz.utils.HandResult;

@Service
public class AdminService {

	@Autowired
	private AdminMapper adminMapper;
	public Admin findAdmin(Admin admin){
		//创建example
		AdminExample example = new AdminExample();
		//设置查询条件
		Criteria createCriteria = example.createCriteria();
		createCriteria.andNameEqualTo(admin.getName());
		createCriteria.andPasswordEqualTo(admin.getPassword());
		//执行查询
		List<Admin> admins = adminMapper.selectByExample(example);
		//判断获取list中的第一个元素
		if(admins != null && admins.size() > 0 ){
			return admins.get(0);
		}
		//否则返回空
		return null;
		
	}
}
