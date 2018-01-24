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
				throw new Exception("modelNum�� �ݵ�� �Է��ؾ��մϴ�.");
			}
			
		   Electronics elec=ElecService.selectByModelNum(modelNum, state);//��ȸ������
		   request.setAttribute("elec", elec); 	
		   url="elecView/read.jsp";
		}catch (Exception e) {
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
