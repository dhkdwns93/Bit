package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dto.Electronics;
import bit.model.service.ElecService;

public class DetailViewElecAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		boolean state=true;
		if(flag!=null)state=false;
		
		String url="errorView/error.jsp";
		String modelNum = request.getParameter("modelNum");
		try{
			if(modelNum==null){
				throw new Exception("modelNum은 반드시 입력해야합니다.");
			}
			
		   Electronics elec=ElecService.selectByModelNum(modelNum, state);//조회수증가
		   request.setAttribute("elec", elec); 	
		   url="elecView/read.jsp";
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
