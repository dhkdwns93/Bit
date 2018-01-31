package kr.co.mlec.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/param")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		
		//post인 경우 반드시 명시
		request.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("name ="+ request.getParameter("name"));
		
		out.close();
		
	}

}
