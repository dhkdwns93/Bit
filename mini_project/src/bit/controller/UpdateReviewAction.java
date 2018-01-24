package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.Reviews;
import model.service.ReviewService;
import model.service.ReviewServiceImpl;

public class UpdateReviewAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "boardView/list.jsp";
		String reId = request.getParameter("reId");
		String userId = request.getParameter("userId");
		String movieId = request.getParameter("movieId");
		String rePwd = request.getParameter("rePwd");
		String reTitle = request.getParameter("reTitle");
		String reStar = request.getParameter("reStar");
		String reContent = request.getParameter("reContnent");
		
		ReviewService service = new ReviewServiceImpl();
		Reviews review = null; 
		try {
			if(reId.equals("")||reId==null||userId.equals("")||userId==null||movieId==null||movieId.equals("")
					||rePwd.equals("")||rePwd==null||reTitle.equals("")||reTitle==null||reStar.equals("")||reStar==null||
					reContent.equals("")||reContent==null) {
				throw new Exception("빈칸을 없애주세요");
			}
			
			service.updateReivew(new Reviews(reId, movieId, rePwd, userId, reTitle, reStar, reContent));
			
			request.getRequestDispatcher(url).forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
