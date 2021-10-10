package ch06_02;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet("/ch06_02/member4.do")
public class SelectMemberServlet extends HttpServlet {
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
//		String password = request.getParameter("pswd");
//		String name = request.getParameter("mName");
//		String address = request.getParameter("mAddress");
//		String phone = request.getParameter("mPhone");
//		String bday = request.getParameter("mBirthday");
//		java.sql.Date date = java.sql.Date.valueOf(bday);
////		date = java.sql.Date.valueOf(bday);
//		Timestamp ts = new Timestamp(System.currentTimeMillis());
//		String weight = request.getParameter("mWeight");
//		double dWeight = -1;
//		dWeight = Double.parseDouble(weight.trim());
		
		// 檢查使用者所輸入的資料
//		MemberBean mb = new MemberBean(id, name, password, address, phone, date, ts, dWeight);
		if (id == null|| id.trim().length() == 0 ) {
			errorMessage.put("id", "商品編號必須輸入");
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/SelectMembers.jsp");
			rd.forward(request, response);
		}
		else{
			MemberService ms =new MemberService();
//			ms.select(id);
			session.setAttribute("memberBean", ms.select(id));

			System.out.println(id);
			String contextPath = request.getContextPath();
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			response.sendRedirect(response.encodeRedirectURL
					                (contextPath + "/ch06_02/SelectMembersSuccess.jsp"));
			// 請容器代為呼叫下一棒程式
//			return;
//			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/SelectMembersSuccess.jsp");
//			rd.forward(request, response);
		}


	}
}
