package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Pro_sto;

public interface Pro_stoDao {
	public void addPro_sto(Pro_sto pro_sto);
	public Pro_sto searchPro_sto(String id);
	public int countPro_sto();
	public void updatePro_sto(Pro_sto pro_sto);
	public void deletePro_sto(Pro_sto pro_sto);

}
