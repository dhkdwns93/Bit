package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.model.dto.Electronics;
import bit.model.service.ElecService;

public class UpdateElecAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="errorView/error.jsp";
		
		//�Ѿ���� ���� �ޱ�
		String modelNum = request.getParameter("modelNum");
		String modelName = request.getParameter("model_name");
		String price =  request.getParameter("price");
		String description = request.getParameter("description");
		String password = request.getParameter("password");
		
		//��ȿ�� �˻�
		try{
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
		  }
		  
		  Electronics elec = new Electronics(modelNum, modelName, 
				    Integer.parseInt(price), description, password);
		  ElecService.update(elec); 
		  url="elec?command=detailView&flag=1";
		}catch(Exception e){
			request.setAttribute("errorMsg", e.getMessage());
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
