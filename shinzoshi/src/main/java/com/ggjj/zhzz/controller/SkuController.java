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

import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.pojo.Storer;
import com.ggjj.zhzz.service.SkuService;
import com.ggjj.zhzz.service.StorerService;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.vo.SkuRequestVo;


@Controller
@RequestMapping(value = "/sku")
public class SkuController {

	@Autowired
	private SkuService skuService;

	@Autowired
	private StorerService storerService;

	@RequestMapping("/toinsert")
	public String toInsert() {
		return "sku/sku-add";
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HandResult insert(Sku sku) {
		HandResult result = skuService.insert(sku);
		return result;
	}

	@RequestMapping("/toedit")
	public String toUpdateStorerPage(){
		return "sku/sku-edit";
		
	}

	@RequestMapping(value = "/edit")
	@ResponseBody
	public HandResult update(Sku sku) {
		HandResult result = skuService.update(sku);
		return result;
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HandResult delete(String ids) {
		HandResult result = skuService.delete(ids);
		return result;
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public DatagridResult findAll(SkuRequestVo requestVo)
			throws ServletException, IOException {
		DatagridResult result = skuService.findAll(requestVo);
		return result;
		
	}
	@RequestMapping(value = "/sku")
	public String sku(){
		return "sku/sku";
		
	}
	//获取全部货主
	@RequestMapping(value = "/findStores")
	@ResponseBody
	public List<Storer> findStores() {
		System.out.println("---------------");
		return storerService.findStores();

	}

}
