package bit.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bit.model.dto.Electronics;
import bit.util.DbUtil;

public class ElecDAOImpl implements ElecDAO {
	
	private ResourceBundle resourceBundle = DbUtil.getResourceBundle();
	
	@Override
	public List<Electronics> selectAll() throws SQLException {
			Connection conn = null;
			PreparedStatement pstmt = null;
			List<Electronics> list= new ArrayList<>();
			ResultSet rs = null;
			
			try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.select"));
									//query.select = select * from Electronics
			rs = pstmt.executeQuery();
			System.out.println(11);
			while(rs.next()) {
				System.out.println(11);
			list.add(new Electronics(rs.getString(1),
									rs.getString(2),
									rs.getInt(3),
									rs.getString(4),
									rs.getString(5),
									rs.getString(6),
									rs.getInt(7),
									rs.getString(8),
									rs.getInt(9)));	
			}
		}finally {
			DbUtil.dbClose(conn, pstmt, rs);
		}
			
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum, boolean flag) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Electronics es = null;
		
		try {
			conn = DbUtil.getConnection();
			pstmt = conn.prepareStatement(resourceBundle.getString("query.selectBymodelNum"));
			pstmt.setString(1, modelNum);
			es = (Electronics) pstmt.executeQuery();
			
		}finally {
			DbUtil.dbClose(conn, pstmt);
		}
		return es;
	}
	
	@Override
	public int updateByReadNum(String modelNum) throws SQLException {
		
		return 0;
	}
	
	@Override
	public int insert(Electronics electronics) throws SQLException {
		
		return 0;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		
		return 0;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		
		return 0;
	}

	

}
