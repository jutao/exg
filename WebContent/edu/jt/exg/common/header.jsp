<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userName=(String)(request.getSession().getAttribute("userName"));
%>

	<div id="header" class="black_gel">
			<div class="header_left" >
				<div class="logo">
					<img src="<%=basePath%>/edu/jt/exg//images/logo1.png" height="60">
				</div>
			</div>
			<div class="header_right">
				<div id="user_nav">
					<ul>
					<li class="user_thumb" ><a><span class="icon"><img src="<%=basePath%>/edu/jt/exg//images/user_thumb.png" width="30" height="30" alt="User"></span></a></li>
					<li class="user_info"><span class="user_name"><%=userName %></span></li>
						<li class="logout"><a id="logout"><span class="icon"></span>Logout</a></li>
					</ul>
				</div>
			</div>
		</div>