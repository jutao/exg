package filter;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utility.LoginUtil;

 
public class LoginFilter implements javax.servlet.Filter {  
  

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        // 获得在下面代码中要用的request,response,session对象
			HttpServletRequest servletRequest = (HttpServletRequest) request;
			HttpServletResponse servletResponse = (HttpServletResponse) response;
			HttpSession session = servletRequest.getSession();
			// 获得用户请求的URI
			String path = servletRequest.getRequestURI();
			String contextpath = servletRequest.getContextPath();

			// 登陆页面无需过滤
			if(	path.indexOf("/LoginAction.action") > -1) {
				chain.doFilter(servletRequest, servletResponse);
				return;
			}
			
			//登录状态检查
			if (LoginUtil.isLogin(servletRequest)) {
				// 已经登陆,继续此次请求
				chain.doFilter(request, response);
			} else {
				// 跳转到登陆页面
				servletResponse.sendRedirect(contextpath+"/login.jsp");
			}			
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}  
}  