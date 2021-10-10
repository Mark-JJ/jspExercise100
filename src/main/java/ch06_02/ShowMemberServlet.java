package ch06_02;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ch06_03.model.MemberService;



@WebServlet("/ch06_02/ShowMember.do")
public class ShowMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("test");
		MemberService  memberService = new MemberService();
		
		List<MemberBean> members = memberService.findAll();
//		System.out.println(members.size());
	    request.setAttribute("allMembers", members);
	    
	    RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/DeletMembers.jsp");
	    rd.forward(request, response);
		return;
		
	}

}
