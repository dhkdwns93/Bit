package mini.listener;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mini.controller.Action;

/**
 * Application Lifecycle Listener implementation class AppContextListener
 *
 */
@WebListener
public class AppContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent e) {

		// web.xml 문서의 properties
		ServletContext app = e.getServletContext();
		String property1 = app.getInitParameter("action");

		String property2 = app.getInitParameter("userAction");

		Map<String, Action> map1 = new HashMap<>();
		Map<String, Action> map2 = new HashMap<>();
		// 로딩
		ResourceBundle rb1 = ResourceBundle.getBundle(property1);
		ResourceBundle rb2 = ResourceBundle.getBundle(property2);

		Iterator<String> it1 = rb1.keySet().iterator();
		Iterator<String> it2 = rb2.keySet().iterator();

		// key와 value를 분리하고 Map에 저장
		while (it1.hasNext()) {
			String key = it1.next();
			String value = rb1.getString(key);

			try {
				Action ac = (Action) Class.forName(value).newInstance();
				map1.put(key, ac);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		app.setAttribute("map", map1);
		app.setAttribute("path", app.getContextPath());
		while (it2.hasNext()) {
			String key2 = it2.next();
			String value2 = rb2.getString(key2);

			try {
				Action ac = (Action) Class.forName(value2).newInstance();
				map2.put(key2, ac);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		app.setAttribute("usermap", map2);
	}

}
