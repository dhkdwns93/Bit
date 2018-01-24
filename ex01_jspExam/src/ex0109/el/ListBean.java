package ex0109.el;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListBean {
	private String names[] = { "장희정", "이나영", "이효리", "김상순" };
	private List<String> menus = new ArrayList<String>();
	private List<BoardVO> boardList = new ArrayList<>();
	private Map<String, String> map = new HashMap<>();

	public ListBean() {
		//메뉴 저장
		menus.add("한식");
		menus.add("일식");
		menus.add("중식");
		menus.add("양식");
		menus.add("분식");
		
		//Board 저장(ListBean)
		boardList.add(new BoardVO(10, "이효리", "Jsp&Servlet", "2018-10-20"));
		boardList.add(new BoardVO(20, "장희정" ,"jQuery", "2018-11-10"));
		boardList.add(new BoardVO(30, "이가현", "HTML5", "2018-12-24"));
		
		//map에 저장
		map.put("KR", "대한민국");
		map.put("US", "미국");
		map.put("JP", "일본");
		map.put("CN", "중국");
		
	}

	public String[] getNames() {//view에서 ${변수이름.names}
		return names;
	}

	public List<String> getMenus() {//view에서 ${변수이름.menus}
		return menus;
	}

	public List<BoardVO> getBoardList() {//${이름.boardList}
		return boardList;
	}

	public Map<String, String> getMap() {//${bean.map}
		return map;
	}
	

}
