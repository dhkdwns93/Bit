package board.ui;

import java.util.List;

import board.vo.BoardVO;

public class SearchUI extends BaseUI{
	public void excute() throws Exception {
		List<BoardVO> list = service.selectBoard();
		
		System.out.println("[게시글 목록 : " + list.size() + "개]");
		System.out.println("----------------------------------------------");
		System.out.println("번호\t제목\t글쓴이\t등록일\t");
		System.out.println("----------------------------------------------");

		if(list.isEmpty()) {
			System.out.println("[주의] : 게시글이 존재하지 않습니다.");
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
