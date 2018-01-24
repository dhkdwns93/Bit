package bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import bit.model.dto.UserDTO;
import bit.util.DbUtil;

public class UserDAOImpl implements UserDAO {
    private ResourceBundle resourceBundle = DbUtil.getResourceBundle();
    
	@Override
	public UserDTO loginCheck(UserDTO userDTO) throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		UserDTO dbUserDTO=null;
		try {
			conn= DbUtil.getConnection();
			pstmt=conn.prepareStatement(resourceBundle.getString("query.userlogin"));
			pstmt.setString(1, userDTO.getUser_id());
			pstmt.setString(2, userDTO.getPwd());
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				dbUserDTO= new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		}finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		
		return dbUserDTO;
	}


	@Override
	public int updateMember(UserDTO userDTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.update"));
			pstmt.setString(1, userDTO.getPwd());
			pstmt.setString(2, userDTO.getName());
			pstmt.setString(3, userDTO.getGender());
			
			result = pstmt.executeUpdate();
			
		}finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public int insertMember(UserDTO userDTO) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.insert"));
			pstmt.setString(1, userDTO.getUser_id());
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
	public UserDTO selectUserId(String user_id) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO userDTO = null;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.selectUserId"));
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				userDTO = new UserDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return userDTO;
	}
	
}









