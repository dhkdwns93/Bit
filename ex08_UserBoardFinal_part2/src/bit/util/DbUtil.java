package bit.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * DBCP��� �ε� ���� �ݱ�
 * */
public class DbUtil {
	static DataSource ds ;
	private static ResourceBundle resourceBundle;
    static {
    	try {
    		//dbQuery.properties������ �ε�.
    		resourceBundle = ResourceBundle.getBundle("bit.model.dao.dbQuery");//dbQuery.properties
    	
    		System.out.println(resourceBundle.getString("query.select"));
    		
    		//DBCP����
    		Context context = new InitialContext();
    		 ds = (DataSource)context.lookup("java:/comp/env/jdbc/myoracle");
    	}catch (Exception e) {
			e.printStackTrace();
		}
    }//static�� End
    
    
    
    
    /**
     * ����
     * 
     * @return
     * @throws SQLException
     */
    public static Connection getConnection()throws SQLException {
    	return ds.getConnection();
    }
    
    /**
     * �ݱ�
     *   : DML�۾�(insert, update, delete)
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
     * �ݱ�(select�ΰ��)
     * */
    public static void dbClose(Connection con, Statement st, ResultSet rs) {
    	try {
    	  if(rs !=null) rs.close();
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	dbClose(con, st);
    	
    }
    
    public static ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
}











