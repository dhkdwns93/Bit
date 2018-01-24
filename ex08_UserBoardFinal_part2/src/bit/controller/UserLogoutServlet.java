package bit.controller;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class UserLogoutServlet extends HttpServlet {
  @Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.getSession().invalidate();
			
		  response.sendRedirect("index.jsp");
	}
}
