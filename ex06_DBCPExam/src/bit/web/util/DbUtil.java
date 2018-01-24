package bit.web.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DBCP기술 로드 연결 닫기
 * */
public class DbUtil {
	static DataSource ds ;
    static {
    	try {
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
    
    /**닫기
     * dbClose()오버로딩
     *    : DML작업(insert, update, delete)
     */
    public static void dbClose(Connection con, Statement st) {
    	try {
	    	if(st!=null)st.close();
	    	if(con!=null)con.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 닫기(select인 경우)
     */
    public static void dbClose(Connection con, Statement st, ResultSet rs) {
    	try {
    	  if(rs !=null) rs.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	dbClose(con, st);
    	
    }
}











