package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ClientDAO;
import dto.BodyShopVO;
import dto.ClientVO;
import dto.ReservationVO;

// service 객체를 만들기 위한 class
public class ClientService {
	public ClientVO login(String id, String pw) {
		Connection con = null;
		ClientVO vo = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ClientDAO dao = new ClientDAO(con);
			vo = dao.login(id, pw);
			if (vo != null) {
				con.commit();
			} else {
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

	public List<ReservationVO> getClientList(String keyword) {
		Connection con = null;
		List<ReservationVO> list = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ClientDAO dao = new ClientDAO(con);
			list = dao.getClientList(keyword);
			if (list != null) {
				con.commit();
			} else {
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

	public BodyShopVO bodyshoplogin(String id, String pw) {
		Connection con = null;
		BodyShopVO vo = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ClientDAO dao = new ClientDAO(con);
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

}
