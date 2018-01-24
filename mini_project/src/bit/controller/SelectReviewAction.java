package bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Reviews;
import model.service.ReviewService;
import model.service.ReviewServiceImpl;

public class SelectReviewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "errorView/error.jsp";
		ReviewService service = new ReviewServiceImpl();
		try {
			List<Reviews> list  = service.selectAllReview();
			request.setAttribute("list", list);
			url="boardView/list.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
