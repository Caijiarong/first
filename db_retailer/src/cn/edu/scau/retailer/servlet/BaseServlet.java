package cn.edu.scau.retailer.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * BaseServlet用来作为其它Servlet的父类
 * 
 * @author qdmmy6
 * 
 *一个类多个请求处理方法，每个请求处理方法的原型与service相同！ 原型 = 返回值类型 + 方法名称 + 参数列表
 */
@SuppressWarnings("serial")
public class BaseServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//处理响应编码
		request.setCharacterEncoding("UTF-8");
		
		/**
		 * 1. 获取method参数，它是用户想调用的方法 2. 把方法名称变成Method类的实例对象 3. 通过invoke()来调用这个方法
		 */
		String methodName = request.getParameter("method");
		Method method = null;
		/**
		 * 2. 通过方法名称获取Method对象
		 */
		try {
			method = this.getClass().getMethod(methodName,
					HttpServletRequest.class, HttpServletResponse.class);
		} catch (Exception e) {
			throw new RuntimeException("您要调用的方法：" + methodName + "它不存在！", e);
		}
		
		/**
		 * 3. 通过method对象来调用它
		 */
		try {
			String result = (String)method.invoke(this, request, response);
			if(result != null && !result.trim().isEmpty() && !result.equals("***")) {//如果请求处理方法返回不为空
				int index = result.indexOf(":");//获取第一个冒号的位置
				if(index == -1) {//如果没有冒号，使用转发
					request.getRequestDispatcher(result).forward(request, response);
				} else {//如果存在冒号
					String start = result.substring(0, index);//分割出前缀
					String path = result.substring(index + 1);//分割出路径
					if(start.equals("f")) {//前缀为f表示转发
						request.getRequestDispatcher(path).forward(request, response);
					} else if(start.equals("r")) {//前缀为r表示重定向
						response.sendRedirect(request.getContextPath() + path);
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 辅助处理返回信息
	 * @Title: sendMessage 
	 * @param response
	 * @param message 
	 * @return void 
	 * @throws
	 */
	protected void sendMessage(HttpServletResponse response, final String message){
		 response.setContentType("text/html;charset=UTF-8");
	        PrintWriter writer;
	        try {
	            writer = response.getWriter();
	            writer.write(message);
	            writer.close();
	        } catch (IOException e) {
	            
	        }
	}
	
	/**
	 * 将对象转换为JSON格式
	 * @Title: sendMessageForObject 
	 * @param response
	 * @param object 
	 * @return void 
	 * @throws
	 */
	protected void sendMessageForObject(HttpServletResponse response, final Object object){
		JSONObject json = new JSONObject();
		if (isPrimitiveType(object)) {
            json.put("value", object.toString());
        } else {
            try {
                json.put("value", JSONObject.fromObject(object));
            } catch (Exception e) {
                json.put("value", "转换返回数据为JSON格式出错");
            }
        }
        sendMessage(response, json.toString());
	}
	
	/**
	 * 判断对象是否是原始类型
	 * @Title: isPrimitiveType 
	 * @param object
	 * @return 
	 * @return boolean 
	 * @throws
	 */
	private boolean isPrimitiveType(Object object){
		Class clazz = object.getClass();
		if(String.class.equals(clazz) || Boolean.class.equals(clazz) || Number.class.equals(clazz)){
			return true;
		}
		return false;
	}
}
