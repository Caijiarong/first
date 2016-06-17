package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Ven_brand {
	private String v_ID;
	private String brand_ID;
	private Date date;
	private String manager;
	public Ven_brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ven_brand(String v_ID, String brand_ID, Date date, String manager) {
		super();
		this.v_ID = v_ID;
		this.brand_ID = brand_ID;
		this.date = date;
		this.manager = manager;
	}
	public String getV_ID() {
		return v_ID;
	}
	public void setV_ID(String v_ID) {
		this.v_ID = v_ID;
	}
	public String getBrand_ID() {
		return brand_ID;
	}
	public void setBrand_ID(String brand_ID) {
		this.brand_ID = brand_ID;
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
		return "Ven_brand [v_ID=" + v_ID + ", brand_ID=" + brand_ID + ", date="
				+ date + ", manager=" + manager + "]";
	}
	
	
}
