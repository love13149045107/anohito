package com.ggjj.zhzz.utils;

import java.io.Serializable;
import java.util.List;


public class DatagridResult implements Serializable {
	
	private long total; //中记录数
	private List rows; //行数据
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	
}
