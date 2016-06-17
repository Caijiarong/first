package cn.edu.scau.retailer.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends BaseServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void download(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		  try
		  {
		   String downFilename="test.xls";
		   String filepath="F:\\tmp\\";
		         response.setContentType("text/plain");
		         response.setHeader("Location",downFilename);
		         response.setHeader("Content-Disposition", "attachment; filename=" + downFilename);
		         OutputStream outputStream = response.getOutputStream();
		         @SuppressWarnings("resource")
				InputStream inputStream = new FileInputStream(filepath+downFilename);
		         byte[] buffer = new byte[1024];
		         int i = -1;
		         while ((i = inputStream.read(buffer)) != -1) {
		          outputStream.write(buffer, 0, i);
		         }
		         outputStream.flush();
		         outputStream.close();
		  }catch(FileNotFoundException e1)
		  {
		   System.out.println("没有找到您要的文件");
		  }
		  catch(Exception e)
		  {
		   System.out.println("系统错误，请及时与管理员联系");
		  }
	}

}
