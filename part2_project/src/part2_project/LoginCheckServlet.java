package part2_project;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCheckServlet extends HttpServlet {
	/*String dbId;
	String dbPwd;
	
	//init-Param���� �����־ init���� �޾ƿ´�.
	@Override
	public void init(ServletConfig config) throws ServletException {
		dbId = config.getInitParameter("dbId");
		dbPwd = config.getInitParameter("dbPwd");
	}*/
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		PrintWriter out = response.getWriter();
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		session.setAttribute("ID", "wang");
		session.setAttribute("Pwd", "1234");
		
		long time = session.getCreationTime();
		
		
		
		
		
		if(userId.equals(session.getAttribute("ID"))&&userPwd.equals(session.getAttribute("Pwd"))&&!userName.isEmpty()) {
			//���ǿ� �̸� ����
			session.setAttribute("userName", userName);
			//���ӽð� ����.
			 session.setAttribute("startTime", time);
			 //LoginOk.jsp�� �̵�
//			 request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
			 response.sendRedirect("LoginOk.jsp");
			 out.println("<script>");
			 out.println("alert('�α��ο� �����ϼ̽��ϴ�.')");
//			 out.println("location.href='LoginOk.jsp'");
			 out.println("</script>");
		}else {
			//��ġ�����ʴ´ٸ�..
			 out.println("<script>");
			 out.println("alert('��ġ�����ʽ��ϴ�.')");
			 out.println("history.back()");
			 out.println("</script>");
		}
		
		
		
		
	}
	
}
