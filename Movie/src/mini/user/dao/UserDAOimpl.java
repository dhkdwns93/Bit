package mini.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import mini.user.dto.UserDTO;
import mini.util.DbUtil;

public class UserDAOimpl implements UserDAO {
	ResourceBundle rb = DbUtil.getResourceBundle();

	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dbUserDTO = null;

		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("user.query.select"));
			pstmt.setString(1, userDTO.getUserId());
			pstmt.setString(2, userDTO.getPwd());

			rs = pstmt.executeQuery();
			System.out.println(rs);
			if (rs.next()) {
				dbUserDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}

		return dbUserDTO;
	}

	@Override
	public int insertUser(UserDTO userDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("user.query.insert"));
			pstmt.setString(1, userDTO.getUserId());
			pstmt.setString(2, userDTO.getPwd());
			pstmt.setString(3, userDTO.getName());
			pstmt.setString(4, userDTO.getGender());
			result = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public int updateUser(UserDTO userDTO) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int result = 0;

		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("user.query.update"));
			pstmt.setString(1, userDTO.getPwd());
			pstmt.setString(2, userDTO.getName());
			pstmt.setString(3, userDTO.getGender());
			pstmt.setString(4, userDTO.getUserId());

			result = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public int deleteUser(String userId, String pwd) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("user.query.delete"));
			pstmt.setString(1, userId);
			pstmt.setString(2, pwd);
			result = pstmt.executeUpdate();

		} finally {
			DbUtil.dbClose(conn, pstmt);
		}

		return result;
	}

}
