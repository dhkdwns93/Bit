package mini.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/updateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		String url = "main.jsp";
		
		UserService service = new UserServiceimpl();
		UserDTO userDTO = null;
		try {
			if(pwd.equals("")||pwd==null) {
				throw new SQLException("빈칸을 채우세요");
			}
			System.out.println("수tothe정");
			service.updateUser(new UserDTO(userId, pwd, name, gender));
			System.out.println("완료!");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url="error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
