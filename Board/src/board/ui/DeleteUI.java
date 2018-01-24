package board.ui;

import board.BoardUIMapping;
import board.vo.BoardVO;

public class DeleteUI extends BaseUI{
	BoardUIMapping map = null;
	public void excute() throws Exception {
		
		int no = scanInt("삭제할 게시판 번호를 입력 : ");
		BoardVO board = new BoardVO();
		board.setNo(no);
		int deleteNo = service.deleteBoard(board);
		
		if(deleteNo !=0) {
			System.out.println("게시글 삭제 성공!");
		} else {
			System.out.println("게시글 삭제 실패!");
		}		
	}	
}
