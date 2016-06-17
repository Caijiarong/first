package cn.edu.scau.retailer.service;

import cn.edu.scau.retailer.dao.BillDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.domain.Bill;

public class BillService {
	
	BillDao billDao = DaoFactory.getBillDao();
	
	public void addBill(Bill bill){
		billDao.addBill(bill);
	}
	
	public Bill searchBill(String id){
		Bill bill = billDao.searchBill(id);
		return bill;
	}
	
	public int countBill(){
		return billDao.countBill();
	}
	
	public void updateBill(Bill bill){
		billDao.updateBill(bill);
	}
	public void deleteBill(Bill bill){
		billDao.deleteBill(bill);
	}
	
	public void cancelBill(Bill bill){
		billDao.cancelBill(bill);	
	}
	
	public void finishBill(Bill bill){
		billDao.finishBill(bill);
	}

}
