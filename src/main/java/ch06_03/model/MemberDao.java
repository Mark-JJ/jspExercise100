package ch06_03.model;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch06_02.MemberBean;

public class MemberDao {

	Context context ;
	
	public MemberDao() {
		try {
			context = new InitialContext();  
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public List<MemberBean> findAll() {
		List<MemberBean> members = new ArrayList<>();
		String sql = "SELECT * FROM Member42";
		try {
			DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
			try (Connection connection = dataSource.getConnection();
				 PreparedStatement stmt = connection.prepareStatement(sql);
				 ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					MemberBean memberBean = new MemberBean();
					memberBean.setMemberId(rs.getString("memberId"));
					memberBean.setPassword(rs.getString("password"));
					memberBean.setName(rs.getString("name"));
					memberBean.setAddress(rs.getString("address"));
					memberBean.setBirthday(rs.getDate("birthday"));
					memberBean.setPhone(rs.getString("phone"));
					memberBean.setRegisterDate(rs.getTimestamp("registerdate"));
					memberBean.setWeight(rs.getInt("weight"));
					memberBean.setPicture(rs.getString("picture"));

					members.add(memberBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}

}
