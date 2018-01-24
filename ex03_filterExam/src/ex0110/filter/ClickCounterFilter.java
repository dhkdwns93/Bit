package ex0110.filter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;



/**
 * ���͵�� ��� 2���� - ����, ������̼�
 */
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "fileName", value = "clickCount.properties")
		})
public class ClickCounterFilter implements Filter {
	Properties pro;
	File file;
	
	public void destroy() {
		//������ ����
		//���̻� �����带 ���� �ʰ� ������ ����ǰ� �ִ� ��� �����带 ����Ϸ�
		//���� �����Ѵ�.
		service.shutdown();
	}

 /**
    *  -����ó�� : ���μ����� �л���� ���� ������ �۾��� ���� �Ҽ� �ֵ��� �ϴ°�.
    *              JDK 1.5���� ����ó���� ������ ������ �����ӿ��� �����Ѵ�.
    * 
    *   Executors :  �⺻������(������ ���࿡ ���õ� �޼ҵ� ����) 
    *   ExecutorService : (������ ���� + �����ϰ� ���� �Ҽ� �ִ� �޼ҵ� ����)
    * */
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		    //���� ó��
		service.execute(new Runnable() {//����ȭ ó��
			@Override
			public void run() {
				//1.uri�ּ� ��������
				HttpServletRequest req = (HttpServletRequest)request;
				String uri = req.getRequestURI();//key
				//2.uri�ּҷ� key�� �����ϴ��� üũ
				String value = pro.getProperty(uri);

				//3.����, ������ ���� �߰�, ������ ���� �� �о value�� �����ϰ� �ٽ� ����.
				if(value==null) {
					pro.setProperty(uri, "1");
				}else {
					int count = Integer.parseInt(value);
					count++;
					pro.setProperty(uri, count+"");
				}
				
				//4. ���Ͽ� �ݿ�
              try {
				pro.store(new FileWriter(file), "");
              }catch (Exception e) {
				e.printStackTrace();
			  }
				
			}
		});
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		String fileName = fConfig.getInitParameter("fileName");
		String path = fConfig.getServletContext().getRealPath("/");
						//
		file = new File(path+"/"+fileName);
		if(!file.exists()) {
			try {
			  file.createNewFile();//���� ����
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//������ ������ �����Ѵ�.
		
		//������ Properties��ü�� �̿��Ͽ� key�� value�� �и��Ѵ�.
		try {
		    pro = new Properties();//�ڷᱸ���� Map -> ���׸�(<>)�� ���������� String���� �޾ƿ��� ������(������)
			pro.load(new FileReader(file));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}












