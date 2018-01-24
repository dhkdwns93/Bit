package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.util.ConnectionFactory;
import board.util.JDBCClose;
import board.vo.BoardVO;

public class BoardDAO {
	
	private List<BoardVO> boardList = new ArrayList<>();
	
	public BoardDAO() {};
	/*
	 * 게시판 등록 기능
	 */	
	public int insertBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertCnt = 0;
		
		try {
			con = new ConnectionFactory().getConnection();
//			String sql = "INSERT INTO t_board(title,writer) VALUES(?,?)";
			StringBuilder sql = new StringBuilder();
			sql.append(" INSERT INTO t_board(title, writer) ");
			sql.append(" VALUES(?, ?)");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());  //인덱스는 1부터  0은 오류 발생.
			pstmt.setString(2, board.getWriter());			
			
			insertCnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt); 
		}
		
		return insertCnt;		
	}	
	
	/*
	 * 게시판 수정 기능
	 */	
	public int updateBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateCnt = 0;
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" UPDATE t_board ");
			sql.append(" SET title = ? ");
			sql.append(" WHERE no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, board.getTitle());
			pstmt.setInt(2, board.getNo());
			
			updateCnt = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
		return updateCnt;
	}
	
	/*
	 * 게시판 삭제 기능 
	 */
	public int deleteBoard(BoardVO board) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteCnt = 0;
		try {
			con = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" DELETE FROM t_board ");
			sql.append(" WHERE no = ?");
			
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, board.getNo());
			
			deleteCnt = pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(con, pstmt);
		}
		return deleteCnt;
	}
	
	/*
	 * 게시판 번호로 조회
	 */
	public BoardVO selectOneBoard(BoardVO board) throws Exception {  //사용시에 try문에서 사용.
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT no, title, writer, reg_date");
		sql.append(" FROM t_board ");
		sql.append(" WHERE no = ?");
		
		pstmt = con.prepareStatement(sql.toString());
		pstmt.setInt(1, board.getNo());
		
		ResultSet rs = pstmt.executeQuery();
		if(!rs.next()) return null;
		else {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String regDate = rs.getString("reg_date");
			
			BoardVO vo = new BoardVO(no,title,writer,regDate);
			JDBCClose.close(con, pstmt);
			return vo;
		}		
	}	
	
	/*
	 * 게시판 전체 조회
	 */
	public List<BoardVO> selectBoard() throws Exception {
		boardList.clear();
		Connection con = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT no, title, writer, reg_date FROM t_board ");
		sql.append(" ORDER BY no ");
		pstmt = con.prepareStatement(sql.toString());
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			int no = rs.getInt("no");
			String title = rs.getString("title");
			String writer = rs.getString("writer");
			String regDate = rs.getString("reg_date");
			
			BoardVO vo = new BoardVO(no,title,writer,regDate);
			boardList.add(vo);
		}				
		JDBCClose.close(con, pstmt);
		return boardList;
	}
}
