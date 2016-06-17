package cn.edu.scau.retailer.service;

import java.sql.SQLException;

import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.ManagerDao;
import cn.edu.scau.retailer.domain.Manager;


public class ManagerService {
	ManagerDao managerDao = DaoFactory.getManagerDao();
	public Manager login(Manager form) throws UserException{
		// TODO Auto-generated method stub
		Manager manager = managerDao.findNum(form.getUser_ID());
		
		if(manager == null)throw new UserException("用户名不存在");
		
		if(!form.getPasswd().equals(manager.getPasswd()))throw new UserException("密码错误");
		
		return manager;
	}
	
	public void addManager(Manager manager){
		managerDao.addManager(manager);
	}
	
	public void updateManager(Manager manager){
		managerDao.updateManager(manager);
	}
	
	public void deleteManager(Manager manager) throws UserException{
		try {
			managerDao.deleteManager(manager);
		} catch (SQLException e) {
			throw new UserException("不能删除该管理员");
		}
	}
	
	public Manager searchManager(String id){
		Manager manager = managerDao.findNum(id);
		return manager;
	}
}
