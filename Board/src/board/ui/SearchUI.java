package board.ui;

import java.util.List;

import board.vo.BoardVO;

public class SearchUI extends BaseUI{
	public void excute() throws Exception {
		List<BoardVO> list = service.selectBoard();
		
		System.out.println("[�Խñ� ��� : " + list.size() + "��]");
		System.out.println("----------------------------------------------");
		System.out.println("��ȣ\t����\t�۾���\t�����\t");
		System.out.println("----------------------------------------------");

		if(list.isEmpty()) {
			System.out.println("[����] : �Խñ��� �������� �ʽ��ϴ�.");
		}
		
		for(BoardVO board : list) {
			System.out.print(board.getNo() + "\t");
			System.out.print(board.getTitle() + "\t");
			System.out.print(board.getWriter() + "\t");
			System.out.println(board.getRegDate() + "\t");
		}
		System.out.println("----------------------------------------------");

		
		
	}

}
