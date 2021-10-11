package test.C;



import test.M.LBean;
import test.M.LDAO;

public class LService {
	public LBean checkIDPassword(String id, String password) {
				LDAO dao = new LDAO();
				LBean mb = dao.select(id);
		        if ( mb != null && mb.getPassword().equals(password) ) {
		        	 return mb;
		        }
				return null;
	}
	
	
}
