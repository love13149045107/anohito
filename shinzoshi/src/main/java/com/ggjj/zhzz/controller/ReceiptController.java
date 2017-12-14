package com.ggjj.zhzz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggjj.zhzz.service.DictService;
import com.ggjj.zhzz.service.ReceiptService;
import com.ggjj.zhzz.vo.ReceiptVo;
import com.ggjj.zhzz.vo.ReceiptdetailVo;

@Controller
@RequestMapping(value = "/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	
	@Autowired
	private DictService dictService;

	@RequestMapping(value = "/findAll")
	public void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", receiptService.findAll());
		request.getRequestDispatcher("/jsp/receipt/receipt.jsp").forward(
				request, response);

	}

	@RequestMapping("/toInsertPage")
	public void toInsertPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", dictService.findEmptyLocCount());
		request.getRequestDispatcher("/jsp/receipt/insertReceipt.jsp").forward(
				request, response);

	}
	
	@RequestMapping(value = "/insert")
	public String insert(ReceiptdetailVo receiptdetailVo) {
		receiptService.insert(receiptdetailVo);
		if("���ջ�".equals(receiptdetailVo.getReceipt().getStatus())){
			return "redirect:/receipt/takeGoods/"+receiptdetailVo.getStorerkey();
		}
		return "redirect:/receipt/findAll";
	}

	@RequestMapping(value = "/delete/{storerkey}")
	public String delete(@PathVariable Integer storerkey) {
		receiptService.delete(storerkey);
		return "redirect:/receipt/findAll";
	}

	@RequestMapping("/takeGoods/{storerkey}")
	public String takeGoods(@PathVariable Integer storerkey){
		ReceiptVo receiptVo=receiptService.takeGoods(storerkey);
		receiptService.executeTakeGoods(receiptVo);
		return "redirect:/receipt/findAll";
		
	}
	
}
