package controller.bodyshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.BodyShopVO;
import dto.ReservationListVO;
import service.BodyshopService;

@WebServlet("/blist.do")
public class BodyshopListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BodyshopListServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		String input = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(request.getReader());

		while ((input = br.readLine()) != null) {
			sb.append(input);
		}
		System.out.println(sb.toString());
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> map = mapper.readValue(sb.toString(), Map.class);
		String id = map.get("bodyshop_no");
		BodyshopService service = new BodyshopService();
		List<ReservationListVO> vo = service.getReserveList(id);
		input = mapper.writeValueAsString(vo);
		System.out.println(input);
		out.println(input);

		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}

}
