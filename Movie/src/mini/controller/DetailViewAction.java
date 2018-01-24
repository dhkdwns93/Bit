package mini.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import mini.board.dao.BoardDAOimpl;
import mini.board.dto.ReviewDTO;
import mini.board.service.BoardService;
import mini.board.service.BoardServiceimpl;
import mini.service.ApiService;
import mini.service.ApiServieimpl;

public class DetailViewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String movieCode = request.getParameter("code");
		String url = "detailResult.jsp";
		ApiService apiService = new ApiServieimpl();
		BoardService bService= new BoardServiceimpl();
		try {
			JSONObject jObj = apiService.detailView(movieCode);// 영화코드로 서비스의 detailView메소드 호출
			List<ReviewDTO> dlist=bService.selectByMid(movieCode);
			HttpSession session = request.getSession();
			session.setAttribute("detail", jObj);
			session.setAttribute("dList", dlist);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "front?cmd=listView");
			url = "error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
