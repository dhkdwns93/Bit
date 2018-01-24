package mini.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

public class DeleteUserAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String url = "main.jsp";

		UserService service = new UserServiceimpl();

		try {
			service.deleteUser(userId,pwd);
			HttpSession session=request.getSession();
			session.invalidate();
			response.sendRedirect(url);
		} catch (SQLException e) {

			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "user/delete.jsp");
			url = "error/error.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
