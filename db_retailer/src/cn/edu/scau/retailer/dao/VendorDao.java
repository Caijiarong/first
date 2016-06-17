package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Vendor;

public interface VendorDao {
	public void addVendor(Vendor vendor);
	public Vendor searchVendor(String id);
	public int countVendor();
	public void updateVendor(Vendor vendor);
	public void deleteVendor(Vendor vendor);
}
