package ex0109.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//아이디, 비번, 이름들의 인코딩
		
		//post방식 parameter데이터 한글 인코딩처리
		request.setCharacterEncoding("UTF-8");//Post방식일때 userName의 한글이 깨지므로 인코딩을 해줘야한다.
		
		
		PrintWriter out = response.getWriter();
		
		//넘어오는 값 브라우져 출력
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName"); 
		
		out.println("아이디 : "+ userId +"<br>");
		out.println("비번 : "+ userPwd +"<br>");
		out.println("이름 : "+ userName +"<br>");
		
		//세션 저장 / 브라우져에서 유효한 session은 하나..
		HttpSession session = request.getSession();
		session.setAttribute("addr", "경기도 광주시 초월읍");//뷰에서 ${sessionScope.addr}
		
		//application 저장
		ServletContext application = request.getServletContext();
		application.setAttribute("message", "이	제 쉽시다..");
		
		request.setAttribute("userName", userName);
		
		//이동하기(크게 3개 : forward, redirect, location.href)
		//1) forward 
//		request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
		
		
		// 2)redirect
		response.sendRedirect("LoginOk.jsp");
		
		out.println("<script>");
		out.println("alert('로그인 성공...');");
		out.println("location.href='LoginOk.jsp'");
		out.println("</script>");
	}
/*
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doGet");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
	}
	*/
	
}
