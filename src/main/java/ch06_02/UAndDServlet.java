package ch06_02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch06_03.model.MemberService;



@WebServlet("/ch06_02/UAndDServlet.do")
public class UAndDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("test");
		MemberService  memberService = new MemberService();
		
		List<MemberBean> members = memberService.findAll();
//		System.out.println("#############"+members.get(0));//[QQ1,狗狗玩偶,台灣,4710114815556,2020-11-29,249.0]
		ArrayList<String> mslist = new ArrayList<String>();

	    request.setAttribute("allMembers", members);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/UpdateAndDelet.jsp");
	    rd.forward(request, response);
		return;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("test");
		MemberService  memberService = new MemberService();
		
		List<MemberBean> members = memberService.findAll();
//		System.out.println("#############"+members.get(0));//[QQ1,狗狗玩偶,台灣,4710114815556,2020-11-29,249.0]
		ArrayList<String> mslist = new ArrayList<String>();

	    request.setAttribute("allMembers", members);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/UpdateAndDelet.jsp");
	    rd.forward(request, response);
		return;
		
	}

}
