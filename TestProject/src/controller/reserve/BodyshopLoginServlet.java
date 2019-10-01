package controller.reserve;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.BodyShopVO;
import dto.ClientVO;
import service.BodyshopService;
import service.ClientService;

@WebServlet("/blogin")
public class BodyshopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BodyshopLoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		System.out.println(id + "  " + pw);
		
		BodyshopService service = new BodyshopService();
		ObjectMapper mapper = new ObjectMapper();
		BodyShopVO res = service.bodyshoplogin(id, pw);
		String json = mapper.writeValueAsString(res);
		System.out.println(json);
		out.println(json);


		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}

}
