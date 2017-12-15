package com.ggjj.zhzz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ggjj.zhzz.pojo.Receiptdetail;
import com.ggjj.zhzz.service.DictService;
import com.ggjj.zhzz.service.ReceiptService;
import com.ggjj.zhzz.service.ReceiptdetailService;

@Controller
@RequestMapping(value = "/receiptdetail")
public class ReceiptdetailController {

	@Autowired
	private ReceiptdetailService receiptdetailService;

	@Autowired
	private DictService dictService;

	@Autowired
	private ReceiptService receiptService;

	@RequestMapping(value = "/findReceiptdetailByStorerkey/{storerkey}")
	public void findReceiptdetailByStorerkey(@PathVariable Integer storerkey,
			HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("list", receiptdetailService
				.findReceiptdetailByStorerkey(storerkey));
		request.setAttribute("storerkey", storerkey);
		/*request.setAttribute("status", receiptService.findReceiptByPrimaryKey(
				storerkey).getStatus());*/
		request.getRequestDispatcher("/jsp/receiptdetail/receiptdetail.jsp")
				.forward(request, response);

	}

	@RequestMapping(value = "/delete/{receiptdetailId}/{storerkey}")
	public String delete(@PathVariable Integer receiptdetailId,
			@PathVariable Integer storerkey) {
		receiptdetailService.delete(receiptdetailId);
		return "redirect:/receiptdetail/findReceiptdetailByStorerkey/"
				+ storerkey;
	}

	@RequestMapping(value = "/{page}/{storerkey}")
	public void toPage(@PathVariable String page,
			@PathVariable Integer storerkey, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setAttribute("storerkey", storerkey);

		request.setAttribute("list", dictService.findEmptyLocCount());

		String path = "/jsp/receiptdetail/" + page + ".jsp";
		request.getRequestDispatcher(path).forward(request, response);
	}

	@RequestMapping(value = "/insert")
	public String insert(Receiptdetail receiptdetail) {
		receiptdetailService.insert(receiptdetail);
		return "redirect:/receiptdetail/findReceiptdetailByStorerkey/"
				+ receiptdetail.getStorerkey();
	}

	@RequestMapping("/toUpdatePage/{receiptdetailId}/{storerkey}")
	public void toUpdatePage(@PathVariable Integer receiptdetailId,
			@PathVariable Integer storerkey, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Receiptdetail receiptdetail = receiptdetailService
				.findReceiptdetailByReceiptdetailId(receiptdetailId);
		request.setAttribute("receiptdetail", receiptdetail);

		request.setAttribute("list", dictService.findEmptyLocCount());

		request.getRequestDispatcher(
				"/jsp/receiptdetail/updateReceiptdetail.jsp").forward(request,
				response);
	}

	@RequestMapping(value = "/update")
	public String update(Receiptdetail receiptdetail) {
		receiptdetailService.update(receiptdetail);
		return "redirect:/receiptdetail/findReceiptdetailByStorerkey/"
				+ receiptdetail.getStorerkey();
	}

}
