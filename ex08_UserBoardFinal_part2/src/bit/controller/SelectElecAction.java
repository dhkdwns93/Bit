package bit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dto.Electronics;
import bit.model.service.ElecService;

public class SelectElecAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="errorView/error.jsp";
		try{	
		 List<Electronics> list = ElecService.selectAll();
		 request.setAttribute("list", list);//viewpage에서 ${list}
		 url="elecView/list.jsp";
//		 ReviewService service = new ReviewServiceImpl();
		 
		 
		}catch(SQLException e){
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());//뷰페이지 ${errorMsg}
		}
		
		 request.getRequestDispatcher(url).forward(request, response);

	}

}




