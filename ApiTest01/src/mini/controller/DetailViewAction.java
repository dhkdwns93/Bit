package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import mini.service.ApiService;
import mini.service.ApiServieimpl;

public class DetailViewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String movieCode = request.getParameter("code");
		String url = "detailResult.jsp";
		ApiService apiService = new ApiServieimpl();
		try {
			JSONObject jObj = apiService.detailView(movieCode);// 영화코드로 서비스의 detailView메소드 호출

			HttpSession session = request.getSession();
			session.setAttribute("detail", jObj);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "front?cmd=listView");
			url = "error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
