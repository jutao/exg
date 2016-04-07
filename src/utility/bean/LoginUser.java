package utility.bean;

import java.sql.Timestamp;

import edu.jt.exg.logic.mgr_user.Mgr_userBean;


public class LoginUser extends Mgr_userBean{
	
	private Timestamp loginTime;

	public Timestamp getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}
	
}
