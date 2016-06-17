package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Bill {
	private String bill_ID;
	private String store_ID;
	private String c_ID;
	private String trade_style;
	private Date finish_date;
	private Date delete_date;
	private String manager;
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bill(String bill_ID, String store_ID, String c_ID,
			String trade_style, Date finish_date, Date delete_date,
			String manager) {
		super();
		this.bill_ID = bill_ID;
		this.store_ID = store_ID;
		this.c_ID = c_ID;
		this.trade_style = trade_style;
		this.finish_date = finish_date;
		this.delete_date = delete_date;
		this.manager = manager;
	}

	public String getBill_ID() {
		return bill_ID;
	}
	public void setBill_ID(String bill_ID) {
		this.bill_ID = bill_ID;
	}
	public String getStore_ID() {
		return store_ID;
	}
	public void setStore_ID(String store_ID) {
		this.store_ID = store_ID;
	}
	public String getC_ID() {
		return c_ID;
	}
	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}
	public String getTrade_style() {
		return trade_style;
	}
	public void setTrade_style(String trade_style) {
		this.trade_style = trade_style;
	}
	public Date getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(Date finish_date) {
		this.finish_date = finish_date;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(Date delete_date) {
		this.delete_date = delete_date;
	}

	@Override
	public String toString() {
		return "Bill [bill_ID=" + bill_ID + ", store_ID=" + store_ID
				+ ", c_ID=" + c_ID + ", trade_style=" + trade_style
				+ ", finish_date=" + finish_date + ", delete_date="
				+ delete_date + ", manager=" + manager + "]";
	}
	
	
}
