package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Reviews;
import model.service.ReviewService;
import model.service.ReviewServiceImpl;

public class InsertReviewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String reId = request.getParameter("reId");
		String movieId = request.getParameter("movieId");
		String rePwd = request.getParameter("rePwd");
		String userId = request.getParameter("userId");
		String reTitle = request.getParameter("reTitle");
		String reStar = request.getParameter("reStar");
		String reContent = request.getParameter("reContent");
		System.out.println(reId+","+movieId+","+rePwd+","+userId+","+reTitle+","+reStar+","+reContent);
		String url = "board?command=list";
		try {//reId==null||reId.equals("")||
			if (movieId==null||movieId.equals("")||
				rePwd == null || reTitle == null || reStar == null || reContent == null || rePwd.equals("")
				|| reTitle.equals("") || reStar.equals("") || reContent.equals("")) {
				
				throw new Exception("빈칸을 채워주세요");
			}
			Reviews review = new Reviews(reId, movieId, rePwd, userId, reTitle, reStar, reContent);

			ReviewService service = new ReviewServiceImpl();
			service.insertReview(review);
			
			request.getRequestDispatcher(url).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}
}
