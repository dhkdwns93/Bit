package soom.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;

import soom.service.ApiService;
import soom.service.ApiServieimpl;

@WebServlet("/listView")
public class ListViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "viewByRank.jsp";
		ApiService service = new ApiServieimpl();
		try {
			JSONArray jArr = service.listView();

			HttpSession session = request.getSession();
			session.setAttribute("jArr", jArr);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "listView");
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
