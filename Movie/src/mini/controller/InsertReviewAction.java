package mini.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mini.board.dto.ReviewDTO;
import mini.board.service.BoardService;
import mini.board.service.BoardServiceimpl;

public class InsertReviewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "front?cmd=listView";
		String mId = request.getParameter("m_id");
		String mName=request.getParameter("m_name");
		String rePwd = request.getParameter("password");
		String userId = request.getParameter("user_id");
		String reTitle = request.getParameter("re_title");
		double reStar = Double.parseDouble(request.getParameter("re_star"));
		String reContent = request.getParameter("re_content");
		ReviewDTO reviewDTO = new ReviewDTO(mId, rePwd, userId, mName+" :: "+reTitle, reStar, reContent);
		BoardService bService = new BoardServiceimpl();

		try {
			bService.insertOne(reviewDTO);// mini.board.service ÀÇ BoardServiceimpl

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "main.jsp");
			url = "error/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
