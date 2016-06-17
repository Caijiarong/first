package cn.edu.scau.retailer.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.scau.retailer.domain.Manager;
import cn.edu.scau.retailer.service.ManagerService;
import cn.edu.scau.retailer.service.UserException;
import cn.itcast.commons.CommonUtils;

@WebServlet("/ManagerServlet")
public class ManagerServlet extends BaseServlet{
	private static final long serialVersionUID = 1L;
       
	ManagerService managerService = new ManagerService();
	
	public String login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Manager form = CommonUtils.toBean(request.getParameterMap(), Manager.class);
		
		String session_verifyCode = (String)request.getSession().getAttribute("session_vCode");
		
		/**
		 * 输入信息的检查
		 */
		if(form.getUser_ID() == ""){
			request.setAttribute("msg", "账号不能为空");
			request.setAttribute("user", form);
			return "f:/login.jsp";
		}
		
		if(form.getPasswd() == ""){
			request.setAttribute("msg", "密码不能为空");
			request.setAttribute("user", form);
			return "f:/login.jsp";
		}
		
		if(!form.getVerifyCode().equalsIgnoreCase(session_verifyCode)){
			request.setAttribute("msg", "验证码错误");
			request.setAttribute("user", form);
			return "f:/login.jsp";
		}
		
		/**
		 * 登陆操作
		 */
		Manager manager;
		try {
			manager = managerService.login(form);
			request.getSession().setAttribute("session_user", manager);
		} catch (UserException e) {
			// TODO Auto-generated catch block
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", form);
			return "f:/login.jsp";
		}
		if(manager.getGrade() == 0){
			return "r:/super_manager.jsp";
		}
		else if (manager.getGrade() == 1) {
			return "r:/in_manager.jsp";
			
		}else if(manager.getGrade() == 2){
			return "r:/out_manager.jsp";
		}
		else{
			return "r:/mem_manager.jsp";
		}

	}
	
	public String logOut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.getSession().setAttribute("session_user", null);
		return "r:/index.jsp";

	}

}
