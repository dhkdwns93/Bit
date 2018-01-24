package ex0110.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//Filter의 기본 틀
public class SimpleFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("SimpleFilter의 destroy 호출");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {//HttpServletRequest의 부모인 ServletRequest를 사용 
		//사전처리
		System.out.println("SimpleFilter의 사전처리입니다.");
		
		//실제 타켓 대상 호출(꼭 있어야함)
		chain.doFilter(request, response);
		
		//사후처리
		System.out.println("SimpleFilter의 사후처리입니다.");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("SimpleFilter의 init 호출");

	}

}
