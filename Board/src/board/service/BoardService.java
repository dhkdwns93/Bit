package board.service;

import java.util.List;

import board.dao.BoardDAO;
import board.vo.BoardVO;

public class BoardService {
	private BoardDAO dao;
	
	public BoardService() {
		dao = new BoardDAO();
	}
	
	public int insertBoard(BoardVO board) throws Exception {
		if(board.getTitle().isEmpty() || board.getWriter().isEmpty()) return 0;		
		return dao.insertBoard(board);
	}
	
	public int updateBoard(BoardVO board) throws Exception {
		if(board.getTitle().isEmpty()) return 0;		
		return dao.updateBoard(board);
	}
	
	public int deleteBoard(BoardVO board) throws Exception {
		if(board.getNo() == 0) return 0;		
		return dao.deleteBoard(board);
	}
	
	public BoardVO selectOneBoard(BoardVO board) throws Exception{
		BoardVO result = dao.selectOneBoard(board);
		return result;
	}
	
	public List<BoardVO> selectBoard() throws Exception {
		List<BoardVO> result = dao.selectBoard();
		return result;
	}	
}
