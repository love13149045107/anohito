package com.ggjj.zhzz.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggjj.zhzz.pojo.Receipt;
import com.ggjj.zhzz.service.DictService;
import com.ggjj.zhzz.service.ReceiptService;
import com.ggjj.zhzz.utils.DatagridResult;
import com.ggjj.zhzz.utils.HandResult;
import com.ggjj.zhzz.vo.ReceiptRequestVo;
import com.ggjj.zhzz.vo.ReceiptVo;
import com.ggjj.zhzz.vo.ReceiptdetailVo;

@Controller
@RequestMapping(value = "/receipt")
public class ReceiptController {

	@Autowired
	private ReceiptService receiptService;
	@RequestMapping(value = "/findAll")
	@ResponseBody
	public DatagridResult findAll(ReceiptRequestVo requestVo){
		DatagridResult result = receiptService.findAll(requestVo);
		return result;

	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public HandResult delete(String ids) {
		HandResult result = receiptService.delete(ids);
		return result;
	}

	@RequestMapping(value = "/insert")
	@ResponseBody
	public HandResult insert(Receipt receipt) {
		HandResult result = receiptService.insert(receipt);
		return result;
	}
	@RequestMapping(value = "/toinsert")
	public String toinsert() {
		return "receipt/receipt-add";
	}

	@RequestMapping(value = "/toedit")
	public String toedit() {
		return "receipt/receipt-edit";
	}
	
	@RequestMapping(value = "/receipt")
	public String receipt() {
		return "receipt/receipt";
	}


	@RequestMapping(value = "/edit")
	@ResponseBody
	public HandResult update(Receipt receipt) {
		HandResult result = receiptService.update(receipt);
		return result;
	}
	
}
