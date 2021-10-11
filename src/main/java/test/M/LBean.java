package test.M;

public class LBean {
	private static final long serialVersionUID = 1L;
	
	private String memberId;   			
	private String password;
	
	public LBean() {
	}
	public LBean(String memberId,String password) {
		this.memberId=memberId;
		this.password=password;
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
