package soom.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import soom.service.ApiService;
import soom.service.ApiServieimpl;
import soom.util.ApiConnection;

@WebServlet("/searchView")
public class SearchViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String movieName = request.getParameter("movieName");
		// System.out.println(movieName);

		String url = "searchResult.jsp";
		ApiService service = new ApiServieimpl();
		try {
			JSONObject jSearch = service.searchView(movieName);
			HttpSession session = request.getSession();
			session.setAttribute("jSearch", jSearch);
			session.setAttribute("name", movieName);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "listView");
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
