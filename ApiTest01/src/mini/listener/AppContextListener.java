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
		String property = app.getInitParameter("action");

		Map<String, Action> map = new HashMap<>();

		// 로딩
		ResourceBundle rb = ResourceBundle.getBundle(property);
		Iterator<String> it = rb.keySet().iterator();

		// key와 value를 분리하고 Map에 저장
		while (it.hasNext()) {
			String key = it.next();
			String value = rb.getString(key);

			try {
				Action ac = (Action) Class.forName(value).newInstance();
				map.put(key, ac);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		app.setAttribute("map", map);
		app.setAttribute("path", app.getContextPath());

	}

}
