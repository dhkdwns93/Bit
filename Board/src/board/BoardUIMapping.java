package board;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import board.ui.IBoardUI;

public class BoardUIMapping {
	
	private HashMap<String, IBoardUI> mapping;
	
	public BoardUIMapping() throws Exception {
		mapping = new HashMap<>();
		
		Properties prop = new Properties();
		InputStream is = new FileInputStream("board_config_properties");
		prop.load(is);
		
		String key = "";
		String className = "";
		
		Enumeration<Object> e = prop.keys();
		//ó������ �� �̾Ƴ� ��, ��ȸ.  iterator�� ����
		//������ ���� ���� Ȯ�� (element)
		//Type�� �𸣴� Object�� ����
		
		while(e.hasMoreElements()) {
			key = (String)e.nextElement(); //nextElemetn()�� load�� key���� ����
			className = (String)prop.get(key); //load�� key�� �ش��ϴ� �� (����)
			
								//new ������ ����ϳ� ObjectŸ������ ������ ���ش�.
			mapping.put(key, (IBoardUI)(Class.forName(className).newInstance()) );			
		}		
	}
	
	public IBoardUI getBoardUI(String key) {
		return mapping.get(key);
	}
	
}