package ex0110.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//@WebListener
public class AppContextListener implements ServletContextListener {
	//���ᰡ�ɶ�
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("contextDestroyed ȣ��");

	}
	//�����Ҷ�
	@Override
	public void contextInitialized(ServletContextEvent e) {
		
		System.out.println("contextInitialized ȣ��");
		
		//�� App ���ݿ��� ����ϰ� �� ���� �����ڵ带 �̸� �����Ѵ�.
		Map<String, String> map = new HashMap<>();
		map.put("KR", "���ѹα�");
		map.put("CN", "�߱�");
		map.put("JP", "�Ϻ�");
		map.put("US", "�̱�");
		
		ServletContext application = e.getServletContext();
		application.setAttribute("map", map);
		
	}

}
