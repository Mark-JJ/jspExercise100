package ch06_03.model;

import java.util.List;

import ch06_02.MemberBean;

public class MemberService {

	MemberDao  memberDao;
	
	public MemberService() {
		this.memberDao = new MemberDao();
	}

	public List<MemberBean> findAll() {
		return memberDao.findAll();
	}

}
