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
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Electronics> list =new ArrayList<>();
		try {
			conn = DbUtil.getConnection();
			pstmt=conn.prepareStatement(resourceBundle.getString("query.select"));
			rs = pstmt.executeQuery();
			 while(rs.next()){
				 Electronics elec = new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			    list.add(elec);
			 }
		}finally{
			DbUtil.dbClose(conn, pstmt, rs);
		}
		
		return list;
	}

	@Override
	public Electronics selectByModelNum(String modelNum) throws SQLException {
		Connection con = DbUtil.getConnection();
		PreparedStatement ps =null;
		ResultSet rs =null;
		Electronics elec =null;
		try{
			 ps = con.prepareStatement(resourceBundle.getString("query.selectBymodelNum"));
			 ps.setString(1, modelNum);
			 rs = ps.executeQuery();
			 if(rs.next()){
				 elec =new Electronics(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getInt(9));
			 }
		}finally{
			DbUtil.dbClose(con, ps, rs);
		}
		return elec;
	}
	
	@Override
	public int updateByReadNum(String modelNum) throws SQLException {
		Connection con =DbUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement(resourceBundle.getString("query.updateReadnum"));
			ps.setString(1, modelNum);
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int insert(Electronics electronics) throws SQLException {
		Connection con =DbUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement(resourceBundle.getString("query.insert"));
			ps.setString(1, electronics.getModelNum());
			ps.setString(2, electronics.getModelName());
			ps.setInt(3, electronics.getPrice());
			ps.setString(4, electronics.getDescription());
			ps.setString(5, electronics.getPassword());
			ps.setString(6, electronics.getfName());
			ps.setInt(7, electronics.getfSize());
			
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int delete(String modelNum, String password) throws SQLException {
		Connection con =DbUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement(resourceBundle.getString("query.delete"));
			ps.setString(1, modelNum);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}

	@Override
	public int update(Electronics electronics) throws SQLException {
		Connection con =DbUtil.getConnection();
		PreparedStatement ps =null;
		int result =0;
		try{
			ps = con.prepareStatement(resourceBundle.getString("query.update"));
			
			ps.setString(1, electronics.getModelName());
			ps.setInt(2, electronics.getPrice());
			ps.setString(3, electronics.getDescription());
			ps.setString(4, electronics.getModelNum());
			ps.setString(5, electronics.getPassword());
			
			result = ps.executeUpdate();
		}finally{
			DbUtil.dbClose(con, ps);
		}
		return result;
	}


}
