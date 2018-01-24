package bit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dto.Electronics;
import bit.model.service.ElecService;
import bit.model.service.ElecServiceImpl;

public class SelectElecAction implements Action {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="elecView/list.jsp";
		ElecService service = new ElecServiceImpl();
		try {
			List<Electronics> list =  service.selectAll();
			request.setAttribute("list", list);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", e.getMessage());
			url="errorView/error.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

	

}
