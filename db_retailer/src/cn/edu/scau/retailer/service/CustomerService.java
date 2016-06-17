package cn.edu.scau.retailer.service;

import java.sql.SQLException;

import cn.edu.scau.retailer.dao.CustomerDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.domain.Customer;

public class CustomerService {
	CustomerDao customerDao = DaoFactory.getCustomerDao();
	
	public void addCustomer(Customer customer) throws UserException{
	
		if(customer.getC_ID() == null || customer.getC_ID().equals("")){
			throw new UserException("会员身份证ID不能为空");
		}
		else if(customer.getName() == null || customer.getName().equals("")){
			throw new UserException("会员姓名不能为空");
		}
		else if(customer.getAddress() == null || customer.getAddress().equals("")){
			throw new UserException("会员住址不能为空");
		}
		else if(customer.getPhone() == null || customer.getPhone().equals("")){
			throw new UserException("会员电话不能为空");
		}
		else{ 
			Customer cus = customerDao.findCustomer(customer.getC_ID());
			if(cus == null)customerDao.addCustomer(customer);
			else throw new UserException("此ID已注册");
		}
	}
	
	public Customer findCustomer(String id){
			Customer cus = customerDao.findCustomer(id);
			return cus;
	}
	
	public void updateCustomer(Customer customer){
		customerDao.updateCustomer(customer);
	}
	
	public void deleteCustomer(Customer customer) throws UserException{
		try {
			customerDao.deleteCustomer(customer);
		} catch (SQLException e) {
			throw new UserException("无法删除该客户");
		}
	}
}
