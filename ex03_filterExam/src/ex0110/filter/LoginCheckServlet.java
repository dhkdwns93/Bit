package ex0110.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���ڵ�
		response.setContentType("text/html;charset=UTF-8");
		
		//���
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("userName");
		out.println("<h1>�̸� : "+userName+"</h1>");
		
	}

	
	
}
