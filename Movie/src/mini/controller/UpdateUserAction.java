package mini.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

public class UpdateUserAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");

		String url = "main.jsp";

		UserService service = new UserServiceimpl();
		UserDTO userDTO = null;
		try {
			if (pwd.equals("") || pwd == null) {
				throw new SQLException("ºóÄ­À» Ã¤¿ì¼¼¿ä");
			}
			service.updateUser(new UserDTO(userId, pwd, name, gender));
		} catch (SQLException e) {

			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			url = "error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
