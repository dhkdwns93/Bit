package mini.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import mini.board.dto.ReviewDTO;
import mini.util.DbUtil;

public class BoardDAOimpl implements BoardDAO {
	private ResourceBundle resourceBundle = DbUtil.getResourceBundle();

	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<>();
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.select"));// select * from review order by
																					// re_id desc
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), Double.parseDouble(rs.getString(6)), rs.getString(7));
				list.add(reviewDTO);
			}

		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<ReviewDTO> selectByMid(String mId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<>();
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.selectByMid"));
			pstmt.setString(1, mId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReviewDTO reviewDTO = new ReviewDTO(Integer.parseInt(rs.getString(1)), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5), Double.parseDouble(rs.getString(6)), rs.getString(7));
				list.add(reviewDTO);
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int insertOne(ReviewDTO reviewDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			System.out.println(reviewDTO.getmId() + " : " + reviewDTO.getUserId());
			pstmt = conn.prepareStatement(resourceBundle.getString("query.insertOne"));// insert into review
																						// values(seq_re_id.nextval, ?,
																						// ?, (select user_id from users
																						// where user_id=?),?, ?,?)
			pstmt.setString(1, reviewDTO.getmId());
			pstmt.setString(2, reviewDTO.getRePwd());
			pstmt.setString(3, reviewDTO.getUserId());
			pstmt.setString(4, reviewDTO.getReTitle());
			pstmt.setDouble(5, reviewDTO.getReStar());
			pstmt.setString(6, reviewDTO.getReContent());
			result = pstmt.executeUpdate();
			System.out.println(result);

		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public int deleteOne(int reId, String rePwd) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateOne(ReviewDTO reviewDTO) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
