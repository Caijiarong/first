package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Type;

public interface TypeDao {
	public void addType(Type type);
	public Type searchType(String id);
	public int countType();
	public void updateType(Type type);
	public void deleteType(Type type);
}
