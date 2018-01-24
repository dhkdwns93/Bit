package ex0109.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 사용자 정의 Servlet
 *   1) public 클래스
 *	 2) HttpServlet 상속
 *   3) 필요한 메소드 재정의
 *   
 *   4)web.xml 문서 or @annotation을 이용하여 등록
 */
public class LifeCycleServlet extends HttpServlet {
	
	public LifeCycleServlet() throws ServletException{
		System.out.println("LifeCycleServlet 생성자호출");
	}
	/*@Override
	public void init() throws ServletException {
		System.out.println("init 호출");
	}*/
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service 호출");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//현재브라우져의 한글 인코딩설정필요
		response.setContentType("text/html;charset=UTF-8");
		
		
		System.out.println("doGet 호출");
		//브라우저에 출력

		PrintWriter out = response.getWriter();
		out.print("<h1>wang 준</h1>");
		
		//넘어오는 parameter 받기
		String name = request.getParameter("name");
		out.println("<h2>이름 : "+name+"</h2>");
				
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}

	@Override
	public void destroy() {
		System.out.println("destroy 호출");
	}

	
}
