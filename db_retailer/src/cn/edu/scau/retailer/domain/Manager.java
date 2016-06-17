package cn.edu.scau.retailer.domain;

import java.util.Date;

public class Manager {
	private String user_ID;
	private String passwd;
	private int grade;
	private Date date;
	private String manager;
	private String verifyCode;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String user_IDString, String passwd, int grade,
			Date date, String manager) {
		super();
		this.user_ID = user_IDString;
		this.passwd = passwd;
		this.grade = grade;
		this.date = date;
		this.manager = manager;
	}
	
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
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

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "Manager [user_ID=" + user_ID + ", passwd=" + passwd
				+ ", grade=" + grade + ", date=" + date + ", manager="
				+ manager + ", verifyCode=" + verifyCode + "]";
	}




}
