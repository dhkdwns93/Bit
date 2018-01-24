package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

public class InsertUserAction implements Action {

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
			if (userId == null || userId.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("")
					|| gender == null || gender.equals("")) {
				throw new Exception("后沫阑 盲况林技夸");
			}
			userDTO = new UserDTO(userId, pwd, name, gender);
			service.insertUser(userDTO);
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			url = "error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
