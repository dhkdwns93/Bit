package kr.co.mlec.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class HelloServlet extends HttpServlet{

	@Override
	public void service(HttpServletRequest request, 
						HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>Hello World!!!11</h1>");
		out.close();		
	}
	
	
}
