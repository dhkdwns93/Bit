package board.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {
		//��� �ÿ��� �޾ƿ����� ���� Factory ����
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/hellodb";
			String user = "root";
			String pw = "bitr32";
			
			con = DriverManager.getConnection(url, user, pw);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return con;
	}
}
