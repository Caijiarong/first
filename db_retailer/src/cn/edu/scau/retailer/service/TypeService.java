package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.TypeDao;
import cn.edu.scau.retailer.domain.Type;

public class TypeService {
	TypeDao typeDao = DaoFactory.getTypeDao();
	
	public void addType(Type type){
		typeDao.addType(type);
	}
	
	public Type searchType(String id){
		Type type = typeDao.searchType(id);
		return type;
	}
	
	public int countType(){
		return typeDao.countType();
	}
	
	public void updateType(Type type){
		typeDao.updateType(type);
	}
	public void deleteType(Type type){
		typeDao.deleteType(type);
	}
}
