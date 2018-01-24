package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String url = "main.jsp";
		UserService userService = new UserServiceimpl();
		try {
			UserDTO userDto = userService.loginCheck(new UserDTO(userId, pwd));
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userDto.getUserId());
			session.setAttribute("loginName", userDto.getName());
			session.setAttribute("loginGender", userDto.getGender());
			session.setAttribute("loginPwd", userDto.getPwd());
			
			response.sendRedirect(url);
			return;
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", url);
			e.printStackTrace();
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}

}
