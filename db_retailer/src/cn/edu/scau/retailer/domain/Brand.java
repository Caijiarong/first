package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Brand {
	private String brand_ID;
	private String name;
	private Date date;
	private String manager;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Brand(String brand_ID, String name, Date date, String manager) {
		super();
		this.brand_ID = brand_ID;
		this.name = name;
		this.date = date;
		this.manager = manager;
	}
	public String getBrand_ID() {
		return brand_ID;
	}
	public void setBrand_ID(String brand_ID) {
		this.brand_ID = brand_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "Brand [brand_ID=" + brand_ID + ", name=" + name + ", date="
				+ date + ", manager=" + manager + "]";
	}
	
}
