package cn.edu.scau.retailer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.scau.retailer.domain.Customer;
import cn.edu.scau.retailer.domain.Manager;
import cn.edu.scau.retailer.service.CustomerService;
import cn.edu.scau.retailer.service.UserException;
import cn.itcast.commons.CommonUtils;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;
    CustomerService customerService = new CustomerService();
    
	public String addCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Customer form = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		Manager manager = (Manager) request.getSession().getAttribute("session_user");
		if(manager.getUser_ID() != null)form.setManager(manager.getUser_ID());
		//System.out.println(form);
		try {
			customerService.addCustomer(form);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("customer", form);
			return "f:/addCustomer.jsp";
		}
		return "r:/mem_manager.jsp";
	}
	
	public String findCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String search  = request.getParameter("search");
		
		Customer customer = customerService.findCustomer(search);
		
		if(customer == null){
			request.setAttribute("msg", "此会员ID尚未注册");
		}else {
			request.setAttribute("customer", customer);
		}

		return "f:/updateCustomer.jsp";
	}
	
	public String updateCustomer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String choice = request.getParameter("choice");
		Customer form = CommonUtils.toBean(request.getParameterMap(), Customer.class);
		if(choice.equals("提交")){
			Manager manager = (Manager) request.getSession().getAttribute("session_user");
			if(manager.getUser_ID() != null)form.setManager(manager.getUser_ID());
			customerService.updateCustomer(form);
		}
		else{
			try {
				customerService.deleteCustomer(form);
			} catch (UserException e) {
				request.setAttribute("customer", form);
				request.setAttribute("msg", e.getMessage());
				return "f:/updateCustomer.jsp";
			}
		}
		return "f:/updateCustomer.jsp";
	}

}
