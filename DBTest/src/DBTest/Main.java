package DBTest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstm = null;

		String query = "select * from departments";

		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query);

			ResultSet rs = pstm.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt(1)+"/"+rs.getString(2)+"/"+rs.getInt(3)+"/"+rs.getInt(4));
			}

		}catch(Exception e){
			System.out.println(e);
		}finally {
			try {
				if (pstm != null)
					pstm.close();

				if(conn != null)
					conn.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		String query2 ="insert into DEPARTMENTS(DEPARTMENT_ID,DEPARTMENT_NAME,MANAGER_ID,LOCATION_ID)"+"values(300,'DOS',200,1700)";
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query2);
			
			pstm.executeQuery();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if (pstm != null)
					pstm.close();

				if(conn != null)
					conn.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		String query3 ="UPDATE DEPARTMENTS SET DEPARTMENT_NAME = 'DOS' WHERE LOCATION_ID=1700";
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query3);
			
			pstm.executeQuery();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if (pstm != null)
					pstm.close();

				if(conn != null)
					conn.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
		String query4 ="DELETE FROM DEPARTMENTS WHERE DEPARTMENT_ID = 300";
		try {
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(query4);
			
			pstm.executeQuery();
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				if (pstm != null)
					pstm.close();

				if(conn != null)
					conn.close();
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		
	}
}
