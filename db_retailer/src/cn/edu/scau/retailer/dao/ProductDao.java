package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Product;

public interface ProductDao {
	public void addProduct(Product product);
	public Product searchProduct(String id);
	public int countProduct();
	public void updateProduct(Product product);
	public void deleteProduct(Product product);

}
