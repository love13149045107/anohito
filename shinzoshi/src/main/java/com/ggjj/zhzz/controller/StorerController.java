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

import com.ggjj.zhzz.pojo.Storer;
import com.ggjj.zhzz.service.StorerService;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.vo.StorerRequestVo;

@Controller
@RequestMapping(value = "/storer")
public class StorerController {

	@Autowired
	private StorerService storerService;

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HandResult insert(Storer storer) {
		HandResult result = storerService.insert(storer);
		return result;
	}
	@RequestMapping(value = "/toinsert")
	public String toInsert() {
		return "storer/storer-add";
	}

	@RequestMapping(value = "/toedit")
	public String toEdit() {
		return "storer/storer-edit";
	}

	@RequestMapping(value = "/edit")
	@ResponseBody
	public HandResult edit(Storer storer) {
		HandResult result = storerService.update(storer);
		return result;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HandResult delete(String ids) {
		HandResult result = storerService.delete(ids);
		return result;
	}
	@RequestMapping(value = "/storer")
	public String store() {
		return "storer/storer";
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public DatagridResult findAll(StorerRequestVo requestVo) {
		return storerService.findStorersByPage(requestVo);

	}

}
