package controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ReservationVO;
import service.MemberService;

@WebServlet("/rlist.do")
public class ReserveListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReserveListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		MemberService service = new MemberService();
		ObjectMapper mapper = new ObjectMapper();

		List<ReservationVO> res = service.getMemberList(id);

		String json = mapper.writeValueAsString(res);
		System.out.println(json);
		out.println(json);

//		ObjectMapper mapper = new ObjectMapper();
//		String json = mapper.writeValueAsString(result);

		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}

}
