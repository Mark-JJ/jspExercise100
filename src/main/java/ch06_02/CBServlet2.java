package ch06_02;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/ch06_02/CBS2.do")
public class CBServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("mId");
		if (id == null|| id.trim().length() == 0 ) {
			errorMessage.put("id", "商品編號必須輸入");
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/CB.jsp");
			rd.forward(request, response);
		}else{
			MemberService ms =new MemberService();
			ms.delete(id);

			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/CBS.do");
			rd.forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("mId");
		if (id == null|| id.trim().length() == 0 ) {
			errorMessage.put("id", "商品編號必須輸入");
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/CB.jsp");
			rd.forward(request, response);
		}else{
			MemberService ms =new MemberService();
			ms.delete(id);

			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/CBS.do");
			rd.forward(request, response);
		}
	}
	
}
