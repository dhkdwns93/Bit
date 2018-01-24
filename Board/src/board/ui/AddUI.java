package board.ui;

import board.vo.BoardVO;

public class AddUI extends BaseUI{
	public void excute() throws Exception {
		String title = scanStr("등록할 글 제목 입력 : ");
		String writer = scanStr("등록할 작성자 입력 : ");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		
		//service는 BaseUI의 protected field이므로 상속받았으니 바로 사용 가능.
		int insertNo = service.insertBoard(board); 
		//insert된 row의 cnt
		if(insertNo != 0) {
			System.out.println("게시글 등록 성공!");
		} else {
			System.out.println("게시글 등록 실패!");
		}
	}
}