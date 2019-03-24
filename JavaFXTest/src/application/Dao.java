package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao{
	public static void select() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String quary = "select * FROM user1";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();

			while(rs.next()) {
				int no = rs.getInt(1);
				String name = rs.getString(2);

				String result = no+" "+name ;
				System.out.println(result);
			}
		}catch (SQLException sqle) {
			System.out.println("SELECT������ ���� �߻�");
			sqle.printStackTrace();
		}finally {
			//DataBase ���� ����
			try {
				if(rs != null) {rs.close();}
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
	}


	public static void insert(UserDto dto) {
		Connection conn = null; //DataBase�� ����� ���¸� ���� ��ü
		PreparedStatement pstm = null; //SQL���� ���� ��ü
		int rs;

		try {
			String quary = "insert into user1 values (?,?,?)";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);

			//dto ��ü �ȿ� ������ ���� �Ӽ����� ������ 
			pstm.setString(1, ""+dto.getNo()+"");
			pstm.setString(2, ""+dto.getId()+"");
			pstm.setString(3,""+dto.getPassword()+"");

			rs = pstm.executeUpdate();

			System.out.println(rs);
		}catch(SQLException sqle) {
			System.out.println("SELECT������  ���� �߻�");
			sqle.printStackTrace();
		}finally {
			//DataBase ���� ����
			try {
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
	}
	
/*	public static void delete(String id) {
		Connection conn = null; //DataBase�� ����� ���¸� ���� ��ü
		PreparedStatement pstm = null; //SQL���� ���� ��ü
		int rs;

		try {
			String quary = "DELETE FROM user1 WHERE id='(?)'";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeUpdate();
			
			

			System.out.println(rs);
		}catch(SQLException sqle) {
			System.out.println("SELECT������  ���� �߻�");
			sqle.printStackTrace();
		}finally {
			//DataBase ���� ����
			try {
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
	}
	*/
}
