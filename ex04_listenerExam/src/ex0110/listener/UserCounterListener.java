package ex0110.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 *  세션이 시작되면 counter 증가
 *  세션이 종료되면 counter 감소
 *  
 *  증가, 감소하는 숫자(변수)를 동기화 필요!!
 *   => JDK1.5버젼에서 각 타입별 변수를 동기화시키는 객체 추가
 * 
 * */

@WebListener
public class UserCounterListener implements ServletContextListener, HttpSessionListener {//인터페이스는 여러개를 받을수있다.
	ServletContext application ;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	
	
	//최초의 하는일..  java.util.concurrent.atomic.AtomicInteger 아까 쓰레드에서 카운트와 유사..
	@Override
	public void contextInitialized(ServletContextEvent e) {
      application = e.getServletContext();
      application.setAttribute("counter", new AtomicInteger());
      										//AtomicInteger : initial value 0.- 0부터시작
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		AtomicInteger counter = (AtomicInteger)application.getAttribute("counter");
		int increCounter = counter.incrementAndGet();
		System.out.println("Counter 증가 : " + increCounter +"명");

	}

	/**
	 *  세션이 종료될때 호출
	 *   1) session.invalidate()호출
	 *   2) 세션시간이 종료될때 호출
	 *   
	 *    - 브라우져창을 닫으면 호출되지 않는다.
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		AtomicInteger counter = (AtomicInteger)application.getAttribute("counter");
		int decreCounter = counter.decrementAndGet();
        System.out.println("Counter 감소 : " + decreCounter +"명");
	}

}





