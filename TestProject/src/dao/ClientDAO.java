// connection을 공용으로 사용해서 service가 transaction 단위로 동작
// dao에 있던 connection 코드를 service로 옮김

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ClientVO;


public class ClientDAO {

	// 하나의 Transaction으로 동작하기 위해
	// 멤버 변수로 Connection을 선언하고 이 Connection을 공유하여 사용
	private Connection con;

	public ClientDAO(Connection con) {
		this.con = con;
	}

	public List<ClientVO> getClientList(String keyword) {
		// keyword를 입력 받아서 DB 검색해서
		// String[] 만들어서 return 해주는 DB 처리
		// logic 나오면 안 됨!

		List<ClientVO> list = new ArrayList<ClientVO>();
		try {
			// 상당히 로드가 많이 걸리는 JDBC 작업 -> 비효율적
			// Connection Pool을 사용하는 코드로 재작성
			// Apache Tomcat은 DBCP라는 ConnectionPool 기능을 제공
			// DBCP는 JNDI를 이용

			// Connection pool로부터 connection을 빌려와서 사용하므로
			// 사용자가 늘어나도 load가 커지지 않음

			// 3. Statement 생성
			String sql = "select * from reservation";
			PreparedStatement pstmt = con.prepareStatement(sql);

			// 4. Query 설정
			ResultSet rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {
				list.add(rs.getString("btitle"));
			}

			// 6. 사용한 resource 해제
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public ClientVO login(String id, String pw) {
		ClientVO vo = new ClientVO();
		String sql = "SELECT * FROM client";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
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
