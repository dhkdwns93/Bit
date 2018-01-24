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
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserDTO dbUserDTO = null;
		
		try {
			conn = DbUtil.getConnection();
			
			pstmt = conn.prepareStatement(resourceBundle.getString("query.userlogin"));
			pstmt.setString(1, userDTO.getUserId());
			pstmt.setString(2, userDTO.getPwd());
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dbUserDTO = new UserDTO(rs.getString(1),
										rs.getString(2));	
			}
		}finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		return dbUserDTO;
	}

}
