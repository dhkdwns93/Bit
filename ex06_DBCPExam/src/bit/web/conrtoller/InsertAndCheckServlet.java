package bit.web.conrtoller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bit.web.model.service.MemberService;
import bit.web.model.service.MemberServiceImpl;
import bit.web.model.vo.MemberVo;

/**
 * Servlet implementation class InsertAndCheckServlet
 */
@WebServlet("/insertAndCheckServlet")
public class InsertAndCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//넘어오는값들 받기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		
		try {
		//유효성체크
		if(id==null||pwd==null||name==null||age==null||phone==null||addr==null
				||id.equals("")||pwd.equals("")||name.equals("")||age.equals("")||phone.equals("")||addr.equals("")) {
		
			throw new SQLException("빈칸을 채워라");
			
		}
		
		MemberService service = new MemberServiceImpl();
		
		MemberVo member = new MemberVo(id, pwd, name, Integer.parseInt(age), phone, addr);
		service.memberInsert(member);
		response.sendRedirect("index.html");
		return;
		
		
		//전송된 값들을 이용하여 MemberDTO를 생성	
		
		}catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("errMsg", e.getMessage());
			request.setAttribute("url", "memberFrom.html");
			
		}
		request.getRequestDispatcher("error.jsp").forward(request, response);
		
	}

}
