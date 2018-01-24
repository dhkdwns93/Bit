package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import bit.util.DbUtil;
import model.dto.Members;

public class MemberDaoImpl implements MemberDao {
	private ResourceBundle rb  = DbUtil.getResourceBundle();

	@Override
	public int insertMember(Members member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.insert"));
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPwd());
//			pstmt.setString(3, member.getPwdCheck());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			
			result = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public int updateMember(Members member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.update"));
			pstmt.setString(1, member.getPwd());
//			pstmt.setString(2, member.getPwdCheck());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getGender());
			
			result = pstmt.executeUpdate();
			
		}finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return result;
	}

	@Override
	public Members loginMember(Members member) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Members members  = null;
		
		try {
			conn = DbUtil.getConnection();
			
					
			
			pstmt = conn.prepareStatement(rb.getString("query.userlogin"));
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				members = new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		
		return members;
	}

	@Override
	public Members selectUserId(String userId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Members members = null;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(rb.getString("query.selectUserId"));
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
			members = new Members(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return members;
	}
	
	

}
