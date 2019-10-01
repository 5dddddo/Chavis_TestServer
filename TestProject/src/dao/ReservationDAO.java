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
import dto.ClientVO;
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
			sql = "SELECT * FROM bodyshop where body_id = ? and body_pw = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				vo = new BodyShopVO();
				vo.setBodyshop_num(rs.getString("BODYSHOP_NUM"));
				vo.setAddress(rs.getString("ADDRESS"));
				vo.setLatitude(rs.getString("LATITUDE"));
				vo.setLongitude(rs.getString("LONGITUDE"));
				vo.setBody_pw(rs.getString("BODY_PW"));
				vo.setBody_id(rs.getString("BODY_ID"));
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
			sql = "SELECT KEY, CLIENT_NAME, CAR_TYPE, RESERVE_TIME, REPAIR_TIME "
					+ "FROM CLIENT JOIN reservation on CLIENT.client_NUM = reservation.CLIENT_ID "
					+ "where client_NUM = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ReservationListVO vo = new ReservationListVO();
				vo.setKey(rs.getString("KEY"));
				vo.setClient_name(rs.getString("client_name"));
				vo.setCar_type(rs.getString("car_type"));
				vo.setReserve_time(rs.getString("reserve_time"));
				vo.setRepair_time(rs.getString("repair_time"));
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
