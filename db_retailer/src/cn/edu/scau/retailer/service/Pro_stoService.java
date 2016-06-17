package cn.edu.scau.retailer.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;



import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import cn.edu.scau.retailer.dao.DaoFactory;
import cn.edu.scau.retailer.dao.Pro_stoDao;
import cn.edu.scau.retailer.domain.Pro_sto;
import cn.edu.scau.retailer.domain.Product;
import cn.edu.scau.retailer.domain.Vendor;

public class Pro_stoService {
	Pro_stoDao pro_stoDao = DaoFactory.getPro_stoDao();
	
	public void addPro_sto(Pro_sto pro_sto) throws UserException{
		
		ProductService productService = new ProductService();
		VendorService vendorService = new VendorService();
		
		Product product = productService.searchProduct(pro_sto.getP_ID());
		Vendor vendor = vendorService.searchVendor(pro_sto.getV_ID());
		
		if(product == null)throw new UserException("没有该产品");
		if(vendor == null)throw new UserException("没有该供货商");
		
		pro_stoDao.addPro_sto(pro_sto);
		
	}
	
	public Pro_sto searchPro_sto(String id){
		Pro_sto pro_sto = pro_stoDao.searchPro_sto(id);
		return pro_sto;
	}
	
	public int countPro_sto(){
		return pro_stoDao.countPro_sto();
	}
	
	public void updatePro_sto(Pro_sto pro_sto){
		pro_stoDao.updatePro_sto(pro_sto);
	}
	public void deletePro_sto(Pro_sto pro_sto){
		pro_stoDao.deletePro_sto(pro_sto);
	}
	
	@SuppressWarnings("finally")
	public int countFileLine(String fileAddress){
		BufferedReader reader = null;
		int line = 0;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileAddress), "GBK"));
			while ((reader.readLine()) != null){
				line++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return line;
		}
	}
	/*
	public void addPro_stoInFile(String fileAddress, String managerName) throws UserException{
		BufferedReader reader = null;
		try {
			
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileAddress), "GBK"));
			System.out.println(fileAddress);
			String str = null;
			int count = 0;
			int line = countFileLine(fileAddress);
			while ((str = reader.readLine()) != null){
				if(count > 3 && count < line - 5){
					Pro_sto pro_sto = new Pro_sto();
					String date[] = str.split(" ");
					if(date.length == 8){
						System.out.println("***" + date[0]);
						pro_sto.setPs_ID(date[0]);
						pro_sto.setStore_ID(date[1]);
						pro_sto.setP_ID(date[2]);
						pro_sto.setV_ID(date[3]);
						pro_sto.setPrice(Double.parseDouble(date[4]));
						pro_sto.setAmount(Double.parseDouble(date[5]));
						pro_sto.setUpc_code(date[6]);
						SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
						pro_sto.setProduct_date(sim.parse(date[7]));
						pro_sto.setManager(managerName);
						
						Pro_sto protemp = pro_stoDao.searchPro_sto(pro_sto.getPs_ID());
						System.out.println(protemp + " " + pro_sto.getPs_ID());				
						ProductService productService = new ProductService();
						VendorService vendorService = new VendorService();

						if(protemp == null){
							int number = pro_stoDao.countPro_sto();
							String strnum = String.format("%5d", number).replace(" ", "0");
							pro_sto.setPs_ID(strnum);
							
							Product product = productService.searchProduct(pro_sto.getP_ID());
							Vendor vendor = vendorService.searchVendor(pro_sto.getV_ID());
							
							if(product == null)throw new UserException("上传到第" + String.valueOf(count - 2) + "行时数据出错，暂停上传");
							if(vendor == null)throw new UserException("上传到第" + String.valueOf(count - 2) + "行时数据出错，暂停上传");
							pro_stoDao.addPro_sto(pro_sto);
							
						}
						else{
							pro_sto.setAmount(pro_sto.getAmount() + protemp.getAmount());
							Product product = productService.searchProduct(pro_sto.getP_ID());
							Vendor vendor = vendorService.searchVendor(pro_sto.getV_ID());
							
							if(product == null)throw new UserException("上传到第" + String.valueOf(count - 2) + "行时数据出错，暂停上传");
							if(vendor == null)throw new UserException("上传到第" + String.valueOf(count - 2) + "行时数据出错，暂停上传");
							
							pro_stoDao.updatePro_sto(pro_sto);
						}
					}
				}	
				count++;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	*/
	
	
	
	public void addPro_stoInFile(String fileAddress, String managerName) throws UserException{
		Workbook readwb = null;
		try {
			InputStream in = new FileInputStream(fileAddress);
			readwb = Workbook.getWorkbook(in);
			Sheet readsheet = readwb.getSheet(0);
			int columns = readsheet.getColumns();
			int rows = readsheet.getRows();

			for (int i = 1; i < rows; i++) {
				
				Pro_sto pro_sto = new Pro_sto();
				
				for (int j = 0; j < columns; j++) {
					Cell cell = readsheet.getCell(j, i);
					if(j == 0)pro_sto.setPs_ID(cell.getContents());
					if(j == 1)pro_sto.setStore_ID(cell.getContents());
					if(j == 2)pro_sto.setP_ID(cell.getContents());
					if(j == 3)pro_sto.setV_ID(cell.getContents());
					if(j == 4)pro_sto.setPrice(Double.parseDouble(cell.getContents()));
					if(j == 5)pro_sto.setAmount(Double.parseDouble(cell.getContents()));
					if(j == 6)pro_sto.setUpc_code(cell.getContents());
					if(j == 7){
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
					    Date date = sdf.parse(cell.getContents());  
						pro_sto.setProduct_date(date);
						}
				}
				
				pro_sto.setManager(managerName);
				
				ProductService productService = new ProductService();
				VendorService vendorService = new VendorService();
				
				Product product = productService.searchProduct(pro_sto.getP_ID());
				Vendor vendor = vendorService.searchVendor(pro_sto.getV_ID());
				
				if(product == null)throw new UserException("第" + String.valueOf(i) + "行数据错误，上传停止");
				if(vendor == null)throw new UserException("第" + String.valueOf(i) + "行数据错误，上传停止");
				
				Pro_stoService pro_stoService = new Pro_stoService();				
				Pro_sto tempPro_sto = pro_stoService.searchPro_sto(pro_sto.getPs_ID());
				
				if(tempPro_sto == null){
					int count = pro_stoService.countPro_sto();
					String str = String.format("%5d", count).replace(" ", "0");
					pro_sto.setPs_ID(str);
					pro_stoService.addPro_sto(pro_sto);
				}
				else{
					pro_sto.setAmount(pro_sto.getAmount() + tempPro_sto.getAmount());
					pro_stoService.updatePro_sto(pro_sto);
				}
			}
		} catch (Exception e) {
			if(e.getMessage().contains("行数据错误，上传停止"))throw new UserException(e.getMessage());
			throw new UserException("文件内容或格式出错");
		} finally {
			readwb.close();
			File file = new File(fileAddress);
			file.delete();
		}
	}
}
