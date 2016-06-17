package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.Ven_brandDao;
import cn.edu.scau.retailer.domain.Brand;
import cn.edu.scau.retailer.domain.Ven_brand;

public class Ven_brandService {
	Ven_brandDao ven_brandDao = DaoFactory.getVen_brandDao();
	
	public void addVen_brand(Ven_brand ven_brand) throws UserException{
		BrandService brandService = new BrandService();
		Brand brand = brandService.searchBrand(ven_brand.getBrand_ID());
		if(brand == null)throw new UserException("该品牌不存在");
		ven_brandDao.addVen_brand(ven_brand);
	}
	
	public Ven_brand searchVen_brand(String v_id, String brand_id){
		Ven_brand ven_brand = ven_brandDao.searchVen_brand(v_id, brand_id);
		return ven_brand;
	}
	
	public void deleteVen_brand(Ven_brand ven_brand){
		ven_brandDao.deleteVen_brand(ven_brand);
	}
}
