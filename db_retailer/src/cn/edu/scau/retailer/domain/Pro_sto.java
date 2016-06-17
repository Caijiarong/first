package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Pro_sto {
	private String ps_ID;
	private String store_ID;
	private String p_ID;
	private String v_ID;
	private double price;
	private double amount;
	private String upc_code;
	private Date product_date;
	private Date date;
	private String manager;
	public Pro_sto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pro_sto(String ps_ID, String store_ID, String p_ID, String v_ID,
			double price, double amount, String upc_code, Date product_date,
			Date date, String manager) {
		super();
		this.ps_ID = ps_ID;
		this.store_ID = store_ID;
		this.p_ID = p_ID;
		this.v_ID = v_ID;
		this.price = price;
		this.amount = amount;
		this.upc_code = upc_code;
		this.product_date = product_date;
		this.date = date;
		this.manager = manager;
	}
	public String getPs_ID() {
		return ps_ID;
	}
	public void setPs_ID(String ps_ID) {
		this.ps_ID = ps_ID;
	}
	public String getStore_ID() {
		return store_ID;
	}
	public void setStore_ID(String store_ID) {
		this.store_ID = store_ID;
	}
	public String getP_ID() {
		return p_ID;
	}
	public void setP_ID(String p_ID) {
		this.p_ID = p_ID;
	}
	public String getV_ID() {
		return v_ID;
	}
	public void setV_ID(String v_ID) {
		this.v_ID = v_ID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUpc_code() {
		return upc_code;
	}
	public void setUpc_code(String upc_code) {
		this.upc_code = upc_code;
	}
	public Date getProduct_date() {
		return product_date;
	}
	public void setProduct_date(Date product_date) {
		this.product_date = product_date;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Pro_sto [ps_ID=" + ps_ID + ", store_ID=" + store_ID + ", p_ID="
				+ p_ID + ", v_ID=" + v_ID + ", price=" + price + ", amount="
				+ amount + ", upc_code=" + upc_code + ", product_date="
				+ product_date + ", date=" + date + ", manager=" + manager
				+ "]";
	}
	
	

}
