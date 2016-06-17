package cn.edu.scau.retailer.dao;

import java.sql.SQLException;

import cn.edu.scau.retailer.domain.Brand;

public interface BrandDao {
	public void addBrand(Brand brand);
	public Brand searchBrand(String id);
	public int countBrand();
	public void updateBrand(Brand brand);
	public void deleteBrand(Brand brand) throws SQLException;
}
