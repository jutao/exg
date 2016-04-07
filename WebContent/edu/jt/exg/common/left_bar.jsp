<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div id="left_bar">
	<div id="sidebar">
		<div id="secondary_nav">
			<ul id="sidenav" class="collapsible">
				<li><a><span class="nav_icon file_cabinet"></span> <s:text
							name="MenuBar.AgreementManage" /><span class="up_down_arrow">&nbsp;</span></a>
<ul class="acitem" style="display: none">
						<li><a href="Mgr_userAction.action?action=initquery"><s:text
									name="MenuBar.MgrusertList" /></a></li>
						<li><a href="UserAction.action?action=initquery"><s:text
									name="MenuBar.UsertList" /></a></li>
						<li><a href="Re_serveAction.action?action=initquery"><s:text
									name="MenuBar.Re_serveList" /></a></li>
						<li><a href="CategoryAction.action?action=initquery"><s:text
									name="MenuBar.CategoryList" /></a></li>
						<li><a href="Category_masterAction.action?action=initquery"><s:text
									name="MenuBar.CategorymasterList" /></a></li>
						<li><a href="Charge_detailAction.action?action=initquery"><s:text
									name="MenuBar.Charge_detailList" /></a></li>
						<li><a href="Consume_detailAction.action?action=initquery"><s:text
									name="MenuBar.Consume_detailList" /></a></li>
						<li><a href="Withdrawals_detailAction.action?action=initquery"><s:text
									name="MenuBar.Withdrawals_detailList" /></a></li>
						<li><a href="V_consume_detailAction.action?action=initquery"><s:text
									name="MenuBar.V_consume_detailList" /></a></li>
						<li><a href="V_order_masterAction.action?action=initquery"><s:text
									name="MenuBar.V_order_masterList" /></a></li>
						<li><a href="V_taskAction.action?action=initquery"><s:text
									name="MenuBar.V_taskList" /></a></li>
						<li><a href="V_order_taskAction.action?action=initquery"><s:text
									name="MenuBar.V_order_taskList" /></a></li>
						<li><a href="V_commentAction.action?action=initquery"><s:text
									name="MenuBar.V_commentList" /></a></li>
						<li><a href="V_charge_detailAction.action?action=initquery"><s:text
									name="MenuBar.V_charge_detailList" /></a></li>
					</ul></li>
				
			</ul>
		</div>
	</div>
</div>
<!-- 显示与隐藏左面板 -->
<script language="javascript">
	$(function() {
		var node=$("#sidenav li");
		
		var base='<%=basePath%>';
		var path=window.location;
		node.each(function(){
			var allHref=base+$(this).children("a").attr("href")
			if(allHref==path){
				$(this).parent().show();
				$(this).css("background-color","#1A84BC");
				   //E29510
			}
		}) 
		
		$('.acitem li').click(function(e) {
			window.location = $(this).children("a").attr("href");
			return false;
		})
		$("#sidenav").children("li").bind("click", function() {
			var node = $(this).children(".acitem");

			if (node.is(':hidden')) {
				node.show("li");
			} else {
				node.hide("li");
			}
		});
	})

	
</script>