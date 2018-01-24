package bit.web.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bit.web.model.vo.MemberVo;
import bit.web.util.DbUtil;

public class MemberDAOImpl implements MemberDAO {

	@Override
	public List<MemberVo> memberSelectAll()  throws SQLException {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<MemberVo> list= new ArrayList<>();
		
		try {
			
			conn = DbUtil.getConnection();
			//쿼리문
			pstmt = conn.prepareStatement("select id,pwd,name,age,phone,addr, join_date from member");
			//?의 개수만큼 순서대로 setXXX( , )
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new MemberVo(rs.getString(1),
										rs.getString(2), 
										rs.getString(3), 
										rs.getInt(4), 
										rs.getString(5),
										rs.getString(6),
										rs.getString(7)));
			}
		} finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public int memberInsert(MemberVo memberVo)  throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			conn=DbUtil.getConnection();
			pstmt = conn.prepareStatement("insert into member(id, pwd, name, age, phone, addr, join_date) "
					+ "values(?,?,?,?,?,?,sysdate)");
			//?의 개수만큼 순서대로 setXxx(,)
			pstmt.setString(1, memberVo.getId());
			pstmt.setString(2, memberVo.getPwd());
			pstmt.setString(3, memberVo.getName());
			pstmt.setInt(4, memberVo.getAge());
			pstmt.setString(5, memberVo.getPhone());
			pstmt.setString(6, memberVo.getAddr());
			
			rs = pstmt.executeUpdate();
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return rs;
	}

	@Override
	public boolean memberByIdCheck(String id)  throws SQLException{
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean rs = false;
		try {
			
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement("select id from member where id=?");
			pstmt.setString(1, id);
			
			pstmt.executeQuery();
			
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		
		return rs;
	}

	@Override
	public int memberDelete(String id)  throws SQLException{
		//conncetion과 PreparedStatement는 무조건 있는것이고 3번째는 리턴타입이라고 보면된다.
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement("delete from member where id = ?");
			pstmt.setString(1, id);
			
			rs = pstmt.executeUpdate();
			
		} finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return rs;
	}

}
