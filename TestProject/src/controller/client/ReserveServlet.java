package controller.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

@WebServlet("/reserve.do")
public class ReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReserveServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain; charset=utf8");
		request.setCharacterEncoding("UTF-8");

		String input = null;
		StringBuffer sb = new StringBuffer();
		BufferedReader br = new BufferedReader(request.getReader());
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}

		System.out.println(sb.toString());

	}

}
