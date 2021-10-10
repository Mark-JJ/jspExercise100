package ch06_02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

@MultipartConfig() // 這個是為了要使用 getPart() 方法一定要加的哦！
@WebServlet("/ch06_02/member.do")
public class ProcessMemberServlet extends HttpServlet {
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
		if (id == null || id.trim().length() == 0) {
			errorMessage.put("id", "商品編號欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 pswd 欄位內的資料，注意大小寫
		String password = request.getParameter("pswd");
		// 檢查使用者所輸入的資料
		if (password == null || password.trim().length() == 0) {
			errorMessage.put("password", "商品分類必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mName 欄位內的資料
		String name = request.getParameter("mName");
		// 檢查使用者所輸入的資料
		if (name == null || name.trim().length() == 0) {
			errorMessage.put("name", "商品名稱欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mAddress 欄位內的資料
		String address = request.getParameter("mAddress");
		// 檢查使用者所輸入的資料
		if (address == null || address.trim().length() == 0) {
			errorMessage.put("address", "產地欄必須輸入");
		}
		// 讀取使用者所輸入，由瀏覽器送來的 mPhone 欄位內的資料
		String phone = request.getParameter("mPhone");

		// 讀取使用者所輸入，由瀏覽器送來的 mBirthday 欄位內的資料
		String bday = request.getParameter("mBirthday");
		// 檢核使用者的輸入資料
		java.sql.Date date = null;

		if (bday != null && bday.trim().length() > 0) {
			try {
				date = java.sql.Date.valueOf(bday);
			} catch (IllegalArgumentException e) {
				errorMessage.put("bday", "製造日期欄格式錯誤");
			}
		}

		Timestamp ts = new Timestamp(System.currentTimeMillis());
		String weight = request.getParameter("mWeight");
		double dWeight = -1;
		// 檢核使用者的輸入資料
		if (weight != null && weight.trim().length() > 0) {
			try {
				dWeight = Double.parseDouble(weight.trim());
			} catch (NumberFormatException e) {
				errorMessage.put("weight", "價格欄必須為數值");
			}
		}
		//圖片
		String spt = request.getParameter("picture");
		Blob pt = null;
//		try {
//			pt = new SerialBlob(spt.getBytes("GBK"));
//		} catch (UnsupportedEncodingException | SQLException e1) {
//			errorMessage.put("picture", "檔案錯誤");
//			e1.printStackTrace();
//		}
		Part filePart = request.getPart("picture");
        String filename = filePart.getSubmittedFileName(); // 取得檔名
        System.out.println("取得檔名"+filename);
        
        InputStream in = filePart.getInputStream(); // 取得 InputStream
        OutputStream out = new FileOutputStream("C:\\_JSP\\tomcat9\\webapps\\ROOT\\" + filename); // 定義 OutputStram 輸出位置
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length); // 檔案寫入
        }
		
		// 如果有錯誤，呼叫view元件，送回錯誤訊息
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);   
			return;
		}
		
		// MemberBean 扮演封裝輸入資料的角色
		MemberBean mb = new MemberBean(id, name, password, address, phone, date, ts, dWeight, filename);
		try {
			MemberService service = new MemberService();
			service.insertMember(mb);
			session.setAttribute("memberBean", mb);
			String contextPath = request.getContextPath();
			// 依照執行的結果挑選適當的view元件，送回相關訊息
			// 產生 RequestDispatcher 物件 rd
			response.sendRedirect(response.encodeRedirectURL
					                (contextPath + "/ch06_02/InsertMemberSuccess.jsp"));
			// 請容器代為呼叫下一棒程式
			return;
        } catch (SQLException e) {
			if (e.getMessage().indexOf("重複的索引鍵") != -1 
				|| e.getMessage().indexOf("Duplicate entry") != -1) {
				errorMessage.put("id", "帳號重複，請重新輸入帳號");
			} else {
				errorMessage.put("exception", "資料庫存取錯誤:" + e.getMessage());
			}
			RequestDispatcher rd = request.getRequestDispatcher("/ch06_02/InsertMemberForm.jsp");
			rd.forward(request, response);
			return;
		}
	}
}
