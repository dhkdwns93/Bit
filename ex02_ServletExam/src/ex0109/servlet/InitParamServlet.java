package ex0109.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.ContextConfig;

public class InitParamServlet extends HttpServlet{
	String addr;
	String fileName;
	String message;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		addr = config.getInitParameter("addr");
		fileName = config.getInitParameter("fileName");
		
		
		
		//context-param가져오기
		ServletContext application = config.getServletContext();
		message = application.getInitParameter("message");
		
		System.out.println("addr : "+addr);
		System.out.println("fileName : "+ fileName);
		System.out.println("message : "+ message);
	
	}
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service addr : "+addr);
		System.out.println("service fileName :"+fileName);
		System.out.println("service message : "+message);
	}
}
