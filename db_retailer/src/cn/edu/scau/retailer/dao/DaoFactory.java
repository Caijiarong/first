package cn.edu.scau.retailer.dao;

public class DaoFactory {
	public static ManagerDao getManagerDao() {
		return new JdbcManagerDaoImpl();
	}
	
	public static CustomerDao getCustomerDao() {
		return new JdbcCustomerDaoImpl();
	}
	public static TypeDao getTypeDao(){
		return new JdbcTypeDaoImpl();
	}
	public static BrandDao getBrandDao(){
		return new JdbcBrandDaoImpl();
	}
	public static ProductDao getProductDao(){
		return new JdbcProductDaoImpl();
	}
	public static VendorDao getVendorDao(){
		return new JdbcVendorDaoImpl();
	}
	public static Pro_stoDao getPro_stoDao(){
		return new JdbcPro_stoDaoImpl();
	}
	public static Ven_brandDao getVen_brandDao(){
		return new JdbcVen_brandDaoImpl();
	}
	public static BillDao getBillDao(){
		return new JdbcBillDaoImpl();
	}
	public static ExtractDao getExtractDao(){
		return new JdbcExtractDaoImpl();
	}
}
