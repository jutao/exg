<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE HTML>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="edu.jt.exg.logic.mgr_user.Mgr_userBean"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String userName = (String) (request.getSession()
			.getAttribute("userName"));
%>
<html>
<head>
<title><s:text name="Mgr_user.Title_query" /></title>
<meta http-equiv="Cache-Control" content="no-store">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Expires" content="0">
<!--     <LINK href="../theme/style.css" rel="stylesheet" type="text/css"> -->
<script type="text/javascript" src="<%=basePath%>edu/jt/exg/js/jsAddress.js"></script>
<link href="<%=basePath%>edu/jt/exg/css/reset.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/layout.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/themes.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/typography.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/styles.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/shCore.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/bootstrap.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/jquery.jqplot.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/jquery-ui-1.8.18.custom.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/data-table.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/form.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/ui-elements.css"
	rel="stylesheet" type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/wizard.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/sprite.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>edu/jt/exg/css/gradient.css" rel="stylesheet"
	type="text/css">
<!--[if IE 7]>
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg/css/ie/ie7.css" />
<![endif]-->
<!--[if IE 8]>
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg/css/ie/ie8.css" />
<![endif]-->
<!--[if IE 9]>
<link rel="stylesheet" type="text/css" href="<%=basePath%>edu/jt/exg/css/ie/ie9.css" />
<![endif]-->

<base href="<%=basePath%>">

<script src="<%=basePath%>edu/jt/exg/js/jquery-1.7.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery-ui-1.8.18.custom.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.ui.touch-punch.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/chosen.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/bootstrap-dropdown.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/bootstrap-colorpicker.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/sticky.full.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.noty.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/selectToUISlider.jQuery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/fg.menu.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.tagsinput.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.cleditor.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.tipsy.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.peity.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.simplemodal.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.jBreadCrumb.1.1.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.colorbox-min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.idTabs.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/jquery.multiFieldExtender.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.confirm.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/elfinder.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/autogrow.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/check-all.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/data-table.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/ZeroClipboard.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/TableTools.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jeditable.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/duallist.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/easing.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/full-calendar.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/input-limiter.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/inputmask.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/iphone-style-checkbox.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/meta-data.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/quicksand.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/raty.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/smart-wizard.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/stepy.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/treeview.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/ui-accordion.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/vaidation.jquery.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/mosaic.1.0.1.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.collapse.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.cookie.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.autocomplete.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/localdata.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/excanvas.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/jquery.jqplot.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.dateAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.cursor.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.logAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.canvasTextRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.highlighter.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.pieRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.barRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.pointLabels.min.js"></script>
<script
	src="<%=basePath%>edu/jt/exg/js/chart-plugins/jqplot.meterGaugeRenderer.min.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/custom-scripts.js"></script>
<!--必须先加载否则js中的jquery脚本会报错未定义-->
<%-- <script src="<%=basePath%>edu/jt/exg/js/jquery-1.11.1.js"></script> --%>
<%-- <script src="<%=basePath%>edu/jt/exg/js/public.js"></script> --%>
<script src="<%=basePath%>edu/jt/exg/js/mgr_user.js"></script>
<script src="<%=basePath%>edu/jt/exg/js/common.js"></script>

</head>
<body id="theme-default" class="full_block">
	<div id="actionsBox" class="actionsBox">
		<div id="actionsBoxMenu" class="menu">
			<span id="cntBoxMenu">0</span> <a id="delete"
				class="button box_action"><s:text name="Common.Delete_Selected" /></a>
		</div>
	</div>
	<s:include value="../common/header.jsp" />
	<s:include value="../common/left_bar.jsp" />
	<div id="container">
		<div style="overflow: hidden; background-color: #FFF;">
			<!--主键、附件、password不作为查询条件出列-->
			<s:form id="form1" name="form1"
				action="Mgr_userAction.action?action=query" namespace="/">

				<div class="page_title gray_sai"  >
					<div class="top_search" style="position:absolute;z-index:1000;">
						<ul id="search_box">
							<li style="margin-right: 5px;"><s:textfield id="userid"
									name="userid" cssClass="search_input" style="width:100px;"
									placeholder="请输入用户ID" /></li>
							<li style="margin-right: 5px;"><s:textfield id="name"
									name="name" cssClass="search_input1" style="width:100px;"
									placeholder="请输入用户名称" /></li>
									
							<li style="margin-right: 5px;">
								<div class="form_input">
									<s:hidden id="usertype" name="usertype"></s:hidden>
									<s:select id="usertypeSelect" name="usertypeSelect" list="usertypeMap"  data-placeholder="用户类型"
										style=" width:110px;" cssClass="chzn-select-deselect" />
								</div>
							</li> 
							<li style="margin-right: 5px;">
								<div class="form_input">
									<s:hidden id="invalid" name="invalid"></s:hidden>
									<s:select id="invalidSelect" name="invalidSelect" list="invalidMap"  data-placeholder="有效无效区分"
										style=" width:110px;" cssClass="chzn-select-deselect" />
								</div>
							</li>

							<li style="margin-right: 5px;">
								<button id="search" name="search" class="btn_small btn_blue">
									<s:text name="Common.Query"></s:text>
								</button>
							</li>
							<li style="margin-right: 15px;">
								<button id="reset" name="reset" class="btn_small btn_gray">
									<s:text name="Common.Reset"></s:text>
								</button>
							</li>
							<li style="margin-right: 5px;"><input id="create_parent"
								name="create_parent" type="button" class="btn_small btn_blue"
								value="创建">
							</li>
						</ul>
					</div>
				</div>


				<div id="content">
					<div class="grid_container">
						<div class="grid_12">
							<div class="widget_wrap tabby">
								<div class="widget_top">
									<span class="h_icon blocks_images"></span>
									<h6><s:text name="Mgruser_table"/></h6>
								</div>
								<div class="widget_content">
								<s:set id="showPage" name="showPage" value="ShowPage"/>
									<s:if test="mgr_userList.size()>=0">
										<table id="action_tbl" class="display">
											<thead>
												<tr>
													<th style="width:40px;"><input name="checkbox" type="checkbox"
														class="checkall"><br>
													<s:text name="Common.Select" /></th>
													<th style="display: none"><s:text name="Common.Serial_Number" /></th>
													<th><s:text name="Mgr_user.Userid" /></th>
													<th><s:text name="Mgr_user.Usertype" /></th>
													<th><s:text name="Mgr_user.Name" /></th>
													<th><s:text name="Mgr_user.Login_password" /></th>
													<th><s:text name="Mgr_user.Invalid" /></th>
													<th><s:text name="Common.Control" /></th>
												</tr>
											</thead>
											<tbody>
												<s:iterator value="mgr_userList" status="stuts" id="R">
													<tr class="t">
														<td class="center tr_select"><input id="mm" name="mm" type="checkbox"  value='<s:property value="#R.id"/>' >
															<s:hidden id="r_code" name="r_code" class="r_code">
																<s:param name="value"><s:property value="#R.code" /></s:param>
															</s:hidden>
														</td>
														<td align="center" style="display: none"><s:property value="#R.id" /></td>			
														<td align="center"><s:property value="#R.userid" /></td>
														<td align="center"><s:property value="#R.usertype" /></td>
														<td align="center"><a href="Mgr_userAction.action?action=detail&id=<s:property value="#R.id"/>" target="_self"><s:property value="#R.name" /></a></td>
														<td align="center"><s:property value="#R.Login_password" /></td>
														<td align="center"><s:property value="#R.invalid" /></td>
														<td align="center">
															<a href="Mgr_userAction.action?action=detail&id=<s:property value="#R.id"/>" target="_self"><img src='<%=basePath%>edu/jt/exg/images/detail.png' border='0' title=<s:text name="Common.Detail"/>></a>
						                                    <a href="Mgr_userAction.action?action=initupdate&id=<s:property value="#R.id"/>" target="_self"><img src='<%=basePath%>edu/jt/exg/images/update.png' border='0' title=<s:text name="Common.Modify"/>></a>
															<a href="Mgr_userAction.action?action=delete&id=<s:property value="#R.id"/>" target="_self"><img src ='<%=basePath%>edu/jt/exg/images/del.png' border='0' title=<s:text name="Common.Delete"/> onclick="return rusure('<s:text name="Common.Alert_Del"/>');"/></a>
														</td>
													</tr>
												</s:iterator>
											</tbody>
										</table>
									</s:if>
								</div>
							</div>
						</div>
					</div>
					<span class="clear"></span>
				</div>
			</s:form>
			<div id="fade" class="black_overlay" style="text-align: center;">
				<img src="<%=basePath%>/edu/jt/exg/images/loading51.gif" width="124"
					height="124" style="margin-top: 20%">
			</div>
			<%@ include file="../html/TableMovingChangeColor.html"%>
		</div>
	</div>
</body>
<script language='javascript'>
	$(function() {
   		
	    
		$("#form1").submit(function() {
			return checkFormForQuery();
		});

		$("#search").click(function() {
			ShowDiv('fade');
			finder();
		});

		$("#search").dblclick(function() {
			javascript: void (0);
		});

		$("#reset").click(function() {
			window.setTimeout(function() {
				window.location = '<%=basePath%>Mgr_userAction.action?action=initquery';
				return true;
			}, 0);
		});

		$("#create_parent").click(function() {
			window.setTimeout(function() {
				window.location = '<%=basePath%>Mgr_userAction.action?action=initcreate'; 
				return true;
			}, 0);
		});

	
		$("#delete").click(function() {
			getDeleteAllIds('<%=basePath%>Mgr_userAction.action?action=deleteSelected&ids=',
									'<s:text name="Common.Delete_All_Msg"/>');
						});

	});
	
</script>
</html>