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
 * 필터등록 방법 2가지 - 설정, 어노테이션
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
		//스레드 종료
		//더이상 스레드를 받지 않고 기존에 실행되고 있는 모든 스레드를 실행완료
		//한후 종료한다.
		service.shutdown();
	}

 /**
    *  -병렬처리 : 프로세스를 분산시켜 좀더 빠르게 작업을 수행 할수 있도록 하는것.
    *              JDK 1.5부터 병렬처리가 가능한 스레드 프레임웍을 제공한다.
    * 
    *   Executors :  기본스레드(스레드 실행에 관련된 메소드 제공) 
    *   ExecutorService : (스레드 실행 + 안전하게 종료 할수 있는 메소드 제공)
    * */
	
	ExecutorService service = Executors.newSingleThreadExecutor();
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		    //사전 처리
		service.execute(new Runnable() {//동기화 처리
			@Override
			public void run() {
				//1.uri주소 가져오기
				HttpServletRequest req = (HttpServletRequest)request;
				String uri = req.getRequestURI();//key
				//2.uri주소로 key가 존재하는지 체크
				String value = pro.getProperty(uri);

				//3.만약, 없으면 새로 추가, 있으면 기존 거 읽어서 value를 수정하고 다시 저장.
				if(value==null) {
					pro.setProperty(uri, "1");
				}else {
					int count = Integer.parseInt(value);
					count++;
					pro.setProperty(uri, count+"");
				}
				
				//4. 파일에 반영
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
			  file.createNewFile();//파일 생성
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//파일이 없을때 생성한다.
		
		//파일을 Properties객체를 이용하여 key와 value를 분리한다.
		try {
		    pro = new Properties();//자료구조의 Map -> 제네릭(<>)이 없는이유는 String으로 받아오기 때문에(정해짐)
			pro.load(new FileReader(file));
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}












