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

import com.ggjj.zhzz.pojo.Sku;
import com.ggjj.zhzz.service.SkuService;
import com.ggjj.zhzz.service.StorerService;


@Controller
@RequestMapping(value = "/sku")
public class SkuController {

	@Autowired
	private SkuService skuService;

	@Autowired
	private StorerService storerService;

	@RequestMapping("/toInsertSkuPage")
	public void toInsertSkuPage(HttpServletResponse response,
			HttpServletRequest request) throws ServletException, IOException {
		//request.setAttribute("list", storerService.findAll());
		request.getRequestDispatcher("/jsp/sku/insertSku.jsp").forward(request,
				response);

	}

	@RequestMapping(value = "/insert")
	public String insert(Sku sku) {
		skuService.insert(sku);
		return "redirect:/sku/findAll";
	}

	@RequestMapping("/toUpdateSkuPage/{sku}")
	public void toUpdateStorerPage(@PathVariable("sku") Integer skuid,
			HttpServletResponse response, HttpServletRequest request)
			throws ServletException, IOException {
		Sku sku = skuService.findSkuBySku(skuid);
		request.setAttribute("sku", sku);
		//request.setAttribute("list", storerService.findAll());

		request.getRequestDispatcher("/jsp/sku/updateSku.jsp").forward(request,
				response);

	}

	@RequestMapping(value = "/update")
	public String update(Sku sku) {
		skuService.update(sku);
		return "redirect:/sku/findAll";
	}

	@RequestMapping(value = "/delete/{sku}")
	public String delete(@PathVariable Integer sku) {
		skuService.delete(sku);
		return "redirect:/sku/findAll";
	}

	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//List<Sku> list = skuService.findAll();
		request.setAttribute("list", null);
		request.getRequestDispatcher("/jsp/sku/sku.jsp").forward(request,
				response);

	}

}
