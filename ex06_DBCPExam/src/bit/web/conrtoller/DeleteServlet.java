package bit.web.conrtoller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.web.model.service.MemberService;
import bit.web.model.service.MemberServiceImpl;


@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   String id;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.넘어오는 id 받기
		id = request.getParameter("id");
		
		String url = "index.html";
		
		try {	
			MemberService service = new MemberServiceImpl();
			
			service.memberDelete(id);
		
			response.sendRedirect(url);
			return;
			
		} catch (Exception e) {
			
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "index.html");
			url="error.jsp";
		}
		//얘는 무조건.
		request.getRequestDispatcher(url).forward(request, response);
		
		
	}
	
}
