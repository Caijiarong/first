package cn.edu.scau.retailer.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import cn.edu.scau.retailer.domain.Product;
import cn.edu.scau.retailer.service.BillService;
import cn.edu.scau.retailer.service.ProductService;

@WebServlet("/Bill_listManager")
public class Bill_listServlet extends BaseServlet{
	
	/** 
	 * @Fields serialVersionUID : 
	*/ 
	private static final long serialVersionUID = 1L;
	
	BillService billService = new BillService();

	public void getMessage(HttpServletRequest request, HttpServletResponse response){
		
		ProductService productService = new ProductService();
		String temp = request.getParameter("param");		//获取传过来的参数
		JSONObject json = JSONObject.fromObject(temp);		//将参数转成JSON
		Product product = productService.searchProduct(json.getString("param1"));
		
		
		sendMessageForObject(response, product);						//返回前端的数据
	}
}
