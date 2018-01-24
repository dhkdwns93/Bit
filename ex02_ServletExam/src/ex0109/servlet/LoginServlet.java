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
		response.setContentType("text/html;charset=UTF-8");//���̵�, ���, �̸����� ���ڵ�
		
		//post��� parameter������ �ѱ� ���ڵ�ó��
		request.setCharacterEncoding("UTF-8");//Post����϶� userName�� �ѱ��� �����Ƿ� ���ڵ��� ������Ѵ�.
		
		
		PrintWriter out = response.getWriter();
		
		//�Ѿ���� �� ������ ���
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName"); 
		
		out.println("���̵� : "+ userId +"<br>");
		out.println("��� : "+ userPwd +"<br>");
		out.println("�̸� : "+ userName +"<br>");
		
		//���� ���� / ���������� ��ȿ�� session�� �ϳ�..
		HttpSession session = request.getSession();
		session.setAttribute("addr", "��⵵ ���ֽ� �ʿ���");//�信�� ${sessionScope.addr}
		
		//application ����
		ServletContext application = request.getServletContext();
		application.setAttribute("message", "��	�� ���ô�..");
		
		request.setAttribute("userName", userName);
		
		//�̵��ϱ�(ũ�� 3�� : forward, redirect, location.href)
		//1) forward 
//		request.getRequestDispatcher("LoginOk.jsp").forward(request, response);
		
		
		// 2)redirect
		response.sendRedirect("LoginOk.jsp");
		
		out.println("<script>");
		out.println("alert('�α��� ����...');");
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
