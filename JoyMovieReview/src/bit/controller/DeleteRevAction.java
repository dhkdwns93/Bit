package bit.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteRevAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String modelNum = request.getParameter("modelNum");
//		String password = request.getParameter("password");
//		try{
//			if(modelNum==null || password == null){
//			   throw new Exception("정보가 정확하지 않습니다.");	
//			}
//			
//			ReviewService.delete(modelNum, password);
//			response.sendRedirect("elec?command=list");
//			return;
//			
//		}catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("errorMsg", e.getMessage());
//		}
//		
//		request.getRequestDispatcher("errorView/error.jsp").forward(request, response);
//
	}

}
