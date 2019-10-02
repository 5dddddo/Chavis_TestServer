package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.MemberVO;
import dto.ReservationVO;

public class MemberDAO {

	// 하나의 Transaction으로 동작하기 위해
	// 멤버 변수로 Connection을 선언하고 이 Connection을 공유하여 사용
	private Connection con;

	public MemberDAO(Connection con) {
		this.con = con;
	}

	public List<ReservationVO> getMemberList(String keyword) {
		// keyword를 입력 받아서 DB 검색해서
		// String[] 만들어서 return 해주는 DB 처리
		// logic 나오면 안 됨!

		List<ReservationVO> list = new ArrayList<ReservationVO>();
		try {
			// 상당히 로드가 많이 걸리는 JDBC 작업 -> 비효율적
			// Connection Pool을 사용하는 코드로 재작성
			// Apache Tomcat은 DBCP라는 ConnectionPool 기능을 제공
			// DBCP는 JNDI를 이용

			// Connection pool로부터 connection을 빌려와서 사용하므로
			// 사용자가 늘어나도 load가 커지지 않음

			// 3. Statement 생성
			String sql = "SELECT reservation_no, bodyshop_no, repaired_person, reservation_time, repaired_time, key "
					+ "FROM RESERVATION JOIN MEMBER ON RESERVATION.member_no = MEMBER.member_no "
					+ "WHERE MEMBER.member_no = "
					+ "(select member_no from member where member_id= ?)"
					+ " ORDER BY reservation_no";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,keyword);
			// 4. Query 설정
			ResultSet rs = pstmt.executeQuery();

			// 5. 결과 처리
			while (rs.next()) {
				ReservationVO vo = new ReservationVO();
				vo.setReservation_no(rs.getInt("reservation_no"));
				vo.setBodyshop_no(rs.getInt("bodyshop_no"));
				vo.setKey(rs.getString("key"));
				vo.setReservation_time(rs.getString("reservation_time"));
				vo.setRepaired_time(rs.getString("repaired_time"));
				vo.setRepaired_person(rs.getString("repaired_person"));
				list.add(vo);
			}
			// 6. 사용한 resource 해제
			rs.close();
			pstmt.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

	public MemberVO login(String id, String pw) {

//      Map<String, String> vo = new HashMap<String, String>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		MemberVO vo = null;

		try {
			sql = "SELECT * FROM member where member_id = ? and member_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new MemberVO();
				vo.setMember_no(rs.getInt("member_no"));
				vo.setMember_id(rs.getString("member_id"));
				vo.setMember_pw(rs.getString("member_pw"));
				vo.setMember_mname(rs.getString("member_mname"));
				vo.setMember_phonenumber(rs.getString("member_phonenumber"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}

			}
			if (con != null) {
				try {
					System.out.println("login 연결 끊기 성공");
					con.close();
				} catch (SQLException e) {
					System.out.println("login 연결 끊기 실패");
				}
			}
		}
		return vo;
	}

	public boolean register(MemberVO vo) {
		boolean flag = false;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "INSERT INTO MEMBER (MEMBER_NO,MEMBER_ID,MEMBER_PW,MEMBER_MNAME,MEMBER_PHONENUMBER) "
				+ "VALUES(MEMBER_NO_SEQUENCE.nextval-1 ,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getMember_id());
			pstmt.setString(2, vo.getMember_pw());
			pstmt.setString(3, vo.getMember_mname());
			pstmt.setString(4, vo.getMember_phonenumber());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("rs : " + rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			if (con != null) {
				try {
					System.out.println("login 연결 끊기 성공");
					con.close();
				} catch (SQLException e) {
					System.out.println("login 연결 끊기 실패");
				}
			}
		}
		return flag;
	}

}