package white.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DbUtil {
	static DataSource ds;
	private static ResourceBundle resourceBundle;
	static {
		try {
			//dbQuery.properties 파일 로딩
			resourceBundle = ResourceBundle.getBundle("bit.model.dao.dbQuery");
			
			//DBCP 연결
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:/comp/env/jdbc/myoracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}// static블럭 End

	// 연결
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

	// 닫기
	// DML 작업(insert,update,delete)
	public static void dbClose(Connection con, Statement st) {
		try {
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 닫기(select인 경우)
	public static void dbClose(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbClose(con, st);
	}
	
	public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}
