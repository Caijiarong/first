package cn.edu.scau.retailer.service;

import java.sql.SQLException;

import cn.edu.scau.retailer.dao.BrandDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.domain.Brand;


public class BrandService {
	BrandDao brandDao = DaoFactory.getBrandDao();
	
	public void addBrand(Brand brand){
		brandDao.addBrand(brand);
	}
	
	public Brand searchBrand(String id){
		Brand brand = brandDao.searchBrand(id);
		return brand;
	}
	
	public int countBrand(){
		return brandDao.countBrand();
	}
	
	public void updateBrand(Brand brand){

		brandDao.updateBrand(brand);
	}
	public void deleteBrand(Brand brand) throws UserException{
		try {
			brandDao.deleteBrand(brand);
		} catch (SQLException e) {
			throw new UserException("不能删除该品牌");
		}
	}
}
