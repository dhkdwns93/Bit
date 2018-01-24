package ex0110.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//��û�� ���ö����� ����
@WebListener
public class RequestTestListener implements ServletRequestListener {

	//request�� ����ɶ�
    public void requestDestroyed(ServletRequestEvent arg0)  { 
        System.out.println("requestDestroyed ȣ��");
    }

	//request�� ���������
    public void requestInitialized(ServletRequestEvent arg0)  { 
        System.out.println("requestInitialized ȣ��");
    }
	
}
