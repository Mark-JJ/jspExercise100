package ch06_02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.sql.DataSource;

import java.sql.Blob;

public class MemberDao {
	
	DataSource ds = null;
	Context context ;
	
	public MemberDao() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
			context = new InitialContext();
		} catch (NamingException e) {
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
					members.add(memberBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return members;
	}
	private static final String SELECT_BY_ID = "Select memberId, password, name, address, phone, birthday, registerdate, picture, weight from member42 where memberId = ?";

	public MemberBean select(String id) {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
		) {
			stmt.setString(1, id);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new MemberBean();
					result.setMemberId(rset.getString("memberid"));
					result.setPassword(rset.getString("password"));
					result.setName(rset.getString("name"));
					result.setAddress(rset.getString("address"));
					result.setPhone(rset.getString("phone"));
					result.setBirthday(rset.getDate("birthday"));
					result.setWeight(rset.getDouble("weight"));
					result.setPicture(rset.getString("picture"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
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
				temp.setPicture(rset.getString("picture"));
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
			stmt.setString(8, bean.getPicture());
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
	

	private static final String UPDATE = "Update member42 set Password=?,Name=?,Address=?,Phone=?,Birthday=?,Weight=?,Picture=? where memberId=?";


	public MemberBean updateMember(MemberBean bean) throws SQLException {
		MemberBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(UPDATE);
		) {
			
			stmt.setString(1, bean.getPassword());
			stmt.setString(2, bean.getName());
			stmt.setString(3, bean.getAddress());
			stmt.setString(4, bean.getPhone());
			

			java.util.Date temp = bean.getBirthday();
			if (temp != null) {
				java.sql.Date someTime = new java.sql.Date(temp.getTime());
				stmt.setDate(5, someTime);
			} else {
				stmt.setDate(5, null);
			}
			stmt.setDouble(6, bean.getWeight());
			stmt.setString(7, bean.getPicture());
			stmt.setString(8, bean.getMemberId());
			

			System.out.println("bean.getPicture()"+bean.getPicture()); 
			System.out.println(bean.getPassword()); 
			stmt.executeUpdate();


		} 
		return result;
	}
}