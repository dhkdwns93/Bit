package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.user.dto.UserDTO;
import mini.user.service.UserService;
import mini.user.service.UserServiceimpl;

/**
 * Servlet implementation class JoinUserServlet
 */
@WebServlet("/joinUserServlet")
public class JoinUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String url = "user/JoinOk.jsp?userId=" + userId;
		
		
		UserService service = new UserServiceimpl();
		
		UserDTO userDTO = null;
		
		try {
			/*
			 * if(!userDTO.getUserId().equals(userId)||!userDTO.getPwd().equals(pwd)||userId
			 * .isEmpty()||pwd.isEmpty()) { throw new Exception("ID와 PWD를 다시 한 번 확인해주세요"); }
			 */
			
			
			if (userId == null || userId.equals("") || pwd == null || pwd.equals("") || name == null || name.equals("")
					|| gender == null || gender.equals("")) {
				throw new Exception("빈칸을 채워주세요");
			}
			
			
			userDTO = new UserDTO(userId, pwd, name, gender);
			System.out.println("슬슬 등록합니다?");
			service.insertUser(userDTO);
			System.out.println("등록된거니??");
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
