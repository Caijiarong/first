package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Customer {
	private String c_ID;
	private boolean gender;
	private String name;
	private String address;
	private String phone;
	private Date adddate;
	private Date deldate;
	private String manager;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String c_ID, boolean gender, String name, String address,
			String phone, Date adddate, Date deldate, String manager) {
		super();
		this.c_ID = c_ID;
		this.gender = gender;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.adddate = adddate;
		this.deldate = deldate;
		this.manager = manager;
	}

	public String getC_ID() {
		return c_ID;
	}
	public void setC_ID(String c_ID) {
		this.c_ID = c_ID;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public Date getDeldate() {
		return deldate;
	}
	public void setDeldate(Date deldate) {
		this.deldate = deldate;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [c_ID=" + c_ID + ", gender=" + gender + ", name="
				+ name + ", address=" + address + ", phone=" + phone
				+ ", adddate=" + adddate + ", deldate=" + deldate
				+ ", manager=" + manager + "]";
	}
	
	

}
