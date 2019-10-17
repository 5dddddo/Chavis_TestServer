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

import dto.MemberVO;
import service.MemberService;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.setContentType("text/plain; charset=utf8");
//		request.setCharacterEncoding("UTF-8");
//		PrintWriter out = response.getWriter();
//
//		String input = null;
//		StringBuffer sb = new StringBuffer();
//		BufferedReader br = new BufferedReader(request.getReader());
//
//		while ((input = br.readLine()) != null) {
//			sb.append(input);
//		}
//
//		ObjectMapper mapper = new ObjectMapper();
//		MemberVO vo = mapper.readValue(sb.toString(), MemberVO.class);
//
//		MemberService service = new MemberService();
//		boolean res = service.register(vo);
//
//		System.out.println(res);
//		out.println(res);
//
//		// 데이터 보내기
//		out.flush();
//		// 데이터 통로 닫기
//		out.close();
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
		MemberVO vo = new MemberVO();
		Map<String, String> map = mapper.readValue(sb.toString(), Map.class);
		vo.setMember_id(map.get("member_id"));
		vo.setMember_pw(map.get("member_pw"));
		vo.setMember_mname(map.get("member_mname"));
		vo.setMember_phonenumber(map.get("member_phonenumber"));
		vo.setCar_id(map.get("car_id"));
		vo.setCar_type(map.get("car_type"));
		vo.setCar_color(map.get("car_color"));

		System.out.println("map : " + map.get("car_type"));
		MemberService service = new MemberService();
		boolean res = service.register(vo);
		System.out.println("dfdfdfdff : " + res);
		PrintWriter out = response.getWriter();
		out.print(res==true?"true":"false");
		out.flush();
		out.close();
		// 데이터 통로 닫기
		br.close();

	}

}
