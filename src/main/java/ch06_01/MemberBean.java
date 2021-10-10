package ch06_01; 

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String memberId;   			// 帳號
	private String password;   			// 密碼

	
	public MemberBean() {
	} 
	
	public MemberBean(String memberId, String password) {
		super();
		this.memberId = memberId;
		this.password = password;
	}

	
	public String toString() {
		return "["+memberId+"]";
	}	

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}