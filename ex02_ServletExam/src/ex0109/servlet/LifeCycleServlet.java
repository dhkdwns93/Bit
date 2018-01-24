package ex0109.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ����� ���� Servlet
 *   1) public Ŭ����
 *	 2) HttpServlet ���
 *   3) �ʿ��� �޼ҵ� ������
 *   
 *   4)web.xml ���� or @annotation�� �̿��Ͽ� ���
 */
public class LifeCycleServlet extends HttpServlet {
	
	public LifeCycleServlet() throws ServletException{
		System.out.println("LifeCycleServlet ������ȣ��");
	}
	/*@Override
	public void init() throws ServletException {
		System.out.println("init ȣ��");
	}*/
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service ȣ��");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����������� �ѱ� ���ڵ������ʿ�
		response.setContentType("text/html;charset=UTF-8");
		
		
		System.out.println("doGet ȣ��");
		//�������� ���

		PrintWriter out = response.getWriter();
		out.print("<h1>wang ��</h1>");
		
		//�Ѿ���� parameter �ޱ�
		String name = request.getParameter("name");
		out.println("<h2>�̸� : "+name+"</h2>");
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost ȣ��");
	}

	@Override
	public void destroy() {
		System.out.println("destroy ȣ��");
	}

	
}
