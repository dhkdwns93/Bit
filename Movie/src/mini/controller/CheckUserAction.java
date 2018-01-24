package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

public class CheckUserAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String url = "main.jsp";
		UserService userService = new UserServiceimpl();
		try {
			UserDTO userDto = userService.loginCheck(new UserDTO(userId, pwd));
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userDto.getUserId());
			session.setAttribute("loginName", userDto.getName());
			response.sendRedirect(url);
			return;
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", url);
			url="error/error.jsp";
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
