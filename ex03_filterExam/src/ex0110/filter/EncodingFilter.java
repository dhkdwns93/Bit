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
 * ������̼�("/*") : ���� ���� ��
 * ������̼�("/loginCheck.jsp") : �ϳ��� ���� ��
 */
/*@WebFilter(
		urlPatterns = { "/loginCheck.jsp" }, 
		initParams = { 
				@WebInitParam(name = "encoding", value = "UTF-8")
		}, 
		servletNames = { "loginCheckServlet" })*/
//����
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
		//post��� ���ڵ�\
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig fConfig) throws ServletException {
		encoding = fConfig.getInitParameter("encoding");
	}

}
