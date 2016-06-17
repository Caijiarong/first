package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Type {
	private String t_ID;
	private String name;
	private String size;
	private Date date;
	private String manager;
	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Type(String t_ID, String name, String size, Date date, String manager) {
		super();
		this.t_ID = t_ID;
		this.name = name;
		this.size = size;
		this.date = date;
		this.manager = manager;
	}
	public String getT_ID() {
		return t_ID;
	}
	public void setT_ID(String t_ID) {
		this.t_ID = t_ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
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
		return "Type [t_ID=" + t_ID + ", name=" + name + ", size=" + size
				+ ", date=" + date + ", manager=" + manager + "]";
	}
	
	
	
}
