package ex0110.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Servlet Filter implementation class EncodingFilter
 * 어노테이션("/*") : 전부 받을 때
 * 어노테이션("/loginCheck.jsp") : 하나만 받을 때
 */
/*@WebFilter(
		urlPatterns = { "/loginCheck.jsp" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		}, 
		servletNames = { "loginCheckServlet" })*/
//전부
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		})
public class EncodingFilter implements Filter {
	String encoding;
  
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//post방식 인코딩\
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
