package ex0110.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionTestListener implements HttpSessionListener {
	//Session�� �������� �������� �߻�.
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated ȣ��");

	}
	//�������� ��������� ȣ����� �ʴ´�.
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed ȣ��");

	}

}
