package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import dao.MemberDAO;
import dto.MemberVO;
import dto.ReservationVO;

// service 객체를 만들기 위한 class
public class MemberService {
	public MemberVO login(String id, String pw) {
		Connection con = null;
		MemberVO vo = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			vo = dao.login(id, pw);
			if (vo != null) {;
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

	public List<ReservationVO> getMemberList(String keyword) {
		Connection con = null;
		List<ReservationVO> list = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			list = dao.getMemberList(keyword);
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

	public boolean register(MemberVO vo) {
		Connection con = null;
		boolean flag = false;
		try {
			con = commonDB.ConnectDB.getConnection();
			MemberDAO dao = new MemberDAO(con);
			flag = dao.register(vo);
			if (flag == true) {
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
		return flag;
	}

}
