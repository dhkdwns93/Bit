package bit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bit.model.dto.Electronics;
import bit.model.service.ElecService;

public class InsertElecAction implements Action {

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����÷�ζ����� multipartRequst�ʿ�.
		 String saveDir = 
			request.getSession().getServletContext().getRealPath("/save/");
				  
	  int maxSize=1024*1024*100;//100m
	  String encoding="UTF-8";
	  
	  try{ 
		  
	  MultipartRequest m =
			  new MultipartRequest(request, saveDir, 
				  maxSize, encoding, new DefaultFileRenamePolicy());
	  
	  
	  String modelNum =  m.getParameter("model_num");
	  String modelName =  m.getParameter("model_name");
	  String price =  m.getParameter("price");
	  String description =  m.getParameter("description");
	  String password =  m.getParameter("password");  
	 
		  //�Է����� ��ȿ�� üũ
		  if(modelNum==null || modelName==null || price==null
				  || description==null ||password==null ){
			
			  throw new Exception("�Է°��� ������� �ʽ��ϴ�.");
		  }
		  
		  //System.out.println(description);
		 description = description.replaceAll("<", "&lt;");
		 // System.out.println(description);
		  
		  Electronics elec =
			new Electronics(modelNum, modelName, Integer.parseInt(price), description, password);
		  
		 if(m.getFilesystemName("file")!= null){//����÷�εǾ��ٸ�
			 elec.setfName(m.getFilesystemName("file"));
            elec.setfSize((int)m.getFile("file").length());			 
		 }
		 
		   ElecService.insert(elec);
		   response.sendRedirect("elec?command=list");
		   return;
		 
	  }catch(Exception e){
		  e.printStackTrace();
		  request.setAttribute("errorMsg", e.getMessage());
	  }
	  
	  request.getRequestDispatcher("errorView/error.jsp").forward(request, response); 

	}

}
