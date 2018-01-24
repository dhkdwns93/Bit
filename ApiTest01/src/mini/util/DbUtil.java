package mini.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DBCP기술 로드 연결 닫기
 * */
public class DbUtil {
	static DataSource ds ;
    private static ResourceBundle rs;
	static {
    	try {
    		//dbQuery.properties파일을 로딩..
    		rs =ResourceBundle.getBundle("mini.util.dbQuery");
    		
    		//DBCP연결
    		Context context = new InitialContext();
    		 ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
    		 
    		 
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }//static블럭 End
    
    //연결
    public static Connection getConnection()throws SQLException {
    	return ds.getConnection();
    }

    public static void dbClose(Connection conn, Statement st) {
    	try {
	    	if(st!=null)st.close();
	    	if(conn!=null)conn.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
      public static void dbClose(Connection conn, Statement st, ResultSet rs) {
    	try {
    	  if(rs !=null) rs.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	dbClose(conn, st);
    	
    }

	public static ResourceBundle getResourceBundle() {
		
		return rs;
	}

	
	
    
}











