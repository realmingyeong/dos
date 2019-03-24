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
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();
		}finally {
			//DataBase 연결 종료
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
		Connection conn = null; //DataBase에 연결된 상태를 담은 객체
		PreparedStatement pstm = null; //SQL문을 담은 객체
		int rs;

		try {
			String quary = "insert into user1 values (?,?,?)";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);

			//dto 객체 안에 생성된 구성 속성들을 가져옴 
			pstm.setString(1, ""+dto.getNo()+"");
			pstm.setString(2, ""+dto.getId()+"");
			pstm.setString(3,""+dto.getPassword()+"");

			rs = pstm.executeUpdate();

			System.out.println(rs);
		}catch(SQLException sqle) {
			System.out.println("SELECT문에서  예외 발생");
			sqle.printStackTrace();
		}finally {
			//DataBase 연결 종료
			try {
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			}catch(Exception e) {
				throw new RuntimeException(e.getMessage()); 
			}
		}
	}
	
/*	public static void delete(String id) {
		Connection conn = null; //DataBase에 연결된 상태를 담은 객체
		PreparedStatement pstm = null; //SQL문을 담은 객체
		int rs;

		try {
			String quary = "DELETE FROM user1 WHERE id='(?)'";

			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeUpdate();
			
			

			System.out.println(rs);
		}catch(SQLException sqle) {
			System.out.println("SELECT문에서  예외 발생");
			sqle.printStackTrace();
		}finally {
			//DataBase 연결 종료
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
