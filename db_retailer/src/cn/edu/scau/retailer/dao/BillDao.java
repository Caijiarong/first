package cn.edu.scau.retailer.dao;

import cn.edu.scau.retailer.domain.Bill;

public interface BillDao {
	public void addBill(Bill bill);
	public Bill searchBill(String id);
	public int countBill();
	public void updateBill(Bill bill);
	public void deleteBill(Bill bill);
	public void cancelBill(Bill bill);
	public void finishBill(Bill bill);
}
