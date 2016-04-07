package utility;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import utility.bean.LoginUser;

/**
 * 判断登录状态
 * @author Tao Ju
 */
public class LoginUtil {
	
	@SuppressWarnings("unchecked")
	public static boolean isLogin(HttpServletRequest request){
		boolean isLogin=false;
		
		String userId=(String) request.getSession().getAttribute("userId");
		Timestamp loginTime=(Timestamp) request.getSession().getAttribute("loginTime");
		if (userId!=null&&userId!="") {
			List<LoginUser> loginUserList=(List<LoginUser>) request.getServletContext().getAttribute("loginUserList");
			if (loginUserList==null||loginUserList.size()==0) {
				isLogin=false;
			}else{
				for (int i = 0; i < loginUserList.size(); i++) {
					LoginUser loginUser=loginUserList.get(i);
					if (userId.equals(loginUser.getUserid())&&loginTime.equals(loginUser.getLoginTime())) {
						isLogin=true;
						break;
					}
				}
			}
		}else{
			isLogin=false;
		}
		
		return isLogin;
		
	}

}
