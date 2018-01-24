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
 * Application Lifecycle Listener implementation class ActionServletContextListener
 *
 */
@WebListener
public class ActionServletContextListener implements ServletContextListener {

    
    public void contextDestroyed(ServletContextEvent arg0)  {}

    public void contextInitialized(ServletContextEvent e)  { 
         //1. web.xml문서에 설정되어 있는 파일이름 가져오기
    	ServletContext application = e.getServletContext();
    	String fileName = application.getInitParameter("fileName");//bit.util.action
    	
    	Map<String, Action> map = new HashMap<>();
    	
    	//2. 그 파일이름을 로딩
    	ResourceBundle rb = ResourceBundle.getBundle(fileName);
    	
    	//key를 모아서 Set에 담고 set안에 있는 데이터를 iterator를이용하여 꺼낸다
    	Iterator<String>  it = rb.keySet().iterator(); 
    	while(it.hasNext()) {
    		String key = it.next();
    		String value = rb.getString(key);
    		try {
    		//객체로 변환
    			Action ac =(Action)Class.forName(value).newInstance();
    			map.put(key, ac);
    			System.out.println(key+"="+value+"-> "+ ac);
    		}catch (Exception ex) {
				ex.printStackTrace();
			}
    	}
    	
    	
    	//3. 파일에 있는 key와 value를 분리해서 value를 객체로 변환하고
    	//   Map에 저장한다.
    	
    	//4. 저장된 Map을 웹App영역 어디에서도 사용할수 있도록 application에 저장한다. 
    	
    	application.setAttribute("map", map);
    	application.setAttribute("path", application.getContextPath()); //뷰에서 ${path}
    }
	
}






