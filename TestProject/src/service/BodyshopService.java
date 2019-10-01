package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ClientDAO;
import dao.ReservationDAO;
import dto.BodyShopVO;
import dto.ClientVO;
import dto.ReservationListVO;
import dto.ReservationVO;

// service 객체를 만들기 위한 class
public class BodyshopService {

	public BodyShopVO bodyshoplogin(String id, String pw) {
		Connection con = null;
		BodyShopVO vo = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ReservationDAO dao = new ReservationDAO(con);
			vo = dao.bodyshoplogin(id, pw);
			if (vo != null) {
				con.commit();
			} else {
				vo.setBodyshop_num("0");
				con.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return vo;
	}
	public List<ReservationListVO> getReserveList(String id) {
		Connection con = null;
		List<ReservationListVO> list = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ReservationDAO dao = new ReservationDAO(con);
			list = dao.getReserveList(id);
			if (id != null) {
				con.commit();
			} else {
//				id.setBodyshop_num("0");
				con.rollback();
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}
}
