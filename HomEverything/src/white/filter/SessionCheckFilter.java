package white.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
@WebFilter(urlPatterns= {

})
*/
public class SessionCheckFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 세션 유무 체크
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		response.setContentType("text/html;charset=UTF-8");
		if(session.getAttribute("loginId") == null) {
			//request.setAttribute("errorMsg", "로그인하고 이용해주세요");
			//request.getRequestDispatcher("error/error.jsp").forward(request, response);
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('권한이 없습니다. 로그인 먼저 해주시기 바랍니다.');");
			out.println("location.href='user/login.jsp';");
			out.println("</script>");
			
			return;
		}
		
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException { }

	@Override
	public void destroy() { }
}
