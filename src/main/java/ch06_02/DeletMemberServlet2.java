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

@WebServlet("/ch06_02/member2.do")
public class DeletMemberServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 定義存放錯誤訊息的 Collection物件
		HttpSession session = request.getSession();
		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);

		// 設定輸入資料的編碼
		request.setCharacterEncoding("UTF-8");
		// 讀取使用者所輸入，由瀏覽器送來的 mId 欄位內的資料，注意大小寫
		String id = request.getParameter("mId");
		// 檢查使用者所輸入的資料
		if (id == null|| id.trim().length() == 0 ) {
			errorMessage.put("id", "商品編號必須輸入");
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/DeletMembers.jsp");
			rd.forward(request, response);
		}else{
			MemberService ms =new MemberService();
			ms.delete(id);
//			JOptionPane.showMessageDialog(null, "資料已刪除", "刪除", 
//			JOptionPane.INFORMATION_MESSAGE);
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/DeletMembersSuccess.jsp");
			rd.forward(request, response);
		}

		
//		if (!errorMessage.isEmpty()) {
//			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/DeletMembers.jsp");
//			rd.forward(request, response);   
//			return;
//		}


		//}
	}
}
