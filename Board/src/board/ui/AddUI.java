package board.ui;

import board.vo.BoardVO;

public class AddUI extends BaseUI{
	public void excute() throws Exception {
		String title = scanStr("����� �� ���� �Է� : ");
		String writer = scanStr("����� �ۼ��� �Է� : ");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		
		//service�� BaseUI�� protected field�̹Ƿ� ��ӹ޾����� �ٷ� ��� ����.
		int insertNo = service.insertBoard(board); 
		//insert�� row�� cnt
		if(insertNo != 0) {
			System.out.println("�Խñ� ��� ����!");
		} else {
			System.out.println("�Խñ� ��� ����!");
		}
	}
}