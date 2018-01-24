package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bit.util.DbUtil;
import model.dto.Reviews;

public class ReviewDaoImpl implements ReviewDao {
	private ResourceBundle rb =  DbUtil.getResourceBundle();
	@Override
	public int insertReview(Reviews review) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0 ;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.insertMovie"));
			//pstmt.setString(1, review.getReId());
			pstmt.setString(1, review.getMovieId());
			pstmt.setString(2, review.getRePwd());
			pstmt.setString(3, review.getUserId());
			pstmt.setString(4, review.getReTitle());
			pstmt.setString(5, review.getReStar());
			pstmt.setString(6, review.getReContent());
			
			rs = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return rs;
	}

	@Override
	public boolean pwdCheck( String reId, String rePwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean rs = false;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.pwdCheck"));
			pstmt.setString(1, reId);
			pstmt.setString(2, rePwd);
			
			rs = pstmt.execute();
			
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return rs;
	}

	@Override
	public List<Reviews> selectAllReview() throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		List<Reviews> list= new ArrayList<>();
		
		ResultSet rs = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.selectAllMovie"));
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Reviews review = new Reviews(rs.getString(1),
											 rs.getString(2), 
											 rs.getString(3),
											 rs.getString(4),
											 rs.getString(5),
											 rs.getString(6),
											 rs.getString(7));
				list.add(review);
			}
			
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Reviews selectStar(String movieId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Reviews review = null;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.selectMovieUserId"));
			pstmt.setString(1, movieId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				 review = new Reviews(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		
		return review;
	}

	@Override
	public int updateReivew(Reviews review) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0 ; 
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.updateReview"));
			pstmt.setString(1, review.getMovieId());
			pstmt.setString(2, review.getRePwd());
			pstmt.setString(3, review.getUserId());
			pstmt.setString(4, review.getReTitle());
			pstmt.setString(5, review.getReStar());
			pstmt.setString(6, review.getReContent());
			pstmt.setString(7, review.getReId());
			
			result = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public Reviews selectReviewUserId(String userId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Reviews reviews = null;
		ResultSet rs = null;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.selectReviewUserId"));
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				reviews = new Reviews(rs.getString(1), 
									  rs.getString(2),
									  rs.getString(3),
									  rs.getString(4),
									  rs.getString(5),
									  rs.getString(6),
									  rs.getString(7));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs );
		}
		return reviews;
	}

	@Override
	public int updateSelectByreIdAndUserIdOrRePwd(String reId, String userId, String rePwd) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.updateSelect"));
		
			pstmt.setString(1, reId);
			pstmt.setString(2, userId);
			pstmt.setString(3, rePwd);
			
			rs = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return rs;
	}
	
	
	
	
}
