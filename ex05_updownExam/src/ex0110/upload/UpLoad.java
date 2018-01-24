package ex0110.upload;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/Upload")
public class UpLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//차후 필터로 처리.
		
		/*String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String file = request.getParameter("file");
		
		System.out.println("name : "+name);
		System.out.println("subject : "+subject);
		System.out.println("file : "+file);*/
		
		//request.getRealPath() 와 같다.
		String saveDir = request.getServletContext().getRealPath("/save");
				
		int maxSize=1024*1024*100;//100메가
		String encoding="UTF-8";
		
		//new DefaultFileRenamePolicy() 
		// : 폴더에 같은 이름의 파일을 올렸을 때 같은이름+숫자로 저장해준다.
		MultipartRequest m 
			= new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
	
		String name = m.getParameter("name");
		String subject = m.getParameter("subject");
		
//		String file = m.getParameter("file"); 이걸로 받으면 null값임
		
		//fileName과 fileOriginal의 차이점
		String fileName = m.getFilesystemName("file");
		String fileOriginal = m.getOriginalFileName("file");
		long fileSize = m.getFile("file").length();
		
		
		
//		System.out.println("name : "+name);
//		System.out.println("subject : "+subject);
//		System.out.println("file : "+file);

		
		//view쪽으로 전달할 데이터 저장
		/*request.setAttribute("name", name);//뷰에서 ${name}
		request.setAttribute("subject", subject);
		request.setAttribute("fileName", fileName);
		request.setAttribute("fileOriginal", fileOriginal);
		request.setAttribute("fileSize", fileSize);
		request.setAttribute("saveDir", saveDir);*/
		
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("subject", subject);
		map.put("fileName", fileName);
		map.put("fileOriginal", fileOriginal);
		map.put("fileSize", fileSize);
		map.put("saveDir", saveDir);
		
		request.setAttribute("map", map);
		request.getRequestDispatcher("uploadResult.jsp").forward(request, response);
	}

}
