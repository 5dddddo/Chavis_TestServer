package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.ClientVO;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
	private static Connection conn = null;

	public static ConnectDB getInstance() {
		return instance;
	}

	public ConnectDB() {
	}

	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "";
	String returns = "a";

	public static void connectionDB() {
		try {
			// oracle 계정
			String jdbcUrl = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
			String userId = "final";
			String userPw = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
	}

	public ClientVO Login(String id, String pw) {
		ClientVO vo = new ClientVO();
		sql = "SELECT * FROM client";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo.setCLIENT_ID(rs.getString("client_id"));
				vo.setCLIENT_NUM(rs.getString("client_num"));
				vo.setCLIENT_NAME(rs.getString("client_name"));
				vo.setCAR_TYPE(rs.getString("car_type"));
				vo.setCAR_ID(rs.getString("car_id"));
				vo.setTEL(rs.getString("tel"));
				vo.setPASSWORD(rs.getString("password"));
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
		return vo;
	}
}