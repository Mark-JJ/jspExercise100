package test.M;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import ch06_01.MemberBean;

public class LDAO {
DataSource ds = null;
	
	public LDAO() {
		try {
			Context context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MemberDB");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private static final String SELECTID = "Select memberId, password from LoginNmber where memberId = ?";

	public LBean select(String id) {
		LBean result = null;
		try(
			Connection conn = ds.getConnection();
			PreparedStatement stmt = conn.prepareStatement(SELECTID);
		) {
			stmt.setString(1, id);
			try (
				ResultSet rset = stmt.executeQuery();					
			){
				if (rset.next()) {
					result = new LBean();
					result.setMemberId(rset.getString("memberid"));
					result.setPassword(rset.getString("password"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
}
