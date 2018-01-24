package bit.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import bit.controller.Action;

/**
 * Application Lifecycle Listener implementation class
 * ActionServletContextListener
 *
 */
@WebListener
public class ActionServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {}

	public void contextInitialized(ServletContextEvent e) {
		// 1. web.xml ������ �����Ǿ� �ִ� ���� �̸� ��������
		ServletContext application = e.getServletContext();
		String fileName = application.getInitParameter("fileName");

		Map<String, Action> map = new HashMap<>();

		// 2.�� ���� �̸��� �ε�
		ResourceBundle rb = ResourceBundle.getBundle(fileName);

		// key�� ��Ƽ� Set �ȿ� �ִ� �����͸� Interator�� �̿��Ͽ� ������.
		Iterator<String> it = rb.keySet().iterator();

		while (it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);
			try {
				// 3.���Ͽ� �ִ� key�� value�� �и��ؼ� value�� ��ü�� ��ȯ�ϰ�
				// Map�� �����Ѵ�.
				Action ac = (Action) Class.forName(value).newInstance();
				map.put(key, ac);

				System.out.println(key + "=" + value + "->" + ac);
				System.out.println(11);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		// 4. ����� Map�� ��App���� ��𿡼��� ����� �� �ֵ��� application�� �����Ѵ�.
		application.setAttribute("map", map);
		application.setAttribute("path", application.getContextPath());//view�� �ƹ��뼭�� path�� ��밡��
	}

}
