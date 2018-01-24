package bit.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bit.model.dto.UserDTO;
import bit.model.service.UserService;
import bit.model.service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String url = "index.jsp";
	
		UserService userService = new UserServiceImpl();
		try {
			
			UserDTO userDTO = userService.loginCheck(new UserDTO(userId, pwd));
			
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", userDTO.getUser_id());
			session.setAttribute("pwd", userDTO.getPwd());
			session.setAttribute("loginName", userDTO.getName());
			
			
			response.sendRedirect(url);
			return;
			
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg",e.getMessage());
			url = "errorView/error.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}








