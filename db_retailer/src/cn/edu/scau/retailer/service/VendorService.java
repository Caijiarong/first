package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.VendorDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.domain.Vendor;

public class VendorService {
	VendorDao vendorDao = DaoFactory.getVendorDao();
	
	public void addVendor(Vendor vendor){
		vendorDao.addVendor(vendor);
	}
	
	public Vendor searchVendor(String id){
		Vendor vendor = vendorDao.searchVendor(id);
		return vendor;
	}
	
	public int countVendor(){
		return vendorDao.countVendor();
	}
	
	public void updateVendor(Vendor vendor){
		vendorDao.updateVendor(vendor);
	}
	public void deleteVendor(Vendor vendor){
		vendorDao.deleteVendor(vendor);
	}

}
