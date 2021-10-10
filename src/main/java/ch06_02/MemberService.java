package ch06_02;

import java.sql.SQLException;
import java.util.List;

public class MemberService {
	
	MemberDao dao = null;
	
	public MemberService() {
		dao = new MemberDao();
	}
	
	public List<MemberBean> findAll() {
		return dao.findAll();
	}
	
	public MemberBean select(String id) {
		return dao.select(id);
	}
	
	public List<MemberBean> select() {
		return dao.select();
	}

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		return dao.insertMember(bean);
	}

	public int delete(String memberId) {
		return dao.delete(memberId);
	}
	
	public MemberBean updateMember(MemberBean bean) throws SQLException {
		return dao.updateMember(bean);
	}
}