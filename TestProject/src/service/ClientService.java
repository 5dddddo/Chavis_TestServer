package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.ClientDAO;
import dto.ClientVO;

// service 객체를 만들기 위한 class
public class ClientService {
	
	public List<ClientVO> login(String id,String pw) {
		List<ClientVO> list = null;
		Connection con = null;
		ClientVO vo = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ClientDAO dao = new ClientDAO(con);
			vo = dao.login(id,pw);
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
		return list;
	}

	public List<ClientVO> getClientList(String keyword) {
		Connection con = null;
		List<ClientVO> list = null;
		try {
			con = commonDB.ConnectDB.getConnection();
			ClientDAO dao = new ClientDAO(con);
			list = dao.selectClient(keyword);
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

//	public List<BookVO> getBooks(String keyword) {
//		// 로직처리 (DB 처리를 포함)
//		// Transaction : 작업의 최소 단위
//		Connection con = null;
//		List<BookVO> list = null;
//		try {
//			con = commonDB.DBTemplate.getConnection();
//			// common.DBTemplate.getConnection() 코드에
//			// con.setAutoCommit(false); 가 있어서
//			// con 얻어오는 순간 transaction이 시작 됨
//			System.out.println("getBooks() 연결 성공!");
//
//			ClientDAO dao = new ClientDAO(con);
//			list = dao.select(keyword);
//			// 얻어온 결과를 이용해서 transaction의 commit과 rollback을 판단
//			if (list != null) {
//				// transaction이 성공적으로 수행 됨
//				// DB 처리 작업을 실제 DB에 적용
//				con.commit();
//			} else {
//				// transaction 처리에 오류가 있는 경우
//				// DB 처리 작업을 무효화 시킴
//				con.rollback();
//			}
//		} catch (Exception e) {
//			System.out.println(e);
//		} finally {
//			try {
//				con.close();
//			} catch (Exception e) {
//				System.out.println(e);
//			}
//		}
//		return list;
//
//	}

}
