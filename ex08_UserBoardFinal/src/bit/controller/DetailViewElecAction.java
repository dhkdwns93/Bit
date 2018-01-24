package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dao.ElecDAO;
import bit.model.dao.ElecDAOImpl;
import bit.model.dto.Electronics;
import bit.model.service.ElecService;
import bit.model.service.ElecServiceImpl;

public class DetailViewElecAction implements Action {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	/*	String modelNum = request.getParameter("modelNum");
		
		String url = "read.jsp";
		
		ElecService service = new ElecServiceImpl();
		try {
		Electronics es = service.selectByModelNum(modelNum);
		request.setAttribute("elec", es);
		
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			
		}*/
	}

}
