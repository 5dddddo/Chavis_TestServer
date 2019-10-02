package controller.member;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.MemberVO;
import dto.ReservationVO;
import service.MemberService;

@WebServlet("/reserve.do")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReserveServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		request.setCharacterEncoding("UTF-8");
		
		ObjectMapper mapper = new ObjectMapper();

		String input = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(request.getReader());
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}

		System.out.println(sb.toString());
		Map<String, String> map = mapper.readValue(sb.toString(), Map.class);
		System.out.println("map : " + map.get("key"));
		
		
		PrintWriter out = response.getWriter();
		out.print("배고프다ㅗㄱ아ㅗㄹ맞ㄴㅇ됨로옥 언제가냐고오ㅗ과ㅗㄹ아ㅗㄱ");
		out.flush();
		out.close();
		// 데이터 통로 닫기
		br.close();
	}

}
