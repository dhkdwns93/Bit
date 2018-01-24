package board.ui;

import board.vo.BoardVO;

public class UpdateUI extends BaseUI{

	public void excute() throws Exception {		
		int no = scanInt("������ �Խñ� ��ȣ�� �Է� : ");
		String title = scanStr("���ο� ������ �Է� : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		
		int updateNo = service.updateBoard(board);
		
		if(updateNo !=0) {
			System.out.println("�Խñ� ���� ����!");
		} else {
			System.out.println("�Խñ� ���� ����!");
			System.out.println("��ȣ [" + no + "]�� �������� �ʽ��ϴ�.");
		}
	}
	
}
