package commonDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberVO;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();

	public static ConnectDB getInstance() {
		return instance;
	}

	public ConnectDB() {
	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			// oracle 계정
			String jdbcUrl = "jdbc:oracle:thin:@70.12.115.70:1521:xe";
			String userId = "final";
			String userPw = "1234";
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(jdbcUrl, userId, userPw);
			System.out.println("DB 연결 성공");
		} catch (Exception e) {
			System.out.println("DB 연결 실패");
		}
		return con;
	}

	public MemberVO Login(String id, String pw) {
		return null;
	}


}