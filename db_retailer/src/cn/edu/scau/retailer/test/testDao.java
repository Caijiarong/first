package cn.edu.scau.retailer.test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import cn.edu.scau.retailer.dao.CustomerDao;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.JdbcCustomerDaoImpl;
import cn.edu.scau.retailer.dao.ManagerDao;
import cn.edu.scau.retailer.domain.Bill;
import cn.edu.scau.retailer.domain.Brand;
import cn.edu.scau.retailer.domain.Customer;
import cn.edu.scau.retailer.domain.Manager;
import cn.edu.scau.retailer.domain.Pro_sto;
import cn.edu.scau.retailer.domain.Product;
import cn.edu.scau.retailer.domain.Type;
import cn.edu.scau.retailer.domain.Ven_brand;
import cn.edu.scau.retailer.domain.Vendor;
import cn.edu.scau.retailer.service.BillService;
import cn.edu.scau.retailer.service.BrandService;
import cn.edu.scau.retailer.service.ExtractService;
import cn.edu.scau.retailer.service.ManagerService;
import cn.edu.scau.retailer.service.Pro_stoService;
import cn.edu.scau.retailer.service.ProductService;
import cn.edu.scau.retailer.service.TypeService;
import cn.edu.scau.retailer.service.UserException;
import cn.edu.scau.retailer.service.Ven_brandService;
import cn.edu.scau.retailer.service.VendorService;

public class testDao {
	

	public void testuserDao(){
		ManagerDao managerDao = DaoFactory.getManagerDao();
		Manager manager = managerDao.findNum("123456");
		System.out.println(manager);
	}

	public void testCustomerService(){
		Customer customer = new Customer();
		CustomerDao customerDao = new JdbcCustomerDaoImpl();
		customer.setC_ID("123");
		customer.setGender(true);
		customer.setManager("member");
		customer.setName("张三");
		customer.setPhone("111222333444");
		customer.setAddress("你好厉害");
		//cs.addCustomer(customer);
		customerDao.addCustomer(customer);
	}

	public void testFindCustomer(){
		CustomerDao customerDao = new JdbcCustomerDaoImpl();
		Customer customer = customerDao.findCustomer("123456");
		System.out.println(customer);
	}

	public void testUpdateCustomer(){
		Customer customer = new Customer();
		CustomerDao customerDao = new JdbcCustomerDaoImpl();
		customer.setC_ID("123456");
		customer.setGender(true);
		customer.setManager("root");
		customer.setName("李四");
		customer.setPhone("123467890");
		customer.setAddress("你好厉害");
		//cs.addCustomer(customer);
		System.out.println(customer);
		customerDao.updateCustomer(customer);
	}

	public void deleteCustomer() throws SQLException{
		Customer customer = new Customer();
		CustomerDao customerDao = new JdbcCustomerDaoImpl();
		customer.setC_ID("123");
		customer.setGender(true);
		customer.setManager("member");
		customer.setName("张三");
		customer.setPhone("111222333444");
		customer.setAddress("你好厉害");
		
		customerDao.deleteCustomer(customer);
	}

	public void typeServiceTest(){
		TypeService typeService = new TypeService();
		Type type1 = new Type();
		type1.setT_ID("1234567");
		type1.setName("苏打水");
		type1.setSize("1L");
		type1.setManager("in");
		typeService.addType(type1);
		
		Type type2 = typeService.searchType("1234567");
		
		System.out.println(type2);
		
	}

	public void countType(){
		TypeService typeService = new TypeService();
		System.out.println(typeService.countType());
	}
	

	public void updateType(){
		TypeService typeService = new TypeService();
		Type type1 = new Type();
		type1.setT_ID("1234");
		type1.setName("苏打水");
		type1.setSize("23L");
		type1.setManager("in");
		typeService.updateType(type1);
	}

	public void testBrand(){
		BrandService brandService = new BrandService();
		Brand brand = new Brand();
		brand.setBrand_ID("123");
		brand.setName("哈哈哈哈");
		brand.setManager("in");
		brandService.addBrand(brand);
		
		Brand brand2 = brandService.searchBrand("123");
		System.out.println(brand2);
	}

	public void testBrand1() throws UserException{
		BrandService brandService = new BrandService();
		Brand brand = new Brand();
		brand.setBrand_ID("123");
		brand.setName("呵呵呵");
		brand.setManager("in");
		brandService.updateBrand(brand);
		Brand brand2 = brandService.searchBrand("123");
		System.out.println(brand2);
		
		brandService.deleteBrand(brand2);
	}
	
	@Test	
	public void testProduct() throws UserException{
		ProductService productService = new ProductService();
		Product product = new Product();
		product.setP_ID("123456");
		product.setBrand_ID("001");
		product.setT_ID("001");
		product.setMade_in("China");
		product.setManager("in");
		product.setManufacturer("我的工厂");
		product.setName("可口可乐");
		product.setUnit("个");
		product.setDiscount(0.5);
		product.setOri_price(100.12);
		productService.addProduct(product);
		
		Product product2 = productService.searchProduct("123456");
		System.out.println(product2);
		
		Product product3 = new Product();
		product3.setP_ID("123456");
		product3.setBrand_ID("001");
		product3.setT_ID("001");
		product3.setMade_in("English");
		product3.setManager("in");
		product3.setManufacturer("钢铁侠的工厂");
		product3.setName("百事可乐");
		product3.setUnit("个");
		product3.setDiscount(0.8);
		product3.setOri_price(10.25);
		
		productService.updateProduct(product3);
		Product product4 = productService.searchProduct("123456");
		System.out.println(product4);
	}

	public void testVendor(){
		VendorService vendorService = new VendorService();
		Vendor vendor = new Vendor();
		vendor.setV_ID("123");
		vendor.setName("我的供货商");
		vendor.setAddress("广州");
		vendor.setManager("in");
		
		vendorService.addVendor(vendor);
		
		Vendor vendor2 = vendorService.searchVendor("123");
		System.out.println(vendor2);
		
		Vendor vendor3 = new Vendor();
		vendor3.setV_ID("123");
		vendor3.setName("ni的供货商");
		vendor3.setAddress("guang州");
		vendor3.setManager("in");
		
		vendorService.updateVendor(vendor3);
		Vendor vendor4 = vendorService.searchVendor("123");
		System.out.println(vendor4);
		vendorService.deleteVendor(vendor4);
		
	}
	

	public void testPro_sto() throws UserException{
		Pro_stoService pro_stoService = new Pro_stoService();
		Pro_sto pro_sto = new Pro_sto();
		
		pro_sto.setPs_ID("123");
		pro_sto.setP_ID("00001");
		pro_sto.setV_ID("00000");
		pro_sto.setUpc_code("132456");
		pro_sto.setAmount(23.56);
		pro_sto.setManager("in");
		pro_sto.setProduct_date(new Date());
		pro_sto.setPrice(12.3);
		pro_sto.setStore_ID("123");
		
		pro_stoService.addPro_sto(pro_sto);
		
		Pro_sto pro_sto2 = pro_stoService.searchPro_sto("123");
		System.out.println(pro_sto2);
		
		Pro_sto pro_sto3 = new Pro_sto();
		pro_sto3.setPs_ID("123");
		pro_sto3.setP_ID("00001");
		pro_sto3.setV_ID("00000");
		pro_sto3.setUpc_code("9132456");
		pro_sto3.setAmount(923.56);
		pro_sto3.setManager("in");
		pro_sto3.setProduct_date(new Date());
		pro_sto3.setPrice(912.3);
		pro_sto3.setStore_ID("123");
		
		pro_stoService.updatePro_sto(pro_sto3);
		
		Pro_sto pro_sto4 = pro_stoService.searchPro_sto("123");
		System.out.println(pro_sto4);
		
		pro_stoService.deletePro_sto(pro_sto4);
	}
	
	public void testVen_brand() throws UserException{
		Ven_brandService ven_brandService = new Ven_brandService();
		Ven_brand ven_brand = new Ven_brand();
		ven_brand.setV_ID("001");
		ven_brand.setBrand_ID("001");
		ven_brand.setManager("in");
		
		ven_brandService.addVen_brand(ven_brand);
		
		Ven_brand ven_brand2 = ven_brandService.searchVen_brand("001", "001");
		System.out.println(ven_brand2);
		
		ven_brandService.deleteVen_brand(ven_brand2);
		
	}
	
	public void testBill(){
		BillService billService = new BillService();
		Bill bill = new Bill();
		bill.setBill_ID("001");
		bill.setStore_ID("001");
		bill.setC_ID("002");
		bill.setTrade_style("w,1234165");
		bill.setManager("in");
		
		billService.addBill(bill);
		Bill bill2 = billService.searchBill("001");
		System.out.println(bill2);
		
		billService.finishBill(bill2);
		Bill bill3 = billService.searchBill("001");
		System.out.println(bill3);
		
		billService.cancelBill(bill3);
		Bill bill4 = billService.searchBill("001");
		System.out.println(bill4);
		
		Bill bill5 = new Bill();
		bill5.setBill_ID("001");
		bill5.setStore_ID("001");
		bill5.setC_ID("002");
		bill5.setTrade_style("z,987654");
		bill5.setManager("in");
		billService.updateBill(bill5);
		Bill bill6 = billService.searchBill("001");
		System.out.println(bill6);
		
	}

	public void testRead() throws UserException{
		Pro_stoService pro_stoService = new Pro_stoService();
		pro_stoService.addPro_stoInFile("F:/tmp/date.xls", "in");
	}
	
	
	public void testManager() throws UserException{
		ManagerService managerService = new ManagerService();
		
		Manager manager = new Manager();
		manager.setUser_ID("manager1");
		manager.setPasswd("haha");
		manager.setGrade(2);
		manager.setManager("in");
		
		managerService.addManager(manager);
		
		Manager manager2 = managerService.searchManager("manager1");
		System.out.println(manager2);
		
		Manager manager3 = new Manager();
		manager3.setUser_ID("manager1");
		manager3.setPasswd("hoho");
		manager3.setGrade(0);
		manager3.setManager("in");
		
		managerService.updateManager(manager3);
		
		Manager manager4 = managerService.searchManager("manager1");
		System.out.println(manager4);
		
		managerService.deleteManager(manager4);
		
	}

	public void testExtract(){
		ExtractService es = new ExtractService();
		es.extractAll("type");
	}

	public void testExtratSQL(){
		ExtractService es = new ExtractService();
		es.extract("SELECT * FROM product,pro_sto WHERE product.p_ID=pro_sto.p_ID");
	}

}
