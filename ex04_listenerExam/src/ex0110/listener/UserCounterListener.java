package ex0110.listener;

import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
/**
 *  ������ ���۵Ǹ� counter ����
 *  ������ ����Ǹ� counter ����
 *  
 *  ����, �����ϴ� ����(����)�� ����ȭ �ʿ�!!
 *   => JDK1.5�������� �� Ÿ�Ժ� ������ ����ȭ��Ű�� ��ü �߰�
 * 
 * */

@WebListener
public class UserCounterListener implements ServletContextListener, HttpSessionListener {//�������̽��� �������� �������ִ�.
	ServletContext application ;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {}
	
	
	//������ �ϴ���..  java.util.concurrent.atomic.AtomicInteger �Ʊ� �����忡�� ī��Ʈ�� ����..
	@Override
	public void contextInitialized(ServletContextEvent e) {
      application = e.getServletContext();
      application.setAttribute("counter", new AtomicInteger());
      										//AtomicInteger : initial value 0.- 0���ͽ���
	}
	
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		AtomicInteger counter = (AtomicInteger)application.getAttribute("counter");
		int increCounter = counter.incrementAndGet();
		System.out.println("Counter ���� : " + increCounter +"��");

	}

	/**
	 *  ������ ����ɶ� ȣ��
	 *   1) session.invalidate()ȣ��
	 *   2) ���ǽð��� ����ɶ� ȣ��
	 *   
	 *    - ������â�� ������ ȣ����� �ʴ´�.
	 * */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		AtomicInteger counter = (AtomicInteger)application.getAttribute("counter");
		int decreCounter = counter.decrementAndGet();
        System.out.println("Counter ���� : " + decreCounter +"��");
	}

}





