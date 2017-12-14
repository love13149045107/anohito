package com.ggjj.zhzz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggjj.zhzz.pojo.Admin;
import com.ggjj.zhzz.service.AdminService;
import com.ggjj.zhzz.utils.HandResult;

@Controller
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/login")
	@ResponseBody
	public HandResult login(Admin admin, HttpServletRequest request){
		Admin result = adminService.findAdmin(admin);
		if(result != null){
			//创建session存放管理信息
			HttpSession session = request.getSession();
			session.setAttribute("admin", admin);
			//设置session存货时间,1800ss
			session.setMaxInactiveInterval(1800);
			//设置返回信息
			return HandResult.ok();
		}
		return HandResult.build(500, "用户名或密码错误！！！");
	}
	@RequestMapping("/index")
	public String toLoginPage(){
		return "index";
	}
}
