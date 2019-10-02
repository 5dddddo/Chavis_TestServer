// connection을 공용으로 사용해서 service가 transaction 단위로 동작
// dao에 있던 connection 코드를 service로 옮김

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BodyShopVO;
import dto.MemberVO;
import dto.ReservationListVO;
import dto.ReservationVO;

public class ReservationDAO {

	// 하나의 Transaction으로 동작하기 위해
	// 멤버 변수로 Connection을 선언하고 이 Connection을 공유하여 사용
	private Connection con;

	public ReservationDAO(Connection con) {
		this.con = con;
	}

	public BodyShopVO bodyshoplogin(String id, String pw) {

		BodyShopVO vo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		try {
			sql = "SELECT * FROM bodyshop where bodyshop_id = ? and bodyshop_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
		
			while (rs.next()) {
				vo = new BodyShopVO();
				vo.setBodyshop_no(rs.getInt("bodyshop_no"));
				vo.setBodyshop_id(rs.getString("bodyshop_id"));
				vo.setBodyshop_pw(rs.getString("bodyshop_pw"));
				vo.setBodyshop_name(rs.getString("bodyshop_name"));
				vo.setBodyshop_address(rs.getString("bodyshop_address"));
				vo.setBodyshop_lat(rs.getString("bodyshop_lat"));
				vo.setBodyshop_long(rs.getString("bodyshop_long"));
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
	
	public List<ReservationListVO> getReserveList(String id) {

		List<ReservationListVO> list = new ArrayList<ReservationListVO>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
	
		try {
			sql = "SELECT key,key_expire_time,member_mname,car_type,car_id,reservation_time,repaired_time,repaired_person "
					+ "FROM member join reservation on member.member_no = reservation.member_no "
					+ "join car on member.member_no =  car.car_no where member_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReservationListVO vo = new ReservationListVO();
				vo.setKey(rs.getString("key"));
				vo.setKey_expire_time(rs.getString("key_expire_time"));
				vo.setMember_mname(rs.getString("member_mname"));
				vo.setCar_type(rs.getString("car_type"));
				vo.setRepaired_person(rs.getString("repaired_person"));
				vo.setReservation_time(rs.getString("reservation_time"));
				vo.setRepaired_time(rs.getString("repaired_time"));
				list.add(vo);
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
		return list;
	}
}
