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
		//처음부터 쭉 뽑아낼 때, 순회.  iterator와 유사
		//원소의 존재 여부 확인 (element)
		//Type을 모르니 Object로 받자
		
		while(e.hasMoreElements()) {
			key = (String)e.nextElement(); //nextElemetn()는 load한 key값의 좌측
			className = (String)prop.get(key); //load한 key에 해당하는 값 (우측)
			
								//new 생성과 비슷하나 Object타입으로 리턴을 해준다.
			mapping.put(key, (IBoardUI)(Class.forName(className).newInstance()) );			
		}		
	}
	
	public IBoardUI getBoardUI(String key) {
		return mapping.get(key);
	}
	
}