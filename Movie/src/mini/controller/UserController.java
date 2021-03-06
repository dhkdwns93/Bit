package mini.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> map;

	@SuppressWarnings("unchecked")
	@Override
	public void init(ServletConfig config) throws ServletException {

		map = (Map<String, Action>) config.getServletContext().getAttribute("usermap");

	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command = request.getParameter("cmd");
		if (command == null) {
			request.getRequestDispatcher("front?cmd=listView").forward(request, response);
			return;
		}
		map.get(command).service(request, response);

	}

}
