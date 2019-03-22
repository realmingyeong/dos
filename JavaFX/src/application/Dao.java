package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao{

	@Override
	public void createUser(UserDto user) implements UserDto {
		Connection conn = null;
		PreparedStatement pstm = null;

		String query = "insert into Users(userNo,id,password,name)" + "values(SEQ_USERS.nextVal,?,?,?)";
		try {
			conn = DBConnection.DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getPw());

			pstm.executeQuery();
		} catch (SQLException e) {
			throw new RuntimeException("in create exception", e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean isExist(String id) {
		Connection conn = null;
		PreparedStatement pstm = null;

		String query = "select id from Users";
		try {
			conn = DBConnection.DBConnection.getConnection();
			pstm = conn.prepareStatement(query);

			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getString(1));
				if (rs.getString(1).equals(id)) {
					return true;
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("in check exception", e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public UserDto login(String id, String pw) {
		UserDto result = null;
		Connection conn = null;
		PreparedStatement pstm = null;

		String query = "select * from Users where id = ? and password = ?";
		try {
			conn = DBConnection.DBConnection.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);

			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				result = new UserDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			throw new RuntimeException("in create exception", e);
		} finally {
			try {
				if (pstm != null)
					pstm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}