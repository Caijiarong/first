package cn.edu.scau.retailer.servlet;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.edu.scau.retailer.domain.Brand;
import cn.edu.scau.retailer.domain.Manager;
import cn.edu.scau.retailer.domain.Pro_sto;
import cn.edu.scau.retailer.domain.Product;
import cn.edu.scau.retailer.domain.Type;
import cn.edu.scau.retailer.domain.Ven_brand;
import cn.edu.scau.retailer.domain.Vendor;
import cn.edu.scau.retailer.service.BrandService;
import cn.edu.scau.retailer.service.Pro_stoService;
import cn.edu.scau.retailer.service.ProductService;
import cn.edu.scau.retailer.service.TypeService;
import cn.edu.scau.retailer.service.UserException;
import cn.edu.scau.retailer.service.Ven_brandService;
import cn.edu.scau.retailer.service.VendorService;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class InManagerServlet
 */


@WebServlet("/InManagerServlet")
public class InManagerServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	TypeService typeService = new TypeService();
	public String choice(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String c = request.getParameter("c");
		request.setAttribute("c", c);
		return "f:/in_manager.jsp";
	}
	
	public String addType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Type type = CommonUtils.toBean(request.getParameterMap(), Type.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		
		int i = typeService.countType();
		String str = String.format("%5d", i).replace(" ", "0");
		type.setT_ID(str);
		type.setManager(manager.getUser_ID());
		
		System.out.println(type);
		typeService.addType(type);
		request.setAttribute("c", "type");
		return "f:/in_manager.jsp";
	}
	
	public String searchType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("search");
		Type type = typeService.searchType(id);
		request.setAttribute("type", type);
		request.setAttribute("c", "type");
		return "f:/in_manager.jsp";
	}
	
	public String updateType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		Type type = CommonUtils.toBean(request.getParameterMap(), Type.class);
		if(choice.equals("提交")){
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			if(manager.getUser_ID() != null)type.setManager(manager.getUser_ID());
			typeService.updateType(type);
		}
		else{
			typeService.deleteType(type);
		}
		request.setAttribute("c", "type");
		return "f:/in_manager.jsp";
	}
	
	private BrandService brandService = new BrandService();
	
	public String addBrand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Brand brand = CommonUtils.toBean(request.getParameterMap(), Brand.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		
		int i = brandService.countBrand();
		String str = String.format("%5d", i).replace(" ", "0");
		brand.setBrand_ID(str);
		brand.setManager(manager.getUser_ID());
		brandService.addBrand(brand);
		request.setAttribute("c", "brand");
		return "f:/in_manager.jsp";
	}
	
	public String searchBrand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("search");
		Brand brand = brandService.searchBrand(id);
		request.setAttribute("brand", brand);
		request.setAttribute("c", "brand");
		return "f:/in_manager.jsp";
	}
	
	public String updateBrand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		Brand brand = CommonUtils.toBean(request.getParameterMap(), Brand.class);
		if(choice.equals("提交")){
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			if(manager.getUser_ID() != null)brand.setManager(manager.getUser_ID());

			brandService.updateBrand(brand);
		}
		else{
			try {
				brandService.deleteBrand(brand);
			} catch (UserException e) {
				request.setAttribute("brand", brand);
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("c", "brand");
				return "f:/in_manager.jsp";
			}
		}
		request.setAttribute("c", "brand");
		return "f:/in_manager.jsp";
	}
	
	private ProductService productService = new ProductService();
	
	public String addProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product product = CommonUtils.toBean(request.getParameterMap(), Product.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		
		int i = productService.countProduct();
		String str = String.format("%5d", i).replace(" ", "0");
		product.setP_ID(str);
		if(manager != null)product.setManager(manager.getUser_ID());
		try {
			productService.addProduct(product);
		} catch (UserException e) {
			String msg = e.getMessage();
			request.setAttribute("msg", msg);
			request.setAttribute("product", product);
			request.setAttribute("c", "addproduct");
			return "f:/in_manager.jsp";
		}
		request.setAttribute("c", "product");
		return "f:/in_manager.jsp";
	}
	
	public String searchProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("search");
		Product product = productService.searchProduct(id);
		request.setAttribute("product", product);
		request.setAttribute("c", "product");
		return "f:/in_manager.jsp";
	}
	
	public String updateProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		Product product = CommonUtils.toBean(request.getParameterMap(), Product.class);
		if(choice.equals("提交")){
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			if(manager.getUser_ID() != null)product.setManager(manager.getUser_ID());

			try {
				productService.updateProduct(product);
			} catch (UserException e) {
				String msg = e.getMessage();
				request.setAttribute("msg", msg);
				request.setAttribute("product", product);
				request.setAttribute("c", "product");
				return "f:/in_manager.jsp";
			}
		}
		else{
			productService.deleteProduct(product);
		}
		request.setAttribute("c", "product");
		return "f:/in_manager.jsp";
	}
	
	private VendorService vendorService = new VendorService();
	
	public String addVendor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Vendor vendor = CommonUtils.toBean(request.getParameterMap(), Vendor.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		
		int i = vendorService.countVendor();
		String str = String.format("%5d", i).replace(" ", "0");
		vendor.setV_ID(str);
		vendor.setManager(manager.getUser_ID());
		vendorService.addVendor(vendor);
		request.setAttribute("c", "vendor");
		return "f:/in_manager.jsp";
	}
	
	public String searchVendor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("search");
		Vendor vendor = vendorService.searchVendor(id);
		System.out.println(vendor);
		request.setAttribute("vendor", vendor);
		request.setAttribute("c", "vendor");
		return "f:/in_manager.jsp";
	}
	
	public String updateVendor(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		Vendor vendor = CommonUtils.toBean(request.getParameterMap(), Vendor.class);
		if(choice.equals("提交")){
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			if(manager.getUser_ID() != null)vendor.setManager(manager.getUser_ID());
			vendorService.updateVendor(vendor);
		}
		else{
			vendorService.deleteVendor(vendor);
		}
		request.setAttribute("c", "vendor");
		return "f:/in_manager.jsp";
	}
	
	private Pro_stoService pro_stoService = new Pro_stoService();
	public String addPro_sto(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//String file = request.getParameter("file");
		//System.out.println(file);


			Pro_sto pro_sto = CommonUtils.toBean(request.getParameterMap(), Pro_sto.class);
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			Pro_sto tempPro_sto = null;
		
			if(pro_sto.getPs_ID() != null){
				tempPro_sto = pro_stoService.searchPro_sto(pro_sto.getPs_ID());
			}
		
			if(pro_sto.getPs_ID() == null || pro_sto.getPs_ID().isEmpty() || tempPro_sto == null){
				int i = pro_stoService.countPro_sto();
				String str = String.format("%5d", i).replace(" ", "0");
				pro_sto.setPs_ID(str);
				pro_sto.setManager(manager.getUser_ID());
				try {
					pro_stoService.addPro_sto(pro_sto);
				} catch (UserException e) {
					request.setAttribute("pro_sto", pro_sto);
					request.setAttribute("msg", e.getMessage());
					request.setAttribute("c", "pro_sto");
					return "f:/in_manager.jsp";
				}
			}
			else{
				tempPro_sto.setAmount(tempPro_sto.getAmount() + pro_sto.getAmount());
				System.out.println(tempPro_sto);
				pro_stoService.updatePro_sto(tempPro_sto);
			}

		request.setAttribute("c", "pro_sto");
		return "f:/in_manager.jsp";
	}
	
	private Ven_brandService ven_brandService = new Ven_brandService();
	
	public String addVen_brand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ven_brand ven_brand = CommonUtils.toBean(request.getParameterMap(), Ven_brand.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		ven_brand.setManager(manager.getUser_ID());
		//System.out.println(ven_brand);
		try {
			ven_brandService.addVen_brand(ven_brand);
		} catch (UserException e) {
			Vendor vendor = vendorService.searchVendor(ven_brand.getV_ID());
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("vendor", vendor);
			request.setAttribute("c", "vendor");
			return "f:/in_manager.jsp";
		}
		Vendor vendor = vendorService.searchVendor(ven_brand.getV_ID());
		request.setAttribute("vendor", vendor);
		request.setAttribute("c", "vendor");
		return "f:/in_manager.jsp";
	}
	/*
	public String searchVen_brand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("search");
		Ven_brand ven_brand = ven_brandService.searchVen_brand(id);
		System.out.println(ven_brand);
		request.setAttribute("ven_brand", ven_brand);
		request.setAttribute("c", "ven_brand");
		return "f:/in_manager.jsp";
	}
	*/
	public String updateVen_brand(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Ven_brand ven_brand = CommonUtils.toBean(request.getParameterMap(), Ven_brand.class);
		
		ven_brandService.deleteVen_brand(ven_brand);

		request.setAttribute("c", "vendor");
		return "f:/in_manager.jsp";
	}

	public String uploadFile(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 得到上传文件的保存目录，将上传的文件存放于WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
		//String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
		String filename = null;
		String savePath = "F:/tmp";
		System.out.println(savePath);
		// 判断上传文件的保存目录是否存在
		File file = new File(savePath);
		if (!file.exists() && !file.isDirectory()) {
			System.out.println(savePath + "目录不存在，需要创建");
			// 创建目录
			file.mkdir();
		}
		// 消息提示
		String message = "";
		try {
			// 使用Apache文件上传组件处理文件上传步骤：
			// 1、创建一个DiskFileItemFactory工厂
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 2、创建一个文件上传解析器
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 解决上传文件名的中文乱码
			upload.setHeaderEncoding("UTF-8");
			// 3、判断提交上来的数据是否是上传表单的数据
			if (!ServletFileUpload.isMultipartContent(request)) {
				// 按照传统方式获取数据
				return null;
			}
			// 4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				// 如果fileitem中封装的是普通输入项的数据
				if (item.isFormField()) {
					String name = item.getFieldName();
					// 解决普通输入项的数据的中文乱码问题
					String value = item.getString("UTF-8");
					// value = new String(value.getBytes("iso8859-1"),"UTF-8");
					System.out.println(name + "=" + value);
				} else {// 如果fileitem中封装的是上传文件
						// 得到上传的文件名称，
					filename = item.getName();
					System.out.println(filename);
					if (filename == null || filename.trim().equals("")) {
						continue;
					}
					// 注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：
					// c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
					// 处理获取到的上传文件的文件名的路径部分，只保留文件名部分
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					// 获取item中的上传文件的输入流
					InputStream in = item.getInputStream();
					// 创建一个文件输出流
					FileOutputStream out = new FileOutputStream(savePath + "\\"
							+ filename);
					// 创建一个缓冲区
					byte buffer[] = new byte[1024];
					// 判断输入流中的数据是否已经读完的标识
					int len = 0;
					// 循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
					while ((len = in.read(buffer)) > 0) {
						// 使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\"
						// + filename)当中
						out.write(buffer, 0, len);
					}
					// 关闭输入流
					in.close();
					// 关闭输出流
					out.close();
					// 删除处理文件上传时生成的临时文件
					item.delete();
					message = "文件上传成功！";
				}
			}
		} catch (Exception e) {
			message = "文件上传失败！";
			e.printStackTrace();

		}
		
		System.out.println(message);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		if(manager != null)
			try {
				pro_stoService.addPro_stoInFile(savePath + "/" + filename, manager.getUser_ID());
			} catch (UserException e) {
				request.setAttribute("msg", e.getMessage());
				request.setAttribute("c", "pro_sto");
				return "f:/in_manager.jsp";
			}
		request.setAttribute("c", "pro_sto");
		return "f:/in_manager.jsp";
	}


}
