package bit.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/elec")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Action> map; 
	public void init(ServletConfig config) throws ServletException {
		map = (Map<String, Action>)config.getServletContext().getAttribute("map");
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command==null) command="list";
		
		//if~else if를 쓰게 된다면 일을 많이하게 되므로 Listener을 이용한다.
		map.get(command).service(request, response);
		
	}

}
