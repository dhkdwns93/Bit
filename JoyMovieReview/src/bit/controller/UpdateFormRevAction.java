package bit.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UpdateFormRevAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String modelNum = request.getParameter("modelNum");
//		String url="errorView/error.jsp";
//		try{
//			if(modelNum==null){
//				throw new Exception("modelNum이 없습니다.");
//			}
//			
//			Electronics elec=ReviewService.selectByModelNum(modelNum, false);//조회수증가안함.
//			request.setAttribute("elec", elec);
//			url="elecView/update.jsp";
//			
//		}catch(Exception e){
//			e.printStackTrace();
//			request.setAttribute("errorMsg", e.getMessage());
//		}
//		
//		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
