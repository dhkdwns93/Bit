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

/**
 * Servlet implementation class DetailViewServlet
 */
@WebServlet("/detailView")
public class DetailViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String movieCode = request.getParameter("code");
		String url = "detailResult.jsp";
		ApiService service = new ApiServieimpl();
		try {
			JSONObject jObj = service.detailView(movieCode);

			HttpSession session = request.getSession();
			session.setAttribute("detail", jObj);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "listView");
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
