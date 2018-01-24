package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.Members;
import model.service.MemberService;
import model.service.MemberServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String url = "user/login.jsp";
		MemberService memberService = new MemberServiceImpl();
		try {
			
			Members members = memberService.loginMember(new Members(userId, userPwd));
			HttpSession session = request.getSession();
			session.setAttribute("userId", members.getUserId());
			session.setAttribute("pwd", members.getPwd());
			session.setAttribute("name", members.getName());
			
			response.sendRedirect(url);
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
