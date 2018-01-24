package ex0110.upload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/downList")
public class DownListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���� �����Ų �����͵��� ���� �����ϰ� �ʹٸ� ������(:D,:C)�� �������ִ°� ����
		String saveDir = request.getServletContext().getRealPath("/save");
		File fileDir = new File(saveDir);
		if(fileDir.isDirectory()) {//isDirectory : ���丮�̳�?
			String[] fileNames = fileDir.list();
			request.setAttribute("fileNames", fileNames);
		}
//		response.getOutputStream();
		request.getRequestDispatcher("downList.jsp").forward(request, response);
	
	
	}

}
