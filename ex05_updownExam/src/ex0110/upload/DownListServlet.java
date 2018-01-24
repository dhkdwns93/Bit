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
		//만약 저장시킨 데이터들을 따로 보관하고 싶다면 절대경로(:D,:C)로 지정해주는게 좋다
		String saveDir = request.getServletContext().getRealPath("/save");
		File fileDir = new File(saveDir);
		if(fileDir.isDirectory()) {//isDirectory : 디렉토리이냐?
			String[] fileNames = fileDir.list();
			request.setAttribute("fileNames", fileNames);
		}
//		response.getOutputStream();
		request.getRequestDispatcher("downList.jsp").forward(request, response);
	
	
	}

}
