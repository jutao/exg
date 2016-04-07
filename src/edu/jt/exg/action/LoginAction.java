package edu.jt.exg.action;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import utility.LoginUtil;
import utility.SingleServletModel;
import utility.Utilities;
import utility.bean.LoginUser;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport {
	
	private static final long serialVersionUID = 19761210;
	
	public HttpServletRequest request=null;
	public SingleServletModel singleServletModel=null;
	
	/**
	 * action跳转动作
	 */
	public String action=null;//action param
	public String getAction(){return action;}
	public void setAction(String action){this.action = action;}
	
	private String user;
	private String password;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 页面跳转
	 * @return 返回跳转页面指针
	 */
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		
		
		request=ServletActionContext.getRequest();
		singleServletModel=Utilities.csi.getSingleServletModel(request);
		//根据action参数跳转
		String forward="";
		if(action.equals("login") || action.equals("${action}")) forward=doInitLogin();
		else if(action.equals("logout")) forward=doLogout("logout");
		return forward;
	}
	
	/**
	 * @return 返回初始化查询页面
	 */
	private String doInitLogin(){return doCommonInitLogin("login");}

	/**
	 * 初始化查询通用方法
	 * @return
	 */
	private String doCommonInitLogin(String parm){

		//登录状态检查
		if (LoginUtil.isLogin(request)) {
			setAction("initquery");
			parm = "toindex";
		}
		
		return parm;
	}
	
	@SuppressWarnings("unchecked")
	private String doLogout(String parm){
		
		String userId=(String) request.getSession().getAttribute("userId");
		
		List<LoginUser> list=(List<LoginUser>) request.getServletContext().getAttribute("loginUserList");
		if (list!=null&&list.size()!=0) {
			for (int i = 0; i < list.size(); i++) {
				LoginUser loginUser=list.get(i);
				if (userId.equals(loginUser.getUserid())) {
					list.remove(i); //移除application在线状态
					break;
				}
			}
		}
		//移除session在线状态
		request.getSession().setAttribute("userId", null);
		request.getSession().setAttribute("userName", null);
		request.getSession().setAttribute("loginTime", null);	
		return parm;
	}
}