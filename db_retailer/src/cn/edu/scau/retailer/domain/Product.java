package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Product {
	private String p_ID;
	private String name;
	private String brand_ID;
	private String t_ID;
	private String manufacturer;
	private String made_in;
	private Date date;
	private String manager;
	private String unit;
	private double discount;
	private double ori_price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(String p_ID, String name, String brand_ID, String t_ID,
			String manufacturer, String made_in, Date date, String manager,
			String unit, double discount, double ori_price) {
		super();
		this.p_ID = p_ID;
		this.name = name;
		this.brand_ID = brand_ID;
		this.t_ID = t_ID;
		this.manufacturer = manufacturer;
		this.made_in = made_in;
		this.date = date;
		this.manager = manager;
		this.unit = unit;
		this.discount = discount;
		this.ori_price = ori_price;
	}

	public String getP_ID() {
		return p_ID;
	}
	public void setP_ID(String p_ID) {
		this.p_ID = p_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand_ID() {
		return brand_ID;
	}
	public void setBrand_ID(String brand_ID) {
		this.brand_ID = brand_ID;
	}
	public String getT_ID() {
		return t_ID;
	}
	public void setT_ID(String t_ID) {
		this.t_ID = t_ID;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMade_in() {
		return made_in;
	}
	public void setMade_in(String made_in) {
		this.made_in = made_in;
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
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}



	public double getDiscount() {
		return discount;
	}



	public void setDiscount(double discount) {
		this.discount = discount;
	}



	public double getOri_price() {
		return ori_price;
	}



	public void setOri_price(double ori_price) {
		this.ori_price = ori_price;
	}




	@Override
	public String toString() {
		return "Product [p_ID=" + p_ID + ", name=" + name + ", brand_ID="
				+ brand_ID + ", t_ID=" + t_ID + ", manufacturer="
				+ manufacturer + ", made_in=" + made_in + ", date=" + date
				+ ", manager=" + manager + ", unit=" + unit + ", discount="
				+ discount + ", ori_price=" + ori_price + "]";
	}






	
	
}
