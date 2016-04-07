package ajax;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;

import transfer.LanguageTransfer;
import utility.Utilities;
import utility.bean.LoginUser;

import com.leap.training.logic.guide.GuideUtility;

import edu.jt.exg.logic.mgr_user.Mgr_userBatisDao;
import edu.jt.exg.logic.mgr_user.Mgr_userBean;
import edu.jt.exg.logic.mgr_user.Mgr_userUtility;

public class ValidateFoundation {

	public ValidateFoundation(){super();}
	
	public static String getutf(String word){
		try{
	            word = new String(word.getBytes("ISO-8859-1"), "utf-8");
	        }catch(UnsupportedEncodingException e){
	            e.printStackTrace();
	        }
	        return word;
	}
	
	private String getValue(String value,HttpServletRequest request,HttpServletResponse response){
		//如果是ie则转gbk,其他则转utf-8
		boolean style=request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 ? true : false;
		if(style==true) value=LanguageTransfer.getGBK(value);
		else value=getutf(value);
		return value;
	}
	
	/**
	 * 提供ajax后台返回值
	 * @param value
	 * @param index
	 * @return
	 */
	public String getReturnValue(String value,int index,HttpServletRequest request,HttpServletResponse response){
		String returnValue="";
		String[] array=null;
		HttpSession session=null;
		value=LanguageTransfer.getLanguageStr(value);
		//value=getValue(value,request);
		switch(index){
			
		}
		return returnValue;
	}
	
	/**
	 * 提供ajax后台验证数据唯一性使用
	 * @param value
	 * @param index
	 * @return
	 */
	public boolean validate(String value,int index,HttpServletRequest request,HttpServletResponse response){
		boolean isValid=false;
		value=LanguageTransfer.getLanguageStr(value);
		//value=getValue(value,request);
		switch(index){
			case 100: // 登陆验证
				isValid=loginValidate(request, value);
				break;
			case 1976://图片验证,请勿删除，通用方法
				isValid=GuideUtility.picValidate(value, request);
				break;
			default:
		}
		return isValid;
	}
	
	/**
	 * 登陆验证
	 * @param value 用户名:密码
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean loginValidate(HttpServletRequest request, String value){
		String[] str=value.split(":");
		String user= str[0];
		String pass=str[1];
		Mgr_userBatisDao mgr_userBatisDao = 
				Mgr_userUtility.getIocHandel().getBean("Mgr_userBatisDao", Mgr_userBatisDao.class);
		Mgr_userBean mgr_userBean = 
				Mgr_userUtility.getIocHandel().getBean("Mgr_userBean", Mgr_userBean.class);
		mgr_userBean.setUserid(user);
		mgr_userBean.setLogin_password(pass);
		if(mgr_userBatisDao.finderEqualCount(mgr_userBean)!=0){
			List<Mgr_userBean> list=mgr_userBatisDao.finderEqual(mgr_userBean);
			Mgr_userBean mgr_user=list.get(0);
			request.getSession().setAttribute("userId", mgr_user.getUserid());
			request.getSession().setAttribute("userName", mgr_user.getName());
			Timestamp loginTime=Utilities.csi.getCurrentTimestamp();
			request.getSession().setAttribute("loginTime", loginTime);
			List<LoginUser> userList = (List<LoginUser>) request.getServletContext().getAttribute("loginUserList");
			if (userList==null||userList.size()==0) {
				userList=new ArrayList<LoginUser>();
				request.getServletContext().setAttribute("loginUserList", userList);
			}
			boolean isExist=false;
			for (int i = 0; i < userList.size(); i++) {
				LoginUser loginUser = userList.get(i);
				if (loginUser.getUserid().equals(mgr_user.getUserid())) {
					BeanUtils.copyProperties(mgr_user, loginUser);
					loginUser.setLoginTime(loginTime);
					isExist=true;
					break;
				}
			}
			if (!isExist) {
				LoginUser loginUser=new LoginUser();
				BeanUtils.copyProperties(mgr_user, loginUser);
				loginUser.setLoginTime(loginTime);
				userList.add(loginUser);
			}
			return true;
		} else {
			return false;
		}
	}
	

}