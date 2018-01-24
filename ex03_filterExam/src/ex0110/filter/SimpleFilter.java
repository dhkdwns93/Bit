package ex0110.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//Filter�� �⺻ Ʋ
public class SimpleFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("SimpleFilter�� destroy ȣ��");

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {//HttpServletRequest�� �θ��� ServletRequest�� ��� 
		//����ó��
		System.out.println("SimpleFilter�� ����ó���Դϴ�.");
		
		//���� Ÿ�� ��� ȣ��(�� �־����)
		chain.doFilter(request, response);
		
		//����ó��
		System.out.println("SimpleFilter�� ����ó���Դϴ�.");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("SimpleFilter�� init ȣ��");

	}

}
