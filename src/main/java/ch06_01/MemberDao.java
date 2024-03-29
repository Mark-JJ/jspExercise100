﻿package ch06_01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Blob;

public class MemberDao {
	
	DataSource ds = null;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}	

	private static final String SELECT_BY_ID = "Select memberId, password from LoginNmber where memberId = ?";

	public MemberBean select(String id) {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

		) {
			System.out.println("1=="+id);
			stmt.setString(1, id);
			try (
				ResultSet rset = stmt.executeQuery();	
			){
				if (rset.next()) {
					System.out.println("2=="+rset.getString("memberid"));
					System.out.println("3=="+rset.getString("password"));
					result = new MemberBean();
					result.setMemberId(rset.getString("memberid"));
					result.setPassword(rset.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.toString());
		} 
		return result;
	}
	
	private static final String SELECT_ALL = "Select memberId, password, name, address, phone, birthday,registerdate ,picture ,weight from member42";
	
	public List<MemberBean> select() {
		List<MemberBean> result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
			ResultSet rset = stmt.executeQuery();				
		) {
			result = new Vector<>();
			while (rset.next()) {
				MemberBean temp = new MemberBean();
				temp.setMemberId(rset.getString("memberid"));
				temp.setPassword(rset.getString("password"));
				temp.setName(rset.getString("name"));
				temp.setAddress(rset.getString("address"));
				temp.setPhone(rset.getString("phone"));
				temp.setBirthday(rset.getDate("birthday"));
				temp.setWeight(rset.getDouble("weight"));
				result.add(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	private static final String INSERT = "Insert into member42 (memberId, password, name, address, phone, birthday, registerdate, picture, weight) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public MemberBean insertMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(INSERT);
		) {
			stmt.setString(1, bean.getMemberId());
			stmt.setString(2, bean.getPassword());
			stmt.setString(3, bean.getName());
			stmt.setString(4, bean.getAddress());
			stmt.setString(5, bean.getPhone());

			java.util.Date temp = bean.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(6, someTime);
			} else {
				stmt.setDate(6, null);
			}

			Timestamp ts = new Timestamp(System.currentTimeMillis());
			stmt.setTimestamp(7, ts);
			Blob b = null;
			stmt.setBlob(8, b);
			stmt.setDouble(9, bean.getWeight());

			int i = stmt.executeUpdate();
			if (i == 1) {
				result = this.select(bean.getMemberId());
			}

		} 
		return result;
	}

	private static final String DELETE = "Delete from member42 where memberId=?";

	public int delete(String memberId) {
		int result = 0;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(DELETE);
		) {
			stmt.setString(1, memberId);
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}