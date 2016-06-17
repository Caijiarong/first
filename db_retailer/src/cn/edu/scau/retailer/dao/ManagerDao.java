package cn.edu.scau.retailer.dao;

import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Manager;

public interface ManagerDao {
	public Manager findNum(String number);
	public void addManager(Manager manager);
	public void updateManager(Manager manager);
	public void deleteManager(Manager manager) throws SQLException;
}
