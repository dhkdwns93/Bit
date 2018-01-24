package ex0110.listener;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

/**
 * Application Lifecycle Listener implementation class TimerRequestListener
 *
 */
@WebListener
public class TimerRequestListener implements ServletRequestListener {
   
	long start;
   
    public void requestInitialized(ServletRequestEvent arg0)  { 
        //���� ���ӵ� �ð��� ���Ѵ�
    	start = System.nanoTime();//�︸����1��
    }
   
    public void requestDestroyed(ServletRequestEvent e)  { 
         long end = System.nanoTime();
         long time = end - start;
         
         HttpServletRequest request = (HttpServletRequest)e.getServletRequest();
        
         System.out.println(request.getRequestURL()+" => �� �ɸ� �ð� : " + time + "ns");
    }

    
	
}







