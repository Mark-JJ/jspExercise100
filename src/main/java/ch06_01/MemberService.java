package ch06_01;

import java.sql.SQLException;
import java.util.List;

public class MemberService {
	
	MemberDao dao = null;
	
	public MemberService() {
		dao = new MemberDao();
	}	

	public MemberBean select(String id) {
		return dao.select(id);
	}
	
	
}