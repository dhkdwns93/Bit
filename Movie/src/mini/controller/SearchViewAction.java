package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import mini.service.ApiService;
import mini.service.ApiServieimpl;

public class SearchViewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		{
			request.setCharacterEncoding("UTF-8");
			String movieName = request.getParameter("movieName");
			// System.out.println(movieName);

			String url = "searchResult.jsp";
			ApiService apiService = new ApiServieimpl();
			try {
				JSONObject jSearch = apiService.searchView(movieName);
				HttpSession session = request.getSession();
				session.setAttribute("jSearch", jSearch);
				session.setAttribute("name", movieName);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("errMsg", e.getMessage());
				request.setAttribute("url", "front?cmd=listView");
				url = "error/error.jsp";
			}
			request.getRequestDispatcher(url).forward(request, response);

		}
	}

}
