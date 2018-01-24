package board.ui;

import board.vo.BoardVO;

public class SearchOneUI extends BaseUI{
	public void excute() throws Exception {
		int no = scanInt("��ȸ�� �Խñ� ��ȣ �Է�");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		
		BoardVO result = service.selectOneBoard(board);
		
		if(result == null) {
			System.out.println("�Խñ� [" + no + "]�� �������� �ʽ��ϴ�");
			return;
		}
		else {
			System.out.println(result.getNo() + "�� �Խñ�");
			System.out.println("----------------------------------------------");
			System.out.println("��ȣ\t����\t�۾���\t�����\t");
			System.out.println("----------------------------------------------");
			System.out.print(result.getNo() + "\t");
			System.out.print(result.getTitle() + "\t");
			System.out.print(result.getWriter() + "\t");
			System.out.println(result.getRegDate() + "\t");
			System.out.println("----------------------------------------------");
		}
		
	}
}
