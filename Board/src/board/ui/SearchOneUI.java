package board.ui;

import board.vo.BoardVO;

public class SearchOneUI extends BaseUI{
	public void excute() throws Exception {
		int no = scanInt("조회할 게시글 번호 입력");
		
		BoardVO board = new BoardVO();
		board.setNo(no);
		
		BoardVO result = service.selectOneBoard(board);
		
		if(result == null) {
			System.out.println("게시글 [" + no + "]는 존재하지 않습니다");
			return;
		}
		else {
			System.out.println(result.getNo() + "번 게시글");
			System.out.println("----------------------------------------------");
			System.out.println("번호\t제목\t글쓴이\t등록일\t");
			System.out.println("----------------------------------------------");
			System.out.print(result.getNo() + "\t");
			System.out.print(result.getTitle() + "\t");
			System.out.print(result.getWriter() + "\t");
			System.out.println(result.getRegDate() + "\t");
			System.out.println("----------------------------------------------");
		}
		
	}
}
