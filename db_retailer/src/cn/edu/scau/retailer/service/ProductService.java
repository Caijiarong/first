package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.BrandDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.ProductDao;
import cn.edu.scau.retailer.dao.TypeDao;
import cn.edu.scau.retailer.domain.Brand;
import cn.edu.scau.retailer.domain.Product;
import cn.edu.scau.retailer.domain.Type;

public class ProductService {
	ProductDao productDao = DaoFactory.getProductDao();
	BrandDao brandDao = DaoFactory.getBrandDao();
	TypeDao typeDao = DaoFactory.getTypeDao();
	
	public void addProduct(Product product) throws UserException{
		Brand brand = brandDao.searchBrand(product.getBrand_ID());
		Type type = typeDao.searchType(product.getT_ID());
		if(brand == null)throw new UserException("该品牌不存在");
		if(type == null)throw new UserException("该类型不存在");
		productDao.addProduct(product);
	}
	
	public Product searchProduct(String id){
		Product product = productDao.searchProduct(id);
		return product;
	}
	
	public int countProduct(){
		return productDao.countProduct();
	}
	
	public void updateProduct(Product product) throws UserException{
		Brand brand = brandDao.searchBrand(product.getBrand_ID());
		Type type = typeDao.searchType(product.getT_ID());
		if(brand == null)throw new UserException("该品牌不存在");
		if(type == null)throw new UserException("该类型不存在");
		productDao.updateProduct(product);
	}
	public void deleteProduct(Product product){
		productDao.deleteProduct(product);
	}

}
