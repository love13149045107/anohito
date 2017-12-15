package com.ggjj.zhzz.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggjj.zhzz.pojo.Loc;
import com.ggjj.zhzz.service.LocService;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.vo.LocRequestVo;


@Controller
@RequestMapping(value = "/loc")
public class LocController {

	@Autowired
	private LocService locService;

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public DatagridResult findAll(LocRequestVo requestVo){
		DatagridResult result = locService.findAll(requestVo);
		return result;

	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HandResult delete(String ids) {
		HandResult result = locService.delete(ids);
		return result;
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HandResult insert(Loc loc) {
		HandResult result = locService.insert(loc);
		return result;
	}
	@RequestMapping(value = "/toinsert")
	public String toinsert() {
		return "loc/loc-add";
	}

	@RequestMapping(value = "/toedit")
	public String toedit() {
		return "loc/loc-edit";
	}
	
	@RequestMapping(value = "/loc")
	public String loc() {
		return "loc/loc";
	}


	@RequestMapping(value = "/edit")
	@ResponseBody
	public HandResult update(Loc loc) {
		HandResult result = locService.update(loc);
		return result;
	}

}
