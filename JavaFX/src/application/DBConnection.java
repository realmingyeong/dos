package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn =null;

		try {
			String url="jdbc:oracle:thin:@localhost:1522:orcl";
			String user = "hr";
			String pw = "hr";

			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,user,pw);
		}catch(ClassNotFoundException e) {
			System.out.println("DB DRIVER LOADING FAIL : "+e);
		}catch(SQLException e) {
			System.out.println("DB CONNECTION FAIL : "+e);
		}catch(Exception e) {
			System.out.println("Unknown : "+e);
		}
		return conn;
	}
}
