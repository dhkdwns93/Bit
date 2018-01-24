package ex0110.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//요청이 들어올때마다 실행
@WebListener
public class RequestTestListener implements ServletRequestListener {

	//request가 종료될때
    public void requestDestroyed(ServletRequestEvent arg0)  { 
        System.out.println("requestDestroyed 호출");
    }

	//request가 만들어질때
    public void requestInitialized(ServletRequestEvent arg0)  { 
        System.out.println("requestInitialized 호출");
    }
	
}
