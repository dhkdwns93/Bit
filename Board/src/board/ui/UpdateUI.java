package board.ui;

import board.vo.BoardVO;

public class UpdateUI extends BaseUI{

	public void excute() throws Exception {		
		int no = scanInt("변경할 게시글 번호를 입력 : ");
		String title = scanStr("새로운 제목을 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		board.setTitle(title);
		
		int updateNo = service.updateBoard(board);
		
		if(updateNo !=0) {
			System.out.println("게시글 변경 성공!");
		} else {
			System.out.println("게시글 변경 실패!");
			System.out.println("번호 [" + no + "]는 존재하지 않습니다.");
		}
	}
	
}
