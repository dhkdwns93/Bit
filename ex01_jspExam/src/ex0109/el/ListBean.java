package ex0109.el;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListBean {
	private String names[] = { "������", "�̳���", "��ȿ��", "����" };
	private List<String> menus = new ArrayList<String>();
	private List<BoardVO> boardList = new ArrayList<>();
	private Map<String, String> map = new HashMap<>();

	public ListBean() {
		//�޴� ����
		menus.add("�ѽ�");
		menus.add("�Ͻ�");
		menus.add("�߽�");
		menus.add("���");
		menus.add("�н�");
		
		//Board ����(ListBean)
		boardList.add(new BoardVO(10, "��ȿ��", "Jsp&Servlet", "2018-10-20"));
		boardList.add(new BoardVO(20, "������" ,"jQuery", "2018-11-10"));
		boardList.add(new BoardVO(30, "�̰���", "HTML5", "2018-12-24"));
		
		//map�� ����
		map.put("KR", "���ѹα�");
		map.put("US", "�̱�");
		map.put("JP", "�Ϻ�");
		map.put("CN", "�߱�");
		
	}

	public String[] getNames() {//view���� ${�����̸�.names}
		return names;
	}

	public List<String> getMenus() {//view���� ${�����̸�.menus}
		return menus;
	}

	public List<BoardVO> getBoardList() {//${�̸�.boardList}
		return boardList;
	}

	public Map<String, String> getMap() {//${bean.map}
		return map;
	}
	

}
