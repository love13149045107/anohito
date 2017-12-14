package com.ggjj.zhzz.vo;

import java.util.List;

import com.ggjj.zhzz.pojo.Receipt;
import com.ggjj.zhzz.pojo.Receiptdetail;



public class ReceiptVo extends Receipt {

	private List<Receiptdetail> receiptdetails;

	public List<Receiptdetail> getReceiptdetails() {
		return receiptdetails;
	}

	public void setReceiptdetails(List<Receiptdetail> receiptdetails) {
		this.receiptdetails = receiptdetails;
	}
}
