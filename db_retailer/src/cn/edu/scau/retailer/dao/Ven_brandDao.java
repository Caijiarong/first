package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Ven_brand;

public interface Ven_brandDao {
	public void addVen_brand(Ven_brand ven_brand);
	public Ven_brand searchVen_brand(String v_id, String brand_id);
	public void deleteVen_brand(Ven_brand ven_brand);

}
