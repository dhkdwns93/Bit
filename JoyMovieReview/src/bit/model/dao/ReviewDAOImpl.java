package bit.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bit.model.dto.ReviewDTO;
import bit.util.DbUtil;

public class ReviewDAOImpl implements ReviewDAO {

	private ResourceBundle resourceBundle = DbUtil.getResourceBundle();

	@Override
	public List<ReviewDTO> selectAll() throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewDTO> list = new ArrayList<ReviewDTO>();
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.select"));
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				System.out.println("dddd");
				//String re_id, String re_title, String user_id, String re_star, String re_content
				ReviewDTO re_dto = new ReviewDTO(rs.getString("re_id"), rs.getString("re_title"), 
						rs.getString("user_id"), rs.getString("re_star"), rs.getString("re_content"));
				System.out.println("re_dto : "+ re_dto);
				list.add(re_dto);
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}

		return list;
	}

	//re_id에 해당하는 리뷰 내용 호출
	@Override
	public ReviewDTO selectByReviewNum(String re_id) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		ReviewDTO re_dto = null;
		try {
			ps = con.prepareStatement(resourceBundle.getString("query.selectByReId"));
			ps.setString(1, re_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				re_dto = new ReviewDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
			}
		} finally {
			DbUtil.dbClose(con, ps, rs);
		}
		return re_dto;
	}

	@Override
	public int updateByReadNum(String re_id) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(resourceBundle.getString("query.updateReadnum"));
			ps.setString(1, re_id);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(ReviewDTO re_dto) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(resourceBundle.getString("query.insert"));
			
			ps.setString(1, re_dto.getRe_id());
			ps.setString(2, re_dto.getM_id());
			ps.setString(3, re_dto.getRe_pwd());
			ps.setString(4, re_dto.getUser_id());
			ps.setString(5, re_dto.getRe_title());
			ps.setString(6, re_dto.getRe_star());
			ps.setString(7, re_dto.getRe_content());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(String re_id, String re_pwd) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(resourceBundle.getString("query.delete"));
			ps.setString(1, re_id);
			ps.setString(2, re_pwd);
			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(ReviewDTO re_dto) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = null;
		int result = 0;
		try {
			ps = con.prepareStatement(resourceBundle.getString("query.update"));

			ps.setString(1, re_dto.getRe_title());
			ps.setString(2, re_dto.getRe_star());
			ps.setString(3, re_dto.getRe_content());
			ps.setString(4, re_dto.getRe_id());
			ps.setString(5, re_dto.getRe_pwd());

			result = ps.executeUpdate();
		} finally {
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

}
