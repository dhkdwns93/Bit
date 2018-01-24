package ex0110.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionTestListener implements HttpSessionListener {
	//Session은 브라우저를 열었을때 발생.
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated 호출");

	}
	//웹브라우저 강제종료시 호출되지 않는다.
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed 호출");

	}

}
