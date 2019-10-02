package controller.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MemberVO;
import service.MemberService;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
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

		ObjectMapper mapper = new ObjectMapper();
		MemberVO vo = mapper.readValue(sb.toString(), MemberVO.class);

		MemberService service = new MemberService();
		boolean res = service.register(vo);

		System.out.println(res);
		out.println(res);

		// 데이터 보내기
		out.flush();
		// 데이터 통로 닫기
		out.close();

	}

}
