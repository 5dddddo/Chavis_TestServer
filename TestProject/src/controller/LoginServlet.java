package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connectDB.ConnectDB;
import vo.ClientVO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		ConnectDB db = ConnectDB.getInstance();
		id = "oea0805";
		pw = "1234";
		ClientVO res = db.Login(id, pw);
		System.out.println(res);
		out.println(res);

//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(result);

		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}

}
