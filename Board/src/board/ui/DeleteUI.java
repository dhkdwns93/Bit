package board.ui;

import board.BoardUIMapping;
import board.vo.BoardVO;

public class DeleteUI extends BaseUI{
	BoardUIMapping map = null;
	public void excute() throws Exception {
		
		int no = scanInt("������ �Խ��� ��ȣ�� �Է� : ");
		BoardVO board = new BoardVO();
		board.setNo(no);
		int deleteNo = service.deleteBoard(board);
		
		if(deleteNo !=0) {
			System.out.println("�Խñ� ���� ����!");
		} else {
			System.out.println("�Խñ� ���� ����!");
		}		
	}	
}
