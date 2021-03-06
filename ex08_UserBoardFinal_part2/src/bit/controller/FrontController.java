package bit.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/movie")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map<String, Action> map;
	public void init(ServletConfig config) throws ServletException {
		map= (Map<String, Action>)config.getServletContext().getAttribute("map");
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if(command==null)command="list";
		map.get(command).service(request, response);
		
		
		/*if(command.equals("select")) {
			new SelectAction().service(request, response);
		}else if(command.equals("delete")) {
			new DeleteAction().service(request, response);
		}else if(command.equals("update")) {
			new UpdateAction().service(request, response);
		}*/
		
		
		
	}

}









