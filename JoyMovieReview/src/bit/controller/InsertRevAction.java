package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dto.ReviewDTO;

public class InsertRevAction implements Action {

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
		String url = "boardView/list.jsp";
		try {
			if (reId==null||reId.equals("")||movieId==null||movieId.equals("")||
				rePwd == null || reTitle == null || reStar == null || reContent == null || rePwd.equals("")
				|| reTitle.equals("") || reStar.equals("") || reContent.equals("")) {
				
				throw new Exception("빈칸을 채워주세요");
			}
			ReviewDTO review = new ReviewDTO(reId, movieId, rePwd, userId, reTitle, reStar, reContent);

//			ReviewService service = new ReviewServiceImpl();
//			service.insertReview(review);
			
			response.sendRedirect("board?command=list");
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url = "errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
