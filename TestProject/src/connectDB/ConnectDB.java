package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}

	public ConnectDB() {
	}

	// oracle 계정
	String jdbcUrl = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
	String userId = "final";
	String userPw = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "";
	String returns = "a";

	public String connectionDB(String id, String pw) {
		try {
			id = "oea0805";
			pw = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
			System.out.println("DB 연결 성공");

			sql = "SELECT * FROM client";
			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setInt(2, 1234);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println(rs.getString("client_id"));
			} else {

				returns = "로그인 실패";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException ex) {
				}
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ex) {
				}
		}
		return returns;
	}
}