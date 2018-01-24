package ex0110.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//@WebListener
public class AppContextListener implements ServletContextListener {
	//종료가될때
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed 호출");

	}
	//시작할때
	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		System.out.println("contextInitialized 호출");
		
		//웹 App 전반에서 사용하게 될 나라별 국가코드를 미리 세팅한다.
		Map<String, String> map = new HashMap<>();
		map.put("KR", "대한민국");
		map.put("CN", "중국");
		map.put("JP", "일본");
		map.put("US", "미국");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
	}

}
