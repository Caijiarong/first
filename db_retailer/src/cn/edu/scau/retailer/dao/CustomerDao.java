package cn.edu.scau.retailer.dao;

import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Customer;

public interface CustomerDao {
	public void addCustomer(Customer customer);
	public Customer findCustomer(String id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer) throws SQLException;
}
