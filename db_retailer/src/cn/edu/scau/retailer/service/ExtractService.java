package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.ExtractDao;

public class ExtractService {
	ExtractDao extractDao = DaoFactory.getExtractDao();
	public void extractAll(String table){
		extractDao.ExtractAll(table);		
	}
	
	public void extract(String sql){
		extractDao.Extract(sql);
	}
}
