package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.ReviewDao;
import model.dao.ReviewDaoImpl;
import model.dto.Reviews;
import model.service.ReviewService;
import model.service.ReviewServiceImpl;

public class UpdateFormReviewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String url = "boardView/update.jsp";
		String userId = request.getParameter("userId");
		System.out.println(userId);

		ReviewService service = new ReviewServiceImpl();
		Reviews review = null;
		try {
			review = service.selectReviewUserId(userId);
			if (!review.getUserId().equals(userId)) {
				throw new Exception("작성하신 게시물이 아닙니다.");
			}
//			request.getRequestDispatcher(url).forward(request, response);
			response.sendRedirect(url);
			return;

		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
