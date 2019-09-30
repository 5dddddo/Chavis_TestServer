package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.ClientVO;
import dto.ReservationVO;
import service.ClientService;

@WebServlet("/list.do")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
//		System.out.println(id + "  " + pw);
		ClientService service = new ClientService();
		ObjectMapper mapper = new ObjectMapper();

		List<ReservationVO> res = service.getClientList(id);

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
