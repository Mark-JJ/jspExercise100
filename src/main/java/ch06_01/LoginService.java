package ch06_01;

public class LoginService {
	public MemberBean checkIDPassword(String id, String password) {
		// 將 MemberDao new為物件，放入變數dao內
		MemberDao dao = new MemberDao();
		// 透過變數dao，呼叫它的select()方法，要傳入參數 id。將傳回值放入變數
        // MemberBean mb 內。
		MemberBean mb = dao.select(id);
        // 如果mb不等於 null 而且參數 password等於mb內的password) {
        if ( mb != null && mb.getPassword().equals(password) ) {
        	// 傳回 mb物件，同時結束本方法
        	 return mb;
        }
        // 傳回null物件
		return null;
	}
}
