package controller.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.BodyShopVO;
import dto.MemberVO;
import service.BodyshopService;
import service.MemberService;

@WebServlet("/clogin.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
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
		String id = map.get("id");
		String pw = map.get("pw");
		MemberService service = new MemberService();
		MemberVO vo = service.login(id, pw);
		input = mapper.writeValueAsString(vo);
		System.out.println(input);
		out.println(input);

		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}
}
