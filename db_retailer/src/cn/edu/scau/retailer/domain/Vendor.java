package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Vendor {
	private String v_ID;
	private String name;
	private String address;
	private Date date;
	private String manager;
	public Vendor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Vendor(String v_ID, String name, String address, Date date,
			String manager) {
		super();
		this.v_ID = v_ID;
		this.name = name;
		this.address = address;
		this.date = date;
		this.manager = manager;
	}
	public String getV_ID() {
		return v_ID;
	}
	public void setV_ID(String v_ID) {
		this.v_ID = v_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
		return "Vendor [v_ID=" + v_ID + ", name=" + name + ", address="
				+ address + ", date=" + date + ", manager=" + manager + "]";
	}
	
	
}
